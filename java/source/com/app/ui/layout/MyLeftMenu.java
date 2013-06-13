package com.app.ui.layout;

import com.kodemore.collection.KmList;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.ScActivity;
import com.kodemore.servlet.ScActivityRegistry;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScSimpleContainer;
import com.kodemore.servlet.script.ScScript;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.Kmu;

import com.app.ui.activity.MyActivityRegistry;
import com.app.ui.activity.admin.MyAdminPage;
import com.app.ui.activity.general.MyHomePage;
import com.app.ui.activity.test.MyTestPage;
import com.app.ui.activity.tools.MyToolsPage;
import com.app.ui.core.MyServletData;
import com.app.utility.MyGlobals;
import com.app.utility.MyHashBridge;

public class MyLeftMenu
{
    //##################################################
    //# install
    //##################################################

    private static MyLeftMenu _instance;

    public static void install()
    {
        if ( _instance != null )
            Kmu.fatal("Already installed.");

        _instance = new MyLeftMenu();
    }

    public static MyLeftMenu getInstance()
    {
        return _instance;
    }

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

    private KmList<ScActivity> getList()
    {
        KmList<ScActivity> v;
        v = new KmList<ScActivity>();

        v.add(MyHomePage.instance);
        v.add(MyAdminPage.instance);
        v.add(MyToolsPage.instance);
        v.add(MyTestPage.instance);

        return v;
    }

    private ScActivity getDefault()
    {
        return MyTestPage.instance;
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

        for ( ScActivity e : getList() )
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

    private void addMenuTo(ScContainer root, ScActivity e)
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
    public void ajaxRefreshSelection(ScActivity e)
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
    public void gotoActivity(ScActivity e)
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

        ScActivityRegistry rr = MyActivityRegistry.getInstance();
        ScActivity menuActivity = rr.findNavigationHash(menuHash);
        ScActivity pageActivity = rr.findNavigationHash(pageHash);

        if ( pageActivity == null )
        {
            gotoDefault();
            return;
        }

        MyLeftMenu mm;
        mm = MyLeftMenu.getInstance();
        mm.checkSelection(menuActivity, pageActivity);

        pageActivity.start();
    }

    //##################################################
    //# selection
    //##################################################

    public ScActivity getSelection()
    {
        String key = getSelectedKey();
        if ( key == null )
            return null;

        return ScActivityRegistry.getInstance().findKey(key);
    }

    public String getSelectedKey()
    {
        return _selectedKey.getValue();
    }

    private void setSelection(ScActivity e)
    {
        _selectedKey.setValue(e.getKey());
    }

    private boolean isSelected(ScActivity e)
    {
        return e.hasKey(_selectedKey.getValue());
    }

    /**
     * Update the selection and refresh the ui, but only if the
     * requested activity is part of the menu.
     */
    public boolean checkSelection(ScActivity primary, ScActivity alternate)
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
    public boolean checkSelection(ScActivity e)
    {
        if ( !isMenuItem(e) )
            return false;

        setSelection(e);
        ajaxRefreshSelection(e);
        return true;
    }

    public boolean isMenuItem(ScActivity a)
    {
        for ( ScActivity e : getList() )
            if ( e.equals(a) )
                return true;

        return false;
    }

    //##################################################
    //# support
    //##################################################

    private ScScript ajax()
    {
        return getData().ajax();
    }

    private MyServletData getData()
    {
        return MyGlobals.getData();
    }

}
