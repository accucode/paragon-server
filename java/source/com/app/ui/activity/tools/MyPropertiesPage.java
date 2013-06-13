package com.app.ui.activity.tools;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScGroupArray;
import com.kodemore.servlet.control.ScLiteral;
import com.kodemore.servlet.control.ScText;

import com.app.property.MyPropertyDefinition;
import com.app.property.MyPropertyRegistry;
import com.app.property.base.MyPropertyDefinitions;
import com.app.ui.activity.MyActivity;

public class MyPropertiesPage
    extends MyAbstractToolsPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyActivity instance = new MyPropertiesPage();

    private MyPropertiesPage()
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
    protected ScControl installRoot()
    {
        ScBox root;
        root = new ScBox();

        _literal = root.addLiteral();

        return root;
    }

    //##################################################
    //# start
    //##################################################

    @Override
    public void start()
    {
        preRender();
        print();
    }

    private void preRender()
    {
        MyPropertyRegistry p = getProperties();

        KmList<String> gs;
        gs = MyPropertyDefinitions.getAllGroups();
        gs.sort();

        ScBox root;
        root = new ScBox();
        root.css().padSpaced();

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
