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
}