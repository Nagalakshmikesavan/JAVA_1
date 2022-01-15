package MultiThreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<E> {

    private Queue<E> queue;
    private int size;
    private ReentrantLock lock = new ReentrantLock();

    public BlockingQueue(int size)
    {
        this.size=size;
        queue=new LinkedList<E>();
    }

    public void put(String val)
    {
        lock.lock();
        try {
            if(queue.size()==size)
            {
                Thread.sleep(200);


            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public E take()
    {
        lock.lock();
        try {
            if(queue.isEmpty())
            {
                Thread.sleep(200);


            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return queue.remove();
    }

    public static void main(String args[])
    {
        int size=5;
        BlockingQueue<String> b = new BlockingQueue<>(size);

        b.put("a");
        b.put("b");
        b.put("c");
        b.put("d");
        
    }

}
