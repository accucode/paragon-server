package com.app.ui.page.tools;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScLiteral;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScText;

import com.app.property.MyPropertyDefinition;
import com.app.property.MyPropertyRegistry;
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

    private ScLiteral _literal;

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
        _literal = root.addLiteral();
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        MyPropertyRegistry p = getProperties();

        KmList<String> gs;
        gs = MyPropertyDefinitions.getAllGroups();
        gs.sort();

        ScBox root;
        root = new ScBox();
        root.css().gap();

        for ( String g : gs )
        {
            ScGroup group;
            group = root.addGroup(g);

            ScFieldTable fields;
            fields = group.getBody().addPad().addFieldTable();

            KmList<MyPropertyDefinition> defs = getDefs(g);
            for ( MyPropertyDefinition def : defs )
            {
                String key = def.getKey();
                Object value = def.getObjectFor(p);

                ScText text;
                text = fields.addText(" = " + value);
                text.setLabel(key);
            }
        }

        KmHtmlBuilder html = root.render();
        _literal.setValue(html);
    }

    private KmList<MyPropertyDefinition> getDefs(String group)
    {
        KmList<MyPropertyDefinition> defs;
        defs = MyPropertyDefinitions.getAllInGroup(group);

        MyPropertyDefinition.sortOnKey(defs);
        return defs;
    }

}
