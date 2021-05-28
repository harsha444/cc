package multithreading;

class ReentrantLockDemo {
    public static void main(String[] args) throws InterruptedException {
        NonReentrantLock nonReentrantLock = new NonReentrantLock();
        nonReentrantLock.lock();
        System.out.println("locked");
        nonReentrantLock.lock();
        System.out.println("locked 2");
    }
}

public class NonReentrantLock {
    boolean isLocked;

    public NonReentrantLock() {
        this.isLocked = false;
    }

    public synchronized void lock() throws InterruptedException {
        while(isLocked) {
            wait();
        }
        isLocked = true;
    }

    public synchronized void unLock() {
        isLocked = false;
        notify();
    }
}
