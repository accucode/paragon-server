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

package com.kodemore.servlet.field;

import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;

public class ScListField<T>
    extends ScAbstractSelectField<T>
{
    //##################################################
    //# constants
    //##################################################

    /**
     * HTML lists and dropdowns are both implemented using the
     * SELECT element.  The dom determines which style to use
     * based on the element's SIZE attribute.  If the SIZE is 1,
     * it displays a dropdown, if the SIZE is >1 it displays a
     * list.
     *
     * For consistency, and cross-browser compatibility, we always
     * set the size to 2, which ensures the element is displayed as
     * a list.
     *
     * To control the visual height of the list, you should use
     * the css/style.
     */
    private static final int SELECT_SIZE    = 2;

    /**
     * This is the default height (px) for list fields.
     */
    private static final int DEFAULT_HEIGHT = 100;

    //##################################################
    //# static :: layout enum
    //##################################################

    /**
     * The various layout options.
     */
    private static enum Layout
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
        flexFiller;
    }

    //##################################################
    //# variables
    //##################################################

    private Layout  _layout;
    private Integer _width;
    private Integer _height;

    //##################################################
    //# constructor
    //##################################################

    public ScListField()
    {
        layoutInline();
    }

    //##################################################
    //# layout
    //##################################################

    public void layoutInline()
    {
        layoutInline(null, DEFAULT_HEIGHT);
    }

    public void layoutInline(Integer width, Integer height)
    {
        _layout = Layout.inline;
        _width = width;
        _height = height;
    }

    public void layoutBlock()
    {
        layoutBlock(DEFAULT_HEIGHT);
    }

    public void layoutBlock(int height)
    {
        _layout = Layout.block;
        _width = null;
        _height = height;
    }

    public void layoutFlexFiller()
    {
        layoutFlexFiller(DEFAULT_HEIGHT);
    }

    public void layoutFlexFiller(int height)
    {
        _layout = Layout.flexFiller;
        _width = null;
        _height = height;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected int getSelectSize()
    {
        return SELECT_SIZE;
    }

    @Override
    protected void applyLayoutTo(KmCssDefaultBuilder css, KmStyleBuilder style)
    {
        css.listField();
        style.width(_width);
        style.height(_height);

        switch ( _layout )
        {
            case inline:
                css.flexInlineRow();
                break;

            case block:
                css.flexRow();
                break;

            case flexFiller:
                css.flexInlineRow();
                css.flexChildFiller();
                break;
        }
    }
}
