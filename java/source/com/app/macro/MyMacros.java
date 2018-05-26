package com.app.macro;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

import com.app.macro.builder.MyAttachmentMacroBuilder;
import com.app.macro.builder.MyCustomerMacroBuilder;
import com.app.macro.builder.MyGlobalMacroBuilder;
import com.app.macro.builder.MyProjectMacroBuilder;
import com.app.macro.builder.MySiteMacroBuilder;
import com.app.macro.builder.MyTenantMacroBuilder;
import com.app.macro.builder.MyUserMacroBuilder;

public class MyMacros
{
    //##################################################
    //# variables
    //##################################################

    // You must update getAll() if you add another list.
    private static KmList<MyMacro> _globalMacros;
    private static KmList<MyMacro> _userMacros;

    // You must update getAll() if you add another list.
    private static KmList<MyMacro> _attachmentMacros;
    private static KmList<MyMacro> _customerMacros;
    private static KmList<MyMacro> _projectMacros;
    private static KmList<MyMacro> _siteMacros;
    private static KmList<MyMacro> _tenantMacros;

    //##################################################
    //# install
    //##################################################

    public static void install()
    {
        _globalMacros = new MyGlobalMacroBuilder().getAll();
        _userMacros = new MyUserMacroBuilder().getAll();

        _attachmentMacros = new MyAttachmentMacroBuilder().getAll();
        _customerMacros = new MyCustomerMacroBuilder().getAll();
        _projectMacros = new MyProjectMacroBuilder().getAll();
        _siteMacros = new MySiteMacroBuilder().getAll();
        _tenantMacros = new MyTenantMacroBuilder().getAll();

        validate();
    }

    private static void validate()
    {
        KmList<String> keys = getAll().collect(e -> e.getKey());
        KmList<String> dups = keys.getDuplicates();

        if ( dups.isNotEmpty() )
            throw Kmu.newFatal("Duplicate macros: %s.", dups.join());
    }

    public static KmList<MyMacro> getAll()
    {
        KmList<MyMacro> v;
        v = new KmList<>();

        v.addAll(getGlobalMacros());
        v.addAll(getUserMacros());

        v.addAll(getAttachmentMacros());
        v.addAll(getCustomerMacros());
        v.addAll(getProjectMacros());
        v.addAll(getSiteMacros());
        v.addAll(getTenantMacros());

        return v;
    }

    //##################################################
    //# accessing
    //##################################################

    public static MyMacro findKey(String key)
    {
        return getAll().selectFirst(e -> e.hasKey(key));
    }

    public static KmList<MyMacro> getAttachmentMacros()
    {
        return _attachmentMacros;
    }

    public static KmList<MyMacro> getCustomerMacros()
    {
        return _customerMacros;
    }

    public static KmList<MyMacro> getGlobalMacros()
    {
        return _globalMacros;
    }

    public static KmList<MyMacro> getProjectMacros()
    {
        return _projectMacros;
    }

    public static KmList<MyMacro> getSiteMacros()
    {
        return _siteMacros;
    }

    public static KmList<MyMacro> getTenantMacros()
    {
        return _tenantMacros;
    }

    public static KmList<MyMacro> getUserMacros()
    {
        return _userMacros;
    }

    //##################################################
    //# main
    //##################################################

    /**
     * A simple main method that installs (and validates) the macros.
     */
    public static void main(String[] args)
    {
        System.out.println("MyMacros test...");
        MyMacros.install();
        MyMacros.getAll().collect(e -> e.getKey()).toSorted().printLines();
        System.out.println("ok.");
    }

}
