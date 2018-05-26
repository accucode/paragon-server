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
    //# constructor
    //##################################################

    public MyPageContent()
    {
        setHtmlId(KmCssDefaultConstantsIF.ID_content);

        _inner = addDiv();
        _inner.setHtmlId(KmCssDefaultConstantsIF.ID_content_inner);
    }

    //##################################################
    //# accessing
    //##################################################

    public ScDiv getInner()
    {
        return _inner;
    }
}
