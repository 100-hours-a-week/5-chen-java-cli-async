package org.school.kakao.audience;

import org.school.kakao.AppContext;
import org.school.kakao.io.InputManager;

import java.util.ArrayList;
import java.util.List;

public class AudienceService {

    public void ask() {
        int personCount = InputManager.nextInt("몇 명?");
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < personCount; i++) {
            Integer age = InputManager.nextInt("나이?");
            String gender = InputManager.nextLine("성별? (M/F)");

            people.add(new Person(age, gender));
        }
        AppContext.getInstance().setAudience(new Audience(people));
    }
}
