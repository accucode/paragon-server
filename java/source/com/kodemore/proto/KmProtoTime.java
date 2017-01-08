package com.kodemore.proto;

import com.kodemore.generator.model.KmgModelFieldType;
import com.kodemore.hibernate.KmhTimeCondition;
import com.kodemore.hibernate.type.KmhTimeType;
import com.kodemore.meta.KmMetaTimeProperty;
import com.kodemore.servlet.field.ScTimeField;
import com.kodemore.time.KmTime;
import com.kodemore.validator.KmTimeValidator;

public class KmProtoTime
    extends KmProtoType
{
    @Override
    public String getName()
    {
        return "time";
    }

    @Override
    public Class<?> getJavaType()
    {
        return KmTime.class;
    }

    @Override
    public String getDatabaseType(KmgModelFieldType e)
    {
        return "time";
    }

    @Override
    public String format_CriteriaClass()
    {
        return KmhTimeCondition.class.getSimpleName();
    }

    @Override
    public String format_CriteriaClass_NoGeneric()
    {
        return format_CriteriaClass();
    }

    @Override
    public String getHibernateType()
    {
        return KmhTimeType.class.getName();
    }

    @Override
    public Class<?> getEditControlClass()
    {
        return ScTimeField.class;
    }

    @Override
    public Class<?> getValidatorClass()
    {
        return KmTimeValidator.class;
    }

    @Override
    public Class<?> getMetaClass()
    {
        return KmMetaTimeProperty.class;
    }

}
