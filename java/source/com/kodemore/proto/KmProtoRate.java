package com.kodemore.proto;

import com.kodemore.generator.model.KmgModelType;
import com.kodemore.meta.KmMetaRateProperty;
import com.kodemore.servlet.field.ScRateField;
import com.kodemore.types.KmRate;
import com.kodemore.utility.Kmu;
import com.kodemore.validator.KmRateValidator;

public class KmProtoRate
    extends KmProtoType
{
    @Override
    public String getName()
    {
        return "rate";
    }

    @Override
    public Class<?> getJavaType()
    {
        return KmRate.class;
    }

    @Override
    public String getDatabaseType(KmgModelType e)
    {
        return Kmu.format("decimal(%s,%s)", KmRate.DATABASE_PRECISION, KmRate.SCALE);
    }

    @Override
    public String getHibernateType()
    {
        return null;
    }

    @Override
    public Class<?> getEditControlClass()
    {
        return ScRateField.class;
    }

    @Override
    public Class<?> getValidatorClass()
    {
        return KmRateValidator.class;
    }

    @Override
    public Class<?> getMetaClass()
    {
        return KmMetaRateProperty.class;
    }

}
