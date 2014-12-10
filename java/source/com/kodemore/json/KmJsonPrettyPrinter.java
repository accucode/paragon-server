package com.kodemore.json;

import java.util.Iterator;

import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.KmConstantsIF;
import com.kodemore.utility.Kmu;

/**
 * I format json values with additional white space to make them more readable.
 * The intent is to still create a valid, parsable, json string, but each value
 * is printed on a separate line, and the contents of arrays and maps are indented.
 */
public class KmJsonPrettyPrinter
{
    //##################################################
    //# static
    //##################################################

    /**
     * Format the json object.
     * Valid values: null, boolean, long, double, string, KmJsonArray, KmJsonMap.
     * 
     * @throws IllegalArgumentException for unhandled types.
     */
    public static String format(Object e)
    {
        return new KmJsonPrettyPrinter().formatValue(e);
    }

    //##################################################
    //# constants
    //##################################################

    private static final char QUOTE     = KmConstantsIF.CHAR_QUOTE;
    private static final char SLASH     = KmConstantsIF.CHAR_SLASH;
    private static final char BACKSLASH = KmConstantsIF.CHAR_BACKSLASH;

    //##################################################
    //# variables
    //##################################################

    private KmStringBuilder   _out;
    private int               _indent;

    //##################################################
    //# constructor
    //##################################################

    private KmJsonPrettyPrinter()
    {
        // private
    }

    //##################################################
    //# format
    //##################################################

    private String formatValue(Object e)
    {
        _out = new KmStringBuilder();
        _indent = 0;

        printValue(e);

        return _out.toString();
    }

    //##################################################
    //# private
    //##################################################

    private void printValue(Object e)
    {
        if ( e == null )
        {
            printNull();
            return;
        }

        if ( e instanceof KmJsonMap )
        {
            printMap((KmJsonMap)e);
            return;
        }

        if ( e instanceof KmJsonArray )
        {
            printArray((KmJsonArray)e);
            return;
        }

        if ( e instanceof String )
        {
            printString((String)e);
            return;
        }

        if ( e instanceof Boolean )
        {
            printBoolean((Boolean)e);
            return;
        }

        if ( e instanceof Long )
        {
            printLong((Long)e);
            return;
        }

        if ( e instanceof Double )
        {
            printDouble((Double)e);
            return;
        }

        throw new IllegalArgumentException("Unhandled type: " + e.getClass().getName());
    }

    private void printArray(KmJsonArray arr)
    {
        if ( arr.isEmpty() )
        {
            printOpenBracket();
            printCloseBracket();
            return;
        }

        printOpenBracket();
        indent();

        Iterator<Object> i = arr.iterator();
        while ( i.hasNext() )
        {
            Object e = i.next();

            println();
            printIndent();
            printValue(e);

            if ( i.hasNext() )
                printComma();
        }

        undent();
        println();
        printIndent();
        printCloseBracket();
    }

    private void printMap(KmJsonMap map)
    {
        if ( map.isEmpty() )
        {
            printOpenBrace();
            printCloseBrace();
            return;
        }

        printOpenBrace();
        indent();

        Iterator<String> keys = map.getSortedKeys().iterator();
        while ( keys.hasNext() )
        {
            String key = keys.next();
            Object value = map.getObject(key);

            println();
            printIndent();
            print(quote(key));
            printColon();

            if ( isMultiline(value) )
            {
                indent();
                println();
                printIndent();
                printValue(value);
                undent();
            }
            else
            {
                printSpace();
                printValue(value);
            }

            if ( keys.hasNext() )
                printComma();
        }

        undent();
        println();
        printIndent();
        printCloseBrace();
    }

    private void printString(String e)
    {
        print(quote(e));
    }

    private void printLong(Long e)
    {
        print(e.toString());
    }

    private void printBoolean(Boolean e)
    {
        print(e.toString());
    }

    private void printDouble(Double e)
    {
        print(e.toString());
    }

    private void printNull()
    {
        print("null");
    }

    //##################################################
    //# formating
    //##################################################

    private void printOpenBrace()
    {
        print("{");
    }

    private void printCloseBrace()
    {
        print("}");
    }

    private void printOpenBracket()
    {
        print("[");
    }

    private void printCloseBracket()
    {
        print("]");
    }

    private void printSpace()
    {
        print(" ");
    }

    private void printComma()
    {
        print(",");
    }

    private void printColon()
    {
        print(":");
    }

    private void print(String e)
    {
        _out.print(e);
    }

    private void println()
    {
        _out.println();
    }

    private void printIndent()
    {
        _out.printSpaces(_indent * 4);
    }

    //##################################################
    //# support
    //##################################################

    private void indent()
    {
        _indent++;
    }

    private void undent()
    {
        _indent--;
    }

    private String quote(String e)
    {
        return QUOTE + escape(e) + QUOTE;
    }

    private String escape(String in)
    {
        KmStringBuilder out = new KmStringBuilder();

        char[] arr = in.toCharArray();
        for ( char c : arr )
            out.print(escape(c));

        return out.toString();
    }

    private String escape(char c)
    {
        if ( c == QUOTE )
            return "" + BACKSLASH + QUOTE;

        if ( c == BACKSLASH )
            return "" + BACKSLASH + BACKSLASH;

        if ( c == SLASH )
            return "" + BACKSLASH + SLASH;

        if ( c == '\b' )
            return "" + BACKSLASH + 'b';

        if ( c == '\f' )
            return "" + BACKSLASH + 'f';

        if ( c == '\n' )
            return "" + BACKSLASH + 'n';

        if ( c == '\r' )
            return "" + BACKSLASH + 'r';

        if ( c == '\t' )
            return "" + BACKSLASH + 't';

        if ( requiresHexadecimal(c) )
        {
            String hex;
            hex = Kmu.formatBase16(c);
            hex = Kmu.leftPad(hex, 4, '0');

            return BACKSLASH + "u" + hex;
        }

        return c + "";
    }

    private boolean requiresHexadecimal(char c)
    {
        return c <= 31 || c >= 127;
    }

    private boolean isMultiline(Object e)
    {
        if ( e instanceof KmJsonObjectIF )
            return ((KmJsonObjectIF)e).isNotEmpty();

        return false;
    }
}
