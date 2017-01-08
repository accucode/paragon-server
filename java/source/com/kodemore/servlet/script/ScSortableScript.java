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

package com.kodemore.servlet.script;

import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.json.KmJsonMap;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.utility.ScJquery;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

public class ScSortableScript
    extends ScAbstractScript
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The selector that identifies the container element whose children
     * will be sortable.  This is required.
     */
    private String _containerSelector;

    /**
     * The optional selector that identifies the child element used
     * to initiate dragging.  If not specified, the user can click
     * anywhere on the child element.
     */
    private String _handleSelector;

    /**
     * The optional update script to be run when the user stopped sorting
     * AND the DOM position has changed.  This should either be the name of a
     * function, or an inline function declaration like:
     *      "function(ev, ui) {...}"
     *
     * For additional info, see:
     *      http://api.jqueryui.com/sortable/#event-update
     */
    private String _update;

    //##################################################
    //# container
    //##################################################

    public String getContainerSelector()
    {
        return _containerSelector;
    }

    public void setContainerSelector(String e)
    {
        _containerSelector = e;
    }

    public void setContainer(ScHtmlIdIF e)
    {
        setContainerSelector(e.getJquerySelector());
    }

    //##################################################
    //# handle
    //##################################################

    public String getHandleSelector()
    {
        return _handleSelector;
    }

    public void setHandleSelector(String sel)
    {
        _handleSelector = sel;
    }

    public void setHandleCss(String css)
    {
        setHandleSelector(ScJquery.formatCssSelector(css));
    }

    public void setHandle()
    {
        setHandleCss(KmCssDefaultConstantsIF.dragHandle);
    }

    public boolean hasHandle()
    {
        return Kmu.hasValue(getHandleSelector());
    }

    //##################################################
    //# update
    //##################################################

    public String getUpdate()
    {
        return _update;
    }

    private void setUpdate(String e)
    {
        _update = e;
    }

    public boolean hasUpdate()
    {
        return Kmu.hasValue(getUpdate());
    }

    /**
     * Set the name of the function to execute.
     */
    public void setUpdateFunctionName(String e)
    {
        setUpdate(e);
    }

    public void setUpdateScript(ScScriptIF e)
    {
        String js = e.formatScript();
        String fn = Kmu.format("function(ev,ui){%s}", js);
        setUpdate(fn);
    }

    //##################################################
    //# format
    //##################################################

    @Override
    public void formatScriptOn(KmStringBuilder out)
    {
        out.printf("$('%s').sortable(%s);", getContainerSelector(), getOptions());
    }

    private KmJsonMap getOptions()
    {
        KmJsonMap e;
        e = new KmJsonMap();

        if ( hasHandle() )
            e.setString("handle", getHandleSelector());

        if ( hasUpdate() )
            e.setLiteral("update", getUpdate());

        return e;
    }
}
