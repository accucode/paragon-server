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
public abstract class MyEmailRecipientToolsBase
    extends MyAbstractDomainTools
{
    public static final MyMetaEmailRecipient Meta = MyEmailRecipient.Meta;

    public ScDomainDropdownField<MyEmailRecipient,String> newDomainDropdown()
    {
        ScDomainDropdownField<MyEmailRecipient,String> e;
        e = new ScDomainDropdownField<>();
        e.setLabel(Meta.getLabel());
        e.setFilter(new MyEmailRecipientFilter());
        e.setFinder(new MyEmailRecipientFinder());
        e.setOptionKeyFunction(Meta.Uid);
        e.setOptionLabelFunction(Meta.DisplayString);
        e.setHelp(Meta.getHelp());
        return e;
    }
}
