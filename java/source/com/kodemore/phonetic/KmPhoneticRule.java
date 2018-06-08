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

package com.kodemore.phonetic;

import com.kodemore.utility.Kmu;

/**
 * I represent a single rule (or step) in the phonetic conversion process.
 * Each rule is a simple string replacement, however the replacement can
 * be specified to apply to the entire string, or to just the prefix or suffix.
 */
public class KmPhoneticRule
{
    //##################################################
    //# constants
    //##################################################

    public static final String MODE_ALL    = "all";
    public static final String MODE_PREFIX = "prefix";
    public static final String MODE_SUFFIX = "suffix";

    //##################################################
    //# variables
    //##################################################

    private String _mode;
    private String _oldValue;
    private String _newValue;

    //##################################################
    //# constructor
    //##################################################

    public KmPhoneticRule()
    {
        _mode = MODE_ALL;
        _oldValue = "";
        _newValue = "";
    }

    //##################################################
    //# accessing
    //##################################################

    public String getMode()
    {
        return _mode;
    }

    public void setMode(String e)
    {
        _mode = e;
    }

    public boolean hasMode(String s)
    {
        return _mode.equals(s);
    }

    public String getOldValue()
    {
        return _oldValue;
    }

    public void setOldValue(String e)
    {
        _oldValue = e;
    }

    public String getNewValue()
    {
        return _newValue;
    }

    public void setNewValue(String e)
    {
        _newValue = e;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public String applyTo(String s)
    {
        return applyTo(s, false);
    }

    public String applyTo(String s, boolean verbose)
    {
        if ( hasMode(MODE_ALL) )
            return replaceAll(s, verbose);

        if ( hasMode(MODE_PREFIX) )
            return replacePrefix(s, verbose);

        if ( hasMode(MODE_SUFFIX) )
            return replaceSuffix(s, verbose);

        return s;
    }

    //##################################################
    //# private
    //##################################################

    private String replaceAll(String s, boolean verbose)
    {
        String result = Kmu.replaceAll(s, _oldValue, _newValue);

        if ( verbose && !result.equals(s) )
            printRuleApplication(s, result);

        return result;
    }

    private String replacePrefix(String s, boolean verbose)
    {
        if ( !s.startsWith(_oldValue) )
            return s;

        String result = _newValue + s.substring(_oldValue.length());

        if ( verbose )
            printRuleApplication(s, result);

        return result;
    }

    private String replaceSuffix(String s, boolean verbose)
    {
        if ( !s.endsWith(_oldValue) )
            return s;

        String result = s.substring(0, s.length() - _oldValue.length()) + _newValue;

        if ( verbose )
            printRuleApplication(s, result);

        return result;
    }

    private void printRuleApplication(String s1, String s2)
    {
        System.out.printf(
            "Rule: %s, %s, %s :: %s -> %s%n",
            getMode(),
            getOldValue(),
            getNewValue(),
            s1,
            s2);
    }

}
