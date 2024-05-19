package org.school.kakao.audience;

public class Person {
    private int age;
    private Gender gender;

    public Person(int age, String gender) {
        this.age = age;
        this.gender = Gender.of(gender);
    }

    public boolean isAdult() {
        return age >= 19;
    }

    public Gender getGender() {
        return gender;
    }
}
