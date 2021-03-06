package ru.mindbroker.lesson02.gcd;

import ru.mindbroker.common.Task;

import java.util.List;

public class EuclidSubtractionTask implements Task {
    @Override
    public String run(List<String> data) {
        String[] numbers = data.get(0).split(" ");
        Integer a = Integer.valueOf(numbers[0]);
        Integer b = Integer.valueOf(numbers[1]);
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return String.valueOf(a);
    }
}
