package com.app.ui.layout;

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

        setHtmlId("pageFooter");

        _inner = addDiv();
        _inner.css().pageFooterInner();
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxRefreshContent()
    {
        _inner.ajax().setHtml(MyConstantsIF.COPYRIGHT_HTML);
    }
}
