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

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.meta.KmMetaAttribute;
import com.kodemore.servlet.renderer.ScRenderer;
import com.kodemore.servlet.script.ScShowNoticeScript;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalInteger;
import com.kodemore.servlet.variable.ScLocalRenderer;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.KmSimpleResult;
import com.kodemore.utility.Kmu;

public abstract class ScButton
    extends ScElement
{
    //##################################################
    //# constants
    //##################################################

    private static final String FLAVOR_NORMAL     = KmCssDefaultConstantsIF.button_normal;
    private static final String FLAVOR_POSITIVE   = KmCssDefaultConstantsIF.button_positive;
    private static final String FLAVOR_NEGATIVE   = KmCssDefaultConstantsIF.button_negative;
    private static final String FLAVOR_WARN       = KmCssDefaultConstantsIF.button_warn;
    private static final String FLAVOR_DISABLED   = KmCssDefaultConstantsIF.button_disabled;
    private static final String FLAVOR_ICON       = KmCssDefaultConstantsIF.button_icon;
    private static final String FLAVOR_SMALL_ICON = KmCssDefaultConstantsIF.button_smallIcon;

    //##################################################
    //# variables
    //##################################################

    /**
     * The text to display inside the label.
     */
    private ScLocalRenderer _text;

    /**
     * The control to display before (to the left of) the text.
     * This is typically an icon.
     */
    private ScControl _preControl;

    /**
     * The control to display after (to the right of) the text.
     * This is typically an icon.
     */
    private ScControl _postControl;

    /**
     * The general 'flavor' of the button.
     * This corresponds to various style decorations defined in the css.
     * E.g.: positive, negative, etc....
     */
    private ScLocalString _flavor;

    /**
     * If true, the button is expected to act as the primary/default
     * button within a form.  That is, it indicates the action that will
     * be taken if the user simply presses enter on a text field.
     */
    private ScLocalBoolean _primary;

    /**
     * If disabled, the button cannot be clicked by the user.
     */
    private ScLocalBoolean _enabled;

    /**
     * If true, add the autofocus attribute to the button.
     * This is normally false.  In most cases the application automatically
     * assigns focus to the first applicable element.
     */
    private ScLocalBoolean _autoFocus;

    /**
     * If set, this indicates that the browser client should automatically
     * run the onclick action every x minutes.
     */
    private ScLocalInteger _autoRunSeconds;

    //##################################################
    //# constructor
    //##################################################

    public ScButton()
    {
        _text = new ScLocalRenderer();
        _flavor = new ScLocalString(FLAVOR_NORMAL);
        _primary = new ScLocalBoolean(false);

        _enabled = new ScLocalBoolean(true);
        _autoFocus = new ScLocalBoolean(false);
        _autoRunSeconds = new ScLocalInteger();
    }

    //##################################################
    //# flavor
    //##################################################

    public String getFlavor()
    {
        return _flavor.getValue();
    }

    private void setFlavor(String e)
    {
        _flavor.setValue(e);
    }

    public void setFlavorNormal()
    {
        setFlavor(FLAVOR_NORMAL);
    }

    public void setFlavorPositive()
    {
        setFlavor(FLAVOR_POSITIVE);
    }

    public void setFlavorNegative()
    {
        setFlavor(FLAVOR_NEGATIVE);
    }

    public void setFlavorDisabled()
    {
        setFlavor(FLAVOR_DISABLED);
    }

    public void setFlavorWarn()
    {
        setFlavor(FLAVOR_WARN);
    }

    public void setFlavorIcon()
    {
        setFlavor(FLAVOR_ICON);
    }

    public void setFlavorSmallIcon()
    {
        setFlavor(FLAVOR_SMALL_ICON);
    }

    public boolean hasFlavor(String e)
    {
        return Kmu.isEqual(getFlavor(), e);
    }

    //##################################################
    //# disabled
    //##################################################

    public void setEnabled(boolean e)
    {
        _enabled.setValue(e);
    }

    public void setEnabled(KmSimpleResult allowed)
    {
        if ( allowed.isOk() )
            enable();
        else
            disable(allowed.getError());
    }

    public void enable()
    {
        setEnabled(true);
    }

    public void disable(String msg)
    {
        setEnabled(false);
        setHelp(msg);
    }

    public boolean isEnabled()
    {
        return _enabled.getValue();
    }

    public boolean isDisabled()
    {
        return !isEnabled();
    }

    //##################################################
    //# primary
    //##################################################

    public boolean getPrimary()
    {
        return _primary.getValue();
    }

    public void setPrimary(boolean b)
    {
        _primary.setValue(b);
    }

    public void setPrimary()
    {
        setPrimary(true);
    }

    public boolean isPrimary()
    {
        return getPrimary();
    }

    //##################################################
    //# text
    //##################################################

    public ScRenderer getText()
    {
        return _text.getValue();
    }

    public void setText(CharSequence e)
    {
        _text.setValue(e);
    }

    @SuppressWarnings("rawtypes")
    public void setText(KmAdaptorIF e)
    {
        _text.setAdaptor(e);
    }

    @SuppressWarnings("rawtypes")
    public void setText(KmMetaAttribute e)
    {
        _text.setAttribute(e);
    }

    public boolean hasText()
    {
        return _text.hasValue();
    }

    //##################################################
    //# controls
    //##################################################

    public void clearControls()
    {
        _preControl = null;
        _postControl = null;
    }

    //==================================================
    //= controls :: icons
    //==================================================

    public ScIcon setIcon()
    {
        return setPreIcon();
    }

    public ScIcon setPreIcon()
    {
        ScIcon e;
        e = newIcon();
        _preControl = e;
        return e;
    }

    public ScIcon setPostIcon()
    {
        ScIcon e;
        e = newIcon();
        _postControl = e;
        return e;
    }

    public void clearIcons()
    {
        _preControl = null;
        _postControl = null;
    }

    private ScIcon newIcon()
    {
        ScIcon e;
        e = new ScIcon();
        e.sizeButton();
        return e;
    }

    //==================================================
    //= controls :: images
    //==================================================

    public ScImage installPreImage(String url)
    {
        ScImage e;
        e = newImage(url);
        _preControl = e;
        return e;
    }

    public ScImage installPostImage(String url)
    {
        ScImage e;
        e = newImage(url);
        _postControl = e;
        return e;
    }

    private ScImage newImage(String url)
    {
        ScImage e;
        e = new ScImage();
        e.setSource(url);
        e.setAlt("");
        e.css().buttonImage();
        return e;
    }

    //##################################################
    //# auto focus
    //##################################################

    public boolean getAutoFocus()
    {
        return _autoFocus.isTrue();
    }

    public void setAutoFocus(boolean e)
    {
        _autoFocus.setValue(e);
    }

    public void setAutoFocus()
    {
        setAutoFocus(true);
    }

    //##################################################
    //# auto run
    //##################################################

    public Integer getAutoRunSeconds()
    {
        return _autoRunSeconds.getValue();
    }

    public void setAutoRunSeconds(Integer e)
    {
        _autoRunSeconds.setValue(e);
    }

    public void clearAutoRunSeconds()
    {
        _autoRunSeconds.clearValue();
    }

    public boolean hasAutoRunSeconds()
    {
        return _autoRunSeconds.hasValue();
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public void applyNormalFlavor()
    {
        setPrimary(false);
        setFlavorNormal();
        clearControls();
    }

    public void applyPrimaryFlavor()
    {
        setPrimary();
        setFlavorPositive();
        clearControls();
        setIcon().nameDone().styleLight();
    }

    public void applyPositiveFlavor()
    {
        setFlavorPositive();
        clearControls();
        setIcon().nameDone().styleLight();
    }

    public void applyNegativeFlavor()
    {
        setFlavorNegative();
        clearControls();
        setIcon().nameClose().styleLight();
    }

    public void applyDeleteFlavor()
    {
        setFlavorWarn();
        clearControls();
        setIcon().nameRemoveCircleOutline().styleLight();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.open("button");
        renderAttributesOn(out);
        out.close();

        renderPreControlOn(out);
        renderTextOn(out);
        renderPostControlOn(out);
        renderHelpOn(out);

        out.end("button");
    }

    @Override
    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        super.renderAttributesOn(out);

        out.printAttribute("type", getButtonType());
        out.printAttribute("onclick", formatOnClick());

        if ( getAutoFocus() )
            out.printAttribute("autofocus", "autofocus");

        // Currently shows a message instead.
        //        if ( isDisabled() )
        //            out.printAttribute("disabled", "disabled");

        if ( hasAutoRunSeconds() )
            out.printDataAttribute("autoRunSeconds", getAutoRunSeconds() + "");
    }

    @Override
    protected KmCssDefaultBuilder formatCss()
    {
        KmCssDefaultBuilder css;
        css = super.formatCss();
        css.button();

        if ( isEnabled() )
            css.apply(getFlavor());
        else
            css.apply(FLAVOR_DISABLED);

        if ( isPrimary() )
            css.button_primary();

        if ( hasAutoRunSeconds() )
            css.autoRun();

        return css;
    }

    private void renderHelpOn(KmHtmlBuilder out)
    {
        Integer x = 0;
        Integer y = null;
        Integer z = null;
        out.printHelpImage(getHelp(), x, y, z);
    }

    private void renderPreControlOn(KmHtmlBuilder out)
    {
        out.render(_preControl);
    }

    private void renderPostControlOn(KmHtmlBuilder out)
    {
        out.render(_postControl);
    }

    private void renderTextOn(KmHtmlBuilder out)
    {
        if ( !hasText() )
            return;

        out.beginSpan();
        getText().renderOn(out, this, getModel());
        out.endSpan();
    }

    protected abstract String getButtonType();

    //##################################################
    //# format on click
    //##################################################

    private String formatOnClick()
    {
        return isEnabled()
            ? formatEnabledOnClick()
            : formatDisabledOnClick();
    }

    protected abstract String formatEnabledOnClick();

    private String formatDisabledOnClick()
    {
        String msg = hasHelp()
            ? getHelp()
            : "This action is currently disabled.";

        ScShowNoticeScript s;
        s = new ScShowNoticeScript();
        s.setTitle("Disabled");
        s.setTextMessage(msg);
        return s.formatScript();
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxEnable()
    {
        ajaxEnable(getFlavor());
    }

    public void ajaxEnable(String flavor)
    {
        getRootScript().run("Kmu.enableButton(%s,%s);", json(getJquerySelector()), json(flavor));
    }

    public void ajaxDisable()
    {
        getRootScript().run("Kmu.disableButton(%s);", json(getJquerySelector()));
    }

    //##################################################
    //# chaining
    //##################################################

    public ScButton positive()
    {
        setFlavorPositive();
        return this;
    }

    public ScButton negative()
    {
        setFlavorNegative();
        return this;
    }

    public ScButton icon()
    {
        setFlavorIcon();
        return this;
    }

    public ScButton primary()
    {
        setPrimary();
        return this;
    }

    //##################################################
    //# style
    //##################################################

    public ScIcon styleAdd()
    {
        setFlavorIcon();
        setHoverText("Add");
        return setIcon().nameAddCircleOutline();
    }

    public ScIcon styleEdit()
    {
        setFlavorIcon();
        setHoverText("Edit");
        return setIcon().nameEdit();
    }

    public ScIcon styleDelete()
    {
        setFlavorIcon();
        setHoverText("Delete?");
        return setIcon().nameDelete();
    }

    public ScIcon styleRefresh()
    {
        setFlavorIcon();
        setHoverText("Refresh");
        return setIcon().nameRefresh();
    }

}
