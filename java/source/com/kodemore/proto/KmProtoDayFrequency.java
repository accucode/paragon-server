package com.kodemore.proto;

import com.kodemore.generator.model.KmgModelType;
import com.kodemore.meta.KmMetaDayFrequencyProperty;
import com.kodemore.types.KmDayFrequency;
import com.kodemore.validator.KmDayFrequencyValidator;

public class KmProtoDayFrequency
    extends KmProtoType
{
    @Override
    public String getName()
    {
        return "dayFrequency";
    }

    @Override
    public Class<?> getJavaType()
    {
        return KmDayFrequency.class;
    }

    @Override
    public String getDatabaseType(KmgModelType e)
    {
        return "char(7)";
    }

    @Override
    public String getHibernateType()
    {
        return null;
    }

    @Override
    public Class<?> getEditControlClass()
    {
        return null;
    }

    @Override
    public Class<?> getValidatorClass()
    {
        return KmDayFrequencyValidator.class;
    }

    @Override
    public Class<?> getMetaClass()
    {
        return KmMetaDayFrequencyProperty.class;
    }

}
