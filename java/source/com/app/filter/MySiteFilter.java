package com.app.filter;

import com.kodemore.collection.KmList;
import com.kodemore.utility.KmEnumIF;

import com.app.criteria.MySiteCriteria;
import com.app.filter.base.MySiteFilterBase;
import com.app.filter.value.MyFilterBooleanValue;
import com.app.filter.value.MyFilterCustomerValue;
import com.app.filter.value.MyFilterChoiceValue;
import com.app.filter.value.MyFilterProjectValue;
import com.app.filter.value.MyFilterStringValue;
import com.app.model.MyCustomer;
import com.app.model.MyFilterTemplate;
import com.app.model.MyProject;
import com.app.model.MyChoice;
import com.app.model.base.MyFilterTemplateContextType;

public class MySiteFilter
    extends MySiteFilterBase
{
    //##################################################
    //# sort (enum)
    //##################################################

    private static enum Sort
        implements KmEnumIF
    {
        // CODES ARE STORED IN DATABASE

        number("number");

        private String _code;

        private Sort(String code)
        {
            _code = code;
        }

        @Override
        public String getCode()
        {
            return _code;
        }
    }

    //##################################################
    //# attributes (enum)
    //##################################################

    private static enum Attribute
        implements KmEnumIF
    {
        // CODES ARE STORED IN DATABASE

        sortCode("sortCode"),
        quickSearch("quickSearch"),
        project("project"),
        customer("customer"),
        nameSubstring("nameSubstring"),
        number("number"),
        typeName("typeName"),
        cableTypeName("cableTypeName"),
        enabled("enabled");

        private String _code;

        private Attribute(String code)
        {
            _code = code;
        }

        @Override
        public String getCode()
        {
            return _code;
        }
    }

    //##################################################
    //# variables
    //##################################################

    private MyFilterStringValue   _sortCode;
    private MyFilterStringValue   _quickSearch;
    private MyFilterProjectValue  _project;
    private MyFilterCustomerValue _customer;
    private MyFilterStringValue   _number;
    private MyFilterStringValue   _nameSubstring;
    private MyFilterChoiceValue   _type;
    private MyFilterChoiceValue   _cableType;
    private MyFilterBooleanValue  _enabled;

    //##################################################
    //# constructor
    //##################################################

    public MySiteFilter()
    {
        setSort(Sort.values()[0]);
    }

    @Override
    protected void installValues()
    {
        _sortCode = addStringValue(Attribute.sortCode);
        _quickSearch = addStringValue(Attribute.quickSearch);
        _project = addProjectValue(Attribute.project);
        _customer = addCustomerValue(Attribute.customer);
        _number = addStringValue(Attribute.number);
        _nameSubstring = addStringValue(Attribute.nameSubstring);
        _type = addProjectOptionValue(Attribute.typeName);
        _cableType = addProjectOptionValue(Attribute.cableTypeName);
        _enabled = addBooleanValue(Attribute.enabled);
    }

    //##################################################
    //# sort
    //##################################################

    public void sortOnNumber()
    {
        setSort(Sort.number);
    }

    //==================================================
    //= sort code
    //==================================================

    public String getSortCode()
    {
        return _sortCode.getValue();
    }

    public void setSortCode(String e)
    {
        _sortCode.setValue(e);
    }

    public void resetSortCode()
    {
        _sortCode.reset();
    }

    public boolean usesSortCode()
    {
        return _sortCode.isUsed();
    }

    //==================================================
    //= sort value
    //==================================================

    public Sort getSort()
    {
        return usesSortCode()
            ? Sort.valueOf(getSortCode())
            : null;
    }

    public void setSort(Sort e)
    {
        if ( e == null )
            resetSortCode();
        else
            setSortCode(e.getCode());
    }

    //##################################################
    //# quickSearch
    //##################################################

    public String getQuickSearch()
    {
        return _quickSearch.getValue();
    }

    @Override
    public void setQuickSearch(String e)
    {
        _quickSearch.setValue(e);
    }

    public void resetQuickSearch()
    {
        _quickSearch.reset();
    }

    public boolean usesQuickSearch()
    {
        return _quickSearch.isUsed();
    }

    //##################################################
    //# project
    //##################################################

    public MyProject getProject()
    {
        return _project.getValue();
    }

    public void setProject(MyProject e)
    {
        _project.setValue(e);
    }

    public void resetProject()
    {
        _project.reset();
    }

    public boolean usesProject()
    {
        return _project.isUsed();
    }

    //##################################################
    //# customer
    //##################################################

    public MyCustomer getCustomer()
    {
        return _customer.getValue();
    }

    public void setCustomer(MyCustomer e)
    {
        _customer.setValue(e);
    }

    public void resetCustomer()
    {
        _customer.reset();
    }

    public boolean usesCustomer()
    {
        return _customer.isUsed();
    }

    //##################################################
    //# number
    //##################################################

    public String getNumber()
    {
        return _number.getValue();
    }

    public void setNumber(String e)
    {
        _number.setValue(e);
    }

    public void resetNumber()
    {
        _number.reset();
    }

    public boolean usesNumber()
    {
        return _number.isUsed();
    }

    //##################################################
    //# nameSubstring
    //##################################################

    public String getNameSubstring()
    {
        return _nameSubstring.getValue();
    }

    public void setNameSubstring(String e)
    {
        _nameSubstring.setValue(e);
    }

    public void resetNameSubstring()
    {
        _nameSubstring.reset();
    }

    public boolean usesNameSubstring()
    {
        return _nameSubstring.isUsed();
    }

    //##################################################
    //# type name
    //##################################################

    public MyChoice getType()
    {
        return _type.getValue();
    }

    public void setType(MyChoice e)
    {
        _type.setValue(e);
    }

    public void resetType()
    {
        _type.reset();
    }

    public boolean usesType()
    {
        return _type.isUsed();
    }

    //##################################################
    //# cable type name
    //##################################################

    public MyChoice getCableType()
    {
        return _cableType.getValue();
    }

    public void setCableType(MyChoice e)
    {
        _cableType.setValue(e);
    }

    public void resetCableType()
    {
        _cableType.reset();
    }

    public boolean usesCableType()
    {
        return _cableType.isUsed();
    }

    //##################################################
    //# active
    //##################################################

    public Boolean getEnabled()
    {
        return _enabled.getValue();
    }

    public void setEnabled(Boolean e)
    {
        _enabled.setValue(e);
    }

    public void resetEnabled()
    {
        _enabled.reset();
    }

    public boolean usesEnabled()
    {
        return _enabled.isUsed();
    }

    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(MySiteCriteria c)
    {
        if ( usesQuickSearch() )
            c.whereFullName().hasSubstring(getQuickSearch());

        if ( usesProject() )
            c.joinToCustomer().whereProjectIs(getProject());

        if ( usesCustomer() )
            c.whereCustomerIs(getCustomer());

        if ( usesNumber() )
            c.whereNumber().is(getNumber());

        if ( usesNameSubstring() )
            c.whereName().hasSubstring(getNameSubstring());

        if ( usesType() )
            c.whereTypeIs(getType());

        if ( usesEnabled() )
            c.whereEnabled().is(getEnabled());
    }

    @Override
    protected void applySortsTo(MySiteCriteria c)
    {
        if ( !usesSortCode() )
            return;

        switch ( getSort() )
        {
            case number:
                c.sortOnNumber();
                c.sortOnUid();
                break;
        }
    }

    //##################################################
    //# templates
    //##################################################

    @Override
    public MyProject getTemplateProject()
    {
        return getProject();
    }

    @Override
    public MyFilterTemplateContextType getTemplateContextType()
    {
        return MyFilterTemplateContextType.Site;
    }

    //==================================================
    //= template :: predefined
    //==================================================

    public static KmList<MyFilterTemplate> getPredefinedTemplatesFor(MyProject project)
    {
        KmList<MyFilterTemplate> v;
        v = new KmList<>();
        v.add(createPredefinedEnabledTemplateFor(project));
        v.add(createPredefinedDisabledTemplateFor(project));
        v.getFirst().setPreferred(true);
        return v;
    }

    private static MyFilterTemplate createPredefinedEnabledTemplateFor(MyProject project)
    {
        MySiteFilter f;
        f = new MySiteFilter();
        f.setProject(project);
        f.setEnabled(true);
        f.sortOnNumber();
        return f.toPredefinedTemplate("Sites");
    }

    private static MyFilterTemplate createPredefinedDisabledTemplateFor(MyProject project)
    {
        MySiteFilter f;
        f = new MySiteFilter();
        f.setProject(project);
        f.setEnabled(false);
        f.sortOnNumber();
        return f.toPredefinedTemplate("Inactive");
    }

}
