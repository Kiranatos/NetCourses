package net.kiranatos.javarush.сore.lvl7;

/* Java Core,  7 уровень,  6 лекция 
Предложения
Не используя synchronized сделай так, чтобы количество сделанных и принятых предложений было одинаковым.

Old variant: package com.javarush.test.level17.lesson06.task02;
 */

/* Предложения
Не используя synchronized сделайте так, чтобы количество сделанных и принятых предложений было одинаковым. */

public class Core7Lvl17Lesson06Task02 {
     public volatile static int proposal = 0;

    public static void main(String[] args) {
        new MakeProposal().start();
        new AcceptProposal().start();
    }

    public static class MakeProposal extends Thread {
        @Override
        public void run() {
            int thisProposal = proposal;

            while (proposal < 10) {
                System.out.println("Сделано предложение №" + (thisProposal + 1));
                proposal = ++thisProposal;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }

    public static class AcceptProposal extends Thread {
        @Override
        public void run() {
            int thisProposal = proposal;

            while (thisProposal < 10) {
                if (thisProposal != proposal) {
                    System.out.println("Принято предложение №" + proposal);
                    thisProposal = proposal;
                }
            }
        }
    }   
}