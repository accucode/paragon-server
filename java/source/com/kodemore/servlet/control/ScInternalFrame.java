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

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalInteger;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.Kmu;

public class ScInternalFrame
    extends ScElement
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalString  _source;
    private ScLocalInteger _width;
    private ScLocalInteger _height;
    private ScLocalBoolean _border;
    private ScLocalBoolean _scrolling;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _source = new ScLocalString();
        _width = new ScLocalInteger(800);
        _height = new ScLocalInteger(600);
        _border = new ScLocalBoolean();
        _scrolling = new ScLocalBoolean();
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.open("iframe");
        renderAttributesOn(out);
        out.close();

        out.end("iframe");
    }

    @Override
    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        super.renderAttributesOn(out);

        out.printAttribute("src", _source.getValue());
        out.printAttribute("width", _width.getValue());
        out.printAttribute("height", _height.getValue());
        out.printAttribute("frameborder", formatBorderAttribute());
        out.printAttribute("scrolling", formatScrollingAttribute());
    }

    //##################################################
    //# accessing
    //##################################################

    public void setSource(String e)
    {
        _source.setValue(e);
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

    public boolean hasWidth()
    {
        return _width.hasValue();
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

    public boolean hasHeight()
    {
        return _height.hasValue();
    }

    //##################################################
    //# border
    //##################################################

    public Boolean getBorder()
    {
        return _border.getValue();
    }

    public void setBorder(Boolean e)
    {
        _border.setValue(e);
    }

    public boolean hasBorder()
    {
        return _border.hasValue();
    }

    private String formatBorderAttribute()
    {
        if ( !hasBorder() )
            return "0";

        if ( _border.getValue() )
            return "1";

        return "0";
    }

    //##################################################
    //# scrolling
    //##################################################

    public boolean getScrolling()
    {
        return _scrolling.getValue();
    }

    public void setScrolling(Boolean e)
    {
        _scrolling.setValue(e);
    }

    public boolean hasScrolling()
    {
        return _scrolling.hasValue();
    }

    private String formatScrollingAttribute()
    {
        Boolean b = _scrolling.getValue();
        if ( b == null )
            return "auto";

        if ( b.equals(true) )
            return "yes";

        return "no";
    }

    //##################################################
    //# script
    //##################################################

    public String formatSetStaticSourceScript(String source)
    {
        return Kmu.format("ref('%s').src = '%s';", getHtmlId(), source);
    }

    public String formatSetDynamicSourceScript(String source)
    {
        return Kmu.format("ref('%s').src = %s;", getHtmlId(), source);
    }
}
