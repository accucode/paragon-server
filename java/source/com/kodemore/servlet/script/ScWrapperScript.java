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

/**
 * I provide the basis for extending someone else's block script.
 * Although I extend from BlockScript, I delegate all options to
 * my "inner" script rather than implementing the operations directly.
 * 
 * This allows my subclasses to enhance, or extend, the functionality
 * of another block script without affecting the class hierarchy.
 */
public class ScWrapperScript
    extends ScBlockScript
{
    //##################################################
    //# variables
    //##################################################

    /**
     * My inner script, to which all operations are delegated.
     * This is required and must be provided on the constructor.
     */
    private ScBlockScript _inner;

    //##################################################
    //# constructor
    //##################################################

    public ScWrapperScript(ScBlockScript e)
    {
        _inner = e;
    }

    //##################################################
    //# inner
    //##################################################

    protected ScBlockScript getInner()
    {
        return _inner;
    }

    @Override
    public ScRootScript getRoot()
    {
        return _inner.getRoot();
    }

    @Override
    protected KmList<ScScriptIF> getScripts()
    {
        return _inner.getScripts();
    }

    @Override
    protected void _add(ScScriptIF e)
    {
        _inner._add(e);
    }
}
