package com.example.adv_software_project;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> items;
    private double totalPrice;
    private LocalDateTime orderDate;
    private boolean isConfirmed;

    //public Order() {}

    public Order(List<OrderItem> items) {
        this.items = new ArrayList<>(items);
        this.orderDate = LocalDateTime.now();
        this.isConfirmed = false;
        for (OrderItem orderItem : items) {
            totalPrice += orderItem.getMenuItem().getPrice() * orderItem.getQuantity();
        }
    }

//    public void addItem(MenuItem item, int quantity) {
//
//        for (OrderItem orderitem : items) {
//            if (orderitem.getMenuItem().getName().equalsIgnoreCase(item.getName())) {
//                orderitem.setQuantity(orderitem.getQuantity() + quantity);
//                totalPrice += orderitem.getMenuItem().getPrice() * quantity;
//                return;
//            }
//        }
//
//        items.add(new OrderItem(item, quantity));
//        totalPrice += item.getPrice() * quantity;
//    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<OrderItem> getOrderDetails() {
        return items;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void displayOrderDetails() {
        System.out.println("Order Date: " + orderDate);
        for (OrderItem item : items) {
            System.out.println("Name: "+ item.getMenuItem().getName() +  " Price: "+ item.getMenuItem().getPrice()+" Quantity: "+ item.getQuantity() + " Total: "+ item.getMenuItem().getPrice()*item.getQuantity());
        }
        System.out.println("Total Price: $" + totalPrice);
        System.out.println("Order Status: " + (isConfirmed ? "Confirmed" : "Pending"));
        System.out.println();
    }

    public void confirmOrder() {
        isConfirmed = true;
        System.out.println("Order confirmed. Paid in cash.");
    }
}
