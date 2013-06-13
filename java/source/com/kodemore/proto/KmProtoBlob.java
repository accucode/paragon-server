package com.kodemore.proto;

import com.kodemore.collection.KmBlob;
import com.kodemore.generator.model.KmgModelType;
import com.kodemore.hibernate.KmHibernateBlobType;
import com.kodemore.meta.KmMetaBlobProperty;
import com.kodemore.validator.KmBlobValidator;

public class KmProtoBlob
    extends KmProtoType
{
    @Override
    public String getName()
    {
        return "blob";
    }

    @Override
    public Class<?> getJavaType()
    {
        return KmBlob.class;
    }

    @Override
    public String getDatabaseType(KmgModelType f)
    {
        // int n = f.getMaximumLength();
        return "mediumblob";
    }

    @Override
    public String getHibernateType()
    {
        return KmHibernateBlobType.class.getName();
    }

    @Override
    public Class<?> getEditControlClass()
    {
        return null;
    }

    @Override
    public Class<?> getValidatorClass()
    {
        return KmBlobValidator.class;
    }

    @Override
    public Class<?> getMetaClass()
    {
        return KmMetaBlobProperty.class;
    }

}
