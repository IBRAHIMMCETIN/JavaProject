package com.homeworks;

public class BankingApplication {
    public static void main(String[] args) {
        System.out.println("===Hoş Geldiniz ===");

        AccountRepository repository = new MemoryAccountRepository();

        System.out.println("\n Yeni hesap oluşturuluyor...");
        Account myAccount = new Account("İbrahim", "1881");
        repository.save(myAccount);
        System.out.println(" Hesap başarıyla veritabanına kaydedildi.");

        System.out.println("\n'İbrahim' kullanıcısı ile giriş yapılmaya çalışılıyor...");
        Account loggedInAccount = repository.findByUsername("İbrahim");

        if (loggedInAccount != null && loggedInAccount.checkPassword("1881")) {
            System.out.println("Giriş başarılı! Hoş geldin, " + loggedInAccount.getUsername());

            System.out.println("\n--- İşlemler Başlıyor ---");
            System.out.println("Mevcut Bakiyeniz: " + loggedInAccount.getBalance() + " TL");

            System.out.println("\n Hesaba 10.000 TL yatırılıyor...");
            loggedInAccount.deposit(10000);

            System.out.println("\n Hesaptan 2.500 TL çekiliyor...");
            loggedInAccount.withdraw(2500);

            System.out.println("\n Hesaptan bakiye aşımı (20.000 TL) çekilmeye çalışılıyor...");
            loggedInAccount.withdraw(20000);

            System.out.println("\n--- Gün Sonu ---");
            System.out.println("Son Bakiyeniz: " + loggedInAccount.getBalance() + " TL");

        } else {
            System.out.println("Hata: Kullanıcı adı veya şifre yanlış!");
        }

        System.out.println("\nİşlemler tamamlandı. Teşekkürler!");
    }
    }