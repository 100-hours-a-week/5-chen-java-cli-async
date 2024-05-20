package org.school.kakao.discount;

import org.school.kakao.audience.Audience;

import java.util.List;

public class AudienceDiscountStrategy implements DiscountStrategy<Audience> {

    @Override
    public DiscountResult discount(Audience audience) {
        if (audience.size() > 2) {
            return new DiscountResult(List.of(new DiscountItem("단체 할인", 1000)));
        }
        return new DiscountResult();
    }
}
