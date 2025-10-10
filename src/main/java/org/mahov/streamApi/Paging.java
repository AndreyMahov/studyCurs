package org.mahov.streamApi;

import java.util.ArrayList;
import java.util.List;

/**
 * Есть микросервис A и микросервис авторизации B.
 * Чтобы вытащить аккаунты из сервиса B по REST используется класс DataService.
 * У него есть 3 метода:
 *  1. dataService.getCount() — возвращает кол-во аккаунтов (int)
 *  2. dataService.getPersons(int from, int to) — возвращает упорядоченные по индексу аккаунты (Person) из сервиса B от from до to.
 *  3. dataService.getAllPersons() — возвращает упорядоченные по индексу все аккаунты из сервиса.
 *
 * Известно, что некоторые аккаунты имеют дополнительную нагрузочную информацию (Person.description),
 * из-за чего ответ сервиса блокируется прокси-сервисом gateway по ограничению для тела ответа.
 *
 * Задача: реализовать метод getAllPersonsSafely(),
 * который будет забирать все аккаунты из сервиса B чтобы не упасть по ограничению gateway.
 */
public class Paging {
    public static void main(String[] args) {
        DataService dataService = new DataService();

        Paging paging = new Paging(dataService);
        List<Person> persons = paging.getAllPersonsSafely();

        System.out.println("Загружено аккаунтов: " + persons.size());
        persons.forEach(System.out::println);
    }

    private final DataService dataService;

    public Paging(DataService dataService) {
        this.dataService = dataService;
    }

    /**
     * TODO: реализовать этот метод
     */
    public List<Person> getAllPersonsSafely() {
        List<Person> result = new ArrayList<>();

        return result;
    }

    static class Person {
        int id;
        String name;
        String description;

        public Person(int id, String name, String description) {
            this.id = id;
            this.name = name;
            this.description = description;
        }

        @Override
        public String toString() {
            return "Person{id=" + id + ", name='" + name + '\'' +
                    (description != null ? ", description='" + description + '\'' : "") +
                    '}';
        }
    }

    static class DataService {
        private final List<Person> storage = new ArrayList<>();

        public DataService() {
            for (int i = 0; i < 37; i++) {
                // У некоторых пользователей есть "тяжёлое" поле description — имитация больших ответов
                String desc = (i % 7 == 0) ? "Очень длинное описание, вызывающее ограничение gateway..." : null;
                storage.add(new Person(i, "User_" + i, desc));
            }
        }

        public int getCount() {
            return storage.size();
        }

        public List<Person> getPersons(int from, int to) {
            int end = Math.min(to, storage.size());
            if (from < 0 || from >= end) return List.of();
            return new ArrayList<>(storage.subList(from, end));
        }

        public List<Person> getAllPersons() {
            // Имитируем падение из-за ограничения gateway
            throw new RuntimeException("Response body too large — blocked by gateway");
        }
    }
}



