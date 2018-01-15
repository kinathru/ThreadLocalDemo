package com.kinath.learning;

/**
 * Created by kinath on 15/01/2018.
 */
public class DemoThread extends Thread
{
    private String[] names = new String[]{"A", "B", "C", "D"};
    private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
    private int normalField = 0;
    private String randomString = null;
    private ThreadLocal<String> threadLocalString = new ThreadLocal<String>();

    public void run()
    {
        threadLocal.set( (int) ( Math.random() * 100D ) );
        normalField = (int) ( Math.random() * 100D );
        randomString = names[(int) Math.random() * 4];
        threadLocalString.set( names[(int) Math.random() * 4] );

        try
        {
            Thread.sleep( 2000 );
        }
        catch( InterruptedException e )
        {
        }

        System.out.println( this.getName()+ " : " + threadLocal.get() );
        System.out.println( this.getName()+ " : " + normalField );
        System.out.println( this.getName()+ " : " + randomString );
        System.out.println( this.getName()+ " : " + threadLocalString.get() );
    }
}
