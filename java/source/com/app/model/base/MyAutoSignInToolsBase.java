//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import com.app.filter.MyAutoSignInFilter;
import com.app.finder.MyAutoSignInFinder;
import com.app.model.MyAutoSignIn;
import com.app.model.core.MyAbstractDomainTools;
import com.app.model.meta.MyMetaAutoSignIn;

import com.kodemore.servlet.field.ScDomainDropdownField;

/**
 * Miscellaneous tools for use with the model.
 */
public abstract class MyAutoSignInToolsBase
    extends MyAbstractDomainTools
{
    public static final MyMetaAutoSignIn Meta = MyAutoSignIn.Meta;

    public ScDomainDropdownField<MyAutoSignIn,String> newDomainDropdown()
    {
        ScDomainDropdownField<MyAutoSignIn,String> e;
        e = new ScDomainDropdownField<MyAutoSignIn,String>();
        e.setLabel(Meta.getLabel());
        e.setFilter(new MyAutoSignInFilter());
        e.setFinder(new MyAutoSignInFinder());
        e.setOptionKeyAdaptor(Meta.Uid);
        return e;
    }
}
