class lockOne extends Thread implements lock  {
    public static boolean[] flag = {false, false};
    // Implementing the locking algorithm
    public void lock(int i) {
        flag[i] = true;
        int j = 1 - i;
        while(flag[j]) {
            System.out.println("Thread: " + i + " is waiting.");
            System.out.println("Flag[i = " + flag[i] + ", j = " + flag[j] + "]\n");
        }
    }
    
    @Override
    public void unlock(int i) {
        flag[i] = false;
        System.out.println("Thread: " + i + " is out the critical section.");
    }
}