package ru.mindbroker.lesson01;

import ru.mindbroker.common.Task;

import java.util.List;

public class StringLengthTask implements Task {

    public String run(List<String> data) {
        return String.valueOf(data.get(0).length());
    }
}
