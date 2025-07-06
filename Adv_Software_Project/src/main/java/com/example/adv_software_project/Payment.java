package com.example.adv_software_project;

public class Payment {
    private double amount;
    private String paymentMethod; // "Cash" or "Credit"
    private String cardNumber;
    private String expiryDate;
    private String cvv;
    private String cardHolderName;

    public Payment(double amount, String paymentMethod) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public void setCardDetails(String cardNumber, String expiryDate, String cvv, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.cardHolderName = cardHolderName;
    }

    public boolean processPayment() {
        if (paymentMethod.equalsIgnoreCase("Cash")) {
            return processCashPayment();
        } else if (paymentMethod.equalsIgnoreCase("Credit")) {
            return processCreditPayment();
        }
        return false; // Invalid payment method
    }

    private boolean processCashPayment() {
        System.out.println("Payment of $" + amount + " received in cash.");
        return true;
    }

    private boolean processCreditPayment() {
        if (validateCreditCard()) {
            System.out.println("Payment of $" + amount + " processed successfully with credit card.");
            return true;
        } else {
            System.out.println("Credit card validation failed.");
            return false;
        }
    }

    private boolean validateCreditCard() {
        return cardNumber != null && cardNumber.length() == 16 &&
                expiryDate != null && expiryDate.matches("\\d{2}/\\d{2}") &&
                cvv != null && cvv.length() == 3;
    }
}
