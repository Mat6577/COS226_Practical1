public class Main {
    public static void main(String[] args) {
        // Initializing the thread objects
        Threads thread0 = new Threads();
        Threads thread1 = new Threads();

        // The threads have been initialized
        thread0.start();
        thread1.start();

        thread0.run();
        thread1.run();
    }
} 