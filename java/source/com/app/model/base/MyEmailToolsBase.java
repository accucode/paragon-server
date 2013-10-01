//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import com.app.filter.MyEmailFilter;
import com.app.finder.MyEmailFinder;
import com.app.model.MyEmail;
import com.app.model.core.MyAbstractDomainTools;
import com.app.model.meta.MyMetaEmail;

import com.kodemore.servlet.field.ScDomainDropdownField;

/**
 * Miscellaneous tools for use with the model.
 */
public abstract class MyEmailToolsBase
    extends MyAbstractDomainTools
{
    public static final MyMetaEmail Meta = MyEmail.Meta;

    public ScDomainDropdownField<MyEmail,String> newDomainDropdown()
    {
        ScDomainDropdownField<MyEmail,String> e;
        e = new ScDomainDropdownField<MyEmail,String>();
        e.setLabel(Meta.getLabel());
        e.setFilter(new MyEmailFilter());
        e.setFinder(new MyEmailFinder());
        e.setOptionKeyAdaptor(Meta.Uid);
        return e;
    }
}
