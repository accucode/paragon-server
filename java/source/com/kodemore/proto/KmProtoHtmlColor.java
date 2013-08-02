package com.kodemore.proto;

import com.kodemore.generator.model.KmgModelType;
import com.kodemore.hibernate.KmHibernateHtmlColorType;
import com.kodemore.meta.KmMetaHtmlColorProperty;
import com.kodemore.servlet.field.ScColorField;
import com.kodemore.types.KmHtmlColor;
import com.kodemore.validator.KmHtmlColorValidator;

public class KmProtoHtmlColor
    extends KmProtoType
{
    @Override
    public String getName()
    {
        return "htmlColor";
    }

    @Override
    public Class<?> getJavaType()
    {
        return KmHtmlColor.class;
    }

    @Override
    public String getDatabaseType(KmgModelType e)
    {
        return "char(7)";
    }

    @Override
    public String getHibernateType()
    {
        return KmHibernateHtmlColorType.class.getName();
    }

    @Override
    public boolean isString()
    {
        return false;
    }

    @Override
    public boolean isProperty()
    {
        return false;
    }

    @Override
    public Class<?> getEditControlClass()
    {
        return ScColorField.class;
    }

    @Override
    public Class<?> getValidatorClass()
    {
        return KmHtmlColorValidator.class;
    }

    @Override
    public Class<?> getMetaClass()
    {
        return KmMetaHtmlColorProperty.class;
    }

}
