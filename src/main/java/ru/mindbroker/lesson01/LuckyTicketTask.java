package ru.mindbroker.lesson01;

import ru.mindbroker.common.Task;

import java.util.List;

public class LuckyTicketTask implements Task {
    private Integer n;
    private Integer qty;


    public String run(List<String> data) {
        if (data == null || data.get(0) == null) {
            return null;
        }
        qty = 0;
        n = Integer.valueOf(data.get(0));
        countLuckyTickets(0, 0, 0);
        return qty.toString();
    }

    private void countLuckyTickets(Integer nr, Integer sum1, Integer sum2) {
        if (nr == 2 * n) {
            if (sum1.equals(sum2)) {
                qty++;
            }
            return;
        }
        for (int i = 0; i <= 9; i ++) {
            if (nr < n) {
                countLuckyTickets(nr + 1, sum1 + i, sum2);
            } else {
                countLuckyTickets(nr + 1, sum1, sum2 + i);
            }
        }
    }
}
