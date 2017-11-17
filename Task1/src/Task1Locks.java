import java.util.concurrent.locks.*;



public abstract class Task1Locks 
{
    
    protected abstract void takeBunch(int q);
    protected abstract void fillBunch();
    
    final private ReentrantReadWriteLock rrwl = new ReentrantReadWriteLock(true);
    final private Lock readLock = rrwl.readLock();
    final private Lock writeLock = rrwl.writeLock();
    
    
    public void take(int i) throws InterruptedException
    {
        beforeTake();
        
        try
        {
            takeBunch(i);
        }
        finally
        {
            afterTake();
        }
    }
    
    public void fill() throws InterruptedException
    {
        beforeFill();
        
        try
        {
            fillBunch();
        }
        finally
        {
            afterFill();
        }
    }
    
    protected void beforeTake()
    {
        readLock.lock();
    }
    
    protected void beforeFill()
    {
        writeLock.lock();
    }
    
    protected void afterTake()
    {
        readLock.unlock();
    }
    
    protected void afterFill()
    {
        writeLock.unlock();
    }
}

