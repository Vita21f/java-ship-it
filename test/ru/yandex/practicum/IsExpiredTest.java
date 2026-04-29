package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.PerishableParcel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsExpiredTest {

    @Test
    void shouldBeExpiredTrue(){
        PerishableParcel parcel = new PerishableParcel("торт", 100, "Москва", 2, 3);
        assertTrue(parcel.isExpired(7));
    }

    @Test
    void shouldBeExpiredFalse(){
        PerishableParcel parcel = new PerishableParcel("торт", 100, "Москва", 2, 3);
        assertFalse(parcel.isExpired(4));
    }

    @Test
    void shouldBeExpiredFalse1(){ //смотрим пограничное значение, когда сумма=currentDay
        PerishableParcel parcel = new PerishableParcel("торт", 100, "Москва", 2, 3);
        assertFalse(parcel.isExpired(5));
    }
}
