package com.app.ui.page.tools;

import com.kodemore.collection.KmList;
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

public class MyDevApplicationPropertiesPage
    extends MyDevAbstractPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyDevApplicationPropertiesPage instance = new MyDevApplicationPropertiesPage();

    private MyDevApplicationPropertiesPage()
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
    //# navigation
    //##################################################

    @Override
    public ScParameterList composeQueryParameters()
    {
        return null;
    }

    @Override
    public void applyQueryParameters(ScParameterList v)
    {
        // none
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
