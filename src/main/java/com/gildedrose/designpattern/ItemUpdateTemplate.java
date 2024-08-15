package com.gildedrose.designpattern;


import com.gildedrose.Item;


public abstract class ItemUpdateTemplate implements ItemStrategy {
    @Override
    public final void update(Item item) {
        updateQuality(item);
        updateSellIn(item);
        handleExpired(item);
    }

    protected abstract void updateQuality(Item item);

    protected void updateSellIn(Item item) {
        item.sellIn--;
    }

    protected void handleExpired(Item item) {
        if (item.sellIn < 0) {
            applyExpiredRules(item);
        }
    }

    protected abstract void applyExpiredRules(Item item);
}