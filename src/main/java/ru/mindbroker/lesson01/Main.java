package ru.mindbroker.lesson01;

import ru.mindbroker.common.Tester;

public class Main {

    public static void main(String[] args) {
        System.out.println("String length test start.");
        Tester tester = new Tester(new StringLengthTask(), "Lesson01/0.String/");
        tester.runTest();
        System.out.println("String length test ends.");

        System.out.println("Lucky tickets test start.");
        tester = new Tester(new LuckyTicketTask(), "Lesson01/1.Tickets/");
        tester.runTest();
        System.out.println("Lucky tickets test ends.");
    }
}
