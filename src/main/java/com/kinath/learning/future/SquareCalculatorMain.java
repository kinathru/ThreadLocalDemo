package com.kinath.learning.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by kinath on 16/01/2018.
 */
public class SquareCalculatorMain
{
    public static void main( String[] args )
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
}
