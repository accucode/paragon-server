//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.filter.base;

import com.kodemore.collection.*;
import com.kodemore.hibernate.*;

import com.app.command.base.*;
import com.app.criteria.*;
import com.app.dao.*;
import com.app.dao.base.*;
import com.app.filter.*;
import com.app.filter.core.*;
import com.app.model.*;
import com.app.model.meta.*;

public abstract class MySiteContactFilterBase
    extends MyBasicFilter<MySiteContact>
    implements MySiteContactDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MySiteContact> c)
    {
        applyConditionsTo((MySiteContactCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MySiteContact> c)
    {
        applySortsTo((MySiteContactCriteria)c);
    }

    protected abstract void applyConditionsTo(MySiteContactCriteria c);

    protected abstract void applySortsTo(MySiteContactCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaSiteContact getMeta()
    {
        return MySiteContact.Meta;
    }

    @Override
    protected MySiteContactDao getDao()
    {
        return getAccess().getSiteContactDao();
    }

    @Override
    protected MySiteContactCriteria createCriteria()
    {
        return new MySiteContactCriteria(_createCriteria());
    }
}
