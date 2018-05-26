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

public class MyPatchJunction
    extends KmhModelJunction
    implements MyPatchDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyPatchJunction(KmhJunction context)
    {
        super(context);
    }

    //##################################################
    //# properties
    //##################################################

    public KmhTimestampCondition whereInstalledUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), INSTALLED_UTC_TS);
    }

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), alias(), NAME);
    }

    public KmhStringCondition whereSource()
    {
        return new KmhStringCondition(context(), alias(), SOURCE);
    }

    //##################################################
    //# associations
    //##################################################

    //##################################################
    //# junction
    //##################################################

    public MyPatchJunction addAnd()
    {
        return new MyPatchJunction(context().addAnd());
    }

    public MyPatchJunction addOr()
    {
        return new MyPatchJunction(context().addOr());
    }

}
