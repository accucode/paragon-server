//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import com.kodemore.servlet.field.ScDomainDropdownField;

import com.app.filter.MySystemLogFilter;
import com.app.finder.MySystemLogFinder;
import com.app.model.MySystemLog;
import com.app.model.core.MyAbstractDomainTools;
import com.app.model.meta.MyMetaSystemLog;

/**
 * Miscellaneous tools for use with the model.
 */
public abstract class MySystemLogToolsBase
    extends MyAbstractDomainTools
{
    public static final MyMetaSystemLog Meta = MySystemLog.Meta;

    public ScDomainDropdownField<MySystemLog,Integer> newDomainDropdown()
    {
        ScDomainDropdownField<MySystemLog,Integer> e;
        e = new ScDomainDropdownField<MySystemLog,Integer>();
        e.setLabel(Meta.getLabel());
        e.setFilter(new MySystemLogFilter());
        e.setFinder(new MySystemLogFinder());
        e.setOptionKeyAdaptor(Meta.Id);
        return e;
    }
}
