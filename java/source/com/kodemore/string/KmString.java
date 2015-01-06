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

package com.kodemore.string;

import com.kodemore.time.KmDate;
import com.kodemore.time.KmDateParser;
import com.kodemore.time.KmTime;
import com.kodemore.time.KmTimeParser;
import com.kodemore.time.KmTimestamp;
import com.kodemore.time.KmTimestampParser;
import com.kodemore.types.KmDecimal;
import com.kodemore.types.KmKilogram;
import com.kodemore.utility.Kmu;

/**
 * I wrap String in order to provide various convenience methods.
 * My value may be null.
 */
public class KmString
{
    //##################################################
    //# variables
    //##################################################

    private String _value;

    //##################################################
    //# constructor
    //##################################################

    public KmString()
    {
        setValue((String)null);
    }

    public KmString(String s)
    {
        setValue(s);
    }

    public KmString(Integer i)
    {
        setValue(i.toString());
    }

    //##################################################
    //# accessing
    //##################################################

    public String getValue()
    {
        return _value;
    }

    public void setValue(String s)
    {
        _value = s;
    }

    public int getLength()
    {
        if ( _value == null )
            return 0;
        return _value.length();
    }

    //##################################################
    //# testing
    //##################################################

    /**
     * Determine if the wrapped string is null.
     */
    public boolean isNull()
    {
        return _value == null;
    }

    /**
     * Determine if the value matches the specified string.
     */
    public boolean hasValue(String e)
    {
        return Kmu.isEqual(_value, e);
    }

    /**
     * Determine if the value is a non-null string with a minimun length of 1.
     */
    public boolean hasValue()
    {
        return Kmu.hasValue(_value);
    }

    /**
     * Determine if the value is either null or an empty string.
     */
    public boolean isEmpty()
    {
        return Kmu.isEmpty(_value);
    }

    /**
     * Determine if the value is a non-null string with a minimun length of 1.
     */
    public boolean isNotEmpty()
    {
        return !isEmpty();
    }

    /**
     * Determine if the value is a non-null.
     */
    public boolean isNotNull()
    {
        return !isNull();
    }

    /**
     * Determine if all of the characters in the value are letters.
     * A..Z, a..z.  Return false is value is null.
     */
    public boolean isAllLetters()
    {
        if ( _value == null )
            return false;
        return Kmu.isAllLetters(_value);
    }

    /**
     * Determine if all of the characters in the value are uppercase letters.
     * Return false if value is null.
     */
    public boolean isAllUpperCase()
    {
        if ( _value == null )
            return false;
        return Kmu.isAllUpperCase(_value);
    }

    /**
     * Determine if all of the characters in the value are lowercase letters.
     * Return false if value is null.
     */
    public boolean isAllLowerCase()
    {
        if ( _value == null )
            return false;
        return Kmu.isAllLowerCase(_value);
    }

    /**
     * Determine if all of the characters in the value are digits (0..9).
     * Return false if value is null.
     */
    public boolean isAllDigits()
    {
        if ( _value == null )
            return false;
        return Kmu.isAllDigits(_value);
    }

    /**
     * Determine if the value contains any of the characters in chars.
     * Return false if value is null.
     */
    public boolean containsAny(String chars)
    {
        if ( _value == null )
            return false;
        return Kmu.containsAny(_value, chars);
    }

    /**
     * Determine if the value is composed solely of the characters in chars.
     * Return false if value is null.
     */
    public boolean containsOnly(String chars)
    {
        if ( _value == null )
            return false;
        return Kmu.containsOnly(_value, chars);
    }

    /**
     * Determine if the value begins with an eol pattern.
     * One of: CRLF, CR, LF
     * Return false if value is null.
     */
    public boolean hasEndOfLinePrefix()
    {
        if ( _value == null )
            return false;
        return Kmu.hasEndOfLinePrefix(_value);
    }

    /**
     * Determine if the value begins with an eol pattern.
     * One of: CRLF, CR, LF
     * Return false if value is null.
     */
    public boolean hasEndOfLineSuffix()
    {
        if ( _value == null )
            return false;
        return Kmu.hasEndOfLineSuffix(getValue());
    }

    public boolean startsWith(String s)
    {
        if ( _value == null )
            return false;
        return _value.startsWith(s);
    }

    //##################################################
    //# conversion
    //##################################################

