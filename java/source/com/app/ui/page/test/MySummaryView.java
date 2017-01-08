package com.app.ui.page.test;

import java.util.function.Function;

import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.meta.KmMetaProperty;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScPopupMenu;
import com.kodemore.servlet.control.ScTextSpan;

public class MySummaryView<T>
    extends ScDiv
{
    //##################################################
    //# variables
    //##################################################

    private ScTextSpan  _titleTextSpan;
    private ScTextSpan  _subtitle1TextSpan;
    private ScTextSpan  _subtitle2TextSpan;

    private ScDiv       _buttonBox;
    private ScPopupMenu _menu;

    //##################################################
    //# constructor
    //##################################################

    public MySummaryView()
    {
        install();
    }

    //##################################################
    //# install
    //##################################################

    private void install()
    {
        ScDiv row = this;
        row.css().summaryView();
        row.css().flexRow().flexAlignSpaced().flexCrossAlignCenter();

        installTitlesOn(row);
        installButtonsOn(row);
        installMenuOn(row);
    }

    private void installTitlesOn(ScContainer row)
    {
        ScDiv col;
        col = row.addFlexColumn();
        col.css().flexAlignCenter().flexChildFiller().clip();
        col.add(createTitle());
        col.add(createSubtitle1());
        col.add(createSubtitle2());
    }

    private void installButtonsOn(ScContainer row)
    {
        ScDiv e;
        e = row.addDiv();
        e.css().flexChildStatic().spacedLeft5().noWrap();
        _buttonBox = e;
    }

    private void installMenuOn(ScContainer row)
    {
        ScPopupMenu e;
        e = new ScPopupMenu();
        row.add(e);
        _menu = e;
    }

    //==================================================
    //= install :: fields
    //==================================================

    private ScTextSpan createTitle()
    {
        ScTextSpan e;
        e = new ScTextSpan();
        e.css().summaryView_title();
        _titleTextSpan = e;
        return e;
    }

    private ScTextSpan createSubtitle1()
    {
        ScTextSpan e;
        e = new ScTextSpan();
        e.css().summaryView_subtitle();
        _subtitle1TextSpan = e;
        return e;
    }

    private ScTextSpan createSubtitle2()
    {
        ScTextSpan e;
        e = new ScTextSpan();
        e.css().summaryView_subtitle();
        _subtitle2TextSpan = e;
        return e;
    }

    //##################################################
    //# title
    //##################################################

    public void setTitle(Function<T,String> e)
    {
        _titleTextSpan.setValue(e);
    }

    public void setTitle(KmMetaProperty<T,String> e)
    {
        _titleTextSpan.setValue(e);
    }

    public void setTitleProperty(String s)
    {
        _titleTextSpan.setValue(s);
    }

    //##################################################
    //# subtitle
    //##################################################

    public void setSubtitle(String s)
    {
        setSubtitle1(s);
        clearSubtitle2();
    }

    public void setSubtitle(Function<T,String> e)
    {
        setSubtitle1(e);
        clearSubtitle2();
    }

    public void setSubtitle(KmMetaProperty<T,String> e)
    {
        setSubtitle1(e);
        clearSubtitle2();
    }

    public KmCssDefaultBuilder subtitleCss()
    {
        return subtitle1Css();
    }

    public void setSubtitleWarning()
    {
        subtitleCss().warningText();
    }

    //##################################################
    //# subtitle 1
    //##################################################

    public void setSubtitle1(String s)
    {
        _subtitle1TextSpan.setValue(s);
    }

    public void setSubtitle1(Function<T,String> e)
    {
        _subtitle1TextSpan.setValue(e);
    }

    public void setSubtitle1(KmMetaProperty<T,String> e)
    {
        _subtitle1TextSpan.setValue(e);
    }

    public void clearSubtitle1()
    {
        _subtitle1TextSpan.clearValue();
    }

    public KmCssDefaultBuilder subtitle1Css()
    {
        return _subtitle1TextSpan.css();
    }

    //##################################################
    //# subtitle 2
    //##################################################

    public void setSubtitle2(String s)
    {
        _subtitle2TextSpan.setValue(s);
    }

    public void setSubtitle2(Function<T,String> e)
    {
        _subtitle2TextSpan.setValue(e);
    }

    public void setSubtitle2(KmMetaProperty<T,String> e)
    {
        _subtitle2TextSpan.setValue(e);
    }

    public void clearSubtitle2()
    {
        _subtitle2TextSpan.clearValue();
    }

    public KmCssDefaultBuilder subtitle2Css()
    {
        return _subtitle2TextSpan.css();
    }

    //##################################################
    //# buttons
    //##################################################

    public ScDiv getButtonBox()
    {
        return _buttonBox;
    }

    //##################################################
    //# menu
    //##################################################

    public ScPopupMenu getMenu()
    {
        return _menu;
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxUpdateValues()
    {
        _titleTextSpan.ajaxReplace();
        _subtitle1TextSpan.ajaxReplace();
        _subtitle2TextSpan.ajaxReplace();
    }
}
