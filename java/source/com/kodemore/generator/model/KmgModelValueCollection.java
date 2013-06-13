package com.kodemore.generator.model;

import com.kodemore.generator.KmgElement;
import com.kodemore.stf.KmStfElement;
import com.kodemore.utility.Kmu;

public class KmgModelValueCollection
    extends KmgModelAttribute
{
    //##################################################
    //# variables
    //##################################################

    private String        _name;
    private String        _comment;
    private KmgModelField _element;

    //##################################################
    //# constructor
    //##################################################

    public KmgModelValueCollection(KmgElement parent)
    {
        super(parent);
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return _name;
    }

    public String getComment()
    {
        return _comment;
    }

    public KmgModelField getElement()
    {
        return _element;
    }

    public KmgModelType getType()
    {
        return getElement().getType();
    }

    //##################################################
    //# public
    //##################################################

    @Override
    public void parse(KmStfElement e)
    {
        checkAttributeKeys(e, "name", "comment", "type");

        _name = parseRequiredNameAttribute(e);
        _comment = parseRequiredString(e, "comment");

        String typeName = parseRequiredString(e, "type");
        _element = new KmgModelField(this);
        _element.setName(_name);
        _element.setType(typeName);
    }

    @Override
    public void validate()
    {
        // none
    }

    @Override
    public void postValidate()
    {
        // none
    }

    //##################################################
    //# format
    //##################################################

    @Override
    public String getf_name()
    {
        return Kmu.pluralize(getName());
    }

    public String getf_singleName()
    {
        return getName();
    }

    public String getf_SingleName()
    {
        return Kmu.capitalizeFirstLetter(getf_singleName());
    }

    @Override
    public String getf_Type()
    {
        return formatList(getHibernateType().getJavaType(), getf_ElementType());
    }

    @Override
    public String getf_ImplType()
    {
        return formatList(getHibernateType().getJavaImpl(), getf_ElementType());
    }

    public String getf_WrapperType()
    {
        return formatList(getHibernateType().getJavaWrapper(), getf_ElementType());
    }

    public String getf_implGetMethod()
    {
        return "getBase" + getf_Name();
    }

    public String getf_ElementType()
    {
        return getElement().getf_Type();
    }

    public String getf_ElementName()
    {
        return getElement().getf_Name();
    }

    public String getf_sqlTable()
    {
        return getModel().getf_name() + "_" + getf_singleName();
    }

    public String getf_hibernateType()
    {
        return getHibernateType().getName();
    }

    public String getf_sqlModelColumn()
    {
        return getModel().getPrimaryKeyField().getf_sqlColumn();
    }

    public String getf_sqlValueColumn()
    {
        return getElement().getf_sqlColumn();
    }

    //##################################################
    //# support
    //##################################################

    private KmgModelHibernateCollectionType getHibernateType()
    {
        return KmgModelHibernateCollectionType.getType();
    }

}
