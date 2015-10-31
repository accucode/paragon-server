package com.app.ui.layout;

import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
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

        setHtmlId(KmCssDefaultConstantsIF.ID_appContent);

        _inner = addDiv();
        _inner.setHtmlId(KmCssDefaultConstantsIF.ID_appContentInner);
        _inner.css().appContentInner();
    }

    //##################################################
    //# accessing
    //##################################################

    public ScDiv getInner()
    {
        return _inner;
    }
}
