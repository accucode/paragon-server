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

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.utility.Kmu;

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
        return getTarget().formatJquerySelector();
    }

    public String formatJqueryReference()
    {
        return getTarget().formatJqueryReference();
    }

    //##################################################
    //# layout
    //##################################################

    public void printMain()
    {
        printMain(getTarget());
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
    //# replace
    //##################################################

    public void replace()
    {
        replace(getTarget());
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

    // todo_wyatt: review.super...
    //    public void hideAllErrors()
    //    {
    //        String target = formatJquerySelector();
    //        String error = KmCssDefaultConstantsIF.error;
    //
    //        run("$('%s .%s').hide();", target, error);
    //    }

    // todo_wyatt: review super.focus
    //    public void focus()
    //    {
    //        getInner().focus(getTarget());
    //    }

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
    //# equalize children
    //##################################################

    public ScEqualizeScript equalizeChildren()
    {
        String sel = Kmu.format("%s > *", formatJquerySelector());
        return runEqualizeScript(sel);
    }

    public ScEqualizeScript equalizeChildrenGroups()
    {
        return equalizeChildrenClass(KmCssDefaultConstantsIF.group_prefix);
    }

    public ScEqualizeScript equalizeChildrenClass(String childClass)
    {
        String sel = Kmu.format("%s > .%s", formatJquerySelector(), childClass);
        return runEqualizeScript(sel);
    }

    public ScEqualizeScript equalizeDecendentGroups()
    {
        return equalizeDecendentClass(KmCssDefaultConstantsIF.group_prefix);
    }

    public ScEqualizeScript equalizeDecendentClass(String childClass)
    {
        String sel = Kmu.format("%s .%s", formatJquerySelector(), childClass);
        return runEqualizeScript(sel);
    }

    private ScEqualizeScript runEqualizeScript(String sel)
    {
        ScEqualizeScript e;
        e = new ScEqualizeScript();
        e.setSelector(sel);

        run(e);
        return e;
    }
}
