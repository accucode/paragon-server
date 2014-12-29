package com.kodemore.tools;

public class KmMemoryPrintTool
{
    public static void main(String[] args)
    {
        System.out.println("Runtime Memory Stats");

        System.out.println();
        printDescriptions();

        System.out.println();
        printValues();
    }

    public static void printDescriptions()
    {
        System.out.println(""
            + "Max:   "
            + "The maximum amount of memory that "
            + "the virtual machine will attempt to use.");

        System.out.println(""
            + "Total: "
            + "the total amount of memory currently "
            + "available for current and future objects.");

        System.out.println(""
            + "Free:  "
            + "An approximation to the total amount of memory "
            + "currently available for future allocated objects.");

        System.out.println("Used:  Total - Free.");
    }

    private static void printValues()
    {
        int mg = 1024 * 1024;

        Runtime rt = Runtime.getRuntime();
        long max = rt.maxMemory() / mg;
        long total = rt.totalMemory() / mg;
        long free = rt.freeMemory() / mg;
        long used = total - free;

        System.out.printf("Max:   %,5d MB\n", max);
        System.out.printf("Total: %,5d MB\n", total);
        System.out.printf("Free:  %,5d MB\n", free);
        System.out.printf("Used:  %,5d MB\n", used);
    }
}
