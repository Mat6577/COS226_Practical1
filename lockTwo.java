class lockTwo extends Thread implements lock  {
    public static int victim;
    // Implementing the locking algorithm
    @Override
    public void lock(int i) {
        victim = i;
        while(victim == i) {
            System.out.println("Thread: " + i + " is waiting.");
            System.out.println("victim = " + i + "\n");
        }
    }
    
    @Override
    public void unlock(int i) {
        System.out.println("Thread: " + i + " is out the critical section.");
    }

    // Main for testing the lockOne lock algorithm
    public static void main(String[] args) {
        switch (args[0]){
            case "1": {
                lockTwoConcurrent thread0 = new lockTwoConcurrent();
                lockTwoConcurrent thread1 = new lockTwoConcurrent();

                thread0.start();
                thread1.start();
                break; 
            }  
            case "2": {
                lockTwoSequential thread0 = new lockTwoSequential();
                lockTwoSequential thread1 = new lockTwoSequential();

                thread0.run();
                thread1.run();
                break; 
            }     
            default: return;       
        }
    }
}