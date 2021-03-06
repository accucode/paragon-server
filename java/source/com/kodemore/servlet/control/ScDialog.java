/*
  Copyright (c) 2005-2018 www.kodemore.com

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

package com.kodemore.servlet.control;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.json.KmJsonMap;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.script.ScAddContentScript;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalInteger;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

/**
 * I show a modal dialog.
 * I rely on jquery-ui dialogs and support nested/stacked dialogs.
 *
 * My root (topmost) element is abstract so that subclasses can use
 * either a form or div.
 *
 * For simple cases, clients should use the ScFormDialog as it automatically
 * manages a form, and has predefined sections for the header, body, and footer.
 * Dialogs that need to manage their own form should subclass from ScFormlessDialog
 * which uses div (instead of a form) but doesn't have any of the predefined layout.
 *
 * Dialogs do not render themselves onto the dom as part of the normal html render
 * process.  Instead, they attach themselves to the html body during ajaxOpen(),
 * and then automatically detach themselves from the dom when they close.
 *
 * Dialogs still need to be attached to the control hierarchy.  That is, they need
 * to have a parent.  This is needed in order to delegate commmon security checks
 * to the page root, and for a few other things.
 */
public abstract class ScDialog<T extends ScStyledHtmlIdIF>
    extends ScControl
    implements ScStyledHtmlIdIF
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The root element to which the content is added.
     * Typically a form or div.
     */
    private T _dialogRoot;

    /**
     * Determines if the user can drag the dialog window.
     * True by default.
     */
    private ScLocalBoolean _draggable;

    /**
     * Determines if the user is allows to manually resize
     * the dialog windows.
     * True by default.
     */
    private ScLocalBoolean _resizable;

    /**
     * The dialog's width.
     */
    private ScLocalInteger _width;

    /**
     * The dialog's height.  Null by default, the dialog will
     * auto-resize to fit the content.
     */
    private ScLocalInteger _height;

    /**
     * If false the "X" close button in the upper-right corner
     * will be hidden.  This is true by default.
     */
    private ScLocalBoolean _showsCloseButton;

    /**
     * Determines if the dialog should be closed when the escape key is pressed.
     * True by default.
     */
    private ScLocalBoolean _closeOnEscape;

    //##################################################
    //# constructor
    //##################################################

    public ScDialog()
    {
        _dialogRoot = createDialogRoot();

        _width = new ScLocalInteger(600);
        _height = new ScLocalInteger(null);
        _draggable = new ScLocalBoolean(true);
        _resizable = new ScLocalBoolean(true);
        _showsCloseButton = new ScLocalBoolean(true);
        _closeOnEscape = new ScLocalBoolean(true);

        style().hide().pad(0);
    }

    //##################################################
    //# dialog root
    //##################################################

    protected abstract T createDialogRoot();

    public final T getDialogRoot()
    {
        return _dialogRoot;
    }

    @Override
    public final KmList<ScControl> getChildren()
    {
        return KmList.createWith(getDialogRoot().asControl());
    }

    //##################################################
    //# html id
    //##################################################

    @Override
    public String getHtmlId()
    {
        return getDialogRoot().getHtmlId();
    }

    @Override
    public ScHtmlIdIF getFocusTarget()
    {
        return getDialogRoot().getFocusTarget();
    }

    @Override
    public ScHtmlIdAjax _htmlIdAjax()
    {
        return getDialogRoot()._htmlIdAjax();
    }

    //##################################################
    //# visible
    //##################################################

    @Override
    public final void setVisible(boolean e)
    {
        getDialogRoot().setVisible(e);
    }

    @Override
    public final boolean isVisible()
    {
        return getDialogRoot().isVisible();
    }

    //##################################################
    //# style
    //##################################################

    @Override
    public KmCssDefaultBuilder css()
    {
        return getDialogRoot().css();
    }

    @Override
    public KmStyleBuilder style()
    {
        return getDialogRoot().style();
    }

    //##################################################
    //# width
    //##################################################

    public Integer getWidth()
    {
        return _width.getValue();
    }

    public void setWidth(Integer px)
    {
        _width.setValue(px);
    }

    public boolean hasWidth()
    {
        return getWidth() != null;
    }

    //##################################################
    //# height
    //##################################################

    public Integer getHeight()
    {
        return _height.getValue();
    }

    public void setHeight(Integer px)
    {
        _height.setValue(px);
    }

    public boolean hasHeight()
    {
        return getHeight() != null;
    }

    //##################################################
    //# draggable
    //##################################################

    public boolean getDraggable()
    {
        return _draggable.getValue();
    }

    public void setDraggable(boolean e)
    {
        _draggable.setValue(e);
    }

    //##################################################
    //# resizable
    //##################################################

    public boolean getResizable()
    {
        return _resizable.getValue();
    }

    public void setResizable(boolean e)
    {
        _resizable.setValue(e);
    }

    //##################################################
    //# close button
    //##################################################

    public boolean getShowsCloseButton()
    {
        return _showsCloseButton.getValue();
    }

    public void setShowsCloseButton(boolean e)
    {
        _showsCloseButton.setValue(e);
    }

    public void hideCloseButton()
    {
        setShowsCloseButton(false);
    }

    //##################################################
    //# close on escape
    //##################################################

    public boolean getCloseOnEscape()
    {
        return _closeOnEscape.getValue();
    }

    public void setCloseOnEscape(boolean e)
    {
        _closeOnEscape.setValue(e);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    public void renderControlOn(KmHtmlBuilder out)
    {
        // none.
        // The content is rendered via ajaxOpen() -> ajaxAttachToBody().
    }

    //##################################################
    //# ajax :: open
    //##################################################

    /**
     * Create the dialog wrapper and overlay.
     * Add the dialog to the DOM if neeeded.
     */
    public void ajaxOpen()
    {
        preRender();
        ajaxAttachToBody();

        if ( getCloseOnEscape() )
            ajaxCloseOnEscape();

        getRootScript().run("$('%s').dialog(%s);", getJquerySelector(), getOpenOptions());
    }

    /**
     * Manually install a key listener to close the dialog on escape.
     * We intentionally do NOT use the jquery dialog option of closeOnEscape:true.
     * The reason is because jquery propogates the escape to the document which can
     * result in unexpected behavior if the page under the dialog also listens to the
     * escape key.  This has been tested with jquery ui 1.11.1.
     */
    private void ajaxCloseOnEscape()
    {
        ScBlockScript s;
        s = ScBlockScript.create();
        s.closeDialog(getDialogRoot());

        _htmlIdAjax().onEscape(s);
    }

    private void ajaxAttachToBody()
    {
        ScAddContentScript e;
        e = _htmlIdAjax().addContents();
        e.setContent(getDialogRoot());
        e.setSelector("body");
    }

    private KmJsonMap getOpenOptions()
    {
        KmJsonMap e;
        e = new KmJsonMap();
        e.setString("title", getLabel());
        e.setBoolean("autoOpen", true);
        e.setBoolean("closeOnEscape", false);
        e.setInteger("show", 150);
        e.setInteger("hide", 150);
        e.setBoolean("modal", true);
        e.setBoolean("stack", true);
        e.setBoolean("resizable", getResizable());
        e.setBoolean("draggable", getDraggable());

        String klass = formatDialogClass();
        if ( Kmu.hasValue(klass) )
            e.setString("dialogClass", klass);

        if ( hasWidth() )
            e.setInteger("width", getWidth());

        if ( hasHeight() )
            e.setInteger("height", getHeight());

        e.setLiteral("close", formatOnCloseFunction());

        KmJsonMap pos;
        pos = e.setMap("position");
        pos.setString("my", "top");
        pos.setString("at", "center top+5%");
        //        pos.setString("my", "center");
        //        pos.setString("at", "center top+30%");
        //        pos.setString("of", "#someTarget");

        return e;
    }

    private String formatOnCloseFunction()
    {
        return Kmu.format("function(){%s}", formatOnCloseScript());
    }

    /**
     * When the dialog closes, we destroy the dialog wrapper.
     * Also, if the dialog does not have a parent then we remove it from the dom.
     */
    private String formatOnCloseScript()
    {
        KmStringBuilder out;
        out = new KmStringBuilder();
        out.print("$(this).dialog('destroy');");
        out.printf("$('%s').remove();", getJquerySelector());
        return out.toString();
    }

    private String formatDialogClass()
    {
        KmList<String> v;
        v = new KmList<>();

        if ( !getShowsCloseButton() )
            v.add(KmCssDefaultConstantsIF.dialogNoClose);

        if ( v.isEmpty() )
            return null;

        return v.join();
    }

    //##################################################
    //# ajax :: other
    //##################################################

    @Override
    public void ajaxHideAllErrors()
    {
        _htmlIdAjax().hideAllErrors();
    }

    public void ajaxClose()
    {
        _htmlIdAjax().closeDialog();
    }

    //##################################################
    //# support
    //##################################################

    @Override
    public boolean isErrorRoot()
    {
        return true;
    }

}
