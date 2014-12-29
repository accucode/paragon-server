package com.app.ui.control;

public abstract class MyListener
{
    public final void run()
    {
        handle();
    }

    protected abstract void handle();
}
