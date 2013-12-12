//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import com.kodemore.servlet.field.ScDomainDropdownField;

import com.app.filter.MyInvitationFilter;
import com.app.finder.MyInvitationFinder;
import com.app.model.MyInvitation;
import com.app.model.core.MyAbstractDomainTools;
import com.app.model.meta.MyMetaInvitation;

/**
 * Miscellaneous tools for use with the model.
 */
public abstract class MyInvitationToolsBase
    extends MyAbstractDomainTools
{
    public static final MyMetaInvitation Meta = MyInvitation.Meta;

    public ScDomainDropdownField<MyInvitation,String> newDomainDropdown()
    {
        ScDomainDropdownField<MyInvitation,String> e;
        e = new ScDomainDropdownField<MyInvitation,String>();
        e.setLabel(Meta.getLabel());
        e.setFilter(new MyInvitationFilter());
        e.setFinder(new MyInvitationFinder());
        e.setOptionKeyAdaptor(Meta.Uid);
        return e;
    }
}
