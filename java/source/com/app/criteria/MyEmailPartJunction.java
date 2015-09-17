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

public class MyEmailPartJunction
    extends KmhModelJunction
    implements MyEmailPartDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyEmailPartJunction(KmhJunction context)
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

    public KmhIntegerCondition whereSequence()
    {
        return new KmhIntegerCondition(context(), fullName(SEQUENCE));
    }

    public KmhStringCondition whereTypeCode()
    {
        return new KmhStringCondition(context(), fullName(TYPE_CODE));
    }

    public KmhStringCondition whereAttachmentName()
    {
        return new KmhStringCondition(context(), fullName(ATTACHMENT_NAME));
    }

    public KmhPropertyCondition<KmBlob> whereData()
    {
        return new KmhPropertyCondition<>(context(), fullName(DATA));
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

    public MyEmailPartJunction addAnd()
    {
        return new MyEmailPartJunction(context().addAnd());
    }

    public MyEmailPartJunction addOr()
    {
        return new MyEmailPartJunction(context().addOr());
    }

}
