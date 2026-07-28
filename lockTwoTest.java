class lockTwoTest extends Thread implements lock  {
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
                lockTwo thread0 = new lockTwo();
                lockTwo thread1 = new lockTwo();

                // Running them concurrently
                thread0.start();
                thread1.start();
                break; 
            }  
            case "2": {
                lockTwo thread0 = new lockTwo();
                lockTwo thread1 = new lockTwo();

                // Running them sequentially
                thread0.run();
                thread1.run();
                break; 
            }     
            default: return;       
        }
    }
}