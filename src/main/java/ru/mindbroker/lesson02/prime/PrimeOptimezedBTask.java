package ru.mindbroker.lesson02.prime;

import ru.mindbroker.common.Task;

import java.util.List;

public class PrimeOptimezedBTask implements Task {

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
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i*i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
