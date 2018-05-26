package com.kodemore.proto;

import com.kodemore.collection.KmList;
import com.kodemore.generator.model.KmgSqlColumn;
import com.kodemore.meta.KmMetaCostProperty;
import com.kodemore.servlet.field.ScCostField;
import com.kodemore.types.KmCost;
import com.kodemore.utility.Kmu;
import com.kodemore.validator.KmCostValidator;

public class KmProtoCost
    extends KmProtoType
{
    @Override
    public String getName()
    {
        return "cost";
    }

    @Override
    public Class<?> getJavaType()
    {
        return KmCost.class;
    }

    public String getDatabaseType()
    {
        return Kmu.format("decimal(%s,%s)", KmCost.DATABASE_PRECISION, KmCost.SCALE);
    }

    @Override
    public KmList<KmgSqlColumn> getSqlColumns()
    {
        return singleColumn(getDatabaseType());
    }

    @Override
    public String getHibernateType()
    {
        return null;
    }

    @Override
    public Class<?> getEditControlClass()
    {
        return ScCostField.class;
    }

    @Override
    public Class<?> getValidatorClass()
    {
        return KmCostValidator.class;
    }

    @Override
    public Class<?> getMetaClass()
    {
        return KmMetaCostProperty.class;
    }

}
