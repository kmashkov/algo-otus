package ru.mindbroker.lesson02.prime;

import ru.mindbroker.common.Task;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrimeOptimezedATask implements Task {

    @Override
    public String run(List<String> data) {
        Integer n = Integer.valueOf(data.get(0));
        return String.valueOf(calcPrimes(n));
    }

    private int calcPrimes(Integer n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(Integer n) {
        if (n == 2) {
            return true;
        }
        for (int i = 2; i * i <= n; i ++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
