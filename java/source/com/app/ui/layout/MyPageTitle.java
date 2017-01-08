package com.app.ui.layout;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScImage;
import com.kodemore.servlet.control.ScTextSpan;

public class MyPageTitle
    extends ScDiv
{
    //##################################################
    //# variables
    //##################################################

    private ScDiv      _left;
    private ScTextSpan _nameText;

    private ScDiv      _right;
    private ScImage    _helpImage;

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

        _right = addDiv();
        _right.css().title_right();

        _helpImage = _right.addImage();
        _helpImage.css().title_help();
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
    }

    private KmHtmlBuilder formatNameHtml(ScPage page)
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.print(page.getTitle());
        return out;
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
}
