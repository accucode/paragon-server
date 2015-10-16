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
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScControlIF;
import com.kodemore.servlet.field.ScHtmlIdIF;

/**
 * I provide convenience methods for a particular target.
 * Note that the ScHtmlIdIF interface implements an ajax()
 * method that returns an instance of ScHtmlIdAjax.
 *
 * For example, instead of:
 *      ajax().hide(aControl);
 *
 * We can use:
 *      aControl.ajax().hide();
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

    public ScHtmlIdAjax(ScHtmlIdIF target)
    {
        this(target, ScBlockScript.create());
    }

    public ScHtmlIdAjax(ScHtmlIdIF target, ScBlockScript delegate)
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

    //##################################################
    //# when done
    //##################################################

    public ScWhenDoneAjax whenDone()
    {
        ScHtmlIdIF target = getTarget();
        ScHtmlIdIF waitFor = target;

        return whenDone(target, waitFor);
    }

    public ScWhenDoneAjax whenDone(ScHtmlIdIF waitFor)
    {
        return whenDone(getTarget(), waitFor);
    }

    public ScWhenDoneAjax pushWhenDone()
    {
        ScHtmlIdIF target = getTarget();
        ScHtmlIdIF waitFor = target;

        return pushWhenDone(target, waitFor);
    }

    public ScWhenDoneAjax pushWhenDone(ScHtmlIdIF waitFor)
    {
        return pushWhenDone(getTarget(), waitFor);
    }

    //##################################################
    //# visible
    //##################################################

    public ScShowScript show()
    {
        return show(getTarget());
    }

    public void show(boolean e)
    {
        if ( e )
            show();
        else
            hide();
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

    public ScGlowScript glowColor()
    {
        return glowColor(getTarget());
    }

    //##################################################
    //# contents
    //##################################################

    public ScReplaceContentsScript setContents(ScControl contents)
    {
        return setContents(getTarget(), contents);
    }

    public ScReplaceContentsScript setContents(KmHtmlBuilder out)
    {
        return setContents(getTarget(), out);
    }

    public ScReplaceContentsScript setContents(String html)
    {
        return setContents(getTarget(), html);
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

    public void insertContentsAfter(CharSequence html)
    {
        insertContentsAfter(getTarget(), html);
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

    public void setHtml(KmHtmlBuilder out)
    {
        setHtml(out.toString());
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

    public void focus()
    {
        getInner().focus(getTarget().getFocusTarget());
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

    public void setChecked(boolean checked)
    {
        setChecked(getTarget(), checked);
    }

    //##################################################
    //# on escape
    //##################################################

    public void onEscape(ScAction action)
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

    public void onControlEnter(ScAction e)
    {
        onControlEnter(getTarget(), e);
    }

    //##################################################
    //# on key up
    //##################################################

    public ScBlockScript onKeyUp()
    {
        return onKeyUp(getTarget());
    }

    public void onKeyUp(ScScriptIF script)
    {
        onKeyUp(getTarget(), script);
    }

    public void onKeyUp(String e)
    {
        onKeyUp(getTarget(), e);
    }

    public void onKeyUp(ScAction e)
    {
        onKeyUp(getTarget(), e);
    }

    //##################################################
    //# on change
    //##################################################

    public ScBlockScript onChange()
    {
        return onChange(getTarget());
    }

    public void onChange(ScScriptIF script)
    {
        onChange(getTarget(), script);
    }

    public void onChange(String e)
    {
        onChange(getTarget(), e);
    }

    public void onChange(ScAction e)
    {
        onChange(getTarget(), e);
    }

    public void fireOnChange()
    {
        fireOnChange(getTarget());
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
    //# tooltip
    //##################################################

    public void tooltip()
    {
        tooltip(getTarget());
    }

    //##################################################
    //# html class
    //##################################################

    public void addCss(String css)
    {
        addCss(getTarget(), css);
    }

    public void removeCss(String css)
    {
        removeCss(getTarget(), css);
    }

    public void setCss(String css)
    {
        setAttribute(getTarget(), "class", css);
    }

    public void clearCss()
    {
        clearCss(getTarget());
    }

    //##################################################
    //# scroll to
    //##################################################

    /**
     * Scroll my target such that the child becomes visible.
     */
    public void scrollTo(ScHtmlIdIF child)
    {
        scrollTo(getTarget(), child);
    }

    public void scrollToTop()
    {
        scrollToTop(getTarget());
    }

    public void scrollToIfOffScreen(String childSel)
    {
        scrollToIfOffScreen(getTarget(), childSel);
    }

    public void scrollToIfOffScreen(ScHtmlIdIF child)
    {
        scrollToIfOffScreen(child.getJquerySelector());
    }

    //##################################################
    //# html attributes
    //##################################################

    public void setAttribute(String key, String value)
    {
        setAttribute(getTarget(), key, value);
    }

    public void removeAttribute(String key)
    {
        removeAttribute(getTarget(), key);
    }

    //##################################################
    //# data attributes
    //##################################################

    public void setDataAttribute(String key, String value)
    {
        setDataAttribute(getTarget(), key, value);
    }

    public void setDataAttribute(String key, Boolean value)
    {
        setDataAttribute(getTarget(), key, value);
    }

    //##################################################
    //# sortable
    //##################################################

    public ScSortableScript sortable()
    {
        return sortable(getTarget());
    }

    //##################################################
    //# dialog
    //##################################################

    public void closeDialog()
    {
        closeDialog(getTarget());
    }

}
