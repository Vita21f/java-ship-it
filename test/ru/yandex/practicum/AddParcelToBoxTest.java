package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.StandardParcel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddParcelToBoxTest {

    @Test
    void shouldAddParcelWhenWeightIsWithinLimit() {

        ParcelBox<StandardParcel> box = new ParcelBox<>(100);
        StandardParcel lightParcel1 = new StandardParcel("Лёгкая посылка", 50, "ул. Примерная, 1", 1);
        StandardParcel lightParcel2 = new StandardParcel("Лёгкая посылка", 30, "ул. Примерная, 1", 1);
        box.add(lightParcel1, 50);
        box.add(lightParcel2, 30);
        // Assert — проверяем результат
        assertEquals(2, box.parcelsOfBoxList.size());
        assertTrue(box.parcelsOfBoxList.contains(lightParcel1));
        assertTrue(box.parcelsOfBoxList.contains(lightParcel2));
    }

    @Test
    void shouldNotAddParcelWhenWeightExceedsLimit() {

        ParcelBox<StandardParcel> box = new ParcelBox<>(50);
        StandardParcel heavyParcel = new StandardParcel("Тяжёлая посылка", 100, "ул. Тяжёлая, 1", 1);


        box.add(heavyParcel, 100);


        assertEquals(0, box.parcelsOfBoxList.size());
    }

    @Test
    void shouldNotAddParcelWhenWeightExceedsLimit1() { //когда вес равен максимально допустимому

        ParcelBox<StandardParcel> box = new ParcelBox<>(50);
        StandardParcel heavyParcel = new StandardParcel("Тяжёлая посылка", 50, "ул. Тяжёлая, 1", 1);


        box.add(heavyParcel, 50);


        assertEquals(0, box.parcelsOfBoxList.size());
    }
}
