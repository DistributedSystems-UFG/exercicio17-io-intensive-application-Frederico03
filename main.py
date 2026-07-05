import time
from concurrent.futures import ThreadPoolExecutor

NUM_TASKS = 50
SIMULATED_IO_SEC = 0.1

def perform_io_task(task_id):
    time.sleep(SIMULATED_IO_SEC)

def main():
    print("--- Starting Python I/O Intensive Application Benchmark ---")

    # 1. Sequential Execution
    start_time = time.time()
    for i in range(NUM_TASKS):
        perform_io_task(i)
    sequential_time = time.time() - start_time
    print(f"Sequential execution took: {sequential_time * 1000:.2f} ms")

    # 2. Concurrent Execution using Thread Pool
    pool_size = 10
    start_time = time.time()
    with ThreadPoolExecutor(max_workers=pool_size) as executor:
        executor.map(perform_io_task, range(NUM_TASKS))
    concurrent_time = time.time() - start_time
    print(f"Concurrent execution ({pool_size} threads) took: {concurrent_time * 1000:.2f} ms")

    speedup = sequential_time / concurrent_time
    print(f"Concurrency Speedup: {speedup:.2f}x")

if __name__ == "__main__":
    main()
