package org.school.kakao.movie;

import org.school.kakao.AppContext;
import org.school.kakao.io.InputManager;
import org.school.kakao.io.OutputManager;

import java.util.List;

public class MovieService {
    private List<ScreeningMovie> movies;

    public MovieService(List<ScreeningMovie> movies) {
        this.movies = movies;
    }

    public void ask() {
        OutputManager.render();
        OutputManager.println("현재 상영중인 영화");
        for (int i = 1; i <= movies.size(); i++) {
            ScreeningMovie movie = movies.get(i - 1);
            OutputManager.println(i + " : " + movie.getTitle() + " at " + movie.getTime());
        }

        ScreeningMovie chosenMovie = InputManager.nextInt("영화를 선택해 주세요.", num -> movies.get(num - 1));
        AppContext.getInstance().setScreeningMovie(chosenMovie);
    }
}
