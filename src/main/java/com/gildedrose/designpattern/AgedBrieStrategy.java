package com.gildedrose.designpattern;
import com.gildedrose.Item;


public class AgedBrieStrategy extends ItemUpdateTemplate {
    @Override
    protected void updateQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    @Override
    protected void applyExpiredRules(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}
