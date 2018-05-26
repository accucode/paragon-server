//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import java.util.*;

import com.kodemore.collection.*;
import com.kodemore.utility.*;

import com.app.model.*;

public enum MyDefaultRecipientContactType
    implements MyDefaultRecipientContactTypeIF
{
    //##################################################
    //# values
    //##################################################

    ProjectSupport("ProjectSupport", "Project Support"),
    Main("Main", "Main"),
    Install("Install", "Install"),
    Technical("Technical", "Technical"),
    Scheduling("Scheduling", "Scheduling"),
    Sales("Sales", "Sales"),
    Requester("Requester", "Requester"),
    CustomerApproval("CustomerApproval", "Customer Approval"),
    CustomerBilling("CustomerBilling", "Customer Billing"),
    ProjectNotifications("ProjectNotifications", "Project Notifications"),
    JobNotifications("JobNotifications", "Job Notifications"),
    CustomerNotifications("CustomerNotifications", "Customer Notifications"),
    Custom("Custom", "Custom"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyDefaultRecipientContactType> _values;
    private static final KmMap<String,MyDefaultRecipientContactType> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyDefaultRecipientContactType e : EnumSet.allOf(MyDefaultRecipientContactType.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyDefaultRecipientContactType> getValues()
    {
        return _values;
    }

    public static MyDefaultRecipientContactType findCode(String code)
    {
        return _codes.get(code);
    }

    //##################################################
    //# variables
    //##################################################

    private String _code;
    private String _label;

    //##################################################
    //# constructor
    //##################################################

    private MyDefaultRecipientContactType(String code, String label)
    {
        _code = code;
        _label = label;
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getCode()
    {
        return _code;
    }

    @Override
    public String getLabel()
    {
        return _label;
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isProjectSupport()
    {
        return this == ProjectSupport;
    }

    public boolean isMain()
    {
        return this == Main;
    }

    public boolean isInstall()
    {
        return this == Install;
    }

    public boolean isTechnical()
    {
        return this == Technical;
    }

    public boolean isScheduling()
    {
        return this == Scheduling;
    }

    public boolean isSales()
    {
        return this == Sales;
    }

    public boolean isRequester()
    {
        return this == Requester;
    }

    public boolean isCustomerApproval()
    {
        return this == CustomerApproval;
    }

    public boolean isCustomerBilling()
    {
        return this == CustomerBilling;
    }

    public boolean isProjectNotifications()
    {
        return this == ProjectNotifications;
    }

    public boolean isJobNotifications()
    {
        return this == JobNotifications;
    }

    public boolean isCustomerNotifications()
    {
        return this == CustomerNotifications;
    }

    public boolean isCustom()
    {
        return this == Custom;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyDefaultRecipientContactType getAt(int index)
    {
        return values()[index];
    }

    public static MyDefaultRecipientContactType getFirst()
    {
        return values()[0];
    }

    public static MyDefaultRecipientContactType getLast()
    {
        return values()[values().length - 1];
    }

    public MyDefaultRecipientContactType getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyDefaultRecipientContactType getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
