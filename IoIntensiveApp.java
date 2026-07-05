import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class IoIntensiveApp {
    private static final int NUM_TASKS = 50;
    private static final int SIMULATED_IO_MS = 100;

    // A task simulating an I/O operations (e.g., database query, API call)
    private static void performIoTask(int taskId) {
        try {
            // Sleep simulates waiting for an external resource (I/O)
            Thread.sleep(SIMULATED_IO_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- Starting I/O Intensive Application Benchmark ---");

        // 1. Sequential Execution
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < NUM_TASKS; i++) {
            performIoTask(i);
        }
        long sequentialTime = System.currentTimeMillis() - startTime;
        System.out.println("Sequential execution took: " + sequentialTime + " ms");

        // 2. Concurrent Execution using an Executor Service (Thread Pool)
        int poolSize = 10;
        ExecutorService executor = Executors.newFixedThreadPool(poolSize);
        startTime = System.currentTimeMillis();
        
        for (int i = 0; i < NUM_TASKS; i++) {
            final int taskId = i;
            executor.submit(() -> performIoTask(taskId));
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        
        long concurrentTime = System.currentTimeMillis() - startTime;
        System.out.println("Concurrent execution (" + poolSize + " threads) took: " + concurrentTime + " ms");
        
        double speedup = (double) sequentialTime / concurrentTime;
        System.out.printf("Concurrency Speedup: %.2fx%n", speedup);
    }
}
