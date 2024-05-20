package org.school.kakao;

import org.school.kakao.config.AppConfig;

public class Main {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        AppController appController = appConfig.appController();
        appController.start();
    }
}