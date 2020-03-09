package ru.mindbroker.lesson02.prime;

import ru.mindbroker.common.Task;
import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class EratosthenesClassicNTask implements Task {
    @Override
    public String run(List<String> data) {
        Integer n = Integer.valueOf(data.get(0));
        return String.valueOf(calcPrimes(n));
    }

    private int calcPrimes(Integer n) {
        int size = n + 1;
        int[] lp = new int[size];
        List<Integer> pr = new ArrayList<>();
        for (int i = 2; i < size; i++) {
            if (lp[i] == 0) {
                lp[i] = i;
                pr.add(i);
            }
            for (int j = 0; j < pr.size() && pr.get(j) <= lp[i] && pr.get(j) * i <= n; j++) {
                lp[pr.get(j) * i] = pr.get(j);
            }
        }
        return pr.size();
    }

}
