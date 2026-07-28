public class petersonLock {
    public static boolean[] flag = {false, false};

    public static int victim;
    // Implementing the locking algorithm
    public void correctLock(int i) {
        flag[i] = true;
        int j = 1 - i;
        victim = i;
        while(flag[j] && victim == i) {
            System.out.println("+ Thread: " + i + " is waiting.");
        }
    }

    public void inCorrectLock(int i) {
        victim = i;
        flag[i] = true;
        int j = 1 - i;

        while(flag[j] && victim == i) {
            System.out.println("+ Thread: " + i + " is waiting.");
        }
    }
    
    public void unlock(int i) {
        System.out.println("- Thread: " + i + " is out the critical section.\n");
        flag[i] = false;
    }

    // Main for testing the lockOne lock algorithm
    public static void main(String[] args) {
        switch (args[0]){
            case "1": {
                petersonLockCorrect thread0 = new petersonLockCorrect();
                petersonLockCorrect thread1 = new petersonLockCorrect();

                thread0.start();
                thread1.start();
                break; 
            }  
            case "2": {
                petersonLockInCorrect thread0 = new petersonLockInCorrect();
                petersonLockInCorrect thread1 = new petersonLockInCorrect();

                thread0.start();
                thread1.start();
                break; 
            }     
            default: return;       
        }


    }
}