package com.kodemore.proto;

import com.kodemore.generator.model.KmgModelType;
import com.kodemore.hibernate.KmhBooleanCondition;
import com.kodemore.meta.KmMetaBooleanProperty;
import com.kodemore.servlet.field.ScCheckboxField;
import com.kodemore.validator.KmBooleanValidator;

public class KmProtoBoolean
    extends KmProtoType
{
    @Override
    public String getName()
    {
        return "boolean";
    }

    @Override
    public Class<?> getJavaType()
    {
        return Boolean.class;
    }

    @Override
    public String getDatabaseType(KmgModelType e)
    {
        return "char(1)";
    }

    @Override
    public String format_CriteriaClass()
    {
        return KmhBooleanCondition.class.getSimpleName();
    }

    @Override
    public String format_CriteriaClass_NoGeneric()
    {
        return format_CriteriaClass();
    }

    @Override
    public String getHibernateType()
    {
        return "yes_no";
    }

    @Override
    public boolean isBoolean()
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
        return ScCheckboxField.class;
    }

    @Override
    public Class<?> getValidatorClass()
    {
        return KmBooleanValidator.class;
    }

    @Override
    public Class<?> getMetaClass()
    {
        return KmMetaBooleanProperty.class;
    }

}
