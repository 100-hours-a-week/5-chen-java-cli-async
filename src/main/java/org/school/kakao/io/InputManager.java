package org.school.kakao.io;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.IntFunction;

public class InputManager {
    private static Scanner instance = new Scanner(System.in);

    private InputManager() {
    }

    private static void printPrompt(String prompt) {
        System.out.println("# " + prompt);
    }

    private static String inputNextLine() {
        if (instance.hasNextLine()) {
            return instance.nextLine();
        }
        return "";
    }

    private static int inputNextInt() {
        int i = instance.nextInt();
        discard();
        return i;
    }

    private static void discard() {
        if (instance.hasNextLine()) {
            instance.nextLine();
        }
    }

    public static String nextLine(String prompt) {
        printPrompt(prompt);
        return inputNextLine();
    }

    public static int nextInt(String prompt) {
        printPrompt(prompt);
        try {
            return inputNextInt();
        } catch (InputMismatchException e) {
            discard();
            printPrompt("잘못 입력하셨습니다.");
            return nextInt(prompt);
        }
    }


    public static <R> R nextLine(String prompt, Function<String, R> function) {
        try {
            return function.apply(nextLine(prompt));
        } catch (IllegalArgumentException exception) {
            return nextLine(exception.getMessage(), function);
        }
    }

    public static <R> R nextInt(String prompt, IntFunction<R> function) {
        try {
            return function.apply(nextInt(prompt));
        } catch (IndexOutOfBoundsException e) {
            return nextInt("잘못된 숫자입니다. 다시 입력해 주세요.", function);
        }
    }
}
