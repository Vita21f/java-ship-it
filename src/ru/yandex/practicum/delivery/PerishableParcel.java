package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    protected int timeToLive;
    private static final int BASE_PRICE = 3;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public int getBasePrice(){
        return BASE_PRICE;
    }

    public boolean isExpired(int currentDay) {
        boolean isExpired = true;
        if ((this.sendDay+this.timeToLive) >= currentDay){
            isExpired = false;
        }
        return isExpired;
    }
}
