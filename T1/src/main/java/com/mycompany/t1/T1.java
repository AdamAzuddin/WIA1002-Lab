package com.mycompany.t1;

class Telephone {

    String areaCode;
    int number;
    static int numberOfTelephoneObject;

    public Telephone(String aCode, int num) {
        numberOfTelephoneObject++;
        areaCode = aCode;
        number = num;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public int getNumber() {
        return number;
    }

    public void setAreaCode(String code) {
        areaCode = code;
    }

    public void setNumber(int num) {
        number = num;
    }

    public String makeFullNumber() {

        String numberStr = String.valueOf(number);

        return areaCode + "-" + numberStr;
    }
}

abstract class Vehicle {

    double maxSpeed;
    protected double currentSpeed;

    public Vehicle(double max) {
        maxSpeed = max;
    }

    void accelerate() {
        currentSpeed++;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    void pedalToTheMetal() {
        while (true) {
            accelerate();
            if(currentSpeed<=maxSpeed){
                break;
            }
        }
    }

}


interface Account{
    void deposit(int num);
    boolean withdraw(int num);
}

class BankAccount implements Account{
    double balance;
    
    public BankAccount(int bal){
        balance = bal;
    }
    
    @Override
    public void deposit(int num){
        balance+=num;
    }
    
    @Override
    public boolean withdraw(int num){
        if(num>balance){
            return false;
        } else{
            balance-=num;
            return true;
        }
    }
}

public class T1 {

    public static void main(String[] args) {
        Q1();
    }

    public static void Q1() {

        Telephone t1 = new Telephone("03", 79676300);
        Telephone t2 = new Telephone("03", 79676301);
        Telephone t3 = new Telephone("03", 79676302);
        Telephone t4 = new Telephone("03", 79676303);
        Telephone t5 = new Telephone("03", 79676304);

        Telephone[] telArr = {t1, t2, t3, t4, t5};

        for (int i = 0; i < telArr.length; i++) {
            System.out.println(telArr[i].makeFullNumber());
        }
    }
}
