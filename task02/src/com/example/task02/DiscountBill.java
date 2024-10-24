package com.example.task02;

public class DiscountBill extends Bill {
    private final int discount; // Скидка в процентах

    public DiscountBill(int discount) {
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public long getAbsoluteDiscount() {
        return (long) (super.getPrice() * (discount / 100.0));
    }

    @Override
    public long getPrice() {
        return (long) (super.getPrice() - getAbsoluteDiscount());
    }
}
