package com.kodemore.proto;

import com.kodemore.collection.KmList;
import com.kodemore.generator.model.KmgSqlColumn;
import com.kodemore.hibernate.KmhDurationCondition;
import com.kodemore.hibernate.type.KmhDurationType;
import com.kodemore.meta.KmMetaDurationProperty;
import com.kodemore.time.KmDuration;
import com.kodemore.validator.KmDurationValidator;

public class KmProtoDuration
    extends KmProtoType
{
    @Override
    public String getName()
    {
        return "duration";
    }

    @Override
    public Class<?> getJavaType()
    {
        return KmDuration.class;
    }

    @Override
    public KmList<KmgSqlColumn> getSqlColumns()
    {
        return singleColumn("bigint");
    }

    @Override
    public String format_CriteriaClass()
    {
        return KmhDurationCondition.class.getSimpleName();
    }

    @Override
    public String format_CriteriaClass_NoGeneric()
    {
        return format_CriteriaClass();
    }

    @Override
    public String getHibernateType()
    {
        return KmhDurationType.class.getName();
    }

    @Override
    public Class<?> getEditControlClass()
    {
        return null;
    }

    @Override
    public Class<?> getValidatorClass()
    {
        return KmDurationValidator.class;
    }

    @Override
    public Class<?> getMetaClass()
    {
        return KmMetaDurationProperty.class;
    }

}
