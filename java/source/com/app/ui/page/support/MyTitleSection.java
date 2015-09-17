package com.app.ui.page.support;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScDivWrapper;
import com.kodemore.servlet.control.ScSubmitButton;
import com.kodemore.servlet.control.ScTextParagraph;
import com.kodemore.utility.Kmu;

/**
 * I provide a convenience way to display a standard title section.
 * The section is a fixed height (50px).
 * The left side displays title and subtitle texts.
 * The right side can be used to display buttons.
 */
public class MyTitleSection
    extends ScDivWrapper
{
    //##################################################
    //# variables
    //##################################################

    private ScDiv           _left;
    private ScTextParagraph _title;
    private ScTextParagraph _subtitle;

    private ScDiv _right;

    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _left = getInner().addDiv();
        _left.css().formSectionLeft();

        _title = _left.addTextParagraph();
        _title.css().formTitle();

        _subtitle = _left.addTextParagraph();
        _subtitle.css().formSubtitle();

        _right = getInner().addDiv();
        _right.css().formSectionRight().buttonBox();
    }

    //##################################################
    //# accessing
    //##################################################

    public ScDiv getLeft()
    {
        return _left;
    }

    public ScDiv getRight()
    {
        return _right;
    }

    public void setTitle(String msg, Object... args)
    {
        String s = Kmu.format(msg, args);
        _title.setValue(s);
    }

    public void setSubtitle(String msg, Object... args)
    {
        String s = Kmu.format(msg, args);
        _subtitle.setValue(s);
    }

    //##################################################
    //# accessing :: buttons
    //##################################################

    public ScSubmitButton addSubmitButton()
    {
        return getRight().addSubmitButton();
    }

    public ScActionButton addButton()
    {
        return getRight().addButton();
    }

    public ScActionButton addButton(String text, ScAction action)
    {
        return getRight().addButton(text, action);
    }

}
