package com.gildedrose.designpattern;


import com.gildedrose.Item;


public class BackstagePassesStrategy extends ItemUpdateTemplate {
    @Override
    protected void updateQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
            if (item.sellIn < 11 && item.quality < 50) {
                item.quality++;
            }
            if (item.sellIn < 6 && item.quality < 50) {
                item.quality++;
            }
        }
    }

    @Override
    protected void applyExpiredRules(Item item) {
        item.quality = 0;
    }
}
