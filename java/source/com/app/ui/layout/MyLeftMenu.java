package com.app.ui.layout;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.utility.ScJquery;

import com.app.ui.core.MyServletData;
import com.app.ui.page.MyPage;
import com.app.utility.MyGlobals;

public class MyLeftMenu
{
    //##################################################
    //# constants
    //##################################################

    private static final String ID_PREFIX = "leftMenu";

    //##################################################
    //# ajax
    //##################################################

    /**
     * Render the entire menu structure.  This could become relatively
     * significant if we support large, multi-tiered menus.
     */
    public KmHtmlBuilder render()
    {
        ScDiv root;
        root = new ScDiv();
        root.setHtmlId(getWrapperId());
        root.css().leftMenu_box();

        for ( MyLeftMenuItem e : MyLeftMenuItem.getValues() )
            renderItemOn(root, e);

        return root.render();
    }

    private void renderItemOn(ScContainer root, MyLeftMenuItem e)
    {
        ScDiv div;
        div = root.addDiv();
        div.setHtmlId(getItemId(e));
        div.addText(e.getTitle());
        div.setOnClick(e.getAction());
        div.css().leftMenu_item();
    }

    //##################################################
    //# ids
    //##################################################

    private String getWrapperId()
    {
        return ID_PREFIX;
    }

    private String getItemId(MyLeftMenuItem e)
    {
        return getWrapperId() + "-" + e.getKey();
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
        String sel = ScJquery.formatCssSelector(KmCssDefaultConstantsIF.leftMenu_item);
        String css = KmCssDefaultConstantsIF.leftMenu_selected;

        ajax().removeCss(sel, css);
    }

    /**
     * Apply the selection css to the menu associated with this page.
     */
    private void _ajaxSetSelection(MyPage page)
    {
        if ( page == null )
            return;

        MyLeftMenuItem item = page.getMenuItem();
        if ( item == null )
            return;

        String sel = ScJquery.formatIdSelector(getItemId(item));
        String css = KmCssDefaultConstantsIF.leftMenu_selected;

        ajax().addCss(sel, css);
    }

    //##################################################
    //# support
    //##################################################

    private MyServletData getData()
    {
        return MyGlobals.getData();
    }

    private ScBlockScript ajax()
    {
        return getData().ajax();
    }

}
