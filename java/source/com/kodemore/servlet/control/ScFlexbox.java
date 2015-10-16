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

/**
 * I use the flexbox layout to arrange items in a row (or column).  I am really just a div
 * with some convenience methods.  I don't attempt to directly support every option available
 * for flexbox's, just the common ones.  Additional convenience methods may be added as needed.
 */
public class ScFlexbox
    extends ScDiv
{
    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        beBlock();

        /*
         * Defaults, don't need to be set.
         * beRow();
         * alignLeft();
         * crossAlignStretch();
         */
    }

    //##################################################
    //# block / inline
    //##################################################

    public void beBlock()
    {
        css().remove().flexInline();
        css().flex();
    }

    public void beInline()
    {
        css().remove().flex();
        css().flexInline();
    }

    //##################################################
    //# row / column
    //##################################################

    public void beRow()
    {
        css().remove().flexColumn();
        css().flexRow();
    }

    public void beColumn()
    {
        css().remove().flexRow();
        css().flexColumn();
    }

    //##################################################
    //# align
    //##################################################

    public void alignStart()
    {
        css().flexAlignStart();
    }

    public void alignEnd()
    {
        css().flexAlignEnd();
    }

    public void alignCenter()
    {
        css().flexAlignCenter();
    }

    public void alignSpaced()
    {
        css().flexAlignSpaced();
    }

    public void alignSpacedAround()
    {
        css().flexAlignSpacedAround();
    }

    //##################################################
    //# cross align
    //##################################################

    public void crossAlignStretch()
    {
        css().flexCrossAlignStretch();
    }

    public void crossAlignStart()
    {
        css().flexCrossAlignStart();
    }

    public void crossAlignEnd()
    {
        css().flexCrossAlignEnd();
    }

    public void crossAlignCenter()
    {
        css().flexCrossAlignCenter();
    }

    public void crossAlignBaseline()
    {
        css().flexCrossAlignBaseline();
    }

    //##################################################
    //# filler
    //##################################################

    public void addFiller(int n)
    {
        for ( int i = 0; i < n; i++ )
            addFiller();
    }

    public ScDiv addFiller()
    {
        ScDiv e;
        e = addDiv();
        e.css().flexFiller();
        return e;
    }

    public ScDiv addSpacer(int px)
    {
        ScDiv e;
        e = addDiv();
        e.css().flexStatic();
        e.style().size(px);
        return e;
    }

    //##################################################
    //# wrap
    //##################################################

    public void wrap()
    {
        css().flexWrap();
    }
}
