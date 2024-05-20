package org.school.kakao.discount;

import java.util.Collection;
import java.util.List;

public interface DiscountStrategy<T> {

    boolean canApply(T t);

    DiscountResult discount(T t);
}
