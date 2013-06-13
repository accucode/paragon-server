package com.kodemore.proto;

import com.kodemore.generator.model.KmgModelType;
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
    public String getDatabaseType(KmgModelType e)
    {
        return "time";
    }

    @Override
    public String getHibernateType()
    {
        return null;
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
