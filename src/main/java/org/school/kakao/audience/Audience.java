package org.school.kakao.audience;

import java.util.List;

public class Audience {
    private List<Person> people;

    public Audience(List<Person> people) {
        this.people = people;
    }

    public int size() {
        return people.size();
    }
}
