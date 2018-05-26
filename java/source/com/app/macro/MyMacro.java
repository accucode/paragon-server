package com.app.macro;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

/**
 * I am used for substitutions in templates that are edited
 * directly by users (non-developers).
 */
public abstract class MyMacro
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The domain type of this macro.
     * e.g. Job, User, Project, etc.
     */
    private MyMacroDomainType _domainType;

    /**
     * The optional association name.  This specifies if the
     * macro is for a field on a model associated with the
     * domain type (e.g. Main Contact for a Job).
     * If null, the macro is for a field on the domain
     * type.
     */
    private String _associationName;

    /**
     * The name of the field for this macro.  Used with
     * the domainName to generate the key.
     */
    private String _fieldName;

    /**
     * The description and/or help text that explains the
     * purpose or content of this variable.  In many cases
     * this is populated directly from the meta help message
     * defined in the .stf files.
     */
    private String _description;

    //##################################################
    //# key
    //##################################################

    /**
     * The unique identifier.
     * E.g.: 'customerName'.  This does NOT include
     * the additional syntax used to identify the token
     * in a template; e.g.: the $().
     */
    public String getKey()
    {
        KmList<String> v;
        v = new KmList<>();
        v.add(getDomainSharedCode());
        v.add(getAssociationName());
        v.add(getFieldName());
        v.removeNulls();
        return v.concatentate();
    }

    public boolean hasKey(String e)
    {
        return Kmu.isEqual(e, getKey());
    }

    //==================================================
    //= key :: domain type
    //==================================================

    public MyMacroDomainType getDomainType()
    {
        return _domainType;
    }

    public void setDomainType(MyMacroDomainType e)
    {
        _domainType = e;
    }

    public boolean hasDomainType()
    {
        return getDomainType() != null;
    }

    public boolean hasDomainType(MyMacroDomainType e)
    {
        return Kmu.isEqual(e, getDomainType());
    }

    /**
     * Return true if my domainType matches ANY of the
     * values provided.
     */
    public boolean hasAnyDomainType(KmList<MyMacroDomainType> v)
    {
        return v.containsIf(e -> hasDomainType(e));
    }

    public String getDomainSharedCode()
    {
        return hasDomainType()
            ? getDomainType().getSharedCode()
            : null;
    }

    public boolean hasDomainSharedCode(String e)
    {
        return Kmu.isEqual(getDomainSharedCode(), e);
    }

    //==================================================
    //= key :: associationName
    //==================================================

    public String getAssociationName()
    {
        return _associationName;
    }

    public void setAssociationName(String e)
    {
        _associationName = e;
    }

    public boolean hasAssociationName(String e)
    {
        return Kmu.isEqual(e, getAssociationName());
    }

    //==================================================
    //= key :: fieldName
    //==================================================

    public String getFieldName()
    {
        return _fieldName;
    }

    public void setFieldName(String fieldName)
    {
        _fieldName = fieldName;
    }

    public boolean hasFieldName(String e)
    {
        return Kmu.isEqual(e, getFieldName());
    }

    //==================================================
    //= key :: calculated
    //==================================================

    public String getName()
    {
        return Kmu.capitalizeWords(Kmu.getCamelCaseWords(getKey()).join(" "));
    }

    public String getToken()
    {
        return Kmu.format("$(%s)", Kmu.capitalizeFirstLetter(getKey()));
    }

    //##################################################
    //# description
    //##################################################

    public String getDescription()
    {
        return _description;
    }

    public void setDescription(String e)
    {
        _description = e;
    }

    //##################################################
    //# format
    //##################################################

    public abstract String formatHtml(Object e);

    public abstract String formatPlaintext(Object e);

    //##################################################
    //# sample
    //##################################################

    public abstract String getSampleHtml();

    public abstract String getSamplePlaintext();

}
