package com.kodemore.generator.model;

import java.util.function.Function;

import com.kodemore.utility.Kmu;

public class KmgSqlColumn
{
    //##################################################
    //# variables
    //##################################################

    private Function<KmgModelField,String> _typeFunction;

    private String _type;
    private String _suffix;

    //##################################################
    //# constructor
    //##################################################

    public KmgSqlColumn(String type, String suffix)
    {
        setTypeFunction(e -> getType());
        _type = type;
        _suffix = suffix;
    }

    public KmgSqlColumn(Function<KmgModelField,String> typeFunction)
    {
        _typeFunction = typeFunction;
    }

    public KmgSqlColumn(String type)
    {
        setTypeFunction(e -> getType());
        _type = type;
    }

    //##################################################
    //# accessing
    //##################################################

    public Function<KmgModelField,String> getTypeFunction()
    {
        return _typeFunction;
    }

    public void setTypeFunction(Function<KmgModelField,String> e)
    {
        _typeFunction = e;
    }

    public String getType()
    {
        return _type;
    }

    public void setType(String e)
    {
        _type = e;
    }

    public String getSuffix()
    {
        return _suffix;
    }

    public void setSuffix(String e)
    {
        _suffix = e;
    }

    public boolean hasSuffix()
    {
        return Kmu.hasValue(getSuffix());
    }

    //##################################################
    //# format
    //##################################################

    public String getf_type(KmgModelField e)
    {
        return getTypeFunction().apply(e);
    }

    public String getf_columnDefinition(KmgModelField e)
    {
        if ( hasSuffix() )
            return Kmu.format("%s%s %s", e.getName(), getf_Suffix(), getf_type(e));

        return Kmu.format("%s %s", e.getName(), getf_type(e));
    }

    public String getf_ColumnDefinition(KmgModelField e)
    {
        return Kmu.capitalizeFirstLetter(getf_columnDefinition(e));
    }

    public String getf_foreignKeyColumnDefinition(KmgModelField e, String prefix)
    {
        return Kmu.format("%s%s", prefix, getf_ColumnDefinition(e), getf_type(e));
    }

    public String getf_Suffix()
    {
        return Kmu.capitalizeFirstLetter(getSuffix());
    }
}