    /**
     * Return the value as a String.
     */
    public String asString()
    {
        return asString(null);
    }

    /**
     * Return the value as a String.
     */
    public String asString(String def)
    {
        if ( _value == null )
            return def;
        return _value;
    }

    //##################################################
    //# access (integer)
    //##################################################

    /**
     * Attempts to convert the value to an Integer.
     * Returns null if it cannot be converted.
     */
    public Integer asInteger()
    {
        return asInteger(null);
    }

    /**
     * Attempts to convert the value to an Integer.
     * Returns the specified default integer if it cannot be converted.
     */
    public Integer asInteger(Integer def)
    {
        return Kmu.parseInteger(_value, def);
    }

    /**
     * Attempts to convert the value to an Integer.
     * Returns the specified default integer if it cannot be converted.
     */
    public Integer asInteger(int def)
    {
        return asInteger(Integer.valueOf(def));
    }

    //##################################################
    //# access (double)
    //##################################################

    /**
     * Attempts to convert the value to a Double.
     * Returns null if it cannot be converted.
     */
    public Double asDouble()
    {
        return asDouble(null);
    }

    /**
     * Attempts to convert the value to a Double.
     * Returns the specified default double if it cannot be converted.
     */
    public Double asDouble(Double def)
    {
        return Kmu.parseDouble(_value, def);
    }

    /**
     * Attempts to convert the value to a Double.
     * Returns the specified default double if it cannot be converted.
     */
    public Double asDouble(double def)
    {
        Double d = asDouble();

        if ( d == null )
            return def;

        return d;
    }

    //##################################################
    //# access (decimal)
    //##################################################

    /**
     * Attempts to convert the value to a Decimal.
     * Returns null if it cannot be converted.
     */
    public KmDecimal asDecimal()
    {
        return asDecimal(null);
    }

    /**
     * Attempts to convert the value to a Decimal.
     * Returns the specified default decimal if it cannot be converted.
     */
    public KmDecimal asDecimal(KmDecimal def)
    {
        return Kmu.parseDecimal(_value, def);
    }

    //##################################################
    //# access (kilogram)
    //##################################################

    /**
     * Attempts to convert the value to a KmKilogram.
     * Returns null if it cannot be converted.
     */
    public KmKilogram asKilogram()
    {
        return asKilogram(null);
    }

    /**
     * Attempts to convert the value to a KmKilogram.
     * Returns the specified default decimal if it cannot be converted.
     */
    public KmKilogram asKilogram(KmKilogram def)
    {
        return Kmu.parseKilogram(_value, def);
    }

    //##################################################
    //# access (boolean)
    //##################################################

    /**
     * Attempts to convert the value to a Boolean.
     * Returns null if it cannot be converted.
     */
    public Boolean asBoolean()
    {
        return asBoolean(null);
    }

    /**
     * Attempts to convert the value to a Boolean.
     * Returns the specified default boolean if it cannot be converted.
     */
    public Boolean asBoolean(Boolean def)
    {
        return Kmu.parseBoolean(_value, def);
    }

    //##################################################
    //# access (character)
    //##################################################

    /**
     * Attempts to convert the value to a Character.
     * Returns null if it cannot be converted.
     *
     */
    public Character asCharacter()
    {
        return asCharacter(null);
    }

    /**
     * Attempts to convert the value to a Character.
     * Returns the specified default character if it cannot be converted.
     */
    public Character asCharacter(Character def)
    {
        if ( isEmpty() )
            return def;

        return _value.charAt(0);
    }

    //##################################################
    //# access (date)
    //##################################################

    /**
     * Attempts to convert the value to a KmDate.
     * Returns null if it cannot be converted.
     */
    public KmDate asDate()
    {
        return asDate(null);
    }

    /**
     * Attempts to convert the value to a KmDate.
     * Returns the specified default date if it cannot be converted.
     */
    public KmDate asDate(KmDate def)
    {
        KmDate d = null;
        try
        {
            d = KmDateParser.parseDate(_value);
        }
        catch ( Exception ex )
        {
            return def;
        }

        if ( d == null )
            return def;

        return d;
    }

    //##################################################
    //# access (expiry)
    //##################################################

    /**
     * Attempts to convert the value to a KmDate using formats that
     * expect and expiration date.  Format is either mm/dd/yyyy, or
     * mm/yyyy.  Returns null if it cannot be converted.
     */
    public KmDate asExpiry()
    {
        return asExpiry(null);
    }

