package org.school.kakao.discount;

public interface DiscountStrategy<T> {

    DiscountResult discount(T t);
}
