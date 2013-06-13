package com.kodemore.proto;

import com.kodemore.generator.model.KmgModelType;
import com.kodemore.meta.KmMetaDoubleProperty;
import com.kodemore.servlet.field.ScDoubleField;
import com.kodemore.validator.KmDoubleValidator;

public class KmProtoDouble
    extends KmProtoType
{
    @Override
    public String getName()
    {
        return "double";
    }

    @Override
    public Class<?> getJavaType()
    {
        return Double.class;
    }

    @Override
    public String getDatabaseType(KmgModelType e)
    {
        return "double";
    }

    @Override
    public String getHibernateType()
    {
        return "double";
    }

    @Override
    public boolean isProperty()
    {
        return true;
    }

    @Override
    public Class<?> getEditControlClass()
    {
        return ScDoubleField.class;
    }

    @Override
    public Class<?> getValidatorClass()
    {
        return KmDoubleValidator.class;
    }

    @Override
    public Class<?> getMetaClass()
    {
        return KmMetaDoubleProperty.class;
    }

}
