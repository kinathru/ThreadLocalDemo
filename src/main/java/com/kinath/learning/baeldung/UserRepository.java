package com.kinath.learning.baeldung;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kinath on 15/01/2018.
 */
public class UserRepository
{
    private static Map<Integer, String> userNameMap = new HashMap<Integer, String>();

    static
    {
        userNameMap.put( 1, "John" );
        userNameMap.put( 2, "Jack" );
        userNameMap.put( 3, "Emma" );
        userNameMap.put( 4, "Will" );
        userNameMap.put( 5, "Snow" );
    }

    public static String getUserNameForUserId(int userId)
    {
        return userNameMap.get( userId );
    }
}
