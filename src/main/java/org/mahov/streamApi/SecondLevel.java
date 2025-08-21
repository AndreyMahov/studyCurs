package org.mahov.streamApi;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static org.mahov.streamApi.LogisticsFabric.createShipmentList;

public class SecondLevel {
    public static void main(String[] args) {
        List<Shipment> shipmentList = createShipmentList();

        // 1) Найти все отправления за 2025 год и отсортировать их по суммарному весу посылок в порядке возрастания
//        shipmentList.stream()

        // 2) Вывести список неповторяющихся перевозчиков
//        shipmentList.stream()

        // 3) Найти все отправления в город назначения Berlin
//        shipmentList.stream()

        /**
         * 4) вернуть строку со всеми id отправлений + название перевозчика через запятую
         *    пример формата: "S-1001:DHL, S-1002:UPS, S-1003:FedEx, ..."
         *
         * 5) выяснить, существует ли отправление клиента C-777
         *    boolean exists = shipmentList.stream().anyMatch(s -> "C-777".equals(s.getClientId()));
         *
         * 6) вывести суммарный вес всех посылок по всем отправлениям
         *
         * 7) каков максимальный суммарный вес посылок среди всех отправлений
         *
         * 8) найти посылку с минимальным весом (вывести id посылки, вес и id отправления)
         */
    }
}

/* ======== Доменные типы (Lombok) ======== */

enum ShipmentStatus { CREATED, IN_TRANSIT, DELIVERED, CANCELLED, RETURNED }

enum EventType { CREATED, PICKED_UP, IN_TRANSIT, DELAY, OUT_FOR_DELIVERY, DELIVERED, CANCELLED }

@Value
@Builder(toBuilder = true)
class Parcel {
    String id;
    double weightKg;
    double declaredValue;
    boolean fragile;
    String category;
}

@Value
@Builder(toBuilder = true)
class TrackingEvent {
    LocalDateTime time;
    String location;
    EventType type;
    int delayMinutes;
}

@Value
@Builder(toBuilder = true)
class Shipment {
    String id;
    String clientId;
    String origin;
    String destination;
    String carrier;
    ShipmentStatus status;
    LocalDate createdDate;
    LocalDate plannedDeliveryDate;

    @Singular("parcel")
    List<Parcel> parcels;

    @Singular("event")
    List<TrackingEvent> tracking;
}

/* ======== Фабрика данных ======== */

class LogisticsFabric {
    public static List<Shipment> createShipmentList() {
        Shipment s1 = Shipment.builder()
                .id("S-1001").clientId("C-100").origin("Warsaw").destination("Berlin").carrier("DHL")
                .status(ShipmentStatus.IN_TRANSIT)
                .createdDate(LocalDate.of(2025, 8, 1))
                .plannedDeliveryDate(LocalDate.of(2025, 8, 25))
                .parcel(Parcel.builder().id("P-1").weightKg(3.2).declaredValue(200.0).fragile(false).category("electronics").build())
                .parcel(Parcel.builder().id("P-2").weightKg(1.1).declaredValue(80.0).fragile(true).category("glass").build())
                .event(TrackingEvent.builder().time(LocalDateTime.of(2025, 8, 1, 9, 0)).location("Warsaw").type(EventType.CREATED).delayMinutes(0).build())
                .event(TrackingEvent.builder().time(LocalDateTime.of(2025, 8, 2, 12, 30)).location("Warsaw").type(EventType.PICKED_UP).delayMinutes(0).build())
                .event(TrackingEvent.builder().time(LocalDateTime.of(2025, 8, 10, 17, 45)).location("Leipzig").type(EventType.IN_TRANSIT).delayMinutes(20).build())
                .build();

        Shipment s2 = Shipment.builder()
                .id("S-1002").clientId("C-200").origin("Prague").destination("Paris").carrier("UPS")
                .status(ShipmentStatus.DELIVERED)
                .createdDate(LocalDate.of(2024, 12, 15))
                .plannedDeliveryDate(LocalDate.of(2025, 1, 10))
                .parcel(Parcel.builder().id("P-3").weightKg(5.0).declaredValue(500.0).fragile(false).category("apparel").build())
                .parcel(Parcel.builder().id("P-4").weightKg(0.6).declaredValue(50.0).fragile(true).category("glass").build())
                .event(TrackingEvent.builder().time(LocalDateTime.of(2024, 12, 15, 10, 0)).location("Prague").type(EventType.CREATED).delayMinutes(0).build())
                .event(TrackingEvent.builder().time(LocalDateTime.of(2025, 1, 9, 9, 30)).location("Paris").type(EventType.OUT_FOR_DELIVERY).delayMinutes(0).build())
                .event(TrackingEvent.builder().time(LocalDateTime.of(2025, 1, 9, 15, 10)).location("Paris").type(EventType.DELIVERED).delayMinutes(0).build())
                .build();

        Shipment s3 = Shipment.builder()
                .id("S-1003").clientId("C-777").origin("Vienna").destination("Berlin").carrier("FedEx")
                .status(ShipmentStatus.IN_TRANSIT)
                .createdDate(LocalDate.of(2025, 7, 20))
                .plannedDeliveryDate(LocalDate.of(2025, 8, 28))
                .parcel(Parcel.builder().id("P-5").weightKg(2.5).declaredValue(120.0).fragile(false).category("books").build())
                .parcel(Parcel.builder().id("P-6").weightKg(7.3).declaredValue(700.0).fragile(true).category("electronics").build())
                .event(TrackingEvent.builder().time(LocalDateTime.of(2025, 7, 20, 11, 0)).location("Vienna").type(EventType.CREATED).delayMinutes(0).build())
                .event(TrackingEvent.builder().time(LocalDateTime.of(2025, 7, 22, 14, 20)).location("Brno").type(EventType.IN_TRANSIT).delayMinutes(0).build())
                .build();

        Shipment s4 = Shipment.builder()
                .id("S-1004").clientId("C-300").origin("Madrid").destination("Rome").carrier("DHL")
                .status(ShipmentStatus.CANCELLED)
                .createdDate(LocalDate.of(2025, 6, 5))
                .plannedDeliveryDate(LocalDate.of(2025, 6, 20))
                .parcel(Parcel.builder().id("P-7").weightKg(10.0).declaredValue(1000.0).fragile(false).category("furniture").build())
                .event(TrackingEvent.builder().time(LocalDateTime.of(2025, 6, 5, 8, 15)).location("Madrid").type(EventType.CREATED).delayMinutes(0).build())
                .event(TrackingEvent.builder().time(LocalDateTime.of(2025, 6, 6, 9, 0)).location("Madrid").type(EventType.CANCELLED).delayMinutes(0).build())
                .build();

        return new ArrayList<>(List.of(s1, s2, s3, s4));
    }
}
