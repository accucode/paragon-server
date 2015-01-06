/*
  Copyright (c) 2005-2014 www.kodemore.com

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

import com.sun.xml.internal.bind.v2.util.EditDistance;

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
     * Determine similar to strings are.  Return the minimum number
     * of characters that need to changed in order to convert one value
     * into the other.
     *
     * http://en.wikipedia.org/wiki/Edit_distance
     */
    public static int editDistance(String a, String b)
    {
        return EditDistance.editDistance(a, b);
    }
}
