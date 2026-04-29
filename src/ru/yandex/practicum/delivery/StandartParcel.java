package ru.yandex.practicum.delivery;

public class StandartParcel extends Parcel{
    private static final int BASE_PRICE = 2;

    public StandartParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public int getBasePrice(){
        return BASE_PRICE;
    }
}
