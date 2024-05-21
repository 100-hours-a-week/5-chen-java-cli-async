package org.school.kakao.movie;

public class Seat {
    private final SeatGrade grade;
    private boolean occupied = false;

    public Seat(SeatGrade grade) {
        this.grade = grade;
    }

    public int getPrice() {
        return grade.getPrice();
    }

    public boolean isOccupied() {
        return occupied;
    }

    public SeatGrade book() {
        this.occupied = true;
        return this.grade;
    }
}
