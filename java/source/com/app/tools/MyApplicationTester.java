package com.app.tools;

import com.kodemore.log.KmLog;
import com.kodemore.utility.Kmu;

import com.app.utility.MyInstaller;

/**
 * I run a variety of tests for the application.
 */
public class MyApplicationTester
{
    //##################################################
    //# run
    //##################################################

    public static void run()
    {
        printLine();
        validateDomainHierarchy();
    }

    //##################################################
    //# tests
    //##################################################

    private static void validateDomainHierarchy()
    {
        KmLog.printfln("Validate domain hierarchy...");
        MyDomainHierarchyValidatorTool.run();
        KmLog.printfln("Validate domain hierarchy, done.");
    }

    //##################################################
    //# utility
    //##################################################

    private static void printLine()
    {
        KmLog.printfln(Kmu.repeat("-", 40));
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        MyInstaller.installDatabase();
        KmLog.printfln(Kmu.repeat("=", 40));
        KmLog.printfln("Application tests, starting...");

        MyApplicationTester.run();

        KmLog.printfln("Application tests, done.");
        System.out.println("ok.");
    }
}
