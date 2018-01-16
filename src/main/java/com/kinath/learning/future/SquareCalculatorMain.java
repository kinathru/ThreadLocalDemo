package com.kinath.learning.future;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by kinath on 16/01/2018.
 */
public class SquareCalculatorMain
{
    @Test
    public void TestSingleThread()
    {
        SquareCalculator squareCalculator = new SquareCalculator();
        Future<Integer> calculate = squareCalculator.calculate( 10 );
        while( !calculate.isDone() )
        {
            System.out.println("Calculating square");
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
            Integer integer = calculate.get();
            System.out.println("Square of 10 is : " + integer);
        }
        catch( InterruptedException e )
        {
            e.printStackTrace();
        }
        catch( ExecutionException e )
        {
            e.printStackTrace();
        }

        if( !squareCalculator.getExecutor().isShutdown() )
        {
            System.out.println( "Shutting down executor" );
            squareCalculator.getExecutor().shutdown();
        }
    }

    @Test
    public void testMultipleThreads()
    {
        SquareCalculator squareCalculator = new SquareCalculator();
        Future<Integer> calc10 = squareCalculator.calculate( 10 );
        Future<Integer> calc100 = squareCalculator.calculate( 100 );

        long startTime = System.currentTimeMillis();
        while( !calc10.isDone() && !calc100.isDone() )
        {
            String cal10Status = "Calc10 " + ( calc10.isDone() ? "Done" : "Processing" );
            String cal100Status = "Calc100 " + ( calc100.isDone() ? "Done" : "Processing" );

            System.out.println( cal10Status + " - " + cal100Status );
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
            System.out.println( calc10.get() + " - " + calc100.get() );
        }
        catch( InterruptedException e )
        {
            e.printStackTrace();
        }
        catch( ExecutionException e )
        {
            e.printStackTrace();
        }
        finally
        {
            squareCalculator.getExecutor().shutdown();
        }

        long endTime = System.currentTimeMillis();

        System.out.println( "Elapsed Time : " + ( endTime - startTime ) / 1000 + " secs" );
    }
}
