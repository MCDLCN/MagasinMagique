package com.magasin;

class Magasin {
    Item[] items;

    public Magasin(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Comté":
                    updateComte(item);
                    break;
                case "Kryptonite":
                    break;
                case "Pass VIP Concert":
                    updatePassVipConcert(item);
                    break;
                default:
                    updateNormalItem(item);
                    break;
            }
        }
    }

    private void updateNormalItem(Item item) {
        decreaseQuality(item, 1);
        item.sellIn--;

        if (item.sellIn < 0) {
            decreaseQuality(item, 1);
        }
    }

    private void updateComte(Item item) {
        increaseQuality(item, 1);
        item.sellIn--;

        if (item.sellIn < 0) {
            increaseQuality(item, 1);
        }
    }

    private void updatePassVipConcert(Item item) {
        increaseQuality(item, 1);

        if (item.sellIn <= 10) {
            increaseQuality(item, 1);
        }

        if (item.sellIn <= 5) {
            increaseQuality(item, 1);
        }

        item.sellIn--;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void increaseQuality(Item item, int amount) {
        item.quality = Math.min(50, item.quality + amount);
    }

    private void decreaseQuality(Item item, int amount) {
        item.quality = Math.max(0, item.quality - amount);
    }
}
