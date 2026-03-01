package paymentinterface;
import java.util.Scanner;

import java.util.Scanner;
public class PaymentGateway {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        double amount;
        do {
            System.out.println("\n===== PAYMENT MENU =====");
            System.out.println("1 - Wallet");
            System.out.println("2 - Card");
            System.out.println("3 - UPI");
            System.out.println("4 - NetBanking");
            System.out.println("5 - Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter amount: ");
                amount = sc.nextDouble();
            } else {
                amount = 0;
            }
            Payment payment = null;
            switch (choice) {
                case 1:
                    payment = new Wallet();
                    break;
                case 2:
                    payment = new Card();
                    break;
                case 3:
                    payment = new UPI();
                    break;
                case 4:
                    payment = new Netbanking();
                    break;
                case 5:
                    System.out.println("Thank you! Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            if (payment != null) {
                payment.pay(amount);
            }
        } while (choice != 5);
        sc.close();
    }
}
 