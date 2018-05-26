package com.app.ui.page.guide.base;

import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScScriptButton;
import com.kodemore.servlet.control.ScTable;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.script.ScSimpleBlockScript;

import com.app.ui.page.MyPage;

public class MySetupGroup
    extends ScGroup
{
    //##################################################
    //# variables
    //##################################################

    ScTable _table;

    //##################################################
    //# constructor
    //##################################################

    public MySetupGroup()
    {
        style().width(300);

        ScDiv body;
        body = getBody();
        body.css().gap20();
    }

    //##################################################
    //# sections
    //##################################################

    public ScControl addPageSection(MyPage page, String title, String description)
    {
        ScDiv e;
        e = getBody();
        e.add(createPagePopoutLink(page, title));
        e.addDiv().addText(description);
        return e;
    }

    //==================================================
    //= rows :: convenience
    //==================================================

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
        js.openWindowUrl(page.formatQueryString());

        ScScriptButton e;
        e = new ScScriptButton();
        e.setFlavorSmallIcon();
        e.setIcon().nameOpenInNew();
        e.setHoverText("Popout");
        e.setScript(js);
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();
    }
}
