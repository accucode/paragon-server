package com.kodemore.servlet;

import java.util.Iterator;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.utility.ScControlRegistry;
import com.kodemore.utility.Kmu;

public class ScMenuItem
{
    //##################################################
    //# variables
    //##################################################

    private String             _key;

    /**
     * The text to display.
     */
    private String             _text;

    /**
     * The action to run.
     * The action and href are mutually exclusive.
     */
    private ScActionIF         _action;

    /**
     * The href to navigate to.
     * The action and href are mutually exclusive.
     */
    private String             _href;

    private ScMenuItem         _parent;
    private KmList<ScMenuItem> _children;

    //##################################################
    //# constructor
    //##################################################

    public ScMenuItem()
    {
        _key = ScControlRegistry.getInstance().getNextKey();

        _text = "";
        _action = null;

        _parent = null;
        _children = new KmList<ScMenuItem>();
    }

    //##################################################
    //# key
    //##################################################

    public String getKey()
    {
        return _key;
    }

    public boolean hasKey(String e)
    {
        return _key.equals(e);
    }

    //##################################################
    //# text
    //##################################################

    public String getText()
    {
        return _text;
    }

    public void setText(String e)
    {
        _text = e;
    }

    //##################################################
    //# tree
    //##################################################

    public ScMenuItem getParent()
    {
        return _parent;
    }

    public void setParent(ScMenuItem e)
    {
        _parent = e;
    }

    public boolean hasParent()
    {
        return _parent != null;
    }

    public boolean isRoot()
    {
        return _parent == null;
    }

    public ScMenuItem getRoot()
    {
        if ( _parent == null )
            return this;
        return _parent.getRoot();
    }

    public KmList<ScMenuItem> getMenuPath()
    {
        KmList<ScMenuItem> v;
        if ( isRoot() )
            v = new KmList<ScMenuItem>();
        else
            v = getParent().getMenuPath();
        v.add(this);
        return v;
    }

    public int getDepth()
    {
        if ( isRoot() )
            return 0;
        return getParent().getDepth() + 1;
    }

    //##################################################
    //# children
    //##################################################

    public KmList<ScMenuItem> getChildren()
    {
        return _children;
    }

    public boolean hasChildren()
    {
        return getChildren().isNotEmpty();
    }

    public ScMenuItem addChild()
    {
        ScMenuItem e;
        e = new ScMenuItem();
        _children.add(e);
        return e;
    }

    public ScMenuItem addChild(String title)
    {
        ScMenuItem e;
        e = addChild();
        e.setText(title);
        return e;
    }

    public ScMenuItem addChild(String text, String href)
    {
        ScMenuItem e;
        e = addChild();
        e.setText(text);
        e.setHref(href);
        return e;
    }

    public ScMenuItem addChild(String text, ScActionIF action)
    {
        ScMenuItem e;
        e = addChild();
        e.setText(text);
        e.setAction(action);
        return e;
    }

    public ScMenuItem addChild(String text, ScActivity e)
    {
        return addChild(text, e.getStartAction());
    }

    //##################################################
    //# action
    //##################################################

    public ScActionIF getAction()
    {
        return _action;
    }

    public void setAction(ScActionIF e)
    {
        _action = e;
    }

    public boolean hasAction()
    {
        return _action != null;
    }

    //##################################################
    //# href
    //##################################################

    public String getHref()
    {
        return _href;
    }

    public void setHref(String e)
    {
        _href = e;
    }

    public boolean hasHref()
    {
        return Kmu.hasValue(_href);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return getClass().getName() + ":" + _text;
    }

    public String formatPath()
    {
        StringBuilder sb = new StringBuilder();
        Iterator<ScMenuItem> i = getMenuPath().iterator();
        while ( i.hasNext() )
        {
            ScMenuItem e = i.next();
            sb.append(e.getText());
            if ( i.hasNext() )
                sb.append(">");
        }
        return sb.toString();
    }

    //##################################################
    //# support
    //##################################################

    public void error(String msg, Object... args)
    {
        Kmu.fatal(msg, args);
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
        System.out.print(_text);
        System.out.println();
        for ( ScMenuItem e : getChildren() )
            e.printTree(indent + 1);
    }

}
