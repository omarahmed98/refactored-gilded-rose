package com.gildedrose.designpattern;
import com.gildedrose.Item;

import java.util.HashMap;
import java.util.Map;

public class ItemFactory {
    private static final Map<String, ItemUpdateTemplate> updaterMap = new HashMap<>();
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    static {
        updaterMap.put(AGED_BRIE, new AgedBrieStrategy());
        updaterMap.put(BACKSTAGE_PASSES, new BackstagePassesStrategy());
        updaterMap.put(SULFURAS, new SulfurasStrategy());
    }

    public static ItemUpdateTemplate createUpdater(Item item) {
        return updaterMap.getOrDefault(item.name, new NormalItemStrategy());
    }
}