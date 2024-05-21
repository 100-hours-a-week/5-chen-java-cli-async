package org.school.kakao.audience;

import org.school.kakao.AppContext;
import org.school.kakao.io.InputManager;
import org.school.kakao.io.OutputManager;

import java.util.ArrayList;
import java.util.List;

public class AudienceService {

    public void ask() {
        OutputManager.render();

        int personCount = InputManager.nextInt("몇 분이십니까?");
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < personCount; i++) {
            int age = InputManager.nextInt("나이를 입력해 주세요.");
            Person person = InputManager.nextLine(
                    "성별을 선택해 주세요. (M/F)",
                    genderString -> new Person(age, genderString)
            );

            people.add(person);
        }
        AppContext.getInstance().setAudience(new Audience(people));
    }
}
