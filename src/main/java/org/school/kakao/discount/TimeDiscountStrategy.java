package org.school.kakao.discount;

import java.time.LocalTime;

public class TimeDiscountStrategy implements DiscountStrategy<LocalTime> {

    @Override
    public boolean canApply(LocalTime time) {
        return false;
    }

    @Override
    public DiscountResult discount(LocalTime time) {
        return null;
    }
}
