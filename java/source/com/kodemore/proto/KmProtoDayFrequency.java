package com.kodemore.proto;

import com.kodemore.collection.KmList;
import com.kodemore.generator.model.KmgSqlColumn;
import com.kodemore.hibernate.type.KmhDayFrequencyType;
import com.kodemore.meta.KmMetaDayFrequencyProperty;
import com.kodemore.servlet.field.ScDayFrequencyField;
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
    public KmList<KmgSqlColumn> getSqlColumns()
    {
        return singleColumn("char(7)");
    }

    @Override
    public String getHibernateType()
    {
        return KmhDayFrequencyType.class.getName();
    }

    @Override
    public Class<?> getEditControlClass()
    {
        return ScDayFrequencyField.class;
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
