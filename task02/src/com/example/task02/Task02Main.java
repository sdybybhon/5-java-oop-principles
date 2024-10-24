package com.example.task02;

public class Task02Main {

    private static final Item ITEM1 = new Item("Товар 1", 10);
    private static final Item ITEM2 = new Item("Товар 2", 20);
    private static final Item ITEM3 = new Item("Товар 3", 30);
    private static final Item ITEM4 = new Item("Товар 4", 40);
    private static final Item ITEM5 = new Item("Товар 5", 50);
    private static final Item ITEM6 = new Item("Товар 6", 60);

    public static void main(String[] args) {
        // Создаем обычный счет
        Bill bill = new Bill();
        bill.add(ITEM1, 100);

        System.out.println("Счет без скидки:");
        System.out.println(bill);
        System.out.println("Итоговая цена: " + bill.getPrice());

        // Создаем счет со скидкой
        DiscountBill discountBill = new DiscountBill(80); // 10% скидка
        discountBill.add(ITEM1, 100);

        System.out.println("\nСчет со скидкой:");
        System.out.println(discountBill);
        System.out.println("Итоговая цена со скидкой: " + discountBill.getPrice());
        System.out.println("Размер скидки: " + discountBill.getAbsoluteDiscount());
    }
}
