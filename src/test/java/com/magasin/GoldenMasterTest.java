package com.magasin;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GoldenMasterTest {

    @Test
    void goldenMasterInventoryOutputAfterThirtyDays() throws IOException {
        Item[] items = new Item[]{
                new Item("Pain", 10, 20),
                new Item("Comté", 2, 0),
                new Item("Kryptonite", 0, 80),
                new Item("Pass VIP Concert", 15, 20),
                new Item("Pass VIP Concert", 10, 49),
                new Item("Pass VIP Concert", 5, 49)
        };

        Magasin app = new Magasin(items);

        StringBuilder output = new StringBuilder();

        for (int day = 0; day < 30; day++) {
            output.append("-------- day ").append(day).append(" --------\n");

            for (Item item : items) {
                output.append(item.name)
                        .append(", ")
                        .append(item.sellIn)
                        .append(", ")
                        .append(item.quality)
                        .append("\n");
            }

            app.updateQuality();
        }

        String expected = Files.readString(
                Path.of("src/test/resources/golden-master.txt"));

        assertEquals(expected, output.toString());
    }
}