public class petersonLock {
    public static boolean[] flag = {false, false};

    public static int victim;
    // Implementing the locking algorithm
    public void correctLock(int i) {
        flag[i] = true;
        int j = 1 - i;
        victim = i;
        while(flag[j] && victim == i) {
            System.out.println("Thread: " + i + " is waiting.");
        }
    }

    public void inCorrectLock(int i) {
        victim = i;
        flag[i] = true;
        int j = 1 - i;

        while(flag[j] && victim == i) {
            System.out.println("Thread: " + i + " is waiting.");
        }
    }
    
    public void unlock(int i) {
        System.out.println("Thread: " + i + " is out the critical section.\n");
        flag[i] = false;
    }
}