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

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScControlIF;
import com.kodemore.servlet.control.ScForm;
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
public class ScHtmlIdAjax
    extends ScWrapperScript
{
    //##################################################
    //# variables
    //##################################################

    private ScHtmlIdIF _target;

    //##################################################
    //# constructor
    //##################################################

    public ScHtmlIdAjax(ScBlockScript delegate, ScHtmlIdIF target)
    {
        super(delegate);

        _target = target;
    }

    //##################################################
    //# accessing
    //##################################################

    public ScHtmlIdIF getTarget()
    {
        return _target;
    }

    public String formatJquerySelector()
    {
        return getTarget().getJquerySelector();
    }

    public String formatJqueryReference()
    {
        return getTarget().getJqueryReference();
    }

    //##################################################
    //# run :: deferred
    //##################################################

    public void runDeferred(ScScriptIF e)
    {
        pushDefer();
        run(e);
        popDefer();
    }

    public ScScriptIF runDeferred(String s, Object... args)
    {
        pushDefer();
        ScScriptIF e = run(s, args);
        popDefer();
        return e;
    }

    public ScActionScript runDeferred(ScActionIF action)
    {
        pushDefer();
        ScActionScript e = run(action);
        popDefer();
        return e;
    }

    public ScActionScript runDeferred(ScActionIF action, ScForm form)
    {
        pushDefer();
        ScActionScript e = run(action, form);
        popDefer();
        return e;
    }

    //##################################################
    //# visible
    //##################################################

    public ScShowScript show()
    {
        return show(getTarget());
    }

    public ScHideScript hide()
    {
        return hide(getTarget());
    }

    public ScToggleScript toggle()
    {
        return toggle(getTarget());
    }

    public ScGlowScript glow()
    {
        return glow(getTarget());
    }

    public ScGlowScript glowDeferred()
    {
        pushDefer();
        ScGlowScript e = glow(getTarget());
        popDefer();
        return e;
    }

    //##################################################
    //# contents
    //##################################################

    public void setContents(ScControl contents)
    {
        setContents(getTarget(), contents);
    }

    public void setContents(KmHtmlBuilder out)
    {
        setContents(getTarget(), out);
    }

    public void clearContents()
    {
        clearContents(getTarget());
    }

    public ScAddContentScript addContents()
    {
        return addContentsTo(getTarget());
    }

    //##################################################
    //# append / prepend
    //##################################################

    public void appendContents(CharSequence html)
    {
        appendContents(getTarget(), html);
    }

    public void prependContents(CharSequence html)
    {
        prependContents(getTarget(), html);
    }

    //##################################################
    //# remove / replace
    //##################################################

    public void remove()
    {
        remove(getTarget());
    }

    public void replaceWith(ScControlIF with)
    {
        replaceWith(getTarget(), with);
    }

    /**
     * Attempt to replace the element identified by the target htmlId
     * with the current version of itself.  
     * 
     * NOTE: HtmlIds are not necessarily renderable.  This only works if 
     * the target HtmlId is also an instance of ScControlIF.  Otherwise,
     * the element will simply be removed.
     */
    public void replace()
    {
        ScHtmlIdIF target = getTarget();

        if ( target instanceof ScControlIF )
        {
            ScControlIF with = (ScControlIF)target;
            replaceWith(target, with);
        }
        else
            remove();
    }

    //##################################################
    //# text
    //##################################################

    public void setText(String e)
    {
        setText(getTarget(), e);
    }

    public void clearText()
    {
        clearText(getTarget());
    }

    //##################################################
    //# html
    //##################################################

    public void setHtml(String value)
    {
        setHtml(getTarget(), value);
    }

    public void clearHtml()
    {
        clearHtml(getTarget());
    }

    //##################################################
    //# misc
    //##################################################

    @Override
    public void hideAllErrors()
    {
        String target = formatJquerySelector();
        String error = KmCssDefaultConstantsIF.error;

        run("$('%s .%s').hide();", target, error);
    }

    @Override
    public void focus()
    {
        getInner().focus(getTarget());
    }

    public void focusDeferred()
    {
        getInner().focusDeferred(getTarget());
    }

    //##################################################
    //# value
    //##################################################

    public void setValue(String e)
    {
        setValue(getTarget(), e);
    }

    public void clearValue()
    {
        clearValue(getTarget());
    }

    //##################################################
    //# stack
    //##################################################

    public void pushDefer()
    {
        pushDeferUntil(getTarget());
    }

    public void defer()
    {
        deferUntil(getTarget());
    }

    //##################################################
    //# on escape
    //##################################################

    public void onEscape(ScActionIF action)
    {
        onEscape(getTarget(), action);
    }

    public void onEscape(String script)
    {
        onEscape(getTarget(), script);
    }

    public void onEscape(ScScriptIF script)
    {
        onEscape(getTarget(), script);
    }

    //##################################################
    //# on control-enter
    //##################################################

    public void onControlEnter(ScScriptIF script)
    {
        onControlEnter(getTarget(), script);
    }

    public void onControlEnter(String e)
    {
        onControlEnter(getTarget(), e);
    }

    public void onControlEnter(ScActionIF e)
    {
        onControlEnter(getTarget(), e);
    }

    //##################################################
    //# block
    //##################################################

    public void block()
    {
        blockControl(getTarget());
    }

    public void unblock()
    {
        unblockControl(getTarget());
    }

    //##################################################
    //# equalize
    //##################################################

    public ScEqualizeScript equalizeChildren()
    {
        return equalizeChildrenOf(getTarget());
    }

    public ScEqualizeScript equalizeClasses(String klass)
    {
        return equalizeClassIn(getTarget(), klass);
    }

    public ScEqualizeScript equalizeGroups()
    {
        return equalizeGroupsIn(getTarget());
    }

    public ScEqualizeScript equalizeGroupBodies()
    {
        return equalizeGroupBodiesIn(getTarget());
    }

    //##################################################
    //# drag
    //##################################################

    public void sortableByHandle()
    {
        sortableByHandle(getTarget());
    }

    public void sortableUpdate(String childPath, String attr, ScActionIF action)
    {
        sortableUpdate(getTarget(), childPath, attr, action);
    }

    //##################################################
    //# tooltip
    //##################################################

    public void tooltip()
    {
        tooltip(getTarget());
    }

}
