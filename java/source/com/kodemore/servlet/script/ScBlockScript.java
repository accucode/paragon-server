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
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.json.KmJsonObject;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScControlIF;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.utility.ScPageLayoutBridge;
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
    private KmList<ScScriptIF> _list;

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
    private ScBlockScript      _stack;

    //##################################################
    //# constructor
    //##################################################

    public ScBlockScript()
    {
        clearScript();
    }

    public void clearScript()
    {
        _list = new KmList<ScScriptIF>();
        _stack = null;
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
    //# stack
    //##################################################

    /**
     * Technically this is a push, but most context don't
     * actually care about the push/pop relationship - instead
     * they really just want to "wait" until the animation is 
     * done before running the rest of the script.  For these
     * cases, this method provides clearer code.  Clients that 
     * use pop should also use a corresponding push.
     */
    public void deferUntil(ScHtmlIdIF target)
    {
        pushDeferUntil(target);
    }

    public void deferUntil(String sel)
    {
        pushDeferUntil(sel);
    }

    /**
     * Push a context onto the stack.  The new context is 
     * wrapped in an anonomous function
     * 
     *      function() { ... }
     * 
     * And is deferred until the target's "promise" is done. 
     */
    public void pushDeferUntil(ScHtmlIdIF target)
    {
        pushDeferUntil(target.formatJquerySelector());
    }

    public void pushDeferUntil(String sel)
    {
        if ( _stack != null )
        {
            _stack.pushDeferUntil(sel);
            return;
        }

        ScDeferredScript promise;
        promise = new ScDeferredScript();
        promise.setSelector(sel);

        _add(promise);
        _stack = promise;
    }

    public void pop()
    {
        if ( _stack == null )
            Kmu.fatal("Cannot pop empty stack.");

        if ( _stack.hasStack() )
            _stack.pop();
        else
            _stack = null;
    }

    public boolean hasStack()
    {
        return _stack != null;
    }

    //##################################################
    //# call
    //##################################################

    public void call(String function)
    {
        run("%s();", function);
    }

    //##################################################
    //# navigation
    //##################################################

    public void back()
    {
        run("window.history.back();");
    }

    public void gotoHash(String e)
    {
        run("window.location.hash=%s;", json(e));
    }

    public void gotoUrl(String uri)
    {
        run("window.location.href=%s;", json(uri));
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
        addCss(target.formatJquerySelector(), css);
    }

    public void removeCss(String sel, String css)
    {
        run("$(%s).removeClass(%s);", json(sel), json(css));
    }

    public void removeCss(ScHtmlIdIF target, String css)
    {
        removeCss(target.formatJquerySelector(), css);
    }

    public void setCss(String sel, String css)
    {
        setAttribute(sel, "class", css);
    }

    public void setCss(ScHtmlIdIF target, String css)
    {
        setCss(target.formatJquerySelector(), css);
    }

    public void clearCss(String sel)
    {
        removeAttribute(sel, "class");
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
        String sel = target.formatJquerySelector();
        clearContents(sel);
    }

    public void appendContents(String sel, CharSequence html)
    {
        if ( Kmu.isEmpty(html) )
            return;

        run("$(%s).append(%s);", json(sel), json(html));
    }

    public void addDivIdTo(String sel, String divId)
    {
        String html = Kmu.format("<div id='%s'></div>", divId);
        appendContents(sel, html);
    }

    //##################################################
    //# replace contents
    //##################################################

    public ScReplaceContentsScript setContents()
    {
        ScReplaceContentsScript e;
        e = new ScReplaceContentsScript();
        run(e);
        return e;
    }

    public void setContents(ScHtmlIdIF target, ScControlIF c)
    {
        String sel = target.formatJquerySelector();
        setContents(sel, c);
    }

    public void setContents(String sel, ScControlIF c)
    {
        if ( c == null )
            clearContents(sel);
        else
            setContents(sel, c.render());
    }

    public void setContents(ScHtmlIdIF target, KmHtmlBuilder contents)
    {
        String sel = target.formatJquerySelector();
        setContents(sel, contents);
    }

    public void setContents(String sel, KmHtmlBuilder contents)
    {
        ScReplaceContentsScript r;
        r = setContents();
        r.setSelector(sel);
        r.setContents(contents);
    }

    //##################################################
    //# add contents
    //##################################################

    public ScAddContentScript addContentsTo(ScHtmlIdIF target)
    {
        ScAddContentScript e;
        e = new ScAddContentScript();
        e.setSelector(target);
        run(e);
        return e;
    }

    //##################################################
    //# main
    //##################################################

    public void printMain(ScControlIF e)
    {
        setContents(getMainSelector(), e);
    }

    public void clearMain()
    {
        clearContents(getMainSelector());
    }

    private String getMainSelector()
    {
        return ScPageLayoutBridge.getInstance().getMainSelector();
    }

    //##################################################
    //# replace with
    //##################################################

    public void replaceWith(String target, KmHtmlBuilder out)
    {
        String html = out.formatHtml();
        String postDom = out.getPostDom().formatScript();
        String postRender = out.getPostRender().formatScript();

        run("$(%s).replaceWith(%s);", json(target), json(html));
        run(postDom);
        run(postRender);
    }

    public void replaceWith(String target, ScControlIF with)
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.render(with);

        replaceWith(target, out);
    }

    public void replaceWith(ScHtmlIdIF target, ScControlIF with)
    {
        replaceWith(target.formatJquerySelector(), with);
    }

    public void replace(ScHtmlIdIF target)
    {
        ScControlIF with = target;
        replaceWith(target, with);
    }

    //##################################################
    //# focus
    //##################################################

    public void focus()
    {
        _focus(null);
    }

    public void focus(ScHtmlIdIF e)
    {
        _focus(e.formatJquerySelector());
    }

    public void focus(String sel)
    {
        _focus(sel);
    }

    private void _focus(String sel)
    {
        if ( sel == null )
            run("Kmu.focus();");
        else
            run("Kmu.focus(%s);", json(sel));
    }

    //##################################################
    //# show
    //##################################################

    public ScShowScript show(ScHtmlIdIF e)
    {
        return show(e.formatJquerySelector());
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
        return hide(e.formatJquerySelector());
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
        return toggle(e.formatJquerySelector());
    }

    public ScToggleScript toggle(String sel)
    {
        ScToggleScript e;
        e = new ScToggleScript();
        e.setSelector(sel);

        _add(e);

        return e;
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
     * This is normally handled automatically immediately
     * before the ajax script is flushed to the http response.
     * See: ScAjaxResult.applyTo();
     */
    public void updatePageSession()
    {
        KmJsonObject json = getData().getPageSessionEncodedValues();
        run("Kmu.updatePageSession(%s);", json);
    }

    //##################################################
    //# text
    //##################################################

    public void setText(ScHtmlIdIF target, String value)
    {
        run("%s.text(%s);", target.formatJqueryReference(), json(value));
    }

    public void clearText(ScHtmlIdIF target)
    {
        setText(target, "");
    }

    public void setHtml(ScHtmlIdIF target, String value)
    {
        run("%s.html(%s);", target.formatJqueryReference(), json(value));
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
        setAttribute(target.formatJquerySelector(), key, value);
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
        removeAttribute(target.formatJquerySelector(), key);
    }

    public void removeAttribute(String sel, String key)
    {
        run("$(%s).removeAttr(%s);", json(sel), json(key));
    }

    public void setValue(ScHtmlIdIF field, String value)
    {
        run("$(%s).val(%s);", field.formatJqueryReference(), json(value));
    }

    public void clearValue(ScHtmlIdIF field)
    {
        setValue(field, "");
    }

    //##################################################
    //# dialog (target)
    //##################################################

    /**
     * Open the target as a modal dialog using the SimpleModal library.
     * This is typically used on a target that is otherwise hidden.
     * See ScDialog for a convenient wrapper.
     */
    public void openDialogTarget(ScHtmlIdIF target, KmJsonObject options)
    {
        if ( options == null )
            run("Kmu.openDialogTarget(%s);", json(target));
        else
            run("Kmu.openDialogTarget(%s,%s);", json(target), options);
    }

    public void openDialogTarget(ScHtmlIdIF target)
    {
        openDialogTarget(target, null);
    }

    public void openDialogTargetSample(ScHtmlIdIF target)
    {
        KmJsonObject css;
        css = new KmJsonObject();
        css.setString("color", "black");
        css.setString("backgroundColor", "#fcc");
        css.setString("borderColor", "#f00");
        css.setString("width", "600px");
        css.setString("height", "400px");
        css.setString("padding", "0px");

        KmJsonObject options;
        options = new KmJsonObject();
        options.setObject("containerCss", css);

        openDialogTarget(target, options);
    }

    //##################################################
    //# dialog (html)
    //##################################################

    public void openDialogHtml(CharSequence html)
    {
        openDialogHtml(html, null);
    }

    public void openDialogHtml(CharSequence html, KmJsonObject options)
    {
        if ( options == null )
            run("Kmu.openDialogHtml(%s);", json(html));
        else
            run("Kmu.openDialogHtml(%s,%s);", json(html), options);
    }

    public void openDialogHtml(KmHtmlBuilder html, KmJsonObject options)
    {
        openDialogHtml(html.toString(), options);
    }

    public void openDialogError(Throwable ex)
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.beginDiv();
        out.printTextCss(ex.getMessage(), "font16 bold sans");
        out.printBreak();
        out.printBreak();
        out.print(Kmu.formatStackTrace(ex));
        out.endDiv();

        KmJsonObject css;
        css = new KmJsonObject();
        css.setString("color", "black");
        css.setString("backgroundColor", "#fcc");
        css.setString("borderColor", "#f00");
        css.setString("width", "600px");
        css.setString("height", "400px");
        css.setString("padding", "0px");

        KmJsonObject options;
        options = new KmJsonObject();
        options.setObject("containerCss", css);

        openDialogHtml(out, options);
    }

    //##################################################
    //# dialog (close)
    //##################################################

    public void closeDialog()
    {
        run("Kmu.closeDialog();");
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

    public void onEscape(ScHtmlIdIF target, ScScriptIF script)
    {
        String ref = target.formatJqueryReference();
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

    public ScScript onControlEnter(ScHtmlIdIF target)
    {
        ScScript e;
        e = new ScScript();

        onControlEnter(target, e);

        return e;
    }

    public void onControlEnter(ScHtmlIdIF target, ScScriptIF script)
    {
        String ref = target.formatJqueryReference();
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
        run("Kmu.blockControl('%s');", target.formatJquerySelector());
    }

    public void unblockControl(ScHtmlIdIF target)
    {
        run("Kmu.unblockControl('%s');", target.formatJquerySelector());
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
    //# format
    //##################################################

    @Override
    public void formatScriptOn(KmStringBuilder out)
    {
        for ( ScScriptIF e : _list )
            e.formatScriptOn(out);
    }

    @Override
    public void formatMultilineScriptOn(KmStringBuilder out)
    {
        for ( ScScriptIF e : _list )
        {
            e.formatMultilineScriptOn(out);
            out.println();
        }
    }

    //##################################################
    //# support
    //##################################################

    /**
     * All actions should ultimately resolve to calling me. 
     * I provide standard hooks for all scripts.
     */
    private void _add(ScScriptIF e)
    {
        if ( e == null )
            return;

        if ( _stack == null )
            _list.add(e);
        else
            _stack._add(e);
    }

}
