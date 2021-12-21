class SharedThreads extends Thread {
// Variable will be recorded in main memory as opposed to cpu
    static volatile int counter = 0; 
    
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting threads...");
// Create thread with identifier strings
        SharedThreads t1 = new SharedThreads("A");
        SharedThreads t2 = new SharedThreads("B");
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
// Identifier string
    String s;

// Constructor
    public SharedThreads(String s) {
        this.s = s;
    }

// Thread run method
    public void run() {
        System.out.println(s + ": Begin.");
// Add one 10 million times
        for(int i = 0; i < 1e7; i++) {
            counter = counter + 1;
        }
// Print thread completion
        System.out.println(s + ": Complete.");
    }
}