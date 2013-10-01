//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import com.app.filter.MyEmailRecipientFilter;
import com.app.finder.MyEmailRecipientFinder;
import com.app.model.MyEmailRecipient;
import com.app.model.core.MyAbstractDomainTools;
import com.app.model.meta.MyMetaEmailRecipient;

import com.kodemore.servlet.field.ScDomainDropdownField;

/**
 * Miscellaneous tools for use with the model.
 */
public abstract class MyEmailRecipientToolsBase
    extends MyAbstractDomainTools
{
    public static final MyMetaEmailRecipient Meta = MyEmailRecipient.Meta;

    public ScDomainDropdownField<MyEmailRecipient,String> newDomainDropdown()
    {
        ScDomainDropdownField<MyEmailRecipient,String> e;
        e = new ScDomainDropdownField<MyEmailRecipient,String>();
        e.setLabel(Meta.getLabel());
        e.setFilter(new MyEmailRecipientFilter());
        e.setFinder(new MyEmailRecipientFinder());
        e.setOptionKeyAdaptor(Meta.Uid);
        return e;
    }
}
