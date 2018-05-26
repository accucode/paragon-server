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

package com.kodemore.servlet.control.layout;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldset;

public class ScLayoutFieldset2Renderer
    extends ScLayoutRenderer
{
    //##################################################
    //# style
    //##################################################

    @Override
    public void applyCss(KmCssDefaultBuilder css)
    {
        css.gap20();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    public void renderChildrenOn(KmHtmlBuilder out, ScLayout layout)
    {
        KmList<KmList<ScControl>> rows = layout.getChildren().splitByGroupSize(2);
        for ( KmList<ScControl> row : rows )
            renderRowOn(out, row);
    }

    private void renderRowOn(KmHtmlBuilder out, KmList<ScControl> controls)
    {
        ScDiv row;
        row = new ScDiv();
        row.css().flexRow().rowSpacer20();
        row.add(createWrapperFor(controls.getAtSafe(0)));
        row.add(createWrapperFor(controls.getAtSafe(1)));
        row.renderOn(out);
    }

    private ScControl createWrapperFor(ScControl e)
    {
        if ( e == null || !e.isVisible() )
        {
            ScDiv space;
            space = new ScDiv();
            space.css().flexChildFiller0();
            return space;
        }

        ScFieldset set;
        set = new ScFieldset();
        set.css().flexChildFiller0();
        set.setLabel(e.getLabel());
        set.addDiv().addWrapper(e);
        return set;
    }
}
