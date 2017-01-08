package com.kodemore.proto;

import com.kodemore.generator.model.KmgModelField;
import com.kodemore.generator.model.KmgModelFieldType;
import com.kodemore.hibernate.KmhPropertyCondition;
import com.kodemore.utility.Kmu;

public abstract class KmProtoType
{
    //##################################################
    //# name
    //##################################################

    public abstract String getName();

    public boolean hasName(String s)
    {
        return getName().equals(s);
    }

    public String format_name()
    {
        return Kmu.lowercaseFirstLetter(getName());
    }

    public String format_Name()
    {
        return Kmu.capitalizeFirstLetter(getName());
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isString()
    {
        return false;
    }

    public boolean isBoolean()
    {
        return false;
    }

    public boolean isTimestamp()
    {
        return false;
    }

    public boolean isInteger()
    {
        return false;
    }

    public boolean isProperty()
    {
        return false;
    }

    //##################################################
    //# java type
    //##################################################

    public abstract Class<?> getJavaType();

    public final String format_JavaType()
    {
        return hasJavaType()
            ? getJavaType().getSimpleName()
            : null;
    }

    public boolean hasJavaType()
    {
        return getJavaType() != null;
    }

    //##################################################
    //# sql
    //##################################################

    public abstract String getDatabaseType(KmgModelFieldType f);

    public String getSqlSelect()
    {
        return "select" + format_Name();
    }

    public String formatSqlGetter()
    {
        return "get" + format_Name();
    }

    public String getSqlInsertAddColumn()
    {
        return Kmu.format("add%sColumn", format_Name());
    }

    public String getSqlInsertAddValue()
    {
        return Kmu.format("add%sValue", format_Name());
    }

    public String getSqlInsertSetValue()
    {
        return Kmu.format("set%sValue", format_Name());
    }

    public String formatSqlColumnDefinition(KmgModelField field)
    {
        return formatSqlColumnDefinition(field, true);
    }

    /**
     * Create the ddl necessary for column definition.
     * The definition is typically a single line, without
     * the terminating end of line characters.  If the
     * field creates multiple columns (e.g.: money) then
     * each column should be separated by a new line. All
     * columns definitions should be terminated by a comma.
     */
    public String formatSqlColumnDefinition(KmgModelField field, boolean autoIncr)
    {
        StringBuilder out;
        out = new StringBuilder();
        out.append("    ");
        out.append(field.getf_sqlColumn());
        out.append(" ");
        out.append(field.getf_sqlType());

        if ( autoIncr && field.isIdentity() )
            out.append(" AUTO_INCREMENT");

        out.append(",");

        return out.toString();
    }

    public String formatSqlForeignKeyDefininition(KmgModelField field, String prefix)
    {
        StringBuilder out;
        out = new StringBuilder();
        out.append("    ");
        out.append(field.getf_sqlForeignKeyColumn(prefix));
        out.append(" ");
        out.append(field.getf_sqlType());
        out.append(",");

        return out.toString();
    }

    //##################################################
    //# hibernate
    //##################################################

    public abstract String getHibernateType();

    public String format_CriteriaClass()
    {
        String className = KmhPropertyCondition.class.getSimpleName();
        String type = format_JavaType();

        return Kmu.format("%s<%s>", className, type);
    }

    public String format_CriteriaClass_NoGeneric()
    {
        String className = KmhPropertyCondition.class.getSimpleName();

        return Kmu.format("%s<>", className);
    }

    //##################################################
    //# model
    //##################################################

    public abstract Class<?> getValidatorClass();

    public String format_ValidatorClass()
    {
        return hasValidatorClass()
            ? getValidatorClass().getSimpleName()
            : null;
    }

    public boolean hasValidatorClass()
    {
        return getValidatorClass() != null;
    }

    //##################################################
    //# ui
    //##################################################

    public abstract Class<?> getEditControlClass();

    public String getEditControlClassName()
    {
        return hasEditControlClass()
            ? getEditControlClass().getSimpleName()
            : null;
    }

    public boolean hasEditControlClass()
    {
        return getEditControlClass() != null;
    }

    //##################################################
    //# meta
    //##################################################

    public abstract Class<?> getMetaClass();

    public boolean hasMetaClass()
    {
        return getMetaClass() != null;
    }

    public String format_MetaSuperClass()
    {
        return hasMetaClass()
            ? getMetaClass().getSimpleName()
            : null;
    }
}
