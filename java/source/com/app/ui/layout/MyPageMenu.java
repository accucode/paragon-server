package com.app.ui.layout;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.utility.ScJquery;

import com.app.ui.page.MyMenuRegistry;
import com.app.ui.page.MyPage;

public class MyPageMenu
    extends ScDiv
{
    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        setHtmlId(KmCssDefaultConstantsIF.ID_appMenu);
        css().appMenu();
    }

    //##################################################
    //# selection
    //##################################################

    /**
     * Update the selection and refresh the ui.
     */
    public void ajaxRefreshSelection(MyPage page)
    {
        _ajaxClearSelection();
        _ajaxSetSelection(page);
    }

    /**
     * Clear the selection css from all menu items.
     */
    private void _ajaxClearSelection()
    {
        String sel = ScJquery.formatCssSelector(KmCssDefaultConstantsIF.appMenu_selection);
        String css = KmCssDefaultConstantsIF.appMenu_item;

        ajax().setCss(sel, css);
    }

    /**
     * Apply the selection css to the menu associated with this page.
     */
    private void _ajaxSetSelection(MyPage page)
    {
        if ( page == null )
            return;

        MyMenuItem item = page.getSecondaryMenuItem();
        if ( item == null )
            return;

        String sel = item.getJquerySelector();
        String css = KmCssDefaultConstantsIF.appMenu_selection;

        ajax().setCss(sel, css);
        ajax().scrollToIfOffScreen(sel);
    }

    //##################################################
    //# refresh
    //##################################################

    public void ajaxRefreshContentFor(ScPage page)
    {
        ajax().setContents(renderSections(page));
    }

    //##################################################
    //# render
    //##################################################

    private KmHtmlBuilder renderSections(ScPage page)
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();

        MyMenuItem top = MyMenuRegistry.getInstance().findTopMenuFor(page);
        if ( top == null )
            return out;

        for ( MyMenuItem e : top.getSubMenus() )
            renderSectionOn(out, e);

        return out;
    }

    private void renderSectionOn(KmHtmlBuilder out, MyMenuItem section)
    {
        if ( !section.isVisible() )
            return;

        ScDiv div;
        div = new ScDiv();
        div.setHtmlId(section.getHtmlId());
        div.addText(section.getTitle());
        div.css().appMenu_section();
        div.renderOn(out);

        for ( MyMenuItem item : section.getSubMenus() )
            renderItemOn(out, item);
    }

    private void renderItemOn(KmHtmlBuilder out, MyMenuItem e)
    {
        if ( !e.isVisible() )
            return;

        ScDiv div;
        div = new ScDiv();
        div.setHtmlId(e.getHtmlId());
        div.addTextSpan(e.getTitle());
        div.setOnClick(e.getClickScript());
        div.css().appMenu_item();
        div.renderOn(out);
    }

}
