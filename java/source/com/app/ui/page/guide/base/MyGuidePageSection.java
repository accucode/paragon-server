package com.app.ui.page.guide.base;

import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScScriptButton;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.script.ScSimpleBlockScript;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

/**
 * A section of a guide group for use with a page.  The section contains
 * a link, a popout button and a description.  The security level of this
 * section is delegated to the page.
 */
public class MyGuidePageSection
    extends MyAbstractGuideSection
{
    //##################################################
    //# variables
    //##################################################

    private MyPage _page;

    //##################################################
    //# constructor
    //##################################################

    public MyGuidePageSection(MyPage page, String title, String description)
    {
        _page = page;

        ScDiv e;
        e = this;
        e.css().flexChildStatic().flexColumn().columnSpacer5();
        e.add(createPagePopoutLink(page, title));
        e.addDiv().addText(description);
    }

    //##################################################
    //# install
    //##################################################

    protected ScControl createPagePopoutLink(MyPage page, String name)
    {
        ScDiv div;
        div = new ScDiv();
        div.css().flexRow().flexCrossAlignCenter().rowSpacer5();
        div.addLink(name, page);
        div.add(createPagePopoutButton(page));
        return div;
    }

    protected ScControl createPagePopoutButton(ScPage page)
    {
        ScBlockScript js;
        js = ScSimpleBlockScript.create();
        js.openWindowUrl(page.formatQueryString(false));

        ScScriptButton e;
        e = new ScScriptButton();
        e.setFlavorSmallIcon();
        e.setIcon().nameOpenInNew();
        e.setHoverText("Popout");
        e.setScript(js);
        return e;
    }

    //##################################################
    //# security
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return _page.getSecurityLevel();
    }
}
