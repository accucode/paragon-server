//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import com.app.filter.MyAccountFilter;
import com.app.finder.MyAccountFinder;
import com.app.model.MyAccount;
import com.app.model.core.MyAbstractDomainTools;
import com.app.model.meta.MyMetaAccount;

import com.kodemore.servlet.field.ScDomainDropdownField;

/**
 * Miscellaneous tools for use with the model.
 */
public abstract class MyAccountToolsBase
    extends MyAbstractDomainTools
{
    public static final MyMetaAccount Meta = MyAccount.Meta;

    public ScDomainDropdownField<MyAccount,String> newDomainDropdown()
    {
        ScDomainDropdownField<MyAccount,String> e;
        e = new ScDomainDropdownField<MyAccount,String>();
        e.setLabel(Meta.getLabel());
        e.setFilter(new MyAccountFilter());
        e.setFinder(new MyAccountFinder());
        e.setOptionKeyAdaptor(Meta.Uid);
        return e;
    }
}
