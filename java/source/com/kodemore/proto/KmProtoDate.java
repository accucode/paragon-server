package com.kodemore.proto;

import com.kodemore.generator.model.KmgModelType;
import com.kodemore.hibernate.type.KmhDateType;
import com.kodemore.meta.KmMetaDateProperty;
import com.kodemore.servlet.field.ScDateField;
import com.kodemore.time.KmDate;
import com.kodemore.validator.KmDateValidator;

public class KmProtoDate
    extends KmProtoType
{
    @Override
    public String getName()
    {
        return "date";
    }

    @Override
    public Class<?> getJavaType()
    {
        return KmDate.class;
    }

    @Override
    public String getDatabaseType(KmgModelType e)
    {
        return "date";
    }

    @Override
    public String getHibernateType()
    {
        return KmhDateType.class.getName();
    }

    @Override
    public Class<?> getEditControlClass()
    {
        return ScDateField.class;
    }

    @Override
    public Class<?> getValidatorClass()
    {
        return KmDateValidator.class;
    }

    @Override
    public Class<?> getMetaClass()
    {
        return KmMetaDateProperty.class;
    }

}
