package ru.mindbroker.lesson02.gcd;

import ru.mindbroker.common.Tester;

import java.nio.file.StandardOpenOption;

public class Main {

    public static void main(String[] args) {
        System.out.println("Euclid subtraction test start.");
        Tester tester = new Tester(new EuclidSubtractionTask(), "Lesson02/1.GCD/");
        tester.runTestToFile("Алгоритм Евклида через вычитание", StandardOpenOption.CREATE);
        System.out.println("Euclid subtraction test ends.");

        System.out.println("Euclid division test start.");
        tester = new Tester(new EuclidDivisionTask(), "Lesson02/1.GCD/");
        tester.runTestToFile("\nАлгоритм Евклида через остаток", StandardOpenOption.APPEND);
        System.out.println("Euclid division test ends.");

        System.out.println("Euclid binary test start.");
        tester = new Tester(new EuclidBinaryTask(), "Lesson02/1.GCD/");
        tester.runTestToFile("\nАлгоритм Евклида через битовые операции", StandardOpenOption.APPEND);
        System.out.println("Euclid binary test ends.");
    }
}
