//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import com.kodemore.servlet.field.ScDomainDropdownField;

import com.app.filter.MyPasswordResetFilter;
import com.app.finder.MyPasswordResetFinder;
import com.app.model.MyPasswordReset;
import com.app.model.core.MyAbstractDomainTools;
import com.app.model.meta.MyMetaPasswordReset;

/**
 * Miscellaneous tools for use with the model.
 */
public abstract class MyPasswordResetToolsBase
    extends MyAbstractDomainTools
{
    public static final MyMetaPasswordReset Meta = MyPasswordReset.Meta;

    public ScDomainDropdownField<MyPasswordReset,String> newDomainDropdown()
    {
        ScDomainDropdownField<MyPasswordReset,String> e;
        e = new ScDomainDropdownField<MyPasswordReset,String>();
        e.setLabel(Meta.getLabel());
        e.setFilter(new MyPasswordResetFilter());
        e.setFinder(new MyPasswordResetFinder());
        e.setOptionKeyAdaptor(Meta.Uid);
        return e;
    }
}
