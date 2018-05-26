package com.app.ui.page.menu;

import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.page.MyPage;

/**
 * I act as a full page menu for navigation that doesn't fit in the top menu..
 */
public abstract class MyMenuPage
    extends MyPage
{
    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().auto();

        KmCssDefaultBuilder css;
        css = root.css();
        css.flexRow().flexCrossAlignStart().flexWrap().flexWrapAlignStart();
        css.postMargin20();

        installMenus();
    }

    protected abstract void installMenus();

    protected abstract Integer getGroupWidth();

    protected abstract Integer getGroupHeight();

    //##################################################
    //# render
    //##################################################

    @Override
    protected final void preRender()
    {
        // none
    }

    //##################################################
    //# support
    //##################################################

    protected ScContainer addMenu(String title)
    {
        ScGroup group;
        group = getRoot().addGroup(title);

        Integer w = getGroupWidth();
        if ( w != null )
            group.style().width(w);

        Integer h = getGroupHeight();
        if ( h != null )
            group.style().height(h);

        ScDiv body;
        body = group.getBody();
        body.css().pad().auto().noWrap();
        body.css().flexColumn().columnSpacer5();
        return body;
    }

}
