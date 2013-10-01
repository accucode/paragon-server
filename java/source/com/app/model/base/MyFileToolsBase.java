//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import com.app.filter.MyFileFilter;
import com.app.finder.MyFileFinder;
import com.app.model.MyFile;
import com.app.model.core.MyAbstractDomainTools;
import com.app.model.meta.MyMetaFile;

import com.kodemore.servlet.field.ScDomainDropdownField;

/**
 * Miscellaneous tools for use with the model.
 */
public abstract class MyFileToolsBase
    extends MyAbstractDomainTools
{
    public static final MyMetaFile Meta = MyFile.Meta;

    public ScDomainDropdownField<MyFile,Integer> newDomainDropdown()
    {
        ScDomainDropdownField<MyFile,Integer> e;
        e = new ScDomainDropdownField<MyFile,Integer>();
        e.setLabel(Meta.getLabel());
        e.setFilter(new MyFileFilter());
        e.setFinder(new MyFileFinder());
        e.setOptionKeyAdaptor(Meta.Id);
        return e;
    }
}
