package com.kinath.learning.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by kinath on 16/01/2018.
 */
public class SquareCalculator
{
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public Future<Integer> calculate( final Integer input )
    {
        Future<Integer> future = executor.submit( new Callable<Integer>()
        {
            @Override public Integer call() throws Exception
            {
                Thread.sleep( 1000 );
                return input * input;
            }
        } );

        return future;

        // Following is the same implementation using lambda
        /*return executor.submit( () ->
        {
            try
            {
                Thread.sleep( 1000 );
            }
            catch( InterruptedException e )
            {
                e.printStackTrace();
            }
            return input * input;
        } );*/
    }
}
