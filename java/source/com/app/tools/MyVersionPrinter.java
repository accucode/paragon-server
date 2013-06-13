package com.app.tools;

import com.app.utility.MyConstantsIF;

public class MyVersionPrinter
{
    public static void main(String[] args)
    {
        System.out.printf(
            "%s (%s)\n",
            MyConstantsIF.APPLICATION_NAME,
            MyConstantsIF.APPLICATION_VERSION);
    }
}