    /**
     * Attempts to convert the value to a KmDate using formats that
     * expect and expiration date.  Format is either mm/dd/yyyy, or
     * mm/yyyy.  Returns null if it cannot be converted.
     */
    public KmDate asExpiry(KmDate def)
    {
        KmDateParser p;
        p = new KmDateParser();
        p.setOneNumberMode(KmDateParser.ONE_NUMBER_MODE_NONE);
        p.setTwoNumberMode(KmDateParser.TWO_NUMBER_MODE_MONTH_YEAR_LAST_DAY);
        p.setThreeNumberMode(KmDateParser.THREE_NUMBER_MODE_MONTH_DAY_YEAR);
        KmDate d = p.parse(_value);
        return d == null
            ? def
            : d;
    }

    //##################################################
    //# access (time)
    //##################################################

    /**
     * Attempts to convert the value to a KmTime.
     * Returns null if it cannot be converted.
     */
    public KmTime asTime()
    {
        return asTime(null);
    }

    /**
     * Attempts to convert the value to a KmTime.
     * Returns the specified default time if it cannot be converted.
     */
    public KmTime asTime(KmTime def)
    {
        KmTime t = KmTimeParser.parseTime(_value);
        return t == null
            ? def
            : t;
    }

    //##################################################
    //# access (timestamp)
    //##################################################

    /**
     * Attempts to convert the value to a KmTimestamp.
     * Returns null if it cannot be converted.
     */
    public KmTimestamp asTimestamp()
    {
        return asTimestamp(null);
    }

    /**
     * Attempts to convert the value to a KmTimestamp.
     * Returns the specified default timestamp if it cannot be converted.
     */
    public KmTimestamp asTimestamp(KmTimestamp def)
    {
        KmTimestamp t = KmTimestampParser.parseTimestamp(_value);
        return t == null
            ? def
            : t;
    }

    //##################################################
    //# manipulation
    //##################################################

    /**
     * Return the value as a String.
     */
    @Override
    public String toString()
    {
        return _value;
    }

    /**
     * Converts the value to upper case.
     */
    public void toUpperCase()
    {
        if ( _value == null )
            return;
        _value = _value.toUpperCase();
    }

    /**
     * Converts the value to lower case.
     */
    public void toLowerCase()
    {
        if ( _value == null )
            return;
        _value = _value.toLowerCase();
    }

    /**
     * Convert the value to first chracter to uppercase and the
     * rest to lower.
     */
    public void capitalizeWord()
    {
        if ( _value == null )
            return;
        _value = Kmu.capitalizeWord(_value);
    }

    /**
     * Convert the value to capitalize first letter of each word.
     * Use space, tab, carriage return, and line feed for delimiters.
     */
    public void capitalizeWords()
    {
        if ( _value == null )
            return;
        _value = Kmu.capitalizeWords(_value);
    }

    /**
     * Convert the value to capitalize first letter of each word
     * based on the delimiters.
     */
    public void capitalizeWords(String delimiters)
    {
        if ( _value == null )
            return;
        _value = Kmu.capitalizeWords(_value, delimiters);
    }

    /**
     * Convert the value to uppercase the first chracter, leave the
     * rest alone.
     */
    public void capitalizeFirstLetter()
    {
        if ( _value == null )
            return;
        _value = Kmu.capitalizeFirstLetter(_value);
    }

    /**
     * Convert the value to remove the specified prefix from the
     * beginning of the string.  If the string does not start with
     * prefix, then the value will not be updated.
     */
    public void removePrefix(String prefix)
    {
        if ( _value == null )
            return;
        _value = Kmu.removePrefix(_value, prefix);
    }

    /**
     * Convert the value to remove the specified suffix from the
     * end of the string.  If the string does not end with the
     * suffix, then the value will not be updated.
     */
    public void removeSuffix(String suffix)
    {
        if ( _value == null )
            return;
        _value = Kmu.removeSuffix(_value, suffix);
    }

    /**
     * Convert the value to remove all sections that begin with
     * <begin> and end with <end>.
     */
    public void removeSections(String begin, String end)
    {
        if ( _value == null )
            return;
        _value = Kmu.removeSections(_value, begin, end);
    }

    /**
     * Convert the value to remove a single eol pattern from the
     * beginning of the string. One of: CRLF, CR, LF
     */
    public void removeEndOfLinePrefix()
    {
        if ( _value == null )
            return;
        _value = Kmu.removeEndOfLinePrefix(_value);
    }

