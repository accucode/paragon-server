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

package com.kodemore.servlet.field;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.json.KmJsonMap;
import com.kodemore.meta.KmMetaAssociation;
import com.kodemore.meta.KmMetaProperty;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.variable.ScLocalInteger;
import com.kodemore.utility.KmEnumIF;
import com.kodemore.utility.Kmu;

public abstract class ScDropdownField<T>
    extends ScAbstractSelectField<T>
{
    //##################################################
    //# constants
    //##################################################

    /**
     * This is the SIZE attribute used on the <select> element.
     * There is some debate whether we should use 0 or 1 for a dropdown.
     * Apparently the html5 spec recommends 0 as the default, but 1
     * seems to work more consistently for now.
     */
    private static final int SELECT_SIZE = 1;

    private static final Integer DEFAULT_INLINE_WIDTH = 200;

    //==================================================
    //= constants :: chosen
    //==================================================

    /**
     * If true, use the 'chosen' javascript library to convert the
     * html select field into a fancy version that supports client-side searching.
     *
     * Homepage
     * https://harvesthq.github.io/chosen
     *
     * Options
     * https://harvesthq.github.io/chosen/options.html
     */
    private static final boolean USES_CHOSEN = false;

    //##################################################
    //# static :: layout enum
    //##################################################

    /**
     * The various layout options.
     */
    private static enum Layout
        implements KmEnumIF
    {
        /**
         * Treat the control as an inline element, with a fixed width.
         * This is similar to the way a standalone input element works.
         * This is the default.
         */
        inline,

        /**
         * Treat the control as a block element (not inline).
         * The control will generally span an entire row, much like a div.
         */
        block,

        /**
         * For use inside a flexbox (row), the child will fill the available space.
         */
        flexFiller
    }

    //##################################################
    //# variables
    //##################################################

    private Layout         _layout;
    private ScLocalInteger _maximumInlineWidth;

    //##################################################
    //# constructor
    //##################################################

    public ScDropdownField()
    {
        _maximumInlineWidth = new ScLocalInteger();
        layoutInline();
    }

    //##################################################
    //# layout
    //##################################################

    public void layoutInline()
    {
        _layout = Layout.inline;
        _maximumInlineWidth.setValue(DEFAULT_INLINE_WIDTH);
    }

    public void layoutInline(int width)
    {
        _layout = Layout.inline;
        _maximumInlineWidth.setValue(width);
    }

    public void layoutBlock()
    {
        _layout = Layout.block;
    }

    public void layoutFlexFiller()
    {
        _layout = Layout.flexFiller;
    }

    //##################################################
    //# meta
    //##################################################

    @Override
    public void setMeta(KmMetaAssociation<?,T> x)
    {
        super.setMeta(x);

        if ( x.isRequired() )
            setNullSelectPrefix();
        else
            setNullNonePrefix();
    }

    @Override
    public void setMeta(KmMetaProperty<?,T> x)
    {
        super.setMeta(x);

        if ( x.isRequired() )
            setNullSelectPrefix();
        else
            setNullNonePrefix();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    public void renderControlOn(KmHtmlBuilder out)
    {
        super.renderControlOn(out);

        renderChosenOn(out);
    }

    /**
     * @see #USES_CHOSEN
     */
    private void renderChosenOn(KmHtmlBuilder out)
    {
        if ( !USES_CHOSEN )
            return;

        String ref = getListReference();

        KmJsonMap options;
        options = new KmJsonMap();
        // options.setInteger("disable_search_threshold", 10);
        // options.setBoolean("search_contains", false);
        // options.setInteger("width", width);

        ScBlockScript ajax;
        ajax = out.getPostRender();
        ajax.run("%s.chosen(%s);", ref, options);
        ajax.run("%s.chosen().change();", ref);
    }

    @Override
    protected int getSelectSize()
    {
        return SELECT_SIZE;
    }

    @Override
    protected void applyWrapperLayoutTo(KmCssDefaultBuilder css, KmStyleBuilder style)
    {
        css.dropdownField();

        switch ( _layout )
        {
            case inline:
                css.dropdownFieldInline();
                break;

            case block:
                css.dropdownFieldBlock();
                break;

            case flexFiller:
                css.dropdownFieldFlexFiller();
                break;
        }
    }

    @Override
    protected KmStyleBuilder formatSelectStyle()
    {
        switch ( _layout )
        {
            case block:
            case flexFiller:
                return null;

            case inline:
                if ( !_maximumInlineWidth.hasValue() )
                    return null;

                KmStyleBuilder style;
                style = new KmStyleBuilder();
                style.maxWidth(_maximumInlineWidth.getValue());
                return style;
        }
        throw Kmu.newEnumError(_layout);
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    protected void _postAjaxUpdate()
    {
        if ( USES_CHOSEN )
            getData().ajax().run("%s.trigger('chosen:updated');", getListReference());
    }

}
