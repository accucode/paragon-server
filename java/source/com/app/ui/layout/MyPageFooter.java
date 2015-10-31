package com.app.ui.layout;

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
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        setHtmlId(KmCssDefaultConstantsIF.ID_appFooter);

        _inner = addDiv();
        _inner.css().appFooterInner();
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxRefreshContent()
    {
        _inner.ajax().setHtml(MyConstantsIF.COPYRIGHT_HTML);
    }
}
