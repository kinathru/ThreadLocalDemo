package com.kinath.learning.forkjoin;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by kinath on 16/01/2018.
 */
public class ForkJoinTest
{
    @Test public void testFactorialCalculator()
    {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        FactorialSquareCalculator calculator = new FactorialSquareCalculator( 10 );
        forkJoinPool.execute( calculator );

        while( !calculator.isDone() )
        {
            System.out.println( "Processing!!!" );
        }

        try
        {
            System.out.println( calculator.get() );
        }
        catch( InterruptedException e )
        {
            e.printStackTrace();
        }
        catch( ExecutionException e )
        {
            e.printStackTrace();
        }
    }
}
