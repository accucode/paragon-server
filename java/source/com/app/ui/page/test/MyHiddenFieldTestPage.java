package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScDoubleField;
import com.kodemore.servlet.field.ScHiddenField;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyHiddenFieldTestPage
    extends MyPage
{
    //##################################################
    //# variables
    //##################################################

    private ScDoubleField                _doubleField;
    private ScHiddenField<Double>        _hiddenField;

    //##################################################
    //# singleton
    //##################################################

    private static MyHiddenFieldTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyHiddenFieldTestPage();
    }

    public static MyHiddenFieldTestPage getInstance()
    {
        return _instance;
    }

    private MyHiddenFieldTestPage()
    {
        // singleton
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    public final MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.developer;
    }

    //##################################################
    //# bookmark
    //##################################################

    @Override
    public void composeBookmarkOn(ScParameterList v)
    {
        // none
    }

    @Override
    public void applyBookmark(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().fill().auto();

        _doubleField = new ScDoubleField();
        _hiddenField = new ScHiddenField<>();
        _hiddenField.setValue(1.0);

        ScFieldset set;
        set = root.addForm().addFieldset("Hidden Field Test");
        set.css().flexColumn();
        set.add(_doubleField);
        set.add(_hiddenField);
        set.addBreak();

        ScDiv row;
        row = set.addFlexRow();
        row.css().rowSpacer5();
        row.addButton("set hidden field", newUncheckedAction(this::handleSetHiddenField));
        row.addButton("set double field", newUncheckedAction(this::handleSetDoubleField));
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        // none
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSetHiddenField()
    {
        _hiddenField.ajaxSetFieldValue(_doubleField.getValue());
    }

    private void handleSetDoubleField()
    {
        _doubleField.ajaxSetFieldValue(_hiddenField.getValue());
    }

}
