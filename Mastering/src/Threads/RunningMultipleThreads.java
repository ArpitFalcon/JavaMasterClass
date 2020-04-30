package Threads;

public class RunningMultipleThreads {
    public static void main(String[] args) {
        System.out.println("Main thread starting.");

        // Construct myThread object.
        MyThread1 myThread = new MyThread1("Alpha");
        MyThread1 myThread2 = new MyThread1("Beta");
        MyThread1 myThread3 = new MyThread1("Delta");
        MyThread1 myThread4 = new MyThread1("Gamma");


        // Construct an actual thread from our previous object.
        // Thread newThread = new Thread(myThread);
        // newThread.start();

        for(int i=0; i< 50; i++){
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted.");
                e.printStackTrace();
            }
        }
        System.out.println("Main thread ending.");
    }
}

class MyThread1 implements Runnable{
    Thread thread;
    String myTread;
    public void run(){
        System.out.println(myTread + " Starting.");
        for(int count = 0; count < 10; count++){
            try {
                // Creating a sleep for 400 ms.
                Thread.sleep(500);
                System.out.println("In " + myTread + " count is " + count);
            } catch (InterruptedException e) {
                System.out.println(myTread + " interrupted.");
                e.printStackTrace();
            }
            System.out.println(myTread + " terminated.");
        }
    }

    public MyThread1(String myTread) {
        this.myTread = myTread;

        // Starting our thread in constructor now.
        thread = new Thread(this, myTread);
        thread.start();

    }
}