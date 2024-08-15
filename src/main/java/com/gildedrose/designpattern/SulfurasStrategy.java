package com.gildedrose.designpattern;


import com.gildedrose.Item;


public class SulfurasStrategy extends ItemUpdateTemplate {
    @Override
    protected void updateQuality(Item item) {
        // Continue
    }

    @Override
    protected void updateSellIn(Item item) {
        // Continue
    }

    @Override
    protected void applyExpiredRules(Item item) {
        // Continue
    }
}