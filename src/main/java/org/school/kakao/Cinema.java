package org.school.kakao;

import org.school.kakao.food.FoodController;
import org.school.kakao.io.InputManager;
import org.school.kakao.io.OutputManager;
import org.school.kakao.movie.MovieController;

public class Cinema {

    private FoodController foodController;
    private MovieController movieController;

    public Cinema(FoodController foodController, MovieController movieController) {
        this.foodController = foodController;
        this.movieController = movieController;
    }

    public void start() {
        OutputManager.render();
        while (true) {
            AppContext.newInstance();
            int op = InputManager.nextInt("선택 (Movie, Food, END)");

            switch (op) {
                case 1 -> movieController.start();
                case 2 -> foodController.start();
                case 3 -> {
                    return;
                }
                default -> OutputManager.println("다시 입력해주세요.");
            }
        }
    }
}
