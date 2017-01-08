package com.kodemore.proto;

import com.kodemore.generator.model.KmgModelFieldType;
import com.kodemore.hibernate.type.KmhMoneyType;
import com.kodemore.meta.KmMetaMoneyProperty;
import com.kodemore.servlet.field.ScMoneyField;
import com.kodemore.types.KmMoney;
import com.kodemore.utility.Kmu;
import com.kodemore.validator.KmMoneyValidator;

public class KmProtoMoney
    extends KmProtoType
{
    @Override
    public String getName()
    {
        return "money";
    }

    @Override
    public Class<?> getJavaType()
    {
        return KmMoney.class;
    }

    @Override
    public String getDatabaseType(KmgModelFieldType e)
    {
        return Kmu.format("decimal(%s,%s)", KmMoney.DATABASE_PRECISION, KmMoney.SCALE);
    }

    @Override
    public String getHibernateType()
    {
        return KmhMoneyType.class.getName();
    }

    @Override
    public Class<?> getEditControlClass()
    {
        return ScMoneyField.class;
    }

    @Override
    public Class<?> getValidatorClass()
    {
        return KmMoneyValidator.class;
    }

    @Override
    public Class<?> getMetaClass()
    {
        return KmMetaMoneyProperty.class;
    }

}
