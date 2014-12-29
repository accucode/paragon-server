//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import java.util.*;

import com.kodemore.collection.*;
import com.kodemore.exception.*;
import com.kodemore.servlet.action.*;
import com.kodemore.servlet.control.*;
import com.kodemore.servlet.field.*;
import com.kodemore.time.*;
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.filter.*;
import com.app.finder.*;
import com.app.model.*;
import com.app.model.core.*;
import com.app.model.meta.*;
import com.app.utility.*;

/**
 * Miscellaneous tools for use with the model.
 */
public abstract class MyApplicationLogToolsBase
    extends MyAbstractDomainTools
{
    public static final MyMetaApplicationLog Meta = MyApplicationLog.Meta;

    public ScDomainDropdownField<MyApplicationLog,Integer> newDomainDropdown()
    {
        ScDomainDropdownField<MyApplicationLog,Integer> e;
        e = new ScDomainDropdownField<>();
        e.setLabel(Meta.getLabel());
        e.setFilter(new MyApplicationLogFilter());
        e.setFinder(new MyApplicationLogFinder());
        e.setOptionKeyAdaptor(Meta.Id);
        return e;
    }
}
