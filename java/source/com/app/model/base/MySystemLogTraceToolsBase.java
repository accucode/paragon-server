//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import com.kodemore.servlet.field.ScDomainDropdownField;

import com.app.filter.MySystemLogTraceFilter;
import com.app.finder.MySystemLogTraceFinder;
import com.app.model.MySystemLogTrace;
import com.app.model.core.MyAbstractDomainTools;
import com.app.model.meta.MyMetaSystemLogTrace;

/**
 * Miscellaneous tools for use with the model.
 */
public abstract class MySystemLogTraceToolsBase
    extends MyAbstractDomainTools
{
    public static final MyMetaSystemLogTrace Meta = MySystemLogTrace.Meta;

    public ScDomainDropdownField<MySystemLogTrace,Integer> newDomainDropdown()
    {
        ScDomainDropdownField<MySystemLogTrace,Integer> e;
        e = new ScDomainDropdownField<MySystemLogTrace,Integer>();
        e.setLabel(Meta.getLabel());
        e.setFilter(new MySystemLogTraceFilter());
        e.setFinder(new MySystemLogTraceFinder());
        e.setOptionKeyAdaptor(Meta.Id);
        return e;
    }
}
