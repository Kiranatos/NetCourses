package net.kiranatos.javarush.сore.lvl7;

/* Java Core,  7 уровень, 10 лекция
Банкомат
Разберись, как работает программа
Во время тестирования лог содержит следующее:
.....
Добавляем 100, на счету 1100
Добавляем 100, на счету 1200
Тратим 1000, на счету 100
Недостаточно денег
.....
Создан баг: При списании денег со счета теряются деньги
Найти и исправить ошибку

Old variant: package com.javarush.test.level17.lesson10.home08;
 */

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Core7Lvl17Lesson10Task08_Bankomat {
    
    static BankAccount account = new BankAccount("Amigo");
    public static volatile boolean isStopped;
    private static Thread addMoney = new Thread() {
        @Override
        public void run() {
            while (!isStopped) {
                account.deposit("1000");            //кладем на счет
                try { Thread.sleep(1000); } catch (InterruptedException e) { break; }
            }
        }
    };

    public static void main(String[] args) {
        addMoney.start();
        new SpendThread();
        new SpendThread();
        new SpendThread();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) { Logger.getLogger(Core7Lvl17Lesson10Task08_Bankomat.class.getName()).log(Level.SEVERE, null, ex); }
        isStopped = true;
    }
    
    public static class SpendThread extends Thread {
        public SpendThread() { start(); }

        @Override
        public void run() {
            while (!isStopped) {
                try {
                    account.withdraw("100");             //снимаем со счета
                } catch (NotEnoughMoneyException e) { System.out.println("Недостаточно денег"); }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) { break; }
            }
        }
    }     
} // end of class Core7Lvl17Lesson10Task08_Bankomat

class NotEnoughMoneyException extends Exception { }

class BankAccount {
    private BigDecimal balance;
    private String owner;

    public BankAccount(String owner) {
        this(BigDecimal.ZERO, owner);
    }

    public BankAccount(BigDecimal balance, String owner) {
        this.balance = balance;
        this.owner = owner;
    }

    public synchronized void deposit(BigDecimal money) {
        BigDecimal newBalance = balance.add(money);
        System.out.println("Добавляем " + money + ", на счету " + newBalance);
        balance = newBalance;
    }

    public synchronized void withdraw(BigDecimal money) throws NotEnoughMoneyException {
        BigDecimal newBalance = balance.subtract(money);

        if (newBalance.compareTo(BigDecimal.ZERO) < 0) throw new NotEnoughMoneyException();

        balance = newBalance;
        System.out.println("Тратим " + money + ", на счету " + balance);
    }

    public void deposit(String money) {
        deposit(new BigDecimal(money));
    }

    public void withdraw(String money) throws NotEnoughMoneyException {
        withdraw(new BigDecimal(money));
    }
}