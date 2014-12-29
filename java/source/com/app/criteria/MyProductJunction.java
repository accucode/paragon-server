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

public class MyProductJunction
    extends KmModelJunction
    implements MyProductDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyProductJunction(KmJunction context)
    {
        super(context);
    }

    public MyProductJunction(KmJunction context, KmAbstractCriteria parent)
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

    public MyCategoryCriteria joinToCategory()
    {
        return join(new MyCategoryCriteria(root().joinTo(CATEGORY)));
    }

    public MyCategoryCriteria leftJoinToCategory()
    {
        return join(new MyCategoryCriteria(root().leftJoinTo(CATEGORY)));
    }

    public KmStringCriteria whereCategoryUid()
    {
        return new KmStringCriteria(context(), fullName(CATEGORY_UID));
    }

    //##################################################
    //# junction
    //##################################################

    public MyProductJunction addAnd()
    {
        return new MyProductJunction(context().addAnd(), parent());
    }

    public MyProductJunction addOr()
    {
        return new MyProductJunction(context().addOr(), parent());
    }

}
