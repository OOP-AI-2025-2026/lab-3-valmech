package org.example.task2;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Тестування класу Box ===");

        try {
            Box box1 = new Box(5.0, 3.0, 2.0);

            System.out.println("Коробка 1: " + box1);
            System.out.println("Площа поверхні: " + box1.getSurfaceArea());
            System.out.println("Площа бічної поверхні: " + box1.getLateralSurfaceArea());
            System.out.println("Об'єм: " + box1.getVolume());

            System.out.println("\n Інший приклад ");
            Box box2 = new Box(10.0, 4.0, 6.0);
            System.out.println("Коробка 2: " + box2);
            System.out.println("Площа поверхні: " + box2.getSurfaceArea());
            System.out.println("Площа бічної поверхні: " + box2.getLateralSurfaceArea());
            System.out.println("Об'єм: " + box2.getVolume());

        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        System.out.println("\n Тестування перевірки даних");
        try {
            Box invalidBox = new Box(0, 3.0, 2.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка при створенні коробки: " + e.getMessage());
        }

        try {
            Box invalidBox2 = new Box(5.0, -2.0, 3.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка при створенні коробки: " + e.getMessage());
        }

        System.out.println("\n\n=== Тестування корзини та замовлень ===");

        // Тестування корзини та замовлень
        Cart cart = new Cart(10);
        cart.add(new Item(1, "Samsung Galaxy S23", 27999));
        cart.add(new Item(2, "Lenovo IdeaPad 3", 19499));
        cart.add(new Item(3, "LG 55\" 4K Smart TV", 15999));
        cart.add(new Item(4, "Bosch Serie 6 Пральна машина", 14799));
        cart.add(new Item(5, "Samsung RB34 Холодильник", 22399));
        cart.add(new Item(6, "De'Longhi Magnifica S Кавоварка", 10599));
        cart.add(new Item(7, "Gorenje Електрична плита", 9999));
        cart.add(new Item(8, "Dyson V11 Пилосос", 16499));
        cart.add(new Item(9, "Samsung ME83K Мікрохвильова піч", 3199));
        cart.add(new Item(10, "Philips DryCare Фен", 1499));

        System.out.println("Кошик після додавання товарів:");
        System.out.println(cart);
        System.out.println("Загальна вартість: " + cart.getTotalPrice());

        cart.removeById(9);
        System.out.println("Кошик після видалення товару з id=9:");
        System.out.println(cart);
        System.out.println("Загальна вартість після видалення: " + cart.getTotalPrice());

        Order order = new Order(1L, "John");
        String bill = order.formOrderBill(cart);
        System.out.println("\nРахунок замовлення:");
        System.out.println(bill);

        System.out.println("\n\n=== Тестування класу IntStack ===");

        IntStack stack = new IntStack();

        System.out.println("Створено новий стек: " + stack);
        System.out.println("Розмір стеку: " + stack.size());
        System.out.println("Стек порожній? " + stack.isEmpty());

        System.out.println("\n Додавання елементів ");
        for (int i = 1; i <= 15; i++) {
            stack.push(i * 10);
            System.out.println("Додано: " + (i * 10) + ", розмір: " + stack.size() + ", ємність: " + stack.getCapacity());
        }

        System.out.println("Стек після додавання: " + stack);
        System.out.println("Вершина стеку (peek): " + stack.peek());

        System.out.println("\n Вилучення елементів");
        while (!stack.isEmpty()) {
            int element = stack.pop();
            System.out.println("Вилучено: " + element + ", розмір: " + stack.size());
        }

        System.out.println("\n Тестування винятків");
        try {
            stack.pop();
        } catch (IllegalStateException e) {
            System.out.println("Помилка при pop(): " + e.getMessage());
        }

        try {
            stack.peek();
        } catch (IllegalStateException e) {
            System.out.println("Помилка при peek(): " + e.getMessage());
        }

        System.out.println("\n Тестування очищення");
        stack.push(100);
        stack.push(200);
        stack.push(300);
        System.out.println("Стек перед очищенням: " + stack);
        stack.clear();
        System.out.println("Стек після очищення: " + stack);
        System.out.println("Розмір після очищення: " + stack.size());
    }
}