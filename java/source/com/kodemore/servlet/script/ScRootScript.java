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

import com.kodemore.utility.Kmu;

/**
 * I manage a list of scripts, roughly representing the
 * contents of a "block".  That is, the lines _between_
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
public class ScRootScript
    extends ScBlockScript
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The stack is used to push nested contexts.  This
     * provides a relatively clean way to handle things
     * like anonomous function callbacks for scripts that
     * need to be deferred.  E.g.: to focus a field after
     * it has been shown via an animation we use...
     *
     *      ScTextField field = ...
     *      
     *      ScScript out;
     *      out = new ScScript();
     *      out.show(field).slide();
     *      out.pushDeferUntil(field);
     *      out.focus(field);
     *      out.pop();
     *      
     * Most clients don't need to explicitly manage the 
     * stack.  Usually it is sufficient to simply defer
     * the rest of the script.  So the above can be 
     * written more simply as:
     * 
     *      ScTextField field = ...
     *      
     *      ScScript out;
     *      out = new ScScript();
     *      out.show(field).slide();
     *      out.deferUntil(field);
     *      out.focus(field);
     * 
     * Finally, many controls support convenience methods 
     * to help streamline this.  For example:
     * 
     *      ScTextField field = ...
     *      field.ajax().show().slide().defer();
     *      field.ajax().focus();
     */
    private ScBlockScript _stack;

    //##################################################
    //# constructor
    //##################################################

    public ScRootScript()
    {
        // todo_wyatt: review
        super(null);
    }

    //##################################################
    //# hierarchy
    //##################################################

    @Override
    public ScRootScript getRoot()
    {
        /**
         * Ignores the _root ivar.
         */
        return this;
    }

    //##################################################
    //# stack
    //##################################################

    @Override
    public void clearScript()
    {
        super.clearScript();
        _stack = null;
    }

    @Override
    public boolean hasStack()
    {
        return _stack != null;
    }

    @Override
    public void pushDeferUntil(String sel)
    {
        if ( _stack != null )
        {
            _stack.pushDeferUntil(sel);
            return;
        }

        ScDeferredScript promise;
        promise = new ScDeferredScript(this);
        promise.setSelector(sel);

        _add(promise);
        _stack = promise;
    }

    @Override
    public void pop()
    {
        if ( _stack == null )
            Kmu.fatal("Cannot pop empty stack.");

        if ( _stack.hasStack() )
            _stack.pop();
        else
            _stack = null;
    }

    //##################################################
    //# add
    //##################################################

    @Override
    protected void _add(ScScriptIF e)
    {
        if ( _stack == null )
            super._add(e);
        else
            _stack._add(e);
    }
}
