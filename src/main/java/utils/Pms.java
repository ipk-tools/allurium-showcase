package utils;

public class Pms {

    public static void measureExecutionTime(String methodName, Runnable action) {
        long startTime = System.nanoTime();
        action.run();
        long endTime = System.nanoTime();
        long durationInMillis = (endTime - startTime) / 1_000_000;
        System.out.println(methodName + " execution time: " + durationInMillis + " ms");
    }
}
