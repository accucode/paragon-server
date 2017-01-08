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

package com.kodemore.html;

import java.util.Iterator;
import java.util.List;

import com.kodemore.collection.KmList;
import com.kodemore.string.KmStringAssociation;
import com.kodemore.utility.KmConstantsIF;
import com.kodemore.utility.KmValueHolder;
import com.kodemore.utility.KmValueHolderIF;
import com.kodemore.utility.Kmu;

/**
 * I am used to compose inline html styles.  As in the quoted value...
 *      <div style="...">
 */
public class KmStyleBuilder
{
    //##################################################
    //# constants
    //##################################################

    private static final int        DEFAULT_GAP = 10;

    //##################################################
    //# variables
    //##################################################

    private KmValueHolderIF<String> _holder;

    //##################################################
    //# constructor
    //##################################################

    public KmStyleBuilder()
    {
        _holder = new KmValueHolder<>();
    }

    public KmStyleBuilder(KmValueHolderIF<String> holder)
    {
        _holder = holder;
    }

    //##################################################
    //# accessing
    //##################################################

    public String getValue()
    {
        return _holder.getValue();
    }

    public void setValue(String e)
    {
        _holder.setValue(e);
    }

    public boolean hasValue()
    {
        return Kmu.hasValue(getValue());
    }

    public void clearValue()
    {
        setValue(null);
    }

    /**
     * Return a copy.  The copy will have the same value as the
     * original, but will be detached from the original value HOLDER.
     */
    public KmStyleBuilder getCopy()
    {
        KmStyleBuilder e;
        e = new KmStyleBuilder();
        e.setValue(getValue());
        return e;
    }

    //##################################################
    //# values
    //##################################################

    public void setValue(String attr, String value)
    {
        removeValue(attr);
        addValue(attr, value);
    }

    public void setValue(String attr, Integer value, String unit)
    {
        removeValue(attr);
        addValue(attr, value, unit);
    }

    public void setValue(String attr, Double value, String unit)
    {
        removeValue(attr);
        addValue(attr, value, unit);
    }

    //==================================================
    //= values :: add
    //==================================================

    public void addValue(String attr)
    {
        setValue(join(attr));
    }

    public void addValue(String attr, String value)
    {
        setValue(join(attr, value));
    }

    public void addValue(String attr, Integer value)
    {
        setValue(join(attr, value));
    }

    public void addValue(String attr, Integer value, String unit)
    {
        setValue(join(attr, value, unit));
    }

    public void addValue(String attr, Double value, String unit)
    {
        setValue(join(attr, value, unit));
    }

    public void addValue(KmStringAssociation e)
    {
        if ( e == null )
            return;

        addValue(e.getKey(), e.getValue());
    }

    public void addValues(List<KmStringAssociation> v)
    {
        if ( v == null )
            return;

        for ( KmStringAssociation e : v )
            addValue(e);
    }

    //==================================================
    //= values :: remove
    //==================================================

