package com.kinath.learning.baeldung;

/**
 * Created by kinath on 15/01/2018.
 */
public class UserContextTest
{
    public static void main( String[] args ) throws InterruptedException
    {
        ShareMapWithUserContext r1 = new ShareMapWithUserContext( 1 );
        ShareMapWithUserContext r2 = new ShareMapWithUserContext( 2 );

        Thread t1 = new Thread( r1 );
        Thread t2 = new Thread( r2 );

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(ShareMapWithUserContext.userContextPerUserId.size());

        System.out.println("-------------------- Thread Local Implementation ----------------------- ");
        ThreadLocalWithUserContext r3 = new ThreadLocalWithUserContext( 3 );
        ThreadLocalWithUserContext r4 = new ThreadLocalWithUserContext( 4 );

        Thread t3 = new Thread( r3 );
        Thread t4 = new Thread( r4 );

        t3.start();
        t4.start();

        t3.join();
        t4.join();
    }
}
