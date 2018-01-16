package com.kinath.learning.runnable;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by kinath on 16/01/2018.
 */
public class RunnableTest
{
    @Test
    public void testEventLoggingTask()
    {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<?> future = executor.submit( new EventLoggingTask() );
        while( !future.isDone()  )
        {
            System.out.println("Logging");
            try
            {
                Thread.sleep( 3000 );
            }
            catch( InterruptedException e )
            {
                e.printStackTrace();
            }
        }

        if( !executor.isShutdown() )
        {
            executor.shutdown();
        }
    }
}
