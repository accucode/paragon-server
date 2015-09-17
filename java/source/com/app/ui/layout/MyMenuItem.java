package com.app.ui.layout;

import java.util.Iterator;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.script.ScSimpleBlockScript;
import com.kodemore.servlet.utility.ScControlRegistry;
import com.kodemore.servlet.utility.ScJquery;
import com.kodemore.utility.Kmu;

public class MyMenuItem
{
    //##################################################
    //# variables
    //##################################################

    /**
     * A unique key, useful for things like the htmlId.
     * We cannot rely on the page key, since not all menus
     * have a direct page.
     */
    private String _key;
    /**
     * The text to display.
     */
    private String _title;

    /**
     * The page this menu item opens.
     *
     * Multiple pages can be added.  The first page is the 'primary' page and is the
     * page that will be opened when the menu is selected.
     *
     * The additional pages are used for reverse navigation.  In some cases, we may
     * not navigate directly to each page from the menu, but instead navigate from one
     * page to another, under the same menu.  In this case, all of the sub pages should
     * be added to the menu.  This allows the application to correctly display and/or
     * highlight the correct menu option when navigation is performed via the browser
     * navigation bar or back button.
     */
    private KmList<ScPage> _pages;

    /**
     * The parent menu.  Used to navigate the hierarchy from any starting point.
     */
    private MyMenuItem _parent;

    /**
     * The nested child menus.
     * This is implemented as a recursive composite.
     * In practice, the application will limit the maximum depth.
     */
    private KmList<MyMenuItem> _children;

    /**
     * The depth of this item in the tree.  This is a cached value, and
     * assumes that the trees composition is static once created.
     */
    private int _depth;

    //##################################################
    //# constructor
    //##################################################

    public MyMenuItem()
    {
        _key = ScControlRegistry.getInstance().getNextKey();
        _pages = new KmList<>();
        _children = new KmList<>();
        _depth = -1;
    }

    //##################################################
    //# key
    //##################################################

    public String getKey()
    {
        return _key;
    }

    //##################################################
    //# title
    //##################################################

    public String getTitle()
    {
        return _title;
    }

    public void setTitle(String e)
    {
        _title = e;
    }

    public boolean hasTitle()
    {
        return Kmu.hasValue(getTitle());
    }

    //##################################################
    //# page
    //##################################################

    public KmList<ScPage> getPages()
    {
        return _pages;
    }

    public boolean hasPages()
    {
        return getPages().isNotEmpty();
    }

    public void addPage(ScPage e)
    {
        _pages.add(e);
    }

    public KmList<String> getPageKeys()
    {
        KmList<String> keys = new KmList<>();

        for ( ScPage e : getPages() )
            keys.add(e.getKey());

        return keys;
    }

    public ScPage getEffectivePage()
    {
        if ( hasPages() )
        {
            ScPage e = getPages().getFirst();
            if ( isVisible(e) )
                return e;
        }

        for ( MyMenuItem e : getSubMenus() )
        {
            ScPage p = e.getEffectivePage();
            if ( p != null )
                return p;
        }

        return null;
    }

    //##################################################
    //# parent
    //##################################################

    public MyMenuItem getParent()
    {
        return _parent;
    }

    public void setParent(MyMenuItem e)
    {
        _parent = e;
    }

    public boolean hasParent()
    {
        return _parent != null;
    }

    //##################################################
    //# children
    //##################################################

    public KmList<MyMenuItem> getSubMenus()
    {
        return _children;
    }

    public boolean hasSubMenus()
    {
        return getSubMenus().isNotEmpty();
    }

    public MyMenuItem addMenu()
    {
        MyMenuItem e;
        e = new MyMenuItem();
        e.setParent(this);
        _children.add(e);
        return e;
    }

    public MyMenuItem addMenu(String title)
    {
        MyMenuItem e;
        e = addMenu();
        e.setTitle(title);
        return e;
    }

