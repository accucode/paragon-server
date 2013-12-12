//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import com.kodemore.servlet.field.ScDomainDropdownField;

import com.app.filter.MyPatchFilter;
import com.app.finder.MyPatchFinder;
import com.app.model.MyPatch;
import com.app.model.core.MyAbstractDomainTools;
import com.app.model.meta.MyMetaPatch;

/**
 * Miscellaneous tools for use with the model.
 */
public abstract class MyPatchToolsBase
    extends MyAbstractDomainTools
{
    public static final MyMetaPatch Meta = MyPatch.Meta;

    public ScDomainDropdownField<MyPatch,String> newDomainDropdown()
    {
        ScDomainDropdownField<MyPatch,String> e;
        e = new ScDomainDropdownField<MyPatch,String>();
        e.setLabel(Meta.getLabel());
        e.setFilter(new MyPatchFilter());
        e.setFinder(new MyPatchFinder());
        e.setOptionKeyAdaptor(Meta.Name);
        return e;
    }
}
