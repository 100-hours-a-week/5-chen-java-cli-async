package org.school.kakao;

import org.school.kakao.audience.Audience;
import org.school.kakao.discount.DiscountResult;
import org.school.kakao.food.Food;
import org.school.kakao.movie.ScreeningMovie;
import org.school.kakao.movie.SeatGrade;

import java.util.List;

public class AppContext {
    private Audience audience;
    private ScreeningMovie screeningMovie;
    private List<SeatGrade> seatGrades;
    private List<Food> foods;
    private DiscountResult discountResult;

    private static AppContext instance;

    private AppContext() {
    }

    public static AppContext getInstance() {
        if (instance == null) {
            instance = new AppContext();
        }
        return instance;
    }

    public static void newInstance() {
        instance = new AppContext();
    }

    public Audience getAudience() {
        return audience;
    }

    public void setAudience(Audience audience) {
        this.audience = audience;
    }

    public ScreeningMovie getScreeningMovie() {
        return screeningMovie;
    }

    public void setScreeningMovie(ScreeningMovie screeningMovie) {
        this.screeningMovie = screeningMovie;
    }

    public List<SeatGrade> getSeatGrades() {
        return seatGrades;
    }

    public void setSeatGrades(List<SeatGrade> seatGrades) {
        this.seatGrades = seatGrades;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public DiscountResult getDiscountResult() {
        return discountResult;
    }

    public void setDiscountResult(DiscountResult discountResult) {
        this.discountResult = discountResult;
    }
}
