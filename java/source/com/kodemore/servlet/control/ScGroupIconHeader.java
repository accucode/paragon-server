/*
  Copyright (c) 2005-2013 www.kodemore.com

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

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.utility.ScJquery;
import com.kodemore.servlet.utility.ScUrls;
import com.kodemore.servlet.variable.ScLocalString;

public class ScGroupIconHeader
    extends ScControl
    implements ScHtmlIdIF
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalString _htmlId;
    private ScImage       _image;
    private ScText        _text;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _htmlId = new ScLocalString(getKey());

        _image = new ScImage();
        _image.setSource(ScUrls.getCommonImage("white50.png"));

        _text = new ScText();
        _text.setValue("default");
    }

    //##################################################
    //# html id
    //##################################################

    @Override
    public String getHtmlId()
    {
        return _htmlId.getValue();
    }

    public void setHtmlId(String e)
    {
        _htmlId.setValue(e);
    }

    @Override
    public String formatJquerySelector()
    {
        return ScJquery.formatSelector(this);
    }

    @Override
    public String formatJqueryReference()
    {
        return ScJquery.formatReference(this);
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public ScHtmlIdAjax ajax()
    {
        return new ScHtmlIdAjax(getRootScript(), this);
    }

    //##################################################
    //# icon
    //##################################################

    public ScImage getImage()
    {
        return _image;
    }

    public void setImageSource(String s)
    {
        _image.setSource(s);
    }

    public void getImageSource()
    {
        _image.getSource();
    }

    //##################################################
    //# text
    //##################################################

    public ScText getText()
    {
        return _text;
    }

    public void setText(String s)
    {
        _text.setValue(s);
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.openDiv();
        out.printAttribute("id", getHtmlId());
        out.close();

        out.render(_image);
        out.printSpace();
        out.render(_text);

        out.endDiv();
    }
}
