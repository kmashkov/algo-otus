package ru.mindbroker.lesson02.prime;

import ru.mindbroker.common.Tester;

import java.nio.file.StandardOpenOption;

public class Main {

    public static void main(String[] args) {
        System.out.println("Prime test start.");
        Tester tester = new Tester(new PrimeTask(), "Lesson02/3.PRIME/");
        tester.runTestToFile("Через перебор делителей", StandardOpenOption.CREATE);
        System.out.println("Prime test end.");

        System.out.println("PrimeOptimezedA test start.");
        tester = new Tester(new PrimeOptimezedATask(), "Lesson02/3.PRIME/");
        tester.runTestToFile("\nЧерез перебор делителей до корня", StandardOpenOption.APPEND);
        System.out.println("PrimeOptimezedA test end.");

        System.out.println("PrimeOptimezedB test start.");
        tester = new Tester(new PrimeOptimezedBTask(), "Lesson02/3.PRIME/");
        tester.runTestToFile("\nЧерез перебор делителей до корня без кратных двум", StandardOpenOption.APPEND);
        System.out.println("PrimeOptimezedB test end.");

        System.out.println("PrimeOptimizedC test start.");
        tester = new Tester(new PrimeOptimizedCTask(), "Lesson02/3.PRIME/");
        tester.runTestToFile("\nЧерез перебор делителей с использованием массива", StandardOpenOption.APPEND);
        System.out.println("PrimeOptimizedC test end.");

        System.out.println("EratosthenesClassic test start.");
        tester = new Tester(new EratosthenesClassicTask(), "Lesson02/3.PRIME/");
        tester.runTestToFile("\nРешето Эратосфена со сложностью O(n log log n) (классическая реализация)", StandardOpenOption.APPEND);
        System.out.println("EratosthenesClassic test end.");

        System.out.println("Eratosthenes test start.");
        tester = new Tester(new EratosthenesTask(), "Lesson02/3.PRIME/");
        tester.runTestToFile("\nРешето Эратосфена со сложностью O(n log log n) (с рекурсией)", StandardOpenOption.APPEND);
        System.out.println("Eratosthenes test end.");

        System.out.println("EratosthenesClassicBin test start.");
        tester = new Tester(new EratosthenesClassicBinTask(), "Lesson02/3.PRIME/");
        tester.runTestToFile("\nРешето Эратосфена с оптимизацией памяти (классическая реализация)", StandardOpenOption.APPEND);
        System.out.println("EratosthenesClassicBin test end.");

        System.out.println("EratosthenesBin test start.");
        tester = new Tester(new EratosthenesBinTask(), "Lesson02/3.PRIME/");
        tester.runTestToFile("\nРешето Эратосфена с оптимизацией памяти (с рекурсией)", StandardOpenOption.APPEND);
        System.out.println("EratosthenesBin test end.");

        System.out.println("EratosthenesClassicN test start.");
        tester = new Tester(new EratosthenesClassicNTask(), "Lesson02/3.PRIME/");
        tester.runTestToFile("\nРешето Эратосфена за n (классическая реализация)", StandardOpenOption.APPEND);
        System.out.println("EratosthenesClassicN test end.");
    }
}
