package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandartParcel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliveryCostTest {

    @Test
    void testStandartParcelCost() {
        StandartParcel parcel = new StandartParcel("Книга", 100, "ул. Пушкина, 10", 1);
        int expectedCost = 200;
        assertEquals(expectedCost, parcel.calculateDeliveryCost());
    }

    @Test
    void testFragileParcelCost() {
        FragileParcel parcel = new FragileParcel("Ваза", 50, "ул. Пушкина, 10", 1);
        int expectedCost = 200;
        assertEquals(expectedCost, parcel.calculateDeliveryCost());
    }

    @Test
    void testPerishableParcelCost() {
        PerishableParcel parcel = new PerishableParcel("Торт", 400, "ул. Пушкина, 10", 1, 3);
        int expectedCost = 1200;
        assertEquals(expectedCost, parcel.calculateDeliveryCost());
    }

}
