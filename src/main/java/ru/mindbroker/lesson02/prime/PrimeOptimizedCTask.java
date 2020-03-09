package ru.mindbroker.lesson02.prime;

import ru.mindbroker.common.Task;

import java.util.LinkedList;
import java.util.List;

public class PrimeOptimizedCTask implements Task {
    List<Integer> primes = new LinkedList<>();

    @Override
    public String run(List<String> data) {
        Integer n = Integer.valueOf(data.get(0));
        return String.valueOf(calcPrimes(n));
    }

    private int calcPrimes(Integer n) {
        primes.clear();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes.size();
    }

    private boolean isPrime(Integer n) {
        if (n == 2) {
            return true;
        }
        for (int i = 0, p = primes.get(i); p * p <= n; i++, p = primes.get(i)) {
            if (n % p == 0) {
                return false;
            }
        }
        return true;
    }
}
