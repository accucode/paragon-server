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

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScLink;
import com.kodemore.servlet.variable.ScLocalAction;
import com.kodemore.servlet.variable.ScLocalAdaptor;
import com.kodemore.servlet.variable.ScLocalOptionList;

/**
 * A list of links, each link separated by an html break.
 * All of the links will use the same action, but the
 * links label(text) and argument are determined by applying
 * the specified adapters to each option.
 *
 * This control only generates the links, not a container
 * around the links.  Scrolling, borders, and other artifacts
 * around the list need to be managed with a separate control.
 */
public class ScLinkList<T>
    extends ScControl
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The common action to be used for all links.
     */
    private ScLocalAction        _action;

    /**
     * The list of options.  Each option corresponds to a single link.
     */
    private ScLocalOptionList<T> _options;

    /**
     * Adapts a single option to the label/text to be displayed.
     * This adapter is required.
     */
    private ScLocalAdaptor       _optionLabelAdaptor;

    /**
     * Adapts a single option to the value/argument to be submitted with the action.
     * This adapter is required.
     */
    private ScLocalAdaptor       _optionValueAdaptor;

    //##################################################
    //# constructor
    //##################################################

    public ScLinkList()
    {
        _action = new ScLocalAction();
        _options = new ScLocalOptionList<>();
        _optionLabelAdaptor = new ScLocalAdaptor();
        _optionValueAdaptor = new ScLocalAdaptor();
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        ScLink link;
        link = new ScLink();
        link.setParent(this);
        link.setAction(_action.getValue());

        for ( ScOption<T> e : _options )
        {
            link.setText(e.getText());
            link.setArgument(e.getValue());
            link.renderOn(out);
            out.printBreak();
        }
    }

    //##################################################
    //# state
    //##################################################

    public void setAction(ScAction e)
    {
        _action.setValue(e);
    }

    @SuppressWarnings("rawtypes")
    public void setOptionTextAdaptor(KmAdaptorIF e)
    {
        _optionLabelAdaptor.setValue(e);
    }

    @SuppressWarnings("rawtypes")
    public void setOptionValueAdaptor(KmAdaptorIF e)
    {
        _optionValueAdaptor.setValue(e);
    }
}
