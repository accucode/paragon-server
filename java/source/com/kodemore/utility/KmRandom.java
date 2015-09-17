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

package com.kodemore.utility;

import java.util.List;
import java.util.Random;

/**
 * I provide a convenience wrapper for access to random values.
 */
public class KmRandom
{
    //##################################################
    //# instance
    //##################################################

    private static final KmRandom _instance = new KmRandom();

    /**
     * A single instance shared across all threads.  Although thread-safe
     * clients that rely heavily on randoms should consider creating separate
     * instances to avoid contention.
     */
    public static final KmRandom getInstance()
    {
        return _instance;
    }

    //##################################################
    //# constants
    //##################################################

    /**
     * The 26 american ascii letters a..z.
     */
    private static final String LOWER_STRING = "abcdefghijklmnopqrstuvwxyz";
    private static final char[] LOWER_ARRAY  = LOWER_STRING.toCharArray();

    /**
     * The 26 american ascii letters A..Z.
     */
    private static final String UPPER_STRING = LOWER_STRING.toUpperCase();
    private static final char[] UPPER_ARRAY  = UPPER_STRING.toCharArray();

    /**
     * The combination of all upper and lower-case letters.
     */
    private static final String ALPHA_STRING = LOWER_STRING + UPPER_STRING;
    private static final char[] ALPHA_ARRAY  = ALPHA_STRING.toCharArray();

    /**
     * The 10 digits 0..9.
     */
    private static final String DIGIT_STRING = "0123456789";
    private static final char[] DIGIT_ARRAY  = DIGIT_STRING.toCharArray();

    /**
     * The combination of all letters and digits.
     */
    private static final String ALPHA_NUMERIC_STRING = ALPHA_STRING + DIGIT_STRING;
    private static final char[] ALPHA_NUMERIC_ARRAY  = ALPHA_NUMERIC_STRING.toCharArray();

    /**
     * The standard (lower) ascii symbols, the ones found on a typical keyboard.
     */
    private static final String SYMBOL_STRING = "`~!@#$%^&*()-_=+[]{}|;:,.<>/?'\"\\";
    private static final char[] SYMBOL_ARRAY  = SYMBOL_STRING.toCharArray();

    /**
     * A list of letters that are relatively safe to use in auto-generated
     * passwords and such.  We leave out all of the vowels (and y) to avoid
     * accidentally generating undesirable results (such as curse words).
     */
    private static final char[] SAFE_ARRAY = "BCDFGHJKLMNPQRSTVWXZ".toCharArray();

    //##################################################
    //# variables
    //##################################################

    private Random _random;

    //##################################################
    //# constructor
    //##################################################

    public KmRandom()
    {
        _random = new Random();
    }

    public KmRandom(long seed)
    {
        _random = new Random(seed);
    }

    //##################################################
    //# basics
    //##################################################

    /**
     * Return a random byte in the range -128..127.
     */
    public byte getByte()
    {
        return getBytes(1)[0];
    }

    /**
     * Return an array of random bytes.
     */
    public byte[] getBytes(int n)
    {
        byte[] arr = new byte[n];
        _random.nextBytes(arr);
        return arr;
    }

    /**
     * Return a random integer.
     */
    public int getInteger()
    {
        return _random.nextInt();
    }

    /**
     * Return a random integer greater than zero.
     */
    public int getPositiveInteger()
    {
        return getInteger(Integer.MAX_VALUE - 1) + 1;
    }

    /**
     * Return a random integer in the range 1..n-1;
     */
    public int getPositiveInteger(int n)
    {
        return getInteger(n - 1) + 1;
    }

    /**
     * Return a random integer in the range 0..n-1
     */
    public int getInteger(int n)
    {
        return _random.nextInt(n);
    }

    /**
     * Return a random long.
     */
    public long getLong()
    {
        return _random.nextLong();
    }

    /**
     * Return a random boolean.
     */
    public boolean getBoolean()
    {
        return _random.nextBoolean();
    }

    /**
     * Return a random double.
     */
    public double getDouble()
    {
        return _random.nextDouble();
    }

    //##################################################
    //# characters
    //##################################################

    /**
     * Return a random character.
     */
    public char getCharacter()
    {
        return (char)getInteger();
    }

    /**
     * Return a random character in the ASCII range 32..126.
     */
    public char getPrintableCharacter()
    {
        int min = 33;
        int max = 126;
        return getCharacterInRange(min, max);
    }

    /**
     * Return a random character a..z.
     */
    public char getLowerCaseCharacter()
    {
        return getCharacterIn(LOWER_ARRAY);
    }

    /**
     * Return a random character in the ASCII range 65..90.
     */
    public char getUpperCaseCharacter()
    {
        return getCharacterIn(UPPER_ARRAY);
    }

    public char getDigit()
    {
        return getCharacterIn(DIGIT_ARRAY);
    }

    public char getCharacterIn(char[] chars)
    {
        return chars[getInteger(chars.length)];
    }

    /**
     * Get single character in the ascii range min-max, inclusive.
     */
    public char getCharacterInRange(int min, int max)
    {
        return (char)(getInteger(max - min + 1) + min);
    }

    //##################################################
    //# strings
    //##################################################

    /**
     * Return a String of random characters with a length of n.
     * All characters will be in the ASCII range of 32..126.
     */
    public String getPrintableString(int n)
    {
        StringBuilder out = new StringBuilder(n);

        for ( int i = 0; i < n; i++ )
            out.append(getPrintableCharacter());

        return out.toString();
    }

    /**
     * Return a String of random characters with a length of n.
     * All characters will be in the ASCII range of 97..122.
     */
    public String getLowerString(int n)
    {
        return getRun(LOWER_ARRAY, n);
    }

    /**
     * Return a String of random characters with a length of n.
     * All characters will be in the ASCII range of 65..90.
     */
    public String getUpperString(int n)
    {
        return getRun(UPPER_ARRAY, n);
    }

    /**
     * Return a String of random letters, of length n.
     * This will include both upper and lower case letters.
     */
    public String getAlphaString(int n)
    {
        return getRun(ALPHA_ARRAY, n);
    }

    /**
     * Return a String of random alpha-numeric characters, of length n.
     * This includes both upper and lower case letters, as well as the 10 digits.
     */
    public String getAlphaNumericString(int n)
    {
        return getRun(ALPHA_NUMERIC_ARRAY, n);
    }

    /**
     * Return a String of random symbols, of length n.
     * This includes the lower ascii symbols commonly found on keyboards.
     */
    public String getSymbolString(int n)
    {
        return getRun(SYMBOL_ARRAY, n);
    }

    /**
     * Get a 'safe' uppercase string.  Safe strings are used for random
     * passwords and tokens that are displayed to users.  By leaving certain
     * letters, we avoid generating words that are offensive.  Specifically,
     * we do not use any of the following letters: aeiouvy
     */
    public String getSafeString(int n)
    {
        return getRun(SAFE_ARRAY, n);
    }

    public String getDigits(int n)
    {
        return getRun(DIGIT_ARRAY, n);
    }

    /**
     * Return a string of length n, composed of random characters from the arr.
     */
    public String getRun(char[] arr, int n)
    {
        StringBuilder out = new StringBuilder();

        for ( int i = 0; i < n; i++ )
            out.append(getCharacterIn(arr));

        return out.toString();
    }

    //##################################################
    //# list
    //##################################################

    /**
     * Return a random element from the list.
     */
    public <E> E getElement(List<E> v)
    {
        return v.get(getPositiveInteger(v.size()));
    }
}
