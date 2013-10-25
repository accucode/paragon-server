package com.kodemore.proto;

import com.kodemore.generator.model.KmgModelType;
import com.kodemore.meta.KmMetaKilogramProperty;
import com.kodemore.servlet.field.ScKilogramField;
import com.kodemore.types.KmKilogram;
import com.kodemore.utility.Kmu;
import com.kodemore.validator.KmKilogramValidator;

public class KmProtoKilogram
    extends KmProtoType
{
    @Override
    public String getName()
    {
        return "kilogram";
    }

    @Override
    public Class<?> getJavaType()
    {
        return KmKilogram.class;
    }

    @Override
    public String getDatabaseType(KmgModelType e)
    {
        return Kmu.format("decimal(%s,%s)", KmKilogram.DATABASE_PRECISION, KmKilogram.SCALE);
    }

    @Override
    public String getHibernateType()
    {
        return null;
    }

    @Override
    public Class<?> getEditControlClass()
    {
        return ScKilogramField.class;
    }

    @Override
    public Class<?> getValidatorClass()
    {
        return KmKilogramValidator.class;
    }

    @Override
    public Class<?> getMetaClass()
    {
        return KmMetaKilogramProperty.class;
    }

}
