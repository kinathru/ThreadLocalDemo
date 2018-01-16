package com.kinath.learning.callable;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by kinath on 16/01/2018.
 */
public class CallableTest
{
    @Test public void testFactorial()
    {
        FactorialTask factorialTask = new FactorialTask( 5 );
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit( factorialTask );

        while( !future.isDone() )
        {
            System.out.println( "Calculating" );
            try
            {
                Thread.sleep( 300 );
            }
            catch( InterruptedException e )
            {
                e.printStackTrace();
            }
        }

        try
        {
            Assert.assertEquals( 120, future.get().intValue() );
            System.out.println( "Factorial of 5 is : " + future.get().intValue() );
        }
        catch( InterruptedException e )
        {
            e.printStackTrace();
        }
        catch( ExecutionException e )
        {
            e.printStackTrace();
        }

        if( !executor.isShutdown() )
        {
            executor.isShutdown();
        }
    }
}
