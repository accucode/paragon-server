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

public class ScDropdownField<T>
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

    private Layout _layout;

    //##################################################
    //# constructor
    //##################################################

    public ScDropdownField()
    {
        layoutInline();
    }

    //##################################################
    //# layout
    //##################################################

    public void layoutInline()
    {
        _layout = Layout.inline;
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
        css.dropdownField();

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
