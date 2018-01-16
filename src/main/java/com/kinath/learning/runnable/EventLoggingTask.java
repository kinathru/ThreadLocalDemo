package com.kinath.learning.runnable;

/**
 * Created by kinath on 16/01/2018.
 */
public class EventLoggingTask implements Runnable
{
    @Override public void run()
    {
        System.out.println("Logging task");
        try
        {
            Thread.sleep( 1000 );
        }
        catch( InterruptedException e )
        {
            e.printStackTrace();
        }
    }
}
