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

public class MyPowerTypeJunction
    extends KmModelJunction
    implements MyPowerTypeDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyPowerTypeJunction(KmJunction context)
    {
        super(context);
    }

    public MyPowerTypeJunction(KmJunction context, KmAbstractCriteria parent)
    {
        super(context, parent);
    }

    //##################################################
    //# properties
    //##################################################

    public KmStringCriteria whereUid()
    {
        return new KmStringCriteria(context(), fullName(UID));
    }

    public KmStringCriteria whereName()
    {
        return new KmStringCriteria(context(), fullName(NAME));
    }

    public KmIntegerCriteria whereLockVersion()
    {
        return new KmIntegerCriteria(context(), fullName(LOCK_VERSION));
    }

    //##################################################
    //# associations
    //##################################################

    public MyProjectCriteria joinToProject()
    {
        return join(new MyProjectCriteria(root().joinTo(PROJECT)));
    }

    public MyProjectCriteria leftJoinToProject()
    {
        return join(new MyProjectCriteria(root().leftJoinTo(PROJECT)));
    }

    public KmStringCriteria whereProjectUid()
    {
        return new KmStringCriteria(context(), fullName(PROJECT_UID));
    }

    //##################################################
    //# junction
    //##################################################

    public MyPowerTypeJunction addAnd()
    {
        return new MyPowerTypeJunction(context().addAnd(), parent());
    }

    public MyPowerTypeJunction addOr()
    {
        return new MyPowerTypeJunction(context().addOr(), parent());
    }

}
