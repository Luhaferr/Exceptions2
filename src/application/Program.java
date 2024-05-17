package application;

import model.entities.Account;
import model.exception.DomainException;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter account data");
        System.out.print("Number: ");
        int number = scanner.nextInt();
        System.out.print("Holder: ");
        scanner.nextLine();
        String holder = scanner.nextLine();
        System.out.print("Initial balance: ");
        double balance = scanner.nextDouble();
        System.out.print("Withdraw limit: ");
        double withdrawLimit = scanner.nextDouble();
        Account account = new Account(number, holder, balance, withdrawLimit);

        System.out.println();
        System.out.print("Enter amount for withdraw: ");

        try {
            account.withdraw(scanner.nextDouble());
            System.out.print("New balance: " + String.format("%.2f", account.getBalance()));
        }
        catch (DomainException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}