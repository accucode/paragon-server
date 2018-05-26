package com.app.ui.layout;

import java.util.Iterator;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.ScPage;
import com.kodemore.utility.Kmu;

public class MyMenuItem
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The text to display.
     */
    private String _title;

    /**
     * The page this menu item opens.
     */
    private ScPage _page;

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

    /**
     * Extra css to be included in the menu.
     */
    private String _css;

    /**
     * If true, show a divider ABOVE this item.
     * If this item is hidden, so is the divider.
     */
    private boolean _topDivider;

    /**
     * If true, show a divider BELOW this item.
     * If this item is hidden, so is the divider.
     */
    private boolean _bottomDivider;

    //##################################################
    //# constructor
    //##################################################

    public MyMenuItem()
    {
        _children = new KmList<>();
        _depth = -1;
        _css = null;
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
    //# top divider
    //##################################################

    public boolean getTopDivider()
    {
        return _topDivider;
    }

    public void setTopDivider()
    {
        _topDivider = true;
    }

    //##################################################
    //# bottom divider
    //##################################################

    public boolean getBottomDivider()
    {
        return _bottomDivider;
    }

    public void setBottomDivider()
    {
        _bottomDivider = true;
    }

    //##################################################
    //# css
    //##################################################

    public String getCss()
    {
        return _css;
    }

    public void setCss(String e)
    {
        _css = e;
    }

    public boolean hasCss()
    {
        return Kmu.hasValue(getCss());
    }

    //##################################################
    //# page
    //##################################################

    public ScPage getPage()
    {
        return _page;
    }

    public void setPage(ScPage e)
    {
        _page = e;
    }

    public boolean hasPage()
    {
        return _page != null;
    }

    public String getPageKey()
    {
        return hasPage()
            ? getPage().getKey()
            : null;
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
        if ( page == null )
            throw Kmu.newFatal("Page is null. Did you update the page registry?");

        MyMenuItem e;
        e = addMenu();
        e.setTitle(title);
        e.setPage(page);
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

    public MyMenuItem getPrimary()
    {
        if ( isTop() )
            return this;

        if ( isRoot() )
            return null;

        return getParent().getPrimary();
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

    public MyMenuItem getSecondary()
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
        System.out.printf("%s, key(%s), visible(%s)%n", getTitle(), isVisible());

        for ( MyMenuItem e : getSubMenus() )
            e.printTree(indent + 1);
    }

    //##################################################
    //# security
    //##################################################

    public boolean isVisible()
    {
        if ( hasPage() )
            if ( isVisible(getPage()) )
                return true;

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
