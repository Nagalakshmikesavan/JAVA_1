package MultiThreading;

public class PingPongThreads {

    public static void main(String args[]) {

        Thread t1 = new Thread(new pingpong(0, "PING"));
        Thread t2 = new Thread(new pingpong(1, "PONG"));

        t1.start();
        t2.start();
    }


}

class pingpong implements Runnable{

    Integer flag;
    String val;
    static Object lock = new Object() ;
    static int N;

    public pingpong(int flag,String val)
    {
        this.flag=flag;
        this.val=val;

    }

    @Override
    public void run() {

        while(N<10)
        {
            synchronized (lock)
            {
                if(N%2!=flag)
                {
                    try{
                        lock.wait(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName()+" "+val);
                N++;
                lock.notify();
            }


        }

    }
}
