import java.util.concurrent.locks.ReentrantLock;

class Locks extends Thread {
// Variable will be recorded in main memory as opposed to cpu
    static volatile int counter = 0; 
// Single lock to pass to constructor
    private final ReentrantLock lock;
// Identifier string to pass to constructor
    private String s;
    
    public static void main(String[] args) throws InterruptedException {
// Lock for critical section
        ReentrantLock rlock = new ReentrantLock();
        System.out.println("Starting threads...");
// Create thread with identifier strings and single lock
        Locks t1 = new Locks("A", rlock);
        Locks t2 = new Locks("B", rlock);
// Run thread 1
        t1.start();
// Run thread 2
        t2.start();
// Wait for thread 1 to finish
        t1.join();
// Wait for thread 2 to finish
        t2.join();

        System.out.println("Threads complete - counter: " + counter);
    }

// Constructor
    public Locks(String s, ReentrantLock lock) {
        this.s = s;
        this.lock = lock;
    }

// Thread run method
    public void run() {
        System.out.println(s + ": Begin.");
// Add one 10 million times
        for(int i = 0; i < 1e7; i++) {
// Lock the critical section to ensure the critical section executes without interruption
            lock.lock();
            try {
                counter = counter + 1;
            } finally {
// Unlock and free the lock for other threads to use
                lock.unlock();
            }
        }
// Print thread completion
        System.out.println(s + ": Complete.");
    }
}