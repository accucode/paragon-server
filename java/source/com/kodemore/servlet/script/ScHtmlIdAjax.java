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

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.utility.Kmu;

/**
 * A block script that knows about a specific element.
 * This allows for a variety of concise convenience methods.
 */
public class ScHtmlIdAjax
    extends ScAjaxWrapper
{
    //##################################################
    //# variables
    //##################################################

    private ScHtmlIdIF _target;

    //##################################################
    //# constructor
    //##################################################

    public ScHtmlIdAjax(ScHtmlIdIF e)
    {
        _target = e;
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
        ajax().printMain(getTarget());
    }

    //##################################################
    //# visible
    //##################################################

    public ScShowScript show()
    {
        return ajax().show(getTarget());
    }

    public ScHideScript hide()
    {
        return ajax().hide(getTarget());
    }

    public ScToggleScript toggle()
    {
        return ajax().toggle(getTarget());
    }

    //##################################################
    //# contents
    //##################################################

    public void setContents(ScControl contents)
    {
        ajax().setContents(getTarget(), contents);
    }

    public void setContents(KmHtmlBuilder out)
    {
        ajax().setContents(getTarget(), out);
    }

    public void clearContents()
    {
        ajax().clearContents(getTarget());
    }

    public ScAddContentScript addContents()
    {
        return ajax().addContentsTo(getTarget());
    }

    //##################################################
    //# replace
    //##################################################

    public void replace()
    {
        ajax().replace(getTarget());
    }

    //##################################################
    //# text
    //##################################################

    public void setText(String e)
    {
        ajax().setText(getTarget(), e);
    }

    public void clearText()
    {
        ajax().clearText(getTarget());
    }

    //##################################################
    //# html
    //##################################################

    public void setHtml(String value)
    {
        ajax().setHtml(getTarget(), value);
    }

    public void clearHtml(ScHtmlIdIF target)
    {
        ajax().clearHtml(getTarget());
    }

    //##################################################
    //# misc
    //##################################################

    public void hideAllErrors()
    {
        String target = formatJquerySelector();
        String error = KmCssDefaultConstantsIF.error;

        run("$('%s .%s').hide();", target, error);
    }

    public void focus()
    {
        ajax().focus(getTarget());
    }

    //##################################################
    //# value
    //##################################################

    public void setValue(String e)
    {
        ajax().setValue(getTarget(), e);
    }

    public void clearValue()
    {
        ajax().clearValue(getTarget());
    }

    //##################################################
    //# stack
    //##################################################

    public void pop()
    {
        ajax().pop();
    }

    public void pushDefer()
    {
        ajax().pushDeferUntil(getTarget());
    }

    public void defer()
    {
        ajax().deferUntil(getTarget());
    }

    //##################################################
    //# on escape
    //##################################################

    public void onEscape(ScActionIF action)
    {
        ajax().onEscape(getTarget(), action);
    }

    public void onEscape(String script)
    {
        ajax().onEscape(getTarget(), script);
    }

    public void onEscape(ScScriptIF script)
    {
        ajax().onEscape(getTarget(), script);
    }

    //##################################################
    //# on control-enter
    //##################################################

    public void onControlEnter(ScScriptIF script)
    {
        ajax().onControlEnter(getTarget(), script);
    }

    public void onControlEnter(ScHtmlIdIF target, String e)
    {
        ajax().onControlEnter(getTarget(), e);
    }

    public void onControlEnter(ScHtmlIdIF target, ScActionIF e)
    {
        ajax().onControlEnter(getTarget(), e);
    }

    //##################################################
    //# block
    //##################################################

    public void block()
    {
        ajax().blockControl(getTarget());
    }

    public void unblock()
    {
        ajax().unblockControl(getTarget());
    }

    //##################################################
    //# hack
    //##################################################

    // fixme_wyatt: toast kludge 
    public void toast(String msg, Object... args)
    {
        ajax().toast(msg, args);
    }

    //##################################################
    //# equalize children
    //##################################################

    /**
     *  review_wyatt: (aaron) here are all the equalize methods, they all delegate
     *  to the ScEqualizeScrips and return it so extra options can be set.
     *  
     *  I also added a few convenience methods for children, children class, and
     *  descendent class.
     */
    public ScEqualizeScript equalizeChildren()
    {
        String selector;
        selector = Kmu.format("%s.children()", formatJqueryReference());

        return runEqualizeScript(selector);
    }

    public ScEqualizeScript equalizeChildrenGroups()
    {
        return equalizeChildrenClass(KmCssDefaultConstantsIF.group_prefix);
    }

    public ScEqualizeScript equalizeChildrenClass(String childClass)
    {
        String selector;
        selector = Kmu.format("$('%s > .%s')", formatJquerySelector(), childClass);

        return runEqualizeScript(selector);
    }

    public ScEqualizeScript equalizeDecendentClass(String childClass)
    {
        String selector;
        selector = Kmu.format("$('%s .%s')", formatJquerySelector(), childClass);

        return runEqualizeScript(selector);
    }

    private ScEqualizeScript runEqualizeScript(String selector)
    {
        ScEqualizeScript e;
        e = new ScEqualizeScript(selector);

        run(e);
        return e;
    }
}
