//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import com.kodemore.servlet.field.ScDomainDropdownField;

import com.app.filter.MyPerformanceLogFilter;
import com.app.finder.MyPerformanceLogFinder;
import com.app.model.MyPerformanceLog;
import com.app.model.core.MyAbstractDomainTools;
import com.app.model.meta.MyMetaPerformanceLog;

/**
 * Miscellaneous tools for use with the model.
 */
public abstract class MyPerformanceLogToolsBase
    extends MyAbstractDomainTools
{
    public static final MyMetaPerformanceLog Meta = MyPerformanceLog.Meta;

    public ScDomainDropdownField<MyPerformanceLog,Integer> newDomainDropdown()
    {
        ScDomainDropdownField<MyPerformanceLog,Integer> e;
        e = new ScDomainDropdownField<MyPerformanceLog,Integer>();
        e.setLabel(Meta.getLabel());
        e.setFilter(new MyPerformanceLogFilter());
        e.setFinder(new MyPerformanceLogFinder());
        e.setOptionKeyAdaptor(Meta.Id);
        return e;
    }
}
