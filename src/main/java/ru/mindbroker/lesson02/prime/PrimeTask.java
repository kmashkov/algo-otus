package ru.mindbroker.lesson02.prime;

import ru.mindbroker.common.Task;

import java.util.List;

public class PrimeTask implements Task {
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
        int count = 1;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count == 2;
    }
}
