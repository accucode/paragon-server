/*
  Copyright (c) 2005-2011 www.kodemore.com

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

public class ScLayoutContainer
    extends ScChildContainer
{
    //##################################################
    //# variables
    //##################################################

    private ScLayoutIF _layout;

    //##################################################
    //# constructor
    //##################################################

    public ScLayoutContainer()
    {
        // none
    }

    //##################################################
    //# layout
    //##################################################

    public ScLayoutIF getLayout()
    {
        return _layout;
    }

    public void setLayout(ScLayoutIF e)
    {
        _layout = e;
    }

    public void clearLayout()
    {
        setLayout(null);
    }

    public boolean hasLayout()
    {
        return _layout != null;
    }

    //##################################################
    //# layout (convenience)
    //##################################################

    public ScColumnLayout useColumnLayout()
    {
        ScColumnLayout e = new ScColumnLayout();
        setLayout(e);
        return e;
    }

    public ScRowLayout useRowLayout()
    {
        ScRowLayout e = new ScRowLayout();
        setLayout(e);
        return e;
    }

    public ScBoxerLayout useBoxLayout()
    {
        ScBoxerLayout e = new ScBoxerLayout();
        setLayout(e);
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        if ( hasLayout() )
            renderWithLayout(out);
        else
            renderWithoutLayout(out);
    }

    private void renderWithLayout(KmHtmlBuilder out)
    {
        ScLayoutIF layout;
        layout = getLayout();
        layout.renderOpenOn(out);

        KmList<ScControl> v = getChildren();
        int n = v.size();
        for ( int i = 0; i < n; i++ )
            layout.renderChildOn(out, v.get(i), i, n);

        layout.renderCloseOn(out);
    }

    private void renderWithoutLayout(KmHtmlBuilder out)
    {
        for ( ScControl e : getChildren() )
            out.render(e);

    }
}
