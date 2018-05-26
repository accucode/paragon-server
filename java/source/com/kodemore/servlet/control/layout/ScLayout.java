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
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.control.ScChildContainerElement;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.KmEnumIF;
import com.kodemore.utility.Kmu;

public class ScLayout
    extends ScChildContainerElement
{
    //##################################################
    //# enum
    //##################################################

    private static enum Type
        implements KmEnumIF
    {
        Fieldset,
        Fieldset2,
        NormalGroup,
        MinorGroup,
        AccordionOpen,
        AccordionClosed,
        MultiAccordionOpen,
        MultiAccordionClosed,
        None
    }

    //##################################################
    //# variables
    //##################################################

    private ScLocalString _typeCode;

    //##################################################
    //# constructor
    //##################################################

    public ScLayout()
    {
        _typeCode = new ScLocalString();
        setTypeNone();
    }

    //##################################################
    //# type
    //##################################################

    private Type getType()
    {
        return Type.valueOf(_typeCode.getValue());
    }

    private void setType(Type e)
    {
        _typeCode.setValue(e.getCode());
    }

    public void setTypeFieldset()
    {
        setType(Type.Fieldset);
    }

    public void setTypeFieldset2()
    {
        setType(Type.Fieldset2);
    }

    public void setTypeNormalGroup()
    {
        setType(Type.NormalGroup);
    }

    public void setTypeMinorGroup()
    {
        setType(Type.MinorGroup);
    }

    public void setTypeAccordionOpen()
    {
        setType(Type.AccordionOpen);
    }

    public void setTypeAccordionClosed()
    {
        setType(Type.AccordionClosed);
    }

    public void setTypeMultiAccordionOpen()
    {
        setType(Type.MultiAccordionOpen);
    }

    public void setTypeMultiAccordionClosed()
    {
        setType(Type.MultiAccordionClosed);
    }

    public void setTypeNone()
    {
        setType(Type.None);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        ScLayoutRenderer r = getRenderer();
        String tag = r.getTag();

        out.open(tag);
        renderAttributesOn(out);
        out.close();
        r.renderChildrenOn(out, this);
        out.end(tag);

        r.renderScriptsOn(out, this);
    }

    @Override
    protected final void renderChildrenOn(KmHtmlBuilder out)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    protected final void renderChildOn(KmHtmlBuilder out, ScControl c)
    {
        throw new UnsupportedOperationException();
    }

    //##################################################
    //# renderer
    //##################################################

    private ScLayoutRenderer getRenderer()
    {
        Type type = getType();
        switch ( type )
        {
            case Fieldset:
                return new ScLayoutFieldsetRenderer();

            case Fieldset2:
                return new ScLayoutFieldset2Renderer();

            case None:
                return new ScLayoutDefaultRenderer();

            case NormalGroup:
                return new ScLayoutNormalGroupRenderer();

            case MinorGroup:
                return new ScLayoutMinorGroupRenderer();

            case AccordionOpen:
                return new ScLayoutOpenAccordionRenderer();

            case AccordionClosed:
                return new ScLayoutClosedAccordionRenderer();

            case MultiAccordionOpen:
                return new ScLayoutOpenMultiAccordionRenderer();

            case MultiAccordionClosed:
                return new ScLayoutClosedMultiAccordionRenderer();
        }

        throw Kmu.newEnumError(type);
    }

    @Override
    protected KmCssDefaultBuilder formatCss()
    {
        KmCssDefaultBuilder css;
        css = super.formatCss();
        getRenderer().applyCss(css);
        return css;
    }

    @Override
    protected KmStyleBuilder formatStyle()
    {
        KmStyleBuilder style;
        style = super.formatStyle();
        getRenderer().applyStyle(style);
        return style;
    }
}
