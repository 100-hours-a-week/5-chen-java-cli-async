package org.school.kakao.pay;

public interface DiscountStrategy<T> {

    DiscountResult discount(T t);
}
