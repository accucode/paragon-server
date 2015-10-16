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

public abstract class MyShipAccountFilterBase
    extends MyBasicFilter<MyShipAccount>
    implements MyShipAccountDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyShipAccount> c)
    {
        applyConditionsTo((MyShipAccountCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyShipAccount> c)
    {
        applySortsTo((MyShipAccountCriteria)c);
    }

    protected abstract void applyConditionsTo(MyShipAccountCriteria c);

    protected abstract void applySortsTo(MyShipAccountCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaShipAccount getMeta()
    {
        return MyShipAccount.Meta;
    }

    @Override
    protected MyShipAccountDao getDao()
    {
        return getAccess().getShipAccountDao();
    }

    @Override
    protected MyShipAccountCriteria createCriteria()
    {
        return new MyShipAccountCriteria(_createCriteria());
    }
}