    /**
     * Remove all attributes with the specified key.
     */
    public void removeValue(String attr)
    {
        boolean found = false;
        KmList<KmStringAssociation> v = getAssociations();

        Iterator<KmStringAssociation> i = v.iterator();
        while ( i.hasNext() )
            if ( i.next().hasKey(attr) )
            {
                i.remove();
                found = true;
            }

        if ( found )
        {
            clearValue();
            addValues(v);
        }
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public KmList<KmStringAssociation> getAssociations()
    {
        KmList<KmStringAssociation> v = new KmList<>();

        KmList<String> tokens = Kmu.tokenize(getValue(), KmConstantsIF.CHAR_SEMICOLON);
        for ( String token : tokens )
        {
            String s = token.trim();
            if ( s.isEmpty() )
                continue;

            KmStringAssociation a;
            a = new KmStringAssociation();

            int i = token.indexOf(KmConstantsIF.CHAR_COLON);
            if ( i < 0 )
            {
                a.setKey(s);
                v.add(a);
                continue;
            }

            String key = s.substring(0, i).trim();
            String value = s.substring(i + 1).trim();

            a.setKey(key);
            a.setValue(value);
            v.add(a);
        }

        return v;
    }

    public boolean hasAssociation(String key, String value)
    {
        return getAssociations().containsIf(e -> e.hasKeyValue(key, value));
    }

    //##################################################
    //# formatting
    //##################################################

    /**
     * Format a string suitable for output to an html stream.
     *
     * I currently just return my value.  But use of this
     * method will insulate clients from changes to my internal
     * implementation.
     */
    public String formatHtmlStyle()
    {
        return getValue();
    }

    //##################################################
    //# position
    //##################################################

    public KmStyleBuilder relative()
    {
        setValue("position", "relative");
        return this;
    }

    public KmStyleBuilder absolute()
    {
        setValue("position", "absolute");
        return this;
    }

    public KmStyleBuilder fill()
    {
        absolute();

        left(0);
        right(0);
        widthAuto();

        top(0);
        bottom(0);
        heightAuto();

        return this;
    }

    //##################################################
    //# left
    //##################################################

    public KmStyleBuilder left(int px)
    {
        setValue("left", px, "px");
        return this;
    }

    public KmStyleBuilder leftPercent(int pct)
    {
        setValue("left", pct, "%");
        return this;
    }

    public KmStyleBuilder leftAuto()
    {
        setValue("left", "auto");
        return this;
    }

    public KmStyleBuilder removeLeft()
    {
        removeValue("left");
        return this;
    }

    //##################################################
    //# right
    //##################################################

    public KmStyleBuilder right(int px)
    {
        addValue("right", px, "px");
        return this;
    }

    public KmStyleBuilder rightPercent(int pct)
    {
        addValue("right", pct, "%");
        return this;
    }

    public KmStyleBuilder rightAuto()
    {
        addValue("right", "auto");
        return this;
    }

    public KmStyleBuilder removeRight()
    {
        removeValue("right");
        return this;
    }

    //##################################################
    //# top
    //##################################################

    public KmStyleBuilder top(int px)
    {
        addValue("top", px, "px");
        return this;
    }

    public KmStyleBuilder topPercent(int pct)
    {
        addValue("top", pct, "%");
        return this;
    }

    public KmStyleBuilder topAuto()
    {
        addValue("top", "auto");
        return this;
    }

    //##################################################
    //# bottom
    //##################################################

    public KmStyleBuilder bottom(int px)
    {
        addValue("bottom", px, "px");
        return this;
    }

    public KmStyleBuilder bottomPercent(int pct)
    {
        addValue("bottom", pct, "%");
        return this;
    }

    public KmStyleBuilder bottomAuto()
    {
        addValue("bottom", "auto");
        return this;
    }

    //##################################################
    //# float
    //##################################################

    public KmStyleBuilder floatLeft()
    {
        addValue("float", "left");
        return this;
    }

    public KmStyleBuilder floatRight()
    {
        addValue("float", "right");
        return this;
    }

    //##################################################
    //# overflow
    //##################################################

    public KmStyleBuilder auto()
    {
        addValue("overflow", "auto");

        return this;
    }

    public KmStyleBuilder scroll()
    {
        addValue("overflow", "scroll");

        return this;
    }

    //##################################################
    //# width
    //##################################################

    public KmStyleBuilder width(Integer px)
    {
        if ( px != null )
            setValue("width", px, "px");

        return this;
    }

    public KmStyleBuilder widthPercent(Integer e)
    {
        if ( e != null )
            setValue("width", e, "%");

        return this;
    }

    public KmStyleBuilder widthFull()
    {
        setValue("width", 100, "%");

        return this;
    }

    public KmStyleBuilder widthAuto()
    {
        setValue("width", "auto");
        return this;
    }

    public KmStyleBuilder removeWidth()
    {
        removeValue("width");
        return this;
    }

    //==================================================
    //= width :: min/max
    //==================================================

    public KmStyleBuilder minWidth(Integer px)
    {
        if ( px != null )
            addValue("min-width", px, "px");

        return this;
    }

    public KmStyleBuilder maxWidth(Integer px)
    {
        if ( px != null )
            addValue("max-width", px, "px");

        return this;
    }

    public KmStyleBuilder maxWidthPercent(Integer percentage)
    {
        if ( percentage != null )
            addValue("max-width", percentage, "%");

        return this;
    }

    //##################################################
    //# height
    //##################################################

    public KmStyleBuilder height(Integer px)
    {
        if ( px != null )
            setValue("height", px, "px");

        return this;
    }

    public KmStyleBuilder heightPercent(Integer e)
    {
        if ( e != null )
            setValue("height", e, "%");

        return this;
    }

    public KmStyleBuilder heightAuto()
    {
        setValue("height", "auto");
        return this;
    }

    public KmStyleBuilder removeHeight()
    {
        removeValue("height");
        return this;
    }

    //##################################################
    //# size
    //##################################################

    public KmStyleBuilder size(Integer px)
    {
        width(px);
        height(px);
        return this;
    }

    //##################################################
    //# margin
    //##################################################

    public KmStyleBuilder margin()
    {
        return margin(DEFAULT_GAP);
    }

    public KmStyleBuilder margin(Integer e)
    {
        if ( e != null )
            addValue("margin", e, "px");

        return this;
    }

    public KmStyleBuilder marginTop()
    {
        return marginTop(DEFAULT_GAP);
    }

    public KmStyleBuilder marginTop(Integer e)
    {
        if ( e != null )
            addValue("margin-top", e, "px");

        return this;
    }

    public KmStyleBuilder marginRight(Integer e)
    {
        if ( e != null )
            addValue("margin-right", e, "px");

        return this;
    }

    public KmStyleBuilder marginBottom(Integer e)
    {
        if ( e != null )
            addValue("margin-bottom", e, "px");

        return this;
    }

    public KmStyleBuilder marginLeft(Integer e)
    {
        if ( e != null )
            addValue("margin-left", e, "px");

        return this;
    }

    public KmStyleBuilder marginCenter()
    {
        addValue("margin-left", "auto");
        addValue("margin-right", "auto");

        return this;
    }

    //##################################################
    //# padding
    //##################################################

    public KmStyleBuilder pad()
    {
        return pad(DEFAULT_GAP);
    }

    public KmStyleBuilder pad(Integer e)
    {
        if ( e != null )
            addValue("padding", e, "px");

        return this;
    }

    public KmStyleBuilder padTop()
    {
        return padTop(DEFAULT_GAP);
    }

    public KmStyleBuilder padTop(Integer e)
    {
        if ( e != null )
            addValue("padding-top", e, "px");

        return this;
    }

    public KmStyleBuilder padRight(Integer e)
    {
        if ( e != null )
            addValue("padding-right", e, "px");

        return this;
    }

    public KmStyleBuilder padBottom(Integer e)
    {
        if ( e != null )
            addValue("padding-bottom", e, "px");

        return this;
    }

    public KmStyleBuilder padLeft(Integer e)
    {
        if ( e != null )
            addValue("padding-left", e, "px");

        return this;
    }

    //##################################################
    //# text align
    //##################################################

    public KmStyleBuilder alignLeft()
    {
        addValue("text-align", "left");
        return this;
    }

    public KmStyleBuilder alignRight()
    {
        addValue("text-align", "right");
        return this;
    }

    public KmStyleBuilder alignCenter()
    {
        addValue("text-align", "center");
        return this;
    }

    //##################################################
    //# font
    //##################################################

    public KmStyleBuilder bold()
    {
        setValue("font-weight", "bold");
        return this;
    }

    public KmStyleBuilder italic()
    {
        setValue("font-style", "italic");
        return this;
    }

    public KmStyleBuilder strike()
    {
        setValue("text-decoration", "line-through");
        return this;
    }

    public KmStyleBuilder sans()
    {
        setValue("font-family", "sans-serif");
        return this;
    }

    public KmStyleBuilder serif()
    {
        setValue("font-family", "serif");
        return this;
    }

    public KmStyleBuilder mono()
    {
        setValue("font-family", "monospace");
        return this;
    }

    public KmStyleBuilder fontPx(int px)
    {
        addValue("font-size", px, "px");
        return this;
    }

    /**
     * Set the font size as CSS3 Root Em rather than pixels.
     * This is actually the preferred method of setting font sizes.
     * If the sytle sheets are configured correctly, you should be
     * able to use 1.0 as 10px; 1.6 as 16px.
     */
    public KmStyleBuilder fontRem(double rem)
    {
        setValue("font-size", rem, "rem");
        return this;
    }

    public KmStyleBuilder fontPxRem(int px)
    {
        return fontRem(px / 10.0);
    }

    //##################################################
    //# display (show/hide)
    //##################################################

    public KmStyleBuilder show(boolean e)
    {
        return e
            ? show()
            : hide();
    }

    public KmStyleBuilder show()
    {
        removeValue("display");
        return this;
    }

    public KmStyleBuilder hide()
    {
        setValue("display", "none");
        return this;
    }

    public boolean hasHide()
    {
        return hasAssociation("display", "none");
    }

    //##################################################
    //# visibility
    //##################################################

    public KmStyleBuilder visibility(boolean show)
    {
        return show
            ? removeVisibility()
            : visibilityHidden();
    }

    public KmStyleBuilder visibilityHidden()
    {
        setValue("visibility", "hidden");
        return this;
    }

    public KmStyleBuilder removeVisibility()
    {
        removeValue("visibility");
        return this;
    }

    //##################################################
    //# border
    //##################################################

    public KmStyleBuilder noBorder()
    {
        setValue("border", "none");
        return this;
    }

    //##################################################
    //# overflow
    //##################################################

    public KmStyleBuilder overflowAuto()
    {
        setValue("overflow", "auto");
        return this;
    }

    public KmStyleBuilder overflowHidden()
    {
        setValue("overflow", "hidden");
        return this;
    }

    public KmStyleBuilder overflowYAuto()
    {
        setValue("overflow-y", "auto");
        return this;
    }

    //##################################################
    //# gradient (html5)
    //##################################################

    public KmStyleBuilder gradientDown(String... colors)
    {
        return gradient("bottom", colors);
    }

    public KmStyleBuilder gradientRight(String... colors)
    {
        return gradient("right", colors);
    }

    /**
     * Add an html5 style gradient.
     * background: linear-gradient(to right, white, yellow, blue, red, green, black);
     */
    public KmStyleBuilder gradient(String to, String... colorArr)
    {
        if ( colorArr.length == 0 )
            return this;

        String colors = Kmu.join(colorArr);
        String value = Kmu.format("linear-gradient(to %s, %s)", to, colors);
        setValue("background-image", value);

        return this;
    }

    //##################################################
    //# miscellaneous
    //##################################################

    public void color(String value)
    {
        setValue("color", value);
    }

    public void backgroundColor(String value)
    {
        setValue("background-color", value);
    }

    public void zIndex(int z)
    {
        setValue("z-index", z, null);
    }

    //##################################################
    //# support
    //##################################################

    private String join(String attr)
    {
        return Kmu.joinHtmlStyle(getValue(), attr);
    }

    private String join(String attr, String value)
    {
        return Kmu.joinHtmlStyle(getValue(), attr, value);
    }

    private String join(String attr, Integer value)
    {
        return Kmu.joinHtmlStyle(getValue(), attr, value);
    }

    private String join(String attr, Integer value, String unit)
    {
        return Kmu.joinHtmlStyle(getValue(), attr, value, unit);
    }

    private String join(String attr, Double value, String unit)
    {
        return Kmu.joinHtmlStyle(getValue(), attr, value, unit);
    }

    //##################################################
    //# display
    //##################################################

    /**
     * This method should return getValue() and may be safely
     * used in place of getValue().
     */
    @Override
    public final String toString()
    {
        return getValue();
    }

}
