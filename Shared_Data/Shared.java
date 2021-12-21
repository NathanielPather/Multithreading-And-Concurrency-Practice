public class Intro {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting threads...");
// Create thread with string as "a" and sleep time 0
        MyThread t1 = new MyThread("a", 0);
// Create thread with string as "b" and sleep time 2000
        MyThread t2 = new MyThread("b", 2000);
// Run thread 1
        t1.start();
// Wait for thread to finish
        t1.join();

// Run thread 2
        t2.start();
// Wait for thread to finish
        t2.join(); 

        System.out.println("Threads finished.");
    }
}

class MyThread extends Thread {
// Class members
    String s;
    int time;

// Constructor
    public MyThread(String s, int time) {
        this.s = s;
        this.time = time;
    }

// Thread run method
    public void run() {
        try {
// Pause thread for time duration
            Thread.sleep(time);
        }
        catch (InterruptedException e) {
            //...
        }
        
// Print string value
        System.out.println(s);
    }
}