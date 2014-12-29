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

package com.kodemore.validator;

import java.util.Iterator;

import com.kodemore.collection.KmList;
import com.kodemore.exception.error.KmErrorIF;
import com.kodemore.exception.error.KmFixedLengthValidationError;
import com.kodemore.exception.error.KmMaximumLengthValidationError;
import com.kodemore.exception.error.KmMinimumLengthValidationError;
import com.kodemore.exception.error.KmRequiredValidationError;
import com.kodemore.exception.error.KmStringConstraintValidationError;
import com.kodemore.utility.Kmu;

public class KmStringValidator
    extends KmValidator<String>
{
    //##################################################
    //# variables
    //##################################################

    private Integer _minimumLength;
    private Integer _maximumLength;
    private Integer _fixedLength;

    private boolean _allowsAll;
    private boolean _allowsLetters;
    private boolean _allowsDigits;
    private boolean _allowsSymbols;
    private boolean _allowsPrintable;
    private boolean _allowsWhitespace;

    private boolean _forcesLowerCase;
    private boolean _forcesUpperCase;
    private boolean _stripsLeadingZeros;
    private boolean _stripsAllSpaces;
    private boolean _stripsAllDashes;

    //##################################################
    //# accessing
    //##################################################

    public int getMinimumLength()
    {
        return _minimumLength;
    }

    public void setMinimumLength(Integer e)
    {
        _minimumLength = e;
    }

    public int getMaximumLength()
    {
        return _maximumLength;
    }

    public void setMaximumLength(Integer e)
    {
        _maximumLength = e;
    }

    public int getFixedLength()
    {
        return _fixedLength;
    }

    public void setFixedLength(Integer e)
    {
        _fixedLength = e;
    }

    //##################################################
    //# constraints
    //##################################################

    public boolean getAllowsAll()
    {
        return _allowsAll;
    }

    public void setAllowsAll(boolean e)
    {
        _allowsAll = e;
    }

    public void allowAll()
    {
        setAllowsAll(true);
    }

    public boolean getAllowsLetters()
    {
        return _allowsLetters;
    }

    public void setAllowsLetters(boolean e)
    {
        _allowsLetters = e;
    }

    public void allowLetters()
    {
        setAllowsLetters(true);
    }

    public boolean getAllowsDigits()
    {
        return _allowsDigits;
    }

    public void setAllowsDigits(boolean e)
    {
        _allowsDigits = e;
    }

    public void allowDigits()
    {
        setAllowsDigits(true);
    }

    public boolean getAllowsSymbols()
    {
        return _allowsSymbols;
    }

    public void setAllowsSymbols(boolean e)
    {
        _allowsSymbols = e;
    }

    public void allowSymbols()
    {
        setAllowsSymbols(true);
    }

    public boolean getAllowsPrintable()
    {
        return _allowsPrintable;
    }

    public void setAllowsPrintable(boolean e)
    {
        _allowsPrintable = e;
    }

    public void allowPrintable()
    {
        setAllowsPrintable(true);
    }

    public boolean getAllowsWhitespace()
    {
        return _allowsWhitespace;
    }

    public void setAllowsWhitespace(boolean e)
    {
        _allowsWhitespace = e;
    }

    public void allowWhitespace()
    {
        setAllowsWhitespace(true);
    }

    //##################################################
    //# conversions
    //##################################################

    public boolean getForcesLowerCase()
    {
        return _forcesLowerCase;
    }

    public void setForcesLowerCase(boolean e)
    {
        _forcesLowerCase = e;
    }

    public boolean getForcesUpperCase()
    {
        return _forcesUpperCase;
    }

    public void setForcesUpperCase(boolean e)
    {
        _forcesUpperCase = e;
    }

    public boolean getStripsLeadingZeros()
    {
        return _stripsLeadingZeros;
    }

    public void setStripsLeadingZeros(boolean e)
    {
        _stripsLeadingZeros = e;
    }

    public boolean getStripsAllSpaces()
    {
        return _stripsAllSpaces;
    }

    public void setStripsAllSpaces(boolean e)
    {
        _stripsAllSpaces = e;
    }

    public boolean getStripsAllDashes()
    {
        return _stripsAllDashes;
    }

    public void setStripsAllDashes(boolean e)
    {
        _stripsAllDashes = e;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public String convertOnly(String s)
    {
        if ( s == null )
            return null;

        if ( _forcesLowerCase )
            s = s.toLowerCase();

        if ( _forcesUpperCase )
            s = s.toUpperCase();

        if ( _stripsLeadingZeros )
            s = Kmu.stripLeadingZeros(s);

        if ( _stripsAllSpaces )
            s = Kmu.stripSpaces(s);

        if ( _stripsAllDashes )
            s = Kmu.stripDashes(s);

        return s;
    }

    @Override
    public void validateModel(String s, KmList<KmErrorIF> v)
    {
        validateRequired(s, v);
        if ( Kmu.isNotEmpty(s) )
        {
            validateFixedLength(s, v);
            validateMinimumLength(s, v);
            validateMaximumLength(s, v);
            validateValidCharacters(s, v);
        }
    }

    private void validateRequired(String s, KmList<KmErrorIF> v)
    {
        if ( isRequired() && Kmu.isEmpty(s) )
            v.add(new KmRequiredValidationError(getModel(), getField()));
    }

    private void validateMinimumLength(String s, KmList<KmErrorIF> v)
    {
        if ( _minimumLength == null )
            return;

        if ( s.length() < _minimumLength )
            v.add(new KmMinimumLengthValidationError(getModel(), getField(), _minimumLength));
    }

    private void validateMaximumLength(String s, KmList<KmErrorIF> v)
    {
        if ( _maximumLength == null )
            return;

        if ( s.length() > _maximumLength )
            v.add(new KmMaximumLengthValidationError(getModel(), getField(), _maximumLength));
    }

    private void validateFixedLength(String s, KmList<KmErrorIF> v)
    {
        if ( _fixedLength == null )
            return;

        if ( s.length() != _fixedLength )
            v.add(new KmFixedLengthValidationError(getModel(), getField(), _fixedLength));
    }

    //##################################################
    //# private (constraints)
    //##################################################

    private void validateValidCharacters(String s, KmList<KmErrorIF> v)
    {
        if ( _allowsAll )
            return;

        int n = s.length();
        for ( int i = 0; i < n; i++ )
        {
            char c = s.charAt(i);

            if ( _allowsPrintable && isPrintable(c) )
                continue;

            if ( _allowsLetters && isLetter(c) )
                continue;

            if ( _allowsDigits && isDigit(c) )
                continue;

            if ( _allowsSymbols && isSymbol(c) )
                continue;

            if ( _allowsWhitespace && isWhitespace(c) )
                continue;

            addConstraintError(v);
            break;
        }
    }

    private void addConstraintError(KmList<KmErrorIF> errors)
    {
        KmList<String> v = new KmList<>();
        if ( _allowsPrintable )
            v.add("printable characters");
        else
        {
            if ( _allowsLetters )
                v.add("letters");

            if ( _allowsDigits )
                v.add("digits");

            if ( _allowsSymbols )
                v.add("symbols");
        }
        if ( _allowsWhitespace )
            v.add("whitespace");

        if ( v.isEmpty() )
        {
            addConstraintError(errors, "does not allow any characters");
            return;
        }

        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("may only contain ");

        Iterator<String> i = v.iterator();
        sb.append(i.next());
        while ( i.hasNext() )
        {
            String s = i.next();
            sb.append(", ");
            if ( !i.hasNext() )
                sb.append("or ");
            sb.append(s);
        }
        addConstraintError(errors, sb.toString());
    }

    private void addConstraintError(KmList<KmErrorIF> v, String message)
    {
        KmStringConstraintValidationError e;
        e = new KmStringConstraintValidationError(getModel(), getField(), message);
        v.add(e);
    }

    //##################################################
    //# utility
    //##################################################

    private boolean isLetter(char c)
    {
        return isLowerCaseLetter(c) || isUpperCaseLetter(c);
    }

    private boolean isLowerCaseLetter(char c)
    {
        return c >= 'a' && c <= 'z';
    }

    private boolean isUpperCaseLetter(char c)
    {
        return c >= 'A' && c <= 'Z';
    }

    private boolean isDigit(char c)
    {
        return c >= '0' && c <= '9';
    }

    private boolean isWhitespace(char c)
    {
        return c == 32 // space
            || c == 9 // tab
            || c == 10 // line feed
            || c == 13; // carriage return
    }

    private boolean isPrintable(char c)
    {
        return c >= 32 && c <= 126;
    }

    private boolean isSymbol(char c)
    {
        if ( !isPrintable(c) )
            return false;

        if ( isLetter(c) )
            return false;

        if ( isDigit(c) )
            return false;

        if ( isWhitespace(c) )
            return false;

        return true;
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public KmStringValidator getCopy()
    {
        return (KmStringValidator)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        // add local variables
    }

}
