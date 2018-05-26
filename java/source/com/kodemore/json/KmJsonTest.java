package com.kodemore.json;

/**
 * I provide a simple test for the json tools.
 *
 * The general process is as follows:
 *      1) Create a complex json object that includes samples of each data type.
 *          Include all the primitive (and nulls).
 *          Include both empty and nested collections (arrays and maps).
 *      2) Format the json object normally.
 *      3) Format the json object using the pretty printer.
 *      4) Make sure the pretty printed string is parsable.
 */
public class KmJsonTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String... args)
    {
        new KmJsonTest().run();
    }

    //##################################################
    //# run
    //##################################################

    private void run()
    {
        KmJsonMap top = newTestValue();

        String pretty1 = top.prettyPrint();

        System.out.println("----------------------------------------");
        System.out.println(pretty1);
        System.out.println("----------------------------------------");

        String pretty2 = KmJsonReader.parseJsonMap(pretty1).prettyPrint();
        if ( pretty1.equals(pretty2) )
            System.out.println("match");
        else
            System.out.println(pretty2);

        System.out.println("----------------------------------------");
    }

    private KmJsonMap newTestValue()
    {
        KmJsonArray nestedArray;
        nestedArray = newSimpleArray();
        nestedArray.addArray(newSimpleArray());
        nestedArray.addMap(newSimpleMap());

        KmJsonMap top;
        top = newSimpleMap();
        top.setMap("nestedMap", newSimpleMap());
        top.setArray("nestedArray", nestedArray);
        return top;
    }

    private KmJsonMap newSimpleMap()
    {
        KmJsonMap e;
        e = new KmJsonMap();
        e.setNull("n");
        e.setBoolean("b", true);
        e.setInteger("i", 1);
        e.setDouble("d", 2.2);
        e.setString("s", "hello");
        e.setArray("a");
        e.setMap("m");
        return e;
    }

    private KmJsonArray newSimpleArray()
    {
        KmJsonArray e;
        e = new KmJsonArray();
        e.addNull();
        e.addBoolean(true);
        e.addInteger(1);
        e.addDouble(2.2);
        e.addString("hello");
        e.addArray();
        e.addMap();
        return e;
    }
}
