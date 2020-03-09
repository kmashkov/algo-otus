package ru.mindbroker.lesson02.prime;

import ru.mindbroker.common.Task;

import java.util.List;

import static java.lang.Math.sqrt;

public class EratosthenesTask implements Task {
    @Override
    public String run(List<String> data) {
        Integer n = Integer.valueOf(data.get(0));
        return String.valueOf(calcPrimes(n));
    }

    private int calcPrimes(Integer n) {
        int limit = (int) sqrt(n);
        boolean[] indexes = new boolean[n + 1];
        markDeleted(2, limit, indexes);
        return count(indexes);
    }

    private void markDeleted(int n, int limit, boolean[] indexes) {
        if (n > limit) {
            return;
        }
        for (int i = n * n; i < indexes.length; i += n) {
            indexes[i] = true;
        }
        int next = next(n, indexes);
        if (next == 0) {
            return;
        }
        markDeleted(next, limit, indexes);
    }

    private int next(int n, boolean[] indexes) {
        for (int i = n + 1; i < indexes.length; i++) {
            if (!indexes[i]) {
                return i;
            }
        }
        return 0;
    }

    private int count(boolean[] indexes) {
        int count = 0;
        for (int i = 2; i < indexes.length; i++) {
            if (!indexes[i]) {
                count++;
            }
        }
        return count;
    }
}
