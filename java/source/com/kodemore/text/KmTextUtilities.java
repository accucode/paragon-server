/*
  Copyright (c) 2005-2016 www.kodemore.com

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
 */

package com.kodemore.text;

import org.apache.commons.codec.language.DoubleMetaphone;
import org.apache.commons.codec.language.Metaphone;
import org.apache.commons.codec.language.Soundex;

/**
 * I provide access to various text utilities.
 * Mostly, I just delegate to other tools and libraries.
 */
public class KmTextUtilities
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        System.out.println("Soundex");
        printSoundex("Robert");
        printSoundex("Rupert");

        System.out.println();
        System.out.println("Metaphone");
        printMetaphone("Robert");
        printMetaphone("Rupert");
        printMetaphone("Candy");
        printMetaphone("Chocolate");

        System.out.println();
        System.out.println("Double Metaphone");
        printDoubleMetaphone("Robert");
        printDoubleMetaphone("Rupert");
        printDoubleMetaphone("Candy");
        printDoubleMetaphone("Chocolate");

        System.out.println();
        System.out.println("Edit Distance");
        printEditDistance("Cat", "Cat");
        printEditDistance("Dog", "Mouse");
        printEditDistance("Robert", "Rupert");
    }

    private static void printSoundex(String s)
    {
        System.out.printf("%s => %s%n", s, soundex(s));
    }

    private static void printMetaphone(String s)
    {
        System.out.printf("%s => %s%n", s, metaphone(s));
    }

    private static void printDoubleMetaphone(String s)
    {
        System.out.printf("%s => %s%n", s, doubleMetaphone(s));
    }

    private static void printEditDistance(String a, String b)
    {
        System.out.printf("%s, %s => %s%n", a, b, editDistance(a, b));
    }

    //##################################################
    //# tools
    //##################################################

    /**
     * The soundex algorithm.
     * Primarily used for indexing proper names by sound.
     * E.g.: both Robert and Rupert => R163.
     *
     * http://en.wikipedia.org/wiki/Soundex
     */
    public static String soundex(String s)
    {
        return new Soundex().encode(s);
    }

    /**
     * The metaphone alghorithm.
     * This is an improvement over soundex and is generally applicable for
     * all words, not just names.
     *
     * http://en.wikipedia.org/wiki/Metaphone
     */
    public static String metaphone(String s)
    {
        return new Metaphone().encode(s);
    }

    /**
     * The metaphone alghorithm.
     * This improves over the original metaphone.
     * It uses a much more complex ruleset.
     *
     * http://en.wikipedia.org/wiki/Metaphone
     */
    public static String doubleMetaphone(String s)
    {
        return new DoubleMetaphone().encode(s);
    }

    /**
     * Compute the Levenshtein "edit" distance. This is the number of changes
     * necessary to convert one string into the other.
     */
    public static int editDistance(String s, String t)
    {
        int d[][]; // matrix
        int sn; // length of s
        int tn; // length of t
        int si; // iterates through s
        int ti; // iterates through t
        char sc; // ith character of s
        char tc; // ith character of t
        int cost; // cost

        sn = s.length();
        tn = t.length();

        if ( sn == 0 )
            return tn;

        if ( tn == 0 )
            return sn;

        d = new int[sn + 1][tn + 1];

        for ( si = 0; si <= sn; si++ )
            d[si][0] = si;

        for ( ti = 0; ti <= tn; ti++ )
            d[0][ti] = ti;

        for ( si = 1; si <= sn; si++ )
        {
            sc = s.charAt(si - 1);
            for ( ti = 1; ti <= tn; ti++ )
            {
                tc = t.charAt(ti - 1);
                if ( sc == tc )
                    cost = 0;
                else
                    cost = 1;
                d[si][ti] = min(d[si - 1][ti] + 1, d[si][ti - 1] + 1, d[si - 1][ti - 1] + cost);
            }
        }
        return d[sn][tn] + Math.abs(tn - sn);
    }

    /**
     * Compute the Levenshtein "edit" distance. This is the number of changes
     * necessary to convert one string into the other.
     */
    public static double adjustedEditDistance(String s, String t)
    {
        double d[][]; // matrix
        int sn; // length of s
        int tn; // length of t
        int si; // iterates through s
        int ti; // iterates through t
        char sc; // ith character of s
        char tc; // ith character of t
        int cost; // cost

        sn = s.length();
        tn = t.length();
        if ( sn == 0 )
            return tn * 1.01;
        if ( tn == 0 )
            return sn * 1.01;

        d = new double[sn + 1][tn + 1];

        for ( si = 0; si <= sn; si++ )
            d[si][0] = si;

        for ( ti = 0; ti <= tn; ti++ )
            d[0][ti] = ti;

        for ( si = 1; si <= sn; si++ )
        {
            sc = s.charAt(si - 1);
            for ( ti = 1; ti <= tn; ti++ )
            {
                tc = t.charAt(ti - 1);
                if ( sc == tc )
                    cost = 0;
                else
                    cost = 1;
                d[si][ti] = min(d[si - 1][ti] + 1, d[si][ti - 1] + 1, d[si - 1][ti - 1] + cost);
            }
        }
        return d[sn][tn] + Math.abs(tn - sn) * 0.01;
    }

    //##################################################
    //# support
    //##################################################

    private static int min(int a, int b, int c)
    {
        return Math.min(Math.min(a, b), c);
    }

    private static double min(double a, double b, double c)
    {
        return Math.min(Math.min(a, b), c);
    }

}
