package com.kinath.learning.callable;

import java.security.InvalidParameterException;
import java.util.concurrent.Callable;

/**
 * Created by kinath on 16/01/2018.
 */
public class FactorialTask implements Callable<Integer>
{
    private int n;

    public FactorialTask( int n )
    {
        this.n = n;
    }

    @Override public Integer call() throws InvalidParameterException
    {
        if( n < 0 )
        {
            throw new InvalidParameterException( "Number should be greater than 1" );
        }

        int fact = 1;
        for( int i = n ; i > 1 ; i-- )
        {
            fact = fact*i;
        }
        return fact;
    }
}
