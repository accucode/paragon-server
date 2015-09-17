package com.app.tools;

import com.kodemore.collection.KmList;

import com.app.property.MyPropertyDefinition;
import com.app.property.MyPropertyRegistry;
import com.app.property.base.MyPropertyDefinitions;
import com.app.utility.MyConstantsIF;
import com.app.utility.MyGlobals;
import com.app.utility.MyInstaller;

public class MyPropertyPrinter
{
    public static void main(String[] args)
    {
        System.out.printf(
            "%s (%s)%n%n",
            MyConstantsIF.APPLICATION_NAME,
            MyConstantsIF.APPLICATION_VERSION);

        MyInstaller.installCore();
        MyPropertyRegistry p = MyGlobals.getProperties();

        KmList<String> groups;
        groups = MyPropertyDefinitions.getAllGroups();
        groups.sort();

        for ( String group : groups )
        {
            System.out.println("\nGROUP: " + group);

            KmList<MyPropertyDefinition> defs;
            defs = MyPropertyDefinitions.getAllInGroup(group);
            defs.sort();

            for ( MyPropertyDefinition def : defs )
            {
                String key = def.getKey();
                Object value = def.getObjectFor(p);
                System.out.printf("  %s = %s%n", key, value);
            }
        }
    }
}
