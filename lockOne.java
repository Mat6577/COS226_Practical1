class lockOne extends Thread implements lock  {
    public static boolean[] flag = {false, false};
    // Implementing the locking algorithm
    @Override
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

    // Main for testing the lockOne lock algorithm
    public static void main(String[] args) {
        switch (args[0]) {
            case "1": {
                lockOneDeadlock thread0 = new lockOneDeadlock();
                lockOneDeadlock thread1 = new lockOneDeadlock();

                thread0.start();
                thread1.start(); 
                break; 
            }  
            case "2": {
                lockOneNormal thread0 = new lockOneNormal();
                lockOneNormal thread1 = new lockOneNormal();

                thread0.start();
                thread1.start(); 
                break; 
            }     
            default: return;       
        }

    }
}