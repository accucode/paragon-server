/*
  Copyright (c) 2005-2011 www.kodemore.com

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

    private String             _mode;
    private String             _oldValue;
    private String             _newValue;

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
            return _replaceAll(s, verbose);
        if ( hasMode(MODE_PREFIX) )
            return _replacePrefix(s, verbose);
        if ( hasMode(MODE_SUFFIX) )
            return _replaceSuffix(s, verbose);
        return s;
    }

    public String _replaceAll(String s)
    {
        return _replaceAll(s, false);
    }

    public String _replaceAll(String s, boolean verbose)
    {
        String result = Kmu.replaceAll(s, _oldValue, _newValue);
        if ( verbose && !result.equals(s) )
            printRuleApplication(s, result);
        return result;
    }

    public String _replacePrefix(String s)
    {
        return _replacePrefix(s, false);
    }

    public String _replacePrefix(String s, boolean verbose)
    {
        if ( !s.startsWith(_oldValue) )
            return s;
        String result = _newValue + s.substring(_oldValue.length());
        if ( verbose )
            printRuleApplication(s, result);
        return result;
    }

    public String _replaceSuffix(String s)
    {
        return _replaceSuffix(s, false);
    }

    public String _replaceSuffix(String s, boolean verbose)
    {
        if ( !s.endsWith(_oldValue) )
            return s;
        String result = s.substring(0, s.length() - _oldValue.length()) + _newValue;
        if ( verbose )
            printRuleApplication(s, result);
        return result;
    }

    //##################################################
    //# display
    //##################################################

    public void printRuleApplication(String s1, String s2)
    {
        System.out.println("Rule: "
            + getMode()
            + ","
            + getOldValue()
            + ","
            + getNewValue()
            + " :: "
            + s1
            + " -> "
            + s2);
    }

}
