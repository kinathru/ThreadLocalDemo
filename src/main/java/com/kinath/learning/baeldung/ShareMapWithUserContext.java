package com.kinath.learning.baeldung;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by kinath on 15/01/2018.
 */
public class ShareMapWithUserContext implements Runnable
{
    public static Map<Integer, Context > userContextPerUserId = new ConcurrentHashMap<Integer, Context>();
    private int userId;

    public void run()
    {
        String userName = UserRepository.getUserNameForUserId( userId );
        userContextPerUserId.put( userId, new Context( userName ) );

        try
        {
            Thread.sleep( 1000 );
        }
        catch( InterruptedException e )
        {
            e.printStackTrace();
        }

        System.out.println( userName + " " + userId );
    }

    public ShareMapWithUserContext( int userId )
    {
        this.userId = userId;
    }
}
