package com.kodemore.proto;

import com.kodemore.generator.model.KmgModelType;
import com.kodemore.hibernate.criteria.KmStringCriteria;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.validator.KmStringValidator;

public class KmProtoString
    extends KmProtoType
{
    @Override
    public String getName()
    {
        return "string";
    }

    @Override
    public Class<?> getJavaType()
    {
        return String.class;
    }

    @Override
    public String getDatabaseType(KmgModelType e)
    {
        String type = "varchar";
        int n = e.getMaximumLength();

        if ( n >= 10000 )
            return "text";

        boolean fixed = e.hasFixedLength();

        if ( fixed || n <= 10 )
            type = "char";

        return type + "(" + n + ")";
    }

    @Override
    public String format_CriteriaClass()
    {
        return KmStringCriteria.class.getSimpleName();
    }

    @Override
    public String format_CriteriaClass_NoGeneric()
    {
        return format_CriteriaClass();
    }

    @Override
    public String getHibernateType()
    {
        return "string";
    }

    @Override
    public boolean isString()
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
        return ScTextField.class;
    }

    @Override
    public Class<?> getValidatorClass()
    {
        return KmStringValidator.class;
    }

    @Override
    public Class<?> getMetaClass()
    {
        return KmMetaStringProperty.class;
    }

}
