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

package com.kodemore.servlet.control;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.variable.ScLocalInteger;
import com.kodemore.servlet.variable.ScLocalString;

/**
 * I represent the <object> tag.
 */
public class ScObjectControl
    extends ScElement
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalString  _mediaType;
    private ScLocalString  _dataUrl;
    private ScLocalInteger _width;
    private ScLocalInteger _height;
    private ScLocalString  _alternateText;

    //##################################################
    //# constructor
    //##################################################

    public ScObjectControl()
    {
        _mediaType = new ScLocalString();
        _dataUrl = new ScLocalString();
        _width = new ScLocalInteger();
        _height = new ScLocalInteger();
        _alternateText = new ScLocalString();
    }

    //##################################################
    //# media type
    //##################################################

    public String getMediaType()
    {
        return _mediaType.getValue();
    }

    public void setMediaType(String e)
    {
        _mediaType.setValue(e);
    }

    public void setMediaTypePdf()
    {
        setMediaType("application/pdf");
    }

    //##################################################
    //# data url
    //##################################################

    public String getDataUrl()
    {
        return _dataUrl.getValue();
    }

    public void setDataUrl(String e)
    {
        _dataUrl.setValue(e);
    }

    //##################################################
    //# width
    //##################################################

    public Integer getWidth()
    {
        return _width.getValue();
    }

    public void setWidth(Integer e)
    {
        _width.setValue(e);
    }

    //##################################################
    //# height
    //##################################################

    public Integer getHeight()
    {
        return _height.getValue();
    }

    public void setHeight(Integer e)
    {
        _height.setValue(e);
    }

    //##################################################
    //# alternate text
    //##################################################

    public String getAlternateText()
    {
        return _alternateText.getValue();
    }

    public void setAlternateText(String e)
    {
        _alternateText.setValue(e);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.open("object");
        renderAttributesOn(out);
        out.close();
        out.print(getAlternateText());
        out.end("object");
    }

    @Override
    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        super.renderAttributesOn(out);

        out.printAttribute("type", getMediaType());
        out.printAttribute("data", getDataUrl());
        out.printAttribute("width", getWidth());
        out.printAttribute("height", getHeight());
    }

}
