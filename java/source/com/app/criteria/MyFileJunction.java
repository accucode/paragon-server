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
import com.kodemore.hibernate.criteria.*;
import com.kodemore.time.*;
import com.kodemore.types.*;

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;

public class MyFileJunction
    extends KmModelJunction<MyFile>
    implements MyFileDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyFileJunction(KmJunction context)
    {
        super(context);
    }

    public MyFileJunction(KmJunction context, KmAbstractCriteria parent)
    {
        super(context, parent);
    }

    //##################################################
    //# properties
    //##################################################

    public KmIntegerCriteria whereId()
    {
        return new KmIntegerCriteria(context(), fullName(ID));
    }

    public KmStringCriteria whereName()
    {
        return new KmStringCriteria(context(), fullName(NAME));
    }

    public KmStringCriteria wherePath()
    {
        return new KmStringCriteria(context(), fullName(PATH));
    }

    public KmPropertyCriteria<KmTimestamp> whereCreatedUtcTs()
    {
        return new KmPropertyCriteria<KmTimestamp>(context(), fullName(CREATED_UTC_TS));
    }

    public KmStringCriteria whereStatusCode()
    {
        return new KmStringCriteria(context(), fullName(STATUS_CODE));
    }

    public KmIntegerCriteria whereSize()
    {
        return new KmIntegerCriteria(context(), fullName(SIZE));
    }

    public KmIntegerCriteria wherePartialSize()
    {
        return new KmIntegerCriteria(context(), fullName(PARTIAL_SIZE));
    }

    public KmIntegerCriteria whereLockVersion()
    {
        return new KmIntegerCriteria(context(), fullName(LOCK_VERSION));
    }

    //##################################################
    //# associations
    //##################################################

    //##################################################
    //# junction
    //##################################################

    public MyFileJunction addAnd()
    {
        return new MyFileJunction(context().addAnd(), parent());
    }

    public MyFileJunction addOr()
    {
        return new MyFileJunction(context().addOr(), parent());
    }

}