    /**
     * Convert the value to remove a single eol pattern from the end
     * of the string.  One of: CRLF, CR, LF
     */
    public void removeEndOfLineSuffix()
    {
        if ( _value == null )
            return;
        _value = Kmu.removeEndOfLineSuffix(_value);
    }

    /**
     * Convert the value to a string that repeats the value, n times.
     */
    public void repeat(int n)
    {
        if ( _value == null )
            return;
        _value = Kmu.repeat(_value, n);
    }

    /**
     * Convert the value to a string that replaces the first occurence
     * of a with b.
     */
    public void replaceFirst(String a, String b)
    {
        if ( _value == null )
            return;
        _value = Kmu.replaceFirst(_value, a, b);
    }

    /**
     * Convert the value to a string that replaces all occurrences of a
     * with b.
     */
    public void replaceAll(String a, String b)
    {
        if ( _value == null )
            return;
        _value = Kmu.replaceAll(_value, a, b);
    }

    /**
     * Convert the value to a string that replaces all non-alpha
     * numeric characters with the space character; the resulting
     * string will be the same length as the original. Update the
     * value to the resultign string.
     */
    public void replaceNonAlphaNumericWithSpace()
    {
        if ( _value == null )
            return;
        _value = Kmu.replaceNonAlphaNumericWithSpace(_value);
    }

    /**
     * Convert the value to remove all letters from the string.
     */
    public void stripLetters()
    {
        if ( _value == null )
            return;
        _value = Kmu.stripLetters(_value);
    }

    /**
     * Convert the value to remove all non-digits from the string.
     */
    public void stripNonDigits()
    {
        if ( _value == null )
            return;
        _value = Kmu.stripNonDigits(_value);
    }

    /**
     * Convert the value to remove all characters matching ch from the
     * string.
     */
    public void stripCharacters(int ch)
    {
        if ( _value == null )
            return;
        _value = Kmu.stripCharacters(_value, ch);
    }

    /**
     * Convert the value to remove all spaces from the string.  This
     * only strips the 'space' character, other whitespace, such as
     * tabs, is not removed.
     */
    public void stripSpaces()
    {
        if ( _value == null )
            return;
        _value = Kmu.stripSpaces(_value);
    }

    /**
     * Convert the value to remove all non-alpha numeric characters
     * from the string.
     */
    public void stripNonAlphaNumeric()
    {
        if ( _value == null )
            return;
        _value = Kmu.stripNonAlphaNumeric(_value);
    }

    /**
     * Convert the value to remove all of the non printable characters.
     */
    public void stripNonSingleLinePrintable()
    {
        if ( _value == null )
            return;

        _value = Kmu.stripNonSingleLinePrintable(_value);
    }

    /**
     * Convert the value to remove all of the non printable characters.
     */
    public void stripNonMultiLinePrintable()
    {
        if ( _value == null )
            return;

        _value = Kmu.stripNonMultiLinePrintable(_value);
    }

    /**
     * Convert the value to trim white space from the string.
     * This is a pass through method to String.
     */
    public void trim()
    {
        if ( _value == null )
            return;
        _value = _value.trim();
    }

    /**
     * Convert the value to truncate the value to a maximum length of n.
     * If ellipses is true then "..." is appended to the end of the
     * string.  The total string length, including ellipses is
     * guaranteed to be <= n.
     */
    public void truncate(int n, boolean ellipses)
    {
        if ( _value == null )
            return;
        _value = Kmu.truncate(_value, n, ellipses);
    }

    /**
     * Convert the value to truncate the value to a maximum length of n.
     */
    public void truncate(int n)
    {
        if ( _value == null )
            return;
        _value = Kmu.truncate(_value, n);
    }

    /**
     * Convert the value to an all uppercase format, preserving word
     * separation using underscores.  Spaces and uppercase letters
     * in the original string are assumed to mark word separators.
     */
    public void formatAsConstant()
    {
        if ( _value == null )
            return;
        _value = Kmu.formatAsConstant(_value);
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object e)
    {
        if ( e instanceof KmString )
            return ((KmString)e).hasValue(_value);
        return false;
    }

    @Override
    public int hashCode()
    {
        if ( _value == null )
            return 0;
        return _value.hashCode();
    }
}
