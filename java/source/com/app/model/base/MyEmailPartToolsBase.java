//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import com.app.filter.MyEmailPartFilter;
import com.app.finder.MyEmailPartFinder;
import com.app.model.MyEmailPart;
import com.app.model.core.MyAbstractDomainTools;
import com.app.model.meta.MyMetaEmailPart;

import com.kodemore.servlet.field.ScDomainDropdownField;

/**
 * Miscellaneous tools for use with the model.
 */
public abstract class MyEmailPartToolsBase
    extends MyAbstractDomainTools
{
    public static final MyMetaEmailPart Meta = MyEmailPart.Meta;

    public ScDomainDropdownField<MyEmailPart,String> newDomainDropdown()
    {
        ScDomainDropdownField<MyEmailPart,String> e;
        e = new ScDomainDropdownField<MyEmailPart,String>();
        e.setLabel(Meta.getLabel());
        e.setFilter(new MyEmailPartFilter());
        e.setFinder(new MyEmailPartFinder());
        e.setOptionKeyAdaptor(Meta.Uid);
        return e;
    }
}
