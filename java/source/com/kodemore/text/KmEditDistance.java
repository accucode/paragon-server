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

/**
 * I estimate the similarity or difference between two strings.
 * A distance of 0 means the strings are the same.
 * A distance of 1 means only one character must be changed for the strings to match.
 */
public class KmEditDistance
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        System.out.println("Edit Distance Test");
        print("cat", "cat");
        print("cat", "hat");
        print("cat", "at");
        print("cat", "cate");
        print("cat", "bait");
        print("cat", "kitten");
    }

    private static void print(String a, String b)
    {
        System.out.printf("%s => %s = %s%n", a, b, getEditDistance(a, b));
    }

    //##################################################
    //# edit distance
    //##################################################

    /**
     * Compute the edit distance between two strings.
     * This is the number of changes required to convert one string into the other.
     */
    public static int getEditDistance(String s, String t)
    {
        int arr[][]; // matrix
        int sn; // length of s
        int tn; // length of t
        int si; // index of s
        int ti; // index of t
        char sc; // ith character of s
        char tc; // ith character of t
        int cost; // cost

        sn = s.length();
        tn = t.length();

        if ( sn == 0 )
            return tn;

        if ( tn == 0 )
            return sn;

        arr = new int[sn + 1][tn + 1];

        for ( si = 0; si <= sn; si++ )
            arr[si][0] = si;

        for ( ti = 0; ti <= tn; ti++ )
            arr[0][ti] = ti;

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

                int temp1 = arr[si - 1][ti] + 1;
                int temp2 = arr[si][ti - 1] + 1;
                int temp3 = arr[si - 1][ti - 1] + cost;

                arr[si][ti] = min(temp1, temp2, temp3);
            }
        }
        return arr[sn][tn];
    }

    private static int min(int a, int b, int c)
    {
        return Math.min(a, Math.min(b, c));
    }

}
