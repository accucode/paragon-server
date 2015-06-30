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
public abstract class MyApplicationLogTraceToolsBase
    extends MyAbstractDomainTools
{
    public static final MyMetaApplicationLogTrace Meta = MyApplicationLogTrace.Meta;

    public ScDomainDropdownField<MyApplicationLogTrace,Integer> newDomainDropdown()
    {
        ScDomainDropdownField<MyApplicationLogTrace,Integer> e;
        e = new ScDomainDropdownField<>();
        e.setLabel(Meta.getLabel());
        e.setFilter(new MyApplicationLogTraceFilter());
        e.setFinder(new MyApplicationLogTraceFinder());
        e.setOptionKeyAdaptor(Meta.Id);
        return e;
    }
}