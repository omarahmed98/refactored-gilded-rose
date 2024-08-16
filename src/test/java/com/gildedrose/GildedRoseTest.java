package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    private static final String NORMAL_ITEM = "Normal Item";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured Mana Cake";

    @Test
    void testNormalItemBeforeSellDate() {
        Item[] items = new Item[] { new Item(NORMAL_ITEM, 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, items[0].sellIn);
        assertEquals(19, items[0].quality);
    }

    @Test
    void testNormalItemOnSellDate() {
        Item[] items = new Item[] { new Item(NORMAL_ITEM, 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, items[0].sellIn);
        assertEquals(18, items[0].quality);
    }

    @Test
    void testNormalItemAfterSellDate() {
        Item[] items = new Item[] { new Item(NORMAL_ITEM, -1, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-2, items[0].sellIn);
        assertEquals(18, items[0].quality);
    }

    @Test
    void testNormalItemWithZeroQuality() {
        Item[] items = new Item[] { new Item(NORMAL_ITEM, 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void testNormalItemWithQualityAtMax() {
        Item[] items = new Item[] { new Item(NORMAL_ITEM, 10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, items[0].sellIn);
        assertEquals(49, items[0].quality); 
    }

    @Test
    void testNormalItemQualityDecreasesTwiceAsFastAfterSellDate() {
        Item[] items = new Item[] { new Item(NORMAL_ITEM, -1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-2, items[0].sellIn);
        assertEquals(3, items[0].quality); 
    }

    @Test
    void testNormalItemQualityZeroAfterSellDate() {
        Item[] items = new Item[] { new Item(NORMAL_ITEM, -1, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-2, items[0].sellIn);
        assertEquals(0, items[0].quality); 
    }


    @Test
    void testAgedBrieBeforeSellDate() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, items[0].sellIn);
        assertEquals(11, items[0].quality);
    }

    @Test
    void testAgedBrieOnSellDate() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, items[0].sellIn);
        assertEquals(12, items[0].quality);
    }

    @Test
    void testAgedBrieAfterSellDate() {
        Item[] items = new Item[] { new Item(AGED_BRIE, -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-2, items[0].sellIn);
        assertEquals(12, items[0].quality);
    }

    @Test
    void testAgedBrieWithMaxQuality() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    void testAgedBrieWithMaxQualityAfterSellDate() {
        Item[] items = new Item[] { new Item(AGED_BRIE, -1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-2, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    void testSulfurasBeforeSellDate() {
        Item[] items = new Item[] { new Item(SULFURAS, 10, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, items[0].sellIn);
        assertEquals(80, items[0].quality);
    }

    @Test
    void testSulfurasOnSellDate() {
        Item[] items = new Item[] { new Item(SULFURAS, 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].sellIn);
        assertEquals(80, items[0].quality);
    }

    @Test
    void testSulfurasAfterSellDate() {
        Item[] items = new Item[] { new Item(SULFURAS, -1, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, items[0].sellIn);
        assertEquals(80, items[0].quality);
    }

    @Test
    void testBackstagePassesLongBeforeSellDate() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 11, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, items[0].sellIn);
        assertEquals(21, items[0].quality);
    }

    @Test
    void testBackstagePassesCloseToSellDate() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, items[0].sellIn);
        assertEquals(22, items[0].quality);
    }

    @Test
    void testBackstagePassesVeryCloseToSellDate() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, items[0].sellIn);
        assertEquals(23, items[0].quality);
    }

    @Test
    void testBackstagePassesOnSellDate() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void testBackstagePassesAfterSellDate() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, -1, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-2, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void testConjuredItemBeforeSellDate() {
        Item[] items = new Item[] { new Item(CONJURED, 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, items[0].sellIn);
        assertEquals(18, items[0].quality);
    }

    @Test
    void testConjuredItemOnSellDate() {
        Item[] items = new Item[] { new Item(CONJURED, 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, items[0].sellIn);
        assertEquals(16, items[0].quality);
    }

    @Test
    void testConjuredItemAfterSellDate() {
        Item[] items = new Item[] { new Item(CONJURED, -1, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-2, items[0].sellIn);
        assertEquals(16, items[0].quality);
    }

    @Test
    void testConjuredItemWithZeroQuality() {
        Item[] items = new Item[] { new Item(CONJURED, 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

}
