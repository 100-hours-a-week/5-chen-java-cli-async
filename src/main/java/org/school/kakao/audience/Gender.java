package org.school.kakao.audience;

public enum Gender {
    MALE, FEMALE, UNKNOWN;

    public static Gender of(String str) {
        return switch (str) {
            case "M" -> Gender.MALE;
            case "F" -> Gender.FEMALE;
            default -> Gender.UNKNOWN;
        };
    }
}
