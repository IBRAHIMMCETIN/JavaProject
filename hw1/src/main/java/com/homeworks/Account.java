package com.homeworks;

public class Account {
    private String username;
    private String password;
    private double balance;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.balance = 0.0; // Yeni hesapların bakiyesi 0 olur
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Başarılı! Yeni bakiye: " + balance + " TL");
        } else {
            System.out.println("Geçersiz tutar!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Başarılı! Çekilen tutar: " + amount + " TL. Kalan bakiye: " + balance + " TL");
        } else {
            System.out.println("Yetersiz bakiye veya geçersiz tutar!");
        }
    }
}
