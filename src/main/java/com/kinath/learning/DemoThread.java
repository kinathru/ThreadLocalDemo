package com.kinath.learning;

/**
 * Created by kinath on 15/01/2018.
 */
public class DemoThread extends Thread
{
    private ThreadLocal<String> threadLocal;
    private String normalField;

    @Override public void run()
    {
        System.out.println( "Value of Thread Local is : " + threadLocal.get() );
        System.out.println( "Value of Normal Field is : " + normalField );
    }

    public ThreadLocal<String> getThreadLocal()
    {
        return threadLocal;
    }

    public void setThreadLocal( ThreadLocal<String> threadLocal )
    {
        this.threadLocal = threadLocal;
    }

    public String getNormalField()
    {
        return normalField;
    }

    public void setNormalField( String normalField )
    {
        this.normalField = normalField;
    }
}
