//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import com.kodemore.servlet.field.ScDomainDropdownField;

import com.app.filter.MyAccountUserFilter;
import com.app.finder.MyAccountUserFinder;
import com.app.model.MyAccountUser;
import com.app.model.core.MyAbstractDomainTools;
import com.app.model.meta.MyMetaAccountUser;

/**
 * Miscellaneous tools for use with the model.
 */
public abstract class MyAccountUserToolsBase
    extends MyAbstractDomainTools
{
    public static final MyMetaAccountUser Meta = MyAccountUser.Meta;

    public ScDomainDropdownField<MyAccountUser,String> newDomainDropdown()
    {
        ScDomainDropdownField<MyAccountUser,String> e;
        e = new ScDomainDropdownField<MyAccountUser,String>();
        e.setLabel(Meta.getLabel());
        e.setFilter(new MyAccountUserFilter());
        e.setFinder(new MyAccountUserFinder());
        e.setOptionKeyAdaptor(Meta.Uid);
        return e;
    }
}
