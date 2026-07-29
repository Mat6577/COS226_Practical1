public class petersonLockCorrect extends Thread {
    public static int count = 0;

    public int i = 0;
    public int id;
    petersonLock lock = new petersonLock();

    public petersonLockCorrect() {
        id=count++;
    }

    // Entering the critical section
    @Override
    public void run() {
        lock.correctLock(this.id);
        try {
            int shared = 0;
            shared = shared + 1;
            shared = shared + 1;
            System.out.print("Thread: " + this.id + " is in the critical section.\n");
        } finally {
            lock.unlock(this.id);
        }
    }
}
