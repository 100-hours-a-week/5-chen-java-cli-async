package org.school.kakao.movie;

public abstract class Movie {
    private String title;
    private Genre genre;

    protected Movie(String title, Genre genre) {
        this.title = title;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }
}
