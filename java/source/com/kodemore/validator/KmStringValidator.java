/*
  Copyright (c) 2005-2018 www.kodemore.com

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
import com.kodemore.exception.error.KmErrorList;
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
    public String convert(String s)
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
    public void validateValueOn(String value, KmErrorList errors)
    {
        if ( !validateRequired(value, errors) )
            return;

        validateFixedLength(value, errors);
        validateMinimumLength(value, errors);
        validateMaximumLength(value, errors);
        validateValidCharacters(value, errors);
    }

    private boolean validateRequired(String value, KmErrorList errors)
    {
        if ( isRequired() && Kmu.isEmpty(value) )
        {
            errors.addRequiredField(this);
            return false;
        }

        return true;
    }

    private void validateMinimumLength(String value, KmErrorList errors)
    {
        if ( _minimumLength == null )
            return;

        if ( value.length() < _minimumLength )
            errors.addFieldError(this, "minimum length is " + _minimumLength);
    }

    private void validateMaximumLength(String value, KmErrorList errors)
    {
        if ( _maximumLength == null )
            return;

        if ( value.length() > _maximumLength )
            errors.addFieldError(this, "maximum length is " + _maximumLength);
    }

    private void validateFixedLength(String value, KmErrorList errors)
    {
        if ( _fixedLength == null )
            return;

        if ( value.length() != _fixedLength )
            errors.addFieldError(this, "must be length " + _fixedLength);
    }

    //##################################################
    //# private (constraints)
    //##################################################

    private void validateValidCharacters(String value, KmErrorList errors)
    {
        if ( _allowsAll )
            return;

        int n = value.length();
        for ( int i = 0; i < n; i++ )
        {
            char c = value.charAt(i);

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

            addConstraintError(errors);
            break;
        }
    }

    private void addConstraintError(KmErrorList errors)
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

        StringBuilder out;
        out = new StringBuilder();
        out.append("may only contain ");

        Iterator<String> i = v.iterator();
        out.append(i.next());

        while ( i.hasNext() )
        {
            String s = i.next();
            out.append(", ");

            if ( !i.hasNext() )
                out.append("or ");

            out.append(s);
        }

        addConstraintError(errors, out.toString());
    }

    private void addConstraintError(KmErrorList errors, String problem)
    {
        errors.addFieldError(this, problem);
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
        return Kmu.isSingleLinePrintable(c);
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
