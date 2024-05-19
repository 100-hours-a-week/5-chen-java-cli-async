package org.school.kakao.movie;

public enum SeatGrade {
    SILVER(7000),
    GOLD(8000),
    PLATINUM(9000),
    DIAMOND(10000);


    private int price;

    SeatGrade(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
