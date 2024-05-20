package org.school.kakao.discount;

import java.util.List;
import java.util.stream.IntStream;

public class DiscountResult {
    private List<DiscountItem> discountItems;

    public DiscountResult(List<DiscountItem> discountItems) {
        this.discountItems = discountItems;
    }

    public int getTotal() {
        return discountItems.stream().map(DiscountItem::getAmount).reduce(0, Integer::sum);
    }
}
