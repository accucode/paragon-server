//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import com.app.filter.MySettingsFilter;
import com.app.finder.MySettingsFinder;
import com.app.model.MySettings;
import com.app.model.core.MyAbstractDomainTools;
import com.app.model.meta.MyMetaSettings;

import com.kodemore.servlet.field.ScDomainDropdownField;

/**
 * Miscellaneous tools for use with the model.
 */
public abstract class MySettingsToolsBase
    extends MyAbstractDomainTools
{
    public static final MyMetaSettings Meta = MySettings.Meta;

    public ScDomainDropdownField<MySettings,Integer> newDomainDropdown()
    {
        ScDomainDropdownField<MySettings,Integer> e;
        e = new ScDomainDropdownField<MySettings,Integer>();
        e.setLabel(Meta.getLabel());
        e.setFilter(new MySettingsFilter());
        e.setFinder(new MySettingsFinder());
        e.setOptionKeyAdaptor(Meta.Code);
        return e;
    }
}
