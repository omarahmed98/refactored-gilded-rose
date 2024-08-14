package com.gildedrose;

class GildedRose {
    Item[] items;
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals(AGED_BRIE)) {
                updateAgedBrie(item);
            } else if (item.name.equals(BACKSTAGE_PASSES)) {
                updateBackstagePasses(item);
            } else if (!item.name.equals(SULFURAS)) {
                updateNormalItem(item);
            }
        }
    }

    private void updateAgedBrie(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality++;
        }
        item.sellIn--;
        if (item.sellIn < 0 && item.quality < MAX_QUALITY) {
            item.quality++;
        }
    }

    private void updateBackstagePasses(Item item) {
        if (item.quality < MAX_QUALITY) {
            if (item.sellIn < 6) {
                item.quality += 3;
            } else if (item.sellIn < 11) {
                item.quality += 2;
            } else {
                item.quality++;
            }
        }
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = MIN_QUALITY;
        }
    }

    private void updateNormalItem(Item item) {
        if (item.quality > MIN_QUALITY) {
            item.quality--;
        }
        item.sellIn--;
        if (item.sellIn < 0 && item.quality > MIN_QUALITY) {
            item.quality--;
        }
    }
}

