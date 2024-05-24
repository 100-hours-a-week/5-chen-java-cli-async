package org.school.kakao;

import org.school.kakao.food.FoodController;
import org.school.kakao.io.InputManager;
import org.school.kakao.io.OutputManager;
import org.school.kakao.movie.MovieController;

public class Cinema {
    private final FoodController foodController;
    private final MovieController movieController;

    public Cinema(FoodController foodController, MovieController movieController) {
        this.foodController = foodController;
        this.movieController = movieController;
    }

    public void start() {


        OutputManager.render();
        while (true) {
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
