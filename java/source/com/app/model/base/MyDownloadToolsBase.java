//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import com.kodemore.servlet.field.ScDomainDropdownField;

import com.app.filter.MyDownloadFilter;
import com.app.finder.MyDownloadFinder;
import com.app.model.MyDownload;
import com.app.model.core.MyAbstractDomainTools;
import com.app.model.meta.MyMetaDownload;

/**
 * Miscellaneous tools for use with the model.
 */
public abstract class MyDownloadToolsBase
    extends MyAbstractDomainTools
{
    public static final MyMetaDownload Meta = MyDownload.Meta;

    public ScDomainDropdownField<MyDownload,String> newDomainDropdown()
    {
        ScDomainDropdownField<MyDownload,String> e;
        e = new ScDomainDropdownField<MyDownload,String>();
        e.setLabel(Meta.getLabel());
        e.setFilter(new MyDownloadFilter());
        e.setFinder(new MyDownloadFinder());
        e.setOptionKeyAdaptor(Meta.Uid);
        return e;
    }
}
