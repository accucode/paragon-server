package com.app.ui.page.guide.base;

import com.kodemore.servlet.control.ScDiv;

import com.app.ui.page.MySecurityLevel;

/**
 * A section of a guide group containing simple text.
 * The section contains a bold label and a description.
 */
public class MyGuideTextSection
    extends MyAbstractGuideSection
{
    //##################################################
    //# constructor
    //##################################################

    public MyGuideTextSection(String title, String description)
    {
        ScDiv e;
        e = this;
        e.css().flexChildStatic().flexColumn().columnSpacer5();
        e.addLabel(title);
        e.addDiv().addText(description);
    }

    //##################################################
    //# security
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.none;
    }
}
