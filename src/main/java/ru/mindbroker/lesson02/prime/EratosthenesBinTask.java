package ru.mindbroker.lesson02.prime;

import ru.mindbroker.common.Task;

import java.util.List;

import static java.lang.Math.sqrt;

public class EratosthenesBinTask implements Task {
    @Override
    public String run(List<String> data) {
        Integer n = Integer.valueOf(data.get(0));
        return String.valueOf(calcPrimes(n));
    }

    private int calcPrimes(Integer n) {
        int limit = (int) sqrt(n);
        int[] indexes = new int[(n + 1) / 32 + ((n + 1) % 32 == 0 ? 0 : 1)];
        markDeleted(2, limit, indexes);
        return count(indexes, n);
    }

    private void markDeleted(int n, int limit, int[] indexes) {
        if (n > limit) {
            return;
        }
        for (int i = n * n; i < indexes.length * 32; i += n) {
            int idx = i / 32;
            int shift = i % 32;
            indexes[idx] = indexes[idx] | 1 << shift;
        }
        int next = next(n, indexes);
        if (next == 0) {
            return;
        }
        markDeleted(next, limit, indexes);
    }

    private int next(int n, int[] indexes) {
        for (int i = n + 1; i < indexes.length * 32; i++) {
            int idx = i / 32;
            int shift = i % 32;
            if ((indexes[idx] >> shift & 1) == 0) {
                return i;
            }
        }
        return 0;
    }

    private int count(int[] indexes, int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            int idx = i / 32;
            int shift = i % 32;
            if ((indexes[idx] >> shift & 1) == 0) {
                count++;
            }
        }
        return count;
    }
}
