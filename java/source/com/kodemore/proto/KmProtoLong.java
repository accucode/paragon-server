package com.kodemore.proto;

import com.kodemore.generator.model.KmgModelFieldType;
import com.kodemore.meta.KmMetaLongProperty;
import com.kodemore.servlet.field.ScLongField;
import com.kodemore.validator.KmLongValidator;

public class KmProtoLong
    extends KmProtoType
{
    @Override
    public String getName()
    {
        return "long";
    }

    @Override
    public Class<?> getJavaType()
    {
        return Long.class;
    }

    @Override
    public String getDatabaseType(KmgModelFieldType e)
    {
        return "bigint";
    }

    @Override
    public String getHibernateType()
    {
        return "long";
    }

    @Override
    public Class<?> getEditControlClass()
    {
        return ScLongField.class;
    }

    @Override
    public Class<?> getValidatorClass()
    {
        return KmLongValidator.class;
    }

    @Override
    public Class<?> getMetaClass()
    {
        return KmMetaLongProperty.class;
    }

}
