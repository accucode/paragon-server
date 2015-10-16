//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.criteria;

import com.kodemore.collection.*;
import com.kodemore.hibernate.*;
import com.kodemore.hibernate.basic.*;
import com.kodemore.time.*;
import com.kodemore.types.*;

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;

public class MyShipAccountJunction
    extends KmhModelJunction
    implements MyShipAccountDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyShipAccountJunction(KmhJunction context)
    {
        super(context);
    }

    //##################################################
    //# properties
    //##################################################

    public KmhStringCondition whereUid()
    {
        return new KmhStringCondition(context(), fullName(UID));
    }

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), fullName(NAME));
    }

    public KmhStringCondition whereDescription()
    {
        return new KmhStringCondition(context(), fullName(DESCRIPTION));
    }

    public KmhBooleanCondition whereBilledToCustomer()
    {
        return new KmhBooleanCondition(context(), fullName(BILLED_TO_CUSTOMER));
    }

    public KmhStringCondition whereShipOnAccountName()
    {
        return new KmhStringCondition(context(), fullName(SHIP_ON_ACCOUNT_NAME));
    }

    public KmhStringCondition whereShipOnAccountNumber()
    {
        return new KmhStringCondition(context(), fullName(SHIP_ON_ACCOUNT_NUMBER));
    }

    public KmhStringCondition whereBillToTypeCode()
    {
        return new KmhStringCondition(context(), fullName(BILL_TO_TYPE_CODE));
    }

    public KmhStringCondition whereBillToAccount()
    {
        return new KmhStringCondition(context(), fullName(BILL_TO_ACCOUNT));
    }

    public KmhIntegerCondition whereLockVersion()
    {
        return new KmhIntegerCondition(context(), fullName(LOCK_VERSION));
    }

    //##################################################
    //# associations
    //##################################################

    //##################################################
    //# junction
    //##################################################

    public MyShipAccountJunction addAnd()
    {
        return new MyShipAccountJunction(context().addAnd());
    }

    public MyShipAccountJunction addOr()
    {
        return new MyShipAccountJunction(context().addOr());
    }

}
