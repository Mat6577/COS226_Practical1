class lockTwo extends Thread implements lock  {
    public static int victim;
    // Implementing the locking algorithm
    @Override
    public void lock(int i) {
        victim = i;
        while(victim == i) {
            System.out.println("Thread: " + i + " is waiting.");
        }
    }
    
    @Override
    public void unlock(int i) {
        System.out.println("Thread: " + i + " is out the critical section.");
    }
}