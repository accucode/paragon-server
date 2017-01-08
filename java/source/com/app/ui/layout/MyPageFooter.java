package com.app.ui.layout;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.control.ScDiv;

import com.app.utility.MyConstantsIF;

public class MyPageFooter
    extends ScDiv
{
    //##################################################
    //# variables
    //##################################################

    private ScDiv _inner;

    //##################################################
    //# constructor
    //##################################################

    public MyPageFooter()
    {
        setHtmlId(KmCssDefaultConstantsIF.ID_footer);

        _inner = addDiv();
        _inner.css().footer_text();
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxRefreshContent(boolean show)
    {
        ajaxShow(show);
        ajaxRefreshContent();
    }

    public void ajaxRefreshContent()
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.printLiteral(MyConstantsIF.COPYRIGHT_HTML);
        out.print(", ");
        out.print(MyConstantsIF.APPLICATION_VERSION);

        _inner.ajaxSetHtml(out);
    }

}
