package com.kodemore.tools;

public class KmMemoryGcTool
{
    public static void main(String[] args)
    {
        System.out.println("Runtime Memory GC");

        System.out.println();
        System.out.println("Before...");
        printValues();

        Runtime.getRuntime().gc();

        System.out.println();
        System.out.println("After...");
        printValues();
    }

    private static void printValues()
    {
        int mg = 1024 * 1024;

        Runtime rt = Runtime.getRuntime();
        long max = rt.maxMemory() / mg;
        long total = rt.totalMemory() / mg;
        long free = rt.freeMemory() / mg;
        long used = total - free;

        System.out.printf("Max:   %,5d MB%n", max);
        System.out.printf("Total: %,5d MB%n", total);
        System.out.printf("Free:  %,5d MB%n", free);
        System.out.printf("Used:  %,5d MB%n", used);
    }
}
