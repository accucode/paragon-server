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
import com.app.model.*;
import com.app.model.core.*;
import com.app.model.meta.*;
import com.app.utility.*;

/**
 * Miscellaneous tools for use with the model.
 */
public abstract class MyOptimisticLockToolsBase
    extends MyAbstractDomainTools
{
//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

    public static final MyMetaOptimisticLock Meta = MyOptimisticLock.Meta;

    public ScDomainDropdownField<MyOptimisticLock,String> newDomainDropdown()
    {
        ScDomainDropdownField<MyOptimisticLock,String> e;
        e = new ScDomainDropdownField<>();
        e.setLabel(Meta.getLabel());
        e.setFinder(MyOptimisticLock.Finder);
        e.setOptionSupplier(new MyOptimisticLockFilter().toSupplier());
        e.setOptionKeyFunction(Meta.Name);
        e.setOptionLabelFunction(Meta.DomainTitle);
        e.setHelp(Meta.getHelp());
        return e;
    }
}
