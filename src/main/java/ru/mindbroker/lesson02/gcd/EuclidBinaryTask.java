package ru.mindbroker.lesson02.gcd;

import ru.mindbroker.common.Task;

import java.util.List;

public class EuclidBinaryTask implements Task {
    @Override
    public String run(List<String> data) {
        String[] numbers = data.get(0).split(" ");
        Integer a = Integer.valueOf(numbers[0]);
        Integer b = Integer.valueOf(numbers[1]);
        Integer nod = getNod(a, b);
        return String.valueOf(nod);
    }

    private Integer getNod(Integer a, Integer b) {
        Integer nod = 1;
        Integer tmp;
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        if (a.equals(b))
            return a;
        if (a == 1 || b == 1)
            return 1;
        while (a != 0 && b != 0) {
            // Если оба числа четные: НОД * 2, а числа делим на 2
            if (((a & 1) | (b & 1)) == 0) {
                nod <<= 1;
                a >>= 1;
                b >>= 1;
                continue;
            }
            // Если а четное, b нечетное: а делим на 2
            if (((a & 1) == 0) && (b & 1) == 1) {
                a >>= 1;
                continue;
            }
            // Если а нечетное, b четное: b делим на 2
            if ((a & 1) == 1 && ((b & 1) == 0)) {
                b >>= 1;
                continue;
            }
            // Присваиваем а разность большего и меншего, деленную на 2, а b - наименшее из двух
            if (a > b) {
                tmp = a;
                a = b;
                b = tmp;
            }
            tmp = a;
            a = (b - a) >> 1;
            b = tmp;
        }
        if (a == 0)
            return nod * b;
        else
            return nod * a;
    }
}
