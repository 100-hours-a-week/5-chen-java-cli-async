package org.school.kakao.audience;

import org.school.kakao.food.Food;
import org.school.kakao.movie.ScreeningMovie;
import org.school.kakao.movie.SeatGrade;

import java.util.List;

public class Audience {
    private List<Person> people;
    private ScreeningMovie movie;
    private List<Food> foods;
    private List<SeatGrade> seatGrades;

    public Audience(List<Person> people) {
        this.people = people;
    }

    public void setMovie(ScreeningMovie movie) {
        this.movie = movie;
    }

    public List<Food> getFoodList() {
        return foods;
    }

    public void setFoods(List<Food> chosenFoods) {
        this.foods = chosenFoods;
    }

    public void setSeatGrades(List<SeatGrade> seatGrades) {
        this.seatGrades = seatGrades;
    }
}
