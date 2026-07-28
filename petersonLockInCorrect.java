public class petersonLockInCorrect extends Thread {
    public static int count = 0;

    public int i = 0;
    public int id;
    petersonLock lock = new petersonLock();

    public petersonLockInCorrect() {
        id=count++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            lock.inCorrectLock(this.id);
            try {
                int shared = 0;
                shared = shared + 1;
                shared = shared + 1;
                System.out.print("+ Thread: " + this.id + " is in the critical section.\n");
            } finally {
                lock.unlock(this.id);
            }
        }
    }
}
