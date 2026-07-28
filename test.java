public class test {
    public static void main(String[] args) {
            switch (args[0]) {
            // lockOne  testing
            case "1"-> {
                lockOneDeadlock thread0 = new lockOneDeadlock();
                lockOneDeadlock thread1 = new lockOneDeadlock();

                // Deadlock prone lockOne
                thread0.start();
                thread1.start(); 
                break; 
            }  
            case "2"-> {
                lockOneNormal thread0 = new lockOneNormal();
                lockOneNormal thread1 = new lockOneNormal();

                // No-Deadlock 
                thread0.start();
                thread1.start(); 
                break; 
            }     
            // lockTwo test
            case "3"-> {
                lockTwoNormal thread0 = new lockTwoNormal();
                lockTwoNormal thread1 = new lockTwoNormal();

                // Running them concurrently
                thread0.start();
                thread1.start();
                break; 
            }  
            case "4"-> {
                lockTwoNormal thread0 = new lockTwoNormal();
                lockTwoNormal thread1 = new lockTwoNormal();

                // Running them sequentially
                thread0.run();
                thread1.run();
                break; 
            }         
            // PetersonLock test
            case "5"-> {
                petersonLockCorrect thread0 = new petersonLockCorrect();
                petersonLockCorrect thread1 = new petersonLockCorrect();

                // petersonLock with correct initialization
                thread0.start();
                thread1.start();
                break; 
            }  
            case "6"-> {
                petersonLockInCorrect thread0 = new petersonLockInCorrect();
                petersonLockInCorrect thread1 = new petersonLockInCorrect();

                // petersonLock with incorrect initialization
                thread0.start();
                thread1.start();
                break; 
            }     
            default -> System.out.println("Index not available");     
        }
    }
}
