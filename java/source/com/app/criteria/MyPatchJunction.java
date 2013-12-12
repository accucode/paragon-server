//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.criteria;

import com.kodemore.hibernate.criteria.KmAbstractCriteria;
import com.kodemore.hibernate.criteria.KmJunction;
import com.kodemore.hibernate.criteria.KmModelJunction;
import com.kodemore.hibernate.criteria.KmPropertyCriteria;
import com.kodemore.hibernate.criteria.KmStringCriteria;
import com.kodemore.time.KmTimestamp;

import com.app.dao.base.MyPatchDaoConstantsIF;
import com.app.model.MyPatch;

public class MyPatchJunction
    extends KmModelJunction<MyPatch>
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
        return new KmPropertyCriteria<KmTimestamp>(context(), fullName(INSTALLED_UTC_TS));
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
