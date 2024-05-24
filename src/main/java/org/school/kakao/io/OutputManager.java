package org.school.kakao.io;

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
