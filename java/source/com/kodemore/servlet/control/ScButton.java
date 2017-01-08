/*
  Copyright (c) 2005-2016 www.kodemore.com

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
import com.kodemore.servlet.utility.ScUrlBridge;
import com.kodemore.servlet.utility.ScUrls;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalRenderer;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.KmCompressMemoryIF;
import com.kodemore.utility.Kmu;

public abstract class ScButton
    extends ScElement
{
    //##################################################
    //# constants
    //##################################################

    private static final String FLAVOR_NORMAL   = KmCssDefaultConstantsIF.button_normal;
    private static final String FLAVOR_POSITIVE = KmCssDefaultConstantsIF.button_positive;
    private static final String FLAVOR_NEGATIVE = KmCssDefaultConstantsIF.button_negative;
    private static final String FLAVOR_DELETE   = KmCssDefaultConstantsIF.button_delete;
    private static final String FLAVOR_DISABLED = KmCssDefaultConstantsIF.button_disabled;
    private static final String FLAVOR_ICON     = KmCssDefaultConstantsIF.button_icon;

    //##################################################
    //# variables
    //##################################################

    /**
     * The text to display inside the label.
     */
    private ScLocalRenderer     _text;

    /**
     * The icon to display before (to the left of) the text.
     */
    private ScLocalString       _preImage;

    /**
     * The icon to display before (to the right of) the text.
     */
    private ScLocalString       _postImage;

    /**
     * The general 'flavor' of the button.
     * This corresponds to various style decorations defined in the css.
     * E.g.: positive, negative, etc....
     */
    private ScLocalString       _flavor;

    /**
     * If true, the button is expected to act as the primary/default
     * button within a form.  That is, it indicates the action that will
     * be taken if the user simply presses enter on a text field.
     */
    private ScLocalBoolean      _primary;

    /**
     * If disabled, the button cannot be clicked by the user.
     */
    private ScLocalBoolean      _enabled;

    /**
     * If true, add the autofocus attribute to the button.
     * This is normally false.  In most cases the application automatically
     * assigns focus to the first applicable element.
     */
    private ScLocalBoolean      _autoFocus;

    //##################################################
    //# constructor
    //##################################################

    public ScButton()
    {
        _text = new ScLocalRenderer();
        _flavor = new ScLocalString(FLAVOR_NORMAL);
        _primary = new ScLocalBoolean(false);

        _preImage = new ScLocalString();
        _postImage = new ScLocalString();

        _enabled = new ScLocalBoolean(true);
        _autoFocus = new ScLocalBoolean(false);
    }

    //##################################################
    //# html name
    //##################################################

    public String getHtmlName()
    {
        return getKey();
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

    public void setFlavorDelete()
    {
        setFlavor(FLAVOR_DELETE);
    }

    public void setFlavorIcon()
    {
        setFlavor(FLAVOR_ICON);
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

    public void setEnabled()
    {
        setEnabled(true);
    }

    public void setDisabled()
    {
        setEnabled(false);
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
    //# pre image
    //##################################################

    public String getPreImage()
    {
        return _preImage.getValue();
    }

    public void setPreImage(String e)
    {
        _preImage.setValue(e);
    }

    public void clearPreImage()
    {
        _preImage.clearValue();
    }

    public boolean hasPreImage()
    {
        return _preImage.hasValue();
    }

    //##################################################
    //# post image
    //##################################################

    public String getPostImage()
    {
        return _postImage.getValue();
    }

    public void setPostImage(String e)
    {
        _postImage.setValue(e);
    }

    public void clearPostImage()
    {
        _postImage.clearValue();
    }

    public boolean hasPostImage()
    {
        return _postImage.hasValue();
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
    //# abstract accessing
    //##################################################

    public void applyNormalFlavor()
    {
        setPrimary(false);
        setFlavorNormal();

        clearPreImage();
        clearPostImage();
    }

    public void applyPrimaryFlavor()
    {
        setPrimary();
        setFlavorPositive();

        setPreImage(ScUrls.getPrimaryButtonImage());
        clearPostImage();
    }

    public void applyPositiveFlavor()
    {
        setFlavorPositive();

        setPreImage(ScUrls.getPositiveButtonImage());
        clearPostImage();
    }

    public void applyNegativeFlavor()
    {
        setFlavorNegative();
        setImage(ScUrls.getNegativeButtonImage());
    }

    public void applyDeleteFlavor()
    {
        setFlavorDelete();
        setImage(ScUrls.getNegativeButtonImage());
    }

    //##################################################
    //# convenience
    //##################################################

    public void setImage(String e)
    {
        setPreImage(e);
        clearPostImage();
    }

    public void clearImages()
    {
        clearPreImage();
        clearPostImage();
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

        renderPreImageOn(out);
        renderTextOn(out);
        renderPostImageOn(out);
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

        if ( isDisabled() )
            out.printAttribute("disabled", "disabled");
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

        return css;
    }

    private void renderHelpOn(KmHtmlBuilder out)
    {
        Integer x = 3;
        Integer y = null;
        Integer z = null;
        out.printHelpImage(getHelp(), x, y, z);
    }

    private void renderPreImageOn(KmHtmlBuilder out)
    {
        if ( hasPreImage() )
            out.printImage(getPreImage());
    }

    private void renderPostImageOn(KmHtmlBuilder out)
    {
        if ( hasPostImage() )
            out.printImage(getPostImage());
    }

    private void renderTextOn(KmHtmlBuilder out)
    {
        if ( hasText() )
            getText().renderOn(out, this, getModel());
    }

    protected abstract String getButtonType();

    protected abstract String formatOnClick();

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

    public void styleAdd()
    {
        String img = ScUrlBridge.getInstance().getAddButtonUrl();

        setImage(img);
        setHoverText("Add");
    }

    public void styleEdit()
    {
        String img = ScUrlBridge.getInstance().getEditButtonUrl();

        setImage(img);
        setHoverText("Edit");
    }

    public void styleRemove()
    {
        String img = ScUrlBridge.getInstance().getRemoveButtonUrl();

        setImage(img);
        setHoverText("Remove");
    }

    public void styleDelete()
    {
        String img = ScUrlBridge.getInstance().getDeleteButtonUrl();

        setImage(img);
        setHoverText("Delete");
    }

    public void styleRefresh()
    {
        String img = ScUrlBridge.getInstance().getRefreshButtonUrl();

        setImage(img);
        setHoverText("Refresh");
    }

    //##################################################
    //# compress
    //##################################################

    /**
     * @see KmCompressMemoryIF#compressMemory()
     */
    @Override
    public void compressMemory()
    {
        super.compressMemory();
        _text.compressMemory();
    }

}
