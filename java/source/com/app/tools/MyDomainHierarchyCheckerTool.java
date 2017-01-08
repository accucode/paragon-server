package com.app.tools;

import com.kodemore.collection.KmList;
import com.kodemore.log.KmLog;

import com.app.model.base.MyModelType;
import com.app.model.core.MyProjectDomainIF;
import com.app.model.core.MySystemDomainIF;
import com.app.model.core.MyTenantDomainIF;
import com.app.utility.MyInstaller;

/**
 * I check all of the database domain classes to ensure that each one
 * implements ONE of the following interfaces...
 *
 * @see MyProjectDomainIF
 * @see MyTenantDomainIF
 * @see MySystemDomainIF
 */
public class MyDomainHierarchyCheckerTool
{
    //##################################################
    //# main
    //##################################################

    public static void main(String... args)
    {
        MyInstaller.installCore();
    }

    public static void run()
    {
        new MyDomainHierarchyCheckerTool().checkAll();
    }

    //##################################################
    //# check
    //##################################################

    private void checkAll()
    {
        MyModelType[] arr = MyModelType.values();
        for ( MyModelType type : arr )
        {
            Class<?> c = type.getJavaClass();
            check(c);
        }
    }

    private void check(Class<?> c)
    {
        boolean system = hasInterface(c, MySystemDomainIF.class);
        boolean tenant = hasInterface(c, MyTenantDomainIF.class);
        boolean project = hasInterface(c, MyProjectDomainIF.class);

        KmList<String> v = KmList.createEmpty();

        if ( system )
            v.add("system");

        if ( tenant )
            v.add("tenant");

        if ( project )
            v.add("project");

        if ( v.isSingleton() )
            return;

        if ( v.isEmpty() )
            v.add("(none)");

        KmLog.println();
        KmLog.printfln("    ERROR: %s => %s", c.getSimpleName(), v.join(" "));
        KmLog.println();
    }

    private boolean hasInterface(Class<?> c, Class<?> i)
    {
        for ( Class<?> e : getAllClassesFor(c) )
            if ( e.equals(i) )
                return true;

        return false;
    }

    private KmList<Class<?>> getAllClassesFor(Class<?> c)
    {
        KmList<Class<?>> v;
        v = new KmList<>();
        collectAllClassesFor(c, v);
        v.sortOn(e -> e.getSimpleName());
        return v;
    }

    private void collectAllClassesFor(Class<?> c, KmList<Class<?>> v)
    {
        if ( c == null )
            return;

        if ( v.contains(c) )
            return;

        v.add(c);

        collectAllClassesFor(c.getSuperclass(), v);

        for ( Class<?> i : c.getInterfaces() )
            collectAllClassesFor(i, v);
    }

}
