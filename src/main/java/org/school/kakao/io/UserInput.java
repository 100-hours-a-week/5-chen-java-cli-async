package org.school.kakao.io;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    private static Scanner instance = new Scanner(System.in);

    private UserInput() {
    }

    public static String nextLine() {
        return inputNextLine();
    }

    private static String inputNextLine() {
        return instance.nextLine();
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
            int i = instance.nextInt();
            discardEnter();
            return i;
        }

    }

    private static void discardEnter() {
        if (instance.hasNextLine()) {
            instance.nextLine();
        }
    }
}
