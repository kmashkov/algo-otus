package ru.mindbroker.lesson02.prime;

import ru.mindbroker.common.Task;

import java.util.Arrays;
import java.util.List;

import static java.lang.Math.sqrt;

public class EratosthenesClassicTask implements Task {
    @Override
    public String run(List<String> data) {
        Integer n = Integer.valueOf(data.get(0));
        return String.valueOf(calcPrimes(n));
    }

    private int calcPrimes(Integer n) {
        int size = n + 1;
        boolean[] isPrime = new boolean[size];
        Arrays.fill(isPrime,true);
        isPrime[1] = false;
        for (int i = 2; i * i < size; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < size; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return count(isPrime);
    }

    private int count(boolean[] isPrime) {
        int count = 0;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}
