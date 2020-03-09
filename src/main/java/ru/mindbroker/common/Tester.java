package ru.mindbroker.common;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Tester {
    private Task task;
    private String path;

    public Tester(Task task, String path) {
        this.task = task;
        this.path = path;
    }

    public void runTest() {
        int nr = 0;
        while (true) {
            URL in = getClass().getClassLoader().getResource(path + "test." + nr + ".in");
            URL out = getClass().getClassLoader().getResource(path + "test." + nr + ".out");
            if (in == null || out == null) {
                break;
            }
            Object[] result = testTask(in.getFile(), out.getFile());
            System.out.println("Test #" + nr + " - " + result[0] + ". Tooks " + result[1] + " micros.");
            nr++;
        }
    }

    public void runTestToFile(String rowName, OpenOption option) {
        String pathDir = getClass().getClassLoader().getResource(path).getPath();
        int nr = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(rowName + ";");
        while (true) {
            String in = pathDir + "test." + nr + ".in";
            String out = pathDir + "test." + nr + ".out";
            if (!Files.exists(Paths.get(in)) || !Files.exists(Paths.get(in))) {
                break;
            }
            Object[] result = testTask(in, out);
            System.out.println("Test #" + nr + " - " + result[0] + ". Tooks " + result[1] + " micros.");
            sb.append(String.format("%b;%.3f;", result[0], result[1]));
            nr++;
        }
        try {
            String res = pathDir + "result.csv";
            Files.write(Paths.get(res), sb.toString().getBytes(), option);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Object[] testTask(String inFile, String outFile) {
        Object[] result = new Object[2];
        try {
            List<String> data = Files.readAllLines(Paths.get(inFile));
            List<String> expected = Files.readAllLines(Paths.get(outFile));
            final long start = System.nanoTime();
            String actual = task.run(data);
            result[1] = (System.nanoTime() - start) / 1000.0;
            result[0] = Objects.equals(actual, expected.get(0));
        } catch (Exception e) {
            e.printStackTrace();
            result[0] = false;
            result[1] = -1;
        }
        return result;

    }
}
