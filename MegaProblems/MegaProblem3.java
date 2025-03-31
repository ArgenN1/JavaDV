import java.util.concurrent.*;

class TaskQueue {
    private final BlockingQueue<Integer> queue;

    public TaskQueue(int capacity) {
        this.queue = new ArrayBlockingQueue<>(capacity);
    }

    public void addTask(int task) throws InterruptedException {
        queue.put(task);
    }

    public Integer takeTask() throws InterruptedException {
        return queue.take();
    }
}

class Worker implements Runnable {
    private final TaskQueue taskQueue;

    public Worker(TaskQueue taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer task = taskQueue.takeTask();
                System.out.println(Thread.currentThread().getName() + " выполняет задачу: " + task);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class MegaProblem3 {
    public static void main(String[] args) throws InterruptedException {
        TaskQueue taskQueue = new TaskQueue(10);
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            executor.execute(new Worker(taskQueue));
        }

        for (int i = 1; i <= 10; i++) {
            taskQueue.addTask(i);
            System.out.println("Добавлена задача: " + i);
            Thread.sleep(300);
        }

        executor.shutdown();
    }
}