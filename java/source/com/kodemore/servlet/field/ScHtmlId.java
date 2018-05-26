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

import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.script.ScVisibilityScript;

/**
 * I represent an object that implements the ScHtmlIdIF interface.
 * However, I am NOT necessarily an ScControl.
 *
 * In most cases, we simply use the pertinent control directly.
 * However when manipulating dynamic content, we may use a single
 * control that is rendered repeatedly with different content.  In
 * this type of situation, there is only one control and we need
 * some representation of the various unique htmlIds.  For these
 * types of situations we use instances of ScHtmlId and manually
 * set their ids to the appropriate values.
 */
public class ScHtmlId
    implements ScHtmlIdIF
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The htmlId that uniquely identifies the element within the DOM.
     * This must correspond to the html of <someElement id="ID"...>.
     */
    private String _htmlId;

    private boolean _visible;

    /**
     * The script to which any ajax is delegated.
     */
    private ScBlockScript _script;

    //##################################################
    //# constructor
    //##################################################

    public ScHtmlId(String htmlId, ScBlockScript script)
    {
        _htmlId = htmlId;
        _visible = true;
        _script = script;
    }

    //##################################################
    //# html id
    //##################################################

    @Override
    public String getHtmlId()
    {
        return _htmlId;
    }

    @Override
    public ScHtmlIdIF getFocusTarget()
    {
        return this;
    }

    //##################################################
    //# visible
    //##################################################

    @Override
    public boolean isVisible()
    {
        return _visible;
    }

    @Override
    public void setVisible(boolean e)
    {
        _visible = e;
    }

    //##################################################
    //# ajax
    //##################################################

    @Override
    public ScHtmlIdAjax _htmlIdAjax()
    {
        return ScHtmlIdAjax.createOnDelegate(this, _script);
    }

    @Override
    public ScVisibilityScript ajaxShow(boolean e)
    {
        return _htmlIdAjax().show(e);
    }

    public ScHtmlIdAjax ajax()
    {
        return _htmlIdAjax();
    }
}
