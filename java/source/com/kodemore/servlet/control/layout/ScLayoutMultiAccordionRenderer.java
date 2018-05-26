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

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.json.KmJsonMap;
import com.kodemore.servlet.control.ScControl;

public abstract class ScLayoutMultiAccordionRenderer
    extends ScLayoutRenderer
{
    //##################################################
    //# render
    //##################################################

    @Override
    public final void renderChildrenOn(KmHtmlBuilder out, ScLayout layout)
    {
        for ( ScControl e : layout.getChildren() )
            renderOn(out, e);
    }

    private void renderOn(KmHtmlBuilder out, ScControl e)
    {
        if ( !e.isVisible() )
            return;

        out.beginDiv();
        out.printHeader1(e.getLabel());
        out.beginDiv();
        out.render(e);
        out.endDiv();
        out.endDiv();
    }

    @Override
    public void renderScriptsOn(KmHtmlBuilder out, ScLayout layout)
    {
        String ref = layout.getJqueryReference();
        KmJsonMap firstOptions = getFirstAccordionOptions();
        KmJsonMap options = getAccordionOptions();

        out.getPostDom().run("%s.children().first().accordion(%s);", ref, firstOptions);
        out.getPostDom().run("%s.children().slice(1).accordion(%s);", ref, options);
    }

    private KmJsonMap getFirstAccordionOptions()
    {
        KmJsonMap map;
        map = new KmJsonMap();
        map.setBoolean("collapsible", true);
        map.setString("heightStyle", "content");
        map.setInteger("animate", 200);

        if ( isOpen() )
            map.setInteger("active", 0);
        else
            map.setBoolean("active", false);

        return map;
    }

    private KmJsonMap getAccordionOptions()
    {
        KmJsonMap map;
        map = new KmJsonMap();
        map.setBoolean("collapsible", true);
        map.setString("heightStyle", "content");
        map.setInteger("animate", 200);
        map.setBoolean("active", false);

        return map;
    }

    protected abstract boolean isOpen();
}
