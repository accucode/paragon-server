/*
  Copyright (c) 2005-2013 www.kodemore.com

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

package com.kodemore.utility;

import java.util.Random;

/**
 * I provide a convenience wrapper for access to random values.
 */
public class KmRandom
{
    //##################################################
    //# constants
    //##################################################

    private static final Random _random        = new Random();

    private static final String UNSAFE_LETTERS = "AEIOUVY";

    //##################################################
    //# accessing
    //##################################################

    /**
     * Return a random byte in the range -128..127.
     */
    public static byte getByte()
    {
        return getBytes(1)[0];
    }

    /**
     * Return an array of random bytes.  The length of the array
     * is passed as a parameter.
     */
    public static byte[] getBytes(int n)
    {
        byte[] arr = new byte[n];
        _random.nextBytes(arr);
        return arr;
    }

    /**
     * Return a random integer.
     */
    public static int getInteger()
    {
        return _random.nextInt();
    }

    /**
     * Return a random integer greater than zero.
     */
    public static int getPositiveInteger()
    {
        return getInteger(Integer.MAX_VALUE) + 1;
    }

    /**
     * Return a random integer in the range 1..n-1;
     */
    public static int getPositiveInteger(int n)
    {
        return getInteger(n - 1) + 1;
    }

    /**
     * Return a random integer in the range 0..n-1
     */
    public static int getInteger(int n)
    {
        return _random.nextInt(n);
    }

    /**
     * Return a random long.
     */
    public static long getLong()
    {
        return _random.nextLong();
    }

    /**
     * Return a random boolean.
     */
    public static boolean getBoolean()
    {
        return _random.nextBoolean();
    }

    /**
     * Return a random character.
     */
    public static char getCharacter()
    {
        return (char)getInteger();
    }

    /**
     * Return a random character in the ASCII range 32..126.
     */
    public static char getPrintableCharacter()
    {
        int min = 33;
        int max = 126;
        return getCharacterInRange(min, max);
    }

    /**
     * Return a random character in the ASCII range 97..122.
     */
    public static char getLowerCaseCharacter()
    {
        int min = 97;
        int max = 122;
        return getCharacterInRange(min, max);
    }

    /**
     * Return a random character in the ASCII range 65..90.
     */
    public static char getUpperCaseCharacter()
    {
        int min = 65;
        int max = 90;
        return getCharacterInRange(min, max);
    }

    /**
     * Return a String of random characters with a length of n.  All
     * characters will be in the ASCII range of 32..126.
     */
    public static String getPrintableString(int n)
    {
        StringBuilder sb = new StringBuilder(n);
        for ( int i = 0; i < n; i++ )
            sb.append(getPrintableCharacter());
        return sb.toString();
    }

    /**
     * Return a String of random characters with a length of n.  All
     * characters will be in the ASCII range of 97..122.
     */
    public static String getLowerCaseString(int n)
    {
        StringBuilder sb = new StringBuilder(n);
        for ( int i = 0; i < n; i++ )
            sb.append(getLowerCaseCharacter());
        return sb.toString();
    }

    /**
     * Return a String of random characters with a length of n.  All
     * characters will be in the ASCII range of 65..90.
     */
    public static String getUpperCaseString(int n)
    {
        StringBuilder sb = new StringBuilder(n);
        for ( int i = 0; i < n; i++ )
            sb.append(getUpperCaseCharacter());
        return sb.toString();
    }

    /**
     * Get a 'safe' uppercase string.  Safe strings are used for random
     * passwords and tokens that are displayed to users.  By leaving certain
     * letters, we avoid generating words that are offensive.  Specifically,
     * we do not use any of the following letters: aeiouvy
     */
    public static String getSafeUpperCaseString(int n)
    {
        StringBuilder sb = new StringBuilder(n);
        for ( int i = 0; i < n; i++ )
            sb.append(getSafeUpperCaseCharacter());
        return sb.toString();
    }

    public static char getSafeUpperCaseCharacter()
    {
        while ( true )
        {
            char c = getUpperCaseCharacter();
            if ( UNSAFE_LETTERS.indexOf(c) < 0 )
                return c;
        }
    }

    /**
     * Get a 'safe' lowercase string.  Safe strings are used for random
     * passwords and tokens that are displayed to users.  By leaving certain
     * letters, we avoid generating words that are offensive.  Specifically,
     * we do not use any of the following letters: aeiouvy
     */
    public static String getSafeLowerCaseString(int n)
    {
        return getSafeUpperCaseString(n).toLowerCase();
    }

    public static String getDigits(int n)
    {
        StringBuilder sb = new StringBuilder(n);
        for ( int i = 0; i < n; i++ )
            sb.append(getDigit());
        return sb.toString();
    }

    public static char getDigit()
    {
        int min = 48;
        int max = 57;
        return getCharacterInRange(min, max);
    }

    /**
     * Return a random double.
     */
    public static double getDouble()
    {
        return _random.nextDouble();
    }

    /**
     * Get single character in the range min-max, inclusive.
     */
    private static char getCharacterInRange(int min, int max)
    {
        return (char)(getInteger(max - min + 1) + min);
    }
}
