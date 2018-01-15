package com.kinath.learning;

import java.util.Random;

/**
 * Created by kinath on 15/01/2018.
 */
public class ThreadLocalExample
{
    public static class MyRunnable implements Runnable
    {

        private String[] names = new String[]{"A", "B", "C", "D"};
        private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
        private ThreadLocal<String> threadLocalString = new ThreadLocal<String>();
        private int normalField = 0;
        private String randomString = null;

        public void run()
        {
            Random random = new Random();
            threadLocal.set( (int) ( Math.random() * 100D ) );
            threadLocalString.set( names[random.nextInt( 4 )] );

            normalField = (int) ( Math.random() * 100D );
            randomString = names[random.nextInt( 4 )];

            try
            {
                Thread.sleep( 2000 );
            }
            catch( InterruptedException e )
            {
            }

            System.out.println("Thread Local : ");
            System.out.println(  threadLocal.get() );
            System.out.println( threadLocalString.get() );

            System.out.println("Normal : ");
            System.out.println( normalField );
            System.out.println( randomString );
            System.out.println();
        }
    }


    public static void main( String[] args ) throws InterruptedException
    {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread( sharedRunnableInstance );
        thread1.setName( "T1" );
        Thread thread2 = new Thread( sharedRunnableInstance );
        thread2.setName( "T2" );

        thread1.start();
        thread2.start();

        thread1.join(); //wait for thread 1 to terminate
        thread2.join(); //wait for thread 2 to terminate
    }
}
