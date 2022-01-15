package MultiThreading;

public class OddEvenThreads {

    public static void main(String args[]) {
        Thread t1 = new Thread(new oddEven(0));
        Thread t2 = new Thread(new oddEven(1));
        t1.start();
        t2.start();


    }
}
    class oddEven implements Runnable{
        Integer flag;
        static Object lock = new Object();
        static int N=1;

        public oddEven(int flag) {
            this.flag =flag;
        }

        @Override
        public void run() {
            while(N<10)
            {
                synchronized (lock)
                {
                    if(N%2!=flag)
                    {
                       // System.out.println("try" + Thread.currentThread().getName());
                        try {
                            lock.wait(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(Thread.currentThread().getName()+ " "+N);
                    N++;
                    lock.notify();
                }
            }

        }
    }



