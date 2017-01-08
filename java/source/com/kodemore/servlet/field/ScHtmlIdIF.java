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

import com.kodemore.servlet.control.ScVisibleIF;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.script.ScToggleScript;
import com.kodemore.servlet.script.ScVisibilityScript;
import com.kodemore.servlet.utility.ScJquery;

public interface ScHtmlIdIF
    extends ScVisibleIF
{
    //##################################################
    //# basics
    //##################################################

    String getHtmlId();

    ScHtmlIdIF getFocusTarget();

    //##################################################
    //# defaults
    //##################################################

    default String getJquerySelector()
    {
        return ScJquery.formatSelector(this);
    }

    default String getJqueryReference()
    {
        return ScJquery.formatReference(this);
    }

    //##################################################
    //# ajax
    //#
    //# A number of default methods are included.
    //# This should only include methods that are
    //# intended to be PUBLIC for ALL classes that
    //# implement ScHtmlIdIF.  Additional ajax methods
    //# may be implemented on specific classes.
    //##################################################

    ScHtmlIdAjax _htmlIdAjax();

    @Override
    default ScVisibilityScript ajaxShow(boolean visible)
    {
        return _htmlIdAjax().show(visible);
    }

    default ScToggleScript ajaxToggle()
    {
        return _htmlIdAjax().toggle();
    }

    default void ajaxFocus()
    {
        _htmlIdAjax().focus();
    }

    default void ajaxReplace()
    {
        _htmlIdAjax().replace();
    }

    default void ajaxReplaceFade()
    {
        _htmlIdAjax().replaceFade();
    }

    default void ajaxHideAllErrors()
    {
        _htmlIdAjax().hideAllErrors();
    }

}
