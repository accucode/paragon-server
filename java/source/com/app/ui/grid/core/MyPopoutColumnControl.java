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

package com.app.ui.grid.core;

import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScLink;
import com.kodemore.servlet.control.ScScriptButton;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.script.ScSimpleBlockScript;

import com.app.dao.base.MyDaoAccess;
import com.app.utility.MyGlobals;

/**
 * I display a link and a popout button for use in grids.
 *
 * P The parent. That is, the model being displayed in the grid.
 * C The child. The model that this control/link is for.
 */
public abstract class MyPopoutColumnControl<P extends KmUidDomainIF, C extends KmUidDomainIF>
    extends ScControl
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The action used to navigate to the child's page.
     */
    private ScAction _viewChildAction;

    //##################################################
    //# constructors
    //##################################################

    public MyPopoutColumnControl()
    {
        _viewChildAction = newUncheckedAction(this::handleViewChild);
    }

    //##################################################
    //# child
    //##################################################

    protected abstract C getChildFor(P p);

    protected abstract String getPopoutUrlFor(C child);

    protected abstract String getTitleFor(C child);

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        @SuppressWarnings("unchecked")
        P parent = (P)getModel();
        C child = getChildFor(parent);

        if ( child == null )
        {
            out.print("[none]");
            return;
        }

        ScDiv row;
        row = new ScDiv();
        row.css().flexRow().flexCrossAlignCenter().rowSpacer5();
        row.style().pad(0);
        row.add(createPopoutButtonFor(child));
        row.add(createLinkFor(child));

        out.render(row);
    }

    private ScControl createPopoutButtonFor(C child)
    {
        String url = getPopoutUrlFor(child);

        ScBlockScript js;
        js = ScSimpleBlockScript.create();
        js.openWindowUrl(url);

        ScScriptButton e;
        e = new ScScriptButton();
        e.setFlavorSmallIcon();
        e.setIcon().nameOpenInNew();
        e.setScript(js);
        return e;
    }

    private ScControl createLinkFor(C child)
    {
        ScLink e;
        e = new ScLink();
        e.css().noWrap();
        e.setText(getTitleFor(child));
        e.setAction(_viewChildAction, child.getUid());
        return e;
    }

    //##################################################
    //# handle
    //##################################################

    private void handleViewChild()
    {
        String uid = getData().getStringArgument();
        C child = findChild(uid);
        ajaxViewChild(child);
    }

    protected abstract void ajaxViewChild(C child);

    protected abstract C findChild(String uid);

    //##################################################
    //# support
    //##################################################

    protected MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }
}
