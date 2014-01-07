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

package com.kodemore.servlet.control;

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.meta.KmMetaAttribute;
import com.kodemore.servlet.utility.ScUrls;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalRenderer;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.Kmu;

public abstract class ScButton
    extends ScElement
{
    //##################################################
    //# constants
    //##################################################

    private static final String PREFIX          = KmCssDefaultConstantsIF.button_prefix;

    private static final String PART            = KmCssDefaultConstantsIF.button_part_element;

    private static final String FLAVOR_POSITIVE = KmCssDefaultConstantsIF.button_flavor_positive;
    private static final String FLAVOR_NEGATIVE = KmCssDefaultConstantsIF.button_flavor_negative;
    private static final String FLAVOR_DEFAULT  = KmCssDefaultConstantsIF.button_flavor_default;
    private static final String FLAVOR_DISABLED = KmCssDefaultConstantsIF.button_flavor_disabled;

    //##################################################
    //# variables
    //##################################################

    private ScLocalString       _htmlName;

    private ScLocalRenderer     _text;
    private ScLocalString       _flavor;
    private ScLocalBoolean      _primary;

    private ScLocalString       _preImage;
    private ScLocalString       _postImage;

    //##################################################
    //# initialize
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        css().noWrap();

        _htmlName = new ScLocalString(getHtmlId());

        _text = new ScLocalRenderer();
        _flavor = new ScLocalString(FLAVOR_DEFAULT);
        _primary = new ScLocalBoolean(false);

        _preImage = new ScLocalString();
        _postImage = new ScLocalString();
    }

    //##################################################
    //# html name
    //##################################################

    public String getHtmlName()
    {
        return _htmlName.getValue();
    }

    public void setHtmlName(String e)
    {
        _htmlName.setValue(e);
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

    public void setFlavorDefault()
    {
        setFlavor(FLAVOR_DEFAULT);
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

    public boolean hasFlavor(String e)
    {
        return Kmu.isEqual(getFlavor(), e);
    }

    //##################################################
    //# disabled
    //##################################################

    public void setDisabled()
    {
        setFlavorDisabled();
    }

    public boolean isDisabled()
    {
        return hasFlavor(FLAVOR_DISABLED);
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

    public void setText(String e)
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
    //# abstract accessing
    //##################################################

    public void applyDefaultFlavor()
    {
        setPrimary(false);
        setFlavorDefault();

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

    /**
     * Buttons are always wrapped in a div.
     * The outer div is the usual target for animations and 
     * and extra styles like layout margins.  The reason for 
     * this is that the button's css style animates the margin
     * as part of the button's custom look-and-feel.  If we
     * don't wrap the button in a div, then the layouts get
     * corrupted when attempting to use margins to add spacing
     * between multiple buttons (or other elements).
     */
    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.open("button");
        renderAttributesOn(out);
        out.close();

        renderPreImage(out);
        renderText(out);
        renderPostImage(out);

        out.end("button");
    }

    @Override
    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        super.renderAttributesOn(out);

        out.printAttribute("name", getHtmlName());
        out.printAttribute("type", formatHtmlType());

        if ( isDisabled() )
            out.printAttribute("disabled", "disabled");

        out.printAttribute("onclick", formatOnClick());
    }

    @Override
    protected KmCssDefaultBuilder formatCss()
    {
        KmCssDefaultBuilder out;
        out = super.formatCss();
        out.button();
        out.apply(PREFIX, PART, getFlavor());

        if ( isPrimary() )
            out.buttonPrimary();

        return out;
    }

    private void renderPreImage(KmHtmlBuilder out)
    {
        if ( !hasPreImage() )
            return;

        out.open("img");
        out.printAttribute("src", getPreImage());
        out.close();
        out.end("img");
    }

    private void renderPostImage(KmHtmlBuilder out)
    {
        if ( !hasPostImage() )
            return;

        out.open("img");
        out.printAttribute("src", getPostImage());
        out.close();
        out.end("img");
    }

    private void renderText(KmHtmlBuilder out)
    {
        if ( hasText() )
            getText().renderOn(out, this);
    }

    protected abstract String formatHtmlType();

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

}
