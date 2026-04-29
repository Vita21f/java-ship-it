package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static ArrayList<FragileParcel> fragileParcels = new ArrayList<>();

    private static ParcelBox<StandartParcel> standartBox = new ParcelBox<>(500);
    private static ParcelBox<FragileParcel> fragileBox = new ParcelBox<>(300);
    private static ParcelBox<PerishableParcel> perishableBox = new ParcelBox<>(700);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    doReportStatus();
                    break;
                case 5:
                    printParcelsOfBox();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Трекинг отправления");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    private static void addParcel() {
        showMenuOfType();
        int type = Integer.parseInt(scanner.nextLine());

        System.out.println("Добавьте описание посылки:");
        String description = scanner.nextLine();
        System.out.println("Добавьте вес посылки:");
        int weight = Integer.parseInt(scanner.nextLine());
        System.out.println("Добавьте адрес доставки:");
        String deliveryAddress = scanner.nextLine();
        System.out.println("Добавьте день отправки посылки:");
        int sendDay = Integer.parseInt(scanner.nextLine());

        switch (type) {
            case 1:
                StandartParcel standartParcel = new StandartParcel(description, weight, deliveryAddress, sendDay);
                allParcels.add(standartParcel);
                standartBox.add(standartParcel, weight);
                break;
            case 2:
                FragileParcel fragileParcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
                allParcels.add(fragileParcel);
                fragileParcels.add(fragileParcel);
                fragileBox.add(fragileParcel, weight);
                break;
            case 3:
                System.out.println("Добавьте срок в днях, за который посылка не испортится:");
                int timeToLive = Integer.parseInt(scanner.nextLine());
                PerishableParcel perishableParcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
                allParcels.add(perishableParcel);
                perishableBox.add(perishableParcel, weight);
                break;
            default:
                System.out.println("Неверный выбор.");
                break;
        }

    }

    private static void sendParcels() {
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        int totalPrice = 0;
        for (Parcel parcel : allParcels) {
            int price = parcel.calculateDeliveryCost();
            totalPrice += price;
        }
        System.out.printf("Общая стоимость всех посылок: %d%n", totalPrice);
    }

    private static void showMenuOfType() {
        System.out.println("Какой тип посылки Вам нужен?");
        System.out.println("1 — Стандартная посылка");
        System.out.println("2 — Хрупкая посылка");
        System.out.println("3 — Скоропортящаяся посылка");
    }

    private static void doReportStatus() {
        for (FragileParcel parcel : fragileParcels) {
            System.out.println("Укажите местоположение текущей посылки:");
            String newLocation = scanner.nextLine();
            parcel.reportStatus(newLocation);
        }
    }

    private static void printParcelsOfBox() {
        System.out.println("Список посылок какой коробки предоставить?");
        System.out.println("1 — Стандартной коробки");
        System.out.println("2 — Хрупкой коробки");
        System.out.println("3 — Скоропортящейся коробки");
        int command = Integer.parseInt(scanner.nextLine());
        if (command == 1) {
            standartBox.getAllParcels();
        } else if (command == 2) {
            fragileBox.getAllParcels();
        } else if (command == 3) {
            perishableBox.getAllParcels();
        } else {
            System.out.println("Такой коробки нет.");
        }
    }
}

