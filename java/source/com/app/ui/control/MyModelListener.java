package com.app.ui.control;

public abstract class MyModelListener<T>
{
    public final void run(T e)
    {
        handle(e);
    }

    protected abstract void handle(T e);
}
