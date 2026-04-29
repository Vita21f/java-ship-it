package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.StandartParcel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddParcelToBoxTest {

    @Test
    void shouldAddParcelWhenWeightIsWithinLimit() {

        ParcelBox<StandartParcel> box = new ParcelBox<>(100);
        StandartParcel lightParcel = new StandartParcel("Лёгкая посылка", 50, "ул. Примерная, 1", 1);

        box.add(lightParcel, 50);

        // Assert — проверяем результат
        assertEquals(1, box.parcelsOfBoxList.size());
        assertTrue(box.parcelsOfBoxList.contains(lightParcel));
    }

    @Test
    void shouldNotAddParcelWhenWeightExceedsLimit() {

        ParcelBox<StandartParcel> box = new ParcelBox<>(50);
        StandartParcel heavyParcel = new StandartParcel("Тяжёлая посылка", 100, "ул. Тяжёлая, 1", 1);


        box.add(heavyParcel, 100);


        assertEquals(0, box.parcelsOfBoxList.size());
    }

    @Test
    void shouldNotAddParcelWhenWeightExceedsLimit1() { //когда вес равен максимально допустимому

        ParcelBox<StandartParcel> box = new ParcelBox<>(50);
        StandartParcel heavyParcel = new StandartParcel("Тяжёлая посылка", 50, "ул. Тяжёлая, 1", 1);


        box.add(heavyParcel, 50);


        assertEquals(0, box.parcelsOfBoxList.size());
    }
}
