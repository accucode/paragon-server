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

import java.util.Iterator;

import com.kodemore.collection.KmSingletonIterator;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.script.ScHtmlIdAjax;

/**
 * I am used to manage common filter groups for search pages.
 * I manage a group box with a title, and buttons for 'clear'
 * and 'search'.  Custom controls are automatically added to
 * my body.
 *
 * The 'clear' button will reset the values of all fields.
 * The 'search' button will validate and save the field values.
 *
 * Both 'clear' and 'search' trigger the pluggable action so
 * that the client can take appropriate steps to update the view.
 */
public class ScFilterBox
    extends ScContainer
    implements ScHtmlIdIF
{
    //##################################################
    //# variables
    //##################################################

    private ScForm     _form;
    private ScGroup    _group;
    private ScBox      _body;

    private ScActionIF _action;
    private ScBox      _leftButtons;
    private ScBox      _rightButtons;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _form = new ScForm();
        _form.setParent(this);
        _form.setSubmitAction(newSearchAction());

        _group = _form.addGroup();
        _group.setTitle("Filter");

        _body = _group.getBody().addPad();

        ScDiv footer;
        footer = _group.showFooter();
        footer.css().flex().flexAlignSpaced();

        _leftButtons = footer.addButtonBox();
        _leftButtons.addSubmitButton("Search");
        _leftButtons.addButton("Clear", newClearAction());

        _rightButtons = footer.addButtonBox();
    }

    protected ScActionIF newSearchAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleSearch();
            }
        };
    }

    protected ScActionIF newClearAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleClear();
            }
        };
    }

    //##################################################
    //# layout
    //##################################################

    public void layoutFill()
    {
        _form.css().fill();

        _group.css().fill();
        _group.getFooter().show();
    }

    //##################################################
    //# html id
    //##################################################

    @Override
    public String getHtmlId()
    {
        return _form.getHtmlId();
    }

    @Override
    public String getJquerySelector()
    {
        return _form.getJquerySelector();
    }

    @Override
    public ScHtmlIdAjax ajax()
    {
        return _form.ajax();
    }

    //##################################################
    //# action
    //##################################################

    public ScActionIF getAction()
    {
        return _action;
    }

    public void setAction(ScActionIF e)
    {
        _action = e;
    }

    private void runAction()
    {
        if ( _action != null )
            _action.run();
    }

    //##################################################
    //# handle
    //##################################################

    protected void handleSearch()
    {
        validateQuietly();

        saveFieldValues();
        ajaxUpdateValues();
        runAction();
    }

    protected void handleClear()
    {
        resetFieldValues();

        saveFieldValues();
        ajaxUpdateValues();
        runAction();
    }

    //##################################################
    //# components
    //##################################################

    public ScGroup getGroup()
    {
        return _group;
    }

    public void setTitle(String title)
    {
        getGroup().setTitle(title);
    }

    @Override
    public Iterator<ScControlIF> getComponents()
    {
        return new KmSingletonIterator<ScControlIF>(_form);
    }

    public ScBox getLeftButtons()
    {
        return _leftButtons;
    }

    public ScBox getRightButtons()
    {
        return _rightButtons;
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.render(_form);
    }

    //##################################################
    //# container
    //##################################################

    @Override
    public <T extends ScControl> T add(T e)
    {
        return _body.add(e);
    }

    @Override
    public boolean isEmpty()
    {
        return _body.isEmpty();
    }

    @Override
    public void clear()
    {
        _body.clear();
    }

}
