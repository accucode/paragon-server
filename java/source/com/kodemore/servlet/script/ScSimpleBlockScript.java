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

package com.kodemore.servlet.script;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.field.ScHtmlIdIF;

/**
 * I manage a list of scripts, roughly representing the
 * contents of a "block".  That is, the code _between_
 * matching braces {...}.
 *
 * NOTE: In many cases, clients will simply use my helper
 * methods such as toast(...).  However, when clients
 * directly compose their own script, then those clients
 * are responsible for manually including any appropriate
 * whitespace or terminators.  The basic add/run methods
 * do NOT automatically add any spaces, linefeeds, or
 * semicolons.
 */
public class ScSimpleBlockScript
    extends ScBlockScript
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The list of scripts to be executed.  Scripts
     * are composed as ScScriptIF and the actual string
     * value is deferred until the script is subsequently
     * composed (e.g.: by toString).  This also means that
     * given the following:
     *
     *      ScScriptBuilder out;
     *      out = new ScScriptBuilder();
     *      out.run(...)
     *
     *      String a = out.toString();
     *      String b = out.toString();
     *
     * Then, a and b cannot be assumed to be the same.
     * If any of the scripts added to the builder use
     * dynamic/deferred binding then the values may be
     * different.
     */
    private KmList<ScScriptIF>     _list;

    private KmList<ScWhenDoneAjax> _stack;

    //##################################################
    //# constructor
    //##################################################

    public ScSimpleBlockScript()
    {
        _list = new KmList<>();
        _stack = new KmList<>();
    }

    //##################################################
    //# scripts
    //##################################################

    @Override
    protected KmList<ScScriptIF> getScripts()
    {
        return _list;
    }

    @Override
    protected void _add(ScScriptIF e)
    {
        if ( e == null )
            return;

        if ( _stack.isNotEmpty() )
            _stack.getLast().run(e);
        else
            getScripts().add(e);
    }

    @Override
    public void clearScript()
    {
        _list.clear();
        _stack.clear();
    }

    //##################################################
    //# stack
    //##################################################

    @Override
    public ScWhenDoneAjax pushWhenDone(ScHtmlIdIF target, ScHtmlIdIF waitFor)
    {
        ScWhenDoneAjax e = whenDone(target, waitFor);
        _stack.add(e);
        return e;
    }

    @Override
    public void popWhenDone()
    {
        _stack.removeLast();
    }

}
