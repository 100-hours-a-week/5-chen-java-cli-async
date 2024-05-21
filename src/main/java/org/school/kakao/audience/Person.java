package org.school.kakao.audience;

public class Person {
    private int age;
    private Gender gender;

    public Person(int age, String gender) throws IllegalArgumentException {
        this.age = age;
        gender = gender.toUpperCase();
        this.gender = switch (gender) {
            case "M" -> Gender.MALE;
            case "F" -> Gender.FEMALE;
            default -> throw new IllegalArgumentException("잘못 입력하셨습니다. M,F 만 입력해주세요.");
        };
    }

    public boolean isAdult() {
        return age >= 19;
    }

    public Gender getGender() {
        return gender;
    }
}
