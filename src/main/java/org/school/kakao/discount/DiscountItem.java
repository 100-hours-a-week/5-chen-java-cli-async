package org.school.kakao.discount;

public class DiscountItem {
    private String name;
    private int amount;

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public DiscountItem(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }
}
