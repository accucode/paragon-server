package com.kodemore.proto;

import com.kodemore.collection.KmList;
import com.kodemore.generator.model.KmgModelField;
import com.kodemore.generator.model.KmgSqlColumn;
import com.kodemore.hibernate.KmhUnitDurationCondition;
import com.kodemore.hibernate.type.KmhUnitDurationType;
import com.kodemore.meta.KmMetaUnitDurationProperty;
import com.kodemore.servlet.field.ScUnitDurationField;
import com.kodemore.time.KmUnitDuration;
import com.kodemore.validator.KmUnitDurationValidator;

public class KmProtoUnitDuration
    extends KmProtoType
{
    //##################################################
    //# constants
    //##################################################

    private static final String VALUE_COLUMN_TYPE   = "double";
    private static final String VALUE_COLUMN_SUFFIX = "Value";

    private static final String UNIT_COLUMN_TYPE   = "varchar(10)";
    private static final String UNIT_COLUMN_SUFFIX = "Unit";

    //##################################################
    //# type
    //##################################################

    @Override
    public String getName()
    {
        return "unitDuration";
    }

    @Override
    public Class<?> getJavaType()
    {
        return KmUnitDuration.class;
    }

    @Override
    public KmList<KmgSqlColumn> getSqlColumns()
    {
        KmList<KmgSqlColumn> v;
        v = new KmList<>();
        v.add(newColumn(VALUE_COLUMN_TYPE, VALUE_COLUMN_SUFFIX));
        v.add(newColumn(UNIT_COLUMN_TYPE, UNIT_COLUMN_SUFFIX));
        return v;
    }

    @Override
    public String formatSqlForeignKeyDefininition(KmgModelField field, String prefix)
    {
        return null;
    }

    @Override
    public String format_CriteriaClass()
    {
        return KmhUnitDurationCondition.class.getSimpleName();
    }

    @Override
    public String format_CriteriaClass_NoGeneric()
    {
        return format_CriteriaClass();
    }

    @Override
    public String getHibernateType()
    {
        return KmhUnitDurationType.class.getName();
    }

    @Override
    public Class<?> getEditControlClass()
    {
        return ScUnitDurationField.class;
    }

    @Override
    public Class<?> getValidatorClass()
    {
        return KmUnitDurationValidator.class;
    }

    @Override
    public Class<?> getMetaClass()
    {
        return KmMetaUnitDurationProperty.class;
    }
}
