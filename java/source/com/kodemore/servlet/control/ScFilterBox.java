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

package com.kodemore.servlet.control;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.script.ScVisibilityScript;

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

    private ScForm  _form;
    private ScGroup _group;
    private ScDiv   _body;

    private ScAction _action;
    private ScDiv    _leftButtons;
    private ScDiv    _rightButtons;

    //##################################################
    //# constructor
    //##################################################

    public ScFilterBox()
    {
        _form = new ScForm();
        _form.setParent(this);
        _form.onSubmit(_form.newUncheckedAction(this::handleSearch));

        _group = _form.addGroup();
        _group.setTitle("Filter");

        _body = _group.getBody().addPad();

        ScDiv footer;
        footer = _group.showFooter();
        footer.css().flexRow().flexAlignSpaced();

        _leftButtons = footer.addButtonBox();
        _leftButtons.addSubmitButton("Search");
        _leftButtons.addButton("clear", _leftButtons.newCheckedAction(this::handleClear));

        _rightButtons = footer.addButtonBox();
    }

    //##################################################
    //# layout
    //##################################################

    public ScForm getFormWrapper()
    {
        return _form;
    }

    public KmCssDefaultBuilder css()
    {
        return getFormWrapper().css();
    }

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
    public ScHtmlIdAjax _htmlIdAjax()
    {
        return _form._htmlIdAjax();
    }

    //##################################################
    //# show/hide
    //##################################################

    @Override
    public boolean isVisible()
    {
        return _form.isVisible();
    }

    @Override
    public void setVisible(boolean e)
    {
        _form.setVisible(e);
    }

    @Override
    public ScVisibilityScript ajaxShow(boolean e)
    {
        return _form.ajaxShow(e);
    }

    //##################################################
    //# action
    //##################################################

    public ScAction getAction()
    {
        return _action;
    }

    public void setAction(ScAction e)
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
        validate();

        saveFieldValues();
        ajaxUpdateFieldValues();
        runAction();
    }

    protected void handleClear()
    {
        resetFieldValues();

        saveFieldValues();
        ajaxUpdateFieldValues();
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
    public final KmList<ScControl> getChildren()
    {
        return KmList.createWith(_form);
    }

    public ScDiv getLeftButtons()
    {
        return _leftButtons;
    }

    public ScDiv getRightButtons()
    {
        return _rightButtons;
    }

    //##################################################
    //# render
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
