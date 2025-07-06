package com.example.adv_software_project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class User {
    private String username;
    private String password;
    private String address;
    private String phone;
    private List<Order> pastOrders;
    private List<OrderItem> cart;
    public static boolean loggedin = false;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.address = "St";
        this.phone = "0123456789";
        this.pastOrders = new ArrayList<>();
        this.cart = new ArrayList<>();
    }

    public boolean login(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            System.out.println("Login successful.");
            loggedin = true;
            return true;
        } else {
            return false;
        }
    }

    public void register(String username, String password, String address, String phone) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.phone = phone;
        System.out.println("Account created successfully.");
        loggedin = true;
    }

    public List<Order> getPastOrders() {

        if (pastOrders.isEmpty()) {
            System.out.println("No past orders found.");
            return null;
        } else {
            System.out.println("Past orders:");
            for (Order order : pastOrders) {
                order.displayOrderDetails();
            }
            return pastOrders;
        }

    }

    public void addOrder(Order order) {
        pastOrders.add(order);
    }

    public List<OrderItem> getCart() {
        if (cart.isEmpty()) {
            //System.out.println("Cart is empty.");
            return new ArrayList<>(); // Return an empty list instead of null
        } else {
            System.out.println("Cart:");
            for (OrderItem item : cart) {
                System.out.println("name: "+item.getMenuItem().getName()+" price: "+item.getMenuItem().getPrice()+" quantity: "+item.getQuantity());
            }
            return cart;
        }
    }

    public void addToCart(MenuItem item, int quantity) {
        cart.add(new OrderItem(item, quantity));
    }

    public void incrementQuantity(MenuItem item){
        for (OrderItem orderItem : cart) {
            if (orderItem.getMenuItem().getName().equalsIgnoreCase(item.getName())) {
                orderItem.setQuantity(orderItem.getQuantity() + 1);
                return;
            }
        }
        addToCart(item, 1);
    }

    public void decrementQuantity(MenuItem item){
        Iterator<OrderItem> iterator = cart.iterator();

        while (iterator.hasNext()) {
            OrderItem orderItem = iterator.next();
            if (orderItem.getMenuItem().getName().equalsIgnoreCase(item.getName())) {
                if (orderItem.getQuantity() > 1) {
                    // Decrement the quantity if greater than 1
                    orderItem.setQuantity(orderItem.getQuantity() - 1);
                } else {
                    // Remove the item from the cart if quantity is 1 or less
                    iterator.remove();
                }
                return; // Exit after processing the item
            }
        }
    }

    public void clearCart() {
        cart.clear();
    }

    public void pay() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty. Cannot proceed with payment.");
            return;
        }

        Order order = new Order(cart);
        System.out.println(order.getTotalPrice());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose Payment Method:");
        System.out.println("false. Cash");
        System.out.println("true. Credit");
        boolean choice = scanner.nextBoolean();

        Payment payment;
        if (!choice) {
            payment = new Payment(order.getTotalPrice(), "Cash");
        } else {
            payment = new Payment(order.getTotalPrice(), "Credit");

            System.out.println("Enter holder name");
            String cardHolder = scanner.next();

            System.out.println("Enter Credit Card Number:");
            String cardNumber = scanner.next();

            System.out.println("Enter Expiry Date (MM/YY):");
            String expiryDate = scanner.next();

            System.out.println("Enter CVV:");
            String cvv = scanner.next();



            payment.setCardDetails(cardNumber, expiryDate, cvv, cardHolder);
        }

        if (!payment.processPayment()) {
            System.out.println("Payment failed. Order cannot be placed.");
            return;
        }


        //Confirm the order
        order.confirmOrder();
        pastOrders.add(order);
        cart.clear();
        System.out.println("Order confirmed. Thank you for your purchase!");
    }
}