    public MyMenuItem addMenu(String title, ScPage page)
    {
        MyMenuItem e;
        e = addMenu();
        e.setTitle(title);
        e.addPage(page);
        return e;
    }

    public MyMenuItem addMenu(ScPage page)
    {
        return addMenu(page.getTitle(), page);
    }

    //##################################################
    //# tree
    //##################################################

    public boolean isRoot()
    {
        return _parent == null;
    }

    public MyMenuItem getRoot()
    {
        if ( _parent == null )
            return this;

        return _parent.getRoot();
    }

    /**
     * Identifies menu items that are considered to be the "top-level" menus.
     *
     * This is NOT the same as the 'root', which is typically ignored and only used
     * to compose the recursive composite.
     */
    public boolean isTop()
    {
        return getDepth() == 1;
    }

    public MyMenuItem getTop()
    {
        if ( isTop() )
            return this;

        if ( isRoot() )
            return null;

        return getParent().getTop();
    }

    public KmList<MyMenuItem> getMenuPath()
    {
        return getParentMenuPath().with(this);
    }

    private KmList<MyMenuItem> getParentMenuPath()
    {
        if ( hasParent() )
            return getParent().getMenuPath();

        return new KmList<>();
    }

    public boolean isLeaf()
    {
        return !hasSubMenus();
    }

    public MyMenuItem getLeftItem()
    {
        if ( getDepth() == 3 )
            return this;

        return null;
    }

    //##################################################
    //# depth
    //##################################################

    public int getDepth()
    {
        if ( _depth < 0 )
            return _depth = computeDepth();

        return _depth;
    }

    private int computeDepth()
    {
        if ( isRoot() )
            return 0;

        return getParent().getDepth() + 1;
    }

    public int getMaximumDepth()
    {
        int i = getDepth();

        for ( MyMenuItem e : getSubMenus() )
            i = Math.max(i, e.getMaximumDepth());

        return i;
    }

    //##################################################
    //# collect
    //##################################################

    public KmList<String> collectPageKeys()
    {
        KmList<String> v = new KmList<>();
        collectPageKeysOn(v);
        return v;
    }

    private void collectPageKeysOn(KmList<String> out)
    {
        out.addAll(getPageKeys());

        for ( MyMenuItem e : getSubMenus() )
            e.collectPageKeysOn(out);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return "MenuItem(" + getTitle() + ")";
    }

    public String formatPath()
    {
        StringBuilder out = new StringBuilder();

        Iterator<MyMenuItem> i = getMenuPath().iterator();
        while ( i.hasNext() )
        {
            MyMenuItem e = i.next();
            out.append(e.getTitle());

            if ( i.hasNext() )
                out.append(">");
        }

        return out.toString();
    }

    //##################################################
    //# print
    //##################################################

    public void printTree()
    {
        printTree(0);
    }

    public void printTree(int indent)
    {
        System.out.print(Kmu.repeat("    ", indent));
        System.out.printf(
            "%s, key(%s), pages(%s), visible(%s)\n",
            getTitle(),
            getKey(),
            getPages().size(),
            isVisible());

        for ( MyMenuItem e : getSubMenus() )
            e.printTree(indent + 1);
    }

    //##################################################
    //# html
    //##################################################

    public String getHtmlId()
    {
        return "menu-" + getKey();
    }

    public String getJquerySelector()
    {
        return ScJquery.formatIdSelector(getHtmlId());
    }

    public ScBlockScript getClickScript()
    {
        ScBlockScript e;
        e = new ScSimpleBlockScript();
        e.enterPage(getEffectivePage());
        return e;
    }

    //##################################################
    //# security
    //##################################################

    public boolean isVisible()
    {
        if ( hasPages() )
        {
            ScPage e = getPages().getFirst();
            return isVisible(e);
        }

        for ( MyMenuItem e : getSubMenus() )
            if ( e.isVisible() )
                return true;

        return false;
    }

    private boolean isVisible(ScPage e)
    {
        return e.checkSecuritySilently();
    }
}
