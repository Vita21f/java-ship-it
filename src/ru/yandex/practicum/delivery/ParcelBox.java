package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {
    private final int maxWeight;
    public ArrayList<T> parcelsOfBoxList = new ArrayList<>();

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void add(T parcel, int weight) {
        int currentWeight = getCurrentWeight();
        if ((currentWeight+weight) < maxWeight) {
            parcelsOfBoxList.add(parcel);
        } else {
            System.out.println("Вес превышен. Посылка не добавлена в коробку.");
        }
    }
    private int getCurrentWeight() {
        int totalWeight = 0;
        for (T parcel : parcelsOfBoxList) {
            totalWeight += parcel.getWeight();
        }
        return totalWeight;
    }

    public void getAllParcels() {
        if (parcelsOfBoxList.isEmpty()) {
            System.out.println("Коробка пуста.");
        } else {
            for (T parcel : parcelsOfBoxList) {
                System.out.println("Посылка: " + parcel.description);
            }
        }
    }
}
