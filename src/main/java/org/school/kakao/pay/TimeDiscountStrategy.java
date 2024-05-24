package org.school.kakao.pay;

import java.time.LocalTime;
import java.util.List;

public class TimeDiscountStrategy implements DiscountStrategy<LocalTime> {

    @Override
    public DiscountResult discount(LocalTime time) {
        if (time.isAfter(LocalTime.of(18, 0))) {
            return new DiscountResult(List.of(new DiscountItem("오후 할인", 1000)));
        }
        return new DiscountResult();
    }
}
