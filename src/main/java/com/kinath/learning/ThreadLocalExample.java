package com.kinath.learning;

/**
 * Created by kinath on 15/01/2018.
 */
public class ThreadLocalExample
{
    public static class MyRunnable implements Runnable
    {

        private String [] names = new String[]{"A","B","C","D"};
        private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
        private int normalField = 0;
        private String randomString = null;
        private ThreadLocal<String> threadLocalString = new ThreadLocal<String>();

        public void run()
        {
            threadLocal.set( (int) ( Math.random() * 100D ) );
            normalField = (int) ( Math.random() * 100D );
            randomString = names[(int)Math.random()*4];
            threadLocalString.set( names[(int)Math.random()*4] );

            try
            {
                Thread.sleep( 2000 );
            }
            catch( InterruptedException e )
            {
            }

            System.out.println( threadLocal.get() );
            System.out.println( normalField );
            System.out.println(randomString);
            System.out.println(threadLocalString.get());
        }
    }


    public static void main( String[] args ) throws InterruptedException
    {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread( sharedRunnableInstance );
        Thread thread2 = new Thread( sharedRunnableInstance );

        thread1.start();
        thread2.start();

        thread1.join(); //wait for thread 1 to terminate
        thread2.join(); //wait for thread 2 to terminate
    }
}
