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
    }
}
