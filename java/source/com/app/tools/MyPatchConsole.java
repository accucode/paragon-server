package com.app.tools;

import com.app.utility.MyInstaller;

import com.kodemore.patch.KmPatchConsole;

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
