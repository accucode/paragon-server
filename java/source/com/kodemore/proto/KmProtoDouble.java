package com.kodemore.proto;

import com.kodemore.collection.KmList;
import com.kodemore.generator.model.KmgSqlColumn;
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
    public KmList<KmgSqlColumn> getSqlColumns()
    {
        return singleColumn("double");
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
