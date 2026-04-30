package ru.yandex.practicum.delivery;

public abstract class Parcel {
    protected String description;
    protected int weight;
    protected String deliveryAddress;
    protected int sendDay;

    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }
    public int getWeight() {
        return weight;
    }

    public void packageItem(){
        System.out.printf("Посылка <<%s>> упакована%n", this.description);
    }

    public void deliver(){
        System.out.printf("Посылка <<%s>> доставлена по адресу %s%n", this.description, this.deliveryAddress);
    }

    public int calculateDeliveryCost() {
        int price = this.weight*getBasePrice();
        return price;
    }

    public abstract int getBasePrice();
}
