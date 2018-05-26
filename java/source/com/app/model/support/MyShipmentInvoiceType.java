package com.app.model.support;

import java.util.EnumSet;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.servlet.field.ScStaticEnumDropdownField;
import com.kodemore.utility.KmEnumIF;

public enum MyShipmentInvoiceType
    implements KmEnumIF
{
    //##################################################
    //# values
    //##################################################

    Nothing("Nothing", "Nothing"),
    CarrierCost("CarrierCost", "Carrier Cost"),
    AboveGroundCost("AboveGroundCost", "Above Ground Cost"),
    Other("Other", "Other"),;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyShipmentInvoiceType>       _values;
    private static final KmMap<String,MyShipmentInvoiceType> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyShipmentInvoiceType e : EnumSet.allOf(MyShipmentInvoiceType.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyShipmentInvoiceType> getValues()
    {
        return _values;
    }

    public static MyShipmentInvoiceType findCode(String code)
    {
        return _codes.get(code);
    }

    //##################################################
    //# control
    //##################################################

    public static final ScStaticEnumDropdownField newField()
    {
        ScStaticEnumDropdownField e;
        e = new ScStaticEnumDropdownField();
        e.setLabel("Invoice Customer For");
        e.setHelp(getHelp());
        e.setOptions(values());
        return e;
    }

    private static final String getHelp()
    {
        return ""
            + "\nThis is used to determine the amount we expect to invoice the"
            + "\ncustomer for this shipment."
            + "\n\n"
            + "\nNothing."
            + "\nInvoice the customer for nothing."
            + "\n\n"
            + "\nCarrier Cost."
            + "\nInvoice the customer for the amount due to the carrier."
            + "\n\n"
            + "\nAbove Ground Cost."
            + "\nInvoice the customer for any amount above the standard ground cost"
            + "\nrecorded for this shipment."
            + "\n\n"
            + "\nOther."
            + "\nInvoice the customer for an ad hoc amount.";
    }

    //##################################################
    //# variables
    //##################################################

    private String _code;
    private String _label;

    //##################################################
    //# constructor
    //##################################################

    private MyShipmentInvoiceType(String code, String label)
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

    public boolean isNothing()
    {
        return this == Nothing;
    }

    public boolean isCarrierCost()
    {
        return this == CarrierCost;
    }

    public boolean isAboveGroundCost()
    {
        return this == AboveGroundCost;
    }

    public boolean isOther()
    {
        return this == Other;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyShipmentInvoiceType getAt(int index)
    {
        return values()[index];
    }

    public static MyShipmentInvoiceType getFirst()
    {
        return values()[0];
    }

    public static MyShipmentInvoiceType getLast()
    {
        return values()[values().length - 1];
    }

    public MyShipmentInvoiceType getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyShipmentInvoiceType getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
