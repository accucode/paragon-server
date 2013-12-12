//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import com.kodemore.servlet.field.ScDomainDropdownField;

import com.app.filter.MyUserFilter;
import com.app.finder.MyUserFinder;
import com.app.model.MyUser;
import com.app.model.core.MyAbstractDomainTools;
import com.app.model.meta.MyMetaUser;

/**
 * Miscellaneous tools for use with the model.
 */
public abstract class MyUserToolsBase
    extends MyAbstractDomainTools
{
    public static final MyMetaUser Meta = MyUser.Meta;

    public ScDomainDropdownField<MyUser,String> newDomainDropdown()
    {
        ScDomainDropdownField<MyUser,String> e;
        e = new ScDomainDropdownField<MyUser,String>();
        e.setLabel(Meta.getLabel());
        e.setFilter(new MyUserFilter());
        e.setFinder(new MyUserFinder());
        e.setOptionKeyAdaptor(Meta.Uid);
        return e;
    }
}
