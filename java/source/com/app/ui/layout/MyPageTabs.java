package com.app.ui.layout;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.utility.ScJquery;

import com.app.ui.page.MyMenuRegistry;
import com.app.ui.page.MyPage;

public class MyPageTabs
    extends ScDiv
{
    //##################################################
    //# constants
    //##################################################

    private static final String ITEM_CSS     = KmCssDefaultConstantsIF.appTabsItem;
    private static final String SELECTED_CSS = KmCssDefaultConstantsIF.appTabsSelected;

    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        setHtmlId(KmCssDefaultConstantsIF.ID_appTabs);
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxRefreshContent()
    {
        ajax().setContents(renderContents());
    }

    private KmHtmlBuilder renderContents()
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();

        renderPrefixOn(out);
        renderItemsOn(out);
        renderSuffixOn(out);

        return out;
    }

    private void renderPrefixOn(KmHtmlBuilder out)
    {
        out.printDivCss(KmCssDefaultConstantsIF.appTabsPrefix);
    }

    private void renderSuffixOn(KmHtmlBuilder out)
    {
        out.printDivCss(KmCssDefaultConstantsIF.appTabsSuffix);
    }

    private void renderItemsOn(KmHtmlBuilder out)
    {
        for ( MyMenuItem e : getItems() )
            renderItemOn(out, e);
    }

    private void renderItemOn(KmHtmlBuilder out, MyMenuItem e)
    {
        ScDiv div;
        div = new ScDiv();
        div.setHtmlId(e.getHtmlId());
        div.css().appTabsItem();
        div.addTextSpan(e.getTitle());
        div.setOnClick(e.getClickScript());
        div.renderOn(out);
    }

    //##################################################
    //# menu
    //##################################################

    private KmList<MyMenuItem> getItems()
    {
        KmList<MyMenuItem> results = new KmList<>();

        KmList<MyMenuItem> all = getMenuRegistry().getRoot().getSubMenus();
        for ( MyMenuItem e : all )
            if ( e.isVisible() )
                results.add(e);

        return results;
    }

    private MyMenuRegistry getMenuRegistry()
    {
        return MyMenuRegistry.getInstance();
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
        String sel = ScJquery.formatCssSelector(SELECTED_CSS);
        String css = ITEM_CSS;

        ajax().setCss(sel, css);
    }

    /**
     * Apply the selection css to the menu associated with this page.
     */
    private void _ajaxSetSelection(MyPage page)
    {
        if ( page == null )
            return;

        MyMenuItem menu = page.getPrimaryMenuItem();
        if ( menu == null )
            return;

        String sel = menu.getJquerySelector();
        String css = SELECTED_CSS;

        ajax().setCss(sel, css);
    }

}
