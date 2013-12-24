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

package com.kodemore.servlet.control;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.script.ScActionScript;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalHtmlId;

public class ScForm
    extends ScContainerElement
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The action to run when users press the enter key in a field.
     */
    // todo_wyatt: rename to _submitAction
    private ScActionIF     _defaultAction;

    /**
     * An optional target to use as the block root.
     */
    private ScLocalHtmlId  _blockTarget;

    /**
     * If true (the default), then act as a block wrapper.
     * See ScControl.findBlockWrapper().
     */
    private ScLocalBoolean _blockWrapper;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _blockTarget = new ScLocalHtmlId();
        _blockWrapper = new ScLocalBoolean(true);

        submitOnControlEnter();
    }

    private void submitOnControlEnter()
    {
        onControlEnter().run("%s.submit();", formatJqueryReference());
    }

    //##################################################
    //# action
    //##################################################

    public ScActionIF getDefaultAction()
    {
        return _defaultAction;
    }

    public void setDefaultAction(ScActionIF e)
    {
        _defaultAction = e;
    }

    public boolean hasAction()
    {
        return _defaultAction != null;
    }

    //##################################################
    //# block target
    //##################################################

    public ScHtmlIdIF getBlockTarget()
    {
        return _blockTarget.getHtmlId();
    }

    public void setBlockTarget(ScHtmlIdIF e)
    {
        _blockTarget.setHtmlId(e);
    }

    public boolean hasBlockTarget()
    {
        return _blockTarget.hasValue();
    }

    //##################################################
    //# block wrapper
    //##################################################

    public boolean getBlockWrapper()
    {
        return _blockWrapper.getValue();
    }

    public void setBlockWrapper(Boolean e)
    {
        _blockWrapper.setValue(e);
    }

    @Override
    public boolean isBlockWrapper()
    {
        return _blockWrapper.isTrue();
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.open("form");
        renderAttributesOn(out);
        out.close();

        out.printHiddenField(ScConstantsIF.PARAMETER_FORM_KEY, getKey());

        KmList<ScControl> v = getChildren();
        for ( ScControl e : v )
            e.renderOn(out);

        out.end("form");
    }

    @Override
    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        super.renderAttributesOn(out);

        out.printAttribute("method", "post");
        out.printAttribute("action", "");
        out.printAttribute("onsubmit", formatOnSubmit());
    }

    private String formatOnSubmit()
    {
        final String suffix = " return false;";

        if ( !hasAction() )
            return suffix;

        ScForm form;
        form = findFormWrapper();

        ScHtmlIdIF block = hasBlockTarget()
            ? getBlockTarget()
            : findBlockWrapper();

        ScActionScript s;
        s = new ScActionScript();
        s.setForm(form);
        s.setAction(getDefaultAction());
        s.setModel(getModel());
        s.setBlockTarget(block);

        return s.formatScript() + suffix;

    }

    //##################################################
    //# types
    //##################################################

    @Override
    public boolean isForm()
    {
        return true;
    }

}
