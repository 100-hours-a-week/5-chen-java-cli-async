package org.school.kakao.discount;

import org.school.kakao.audience.Audience;

public class AudienceDiscountStrategy<T extends Audience> implements DiscountStrategy<T> {
    @Override
    public boolean canApply(T audience) {
        return false;
    }

    @Override
    public DiscountResult discount(T audience) {
        return null;
    }
}
