package com.mycompany.l1;

import java.util.*;
import java.io.*;


class Transaction{
    private Date date;
    private char type;
    private double amount;
    private double balance;
    private String description;
    
    public Transaction(Date dateCreated, char t, double bal, String desc){
        date = dateCreated;
        type = t;
        balance = bal;
        description = desc;
    }
    
    public void setDate(Date d){
        date = d;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setType(char t){
        type = t;
    }
    
    public char getType() {
        return type;
    }
    
    public void setAmount(double a){
        amount = a;
    }
    
    public double getAmount() {
        return amount;
    }
    
    
    public void setBalance(double b){
        balance = b;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setDescription(String s){
        description = s;
    }
    
    public String getDescription() {
        return description;
    }
}

class Account {

    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;
    private String name;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Account() {
        id = 0;
        balance = 0;
        annualInterestRate = 0;
        dateCreated = new Date();
    }

    public Account(int defaultId, double initialBalance) {
        id = defaultId;
        balance = initialBalance;
        dateCreated = new Date();
    }
    
    public Account(String n,int defaultId, double initialBalance){
        name = n;
        id = defaultId;
        balance = initialBalance;
    }

    public void setId(int newId) {
        id = newId;
    }

    public int getId() {
        return id;
    }

    public void setBalance(int newBalance) {
        balance = newBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setAnualInterestRate(double newAnnualInterestRate) {
        annualInterestRate = newAnnualInterestRate;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public Date getDate() {
        return dateCreated;
    }

    public double getMonthlyInterestRate() {
        return (annualInterestRate / 100) / 12;
    }

    public double getMonthlyInterest() {
        return (annualInterestRate / 100) / 12 * balance;
    }

    public void withdraw(double amt, String desc){
        balance -= amt;
        Transaction transaction = new Transaction(new Date(), 'W', amt, desc);
        transaction.setBalance(balance);
        transactions.add(transaction);
    }

    public void deposit(double amt, String desc) {
        balance += amt;
        Transaction transaction = new Transaction(new Date(), 'D', amt, desc);
        transaction.setBalance(balance);
        transactions.add(transaction);
    }
    
    public void printTransactions(){
        System.out.println("Transaction history:");
        for (Transaction transaction : transactions) {
            System.out.println("Date of transaction: "+ transaction.getDate());
            System.out.println("Type: "+ transaction.getType());
            System.out.println("Transaction amount: "+ transaction.getAmount());
            System.out.println("Latest balance: "+ transaction.getBalance());
            System.out.println("Description: "+ transaction.getDescription());
            System.out.println();
        }
    }
    
    public void printAccountSummary(){
        System.out.println("Name: "+name);
        System.out.println("Interest rate: "+annualInterestRate);
        System.out.println("Account balance: "+balance);
        printTransactions();
    }

}

public class L1 {

    public static void main(String[] args) {
        Q4();
    }

    public static void Q3() {
        Account acc = new Account(1122, 20000);
        acc.setAnualInterestRate(4.5);
        acc.withdraw(2500,"");
        acc.deposit(3000,"");
        System.out.println("Balance: "+acc.getBalance());
        System.out.println("Monthly interest: "+acc.getMonthlyInterest());
        System.out.println("Date created: "+acc.getDate());
    }
    
    public static void Q4(){
        Account Account1 = new Account("George",1122,1000);
        Account1.setAnualInterestRate(1.5);
        Account1.deposit(30, "");
        Account1.deposit(40, "");
        Account1.deposit(50, "");
        
        Account1.withdraw(5, "");
        Account1.withdraw(4, "");
        Account1.withdraw(2, "");
        
        Account1.printAccountSummary();
    }

    public static void Q2() {
        try {

            BufferedReader is1 = new BufferedReader(new FileReader("text1.txt"));
            BufferedReader is2 = new BufferedReader(new FileReader("text2.txt"));
            BufferedReader is3 = new BufferedReader(new FileReader("text3.txt"));
            BufferedReader is4 = new BufferedReader(new FileReader("text4.txt"));

            String line;
            System.out.println("text1.txt");
            int numCharText1 = 0;
            int numCharText2 = 0;
            int numCharText3 = 0;
            int numCharText4 = 0;
            while ((line = is1.readLine()) != null) {
                String[] arr = line.split(",");
                numCharText1 += arr.length;
                for (String string : arr) {
                    System.out.print(string + " ");
                }
                System.out.println();
            }

            System.out.println("\ntext1.text has " + numCharText1 + " number of characters");

            System.out.println("\ntext2.txt");
            while ((line = is2.readLine()) != null) {
                String[] arr = line.split(", ");
                numCharText2 += arr.length;
                for (String string : arr) {
                    System.out.print(string + " ");
                }
                System.out.println();
            }

            System.out.println("\ntext2.text has " + numCharText2 + " number of characters");

            System.out.println("\ntext3.txt");
            while ((line = is3.readLine()) != null) {
                String[] arr = line.split("; ");
                numCharText3 += arr.length;
                for (String string : arr) {
                    System.out.print(string + " ");
                }
                System.out.println();
            }

            System.out.println("\ntext3.text has " + numCharText3 + " number of characters");

            System.out.println("\ntext4.txt");
            while ((line = is4.readLine()) != null) {
                String[] arr = line.split("\\d+");
                numCharText4 += arr.length;
                for (String string : arr) {
                    System.out.print(string + " ");
                }
                System.out.println();
            }

            System.out.println("\ntext4.text has " + numCharText4 + " number of characters");
            is1.close();
            is2.close();
            is3.close();
            is4.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void Q1() {
        try {

            BufferedReader is = new BufferedReader(new FileReader("Adam_23002641.txt"));

            BufferedWriter writer = new BufferedWriter(new FileWriter("Adam_23002641.txt", true));
            Scanner scanner = new Scanner(System.in);
            System.err.println("Write your letter type END at end when you finish writing: ");
            writer.newLine();
            writer.newLine();

            while (true) {
                String text = scanner.nextLine();
                if (text.equalsIgnoreCase("END")) {
                    break;
                }
                writer.write(text);
                writer.newLine();

            }
            writer.close();

            String line;
            while ((line = is.readLine()) != null) {
                System.out.println(line);
            }
            is.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
