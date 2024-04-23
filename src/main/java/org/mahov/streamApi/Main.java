package org.mahov.streamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.mahov.streamApi.BrokerFabric.createBrokerList;
import static org.mahov.streamApi.StockBlockFabric.getStockBlockList;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        List<Integer> integers = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        int[] array = new int[]{1,2,3};

        for (int i = 0; i < 10; i++) {
            Integer value = random.nextInt(0,100);
            integers.add(value);
            strings.add(value.toString());
        }

        // способы создания stream
        integers.stream().close();
        Stream<Integer> stream = integers.stream();

        Stream<Integer> streamOf = Stream.of(1,2,3);
        Stream.of(1,2,3).close();

        IntStream arrayStream = Arrays.stream(array);
        Arrays.stream(array).close();
        // и так далее...


        // ленивый стрим
        stream
        .map(item -> item - 5);

        integers.forEach(System.out::println);

        // нельзя использовать один стрим два раза
        stream.close();
        stream
                .map(item -> item + 5)
                .forEach(System.out::println);

        /* часто используемые функциональные интерфейсы
        * Predicate<T>
        * Consumer<T>
        * Function<T,R>
        * Supplier<T>
        * UnaryOperator<T>
        * BinaryOperator<T>
        * */

        /**
        * 1) Найти все пакеты акций за 2012 год и отсортировать их по сумме в порядке возрастания
          2) Вывести список не повторяющихся контор, в которых работаю брокеры
          3) Найти всех брокеров из конторы Golden soks
          4) вернуть строку со всеми имена брокеров + название контор через запятую
          5) выяснить существует ли брокер с именем Oly
          6) вывести сумму всех пакетов акций
          7) какова максимальная сумма пакетов акций брокеров
          8) найти пакет акций с минимальной суммой
        *
        * */

        List<Broker> brokerList = createBrokerList();
        List<StockBlock> stockBlockList = getStockBlockList();

    }

}
