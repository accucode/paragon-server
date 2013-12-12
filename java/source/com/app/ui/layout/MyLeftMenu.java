package com.app.ui.layout;

import com.kodemore.collection.KmList;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.ScPageRegistry;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScSimpleContainer;
import com.kodemore.servlet.script.ScRootScript;
import com.kodemore.servlet.variable.ScLocalString;

import com.app.ui.core.MyServletData;
import com.app.ui.page.MyPageRegistry;
import com.app.ui.page.admin.MyAdminMenuPage;
import com.app.ui.page.general.MyHomePage;
import com.app.ui.page.test.MyTestMenuPage;
import com.app.ui.page.tools.MyToolsMenuPage;
import com.app.utility.MyGlobals;
import com.app.utility.MyHashBridge;

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

    private ScPage getDefault()
    {
        return MyPageRegistry.getInstance().getHomeActivity();
    }

    //##################################################
    //# ajax
    //##################################################

    /**
     * Refresh the entire menu structure.  This could become relatively
     * significant if we support large, multi-tiered menus.
     */
    public void ajaxRefreshMenu()
    {
        ScSimpleContainer root;
        root = new ScSimpleContainer();

        for ( ScPage e : getList() )
            addMenuTo(root, e);

        String leftCss;
        leftCss = KmCssDefaultConstantsIF.appMenu_box;

        String centerCss;
        centerCss = KmCssDefaultConstantsIF.appMenu_content;

        MyPageLayout layout;
        layout = MyPageLayout.getInstance();
        layout.ajaxSetLeftCss(leftCss);
        layout.ajaxShowLeft(root);
        layout.ajaxSetCenterCss(centerCss);
    }

    private void addMenuTo(ScContainer root, ScPage e)
    {
        ScDiv div;
        div = root.addDiv();
        div.setOnClickHash(e.getNavigationHash());
        div.addText(e.getName());

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

        ajaxRefreshMenu();
    }

    //##################################################
    //# goto
    //##################################################

    /**
     * Updates the browser url in order to force a navigation.  The 
     * actual ui update will be managed during a subsequent callback
     * that is trigged when the url changes.
     */
    public void gotoActivity(ScPage e)
    {
        setSelection(e);

        String hash = e.getNavigationHash();

        if ( getData().hasWindowLocationHash(hash) )
            e.start();
        else
            ajax().gotoHash(hash);
    }

    /**
     * Navigate to the default menu item.  See also, gotoItem(). 
     */
    public void gotoDefault()
    {
        gotoActivity(getDefault());
    }

    /**
     * Navigate to the location indicated by the window's location url.
     * If the window url does not indicate a valid menu, then goto
     * the default location.
     */
    public void gotoWindowLocation()
    {
        String fullHash = getData().getWindowLocationHash();

        MyHashBridge hh = MyHashBridge.getInstance();
        String menuHash = hh.parseMenuHash(fullHash);
        String pageHash = hh.parsePageHash(fullHash);

        ScPageRegistry rr = MyPageRegistry.getInstance();
        ScPage menuActivity = rr.findNavigationHash(menuHash);
        ScPage pageActivity = rr.findNavigationHash(pageHash);

        if ( pageActivity == null )
        {
            gotoDefault();
            return;
        }

        MyLeftMenu mm;
        mm = MyPageLayout.getInstance().getLeftMenu();
        mm.checkSelection(menuActivity, pageActivity);

        pageActivity.start();
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

    //##################################################
    //# support
    //##################################################

    private ScRootScript ajax()
    {
        return getData().ajax();
    }

    private MyServletData getData()
    {
        return MyGlobals.getData();
    }

}
