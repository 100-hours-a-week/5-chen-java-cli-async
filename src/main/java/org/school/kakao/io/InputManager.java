package org.school.kakao.io;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputManager {
    private static Scanner instance = new Scanner(System.in);

    private InputManager() {
    }

    public static String nextLine() {
        return inputNextLine();
    }

    private static String inputNextLine() {
        if (instance.hasNextLine()) {
            return instance.nextLine();
        }
        return "";
    }

    public static String nextLine(String prompt) {
        System.out.println(prompt);
        return inputNextLine();
    }

    public static Integer nextInt(String prompt) {
        System.out.println(prompt);
        try {
            int i = instance.nextInt();
            discardEnter();
            return i;
        } catch (InputMismatchException e) {
            discardEnter();
            System.out.println("잘못 입력하셨습니다.");
            return nextInt(prompt);
        }

    }

    private static void discardEnter() {
        if (instance.hasNextLine()) {
            instance.nextLine();
        }
    }
}
