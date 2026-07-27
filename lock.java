public interface lock {
    // Constructor used to lock create an instance of the lock
    public void lock(int id);
    // An abstract function for unlocking the locks
    public void unlock(int id);    
}
