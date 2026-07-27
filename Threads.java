public class Threads extends Thread {
    public static int count = 0;

    int id;
    private lockOne lock = new lockOne();

    public Threads() {
        id=count++;
    }

    public void run() {

        lock.lock(this.id);
        try {
            int shared = 0;
            shared = shared + 1;
            try { this.sleep(10); }
            catch (IllegalArgumentException e) { System.out.println(e); }
            catch (InterruptedException e) { System.out.println(e); }

            System.out.print("Thread: " + this.id + " is in the critical section.\n");
        } finally {
            lock.unlock(this.id);
        }
    }
}