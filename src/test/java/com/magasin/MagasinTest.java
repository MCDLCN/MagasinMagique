package com.magasin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {

    @Test
    void normalItemQualityDecreasesByOne() {
        Item[] items = new Item[] { new Item("Pain", 10, 20) };

        Magasin app = new Magasin(items);
        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(19, app.items[0].quality);
    }

    @Test
    void normalItemQualityDecreasesTwiceAsFastAfterExpiration() {
        Item[] items = new Item[] { new Item("Pain", 0, 20) };

        Magasin app = new Magasin(items);
        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(18, app.items[0].quality);
    }

    @Test
    void normalItemQualityNeverGoesBelowZero() {
        Item[] items = new Item[] { new Item("Pain", 10, 0) };

        Magasin app = new Magasin(items);
        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void comteQualityIncreasesByOne() {
        Item[] items = new Item[] { new Item("Comté", 10, 20) };

        Magasin app = new Magasin(items);
        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(21, app.items[0].quality);
    }

    @Test
    void comteQualityNeverGoesAboveFifty() {
        Item[] items = new Item[] { new Item("Comté", 10, 50) };

        Magasin app = new Magasin(items);
        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void kryptoniteNeverChanges() {
        Item[] items = new Item[] { new Item("Kryptonite", 10, 80) };

        Magasin app = new Magasin(items);
        app.updateQuality();

        assertEquals(10, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void passVipConcertQualityIncreasesByOneWhenMoreThanTenDaysLeft() {
        Item[] items = new Item[] { new Item("Pass VIP Concert", 15, 20) };

        Magasin app = new Magasin(items);
        app.updateQuality();

        assertEquals(14, app.items[0].sellIn);
        assertEquals(21, app.items[0].quality);
    }

    @Test
    void passVipConcertQualityIncreasesByTwoWhenTenDaysOrLessLeft() {
        Item[] items = new Item[] { new Item("Pass VIP Concert", 10, 20) };

        Magasin app = new Magasin(items);
        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
        assertEquals(22, app.items[0].quality);
    }

    @Test
    void passVipConcertQualityIncreasesByThreeWhenFiveDaysOrLessLeft() {
        Item[] items = new Item[] { new Item("Pass VIP Concert", 5, 20) };

        Magasin app = new Magasin(items);
        app.updateQuality();

        assertEquals(4, app.items[0].sellIn);
        assertEquals(23, app.items[0].quality);
    }

    @Test
    void passVipConcertQualityDropsToZeroAfterConcert() {
        Item[] items = new Item[] { new Item("Pass VIP Concert", 0, 20) };

        Magasin app = new Magasin(items);
        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
}