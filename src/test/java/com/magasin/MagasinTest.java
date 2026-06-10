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
}