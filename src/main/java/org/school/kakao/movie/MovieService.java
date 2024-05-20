package org.school.kakao.movie;

import org.school.kakao.AppContext;
import org.school.kakao.io.InputManager;

import java.util.List;

public class MovieService {
    private List<ScreeningMovie> movies;

    public MovieService(List<ScreeningMovie> movies) {
        this.movies = movies;
    }

    public void ask() {
        System.out.println("상영중인 영화");
        for (int i = 1; i <= movies.size(); i++) {
            ScreeningMovie movie = movies.get(i - 1);
            System.out.println(i + " : " + movie.getTitle() + " at " + movie.getTime());
        }

        Integer order = InputManager.nextInt("어떤 영화?");
        ScreeningMovie chosenMovie = movies.get(order - 1);
        System.out.println("선택하신 영화 : " + chosenMovie.getTitle() + " at " + chosenMovie.getTime());

        AppContext.getInstance().setScreeningMovie(chosenMovie);
    }
}
