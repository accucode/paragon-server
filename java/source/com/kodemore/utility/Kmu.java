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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.collection.KmSetImpl;
import com.kodemore.exception.KmApplicationException;
import com.kodemore.exception.KmCancelException;
import com.kodemore.exception.KmRoleViolationException;
import com.kodemore.file.KmFileUtility;
import com.kodemore.log.KmLog;
import com.kodemore.meta.KmMetaAttribute;
import com.kodemore.string.KmNameTokenizer;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmDateFormatter;
import com.kodemore.time.KmTime;
import com.kodemore.time.KmTimestamp;
import com.kodemore.types.KmDecimal;
import com.kodemore.types.KmKilogram;
import com.kodemore.types.KmMoney;
import com.kodemore.types.KmQuantity;

/**
 * I am a collection of various static methods that are useful in a variety of
 * situations. This class should generally not have any dependencies on other
 * packages.
 */
public class Kmu
    implements KmConstantsIF
{
    //##################################################
    //# constants
    //##################################################

    private static final boolean CHECK_FILE_NAME_CASE = true;

    private static final String  DIGITS               = "0123456789";
    private static final String  UPPERCASE_LETTERS    = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String  LOWERCASE_LETTERS    = "abcdefghijklmnopqrstuvwxyz";

    private static final String  LETTERS              = UPPERCASE_LETTERS + LOWERCASE_LETTERS;
    private static final String  DIGITS_AND_LETTERS   = DIGITS + LETTERS;

    private static final String  HEX_CHAR_STRING      = "0123456789ABCDEF";
    private static final char[]  HEX_CHAR_ARRAY       = HEX_CHAR_STRING.toCharArray();

    private static final String  BASE_62_STRING       = DIGITS
                                                          + UPPERCASE_LETTERS
                                                          + LOWERCASE_LETTERS;
    private static final char[]  BASE_62_ARRAY        = BASE_62_STRING.toCharArray();

    private static final String  BASE_36_STRING       = DIGITS + UPPERCASE_LETTERS;
    private static final char[]  BASE_36_ARRAY        = BASE_36_STRING.toCharArray();

    private static final String  BASE_20_STRING       = "BCDFGHJKLMNPQRSTWXZ";
    private static final char[]  BASE_20_ARRAY        = BASE_20_STRING.toCharArray();

    private static final char    CHAR_CR              = (char)13;
    private static final char    CHAR_LF              = (char)10;
    private static final char    CHAR_NON_PRINTABLE   = '?';

    private static final String  STRING_CR            = "" + CHAR_CR;
    private static final String  STRING_LF            = "" + CHAR_LF;
    private static final String  STRING_CRLF          = "" + CHAR_CR + CHAR_LF;

    private static final String  CHARSET_UTF_8        = "UTF-8";

    private static final String  LIST_SEPARATOR       = ", ";

    //##################################################
    //# parse integer
    //##################################################

    /**
     * Parse an integer and return the value wrapped as an instance. Return null
     * if an error occurs.
     */
    public static Integer parseInteger(String s)
    {
        return parseInteger(s, null);
    }

    /**
     * Parse an integer and return the value wrapped as an instance. Return the
     * default value if an error occurs.
     */
    public static Integer parseInteger(String s, Integer def)
    {
        try
        {
            if ( s == null )
                return def;

            s = s.trim();
            if ( s.length() == 0 )
                return def;

            s = stripLeadingZeros(s);
            if ( s.length() == 0 )
                return 0;

            return new Integer(s);
        }
        catch ( NumberFormatException ex )
        {
            return def;
        }
    }

    /**
     * Parse a string into an integer. If an error occurs, return
     * KmConstantsIF.UNDEFINED_INT.
     */
    public static int parse_int(String s)
    {
        return parse_int(s, UNDEFINED_INT);
    }

    /**
     * Parse a string into an integer. If an error occurs, return the default
     * value.
     */
    public static int parse_int(String s, int def)
    {
        return parseInteger(s, def);
    }

    /**
     * Cast an object to an integer.
     * Null => null.
     * Integer => Integer
     * Long => Integer, iff in Integer range.
     * Otherwise throw an unchecked exception.
     */
    public static Integer toInteger(Object e)
    {
        if ( e == null )
            return null;

        if ( e instanceof Integer )
            return (Integer)e;

        if ( e instanceof Long )
        {
            Long j = (Long)e;
            if ( j >= Integer.MIN_VALUE && j <= Integer.MAX_VALUE )
                return j.intValue();

            throw new RuntimeException("Long out of range: " + j);
        }

        throw new RuntimeException("Invalid type: " + e.getClass().getName());
    }

    //##################################################
    //# parse long
    //##################################################

    /**
     * Parse a long and return the value wrapped as an instance. Return null
     * if an error occurs.
     */
    public static Long parseLong(String s)
    {
        return parseLong(s, null);
    }

    /**
     * Parse a long and return the value wrapped as an instance. Return the
     * default value if an error occurs.
     */
    public static Long parseLong(String s, Long def)
    {
        try
        {
            if ( s == null )
                return def;

            s = s.trim();
            s = stripLeadingZeros(s);
            return new Long(s);
        }
        catch ( NumberFormatException ex )
        {
            return def;
        }
    }

    /**
     * Parse a string into an integer. If an error occurs, return
     * KmConstantsIF.UNDEFINED_LONG.
     */
    public static long parse_long(String s)
    {
        return parse_long(s, UNDEFINED_LONG);
    }

    /**
     * Parse a string into a long. If an error occurs, return the default
     * value.
     */
    public static long parse_long(String s, long def)
    {
        return parseLong(s, def);
    }

    //##################################################
    //# parse double
    //##################################################

    /**
     * Parse a string into a double. If an error occurs, return null.
     */
    public static Double parseDouble(String s)
    {
        return parseDouble(s, null);
    }

    /**
     * Parse a string into a double. If an error occurs, return the default
     * value.
     */
    public static Double parseDouble(String s, Double def)
    {
        try
        {
            if ( s == null )
                return def;

            s = s.trim();
            return new Double(s);
        }
        catch ( NumberFormatException ex )
        {
            return def;
        }
    }

    /**
     * Parse a string into a double. If an error occurs, return Nan.
     */
    public static double parse_double(String s)
    {
        return parse_double(s, Double.NaN);
    }

    /**
     * Parse a string into a double. If an error occurs, return the default
     * value.
     */
    public static double parse_double(String s, double def)
    {
        return parseDouble(s, def);
    }

    //##################################################
    //# parse decimal
    //##################################################

    /**
     * Parse a string into a decimal. If an error occurs, return null.
     */
    public static KmDecimal parseDecimal(String s)
    {
        return parseDecimal(s, null);
    }

    /**
     * Parse a string into a decimal. If an error occurs, return the default
     * value.
     */
    public static KmDecimal parseDecimal(String s, KmDecimal def)
    {
        try
        {
            if ( s == null )
                return def;

            s = s.trim();
            return new KmDecimal(s);
        }
        catch ( NumberFormatException ex )
        {
            return def;
        }
    }

    //##################################################
    //# parse kilogram
    //##################################################

    /**
     * Parse a string into a KmKilogram. If an error occurs, return null.
     */
    public static KmKilogram parseKilogram(String s)
    {
        return parseKilogram(s, null);
    }

    /**
     * Parse a string into a KmKilogram. If an error occurs, return the default
     * value.
     */
    public static KmKilogram parseKilogram(String s, KmKilogram def)
    {
        try
        {
            if ( s == null )
                return def;

            s = s.trim();
            double d = parse_double(s);
            return new KmKilogram(d);
        }
        catch ( NumberFormatException ex )
        {
            return def;
        }
    }

    //##################################################
    //# parse quantity
    //##################################################

    /**
     * Parse a string into a KmQuantity. If an error occurs, return null.
     */
    public static KmQuantity parseQuantity(String s)
    {
        return parseQuantity(s, null);
    }

    /**
     * Parse a string into a KmQuantity. If an error occurs, return the default
     * value.
     */
    public static KmQuantity parseQuantity(String s, KmQuantity def)
    {
        try
        {
            if ( s == null )
                return def;

            s = s.trim();

            Double d = parseDouble(s);
            if ( d == null )
                return null;

            return new KmQuantity(d);
        }
        catch ( Exception ex )
        {
            return null;
        }
    }

    //##################################################
    //# parse boolean
    //##################################################

    /**
     * Parse the string into a boolean. Return null if an error occurs.
     */
    public static Boolean parseBoolean(String s)
    {
        return parseBoolean(s, null);
    }

    /**
     * Parse the string into a boolean. Return the default value if an error
     * occurs.
     */
    public static Boolean parseBoolean(String s, Boolean def)
    {
        if ( s == null )
            return def;

        s = s.toLowerCase();
        if ( s.equals("t") )
            return true;

        if ( s.equals("true") )
            return true;

        if ( s.equals("y") )
            return true;

        if ( s.equals("yes") )
            return true;

        if ( s.equals("on") )
            return true;

        if ( s.equals("1") )
            return true;

        if ( s.equals("f") )
            return false;

        if ( s.equals("false") )
            return false;

        if ( s.equals("n") )
            return false;

        if ( s.equals("no") )
            return false;

        if ( s.equals("off") )
            return false;

        if ( s.equals("0") )
            return false;

        return def;
    }

    /**
     * Parse the string into a boolean.
     * Return false if an error occurs.
     */
    public static boolean parse_boolean(String s)
    {
        return parse_boolean(s, false);
    }

    /**
     * Parse the string into a boolean.
     * Return the default value if an error occurs.
     */
    public static boolean parse_boolean(String s, boolean def)
    {
        return parseBoolean(s, def);
    }

    //##################################################
    //# token
    //##################################################

    /**
     * Return the words contained in s using a default delimters.
     */
    public static KmList<String> getWords(String s)
    {
        return getWords(s, " \t\r\n");
    }

    /**
     * Return the words contained in s, using the characters in delimiters to
     * separate the words.
     */
    public static KmList<String> getWords(String s, String delimiters)
    {
        KmList<String> v = new KmList<String>();
        StringTokenizer st = new StringTokenizer(s, delimiters, true);
        while ( st.hasMoreTokens() )
        {
            String t = st.nextToken().trim();
            if ( t.length() > 0 )
                v.add(t);
        }
        return v;
    }

    public static KmList<String> getCamelCaseWords(String s)
    {
        return getWords(formatCamelCaseAsWords(s).toLowerCase());
    }

    /**
     * Split the source string into pieces, using the delimiter as a separator.
     * None of the split strings will include the delimiter character. The
     * number of pieces will be exactly equals to the number of occurences of
     * delimiter + 1. Only single character delimiters are supported at this
     * time and there is no support for escape characters. Note: this method
     * does not return the same results as StringTokenizer. Parsing "a,b," using
     * "," would result in: "a", "b", "".
     */
    public static KmList<String> tokenize(String s, char delimiter)
    {
        KmList<String> v = new KmList<String>();

        if ( s == null )
            return v;

        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = -1;
        StringBuilder out = new StringBuilder(n);

        while ( true )
        {
            i++;
            if ( i == n )
                break;

            char c = arr[i];
            if ( c == delimiter )
            {
                v.add(out.toString());
                out.setLength(0);
            }
            else
                out.append(c);
        }

        v.add(out.toString());
        return v;
    }

    public static KmList<String> tokenize(String s)
    {
        return tokenize(s, CHAR_COMMA);
    }

    //##################################################
    //# string
    //##################################################

    public static Integer getLastAlphaIndex(String s)
    {
        if ( isEmpty(s) )
            return 0;

        int n = s.length() - 1;

        while ( n >= 0 )
        {
            if ( !isDigit(s.charAt(n)) )
                break;

            n--;
        }

        return n;
    }

    /**
     * Determine if s is a non-null string with a minimun length of 1.
     */
    public static boolean hasValue(String s)
    {
        return !isEmpty(s);
    }

    /**
     * Determine if s is a non-null string with a minimun length of 1.
     */
    public static boolean isNotEmpty(String s)
    {
        return !isEmpty(s);
    }

    /**
     * Determine if s is either null or an empty string.
     */
    public static boolean isEmpty(CharSequence s)
    {
        return s == null || s.length() == 0;
    }

    /**
     * Determines if all of the arguments are empty.
     */
    public static boolean areAllEmpty(String... arr)
    {
        int n = arr.length;
        for ( int i = 0; i < n; i++ )
            if ( !isEmpty(arr[i]) )
                return false;

        return true;
    }

    public static String emptyToNull(String s)
    {
        return isEmpty(s)
            ? null
            : s;
    }

    /**
     * Remove all leading characters matching c.
     */
    public static String removeAllLeading(String s, char c)
    {
        while ( true )
        {
            if ( s.length() == 0 )
                return "";

            if ( s.charAt(0) != c )
                return s;

            s = s.substring(1);
        }
    }

    /**
     * Remove the specified prefix from the beginning of the string. If the
     * string does not start with prefix, then return the original string.
     */
    public static String removePrefix(String s, String prefix)
    {
        if ( prefix == null )
            return s;

        if ( s.startsWith(prefix) )
            return s.substring(prefix.length());

        return s;
    }

    /**
     * Repeatedly remove the prefix and return the result.
     */
    public static String removeAllPrefix(String s, String prefix)
    {
        while ( true )
        {
            String result = removePrefix(s, prefix);

            if ( result.equals(s) )
                return result;

            s = result;
        }
    }

    /**
     * If, and only if s starts with oldPrefix, then remove the old prefix
     * and prepend the new prefix.  If s is null, return null.
     */
    public static String replacePrefix(String s, String oldPrefix, String newPrefix)
    {
        if ( s == null )
            return null;

        if ( !s.startsWith(oldPrefix) )
            return s;

        return newPrefix + removePrefix(s, oldPrefix);
    }

    /**
     * Remove the specified suffix from the end of the string. If the string
     * does not end with the suffix, when return the original string.
     */
    public static String removeSuffix(String s, String suffix)
    {
        if ( suffix == null )
            return s;

        if ( s.endsWith(suffix) )
            return s.substring(0, s.length() - suffix.length());

        return s;
    }

    /**
     * Remove the specified suffix from the end of the string. If the string
     * does not end with the suffix, when return the original string.
     */
    public static String removeSuffix(String s, char suffix)
    {
        return removeSuffix(s, suffix + "");
    }

    /**
     * Repeatedly remove the prefix and return the result.
     */
    public static String removeAllSuffix(String s, String suffix)
    {
        while ( true )
        {
            String result = removeSuffix(s, suffix);

            if ( result.equals(s) )
                return result;

            s = result;
        }
    }

    /**
     * Add the prefix to s, if it does not already have that prefix.
     */
    public static String ensurePrefix(String s, String prefix)
    {
        if ( s == null )
            return null;

        if ( isEmpty(prefix) )
            return s;

        if ( s.startsWith(prefix) )
            return s;

        return prefix + s;
    }

    /**
     * Add the suffix to s, if it does not already have that suffix.
     */
    public static String ensureSuffix(String s, String suffix)
    {
        if ( s == null )
            return null;

        if ( isEmpty(suffix) )
            return s;

        if ( s.endsWith(suffix) )
            return s;

        return s + suffix;
    }

    /**
     * Determine if s ends with any of the the suffixes.
     */
    public static boolean endsWithAny(String s, String... suffixes)
    {
        for ( String suffix : suffixes )
            if ( s.endsWith(suffix) )
                return true;

        return false;
    }

    /**
     * Create a string that repeats c, n times.
     */
    public static String repeat(char c, int n)
    {
        if ( n <= 0 )
            return "";

        StringBuilder out = new StringBuilder(n);
        for ( int i = 0; i < n; i++ )
            out.append(c);

        return out.toString();
    }

    /**
     * Create a string that repeats s, n times.
     */
    public static String repeat(String s, int n)
    {
        if ( n <= 0 )
            return "";

        StringBuilder out = new StringBuilder(s.length() * n);
        for ( int i = 0; i < n; i++ )
            out.append(s);

        return out.toString();
    }

    public static String dashes(int n)
    {
        return repeat('-', n);
    }

    /**
     * Replace the first occurence of a with b in s.
     */
    public static String replaceFirst(String s, String a, String b)
    {
        int i = s.indexOf(a);
        if ( i < 0 )
            return s;

        return s.substring(0, i) + b + s.substring(i + a.length());
    }

    /**
     * Replace all occurrences of a with b, within s.
     */
    public static String replaceAll(String s, String a, String b)
    {
        return replaceAll(s, a, b, false);
    }

    /**
     * Replace all occurrences of a with b, within s.
     */
    public static String replaceAll(String s, String a, String b, boolean searchReplacements)
    {
        if ( s == null )
            return null;

        int i = 0;
        while ( true )
        {
            i = s.indexOf(a, i);
            if ( i < 0 )
                return s;

            s = s.substring(0, i) + b + s.substring(i + a.length());
            if ( !searchReplacements )
                i += b.length();
        }
    }

    /**
     * Replace all occurrences of a with b, within s.
     */
    public static String replaceAll(String s, char a, String b)
    {
        return replaceAll(s, a + "", b);
    }

    /**
     * Replace all occurrences of a with b, within s.
     */
    public static String replaceAll(String s, char a, char b)
    {
        return replaceAll(s, a + "", b + "");
    }

    /**
     * Replace all occurrences of the map keys with the corresponding values.
     */
    public static String replaceAll(String s, KmMap<String,String> m)
    {
        if ( m == null )
            return s;

        for ( String k : m.getKeys() )
            s = replaceAll(s, k, m.get(k));

        return s;
    }

    /**
     * Trim the value, and replace all whitespace runs with a single space.
     * Tabs, CRs, LFs are all converted to spaces.  Multiples spaces are 
     * converted to a single space.
     */
    public static String collapseWhitespace(String s)
    {
        if ( s == null )
            return null;

        s = s.trim();
        s = replaceAll(s, "\t", " ");
        s = replaceAll(s, "\r", " ");
        s = replaceAll(s, "\n", " ");
        s = replaceAll(s, "  ", " ", true);

        return s;
    }

    /**
     * Truncate s to a maximum length of n. If ellipses is true then "..." is
     * appended to the end of the string. The total string length, including
     * ellipses is guaranteed to be <= n.
     */
    public static String truncate(String s, int n, boolean ellipses)
    {
        if ( s == null )
            return null;

        if ( ellipses )
        {
            if ( s.length() <= n )
                return s;

            if ( n <= 3 )
                return repeat(".", n);

            return substringSafe(s, 0, n - 3) + "...";
        }
        return substringSafe(s, 0, n);
    }

    /**
     * Truncate the string to a maximum length of n.
     */
    public static String truncate(String s, int n)
    {
        return truncate(s, n, false);
    }

    /**
     * Returns the last X characters of the string where X is defined by
     * suffixLength. If the string is shorter than the suffix, return the
     * string, otherwise return an empty string. This method is guaranteed to
     * return a string value without error.
     */
    public static String suffix(String s, int suffixLength)
    {
        if ( s == null )
            return "";

        int start = s.length() - suffixLength;
        int end = s.length();

        return substringSafe(s, start, end);
    }

    /**
     * This serves the same purpose as String.substring except that it is
     * guaranteed to return a string value without error.
     */
    public static String substringSafe(String s, int start)
    {
        if ( s == null )
            return "";

        int end = s.length();

        if ( start < 0 )
            start = 0;

        if ( end < start )
            return "";

        return s.substring(start, end);
    }

    /**
     * This serves the same purpose as String.substring except that it is
     * guaranteed to return a string value without error.
     */
    public static String substringSafe(String s, int start, int end)
    {
        if ( s == null )
            return "";

        if ( start < 0 )
            start = 0;

        if ( start >= s.length() )
            return "";

        if ( end < start )
            return "";

        if ( end > s.length() )
            end = s.length();

        return s.substring(start, end);
    }

    /**
     * Determine if the character is a letter.
     */
    public static boolean isLetter(char c)
    {
        return LETTERS.indexOf(c) >= 0;
    }

    /**
     * Determine if all of the characters in s are letters. A..Z, a..z.
     */
    public static boolean isAllLetters(String s)
    {
        return containsOnly(s, LETTERS);
    }

    /**
     * Determine if all of the characters in s are either letters or digits.
     */
    public static boolean isAllAlphaNumeric(String s)
    {
        return containsOnly(s, DIGITS_AND_LETTERS);
    }

    /**
     * Determine if all of the characters in s are uppercase letters.
     */
    public static boolean isAllUpperCase(String s)
    {
        return containsOnly(s, UPPERCASE_LETTERS);
    }

    /**
     * Determine if all of the characters in s are lowercase letters.
     */
    public static boolean isAllLowerCase(String s)
    {
        return containsOnly(s, LOWERCASE_LETTERS);
    }

    public static boolean isUpperCase(char c)
    {
        return UPPERCASE_LETTERS.indexOf(c) >= 0;
    }

    /**
     * Determine if the character is a digit.
     */
    public static boolean isDigit(char c)
    {
        return DIGITS.indexOf(c) >= 0;
    }

    /**
     * Determine if all of the characters in s are digits (0..9).
     */
    public static boolean isAllDigits(String s)
    {
        return containsOnly(s, DIGITS);
    }

    /**
     * Determine if the character is a hex digit.
     */
    public static boolean isHexDigit(char c)
    {
        return HEX_CHAR_STRING.indexOf(c) >= 0;
    }

    /**
     * Determine if all of the characters in s are hex digits (0..F).
     */
    public static boolean isAllHexDigits(String s)
    {
        return containsOnly(s, HEX_CHAR_STRING);
    }

    /**
     * Determine if all of the characters in s are either all letters A..Z, a..z or all digits (0..9).
     */
    public static boolean isAllLettersOrDigits(String s)
    {
        return isAllLetters(s) || isAllDigits(s);
    }

    /**
     * Determine if we have all digits with the possibility of a leading - (negative)
     */
    public static boolean isAllDigitsWithOptionalLeadingNegativeCommasAndDecimal(String s)
    {
        if ( isEmpty(s) )
            return true;

        s = stripCharacters(s, CHAR_COMMA);

        if ( countOccurencesOf(CHAR_DOT, s) > 1 )
            return false;

        s = stripCharacters(s, CHAR_DOT);

        char c = s.charAt(0);

        if ( c == CHAR_DASH )
            return isAllDigits(s.substring(1));

        return isAllDigits(s);
    }

    /**
     * determine the number of times a particular character occurs in a given string.
     *
     * @param c the character you want to count.
     * @param s the string you want checked.
     * @return the number of times 'c' occurs in 's'
     */
    private static int countOccurencesOf(char c, String s)
    {
        int n = 0;

        for ( int i = 0; i < s.length(); i++ )
        {
            char sc = s.charAt(i);
            if ( sc == c )
                n++;
        }

        return n;
    }

    /**
     * Determine if the character is alphanumeric: a..z, A..Z, 0..9.
     */
    public static boolean isAlphaNumeric(char c)
    {
        return DIGITS_AND_LETTERS.indexOf(c) >= 0;
    }

    /**
     * Determine if s contains any of the characters in chars.
     */
    public static boolean containsAny(String s, String chars)
    {
        int n = chars.length();
        for ( int i = 0; i < n; i++ )
        {
            char c = chars.charAt(i);
            if ( s.indexOf(c) >= 0 )
                return true;
        }
        return false;
    }

    /**
     * Determine is s is composed solely of the characters in chars.
     */
    public static boolean containsOnly(String s, String chars)
    {
        int n = s.length();
        for ( int i = 0; i < n; i++ )
        {
            char c = s.charAt(i);
            if ( chars.indexOf(c) < 0 )
                return false;
        }
        return true;
    }

    /**
     * Remove leading characters from the string.
     */
    public static String stripLeadingCharacters(String s, char c)
    {
        if ( s == null )
            return null;

        String prefix = c + "";
        while ( s.startsWith(prefix) )
            s = s.substring(1);

        return s;
    }

    public static String stripLeadingZeros(String s)
    {
        return stripLeadingCharacters(s, '0');
    }

    /**
     * Remove trailing characters from the string.
     */
    public static String stripTrailingCharacters(String s, char c)
    {
        if ( s == null )
            return null;

        String suffix = c + "";
        while ( s.endsWith(suffix) )
            s = s.substring(0, s.length() - 1);

        return s;
    }

    /**
     * Remove trailing digits
     */
    public static String stripTrailingDigits(String s)
    {
        if ( s == null )
            return null;

        while ( true )
        {
            int n = s.length();
            if ( n == 0 )
                return s;

            char c = s.charAt(n - 1);
            if ( !isDigit(c) )
                return s;

            s = s.substring(0, n - 1);
        }
    }

    /**
     * Return the longest prefix that is common to both strings.
     * See getCommonPrefix(String, String, maxLength).
     */
    public static String getCommonPrefix(String a, String b)
    {
        if ( a == null )
            return null;

        if ( b == null )
            return null;

        int maxLength = min(a.length(), b.length());
        return getCommonPrefix(a, b, maxLength);
    }

    /**
     * Return the longest prefix that is common to both strings.
     * The prefix will be truncated to no more than maxLength.
     * Return null if either string is null.
     * Return empty string if there is no common prefix.
     */
    public static String getCommonPrefix(String a, String b, int maxLength)
    {
        if ( a == null )
            return null;

        if ( b == null )
            return null;

        String prefix = "";
        maxLength = min(maxLength, a.length(), b.length());

        for ( int i = 1; i <= maxLength; i++ )
        {
            String aPrefix = a.substring(0, i);
            String bPrefix = b.substring(0, i);

            if ( !aPrefix.equals(bPrefix) )
                break;

            prefix = aPrefix;
        }
        return prefix;
    }

    /**
     * Remove all letters from the string.
     */
    public static String stripLetters(String s)
    {
        if ( s == null )
            return null;

        StringBuilder out = new StringBuilder();

        int n = s.length();
        for ( int i = 0; i < n; i++ )
        {
            char c = s.charAt(i);
            if ( !isLetter(c) )
                out.append(c);
        }

        return out.toString();
    }

    /**
     * Remove all characters that are not letters.
     */
    public static String stripNonLetters(String s)
    {
        if ( s == null )
            return null;

        StringBuilder out = new StringBuilder();

        int n = s.length();
        for ( int i = 0; i < n; i++ )
        {
            char c = s.charAt(i);
            if ( isLetter(c) )
                out.append(c);
        }

        return out.toString();
    }

    /**
     * Remove all non-digits from the string.
     */
    public static String stripNonDigits(String s)
    {
        if ( s == null )
            return null;

        StringBuilder out = new StringBuilder();

        int n = s.length();
        for ( int i = 0; i < n; i++ )
        {
            char c = s.charAt(i);
            if ( isDigit(c) )
                out.append(c);
        }

        return out.toString();
    }

    /**
     * Remove all characters matching ch from the string.
     */
    public static String stripCharacters(String s, int ch)
    {
        if ( s == null )
            return null;

        if ( s.indexOf(ch) < 0 )
            return s;

        StringBuilder out = new StringBuilder();

        int n = s.length();
        for ( int i = 0; i < n; i++ )
        {
            char c = s.charAt(i);
            if ( c != ch )
                out.append(c);
        }
        return out.toString();
    }

    /**
     * Remove all spaces from the string. This only strips the 'space'
     * character, other whitespace, such as tabs, is not removed.
     */
    public static String stripSpaces(String s)
    {
        return stripCharacters(s, ' ');
    }

    /**
     * Remove all dashes from the string.
     */
    public static String stripDashes(String s)
    {
        return stripCharacters(s, '-');
    }

    /**
     * Remove all non-alpha numeric characters from the string.
     */
    public static String stripNonAlphaNumeric(String s)
    {
        if ( s == null )
            return null;

        StringBuilder out = new StringBuilder();

        int n = s.length();
        for ( int i = 0; i < n; i++ )
        {
            char c = s.charAt(i);
            if ( isAlphaNumeric(c) )
                out.append(c);
        }

        return out.toString();
    }

    /**
     * Remove all of the non printable characters from the string.
     */
    public static String stripNonSingleLinePrintable(String s)
    {
        if ( s == null )
            return null;

        StringBuilder out = new StringBuilder();

        int n = s.length();
        for ( int i = 0; i < n; i++ )
        {
            char c = s.charAt(i);
            if ( isSingleLinePrintable(c) )
                out.append(c);
        }

        return out.toString();
    }

    /**
     * Remove all of the non printable characters from the string.
     */
    public static String stripNonMultiLinePrintable(String s)
    {
        if ( s == null )
            return null;

        StringBuilder out = new StringBuilder();

        int n = s.length();
        for ( int i = 0; i < n; i++ )
        {
            char c = s.charAt(i);
            if ( isMultiLinePrintable(c) )
                out.append(c);
        }

        return out.toString();
    }

    /**
     * Strip all characters that we do not allow during a form post.
     */
    public static String stripNonFormPostable(String s)
    {
        if ( s == null )
            return null;

        int n = s.length();
        StringBuilder out = new StringBuilder(n);

        for ( int i = 0; i < n; i++ )
        {
            char c = s.charAt(i);
            if ( isFormPostable(c) )
                out.append(c);
        }

        return out.toString();
    }

    /**
     * Replace the non printable characters with a standard place holder.
     */
    public static String replaceNonSingleLinePrintable(String s)
    {
        if ( s == null )
            return null;

        StringBuilder out = new StringBuilder();

        int n = s.length();
        for ( int i = 0; i < n; i++ )
        {
            char c = s.charAt(i);
            if ( isSingleLinePrintable(c) )
                out.append(c);
            else
                out.append(CHAR_NON_PRINTABLE);
        }

        return out.toString();
    }

    /**
     * Determine if the character is considered printable on a single line. 
     * Basically, all characters with ascii values between 0x20 and 0xFE (inclusive).
     * Note: CR, LF, and TAB are not considered line printable.
     * See also, isWhitespace, isParagraphPrintable.
     */
    public static boolean isSingleLinePrintable(char c)
    {
        return c >= 32 && c <= 126;
    }

    /**
     * Determine if the character is considered printable across multiple lines. 
     * This includes all of the singleLinePrintable characters, and adds the
     * standard whitespace (CR, LF, TAB).
     */
    public static boolean isMultiLinePrintable(char c)
    {
        return isSingleLinePrintable(c) || isWhitespace(c);
    }

    /**
     * Determine if the character is considered whitespace.
     * Whitespace characters include: space, tab, cr, lf.
     */
    public static boolean isWhitespace(char c)
    {
        if ( c == CHAR_SPACE )
            return true;

        if ( c == CHAR_CR )
            return true;

        if ( c == CHAR_LF )
            return true;

        if ( c == CHAR_TAB )
            return true;

        return false;
    }

    /**
     * Determine if the character is allowed during a form post.
     * We allow all printable and whitespace characters.
     */
    public static boolean isFormPostable(char c)
    {
        return isMultiLinePrintable(c);
    }

    /**
     * Determine if the character is considered Unicode.
     * This criteria is met when the character breaches the high ascii mark (256+)
     */
    public static boolean isUnicode(char c)
    {
        if ( c > 255 )
            return true;

        return false;
    }

    public static boolean isUnicode(String s)
    {
        for ( int i = 0; i < s.length(); i++ )
            if ( isUnicode(s.charAt(i)) )
                return true;

        return false;
    }

    /**
     * Determine if the character is considered High Ascii.
     * This criteria is met when the character is within the high ascii area (128-255)
     */
    public static boolean isHighAscii(char c)
    {
        if ( c > 127 && c < 256 )
            return true;

        return false;
    }

    public static boolean isHighAscii(String s)
    {
        for ( int i = 0; i < s.length(); i++ )
            if ( isHighAscii(s.charAt(i)) )
                return true;

        return false;
    }

    /**
     * Replace all non-alpha numeric characters with the space character; the
     * resulting string will be the same length as the original.
     */
    public static String replaceNonAlphaNumericWithSpace(String s)
    {
        if ( s == null )
            return null;

        StringBuilder out = new StringBuilder();

        int n = s.length();
        for ( int i = 0; i < n; i++ )
        {
            char c = s.charAt(i);
            if ( !isAlphaNumeric(c) )
                c = ' ';
            out.append(c);
        }

        return out.toString();
    }

    /**
     * Set the first chracter to uppercase and the rest to lower.
     */
    public static String capitalizeWord(String s)
    {
        if ( s == null )
            return null;

        int n = s.length();
        if ( n == 0 )
            return s;

        if ( n == 1 )
            return s.toUpperCase();

        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    /**
     * Capitalize the first letter of each word. Use space, tab, carriage
     * return, and line feed for delimiters.
     */
    public static String capitalizeWords(String s)
    {
        return capitalizeWords(s, " \t\r\n");
    }

    /**
     * Capitalize the first letter of each word based on the delimiters.
     */
    public static String capitalizeWords(String s, String delimiters)
    {
        StringBuilder out = new StringBuilder();

        StringTokenizer st = new StringTokenizer(s, delimiters, true);
        while ( st.hasMoreTokens() )
        {
            String t = st.nextToken();
            out.append(capitalizeWord(t));
        }

        return out.toString();
    }

    /**
     * Set the first character to uppercase leave the rest alone.
     */
    public static String capitalizeFirstLetter(String s)
    {
        if ( s == null )
            return null;

        if ( s.length() == 0 )
            return s;

        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    /**
     * Set the first character to lowercase leave the rest alone.
     */
    public static String lowercaseFirstLetter(String s)
    {
        if ( s == null )
            return null;

        if ( s.length() == 0 )
            return s;

        return s.substring(0, 1).toLowerCase() + s.substring(1);
    }

    /**
     * Convert the input string into kneeling camel case, while delimiting on
     * any spaces.
     */
    public static String toKneelingCamelCase(String s)
    {
        StringBuilder out = new StringBuilder();
        boolean newWord = false;

        int n = s.length();
        for ( int i = 0; i < n; i++ )
        {
            char c = s.charAt(i);
            if ( c == ' ' )
            {
                newWord = true;
                continue;
            }

            if ( newWord )
                c = Character.toUpperCase(c);

            out.append(c);
            newWord = false;
        }

        return lowercaseFirstLetter(out.toString());
    }

    /**
     * Convert the input string into camel case, while delimiting on any spaces.
     */
    public static String toCamelCase(String s)
    {
        return capitalizeFirstLetter(toKneelingCamelCase(s));
    }

    /**
     * Split a single camel case token into multiple words.  Insert a space before
     * each upper case letter, and then trim the result.
     */
    public static String formatCamelCaseAsWords(String s)
    {
        StringBuilder out = new StringBuilder();

        int n = s.length();
        for ( int i = 0; i < n; i++ )
        {
            char c = s.charAt(i);

            if ( isUpperCase(c) )
                out.append(" ");

            out.append(c);
        }

        return out.toString().trim();
    }

    /**
     * Split a single camel case token into multiple words.  Insert a space before
     * each upper case letter, and then trim the result. In the case that the string
     * is a kneeling camel case, capitalize the first word.
     */
    public static String formatCamelCaseAsCapitalizedWords(String s)
    {
        return formatCamelCaseAsWords(capitalizeFirstLetter(s));
    }

    /**
     * Remove all sections of the string that begin with <begin> and end with
     * <end>.
     */
    public static String removeSections(String s, String begin, String end)
    {
        int i = s.indexOf(begin);
        if ( i < 0 )
            return s;

        int j = 0;
        StringBuilder out = new StringBuilder();

        while ( i >= 0 )
        {
            out.append(s.substring(j, i));
            j = s.indexOf(end, i + begin.length());

            if ( j < 0 )
                j = s.length();
            else
                j += end.length();

            i = s.indexOf(begin, j);
        }

        out.append(s.substring(j));
        return out.toString();
    }

    /**
     * Determine if the string begins with an eol pattern. One of: CRLF, CR, LF
     */
    public static boolean hasEndOfLinePrefix(String s)
    {
        if ( s.startsWith(STRING_CR) )
            return true;

        if ( s.startsWith(STRING_LF) )
            return true;

        return false;
    }

    /**
     * Remove a single eol pattern from the beginning of the string. One of:
     * CRLF, CR, LF
     */
    public static String removeEndOfLinePrefix(String s)
    {
        if ( s.startsWith(STRING_CRLF) )
            return removePrefix(s, STRING_CRLF);

        if ( s.startsWith(STRING_CR) )
            return removePrefix(s, STRING_CR);

        if ( s.startsWith(STRING_LF) )
            return removePrefix(s, STRING_LF);

        return s;
    }

    /**
     * Determine if the string begins with an eol pattern. One of: CRLF, CR, LF
     */
    public static boolean hasEndOfLineSuffix(String s)
    {
        if ( s.endsWith(STRING_CR) )
            return true;

        if ( s.endsWith(STRING_LF) )
            return true;

        return false;
    }

    /**
     * Remove a single eol pattern from the end of the string. One of: CRLF, CR,
     * LF
     */
    public static String removeEndOfLineSuffix(String s)
    {
        if ( s.endsWith(STRING_CRLF) )
            return removeSuffix(s, STRING_CRLF);

        if ( s.endsWith(STRING_CR) )
            return removeSuffix(s, STRING_CR);

        if ( s.endsWith(STRING_LF) )
            return removeSuffix(s, STRING_LF);

        return s;
    }

    /**
     * Convert a word to an all uppercase format, preserving word separation
     * using underscores. Spaces and uppercase letters in the original string
     * are assumed to mark word separators.
     */
    public static String formatAsConstant(String s)
    {
        StringBuilder out = new StringBuilder();

        Iterator<String> i = parseNameTokens(s).iterator();
        while ( i.hasNext() )
        {
            out.append(i.next().toUpperCase());
            if ( i.hasNext() )
                out.append("_");
        }

        return out.toString();
    }

    public static String formatAsLowerCaseNames(String name)
    {
        StringBuilder out = new StringBuilder();
        KmList<String> v = parseNameTokens(name);

        Iterator<String> i = v.iterator();
        while ( i.hasNext() )
        {
            out.append(i.next());

            if ( i.hasNext() )
                out.append(" ");
        }

        return out.toString();
    }

    public static String formatAsCapitalizedNames(String name)
    {
        StringBuilder out = new StringBuilder();
        KmList<String> v = parseNameTokens(name);

        Iterator<String> i = v.iterator();
        while ( i.hasNext() )
        {
            String s = capitalizeFirstLetter(i.next());
            out.append(s);

            if ( i.hasNext() )
                out.append(" ");
        }

        return out.toString();
    }

    public static KmList<String> parseNameTokens(String name)
    {
        return KmNameTokenizer.parse(name);
    }

    /**
     * Trim only the leading whitespace from the string. The intent is to use
     * the same rules at String.trim, except trailing whitespace is not
     * affected.
     */
    public static String trimLeading(String s)
    {
        if ( s == null )
            return null;

        char c = '\u0020';
        int i = 0;

        while ( true )
        {
            if ( i == s.length() )
                break;

            if ( s.charAt(i) > c )
                break;

            i++;
        }

        return s.substring(i);
    }

    public static String trim(String s)
    {
        if ( s == null )
            return null;

        return s.trim();
    }

    /**
     * Trim only the trailing whitespace from the string. The intent is to use
     * the same rules at String.trim, except leading whitespace is not affected.
     */
    public static String trimTrailing(String s)
    {
        if ( s == null )
            return null;

        char c = '\u0020';
        int n = s.length();

        while ( true )
        {
            if ( n == 0 )
                break;

            if ( s.charAt(n - 1) > c )
                break;

            n--;
        }

        return s.substring(0, n);
    }

    public static String trimSlashes(String s)
    {
        if ( s == null )
            return null;

        s = removeAllPrefix(s, SLASH);
        s = removeAllSuffix(s, SLASH);

        return s;
    }

    /**
     * Determine if the string starts with whitespace.
     */
    public static boolean hasLeadingWhitespace(String s)
    {
        return s.length() == 0
            ? false
            : s.charAt(0) <= '\u0020';
    }

    /**
     * Determine if the string ends with whitespace.
     */
    public static boolean hasTrailingWhitespace(String s)
    {
        return s.length() == 0
            ? false
            : s.charAt(s.length() - 1) <= '\u0020';
    }

    /**
     * Take a best guess as auto-converting a word to a its plural.
     * E.g:
     * egg   : eggs
     * city  : cities
     * child : children
     */
    public static String pluralize(String s)
    {
        if ( s == null )
            return null;

        int n = s.length();
        if ( n <= 1 )
            return s;

        if ( s.equalsIgnoreCase("child") )
            return s + "ren";

        char last = s.charAt(n - 1);
        if ( last == 's' )
            return s + "es";

        if ( isVowel(last) )
            return s + "s";

        if ( s.endsWith("y") )
        {
            char c = s.charAt(n - 2);
            return isVowel(c)
                ? s + "s"
                : s.substring(0, n - 1) + "ies";
        }

        return s + "s";
    }

    /**
     * Determine if c is a vowel.
     */
    public static boolean isVowel(char c)
    {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    /**
     * Determine if c is a consonant.
     */
    public static boolean isConsonant(char c)
    {
        return !isVowel(c);
    }

    public static String escapeXml(String s)
    {
        s = replaceAll(s, "&", "&amp;");
        s = replaceAll(s, "'", "&apos;");
        s = replaceAll(s, "\"", "&quot;");
        s = replaceAll(s, "<", "&lt;");
        s = replaceAll(s, ">", "&gt;");
        return s;
    }

    /**
     * Useful for representing java generic types in xml.
     * E.g.: convert KmList<Person> to KmList(Person)
     */
    public static String escapeXmlType(String s)
    {
        s = replaceAll(s, "<", "(");
        s = replaceAll(s, ">", ")");
        s = escapeXml(s);
        return s;
    }

    /**
     * Return the list of lines (without the line separator characters) using
     * the standard line reading mechanism of BufferedReader.
     */
    public static KmList<String> getLines(String source)
    {
        try
        {
            BufferedReader br = new BufferedReader(new StringReader(source));
            KmList<String> v = new KmList<String>();

            while ( true )
            {
                String s = br.readLine();
                if ( s == null )
                    break;
                v.add(s);
            }

            return v;
        }
        catch ( Exception ex )
        {
            return new KmList<String>();
        }
    }

    /**
     * Get the first line.
     */
    public static String getFirstLine(String s)
    {
        return getLines(s).getFirstSafe();
    }

    /**
     * Get the last line.
     */
    public static String getLastLine(String s)
    {
        return getLines(s).getLastSafe();
    }

    /**
     * Return the suffix of the string. Up to n characters are returned. If (s ==
     * null) return null. If (s.length < n) return s.
     */
    public static String getSuffix(String s, int n)
    {
        if ( s == null )
            return null;

        if ( s.length() <= n )
            return s;

        return s.substring(s.length() - n);
    }

    /**
     * Remove the blank lines from the string.
     */
    public static String removeBlankLines(String source)
    {
        try
        {
            StringReader sr = new StringReader(source);
            BufferedReader br = new BufferedReader(sr);
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);

            while ( true )
            {
                String s = br.readLine();

                if ( s == null )
                    break;

                if ( s.trim().length() > 0 )
                    pw.println(s);
            }

            pw.flush();
            return sw.toString();
        }
        catch ( Exception ex )
        {
            return "";
        }
    }

    public static void removeBlankLines(KmList<String> lines)
    {
        Iterator<String> i = lines.iterator();
        while ( i.hasNext() )
        {
            String s = i.next();
            if ( s == null )
            {
                i.remove();
                continue;
            }
            if ( s.trim().length() == 0 )
            {
                i.remove();
                continue;
            }
        }
    }

    /**
     * Remove null and empty values.
     */
    public static void removeEmptyValues(List<String> v)
    {
        Iterator<String> i = v.iterator();
        while ( i.hasNext() )
            if ( isEmpty(i.next()) )
                i.remove();
    }

    public static void removeLinesStartingWith(KmList<String> v, String prefix)
    {
        Iterator<String> i = v.iterator();
        while ( i.hasNext() )
        {
            String s = i.next();
            if ( s.startsWith(prefix) )
                i.remove();
        }
    }

    public static void trimValues(List<String> v)
    {
        int n = v.size();
        for ( int i = 0; i < n; i++ )
        {
            String s = v.get(i);
            if ( s != null )
                v.set(i, s.trim());
        }
    }

    public static String crop(String s, String prefix, String suffix)
    {
        int i;

        i = s.indexOf(prefix);
        if ( i >= 0 )
            s = s.substring(i + prefix.length());

        i = s.indexOf(suffix);
        if ( i >= 0 )
            s = s.substring(0, i);

        return s;
    }

    /**
     * Get the portion of the source before the specified split.
     * Returns null if the split is not found. 
     */
    public static String getBeforeFirst(String source, String split)
    {
        int i = source.indexOf(split);
        if ( i < 0 )
            return null;

        return source.substring(0, i);
    }

    /**
     * Get the portion of the source after the specified split.
     * Returns null if the split is not found. 
     */
    public static String getAfterFirst(String source, String split)
    {
        int i = source.indexOf(split);
        if ( i < 0 )
            return null;

        return source.substring(i + split.length());
    }

    //##################################################
    //# edit distance
    //##################################################

    /**
     * Compute the Levenshtein "edit" distance. This is the number of changes
     * necessary to convert one string into the other.
     */
    public static int getEditDistance(String s, String t)
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
    public static double getAdjustedEditDistance(String s, String t)
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
    //# soundex
    //##################################################

    /**
     * Compute the soundex with a standard padLength.
     */
    public static String getSoundex(String s)
    {
        return getSoundex(s, 4);
    }

    /**
     * Compute the soundex with a given padLength.
     */
    public static String getSoundex(String s, int padLength)
    {
        char[] cArr = s.toLowerCase().toCharArray();
        int n = cArr.length;
        char[] iArr = new char[n];

        for ( int i = 0; i < n; i++ )
        {
            char c = cArr[i];
            if ( c == 'b' || c == 'p' || c == 'f' || c == 'v' )
            {
                iArr[i] = '1';
                continue;
            }

            if ( c == 'c'
                || c == 's'
                || c == 'k'
                || c == 'g'
                || c == 'j'
                || c == 'q'
                || c == 'x'
                || c == 'z' )
            {
                iArr[i] = '2';
                continue;
            }

            if ( c == 'd' || c == 't' )
            {
                iArr[i] = '3';
                continue;
            }

            if ( c == 'l' )
            {
                iArr[i] = '4';
                continue;
            }

            if ( c == 'm' || c == 'n' )
            {
                iArr[i] = '5';
                continue;
            }

            if ( c == 'r' )
            {
                iArr[i] = '6';
                continue;
            }

            iArr[i] = '0';
        }

        StringBuilder out;
        out = new StringBuilder(padLength);
        out.append(cArr[0]);

        int prev = iArr[0];

        for ( int i = 1; i < n; i++ )
        {
            char code = iArr[i];
            if ( code == '0' )
                continue;

            if ( code != prev )
            {
                out.append(code);
                prev = code;
                if ( out.length() == padLength )
                    break;
            }
        }

        n = padLength - out.length();
        for ( int i = 0; i < n; i++ )
            out.append('0');

        return out.toString();
    }

    //##################################################
    //# encode
    //##################################################

    public static String encodeUtf8(String s)
    {
        try
        {
            return URLEncoder.encode(s, CHARSET_UTF_8);
        }
        catch ( Exception ex )
        {
            throw toRuntime(ex);
        }
    }

    public static String decodeUtf8(String s)
    {
        try
        {
            return URLDecoder.decode(s, CHARSET_UTF_8);
        }
        catch ( Exception ex )
        {
            throw toRuntime(ex);
        }
    }

    /**
     * Determine is the first parameter matches any of the arguments.
     */
    public static boolean matchesAny(String s, String... args)
    {
        int n = args.length;
        for ( int i = 0; i < n; i++ )
            if ( isEqual(s, args[i]) )
                return true;

        return false;
    }

    /**
     * Determine is the first parameter matches any of the arguments.
     */
    public static boolean matchesAny(Integer s, Integer... args)
    {
        int n = args.length;
        for ( int i = 0; i < n; i++ )
            if ( isEqual(s, args[i]) )
                return true;

        return false;
    }

    public static String formatList(String... arr)
    {
        if ( arr == null )
            return "";

        StringBuilder out = new StringBuilder();

        int n = arr.length;
        for ( int i = 0; i < n; i++ )
        {
            out.append(arr[i]);
            if ( i < n - 1 )
                out.append(",");
        }

        return out.toString();
    }

    public static <E> String formatList(Iterable<E> v)
    {
        return formatList(v, (KmAdaptorIF<E,?>)null, LIST_SEPARATOR);
    }

    public static <E> String formatList(Iterable<E> v, KmAdaptorIF<E,?> adapter, Object separator)
    {
        if ( v == null )
            return "";

        StringBuilder out = new StringBuilder();

        Iterator<E> i = v.iterator();
        while ( i.hasNext() )
        {
            E e = i.next();

            Object o = e;
            if ( adapter != null )
                o = adapter.getValue(e);

            out.append(o);

            if ( i.hasNext() && separator != null )
                out.append(separator);
        }

        return out.toString();
    }

    public static <E> String formatList(Iterable<E> v, KmAdaptorIF<E,?> adapter)
    {
        return formatList(v, adapter, LIST_SEPARATOR);
    }

    public static <E> String formatList(Iterable<E> v, Object separator)
    {
        return formatList(v, (KmAdaptorIF<E,?>)null, separator);
    }

    public static <E> String formatList(Iterable<E> v, KmMetaAttribute<E,?> attr, Object separator)
    {
        return formatList(v, attr.getAdaptor(), separator);
    }

    public static <E> String formatLines(Iterable<E> v)
    {
        return formatList(v, "\n");
    }

    public static String formatSeparated(String separator, Object... arr)
    {
        StringBuilder out = new StringBuilder();

        for ( Object e : arr )
        {
            if ( out.length() > 0 )
                out.append(separator);

            out.append(e);
        }

        return out.toString();
    }

    public static String format(String msg, Object... args)
    {
        if ( isEmpty(msg) )
            return msg;

        if ( args.length == 0 )
            return msg;

        return String.format(msg, args);
    }

    /**
     * Insert some insertion text into the source at the specified index.
     */
    public static String insert(String source, String insertion, int index)
    {
        return substringSafe(source, 0, index) + insertion + substringSafe(source, index);
    }

    public static int getMaximumLength(KmList<String> keys)
    {
        int max = 0;

        for ( String s : keys )
            max = Math.max(max, s.length());

        return max;
    }

    public static String normalizeLineEnds(String source, String eol)
    {
        String line;
        BufferedReader in = null;
        StringWriter out = null;

        try
        {
            if ( source == null )
                return null;

            StringReader sr = new StringReader(source);
            in = new BufferedReader(sr);
            out = new StringWriter();

            while ( true )
            {
                line = in.readLine();
                if ( line == null )
                    break;

                out.write(line);
                out.write(eol);
            }

            return out.toString();
        }
        catch ( IOException ex )
        {
            throw toRuntime(ex);
        }
        finally
        {
            closeSafely(in);
            closeSafely(out);
        }
    }

    /**
     * Return the default system line end.  Typically <cr><lf> on windows; <lf> on unix.
     */
    public static String getDefaultLineEnd()
    {
        return System.getProperties().getProperty("line.separator");
    }

    /**
     * Rotate the string by a specific number of characters.
     * Examples:
     * rotate("abc", 0) -> abc
     * rotate("abc", 1) -> bca
     * rotate("abc", 3) -> abc
     * rotate("abc", -1) -> cab
     */
    public static String rotate(String s, int i)
    {
        int n = s.length();
        String ss = s + s + s;
        int start = n + i % n;
        int end = start + n;
        return ss.substring(start, end);
    }

    /**
     * Take html and reformat it into a javascript string literal.
     * 
     * E.g.:
     * Input...
     * 
     *      Hello world
     *      <b>Bold text</b>
     *      A "quoted" value.
     *      <script>some javascript</script>
     *   
     * Output...
     *
     *      var s = "";
     *      s += "Hello world\n";
     *      s += "<b>Bold text</b>\n";
     *      s += "A \"quoted\" value.\n";
     *      s += "<scr"+"ipt>some javascript</scr"+"ipt>\n";
     */
    public static String formatHtmlAsJavascriptString(String var, String html)
    {
        KmStringBuilder out;
        out = new KmStringBuilder();
        out.printfln("var %s = \"\";", var);

        KmList<String> lines = getLines(html);
        for ( String line : lines )
        {
            String escaped = escapeJavascriptStringLiteral(line);
            out.printfln("%s += \"%s\\n\";", var, escaped);
        }

        return out.toString();
    }

    public static String toStringSafe(Object e)
    {
        return e == null
            ? null
            : e.toString();
    }

    //##################################################
    //# math
    //##################################################

    /**
     * Determine if the integer is even.
     */
    public static boolean isEven(int i)
    {
        return i % 2 == 0;
    }

    /**
     * Determine if the integer is odd.
     */
    public static boolean isOdd(int i)
    {
        return !isEven(i);
    }

    /**
     * This is a convenience wrapper for Double.isNaN(d)
     */
    public static boolean isNan(double d)
    {
        return Double.isNaN(d);
    }

    /**
     * Convert the byte -128..127 to an unsigned integer in the range 0..255.
     */
    public static int unsigned(byte b)
    {
        return (b >> 4 & 0x0F) << 4 | b & 0x0F;
    }

    /**
     * Round the double to the specified number of decimal places.
     */
    public static int round(double d)
    {
        return (int)round(d, 0);
    }

    /**
     * Round the double to the specified number of decimal places.
     */
    public static double round(double d, int n)
    {
        if ( Double.isNaN(d) )
            return Double.NaN;

        boolean neg = d < 0;
        if ( neg )
            d = -d;

        double ten = Math.pow(10, n);
        d = Math.round(d * ten) / ten;
        if ( neg )
            d = -d;

        return d;
    }

    /**
     * Round the double to the next whole number.
     */
    public static double roundUpToInteger(double d)
    {
        return Math.ceil(d);
    }

    /**
     * Round the double to the next whole number.
     */
    public static double roundHalfUpToInteger(double d)
    {
        return Math.rint(d);
    }

    /**
     * Safely add two Doubles. The result is always a non-null Double.
     */
    public static Double add(Double a, Double b)
    {
        if ( a == null && b == null )
            return 0.0;

        if ( a == null )
            return b;

        if ( b == null )
            return a;

        return a.doubleValue() + b.doubleValue();
    }

    public static boolean isBetweenInclusive(Integer i, Integer min, Integer max)
    {
        if ( min != null && i < min )
            return false;

        if ( max != null && i > max )
            return false;

        return true;
    }

    public static boolean isBetweenExclusive(Integer i, Integer min, Integer max)
    {
        if ( min != null && i <= min )
            return false;

        if ( max != null && i >= max )
            return false;

        return true;
    }

    //##################################################
    //# math (min / max)
    //##################################################

    /**
     * Determine the minimum value of two integers. This is only here for
     * consistency. Compare to min(double, double).
     */
    public static int min(int a, int b)
    {
        return Math.min(a, b);
    }

    /**
     * Determine the maximum value of two integers. This is only here for
     * consistency. Compare to max(double, double).
     */
    public static int max(int a, int b)
    {
        return Math.max(a, b);
    }

    /**
     * Determine the minimum value of three integers.
     */
    public static int min(int a, int b, int c)
    {
        return min(a, min(b, c));
    }

    /**
     * Determine the maximum value of three integers.
     */
    public static int max(int a, int b, int c)
    {
        return max(a, max(b, c));
    }

    /**
     * Determine the minimum non-nan value of two doubles. If both are nan, then
     * return nan.
     */
    public static double min(double a, double b)
    {
        if ( isNan(a) )
            return b;

        if ( isNan(b) )
            return a;

        return Math.min(a, b);
    }

    /**
     * Determine the maximum non-nan value of two doubles. If both are nan, then
     * return nan.
     */
    public static double max(double a, double b)
    {
        if ( isNan(a) )
            return b;

        if ( isNan(b) )
            return a;

        return Math.max(a, b);
    }

    /**
     * Determine the minimum non-nan value of three doubles. If all three values
     * are nan, then return nan.
     */
    public static double min(double a, double b, double c)
    {
        return min(a, min(b, c));
    }

    /**
     * Determine the maximum non-nan value of three doubles. If all three values
     * are nan, then return nan.
     */
    public static double max(double a, double b, double c)
    {
        return max(a, max(b, c));
    }

    public static KmDate min(KmDate a, KmDate b)
    {
        if ( a == null )
            return b;

        if ( b == null )
            return a;

        if ( a.isBefore(b) )
            return a;

        return b;
    }

    public static KmDate max(KmDate a, KmDate b)
    {
        if ( a == null )
            return b;

        if ( b == null )
            return a;

        if ( a.isAfter(b) )
            return a;

        return b;
    }

    public static int constrain(int e, int min, int max)
    {
        if ( e < min )
            e = min;

        if ( e > max )
            e = max;

        return e;
    }

    public static long constrain(long e, long min, long max)
    {
        if ( e < min )
            e = min;

        if ( e > max )
            e = max;

        return e;
    }

    public static double constrain(double e, double min, double max)
    {
        if ( e < min )
            e = min;

        if ( e > max )
            e = max;

        return e;
    }

    public static Double toDouble(Integer e)
    {
        return e == null
            ? null
            : e.doubleValue();
    }

    //##################################################
    //# compare
    //##################################################

    /**
     * A safe comparison to determine if a string is in the list of srings. This will work if
     * either or both of the instances are null. This will throw an exception if
     * both a and b are non-null and a.equals(b) generates an exception.
     */
    public static boolean isEqualToAny(String a, KmList<String> values)
    {
        for ( Object b : values )
            if ( isEqual(a, b) )
                return true;

        return false;
    }

    /**
     * A safe comparison to determine if to objects are equal. This will work if
     * either or both of the instances are null. This will throw an exception if
     * both a and b are non-null and a.equals(b) generates an exception.
     */
    public static boolean isEqual(Object a, Object b)
    {
        if ( a == null )
            return b == null;

        if ( b == null )
            return false;

        return a.equals(b);
    }

    /**
     * A safe comparison to determine if two Strings are equal, ignoring case.
     */
    public static boolean isEqualIgnoreCase(String a, String b)
    {
        if ( a == null )
            return b == null;

        if ( b == null )
            return false;

        return a.equalsIgnoreCase(b);
    }

    public static boolean isNotEqual(Object a, Object b)
    {
        return !isEqual(a, b);
    }

    public static boolean isSame(Object a, Object b)
    {
        return isEqual(a, b);
    }

    public static boolean isDifferent(Object a, Object b)
    {
        return isNotEqual(a, b);
    }

    /**
     * Determine if x = y; return true if both are nan.
     */
    public static boolean isEqual(double x, double y)
    {
        if ( isNan(x) )
            return isNan(y);

        if ( isNan(y) )
            return false;

        return x == y;
    }

    /**
     * Determine if x == y within some tolerance.
     * Return true if both x and y are Nan.
     */
    public static boolean isEqual(double x, double y, double tolerance)
    {
        if ( isNan(x) )
            return isNan(y);

        if ( isNan(y) )
            return false;

        return Math.abs(x - y) <= tolerance;
    }

    /**
     * Determine if x and y are equal within a common tolerance.
     */
    public static boolean isNearEqual(double x, double y)
    {
        return isEqual(x, y, .000000001);
    }

    /**
     * Determine if the contents of a and b are identical. They must contain the
     * same number of elements and all of the elements must have the same values
     * for the same indexes. Return true if both are null.
     */
    public static boolean isEqual(byte[] a, byte[] b)
    {
        if ( a == null )
            return b == null;

        if ( b == null )
            return false;

        int n = a.length;
        if ( b.length != n )
            return false;

        for ( int i = 0; i < n; i++ )
            if ( a[i] != b[i] )
                return false;

        return true;
    }

    /**
     * A convenience method to compare a to b since it is easy to miswrite the
     * comparison logic.
     */
    public static int compare(long a, long b)
    {
        if ( a < b )
            return -1;

        if ( a > b )
            return 1;

        return 0;
    }

    /**
     * A convenience method to compare a to b since it is easy to miswrite the
     * comparison logic.
     */
    public static int compare(double a, double b)
    {
        if ( a < b )
            return -1;

        if ( a > b )
            return 1;

        return 0;
    }

    /**
     * Determine if a is less than b, first rounding both values to the
     * specified number of decimals.
     */
    public static int compare(double a, double b, int decimals)
    {
        a = round(a, decimals);
        b = round(b, decimals);
        return compare(a, b);
    }

    /**
     * Determine if a is less than b, first rounding both values to the
     * specified number of decimals.
     */
    public static boolean isLessThan(double a, double b, int decimals)
    {
        return compare(a, b, decimals) < 0;
    }

    /**
     * Determine if a is greater than b, first rounding both values to the
     * specified number of decimals.
     */
    public static boolean isGreaterThan(double a, double b, int decimals)
    {
        return compare(a, b, decimals) > 0;
    }

    /**
     * Determine the hash code of an object, return 0 if null.
     */
    public static int getHashCode(Object e)
    {
        if ( e == null )
            return 0;

        return e.hashCode();
    }

    //##################################################
    //# file names
    //##################################################

    /**
     * Determine the file names extension. This assumes that the extension is
     * the portion of the file name after the last '.'. Periods included in the
     * directory structure should be ignored.
     */
    public static String getExtension(String path)
    {
        return getExtension(new File(path));
    }

    /**
     * Determine the file names extension. This assumes that the extension is
     * the portion of the file name after the '.'. Periods included in the
     * directory structure should be ignored.
     */
    public static String getExtension(File f)
    {
        String s = f.getName();
        int i = s.lastIndexOf(CHAR_DOT);

        if ( i < 0 )
            return "";

        return s.substring(i + 1);
    }

    /**
     * Remove any previous extension and append the new extension.
     */
    public static String setExtension(String s, String ext)
    {
        String old = getExtension(s);

        if ( old.length() > 0 )
            s = removeSuffix(s, CHAR_DOT + old);

        s += CHAR_DOT;
        s += ext;
        return s;
    }

    /**
     * Remove any previous extension and append the new extension.
     */
    public static File setExtension(File f, String ext)
    {
        String path = setExtension(f.getPath(), ext);
        return new File(path);
    }

    private static String _joinFilePath(String a, String b)
    {
        return _joinPath(a, b, CHAR_SLASH);
    }

    private static String _joinUrlPath(String a, String b)
    {
        return _joinPath(a, b, CHAR_SLASH);
    }

    private static String _joinPath(String a, String b, char join)
    {
        return _joinPath(a, b, join + "");
    }

    /**
     * Return the result of joining two paths together. This method assumes that
     * a forward slash (/) is used as the file separator. Also, this takes care
     * of checking wither the first path already ends with a separator, or the
     * second path already ends with a separator; so the resulting path will
     * always have a single separator between the two parts. Finally, all
     * backslashes are converted to forward slashes for consistency.
     */
    private static String _joinPath(String a, String b, String join)
    {
        if ( a == null && b == null )
            return null;

        if ( a == null )
            a = "";

        if ( b == null )
            b = "";

        a = a.trim();
        b = b.trim();

        a = replaceAll(a, CHAR_BACKSLASH, join);
        b = replaceAll(b, CHAR_BACKSLASH, join);

        String ab = a + b;
        boolean leading = ab.startsWith(join);
        boolean trailing = ab.endsWith(join);

        if ( hasValue(a) && hasValue(b) )
        {
            while ( a.endsWith(join) )
                a = removeSuffix(a, join);

            while ( b.startsWith(join) )
                b = removePrefix(b, join);
        }

        String s;
        if ( a.equals("") )
            s = b;
        else
            if ( b.equals("") )
                s = a;
            else
                s = a + join + b;

        if ( leading )
            s = ensurePrefix(s, join);

        if ( trailing )
            s = ensureSuffix(s, join);

        return s;
    }

    /**
     * See _joinPath(String a, String b);
     */
    public static String joinFilePath(String... arr)
    {
        return joinFilePath(new KmList<String>(arr));
    }

    /**
     * See _joinPath(String a, String b);
     */
    public static String joinFilePath(KmList<String> v)
    {
        String s = null;

        for ( String e : v )
            s = _joinFilePath(s, e);

        return s;
    }

    /**
     * See _joinPath(String a, String b);
     */
    public static String joinUrlPath(String... arr)
    {
        return joinUrlPath(new KmList<String>(arr));
    }

    /**
     * See _joinPath(String a, String b);
     */
    public static String joinUrlPath(KmList<String> v)
    {
        String s = null;

        for ( String e : v )
            s = _joinUrlPath(s, e);

        return s;
    }

    public static String getCanonicalPath(File file)
    {
        try
        {
            return KmFileUtility.normalize(file.getCanonicalPath());
        }
        catch ( IOException ex )
        {
            throw toRuntime(ex);
        }
    }

    public static String getCanonicalPath(String path)
    {
        return getCanonicalPath(new File(path));
    }

    public static String getRootPath(String path)
    {
        path = getCanonicalPath(path);
        File file = new File(path);

        while ( true )
        {
            File parent = file.getParentFile();
            if ( parent == null )
                return getCanonicalPath(file);

            file = parent;
        }
    }

    public static String getReleativePath(String path)
    {
        path = getCanonicalPath(path);

        String root = getRootPath(path);

        return removePrefix(path, root);
    }

    public static String getWorkingFolder()
    {
        try
        {
            return new File("").getCanonicalPath();
        }
        catch ( Exception ex )
        {
            throw toRuntime(ex);
        }
    }

    /**
     * Determine if a path matches the pattern.
     * 
     * The path follow the form: a/b/c.  
     * Backslashes are converted to forward slashes.
     *
     * NOTE: the pattern matches on * instead of @,
     * but I cannot put the stars in the comment.
     * So USE *'s!
     * 
     * The pattern follows the general form of
     *      a/b/c/@/d/@@/e
     * Where * matches exactly one element and **
     * match 0 to many elements.
     */
    public static boolean matchesPath(String path, String pattern)
    {
        path = Kmu.replaceAll(path, BACKSLASH, SLASH);

        String r;
        r = pattern;
        r = Kmu.replaceAll(r, "*", "@");
        r = Kmu.replaceAll(r, "/@@/", "/.*/");
        r = Kmu.replaceAll(r, "@@/", "([^/]*/)*");
        r = Kmu.replaceAll(r, "/@@", "(/[^/]*)*");
        r = Kmu.replaceAll(r, "@/", "[^/]*/");
        r = Kmu.replaceAll(r, "/@", "/[^/]*");
        r = "^" + r + "$";

        Pattern p = Pattern.compile(r);
        Matcher m = p.matcher(path);

        return m.matches();
    }

    //##################################################
    //# file
    //##################################################

    public static boolean fileExists(String path)
    {
        if ( isEmpty(path) )
            return false;

        File f = new File(path);
        return f.exists();
    }

    /**
     * Return the contents of the file. No conversions are made and the file is
     * assumed to be compatible with String. Any exceptions are throw as a
     * RuntimeException.
     */
    public static String readTextFile(File f)
    {
        return readTextFile(f.getPath());
    }

    /**
     * Return the contents of the file. No conversions are made and the file is
     * assumed to be compatible with String. Any exceptions are throw as a
     * RuntimeException.
     */
    public static String readTextFile(String path)
    {
        KmReaderProcessorIF p = new KmReaderProcessorIF()
        {
            @Override
            public Object process(Reader r, Object... args) throws IOException
            {
                StringBuilder sb = new StringBuilder();
                while ( true )
                {
                    int i = r.read();
                    if ( i < 0 )
                        break;

                    sb.append((char)i);
                }
                return sb.toString();
            }
        };
        return (String)process(path, p);
    }

    /**
     * Return the contents of the file. Conversions are made and the file is
     * assumed to be compatible with String. Any exceptions are throw as a
     * RuntimeException.
     */
    public static String readTextFileUnicode(String path)
    {
        byte[] bytes = readByteFile(path);
        return new String(
            Charset.forName(KmConstantsIF.UTF_16).decode(ByteBuffer.wrap(bytes)).array());
    }

    public static Object process(String path, KmReaderProcessorIF p, Object... args)
    {
        BufferedReader in = null;
        try
        {
            if ( CHECK_FILE_NAME_CASE && !checkFileNameCase(path) )
                fatal("Cannot find file: %s.", path);

            in = new BufferedReader(new FileReader(path));
            return p.process(in, args);
        }
        catch ( IOException ex )
        {
            KmLog.error(ex, "Cannot read file(%s)", path);
            return null;
        }
        finally
        {
            closeSafely(in);
        }
    }

    /**
     * Return the contents of the file and return the list of lines.
     */
    public static KmList<String> readTextFileLines(File f)
    {
        return readTextFileLines(f.getPath());
    }

    /**
     * Return the contents of the file and return the list of lines.
     */
    public static KmList<String> readTextFileLines(String path)
    {
        String s = readTextFile(path);
        return getLines(s);
    }

    /**
     * Read all remaining bytes from the input stream
     * and return them as a String.
     * The stream is NOT closed.  Any exceptions will
     * be wrapped and thrown as Runtime exceptions.
     */
    public static String readStringFrom(InputStream is)
    {
        return new String(readBytesFrom(is));
    }

    /**
     * Read all remaining bytes from the input stream.
     * The stream is NOT closed.  Any exceptions will
     * be wrapped and thrown as Runtime exceptions.
     */
    public static byte[] readBytesFrom(InputStream in)
    {
        try
        {
            ByteArrayOutputStream out;
            out = new ByteArrayOutputStream();
            in = toBufferedInputStream(in);

            while ( true )
            {
                int i = in.read();
                if ( i < 0 )
                    break;

                out.write(i);
            }

            out.close();
            return out.toByteArray();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    /**
     * Return a buffered input stream.  If the parameter is already a
     * buffered input stream, then just cast it.
     */
    public static BufferedInputStream toBufferedInputStream(InputStream in)
    {
        if ( in instanceof BufferedInputStream )
            return (BufferedInputStream)in;

        return new BufferedInputStream(in);
    }

    /**
     * Create or overwrite the contents of a file. Any exceptions are throw as a
     * RuntimeException.
     */
    public static void writeFile(File f, String text)
    {
        writeFile(f.getPath(), text);
    }

    /**
     * Create or overwrite the contents of a file. Any exceptions are throw as a
     * RuntimeException.
     */
    public static void writeFile(String path, String text)
    {
        boolean append = false;
        writeFile(path, text, append);
    }

    /**
     * Append the value to a file.  Create the file if missing.
     */
    public static void appendToFile(String path, String text)
    {
        boolean append = true;
        writeFile(path, text, append);
    }

    /**
     * Create or overwrite the contents of a file. Any exceptions are throw as a
     * RuntimeException.
     */
    public static void writeFile(String path, String text, boolean append)
    {
        BufferedWriter out = null;
        try
        {
            out = new BufferedWriter(new FileWriter(path, append));
            out.write(text, 0, text.length());
            out.flush();
        }
        catch ( IOException ex )
        {
            throw toRuntime(ex);
        }
        finally
        {
            closeSafely(out);
        }
    }

    /**
     * Create or overwrite the contents of a file. Any exceptions are throw as a
     * RuntimeException.
     */
    public static void writeFile(String path, KmWriteableIF writeable)
    {
        BufferedWriter out = null;
        try
        {
            out = new BufferedWriter(new FileWriter(path));
            writeable.writeOn(out);
            out.flush();
        }
        catch ( IOException ex )
        {
            throw toRuntime(ex);
        }
        finally
        {
            closeSafely(out);
        }
    }

    /**
     * Read the contents of the file into a byte array. Exceptions are printed
     * to System.out but are not thrown.
     */
    public static byte[] readByteFile(File f)
    {
        return readByteFile(f.getPath());
    }

    /**
     * Read the contents of the file into a byte array. Exceptions are printed
     * to System.out but are not thrown.
     */
    public static byte[] readByteFile(String path)
    {
        BufferedInputStream in = null;
        ByteArrayOutputStream out = null;

        try
        {
            if ( CHECK_FILE_NAME_CASE && !checkFileNameCase(path) )
                throw new RuntimeException("Cannot find file: " + path);

            int n = (int)new File(path).length();
            in = new BufferedInputStream(new FileInputStream(path));
            out = new ByteArrayOutputStream(n);

            while ( true )
            {
                int i = in.read();
                if ( i < 0 )
                    break;

                out.write(i);
            }

            out.flush();
            return out.toByteArray();
        }
        catch ( IOException ex )
        {
            throw toRuntime(ex);
        }
        finally
        {
            closeSafely(in);
            closeSafely(out);
        }
    }

    /**
     * Read the byte contents of the file into an integer array. Each integer in
     * the array represents one byte from the file. This is often convenient so
     * that the bytes can be processed as having a range of 0..255 instead of
     * -128..127. Exceptions are printed to System.out but are not thrown.
     */
    public static int[] readByteFileAsIntegers(String path)
    {
        byte[] ba = readByteFile(path);
        int n = ba.length;
        int[] ia = new int[n];

        for ( int i = 0; i < n; i++ )
        {
            int x = ba[i];
            if ( x < 0 )
                x += 256;
            ia[i] = x;
        }

        return ia;
    }

    /**
     * Delete a file
     */
    public static boolean deleteFile(String path)
    {
        File f = new File(path);
        return f.delete();
    }

    /**
     * Move a file from one location to another.
     */
    public static boolean moveFile(String oldPath, String newPath)
    {
        File oldFile = new File(oldPath);
        File newFile = new File(newPath);

        return oldFile.renameTo(newFile);
    }

    /**
     * Write the byte array to the file. Exceptions are printed to System.out
     * but are not thrown.
     */
    public static void writeFile(String path, byte[] arr)
    {
        File f = new File(path);
        writeFile(f, arr);
    }

    /**
     * Write the byte array to the file. Exceptions are printed to System.out
     * but are not thrown.
     */
    public static void writeFile(File f, byte[] arr)
    {
        boolean append = false;
        writeFile(f, arr, append);
    }

    /**
     * Append the value to a file.  Create file if missing.
     */
    public static void appendToFile(File f, byte[] arr)
    {
        boolean append = true;
        writeFile(f, arr, append);
    }

    /**
     * Write the byte array to the file. Exceptions are printed to System.out
     * but are not thrown.
     */
    public static void writeFile(File f, byte[] arr, boolean append)
    {
        BufferedOutputStream out = null;
        try
        {
            out = new BufferedOutputStream(new FileOutputStream(f, append));
            out.write(arr);
            out.flush();
        }
        catch ( IOException ex )
        {
            throw toRuntime(ex);
        }
        finally
        {
            closeSafely(out);
        }
    }

    /**
     * Ensure that the specified path exists. If it does not exist then attempt
     * to create it. Return true if the path was successfully created.  The entire
     * path is assumed to be a directory.
     * Exceptions are printed to System.out but are not thrown.
     */
    public static boolean createFolder(String s)
    {
        File f = new File(s);
        return createFolder(f);
    }

    /**
     * Ensure that the specified path exists. If it does not exist then attempt
     * to create it. Return true if the path was successfully created.
     * The entire path is assumed to be a directory.
     * Exceptions are logged but are not thrown.
     */
    public static boolean createFolder(File f)
    {
        try
        {
            f = f.getCanonicalFile();
            if ( f.exists() )
                return true;

            File p = f.getParentFile();
            if ( !createFolder(p) )
                return false;

            return f.mkdir();
        }
        catch ( IOException ex )
        {
            KmLog.error(ex, "Cannot create directory (%s).", f.getPath());
            return false;
        }
    }

    /**
     * Copy one file to another.
     */
    public static void copyFile(File in, File out)
    {
        byte[] arr = readByteFile(in);
        writeFile(out, arr);
    }

    /**
     * Copy one file to another director.
     */
    public static void copyFileToDirectory(File in, File dir)
    {
        String name = in.getName();
        File out = new File(dir, name);
        copyFile(in, out);
    }

    /**
     * Generate a unique file name for the specified directory by using today's
     * 8-digit date as the file name, and an incrementing number for the
     * extension. E.g.: 20050131.005. The extension starts at 0 and increments
     * through 999 testing for a unique name. If a unique name is not found the
     * method returns null.
     */
    public static String getUniqueFileName(String dirPath)
    {
        KmDate d = KmDate.createTodayUtc();
        KmDateFormatter f = new KmDateFormatter("{yyyy}{mm}{dd}");
        String prefix = f.format(d);

        return getUniqueFileName(dirPath, prefix);
    }

    /**
     * Generate a unique file name for the specified directory by using the
     * specified prefix as the file name, and an incrementing number for the
     * extension. E.g.: myPrefix.005. The extension starts at 0 and increments
     * through 999 testing for a unique name. If a unique name is not found the
     * method returns null.
     */
    public static String getUniqueFileName(String path, String prefix)
    {
        File file;

        int n = 1000;
        for ( int i = 0; i < n; i++ )
        {
            String suffix = leftPad(i + "", 3, '0');
            String s = prefix + "." + suffix;
            file = new File(path, s);

            if ( !file.exists() )
                return file.getPath();
        }

        return null;
    }

    /**
     * A simple parser to read a properties files and return the map.
     */
    public static KmMap<String,String> readPropertiesFile(File f)
    {
        return readPropertiesFile(f.getPath());
    }

    /**
     * A simple parser to read a properties files and return the map.
     */
    public static KmMap<String,String> readPropertiesFile(String path)
    {
        KmPropertyFileReader r;
        r = new KmPropertyFileReader();
        r.addCommentPrefix("//");
        r.addCommentPrefix("#");
        return r.readFile(path);
    }

    /**
     * Write the properties to a file.
     */
    public static void writePropertiesFile(File f, KmMap<String,String> m)
    {
        writePropertiesFile(f.getPath(), m);
    }

    /**
     * Write the properties to a file.
     */
    public static void writePropertiesFile(String path, KmMap<String,String> m)
    {
        KmList<String> keys = new KmList<String>();
        keys.addAll(m.keySet());
        keys.sort();

        int maxKey = 0;

        Iterator<String> i = keys.iterator();
        while ( i.hasNext() )
        {
            String k = i.next();
            if ( k.length() > maxKey )
                maxKey = k.length();
        }

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        i = keys.iterator();
        while ( i.hasNext() )
        {
            String k = i.next();
            String v = m.get(k);
            pw.print(rightPad(k, maxKey));
            pw.print(" = ");
            pw.print(v);
            pw.println();
        }

        pw.close();
        writeFile(path, sw.toString());
    }

    /**
     * Get the list of files in a directory with a matching prefix and suffix.
     */
    public static KmList<File> getFiles(String directory, String prefix, String suffix)
    {
        File dir = new File(directory);
        return getFiles(dir, prefix, suffix);
    }

    /**
     * Get the list of files in a directory with a matching prefix and suffix.
     */
    public static KmList<File> getFiles(File directory, String prefix, String suffix)
    {
        if ( prefix == null )
            prefix = "";

        if ( suffix == null )
            suffix = "";

        KmList<File> v = new KmList<File>();
        File[] arr = directory.listFiles();

        if ( arr == null )
            fatal("Null file array for: " + directory);

        for ( File f : arr )
        {
            String s = f.getName();
            if ( s.startsWith(prefix) && s.endsWith(suffix) )
                v.add(f);
        }

        return v;
    }

    /**
     * Check the case of a file name.
     */
    public static boolean checkFileNameCase(String path)
    {
        try
        {
            File f = new File(path);
            String a = f.getName();
            String b = f.getCanonicalFile().getName();

            return isEqual(a, b);
        }
        catch ( Exception ex )
        {
            return false;
        }
    }

    /**
     * Get the parent directory of a file.  Behaves like unix dirname.
     * The path can be relative or absolute.  No checking is done
     * as this may be a remote path.
     */
    public static String dirname(String path)
    {
        File f = new File(path);
        return f.getParent();
    }

    /**
     * get a list of all directories in a path.  For example,
     * a/b/c/d/file.txt would return:
     *
     * a
     * a/b
     * a/b/c
     * a/b/c/d
     *
     * Usefull for creating directories recursively.
     */
    public static KmList<String> getDirsRecursively(String path)
    {
        KmList<String> result = new KmList<String>();

        if ( path == null )
            return result;

        result.add(path);
        File f = new File(path);
        String p = null;

        while ( (p = f.getParent()) != null )
        {
            if ( !p.equals("/") )
                result.add(p);

            f = f.getParentFile();
        }

        result.reverse();
        return result;
    }

    /**
     * Used to suppress warning about hardcoded paths.
     * This should only be used by code where it really
     * is ok to hardcode a fragile file path.
     */
    public static String getHardcodedPath(String s)
    {
        return s;
    }

    /**
     * Call e.close, but wrap the call in a try/catch block
     * that logs any exception without throwing it.
     */
    public static void closeSafely(InputStream e)
    {
        try
        {
            if ( e != null )
                e.close();
        }
        catch ( Exception ex )
        {
            KmLog.error(ex, "Cannot close input stream.");
        }
    }

    /**
     * Call e.close, but wrap the call in a try/catch block
     * that logs any exception without throwing it.
     */
    public static void closeSafely(OutputStream e)
    {
        try
        {
            if ( e != null )
                e.close();
        }
        catch ( Exception ex )
        {
            KmLog.error(ex, "Cannot close output stream.");
        }
    }

    /**
     * Call e.close, but wrap the call in a try/catch block
     * that logs any exception without throwing it.
     */
    public static void closeSafely(RandomAccessFile e)
    {
        try
        {
            if ( e != null )
                e.close();
        }
        catch ( Exception ex )
        {
            KmLog.error(ex, "Cannot close random access.");
        }
    }

    /**
     * Call e.close, but wrap the call in a try/catch block
     * that logs any exception without throwing it.
     */
    public static void closeSafely(Reader e)
    {
        try
        {
            if ( e != null )
                e.close();
        }
        catch ( Exception ex )
        {
            KmLog.error(ex, "Cannot close reader.");
        }
    }

    /**
     * Call e.close, but wrap the call in a try/catch block
     * that logs any exception without throwing it.
     */
    public static void closeSafely(Writer e)
    {
        try
        {
            if ( e != null )
                e.close();
        }
        catch ( Exception ex )
        {
            KmLog.error(ex, "Cannot close writer.");
        }
    }

    /**
     * Call e.close, but wrap the call in a try/catch block
     * that logs any exception without throwing it.
     */
    public static void closeSafely(Statement e)
    {
        try
        {
            if ( e != null )
                e.close();
        }
        catch ( Exception ex )
        {
            KmLog.error(ex, "Cannot close statement.");
        }
    }

    /**
     * Call e.close, but wrap the call in a try/catch block
     * that logs any exception without throwing it.
     */
    public static void closeSafely(ResultSet e)
    {
        try
        {
            if ( e != null )
                e.close();
        }
        catch ( Exception ex )
        {
            KmLog.error(ex, "Cannot close result set.");
        }
    }

    //##################################################
    //# object copy
    //##################################################

    /**
     * Create a deep copy of the object using the java serialization protocol.
     */
    public static <T extends Serializable> T getSerializedCopy(T e)
    {
        return KmUnchecked.getSerializedCopy(e);
    }

    /**
     * Determine the size (in bytes) of the serialized object.
     */
    public static int getSerializedObjectSize(Serializable o)
    {
        try
        {
            ByteArrayOutputStream baos;
            baos = new ByteArrayOutputStream();

            ObjectOutputStream oos;
            oos = new ObjectOutputStream(baos);
            oos.writeObject(o);
            oos.flush();
            oos.close();

            return baos.toByteArray().length;
        }
        catch ( Exception ex )
        {
            throw toRuntime(ex);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T extends KmCopyIF> T copy(T e)
    {
        if ( e == null )
            return null;

        return (T)e.getCopy();
    }

    //##################################################
    //# lists
    //##################################################

    /**
     * Add a prefix to all of the key in a map. The orginal map is left
     * unchanged, a map with the new keys is returned. Assumes all keys are
     * Strings.
     */
    public static KmMap<String,Object> addPrefixToKeys(KmMap<String,Object> m, String prefix)
    {
        KmMap<String,Object> result = new KmMap<String,Object>();

        for ( String e : m.getKeys() )
        {
            String key = prefix + e;
            Object value = m.get(e);
            result.put(key, value);
        }

        return result;
    }

    public static String[] toStringArray(KmList<String> v)
    {
        int i = 0;
        String[] arr = new String[v.size()];

        for ( String e : v )
            arr[i++] = e;

        return arr;
    }

    public static Integer[] toIntegerArray(KmList<Integer> v)
    {
        int i = 0;
        Integer[] arr = new Integer[v.size()];

        for ( Integer e : v )
            arr[i++] = e;

        return arr;
    }

    public static Integer[] toIntegerArray(KmSetImpl<Integer> v)
    {
        int i = 0;
        Integer[] arr = new Integer[v.size()];

        for ( Integer e : v )
            arr[i++] = e;

        return arr;
    }

    public static <T> T[] toArray(T... v)
    {
        return v;
    }

    public static Boolean isListEmpty(KmList<?> v)
    {
        if ( v == null )
            return true;

        return v.isEmpty();
    }

    public static KmList<String> toStringList(String... arr)
    {
        KmList<String> v;
        v = new KmList<String>();
        v.addAll(arr);
        return v;
    }

    /**
     * Caution: this will necessarily iterate through the iterator.
     */
    public static int count(Iterator<?> i)
    {
        int n = 0;
        while ( i.hasNext() )
        {
            i.next();
            n++;
        }
        return n;

    }

    //##################################################
    //# display
    //##################################################

    /**
     * Return the "short" name of the class. The package name is not included.
     */
    public static String getSimpleClassName(Object e)
    {
        if ( e == null )
            return "null";

        Class<?> c = e instanceof Class<?>
            ? (Class<?>)e
            : e.getClass();

        return getSimpleClassName(c);
    }

    /**
     * Return the "short" name of the class. The package name is not included.
     */
    public static String getSimpleClassName(Class<?> c)
    {
        if ( c == null )
            return "null";

        return c.getSimpleName();
    }

    /**
     * Return the package name of the class.
     */
    public static String getPackageName(Object e)
    {
        if ( e == null )
            return "null";

        Class<?> c = e instanceof Class<?>
            ? (Class<?>)e
            : e.getClass();

        return getPackageName(c);
    }

    /**
     * Return the package name of the class.
     */
    public static String getPackageName(Class<?> e)
    {
        if ( e == null )
            return "null";

        return e.getPackage().getName();
    }

    public static String format_trueFalse(Boolean e)
    {
        if ( e == null )
            return null;

        if ( e )
            return "true";

        return "false";
    }

    //##################################################
    //# formatting
    //##################################################

    /**
     * Add commas to the integer in standard american format.
     */
    public static String formatInteger(long value)
    {
        int min = value < 0
            ? 2
            : 1;

        StringBuilder out;
        out = new StringBuilder();
        out.append(value);

        int i = out.length() - 3;
        while ( i >= min )
        {
            out.insert(i, CHAR_COMMA);
            i -= 3;
        }

        return out.toString();
    }

    /**
     * Format a double using commas for the integer portion and rounded to the
     * appropriate number of decimal places.
     */
    public static String formatDouble(double d, int places)
    {
        return formatDouble(d, places, true);
    }

    /**
     * Format a double using optional commas for the integer portion and rounded
     * to the appropriate number of decimal places.
     */
    public static String formatDouble(double d, int places, boolean commas)
    {
        if ( Double.isNaN(d) )
            return "NaN";

        d = round(d, places);
        String s = getDecimalFormat(places, commas);

        return new DecimalFormat(s).format(d);
    }

    /**
     * This returns the appropriate format for the Java DecimalFormat class
     * depending on the desired number of decimal places and optional comma
     * display.
     */
    public static String getDecimalFormat(int places, boolean commas)
    {
        if ( places == 0 )
            return commas
                ? "#,##0"
                : "0";

        StringBuilder out = new StringBuilder();

        if ( commas )
            out.append("#,##");

        out.append("0.");

        for ( int i = 0; i < places; i++ )
            out.append("0");

        return out.toString();
    }

    /**
     * Pad i with leading zeros until its length is n. Return i if its length
     * is greater than n.
     */
    public static String leadZero(Integer i, int n)
    {
        if ( i == null )
            return leftPad("", n, CHAR_ZERO);

        return leftPad(i.toString(), n, CHAR_ZERO);
    }

    /**
     * Pad s with leading spaces until its length is n. Return s if its length
     * is greater than n.
     */
    public static String leftPad(String s, int n)
    {
        return leftPad(s, n, CHAR_SPACE);
    }

    /**
     * Pad s with leading c's until its length is n. Return s if its length is
     * greater than n.
     */
    public static String leftPad(String s, int n, char c)
    {
        StringBuilder out = new StringBuilder();
        n -= s.length();

        for ( int i = 0; i < n; i++ )
            out.append(c);

        out.append(s);
        return out.toString();
    }

    /**
     * Pad the value with leading zeroes such that the total length is n.
     */
    public static String leftPad(int value, int n)
    {
        return leftPad(value + "", n, CHAR_ZERO);
    }

    /**
     * Pad s with trailing spaces until its length is n. Return s if its length
     * is greater than n.
     */
    public static String rightPad(String s, int n)
    {
        return rightPad(s, n, CHAR_SPACE);
    }

    /**
     * Pad s with trailing c's until its length is n. Return s if its length is
     * greater than n.
     */
    public static String rightPad(String s, int n, char c)
    {
        StringBuilder out;
        out = new StringBuilder(n);
        out.append(s);

        while ( out.length() < n )
            out.append(c);

        return out.toString();
    }

    /**
     * Pad s with leading spaces and (space provided) trailing spaces until its
     * length is n. Return s if its length is greater than n.
     */
    public static String outsidePad(String s, int n)
    {
        return outsidePad(s, n, ' ');
    }

    /**
     * Pad s with leading c's and (space provided) trailing c's until its length
     * is n. Return s if its length is greater than n.
     */
    public static String outsidePad(String s, int n, char c)
    {
        StringBuilder out;
        out = new StringBuilder(n);
        out.append(s);

        while ( out.length() < n )
        {
            out.insert(0, c);

            if ( out.length() < n )
                out.append(c);
        }

        return out.toString();
    }

    //##################################################
    //# hex
    //##################################################

    /**
     * Return the 2-character hex code for this byte. Note, the return string is
     * always two characters even if the leading character (or both) are zero.
     */
    public static String formatHexString(byte b)
    {
        return "" + HEX_CHAR_ARRAY[b >> 4 & 15] + HEX_CHAR_ARRAY[b & 15];
    }

    /**
     * Return the hex string for the byte array. Each byte is converted to a
     * 2-byte hex string.  The bytes are printed with no separator.
     */
    public static String formatHexString(String s)
    {
        return formatHexString(s.getBytes());
    }

    /**
     * Return the hex string for the byte array. Each byte is converted to a
     * 2-byte hex string.
     */
    public static String formatHexString(String s, String separator)
    {
        return formatHexString(s.getBytes(), separator);
    }

    /**
     * Return the hex string for the byte array. Each byte is converted to a
     * 2-byte hex string.  The bytes are printed with no separator.
     */
    public static String formatHexString(byte[] arr)
    {
        return formatHexString(arr, Integer.MAX_VALUE);
    }

    /**
     * Return the hex string for the byte array. Each byte is converted to a
     * 2-byte hex string.  Only the first maxBytes are displayed.
     */
    public static String formatHexString(byte[] arr, int maxBytes)
    {
        return formatHexString(arr, maxBytes, null);
    }

    public static String formatHexString(byte[] arr, String separator)
    {
        return formatHexString(arr, Integer.MAX_VALUE, separator);
    }

    public static String formatHexString(byte[] arr, int maxBytes, String separator)
    {
        StringBuilder out = new StringBuilder();

        int n = Math.min(arr.length, maxBytes);
        for ( int i = 0; i < n; i++ )
        {
            byte b = arr[i];
            String c = formatHexString(b);
            out.append(c);

            if ( separator != null && i < n - 1 )
                out.append(separator);
        }

        return out.toString();
    }

    /**
     * Parse a hex string into a byte array. Assumes that every all characters
     * are valid hex characters 0..F. Upper and lowercase are accepted. Assumes
     * no spaces or other delimiters between the hex pairs.
     */
    public static byte[] parseHexBytes(String s)
    {
        s = s.toUpperCase();
        int n = s.length() / 2;
        byte[] arr = new byte[n];

        for ( int i = 0; i < n; i++ )
        {
            char c;
            byte b;

            c = s.charAt(i * 2);
            b = (byte)HEX_CHAR_STRING.indexOf(c);

            c = s.charAt(i * 2 + 1);
            b = (byte)(b << 4 | (byte)HEX_CHAR_STRING.indexOf(c));

            arr[i] = b;
        }
        return arr;
    }

    /**
     * Parse a hex string into a single byte.  The string must be exactly two
     * characters long.  Valid hex characters 0..F. Upper and lowercase are accepted.
     */
    public static byte parseHexByte(String s)
    {
        if ( s.length() != 2 )
            fatal("Hex string must be exactly two characters.");

        s = s.toUpperCase();

        char c;
        byte b;

        c = s.charAt(0);
        b = (byte)HEX_CHAR_STRING.indexOf(c);

        c = s.charAt(1);
        b = (byte)(b << 4 | (byte)HEX_CHAR_STRING.indexOf(c));

        return b;
    }

    //##################################################
    //# thread
    //##################################################

    /**
     * A convenience wrapper for Thread.sleep that bags any exception.
     */
    public static void sleepMs(long ms)
    {
        try
        {
            if ( ms <= 0 )
                return;

            Thread.sleep(ms);
        }
        catch ( InterruptedException ex )
        {
            throw toRuntime(ex);
        }
    }

    public static void sleepSeconds(long seconds)
    {
        sleepMs(seconds * 1000);
    }

    /**
     * A convenience method for consistency with other thread methods that are
     * wrapped here.
     */
    public static void yield()
    {
        Thread.yield();
    }

    /**
     * A convenience method to print the current stack trace.
     */
    public static void printStackTrace()
    {
        Thread.dumpStack();
    }

    /**
     * A convenience method to print the current stack trace.
     */
    public static void printStackTrace(String title)
    {
        System.out.println(title);
        Thread.dumpStack();
    }

    public static void printStackTrace(Throwable ex)
    {
        System.out.println(formatStackTrace(ex));
    }

    public static String formatStackTrace(Throwable ex)
    {
        return KmExceptionUtility.formatNormal(ex);
    }

    public static String formatStackTrace()
    {
        return formatStackTrace("Stack Trace");
    }

    public static String formatStackTrace(String name)
    {
        try
        {
            throw new RuntimeException(name);
        }
        catch ( RuntimeException ex )
        {
            return formatStackTrace(ex);
        }
    }

    public static Throwable newException()
    {
        try
        {
            throw new RuntimeException();
        }
        catch ( Exception ex )
        {
            return ex;
        }
    }

    public static StackTraceElement[] getStackTrace()
    {
        return Thread.currentThread().getStackTrace();
    }

    public static StackTraceElement[] getLocalStackTrace()
    {
        return getLocalStackTrace(1, -1);
    }

    public static StackTraceElement[] getLocalStackTrace(int firstLine, int lineCount)
    {
        StackTraceElement[] arr = Thread.currentThread().getStackTrace();

        int i = firstLine + 3;
        int n = arr.length - i;

        if ( n < 0 )
            n = 0;

        if ( lineCount > 0 && n > lineCount )
            n = lineCount;

        StackTraceElement[] target = new StackTraceElement[n];
        System.arraycopy(arr, i, target, 0, n);

        return target;
    }

    public static String formatLocalStackTrace()
    {
        return formatLocalStackTrace(1, -1);
    }

    public static String formatLocalStackTrace(int firstLine, int lineCount)
    {
        StackTraceElement[] arr = getLocalStackTrace(firstLine + 1, lineCount);
        KmStringBuilder out = new KmStringBuilder();

        for ( StackTraceElement e : arr )
        {
            out.printRepeat(CHAR_SPACE, 4);
            out.println(e);
        }

        return out.toString().trim();
    }

    /**
     * Return the class and method that called me.
     */
    public static String getSender()
    {
        return Thread.currentThread().getStackTrace()[4].toString();
    }

    //##################################################
    //# exceptions
    //##################################################

    /**
     * Conver the exception to one that can be throw 'unchecked'.
     * If the exception is already a runtime exception then simply return it.
     * Otherwise, wrap it in a RuntimeException.
     */
    public static RuntimeException toRuntime(Throwable ex)
    {
        if ( ex instanceof RuntimeException )
            return (RuntimeException)ex;

        return new RuntimeException(ex);
    }

    /**
     * An error that is severe enough that the user will not be able to continue
     * after viewing the error message.  Direct the user to an independent error
     * message screen.  After which they system will redirect them to the "top"
     * of the current module.
     */
    public static void fatal(String msg, Object... args)
    {
        throw createFatal(msg, args);
    }

    public static RuntimeException createFatal(String msg, Object... args)
    {
        String s = format(msg, args);
        return new RuntimeException(s);
    }

    public static RuntimeException createFatal(Exception ex, String msg, Object... args)
    {
        String s = format(msg, args);
        return new RuntimeException(s, ex);
    }

    public static void fatal(Exception ex, String msg, Object... args)
    {
        String s = format(msg, args);
        throw new RuntimeException(s, ex);
    }

    /**
     * An error has occurred that disallows the requested action from proceeding.
     * The error is shown at the top of the redisplayed page and the user is
     * expected to correct the error and resubmit.
     */
    public static void error(String msg, Object... args)
    {
        throw new KmApplicationException(msg, args);
    }

    /**
     * Throw a runtime exception for the purpose of cancelling
     * the current operation.   This is typically used by ajax
     * handlers to exit the current execution stack after errors
     * have been added to the http response.
     */
    public static void cancel()
    {
        throw new KmCancelException();
    }

    public static void accessError(String msg, Object... args)
    {
        throw new KmRoleViolationException(msg, args);
    }

    public static Throwable getRootCause(Throwable ex)
    {
        while ( true )
        {
            Throwable cause = ex.getCause();
            if ( cause == null )
                return ex;

            ex = cause;
        }
    }

    public static String getRootMessage(Throwable ex)
    {
        return getRootCause(ex).getMessage();
    }

    public static void checkInstalled(boolean installed)
    {
        if ( installed )
            fatal("Already installed.");
    }

    //##################################################
    //# arrays
    //##################################################

    public static String[] appendToArray(String[] source, String... suffix)
    {
        return mergeArrays(source, suffix);
    }

    public static String[] prependToArray(String[] source, String... prefix)
    {
        return mergeArrays(prefix, source);
    }

    public static String[] mergeArrays(String[]... arrays)
    {
        int n = 0;

        for ( String[] arr : arrays )
            n += arr.length;

        String[] target = new String[n];
        int pos = 0;

        for ( String[] arr : arrays )
        {
            System.arraycopy(arr, 0, target, pos, arr.length);
            pos += arr.length;
        }

        return target;
    }

    public static long indexOf(char[] arr, char c)
    {
        int n = arr.length;
        for ( int i = 0; i < n; i++ )
            if ( arr[i] == c )
                return i;

        return -1;
    }

    //##################################################
    //# byte array
    //##################################################

    /**
     * Create a byte array from source, starting at offset, with a total of
     * length bytes. No bounds checking is performed.
     */
    public static byte[] getBytes(byte[] arr, int offset, int length)
    {
        if ( arr == null )
            return null;

        byte[] buf = new byte[length];

        for ( int i = 0; i < length; i++ )
            buf[i] = arr[offset + i];

        return buf;
    }

    /**
     * Create a byte array from source, starting at the first byte, with a total
     * of length bytes. No bounds checking is performed.
     */
    public static byte[] getBytes(byte[] arr, int length)
    {
        return getBytes(arr, 0, length);
    }

    /**
     * Return the a bytes array composed of the bytes from the source array
     * located at even indexes. Bytes from arr[0], arr[2], arr[4], etc...
     */
    public static byte[] evenBytes(byte[] arr)
    {
        if ( arr == null )
            return null;

        int n = arr.length;
        byte[] result = new byte[(n + 1) / 2];

        for ( int i = 0; i < n; i += 2 )
            result[i / 2] = arr[i];

        return result;
    }

    /**
     * Return the a bytes array composed of the bytes from the source array
     * located at even indexes. Bytes from arr[1], arr[3], arr[5], etc...
     */
    public static byte[] oddBytes(byte[] arr)
    {
        if ( arr == null )
            return null;

        int n = arr.length;
        byte[] result = new byte[n / 2];

        for ( int i = 1; i < n; i += 2 )
            result[i / 2] = arr[i];

        return result;
    }

    //##################################################
    //# bits
    //##################################################

    /**
     * Reverse the bit order in an integer. This is not xor-ing or not-ing the
     * int. If the integer is thought of as an array, the result is swap(0, 15),
     * swap(1, 14), etc...
     */
    public static int reverseBits(int arr)
    {
        int n = 32;
        int result = 0;

        for ( int i = 0; i < n; i++ )
        {
            result <<= 1;

            if ( (arr & 1) == 1 )
                result |= 1;

            arr >>= 1;
        }

        return result;
    }

    //##################################################
    //# radix
    //##################################################

    /**
     * Convert the integer to a string representation.  The chars
     * parameter defines the characters used and also implies the
     * radix (chars.length).
     */
    public static String formatRadixString(long i, char[] radixChars)
    {
        int radix = radixChars.length;
        char[] buf = new char[65]; // big enough for radix-2 (64) plus sign
        int charPos = 64;
        boolean negative = i < 0;

        if ( !negative )
            i = -i;

        while ( i <= -radix )
        {
            int j = (int)-(i % radix);
            buf[charPos--] = radixChars[j];
            i = i / radix;
        }

        buf[charPos] = radixChars[(int)-i];

        if ( negative )
            buf[--charPos] = CHAR_DASH;

        return new String(buf, charPos, 65 - charPos);
    }

    /**
     * Convert a string in the integer to a string representation.  The chars
     * parameter defines the characters used and also implies the
     * radix (chars.length).
     */
    public static long parseRadixString(String s, char[] radixChars)
    {
        int radix = radixChars.length;
        long result = 0;
        int n = s.length();

        for ( int i = 0; i < n; i++ )
        {
            char c = s.charAt(i);
            result *= radix;
            result += indexOf(radixChars, c);
        }

        return result;
    }

    public static String formatBase62(long i)
    {
        return formatRadixString(i, BASE_62_ARRAY);
    }

    public static long parseBase62(String s)
    {
        return parseRadixString(s, BASE_62_ARRAY);
    }

    public static String formatBase36(long i)
    {
        return formatRadixString(i, BASE_36_ARRAY);
    }

    public static long parseBase36(String s)
    {
        return parseRadixString(s, BASE_36_ARRAY);
    }

    public static String formatBase20(long i)
    {
        return formatRadixString(i, BASE_20_ARRAY);
    }

    public static long parseBase20(String s)
    {
        return parseRadixString(s, BASE_20_ARRAY);
    }

    //##################################################
    //# hostname
    //##################################################

    public static String getLocalHostName()
    {
        try
        {
            return InetAddress.getLocalHost().getHostName();
        }
        catch ( UnknownHostException ex )
        {
            throw toRuntime(ex);
        }
    }

    public static String getCanonicalLocalHostName()
    {
        try
        {
            return InetAddress.getLocalHost().getCanonicalHostName();
        }
        catch ( UnknownHostException ex )
        {
            throw toRuntime(ex);
        }
    }

    public static String getLocalHostAddress()
    {
        try
        {
            return InetAddress.getLocalHost().getHostAddress();
        }
        catch ( UnknownHostException ex )
        {
            throw toRuntime(ex);
        }
    }

    //##################################################
    //# weight conversion
    //##################################################

    public static double kilogramsToPounds(double kilograms)
    {
        return kilograms * KmConstantsIF.POUNDS_PER_KILOGRAM;
    }

    public static double poundsToKilograms(double pounds)
    {
        return pounds * KmConstantsIF.KILOGRAMS_PER_POUND;
    }

    //##################################################
    //# testing
    //##################################################

    public static boolean allNulls(Object... args)
    {
        int n = args.length;
        for ( int i = 0; i < n; i++ )
            if ( args[i] != null )
                return false;

        return true;
    }

    public static boolean hasAllNonNulls(Object... args)
    {
        int n = args.length;
        for ( int i = 0; i < n; i++ )
            if ( args[i] == null )
                return false;

        return true;
    }

    public static boolean hasAnyNulls(Object... args)
    {
        int n = args.length;
        for ( int i = 0; i < n; i++ )
            if ( args[i] == null )
                return true;

        return false;
    }

    public static boolean hasAnyNonNulls(Object... args)
    {
        int n = args.length;
        for ( int i = 0; i < n; i++ )
            if ( args[i] != null )
                return true;

        return false;
    }

    //##################################################
    //# Uid
    //##################################################

    /**
     * Return a "unique" id based on the combination of the current time and a random value.
     * This format does NOT attempt to match the format of a formal UUID/GUID.  The returned
     * string is in the format of ttttttt-aaaaaa-bbbbbb-cccccc.  Time is roughly the number of
     * tenths of a second since Jan 1, 1970.  The values a, b, c, are each a random integer.
     * All four values are converted to a base-36, then left padded with zeroes.  
     * 
     * This format has the main advantage of being sortable by creation time.  
     * This is primarily intended as an aid in debugging, and loose sorting 
     * for data that does not require strict sequencing.
     */
    public static String newUid()
    {
        long now = System.currentTimeMillis() / 100;
        // long now = KmDate.create(2200, 1, 1).getJavaDate().getTime() / 100;

        String a = Kmu.formatBase36(now);
        String b = Kmu.formatBase36(KmRandomUtility.getPositiveInteger());
        String c = Kmu.formatBase36(KmRandomUtility.getPositiveInteger());
        String d = Kmu.formatBase36(KmRandomUtility.getPositiveInteger());

        StringBuilder out;
        out = new StringBuilder();

        out.append(leftPad(a, 7, '0'));
        out.append(CHAR_DASH);

        out.append(leftPad(b, 6, '0'));
        out.append(CHAR_DASH);

        out.append(leftPad(c, 6, '0'));
        out.append(CHAR_DASH);

        out.append(leftPad(d, 6, '0'));

        return out.toString();
    }

    /**
     * Return a (random) uuid using the standard java routine. 
     */
    public static String newJavaUid()
    {
        return UUID.randomUUID().toString();
    }

    //##################################################
    //# email
    //##################################################

    public static boolean isValidEmailAddress(String email)
    {
        return KmEmailParser.validate(email);
    }

    //##################################################
    //# testing
    //##################################################

    public static boolean all(boolean... arr)
    {
        int n = arr.length;
        for ( int i = 0; i < n; i++ )
            if ( !arr[i] )
                return false;

        return true;
    }

    public static boolean any(boolean... arr)
    {
        int n = arr.length;
        for ( int i = 0; i < n; i++ )
            if ( arr[i] )
                return true;

        return false;
    }

    public static boolean none(boolean... arr)
    {
        int n = arr.length;
        for ( int i = 0; i < n; i++ )
            if ( arr[i] )
                return false;

        return true;
    }

    //##################################################
    //# date / time
    //##################################################

    public static KmDate getDate(KmTimestamp e)
    {
        if ( e == null )
            return null;

        return e.getDate();
    }

    public static KmTime getTime(KmTimestamp e)
    {
        if ( e == null )
            return null;

        return e.getTime();
    }

    //##################################################
    //# excel
    //##################################################

    public static Integer getSpreadsheetColumnIndex(String code)
    {
        if ( code == null )
            return null;

        code = code.toUpperCase().trim();
        int n = code.length();

        if ( !isAllLetters(code) )
            return null;

        if ( n == 0 || n > 2 )
            return null;

        final char a = 'A';

        if ( n == 1 )
            return code.charAt(0) - a;

        return 26 * (code.charAt(0) - a + 1) + code.charAt(1) - a;
    }

    public static String getSpreadsheetColumnCode(Integer index)
    {
        if ( index == null )
            return null;

        if ( index < 0 )
            return null;

        final char a = 'A';

        if ( index < 26 )
            return "" + (char)(a + index);

        return "" + (char)(a + index / 26 - 1) + (char)(a + index % 26);
    }

    //##################################################
    //# enum
    //##################################################

    public static String getCode(KmCodedEnumIF e)
    {
        if ( e == null )
            return null;

        return e.getCode();
    }

    public static String getName(KmCodedEnumIF e)
    {
        if ( e == null )
            return null;

        return e.getName();
    }

    //##################################################
    //# lorem ipsum
    //##################################################

    public static String getLoremIpsum()
    {
        return "Lorem ipsum dolor sit amet, consectetur adipisicing elit, "
            + "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "
            + "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris "
            + "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in "
            + "reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla "
            + "pariatur. Excepteur sint occaecat cupidatat non proident, sunt in "
            + "culpa qui officia deserunt mollit anim id est laborum.";
    }

    public static String getLoremIpsum(int length)
    {
        return truncate(getLoremIpsum(), length, true);
    }

    public static String getLoremIpsumParagraphs(int n)
    {
        String s = getLoremIpsum() + "\n\n";
        return repeat(s, n).trim();
    }

    //##################################################
    //# html
    //##################################################

    public static String escapeHtml(String s)
    {
        s = replaceAll(s, "&", "&amp;");
        // why is this not also in KmHtmlBuffer.format(Object e)?
        s = replaceAll(s, "'", "&apos;");
        s = replaceAll(s, "\"", "&quot;");
        s = replaceAll(s, "<", "&lt;");
        s = replaceAll(s, ">", "&gt;");
        s = replaceAll(s, "\r\n", "<br>");
        s = replaceAll(s, "\r", "<br>");
        s = replaceAll(s, "\n", "<br>");
        return s;
    }

    public static String escapeJavascriptStringLiteral(String s)
    {
        s = replaceAll(s, "\"", "\\\"");
        s = replaceAll(s, "<script>", "<scr\"+\"ipt>");
        s = replaceAll(s, "</script>", "</scr\"+\"ipt>");
        return s;
    }

    //##################################################
    //# join (html style)
    //##################################################

    public static String joinHtmlStyle(String css, String next)
    {
        return joinText(css, next, ";");
    }

    public static String joinHtmlStyle(String css, String nextAttr, String nextValue)
    {
        String next = nextAttr + ":" + nextValue;
        return joinHtmlStyle(css, next);
    }

    public static String joinHtmlStyle(String css, String nextAttr, Integer nextValue)
    {
        String nextUnit = null;
        return joinHtmlStyle(css, nextAttr, nextValue, nextUnit);
    }

    public static String joinHtmlStyle(
        String css,
        String nextAttr,
        Integer nextValue,
        String nextUnit)
    {
        String s = nextValue + "";

        if ( nextUnit != null )
            s += nextUnit;

        return joinHtmlStyle(css, nextAttr, s);
    }

    //##################################################
    //# join text
    //##################################################

    public static String joinText(String prefix, String suffix, String separator)
    {
        if ( prefix == null )
            prefix = "";

        if ( suffix == null )
            suffix = "";

        if ( separator == null )
            separator = "";

        if ( prefix.length() == 0 )
            return suffix;

        if ( suffix.length() == 0 )
            return prefix;

        if ( prefix.endsWith(separator) || suffix.startsWith(separator) )
            return prefix + suffix;

        return prefix + separator + suffix;
    }

    //##################################################
    //# money
    //##################################################

    public static KmMoney add(KmMoney a, KmMoney b)
    {
        if ( a == null )
            return b;

        if ( b == null )
            return a;

        return a.add(b);
    }

    //##################################################
    //# class resource
    //##################################################

    /**
     * Read a resource from the class path.
     * For example: to read a file named "abc.txt"
     * located in the package com.kodemore you could use:
     * Kmu.readClassResource("com/kodemore/abc.txt");
     */
    public static byte[] readClassResource(String path)
    {
        InputStream in = null;
        ByteArrayOutputStream out = null;
        try
        {
            URL url = ClassLoader.getSystemResource(path);
            in = url.openStream();
            out = new ByteArrayOutputStream();

            while ( true )
            {
                int b = in.read();
                if ( b < 0 )
                    break;

                out.write(b);
            }

            return out.toByteArray();
        }
        catch ( IOException ex )
        {
            KmLog.error(ex, "Cannot read class resource(%s)", path);
            return null;
        }
        finally
        {
            closeSafely(in);
            closeSafely(out);
        }
    }

    public static String readClassString(String path)
    {
        byte[] bytes = readClassResource(path);
        if ( bytes == null )
            return null;

        return new String(bytes);
    }

    //##################################################
    //# runtime
    //##################################################

    /**
     * Just checking freeMemory before/after some action isn't enough.
     * You might see the free memory stay the same, but if the totalMemory
     * increased by 100Mg, then that means that the action actually used
     * 100Mg even though the free memory didn't change.
     */
    public static long getUsedMemory()
    {
        Runtime rt;
        rt = Runtime.getRuntime();
        rt.gc();
        rt.gc(); // the double gc seems to generate more consistent results.
        return rt.totalMemory() - rt.freeMemory();
    }

    //##################################################
    //# regex
    //##################################################

    public static KmList<String> getRegexGroups(String source, String regex)
    {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        boolean matches = matcher.matches();

        if ( !matches )
            return null;

        KmList<String> v = new KmList<String>();

        int n = matcher.groupCount();
        for ( int i = 0; i < n; i++ )
            v.add(matcher.group(i + 1));

        return v;
    }

    //##################################################
    //# url
    //##################################################

    public static String getUrlHash(String uri)
    {
        if ( uri == null )
            return null;

        int i = uri.lastIndexOf("#");
        if ( i < 0 )
            return null;

        return uri.substring(i + 1);
    }
}
