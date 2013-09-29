//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import com.app.filter.MyServerSessionFilter;
import com.app.finder.MyServerSessionFinder;
import com.app.model.MyServerSession;
import com.app.model.core.MyAbstractDomainTools;
import com.app.model.meta.MyMetaServerSession;

import com.kodemore.servlet.field.ScDomainDropdownField;

/**
 * Miscellaneous tools for use with the model.
 */
public abstract class MyServerSessionToolsBase
    extends MyAbstractDomainTools
{
    public static final MyMetaServerSession Meta = MyServerSession.Meta;

    public ScDomainDropdownField<MyServerSession,String> newDomainDropdown()
    {
        ScDomainDropdownField<MyServerSession,String> e;
        e = new ScDomainDropdownField<MyServerSession,String>();
        e.setLabel(Meta.getLabel());
        e.setFilter(new MyServerSessionFilter());
        e.setFinder(new MyServerSessionFinder());
        e.setOptionKeyAdaptor(Meta.Uid);
        return e;
    }
}
