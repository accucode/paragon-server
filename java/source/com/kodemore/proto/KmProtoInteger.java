package com.kodemore.proto;

import com.kodemore.collection.KmList;
import com.kodemore.generator.model.KmgSqlColumn;
import com.kodemore.hibernate.KmhIntegerCondition;
import com.kodemore.meta.KmMetaIntegerProperty;
import com.kodemore.servlet.field.ScIntegerField;
import com.kodemore.validator.KmIntegerValidator;

public class KmProtoInteger
    extends KmProtoType
{
    @Override
    public String getName()
    {
        return "integer";
    }

    @Override
    public Class<?> getJavaType()
    {
        return Integer.class;
    }

    @Override
    public KmList<KmgSqlColumn> getSqlColumns()
    {
        return singleColumn("int");
    }

    @Override
    public String format_CriteriaClass()
    {
        return KmhIntegerCondition.class.getSimpleName();
    }

    @Override
    public String format_CriteriaClass_NoGeneric()
    {
        return format_CriteriaClass();
    }

    @Override
    public String getHibernateType()
    {
        return "integer";
    }

    @Override
    public boolean isInteger()
    {
        return true;
    }

    @Override
    public boolean isProperty()
    {
        return true;
    }

    @Override
    public Class<?> getEditControlClass()
    {
        return ScIntegerField.class;
    }

    @Override
    public Class<?> getValidatorClass()
    {
        return KmIntegerValidator.class;
    }

    @Override
    public Class<?> getMetaClass()
    {
        return KmMetaIntegerProperty.class;
    }

}
