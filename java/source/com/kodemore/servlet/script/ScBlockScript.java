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
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.json.KmJsonMap;
import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScControlIF;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.utility.ScBridge;
import com.kodemore.servlet.utility.ScJquery;
import com.kodemore.servlet.utility.ScUrlBridge;
import com.kodemore.string.KmStringBuilder;
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
public abstract class ScBlockScript
    extends ScAbstractScript
{
    //##################################################
    //# instance creation
    //##################################################

    public static ScBlockScript create()
    {
        return new ScSimpleBlockScript();
    }

    //##################################################
    //# run
    //##################################################

    public void run(ScScriptIF e)
    {
        _add(e);
    }

    public ScScriptIF run(String s, Object... args)
    {
        ScScriptIF e;
        e = ScSimpleScript.create(s, args);
        run(e);
        return e;
    }

    public ScActionScript run(ScActionIF action)
    {
        ScActionScript e;
        e = ScActionScript.create(action);
        run(e);
        return e;
    }

    public ScActionScript run(ScActionIF action, ScForm form)
    {
        ScActionScript e;
        e = ScActionScript.create(action, form);
        run(e);
        return e;
    }

    public void returnFalse()
    {
        run("return false;");
    }

    public void returnTrue()
    {
        run("return true;");
    }

    //##################################################
    //# run delayed
    //##################################################

    public ScDelayedScript runDelayed()
    {
        ScDelayedScript e;
        e = new ScDelayedScript();

        _add(e);

        return e;
    }

    //##################################################
    //# when done
    //##################################################

    public ScWhenDoneAjax whenDone(ScHtmlIdIF target, ScHtmlIdIF waitFor)
    {
        ScWhenDoneAjax e;
        e = new ScWhenDoneAjax(target, waitFor);
        run(e);
        return e;
    }

    public abstract ScWhenDoneAjax pushWhenDone(ScHtmlIdIF target, ScHtmlIdIF waitFor);

    public abstract void popWhenDone();

    //##################################################
    //# call
    //##################################################

    public void call(String function)
    {
        run("%s();", function);
    }

    //##################################################
    //# html class
    //##################################################

    public void addCss(String sel, String css)
    {
        run("$(%s).addClass(%s);", json(sel), json(css));
    }

    public void addCss(ScHtmlIdIF target, String css)
    {
        addCss(target.getJquerySelector(), css);
    }

    public void removeCss(String sel, String css)
    {
        run("$(%s).removeClass(%s);", json(sel), json(css));
    }

    public void removeCss(ScHtmlIdIF target, String css)
    {
        removeCss(target.getJquerySelector(), css);
    }

    public void setCss(String sel, String css)
    {
        setAttribute(sel, "class", css);
    }

    public void setCss(ScHtmlIdIF target, String css)
    {
        setCss(target.getJquerySelector(), css);
    }

    public void clearCss(String sel)
    {
        removeAttribute(sel, "class");
    }

    public void clearCss(ScHtmlIdIF target)
    {
        clearCss(target.getJquerySelector());
    }

    //##################################################
    //# messages
    //##################################################

    public void alert(String msg)
    {
        run("alert(%s);", json(msg));
    }

    public void alert(String msg, Object... args)
    {
        String s = Kmu.format(msg, args);
        alert(s);
    }

    //##################################################
    //# toast
    //##################################################

    public ScToastScript toast()
    {
        ScToastScript e;
        e = new ScToastScript();

        run(e);

        return e;
    }

    public ScToastScript toast(Object o)
    {
        ScToastScript e;
        e = toast();
        e.setText(o + "");
        return e;
    }

    public ScToastScript toast(String s)
    {
        ScToastScript e;
        e = toast();
        e.setText(s);
        return e;
    }

    public ScToastScript toast(String msg, Object... args)
    {
        String s = Kmu.format(msg, args);
        return toast(s);
    }

    //##################################################
    //# contents
    //##################################################

    public void clearContents(String sel)
    {
        run("$(%s).empty();", json(sel));
    }

    public void clearContents(ScHtmlIdIF target)
    {
        String sel = target.getJquerySelector();
        clearContents(sel);
    }

    public void appendContents(String sel, CharSequence html)
    {
        if ( Kmu.isEmpty(html) )
            return;

        run("$(%s).append(%s);", json(sel), json(html));
    }

    public void appendContents(ScHtmlIdIF target, CharSequence html)
    {
        appendContents(target.getJquerySelector(), html);
    }

    public void prependContents(String sel, CharSequence html)
    {
        if ( Kmu.isEmpty(html) )
            return;

        run("$(%s).prepend(%s);", json(sel), json(html));
    }

    public void prependContents(ScHtmlIdIF target, CharSequence html)
    {
        prependContents(target.getJquerySelector(), html);
    }

    public void insertContentsAfter(String sel, CharSequence html)
    {
        if ( Kmu.isEmpty(html) )
            return;

        run("$(%s).after(%s);", json(sel), json(html));
    }

    public void insertContentsAfter(ScHtmlIdIF target, CharSequence html)
    {
        insertContentsAfter(target.getJquerySelector(), html);
    }

    public void addDivIdTo(String sel, String divId)
    {
        String html = Kmu.format("<div id='%s'></div>", divId);
        appendContents(sel, html);
    }

    //##################################################
    //# set contents
    //##################################################

    public ScReplaceContentsScript setContents()
    {
        ScReplaceContentsScript e;
        e = new ScReplaceContentsScript();
        run(e);
        return e;
    }

    public ScReplaceContentsScript setContents(ScHtmlIdIF target, ScControlIF c)
    {
        String sel = target.getJquerySelector();
        return setContents(sel, c);
    }

    public ScReplaceContentsScript setContents(String sel, ScControlIF c)
    {
        if ( c == null )
            return setContents(sel, (KmHtmlBuilder)null);

        return setContents(sel, c.render());
    }

    public ScReplaceContentsScript setContents(ScHtmlIdIF target, KmHtmlBuilder contents)
    {
        String sel = target.getJquerySelector();
        return setContents(sel, contents);
    }

    public ScReplaceContentsScript setContents(String sel, KmHtmlBuilder contents)
    {
        ScReplaceContentsScript r;
        r = setContents();
        r.setSelector(sel);
        r.setContents(contents);
        return r;
    }

    public ScReplaceContentsScript setContents(ScHtmlIdIF target, String html)
    {
        KmHtmlBuilder contents = new KmHtmlBuilder(html);
        return setContents(target, contents);
    }

    public ScReplaceContentsScript setContents(String sel, String html)
    {
        KmHtmlBuilder contents = new KmHtmlBuilder(html);
        return setContents(sel, contents);
    }

    //##################################################
    //# add contents
    //##################################################

    public ScAddContentScript addContentsTo(String sel)
    {
        ScAddContentScript e;
        e = new ScAddContentScript();
        e.setSelector(sel);
        run(e);
        return e;
    }

    public ScAddContentScript addContentsTo(ScHtmlIdIF target)
    {
        return addContentsTo(target.getJquerySelector());
    }

    //##################################################
    //# navigation
    //##################################################

    /**
     * All of the pushPage methods redirect to me.
     *
     * Before adding the pushPage script, I write the CURRENT page session.  Updating the
     * page session as part of navigation is relatively rare, but when it does happen it is
     * important to ensure that the client side session gets updated BEFORE triggering the
     * client side history and navigation flows.
     */
    private ScPushPageScript _pushPage()
    {
        updatePageSession();

        ScPushPageScript e;
        e = new ScPushPageScript();
        run(e);
        return e;
    }

    public ScPushPageScript pushPage(String url)
    {
        ScPushPageScript e;
        e = _pushPage();
        e.setUrl(url);
        return e;
    }

    public ScPushPageScript pushPage(ScPage page)
    {
        ScPushPageScript e;
        e = _pushPage();
        e.setUrl(page);
        return e;
    }

    /**
     * Uses replaces the current browser history with the current
     * state of the page specified.  This does NOT trigger a navigation
     * event.
     */
    public ScPushPageScript replaceHistory(ScPage page)
    {
        ScPushPageScript e;
        e = pushPage(page);
        e.setReplace();
        e.setHandleStateChange(false);
        return e;
    }

    public void back()
    {
        run("window.history.back();");
    }

    public void gotoUrl(String uri)
    {
        run("window.location.href=%s;", json(uri));
    }

    //##################################################
    //# remove
    //##################################################

    public void remove(String sel)
    {
        run("$(%s).remove();", json(sel));
    }

    public void remove(ScHtmlIdIF target)
    {
        remove(target.getJquerySelector());
    }

    //##################################################
    //# replace with
    //##################################################

    public void replaceWith(String targetSel, KmHtmlBuilder out)
    {
        String html = out.formatHtml();
        String postDom = out.getPostDom().formatScript();
        String postRender = out.getPostRender().formatScript();

        run("$(%s).replaceWith(%s);", json(targetSel), json(html));
        run(postDom);
        run(postRender);
    }

    public void replaceWith(String targetSel, ScControlIF with)
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.render(with);

        replaceWith(targetSel, out);
    }

    public void replaceWith(ScHtmlIdIF target, ScControlIF with)
    {
        replaceWith(target.getJquerySelector(), with);
    }

    //##################################################
    //# focus
    //##################################################

    /**
     * Focus on the first enabled field found on the page.
     */
    public void focusPage()
    {
        run("Kmu.focus();");
    }

    public void focus(ScHtmlIdIF e)
    {
        if ( e == null )
            return;

        e = e.getFocusTarget();
        focus(e.getJquerySelector());
    }

    public void focus(String sel)
    {
        if ( Kmu.isEmpty(sel) )
            focusPage();
        else
            run("Kmu.focus(%s);", json(sel));
    }

    //##################################################
    //# show
    //##################################################

    public ScShowScript show(ScHtmlIdIF e)
    {
        return show(e.getJquerySelector());
    }

    public ScShowScript show(String sel)
    {
        ScShowScript s;
        s = new ScShowScript();
        s.setSelector(sel);

        _add(s);

        return s;
    }

    public ScHideScript hide(ScHtmlIdIF e)
    {
        return hide(e.getJquerySelector());
    }

    public ScHideScript hide(String sel)
    {
        ScHideScript s;
        s = new ScHideScript();
        s.setSelector(sel);

        _add(s);

        return s;
    }

    public ScToggleScript toggle(ScHtmlIdIF e)
    {
        return toggle(e.getJquerySelector());
    }

    public ScToggleScript toggle(String sel)
    {
        ScToggleScript e;
        e = new ScToggleScript();
        e.setSelector(sel);

        _add(e);

        return e;
    }

    public ScGlowScript glow(String sel)
    {
        ScGlowScript e;
        e = new ScGlowScript();
        e.setTarget(sel);

        run(e);

        return e;
    }

    public ScGlowScript glow(ScHtmlIdIF target)
    {
        return glow(target.getJquerySelector());
    }

    //==================================================
    //= glow :: color
    //==================================================

    public ScGlowScript glowColor(String sel)
    {
        ScGlowScript e;
        e = glow(sel);
        e.setAttribute("color");
        e.setValue("yellow");
        return e;
    }

    public ScGlowScript glowColor(ScHtmlIdIF target)
    {
        return glowColor(target.getJquerySelector());
    }

    //##################################################
    //# open window
    //##################################################

    public ScOpenWindowScript openWindow()
    {
        ScOpenWindowScript e;
        e = new ScOpenWindowScript();

        _add(e);

        return e;
    }

    public ScOpenWindowScript openWindowHtml(String html)
    {
        ScOpenWindowScript e;
        e = openWindow();
        e.setHtml(html);
        return e;
    }

    public ScOpenWindowScript openWindowUrl(String url)
    {
        ScOpenWindowScript e;
        e = openWindow();
        e.setUrl(url);
        return e;
    }

    //##################################################
    //# errors
    //##################################################

    /**
     * Hide all errors on the entire page.
     */
    public void hideAllErrors()
    {
        String sel = "." + KmCssDefaultConstantsIF.error;
        hide(sel);
    }

    //##################################################
    //# session
    //##################################################

    /**
     * This is normally handled automatically immediately and clients should not need
     * to call this directly under most circumstances.  There are two cases where this
     * is usually handled automatically:
     *
     * 1) Any time the client code calls pushPage.  This ensures the client-side page
     *      session is updated before navigating away from the page and updating the
     *      browser history stack.
     *
     * 2) At the end of every normal ajax request.
     */
    public void updatePageSession()
    {
        KmJsonMap json = getData().getPageSessionEncodedValues();
        run("KmNavigator.updatePageSession(%s);", json);
    }

    /**
     * See 'pageKey' variable in KmUtility.js.
     */
    public void updateCurrentPageKey(ScPage e)
    {
        run("Kmu.currentPageKey = '%s';", e.getKey());
    }

    //##################################################
    //# text
    //##################################################

    public void setText(ScHtmlIdIF target, String value)
    {
        run("%s.text(%s);", formatReference(target), json(value));
    }

    public void clearText(ScHtmlIdIF target)
    {
        setText(target, "");
    }

    public void setHtml(ScHtmlIdIF target, String value)
    {
        run("%s.html(%s);", formatReference(target), json(value));
    }

    public void clearHtml(ScHtmlIdIF target)
    {
        clearText(target);
    }

    //##################################################
    //# html attributes
    //##################################################

    public void setAttribute(ScHtmlIdIF target, String key, String value)
    {
        setAttribute(target.getJquerySelector(), key, value);
    }

    public void setAttribute(String sel, String key, String value)
    {
        if ( value == null )
            removeAttribute(sel, key);
        else
            run("$(%s).attr(%s,%s);", json(sel), json(key), json(value));
    }

    public void removeAttribute(ScHtmlIdIF target, String key)
    {
        removeAttribute(target.getJquerySelector(), key);
    }

    public void removeAttribute(String sel, String key)
    {
        run("$(%s).removeAttr(%s);", json(sel), json(key));
    }

    public void setValue(ScHtmlIdIF field, String value)
    {
        run("%s.val(%s);", formatReference(field), json(value));
    }

    public void clearValue(ScHtmlIdIF field)
    {
        setValue(field, "");
    }

    //##################################################
    //# dialog
    //##################################################

    public void openErrorDialog(Throwable ex)
    {
        ScBridge.getInstance().displayError(ex);
    }

    public void closeDialog(String sel)
    {
        run("$('%s').dialog('close');", sel);
    }

    public void closeDialog(ScHtmlIdIF target)
    {
        closeDialog(target.getJquerySelector());
    }

    //##################################################
    //# cookie
    //##################################################

    /**
     * Set a cookie.
     */
    public void setCookie(String key, String value)
    {
        run("Kmu.setCookie(%s,%s);", json(key), json(value));
    }

    /**
     * Set a cookie.
     */
    public void setCookie(String key, Boolean value)
    {
        String s = Kmu.format_trueFalse(value);
        setCookie(key, s);
    }

    /**
     * Clear a cookie.  This may delete the cookie, or just clear
     * its value.
     */
    public void clearCookie(String key)
    {
        run("Kmu.clearCookie(%s);", json(key));
    }

    //##################################################
    //# on escape
    //##################################################

    public ScBlockScript onEscape(ScHtmlIdIF target)
    {
        ScBlockScript block = new ScSimpleBlockScript();
        onEscape(target, block);
        return block;
    }

    public void onEscape(ScHtmlIdIF target, ScScriptIF script)
    {
        String ref = formatReference(target);
        String fn = ref + ".onEscape(function(){%s});";

        ScScriptPattern e;
        e = new ScScriptPattern();
        e.setPattern(fn);
        e.addArgument(script);
        run(e);
    }

    public void onEscape(ScHtmlIdIF target, String e)
    {
        onEscape(target, ScSimpleScript.create(e));
    }

    public void onEscape(ScHtmlIdIF target, ScActionIF action)
    {
        onEscape(target, ScActionScript.create(action));
    }

    //##################################################
    //# on control-enter
    //##################################################

    public ScBlockScript onControlEnter(ScHtmlIdIF target)
    {
        ScBlockScript block = new ScSimpleBlockScript();
        onControlEnter(target, block);
        return block;
    }

    public void onControlEnter(ScHtmlIdIF target, ScScriptIF script)
    {
        String ref = ScJquery.formatReference(target);
        String fn = ref + ".onControlEnter(function(){%s});";

        ScScriptPattern e;
        e = new ScScriptPattern();
        e.setPattern(fn);
        e.addArgument(script);
        run(e);
    }

    public void onControlEnter(ScHtmlIdIF target, String e)
    {
        onControlEnter(target, ScSimpleScript.create(e));
    }

    public void onControlEnter(ScHtmlIdIF target, ScActionIF e)
    {
        onControlEnter(target, ScActionScript.create(e));
    }

    //##################################################
    //# on key up
    //##################################################

    public ScBlockScript onKeyUp(ScHtmlIdIF target)
    {
        ScBlockScript block = new ScSimpleBlockScript();
        onKeyUp(target, block);
        return block;
    }

    public void onKeyUp(ScHtmlIdIF target, ScScriptIF script)
    {
        String ref = formatReference(target);
        String fn = ref + ".keyup(function(){%s});";

        ScScriptPattern e;
        e = new ScScriptPattern();
        e.setPattern(fn);
        e.addArgument(script);
        run(e);
    }

    public void onKeyUp(ScHtmlIdIF target, String e)
    {
        onKeyUp(target, ScSimpleScript.create(e));
    }

    public void onKeyUp(ScHtmlIdIF target, ScActionIF e)
    {
        onKeyUp(target, ScActionScript.create(e));
    }

    //##################################################
    //# on change
    //##################################################

    public ScBlockScript onChange(ScHtmlIdIF target)
    {
        ScBlockScript block = new ScSimpleBlockScript();
        onChange(target, block);
        return block;
    }

    public void onChange(ScHtmlIdIF target, ScScriptIF script)
    {
        String ref = formatReference(target);
        String fn = ref + ".change(function(){%s});";

        ScScriptPattern e;
        e = new ScScriptPattern();
        e.setPattern(fn);
        e.addArgument(script);
        run(e);
    }

    public void onChange(ScHtmlIdIF target, String e)
    {
        onChange(target, ScSimpleScript.create(e));
    }

    public void onChange(ScHtmlIdIF target, ScActionIF e)
    {
        onChange(target, ScActionScript.create(e));
    }

    //##################################################
    //# fire on change
    //##################################################

    public void fireOnChange(ScHtmlIdIF target)
    {
        fireOnChange(target.getJquerySelector());
    }

    public void fireOnChange(String sel)
    {
        run("$(%s).change();", json(sel));
    }

    //##################################################
    //# block
    //##################################################

    public void blockPage()
    {
        run("Kmu.blockPage();");
    }

    public void unblockPage()
    {
        run("Kmu.unblockPage();");
    }

    public void blockControl(ScHtmlIdIF target)
    {
        run("Kmu.blockControl('%s');", target.getJquerySelector());
    }

    public void unblockControl(ScHtmlIdIF target)
    {
        run("Kmu.unblockControl('%s');", target.getJquerySelector());
    }

    //##################################################
    //# download
    //##################################################

    public void download(String name, CharSequence value)
    {
        byte[] bytes = value.toString().getBytes();
        download(name, bytes);
    }

    public void download(String name, byte[] value)
    {
        String url = ScUrlBridge.getInstance().createDownloadFor(name, value);
        String html = formatDownloadHtml(name, url);

        openWindowHtml(html);
    }

    private String formatDownloadHtml(String name, String url)
    {
        String onload = Kmu.format("window.location='%s';", url);

        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.printDocType();
        out.beginHtml();
        out.printTitle("Download");

        out.openBody();
        out.printAttribute("onload", onload);
        out.close();

        out.printHeader1("Downloading: " + name);
        out.println("Your download will begin shortly...");

        out.open("button");
        out.printAttribute("onclick", "window.close();");
        out.close();
        out.print("Close");
        out.end("button");

        out.endBody();
        out.endHtml();

        return out.toString();
    }

    //##################################################
    //# equalize
    //##################################################

    /**
     * Equalize the sizes of all elements that match the selector.
     */
    public ScEqualizeScript equalize(String sel)
    {
        ScEqualizeScript e;
        e = new ScEqualizeScript();
        e.setSelector(sel);

        run(e);
        return e;
    }

    /**
     * Equalize the immediate children of the target.
     */
    public ScEqualizeScript equalizeChildrenOf(ScHtmlIdIF target)
    {
        return equalizeChildrenOf(target.getJquerySelector());
    }

    /**
     * Equalize the immediate children of the target.
     */
    public ScEqualizeScript equalizeChildrenOf(String sel)
    {
        sel += " > *";
        return equalize(sel);
    }

    /**
     * Equalize all groups contained in the target.
     */
    public ScEqualizeScript equalizeGroupsIn(ScHtmlIdIF target)
    {
        return equalizeGroupsIn(target.getJquerySelector());
    }

    /**
     * Equalize all groups contained in the target.
     */
    public ScEqualizeScript equalizeGroupsIn(String sel)
    {
        String klass = KmCssDefaultConstantsIF.group;
        return equalizeClassIn(sel, klass);
    }

    /**
     * Equalize all group bodies contained in the target.
     */
    public ScEqualizeScript equalizeGroupBodiesIn(ScHtmlIdIF target)
    {
        return equalizeGroupBodiesIn(target.getJquerySelector());
    }

    /**
     * Equalize the group bodies within the target.
     */
    public ScEqualizeScript equalizeGroupBodiesIn(String sel)
    {
        String klass = KmCssDefaultConstantsIF.groupBody;
        return equalizeClassIn(sel, klass);
    }

    /**
     * Equalize all elements with a matching class, contained in the target.
     */
    public ScEqualizeScript equalizeClassIn(ScHtmlIdIF target, String klass)
    {
        return equalizeClassIn(target.getJquerySelector(), klass);
    }

    /**
     * Equalize all elements with a matching class, contained in the target.
     */
    public ScEqualizeScript equalizeClassIn(String sel, String klass)
    {
        sel += " ." + klass;
        return equalize(sel);
    }

    //##################################################
    //# sort
    //##################################################

    public ScSortableScript sortable(ScHtmlIdIF target)
    {
        ScSortableScript e;
        e = new ScSortableScript();
        e.setContainer(target);
        run(e);
        return e;
    }

    //##################################################
    //# scrollTo
    //##################################################

    /**
     * Scroll a container such that the target become visible.
     * This function relies on:
     *      jQuery.SerialScroll
     *      by Ariel Flesler
     *      http://flesler.blogspot.com/
     */
    public void scrollTo(String containerSel, String targetSel, Integer speedMs)
    {
        if ( speedMs == null )
            run("$('%s').scrollTo('%s');", containerSel, targetSel);
        else
            run("$('%s').scrollTo('%s',%s);", containerSel, targetSel, speedMs);
    }

    public void scrollTo(String containerSel, String targetSel)
    {
        Integer speedMs = null;
        scrollTo(containerSel, targetSel, speedMs);
    }

    public void scrollTo(ScHtmlIdIF container, ScHtmlIdIF target, Integer speedMs)
    {
        scrollTo(container.getJquerySelector(), target.getJquerySelector(), speedMs);
    }

    public void scrollTo(ScHtmlIdIF container, ScHtmlIdIF target)
    {
        Integer speedMs = null;
        scrollTo(container, target, speedMs);
    }

    //##################################################
    //# scrollToTop
    //##################################################

    public void scrollToTop(ScHtmlIdIF container)
    {
        Integer speedMs = null;
        scrollToTop(container, speedMs);
    }

    public void scrollToTop(ScHtmlIdIF container, Integer speedMs)
    {
        scrollToTop(container.getJquerySelector(), speedMs);
    }

    public void scrollToTop(String containerSel, Integer speedMs)
    {
        if ( speedMs == null )
            run("$('%s').scrollTo(0);", containerSel);
        else
            run("$('%s').scrollTo(0,%s);", containerSel, speedMs);
    }

    //##################################################
    //# scrollTo (off screen)
    //##################################################

    public void scrollToIfOffScreen(ScHtmlIdIF container, ScHtmlIdIF target)
    {
        scrollToIfOffScreen(container, target.getJquerySelector());
    }

    public void scrollToIfOffScreen(ScHtmlIdIF container, String targetSel)
    {
        String containerSel = container.getJquerySelector();
        run("Kmu.scrollToIfOffScreen('%s','%s');", containerSel, targetSel);
    }

    //##################################################
    //# tooltip
    //##################################################

    /**
     * jQuery tooltip which uses title (hover) but is much prettier
     * and easier to see.
     */
    public void tooltip(String sel)
    {
        run("$('%s').tooltip();", sel);
    }

    public void tooltip(ScHtmlIdIF target)
    {
        tooltip(target.getJquerySelector());
    }

    //##################################################
    //# format
    //##################################################

    @Override
    public void formatScriptOn(KmStringBuilder out)
    {
        for ( ScScriptIF e : getScripts() )
            e.formatScriptOn(out);
    }

    @Override
    public void formatMultilineScriptOn(KmStringBuilder out)
    {
        for ( ScScriptIF e : getScripts() )
            e.formatMultilineScriptOn(out);
    }

    //##################################################
    //# scripts
    //##################################################

    protected abstract KmList<ScScriptIF> getScripts();

    /**
     * All actions should ultimately resolve to calling me.
     * I provide standard hooks for all scripts.
     */
    protected void _add(ScScriptIF e)
    {
        getScripts().addNonNull(e);
    }

    public void clearScript()
    {
        getScripts().clear();
    }

    public boolean isEmpty()
    {
        return getScripts().isEmpty();
    }

    public boolean isNotEmpty()
    {
        return !isEmpty();
    }

}
