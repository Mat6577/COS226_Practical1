
public class lockOneDeadlock extends Thread {
    public static int count = 0;

    public int id;
    lockOne lock = new lockOne();

    public lockOneDeadlock() {
        id=count++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) { 
            // The iteration will cause a deadlock as we will reach a point where two threads want to enter the CS
            lock.lock(this.id);
            try {
                int shared = 0;
                shared = shared + 1;
                System.out.print("Thread: " + this.id + " is in the critical section.\n");
            } finally {
                lock.unlock(this.id);
            }
        }
    }
}
