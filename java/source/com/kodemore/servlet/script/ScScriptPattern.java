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

package com.kodemore.servlet.script;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

/**
 * I provide a simple way to defer execution of scripts
 * while combining them into other code patterns.  Complex
 * patterns should generally be normalized into first-class
 * subclasses of ScScriptIF, but simple, one-off cases don't
 * always justify creating specialized class hierarchies.
 */
public class ScScriptPattern
    implements ScScriptIF
{
    //##################################################
    //# variables
    //##################################################

    private String         _pattern;
    private KmList<Object> _arguments;

    //##################################################
    //# constructor
    //##################################################

    public ScScriptPattern()
    {
        _arguments = new KmList<Object>();
    }

    //##################################################
    //# accessing
    //##################################################

    public String getPattern()
    {
        return _pattern;
    }

    public void setPattern(String e)
    {
        _pattern = e;
    }

    public KmList<Object> getArguments()
    {
        return _arguments;
    }

    public void addArgument(ScScriptIF e)
    {
        _arguments.add(e);
    }

    public void addArguments(Object[] arr)
    {
        _arguments.addAll(arr);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public final String formatScript()
    {
        return Kmu.format(_pattern, _arguments.toArray());
    }

}
