package org.school.kakao;

import org.school.kakao.config.AppConfig;

public class Main {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        Cinema cinema = appConfig.cinema();
        ThreadUser threadUser = appConfig.threadUser();

        threadUser.start();
        cinema.start();
        threadUser.end();
    }
}