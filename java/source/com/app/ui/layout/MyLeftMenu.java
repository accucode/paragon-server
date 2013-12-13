package com.app.ui.layout;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.ScPageRegistry;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScSimpleContainer;
import com.kodemore.servlet.variable.ScLocalString;

import com.app.ui.page.admin.MyAdminMenuPage;
import com.app.ui.page.general.MyHomePage;
import com.app.ui.page.test.MyTestMenuPage;
import com.app.ui.page.tools.MyToolsMenuPage;

public class MyLeftMenu
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalString _selectedKey;

    //##################################################
    //# constructor
    //##################################################

    public MyLeftMenu()
    {
        _selectedKey = new ScLocalString();
        _selectedKey.setAutoSave();
    }

    //##################################################
    //# basics
    //##################################################

    private KmList<ScPage> getList()
    {
        KmList<ScPage> v;
        v = new KmList<ScPage>();

        v.add(MyHomePage.instance);
        v.add(MyAdminMenuPage.instance);
        v.add(MyToolsMenuPage.instance);
        v.add(MyTestMenuPage.instance);

        return v;
    }

    //##################################################
    //# ajax
    //##################################################

    /**
     * Render the entire menu structure.  This could become relatively
     * significant if we support large, multi-tiered menus.
     */
    public KmHtmlBuilder render()
    {
        ScSimpleContainer root;
        root = new ScSimpleContainer();

        for ( ScPage e : getList() )
            addMenuTo(root, e);

        return root.render();
    }

    public String getMenuCss()
    {
        return KmCssDefaultConstantsIF.appMenu_box;
    }

    public String getContentCss()
    {
        return KmCssDefaultConstantsIF.appMenu_content;
    }

    private void addMenuTo(ScContainer root, ScPage e)
    {
        ScDiv div;
        div = root.addDiv();
        div.addText(e.getTitle());
        div.setOnClickPush(e);

        if ( isSelected(e) )
            div.css().appMenu_selectedItem();
        else
            div.css().appMenu_item();
    }

    /**
     * Refresh the current menu selection.  This assumes that the 
     * menu is already installed and we need only to update the visual
     * selection.
     * 
     * (For now we simply refresh the _entire_ menu.)
     */
    public void ajaxRefreshSelection(ScPage e)
    {
        setSelection(e);

        // todo_wyatt: menu refresh?
        // ajaxRefreshMenu();
    }

    //##################################################
    //# selection
    //##################################################

    public ScPage getSelection()
    {
        String key = getSelectedKey();
        if ( key == null )
            return null;

        return ScPageRegistry.getInstance().findKey(key);
    }

    public String getSelectedKey()
    {
        return _selectedKey.getValue();
    }

    private void setSelection(ScPage e)
    {
        _selectedKey.setValue(e.getKey());
    }

    private boolean isSelected(ScPage e)
    {
        return e.hasKey(_selectedKey.getValue());
    }

    /**
     * Update the selection and refresh the ui, but only if the
     * requested activity is part of the menu.
     */
    public boolean checkSelection(ScPage primary, ScPage alternate)
    {
        if ( checkSelection(primary) )
            return true;

        if ( checkSelection(alternate) )
            return true;

        return false;
    }

    /**
     * Update the selection and refresh the ui, but only if the
     * requested activity is part of the menu.
     */
    public boolean checkSelection(ScPage e)
    {
        if ( !isMenuItem(e) )
            return false;

        setSelection(e);
        ajaxRefreshSelection(e);
        return true;
    }

    public boolean isMenuItem(ScPage a)
    {
        for ( ScPage e : getList() )
            if ( e.equals(a) )
                return true;

        return false;
    }
}
