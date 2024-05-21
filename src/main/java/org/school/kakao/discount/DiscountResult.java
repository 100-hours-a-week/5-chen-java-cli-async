package org.school.kakao.discount;

import java.util.LinkedList;
import java.util.List;

public class DiscountResult {
    private List<DiscountItem> discountItems;

    public DiscountResult() {
        discountItems = new LinkedList<>();
    }

    public DiscountResult(List<DiscountItem> discountItems) {
        this.discountItems = discountItems;
    }

    public int getTotal() {
        return discountItems.stream()
                .map(DiscountItem::getAmount)
                .reduce(0, Integer::sum);
    }

    public void addAll(DiscountResult other) {
        this.discountItems.addAll(other.getDiscountItems());
    }

    public List<DiscountItem> getDiscountItems() {
        return discountItems;
    }
}
