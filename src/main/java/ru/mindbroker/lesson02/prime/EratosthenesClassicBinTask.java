package ru.mindbroker.lesson02.prime;

import ru.mindbroker.common.Task;

import java.util.Arrays;
import java.util.List;

public class EratosthenesClassicBinTask implements Task {
    @Override
    public String run(List<String> data) {
        Integer n = Integer.valueOf(data.get(0));
        return String.valueOf(calcPrimes(n));
    }

    private int calcPrimes(Integer n) {
        int size = n + 1;
        int[] arr = new int[size / 32 + (size % 32 == 0 ? 0 : 1)];
        for (int i = 2; i * i < size; i++) {
            int idx = i / 32;
            int sft = i % 32;
            if ((arr[idx] >> sft & 1) == 0) {
                for (int j = i * i; j < size; j += i) {
                    int index= j / 32;
                    int shift = j % 32;
                    arr[index] = arr[index] | 1 << shift;
                }
            }
        }
        return count(arr, n);
    }

    private int count(int[] arr, int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            int idx = i / 32;
            int shift = i % 32;
            if ((arr[idx] >> shift & 1) == 0) {
                count++;
            }
        }
        return count;
    }
}
