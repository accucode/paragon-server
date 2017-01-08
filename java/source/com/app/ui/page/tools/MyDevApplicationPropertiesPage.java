package com.app.ui.page.tools;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScText;
import com.kodemore.servlet.control.ScTransientContainer;

import com.app.property.MyPropertyDefinition;
import com.app.property.MyProperties;
import com.app.property.base.MyPropertyDefinitions;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyDevApplicationPropertiesPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyDevApplicationPropertiesPage _instance;

    public static void installInstance()
    {
        _instance = new MyDevApplicationPropertiesPage();
    }

    public static MyDevApplicationPropertiesPage getInstance()
    {
        return _instance;
    }

    private MyDevApplicationPropertiesPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScTransientContainer _container;

    //##################################################
    //# settings
    //##################################################

    @Override
    public final MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.developer;
    }

    //##################################################
    //# bookmark
    //##################################################

    @Override
    public void composeBookmarkOn(ScParameterList v)
    {
        // none
    }

    @Override
    public void applyBookmark(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().fill().auto().columnSpacer10();

        _container = root.addTransientContainer();
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        MyProperties p = getProperties();

        KmList<String> groupNames;
        groupNames = MyPropertyDefinitions.getAllGroups();
        groupNames.sort();

        for ( String groupName : groupNames )
        {
            ScGroup group;
            group = _container.addGroup(groupName);

            ScFieldTable fields;
            fields = group.getBody().addPad().addFieldTable();

            KmList<MyPropertyDefinition> defs = getDefs(groupName);
            for ( MyPropertyDefinition def : defs )
            {
                String key = def.getKey();
                Object value = def.getObjectFor(p);

                ScText text;
                text = fields.addText(" = " + value);
                text.setLabel(key);
            }
        }
    }

    private KmList<MyPropertyDefinition> getDefs(String group)
    {
        KmList<MyPropertyDefinition> v;
        v = MyPropertyDefinitions.getAllInGroup(group);
        v.sortOn(e -> e.getKey());
        return v;
    }

}
