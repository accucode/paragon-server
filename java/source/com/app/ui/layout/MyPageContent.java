package com.app.ui.layout;

import com.kodemore.servlet.control.ScDiv;

public class MyPageContent
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

        setHtmlId("pageContent");

        _inner = addDiv();
        _inner.setHtmlId("pageContentInner");
        _inner.css().pageContentInner();
    }

    //##################################################
    //# accessing
    //##################################################

    public ScDiv getInner()
    {
        return _inner;
    }
}
