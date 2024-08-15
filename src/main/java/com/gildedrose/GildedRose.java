package com.gildedrose;

import com.gildedrose.designpattern.ItemFactory;
import com.gildedrose.designpattern.ItemUpdateTemplate;


class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdateTemplate updater = ItemFactory.createUpdater(item);
            updater.update(item);
        }
    }
}

