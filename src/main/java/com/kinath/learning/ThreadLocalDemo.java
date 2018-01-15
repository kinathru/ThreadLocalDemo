package com.kinath.learning;

/**
 * Created by kinath on 15/01/2018.
 */
public class ThreadLocalDemo
{
    public static void main( String[] args )
    {
        DemoThread d1 = new DemoThread();
        d1.setNormalField( "D1" );
        ThreadLocal<String> d1t1 = new ThreadLocal<String>();
        d1t1.set( "D1T1" );
        d1.setThreadLocal( d1t1 );

        DemoThread d2 = new DemoThread();
        d2.setNormalField( "D2" );
        ThreadLocal<String> d2t1 = new ThreadLocal<String>();
        d2t1.set( "D2T1" );
        d2.setThreadLocal( d2t1 );

        d1.start();
        d2.start();
    }
}
