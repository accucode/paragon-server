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

package com.kodemore.servlet.script;

import com.kodemore.json.KmJsonObject;
import com.kodemore.string.KmStringBuilder;

public class ScEqualizeScript
    extends ScAbstractScript
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The jquery selector for the elements to be equalized.
     */
    private String  _selector;

    private boolean _equalizeHeight;
    private boolean _equalizeWidth;

    /**
     * The min/max values for height and width.  The 
     * equalized elements will always fall between these values
     * if they are defined.
     */
    private Integer _minWidth;
    private Integer _maxWidth;
    private Integer _minHeight;
    private Integer _maxHeight;

    //##################################################
    //# constructor
    //##################################################

    public ScEqualizeScript()
    {
        // none
    }

    //##################################################
    //# acessing
    //##################################################

    public String getSelector()
    {
        return _selector;
    }

    public void setSelector(String e)
    {
        _selector = e;
    }

    //##################################################
    //# mode
    //##################################################

    public boolean getEqualizeHeight()
    {
        return _equalizeHeight;
    }

    public void setEqualizeHeight(boolean e)
    {
        _equalizeHeight = e;
    }

    public void setEqualizeHeight()
    {
        setEqualizeHeight(true);
    }

    public boolean getEqualizeWidth()
    {
        return _equalizeWidth;
    }

    public void setEqualizeWidth(boolean e)
    {
        _equalizeWidth = e;
    }

    public void setEqualizeWidth()
    {
        setEqualizeWidth(true);
    }

    public void setEqualizeBoth()
    {
        setEqualizeHeight();
        setEqualizeWidth();
    }

    //##################################################
    //# min and max values
    //##################################################

    public Integer getMinWidth()
    {
        return _minWidth;
    }

    public void setMinWidth(Integer e)
    {
        _minWidth = e;
    }

    public Integer getMaxWidth()
    {
        return _maxWidth;
    }

    public void setMaxWidth(Integer e)
    {
        _maxWidth = e;
    }

    public Integer getMinHeight()
    {
        return _minHeight;
    }

    public void setMinHeight(Integer e)
    {
        _minHeight = e;
    }

    public Integer getMaxHeight()
    {
        return _maxHeight;
    }

    public void setMaxHeight(Integer e)
    {
        _maxHeight = e;
    }

    //##################################################
    //# format
    //##################################################

    @Override
    public void formatScriptOn(KmStringBuilder out)
    {
        boolean height = getEqualizeHeight();
        boolean width = getEqualizeWidth();

        if ( !getEqualizeHeight() && !getEqualizeWidth() )
        {
            height = true;
            width = true;
        }

        KmJsonObject e;
        e = new KmJsonObject();
        e.setString("selector", getSelector());
        e.setBoolean("height", height);
        e.setBoolean("width", width);
        e.setInteger("minWidth", getMinWidth());
        e.setInteger("maxWidth", getMaxWidth());
        e.setInteger("minHeight", getMinHeight());
        e.setInteger("maxHeight", getMaxHeight());

        out.printf("Kmu.equalize(%s);", e);
    }
}
