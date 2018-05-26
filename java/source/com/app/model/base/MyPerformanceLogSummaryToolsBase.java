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
public abstract class MyPerformanceLogSummaryToolsBase
    extends MyAbstractDomainTools
{
//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

    public static final MyMetaPerformanceLogSummary Meta = MyPerformanceLogSummary.Meta;

    public ScDomainDropdownField<MyPerformanceLogSummary,String> newDomainDropdown()
    {
        ScDomainDropdownField<MyPerformanceLogSummary,String> e;
        e = new ScDomainDropdownField<>();
        e.setLabel(Meta.getLabel());
        e.setFinder(MyPerformanceLogSummary.Finder);
        e.setOptionSupplier(new MyPerformanceLogSummaryFilter().toSupplier());
        e.setOptionKeyFunction(Meta.Uid);
        e.setOptionLabelFunction(Meta.DomainTitle);
        e.setHelp(Meta.getHelp());
        return e;
    }
}
