package com.kodemore.proto;

import com.kodemore.collection.KmList;
import com.kodemore.generator.model.KmgModelField;
import com.kodemore.generator.model.KmgModelFieldType;
import com.kodemore.generator.model.KmgSqlColumn;
import com.kodemore.hibernate.KmhStringCondition;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.validator.KmStringValidator;

public class KmProtoString
    extends KmProtoType
{
    @Override
    public String getName()
    {
        return "string";
    }

    @Override
    public Class<?> getJavaType()
    {
        return String.class;
    }

    public String getDatabaseType(KmgModelField e)
    {
        KmgModelFieldType fieldType = e.getType();

        String type = "varchar";
        int n = fieldType.getMaximumLength();

        if ( n >= 10000 )
            return "text";

        boolean fixed = fieldType.hasFixedLength();

        if ( fixed || n <= 10 )
            type = "char";

        return type + "(" + n + ")";
    }

    @Override
    public KmList<KmgSqlColumn> getSqlColumns()
    {
        return singleColumn(e -> getDatabaseType(e));
    }

    @Override
    public String format_CriteriaClass()
    {
        return KmhStringCondition.class.getSimpleName();
    }

    @Override
    public String format_CriteriaClass_NoGeneric()
    {
        return format_CriteriaClass();
    }

    @Override
    public String getHibernateType()
    {
        return "string";
    }

    @Override
    public boolean isString()
    {
        return true;
    }

    @Override
    public boolean isProperty()
    {
        return true;
    }

    @Override
    public Class<?> getEditControlClass()
    {
        return ScTextField.class;
    }

    @Override
    public Class<?> getValidatorClass()
    {
        return KmStringValidator.class;
    }

    @Override
    public Class<?> getMetaClass()
    {
        return KmMetaStringProperty.class;
    }

}
