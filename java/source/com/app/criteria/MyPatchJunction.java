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

public class MyPatchJunction
    extends KmModelJunction
    implements MyPatchDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyPatchJunction(KmJunction context)
    {
        super(context);
    }

    public MyPatchJunction(KmJunction context, KmAbstractCriteria parent)
    {
        super(context, parent);
    }

    //##################################################
    //# properties
    //##################################################

    public KmStringCriteria whereName()
    {
        return new KmStringCriteria(context(), fullName(NAME));
    }

    public KmPropertyCriteria<KmTimestamp> whereInstalledUtcTs()
    {
        return new KmPropertyCriteria<>(context(), fullName(INSTALLED_UTC_TS));
    }

    public KmStringCriteria whereSource()
    {
        return new KmStringCriteria(context(), fullName(SOURCE));
    }

    //##################################################
    //# associations
    //##################################################

    //##################################################
    //# junction
    //##################################################

    public MyPatchJunction addAnd()
    {
        return new MyPatchJunction(context().addAnd(), parent());
    }

    public MyPatchJunction addOr()
    {
        return new MyPatchJunction(context().addOr(), parent());
    }

}
