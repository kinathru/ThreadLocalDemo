package com.kinath.learning.baeldung;

/**
 * Created by kinath on 15/01/2018.
 */
public class ThreadLocalWithUserContext implements Runnable
{
    public static ThreadLocal<Context> contextThreadLocal = new ThreadLocal<Context>();
    int userId;

    public void run()
    {
        Context context = new Context( UserRepository.getUserNameForUserId( userId ) );
        contextThreadLocal.set( context );
        System.out.println( "thread context for given userId: " + userId + " is: " + contextThreadLocal.get() );
    }

    public ThreadLocalWithUserContext( int userId )
    {
        this.userId = userId;
    }
}
