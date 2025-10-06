package org.example.task2;

import java.util.Arrays;

public class Cart {
    private Item[] items;
    private int itemCount;

    public Cart(int capacity) {
        this.items = new Item[capacity];
        this.itemCount = 0;
    }

    public void add(Item item) {
        if (isCartFull()) {
            return;
        }
        items[itemCount] = item;
        itemCount++;
    }

    public void removeById(long itemId) {
        if (itemCount == 0) {
            return;
        }

        int foundItemIndex = findItemIndexById(itemId);
        if (foundItemIndex == -1) {
            return;
        }

        // Зсув елементів для видалення
        for (int i = foundItemIndex; i < itemCount - 1; i++) {
            items[i] = items[i + 1];
        }
        items[itemCount - 1] = null;
        itemCount--;
    }

    private int findItemIndexById(long itemId) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getId() == itemId) {
                return i;
            }
        }
        return -1;
    }

    public boolean isCartFull() {
        return itemCount == items.length;
    }

    public boolean isEmpty() {
        return itemCount == 0;
    }

    public int getItemCount() {
        return itemCount;
    }

    public Item[] getItems() {
        return Arrays.copyOf(items, itemCount);
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (int i = 0; i < itemCount; i++) {
            total += items[i].getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + Arrays.toString(getItems()) +
                ", itemCount=" + itemCount +
                '}' + "\n";
    }
}