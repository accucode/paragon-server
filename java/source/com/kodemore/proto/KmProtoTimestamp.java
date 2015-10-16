package com.kodemore.proto;

import com.kodemore.generator.model.KmgModelType;
import com.kodemore.hibernate.KmhTimestampCondition;
import com.kodemore.hibernate.type.KmhTimestampType;
import com.kodemore.meta.KmMetaTimestampProperty;
import com.kodemore.servlet.field.ScTimestampField;
import com.kodemore.time.KmTimestamp;
import com.kodemore.validator.KmTimestampValidator;

public class KmProtoTimestamp
    extends KmProtoType
{
    @Override
    public String getName()
    {
        return "timestamp";
    }

    @Override
    public boolean isTimestamp()
    {
        return true;
    }

    @Override
    public Class<?> getJavaType()
    {
        return KmTimestamp.class;
    }

    @Override
    public String getDatabaseType(KmgModelType e)
    {
        return "datetime";
    }

    @Override
    public String format_CriteriaClass()
    {
        return KmhTimestampCondition.class.getSimpleName();
    }

    @Override
    public String format_CriteriaClass_NoGeneric()
    {
        return format_CriteriaClass();
    }

    @Override
    public String getHibernateType()
    {
        return KmhTimestampType.class.getName();
    }

    @Override
    public Class<?> getEditControlClass()
    {
        return ScTimestampField.class;
    }

    @Override
    public Class<?> getValidatorClass()
    {
        return KmTimestampValidator.class;
    }

    @Override
    public Class<?> getMetaClass()
    {
        return KmMetaTimestampProperty.class;
    }

}
