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

/**
 * I implement the SoundEx alghorithm.
 *
 * This is a relatively old implementation, and is NOT optimized.
 * Apache now how a standard library that we should consider adopting.
 * See KmTextUtilities.
 *
 * For the purpose of this implementation...
 *      Vowels refer to: A, E, I, O, U, Y
 *      Silents refer to A, H
 *
 * http://en.wikipedia.org/wiki/Soundex
 */
public class KmSoundexOld
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        System.out.println("Soundex Test");
        verify("Allricht", "A462");
        verify("Eberhard", "E166");
        verify("Hanselmann", "H524");
        verify("Heimbach", "H512");
        verify("Kavanagh", "K152");
        verify("Lind", "L530");
        verify("Lukaschowsky", "L222");
        verify("McDonnell", "M235");
        verify("McGee", "M200");
        verify("O'Brien", "O165");
        verify("Oppenheimer", "O155");
        verify("Riedemanas", "R355");
        verify("Schafer", "S160");
        verify("Shaeffer", "S160");
        verify("Zita", "Z300");
        verify("Zitzmeinn", "Z325");
        verify("Tomzak", "T522");
        verify("Roses", "R220");
        verify("Ashcroft", "A261");
        verify("Carwruth", "C630");
    }

    private static void verify(String word, String expected)
    {
        String actual = compute(word);

        String result = expected.equals(actual)
            ? "ok"
            : "ERROR, expected " + expected;

        System.out.printf("%s => %s (%s)\n", word, actual, result);
    }

    //##################################################
    //# soundex
    //##################################################

    /**
     * Compute the soundex for the word.
     */
    public static String compute(String s)
    {
        s = s.trim().toUpperCase();

        String first = s.substring(0, 1);

        // base letters: BCDLMR, AH
        s = toBase(s);

        // collapse double letters
        s = s.replaceAll("BB", "B");
        s = s.replaceAll("CC", "C");
        s = s.replaceAll("DD", "D");
        s = s.replaceAll("LL", "L");
        s = s.replaceAll("MM", "M");
        s = s.replaceAll("RR", "R");
        s = s.replaceAll("AA", "A");
        s = s.replaceAll("HH", "H");

        // if the same sound repeats separated by a VOWEL, treat it as a DOUBLE letter.
        s = s.replaceAll("BAB", "BB");
        s = s.replaceAll("CAC", "CC");
        s = s.replaceAll("DAD", "DD");
        s = s.replaceAll("LAL", "LL");
        s = s.replaceAll("MAM", "MM");
        s = s.replaceAll("RAR", "RR");

        // if the same sound repeats separated by a SILENT, treat it as a SINGLE letter.
        s = s.replaceAll("BHB", "B");
        s = s.replaceAll("CHC", "C");
        s = s.replaceAll("DHD", "D");
        s = s.replaceAll("LHL", "L");
        s = s.replaceAll("MHM", "M");
        s = s.replaceAll("RHR", "R");

        // remove first letter
        s = s.substring(1);

        // remove vowels, silents, and any miscellaneous punctuation.
        s = s.replaceAll("A", "");
        s = s.replaceAll("H", "");
        s = s.replaceAll("0", "");
        s = toDigits(s);

        // add the first letter back.
        s = first + s;

        // force the result to exactly 4 characters.
        s = normalizeLength(s);

        return s;
    }

    private static String normalizeLength(String s)
    {
        int n = 4;

        while ( s.length() < n )
            s += "0";

        if ( s.length() > n )
            s = s.substring(0, n);

        return s;
    }

    private static String toBase(String s)
    {
        StringBuilder out = new StringBuilder();

        for ( char c : s.toCharArray() )
            out.append(toBase(c));

        return out.toString();
    }

    private static String toDigits(String s)
    {
        StringBuilder out = new StringBuilder();

        for ( char c : s.toCharArray() )
            out.append(toDigit(c));

        return out.toString();
    }

    private static char toBase(char c)
    {
        switch ( c )
        {
            case 'B':
            case 'F':
            case 'P':
            case 'V':
                return 'B';

            case 'C':
            case 'G':
            case 'J':
            case 'K':
            case 'Q':
            case 'S':
            case 'X':
            case 'Z':
                return 'C';

            case 'D':
            case 'T':
                return 'D';

            case 'L':
                return 'L';

            case 'M':
            case 'N':
                return 'M';

            case 'R':
                return 'R';

            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
            case 'Y':
                return 'A';

            case 'H':
            case 'W':
                return 'H';
        }

        return '0';
    }

    private static char toDigit(char c)
    {
        switch ( c )
        {
            case 'B':
                return '1';

            case 'C':
                return '2';

            case 'D':
                return '3';

            case 'L':
                return '4';

            case 'M':
                return '5';

            case 'R':
                return '6';
        }

        return '0';
    }
}
