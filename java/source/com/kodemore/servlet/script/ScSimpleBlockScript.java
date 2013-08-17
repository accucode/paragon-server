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

package com.kodemore.servlet.script;

import com.kodemore.collection.KmList;

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

    // todo_wyatt: comment
    private ScRootScript       _root;

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
    private KmList<ScScriptIF> _list;

    //##################################################
    //# constructor
    //##################################################

    public ScSimpleBlockScript(ScRootScript root)
    {
        _list = new KmList<ScScriptIF>();
        _root = root;
    }

    //##################################################
    //# root
    //##################################################

    @Override
    protected ScRootScript getRoot()
    {
        return _root;
    }

    //##################################################
    //# scripts
    //##################################################

    @Override
    protected KmList<ScScriptIF> getScripts()
    {
        return _list;
    }

}
