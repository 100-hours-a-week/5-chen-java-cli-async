package org.school.kakao;

import org.school.kakao.config.AppConfig;

public class Main {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        ThreadApp threadApp = new ThreadApp(appConfig);

        Cinema cinema = appConfig.cinema();
        threadApp.start(false);
        cinema.start();
        threadApp.end();
    }
}