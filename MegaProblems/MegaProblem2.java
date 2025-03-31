import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MegaProblem2 {

    static class Resource {
        private final String name;
        private final Lock lock;

        public Resource(String name) {
            this.name = name;
            this.lock = new ReentrantLock();
        }

        public boolean lockResource(long timeout) {
            try {
                return lock.tryLock(timeout, java.util.concurrent.TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
        }

        public void unlockResource() {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + " освободил ресурс " + name);
        }
    }

    static class Thread1 implements Runnable {
        private final Resource resourceA;
        private final Resource resourceB;

        public Thread1(Resource resourceA, Resource resourceB) {
            this.resourceA = resourceA;
            this.resourceB = resourceB;
        }

        @Override
        public void run() {
            try {
                if (resourceA.lockResource(500)) {
                    System.out.println(Thread.currentThread().getName() + " захватил ресурс " + resourceA.name);
                    Thread.sleep(100);

                    if (resourceB.lockResource(500)) {
                        System.out.println(Thread.currentThread().getName() + " захватил ресурс " + resourceB.name);
                        System.out.println(Thread.currentThread().getName() + " выполнил работу с ресурсами");
                        resourceB.unlockResource();
                    } else {
                        System.out.println(Thread.currentThread().getName() + " не смог захватить ресурс " + resourceB.name);
                    }
                    resourceA.unlockResource();
                } else {
                    System.out.println(Thread.currentThread().getName() + " не смог захватить ресурс " + resourceA.name);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    static class Thread2 implements Runnable {
        private final Resource resourceA;
        private final Resource resourceB;

        public Thread2(Resource resourceA, Resource resourceB) {
            this.resourceA = resourceA;
            this.resourceB = resourceB;
        }

        @Override
        public void run() {
            try {
                if (resourceB.lockResource(500)) {
                    System.out.println(Thread.currentThread().getName() + " захватил ресурс " + resourceB.name);
                    Thread.sleep(100);

                    if (resourceA.lockResource(500)) {
                        System.out.println(Thread.currentThread().getName() + " захватил ресурс " + resourceA.name);
                        System.out.println(Thread.currentThread().getName() + " выполнил работу с ресурсами");
                        resourceA.unlockResource();
                    } else {
                        System.out.println(Thread.currentThread().getName() + " не смог захватить ресурс " + resourceA.name);
                    }
                    resourceB.unlockResource();
                } else {
                    System.out.println(Thread.currentThread().getName() + " не смог захватить ресурс " + resourceB.name);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Resource resourceA = new Resource("Resource A");
        Resource resourceB = new Resource("Resource B");

        Thread thread1 = new Thread(new Thread1(resourceA, resourceB), "Thread 1");
        Thread thread2 = new Thread(new Thread2(resourceA, resourceB), "Thread 2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}