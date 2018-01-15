package com.kinath.learning.baeldung;

/**
 * Created by kinath on 15/01/2018.
 */
public class Context
{
    String userName;

    public Context( String userName )
    {
        this.userName = userName;
    }

    @Override public String toString()
    {
        return "Context{" + "userName='" + userName + '\'' + '}';
    }
}
