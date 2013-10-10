package com.app.ui.activity.tools;

import com.app.property.MyPropertyDefinition;
import com.app.property.MyPropertyRegistry;
import com.app.property.base.MyPropertyDefinitions;
import com.app.ui.activity.MyActivity;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScGroupArray;
import com.kodemore.servlet.control.ScLiteral;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScText;

public class MyApplicationPropertiesPage
    extends MyToolsPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyActivity instance = new MyApplicationPropertiesPage();

    private MyApplicationPropertiesPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScLiteral _literal;

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        _literal = root.addLiteral();
    }

    //##################################################
    //# prePrint
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

        ScGroupArray groups;
        groups = root.addGroupArray();

        for ( String g : gs )
        {
            ScGroup group;
            group = groups.addGroup(g);

            ScFieldTable fields;
            fields = group.addPad().addFields();

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
        _literal.setValue(root.render());
    }

    private KmList<MyPropertyDefinition> getDefs(String group)
    {
        KmList<MyPropertyDefinition> defs;
        defs = MyPropertyDefinitions.getAllInGroup(group);

        MyPropertyDefinition.sortOnKey(defs);
        return defs;
    }

}
