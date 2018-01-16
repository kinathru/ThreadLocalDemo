package com.kinath.learning.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * Created by kinath on 16/01/2018.
 */
public class FactorialSquareCalculator extends RecursiveTask<Integer>
{
    private int n;

    public FactorialSquareCalculator( int n )
    {
        this.n = n;
    }

    @Override protected Integer compute()
    {
        if( n <= 1 )
        {
            return n;
        }

        FactorialSquareCalculator calculator = new FactorialSquareCalculator( n - 1 );
        calculator.fork();

        return n * n + calculator.join();
    }
}
