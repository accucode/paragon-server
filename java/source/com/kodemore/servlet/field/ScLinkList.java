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

package com.kodemore.servlet.field;

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScLink;
import com.kodemore.servlet.variable.ScLocalAction;
import com.kodemore.servlet.variable.ScLocalAdaptor;
import com.kodemore.servlet.variable.ScLocalList;
import com.kodemore.servlet.variable.ScLocalString;

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
    private ScLocalAction _action;

    /**
     * The list of options.  Each option corresponds to a single link.
     */
    private ScLocalList<T> _options;

    /**
     * Adapts a single option to the label/text to be displayed.
     * This adapter is required.
     */
    private ScLocalAdaptor _optionLabelAdaptor;

    /**
     * Adapts a single option to the value/argument to be submitted with the action.
     * This adapter is required.
     */
    private ScLocalAdaptor _optionValueAdaptor;

    /**
     * If set, add an extra link at the beginning of the list with this text.
     */
    private ScLocalString _nullPrefix;

    /**
     * If set, add an extra link at the end of the list with this text.
     */
    private ScLocalString _nullSuffix;

    //##################################################
    //# constructor
    //##################################################

    public ScLinkList()
    {
        _action = new ScLocalAction();
        _options = new ScLocalList<>();
        _optionLabelAdaptor = new ScLocalAdaptor();
        _optionValueAdaptor = new ScLocalAdaptor();
        _nullPrefix = new ScLocalString();
        _nullSuffix = new ScLocalString();
    }

    //##################################################
    //# null prefix
    //##################################################

    public void setNullPrefix(String e)
    {
        _nullPrefix.setValue(e);
    }

    //##################################################
    //# null suffix
    //##################################################

    public void setNullSuffix(String e)
    {
        _nullSuffix.setValue(e);
    }

    //##################################################
    //# state
    //##################################################

    public void setAction(ScAction e)
    {
        _action.setValue(e);
    }

    //##################################################
    //# options
    //##################################################

    public void setOptions(KmList<T> v)
    {
        _options.setValue(v);
    }

    public void setOptionTextAdaptor(KmAdaptorIF<T,String> e)
    {
        _optionLabelAdaptor.setValue(e);
    }

    public void setOptionValueAdaptor(KmAdaptorIF<T,String> e)
    {
        _optionValueAdaptor.setValue(e);
    }

    @SuppressWarnings("unchecked")
    private String getTextFor(T e)
    {
        KmAdaptorIF<T,String> a = _optionLabelAdaptor.getValue();
        return a.getValue(e);
    }

    @SuppressWarnings("unchecked")
    private String getValueFor(T e)
    {
        KmAdaptorIF<T,String> a = _optionValueAdaptor.getValue();
        return a.getValue(e);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        ScLink link;
        link = new ScLink();
        link.setParent(this);
        link.setAction(_action.getValue());

        if ( _nullPrefix.hasValue() )
        {
            link.setText(_nullPrefix.getValue());
            link.setArgument(null);
            link.renderOn(out);
        }

        for ( T e : _options.getValue() )
        {
            link.setText(getTextFor(e));
            link.setArgument(getValueFor(e));
            link.renderOn(out);
        }

        if ( _nullSuffix.hasValue() )
        {
            link.setText(_nullSuffix.getValue());
            link.setArgument(null);
            link.renderOn(out);
        }
    }
}
