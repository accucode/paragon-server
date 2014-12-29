package com.kodemore.javaParser;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

/**
 * Some simple methods for parsing java source files.
 * This is NOT intended to be robust or reliable.  It
 * is only intended for some simple cases.
 */
public class KmJavaParser
    extends KmParser
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public void setSource(String s)
    {
        super.setSource(removeComments(s));
    }

    //##################################################
    //# remove comments
    //##################################################

    private String removeComments(String s)
    {
        StringBuilder out = new StringBuilder();

        while ( true )
        {
            int a = s.indexOf("//");
            int b = s.indexOf("/*");
            int c = next(a, b);
            if ( c < 0 )
                break;

            out.append(s.substring(0, c));
            s = s.substring(c);

            if ( a == c )
            {
                int x = s.indexOf("\r");
                int y = s.indexOf("\n");
                int z = next(x, y);

                if ( z < 0 )
                    break;

                s = s.substring(z);
                continue;
            }

            int j = s.indexOf("*/");
            if ( j < 0 )
                break;

            s = s.substring(j + 2);
        }

        out.append(s);
        return out.toString();
    }

    private int next(int a, int b)
    {
        if ( a < 0 )
            return b;

        if ( b < 0 )
            return a;

        return Math.min(a, b);
    }

    //##################################################
    //# class
    //##################################################

    public boolean isAbstract()
    {
        return getSource().contains("abstract class");
    }

    //##################################################
    //# methods
    //##################################################

    public String getExtends()
    {
        resetIndex();
        skipThrough("class");
        skipUntil("{");

        int bodyIndex = getIndex();

        resetIndex();
        skipThrough("extends");

        if ( isEnd() )
            return null;

        if ( getIndex() > bodyIndex )
            return null;

        int extendsBegin = getIndex();

        skipUntil("implements");

        int extendsEnd;

        if ( isEnd() || getIndex() > bodyIndex )
            extendsEnd = bodyIndex;
        else
            extendsEnd = getIndex();

        return getSubstring(extendsBegin, extendsEnd).trim();
    }

    public KmList<KmJavaMethod> getPublishedMethods()
    {
        KmList<KmJavaMethod> v = new KmList<>();
        resetIndex();

        while ( true )
        {
            KmJavaMethod e = getNextPublishedMethod();

            if ( e == null )
                break;

            v.add(e);
        }

        return v;
    }

    private KmJavaMethod getNextPublishedMethod()
    {
        while ( true )
        {
            if ( isEnd() )
                return null;

            if ( !skipThrough("@KmServicePublish") )
                return null;

            String s;
            s = readUntilAny("{;");
            s = s.trim();

            if ( s.endsWith(")") )
            {
                KmJavaMethod m = parseMethod(s);

                if ( m != null )
                    return m;
            }
        }
    }

    public KmList<KmJavaMethod> getPublicMethods()
    {
        KmList<KmJavaMethod> v = new KmList<>();

        resetIndex();
        skipThrough("class");

        while ( true )
        {
            KmJavaMethod e = getNextPublicMethod();

            if ( e == null )
                break;

            v.add(e);
        }
        return v;
    }

    private KmJavaMethod getNextPublicMethod()
    {
        while ( true )
        {
            if ( isEnd() )
                return null;

            if ( !skipUntil("public") )
                return null;

            String s;
            s = readUntilAny("{;");
            s = s.trim();
            if ( s.endsWith(")") )
            {
                KmJavaMethod m = parseMethod(s);
                if ( m != null )
                    return m;
            }
        }
    }

    private KmJavaMethod parseMethod(String source)
    {
        int i;
        String[] arr;
        KmJavaMethod m = new KmJavaMethod();

        String s;
        s = source;
        s = Kmu.removePrefix(s, "public");
        s = s.trim();

        if ( s.startsWith("static") )
            return null;

        if ( s.contains(" class ") )
            return null;

        i = s.indexOf("(");
        if ( i < 0 )
            error("Cannot find open parenthesis in: " + source);

        String params = s.substring(i);

        s = s.substring(0, i);
        arr = s.split(" ");

        if ( arr.length == 1 )
            return null; // constructor

        if ( arr.length != 2 )
            error("Expected to find exactly two tokens (return & name) before open parenthesis in: "
                + source);

        m.setReturnType(arr[0]);
        m.setName(arr[1]);

        params = Kmu.removePrefix(params, "(");
        params = Kmu.removeSuffix(params, ")");

        arr = params.split(",");

        KmList<String> v;
        v = new KmList<>();
        v.addAll(arr);

        Kmu.trimValues(v);
        Kmu.removeEmptyValues(v);

        for ( String p : v )
        {
            arr = p.split(" ");

            if ( arr.length != 2 )
                error("Expected parameter (%s), to split into two parts.", p);

            m.addArgument(arr[1], arr[0]);
        }

        return m;
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isComment()
    {
        return isLineComment() || isBlockComment();
    }

    public boolean isLineComment()
    {
        return is("//");
    }

    public boolean isBlockComment()
    {
        return is("/*");
    }

    //##################################################
    //# annotations
    //##################################################

    public String getFirstAnnotationString(String key)
    {
        resetIndex();
        key = "@" + key;
        if ( !skipThrough(key) )
            return null;

        String s;
        s = readUntilEol();
        s = s.trim();
        s = Kmu.removePrefix(s, "(");
        s = Kmu.removeSuffix(s, ")");
        s = s.trim();

        if ( Kmu.isEmpty(s) )
            return "";

        s = Kmu.removePrefix(s, QUOTE + "");
        s = Kmu.removeSuffix(s, QUOTE + "");
        return s;
    }

    public Integer getFirstAnnotationInteger(String key)
    {
        resetIndex();
        key = "@" + key;

        if ( !skipThrough(key) )
            return null;

        String s;
        s = readUntilEol();
        s = s.trim();
        s = Kmu.removePrefix(s, "(");
        s = Kmu.removeSuffix(s, ")");
        s = s.trim();

        return Kmu.parseInteger(s);
    }

    //##################################################
    //# utility
    //##################################################

    private void error(String msg, Object... args)
    {
        Kmu.fatal(msg, args);
    }

}
