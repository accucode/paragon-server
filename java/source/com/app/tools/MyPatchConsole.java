package com.app.tools;

import com.kodemore.patch.KmPatchConsole;

import com.app.utility.MyInstaller;

public class MyPatchConsole
    extends KmPatchConsole
{
    public static void main(String[] args)
    {
        // requires jdbc but NOT hibernate.
        // see MyPatchBridge.
        MyInstaller.installJdbc();

        new MyPatchConsole().run(args);
    }
}
