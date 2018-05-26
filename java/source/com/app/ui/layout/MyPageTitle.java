package com.app.ui.layout;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScImage;
import com.kodemore.servlet.control.ScTextSpan;
import com.kodemore.utility.Kmu;

import com.app.ui.dialog.MyDialogs;
import com.app.ui.page.MyPage;

public class MyPageTitle
    extends ScDiv
{
    //##################################################
    //# variables
    //##################################################

    private ScDiv      _left;
    private ScTextSpan _nameText;
    private ScTextSpan _pageModuleName;

    private ScDiv          _right;
    private ScActionButton _feedbackButton;
    private ScImage        _helpImage;

    //##################################################
    //# constructor
    //##################################################

    public MyPageTitle()
    {
        setHtmlId(KmCssDefaultConstantsIF.ID_title);

        _left = addDiv();
        _left.css().title_left();

        _nameText = _left.addTextSpan();
        _nameText.css().title_nameText();

        _pageModuleName = _left.addTextSpan();
        _pageModuleName.css().title_pageModuleName();

        _right = addDiv();
        _right.css().title_right();

        _feedbackButton = _right.addButton();
        _feedbackButton.setAction(newUncheckedAction(this::handleFeedback));
        _feedbackButton.setFlavorIcon();
        _feedbackButton.setIcon().nameFeedback().styleDark();
        _feedbackButton.setHoverText("Report a problem");

        _helpImage = _right.addImage();
        _helpImage.css().title_help().helpTooltip();
        _helpImage.style().hide();
    }

    //##################################################
    //# refresh
    //##################################################

    public void ajaxRefreshContentFor(ScPage page, boolean visible)
    {
        ajaxShow(visible);
        ajaxRefreshContentFor(page);
    }

    public void ajaxRefreshContentFor(ScPage page)
    {
        _ajaxRefreshTitleFor(page);
        _ajaxRefreshHelpFor(page);
    }

    private void _ajaxRefreshTitleFor(ScPage page)
    {
        _nameText.ajaxSetContents(formatNameHtml(page));

        preRenderModuleName(page);
        _pageModuleName.ajaxReplace();
    }

    private KmHtmlBuilder formatNameHtml(ScPage page)
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.print(page.getTitle());
        return out;
    }

    private void preRenderModuleName(ScPage page)
    {
        _pageModuleName.clearValue();

        if ( page instanceof MyPage )
        {
            MyPage e = (MyPage)page;

            String name = e.hasModuleName()
                ? Kmu.formatMetaValue(e.getModuleName())
                : null;

            _pageModuleName.setValue(name);
            _pageModuleName.setHoverText(e.getModuleHelp());
        }
    }

    private void _ajaxRefreshHelpFor(ScPage page)
    {
        if ( !page.hasHelpMessage() )
        {
            _helpImage.ajaxHide();
            return;
        }

        _helpImage.ajaxSetAttribute("title", page.getHelpMessage());
        _helpImage.ajaxShow();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleFeedback()
    {
        MyDialogs.getFeedbackDialog().ajaxOpen();
    }
}
