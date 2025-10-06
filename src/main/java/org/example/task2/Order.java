package org.example.task2;

public class Order {
    private long id;
    private String customer;

    public Order(long id, String customer) {
        this.id = id;
        this.customer = customer;
    }

    public String formOrderBill(Cart cart) {
        StringBuilder builder = new StringBuilder();
        builder.append("Order number ").append(id).append(" for customer ").append(customer);
        builder.append("\n------------------\n");

        double totalSum = 0.0;
        Item[] items = cart.getItems();

        for (Item item : items) {
            totalSum += item.getPrice();
            builder.append("Item id: ")
                    .append(item.getId())
                    .append(" name: ")
                    .append(item.getName())
                    .append(" price: ")
                    .append(item.getPrice())
                    .append("\n");
        }

        builder.append("------------------\n");
        builder.append("Total sum: ").append(totalSum);

        return builder.toString();
    }

    // Гетери
    public long getId() {
        return id;
    }

    public String getCustomer() {
        return customer;
    }
}