package org.school.kakao.io;

import org.school.kakao.AppContext;
import org.school.kakao.food.Food;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class OutputManager {
    private OutputManager() {
    }

    public static void render() {
        clear();
        String header = """
                  ____ _                           \s
                 / ___(_)_ __   ___ _ __ ___   __ _\s
                | |   | | '_ \\ / _ \\ '_ ` _ \\ / _` |
                | |___| | | | |  __/ | | | | | (_| |
                 \\____|_|_| |_|\\___|_| |_| |_|\\__,_|
                """;
        System.out.println(header);

        AppContext context = AppContext.getInstance();
        if (context.getAudience() != null) {
            System.out.printf("%-8s : %d %n", "손님 수", context.getAudience().size());
        }

        if (context.getScreeningMovie() != null) {
            String movieTitle = context.getScreeningMovie().getTitle();
            LocalTime movieTime = context.getScreeningMovie().getTime();
            System.out.printf("%-8s : %s (%02d:%02d)%n", "영화", movieTitle, movieTime.getHour(), movieTime.getMinute());
        }

        if (context.getFoods() != null) {
            List<Food> foods = context.getFoods();
            if (foods.isEmpty()) {
                System.out.printf("%-8s : %s %n", "주문 음식", "없음");
            } else {
                String foodName = foods.stream().map(Food::getName).collect(Collectors.joining(","));
                Integer foodPrice = foods.stream().map(Food::getPrice).reduce(0, Integer::sum);
                System.out.printf("%-8s : %s %n", "주문 음식", foodName);
                System.out.printf("%-8s : %s %n", "음식 가격", foodPrice);
            }

        }

        System.out.println("============================================");
    }

    public static void println(String prompt) {
        System.out.println("# " + prompt);
    }
    
    public static void rawPrintf(String format, Object... args) {
        System.out.printf(format, args);
    }

    private static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
