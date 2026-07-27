public class lockOneNormal extends Thread {
    public static int count = 0;

    public int i = 0;
    public int id;
    lockOne lock = new lockOne();

    public lockOneNormal() {
        id=count++;
    }

    @Override
    public void run() {
        lock.lock(this.id);
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
