//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.filter.base;

import com.kodemore.collection.*;
import com.kodemore.hibernate.criteria.*;

import com.app.command.base.*;
import com.app.criteria.*;
import com.app.dao.*;
import com.app.dao.base.*;
import com.app.filter.*;
import com.app.filter.core.*;
import com.app.model.*;
import com.app.model.meta.*;

public abstract class MyAccountFilterBase
    extends MyBasicFilter<MyAccount>
    implements MyAccountDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MyAccount> c)
    {
        applyConditionsTo((MyAccountCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MyAccount> c)
    {
        applySortsTo((MyAccountCriteria)c);
    }

    protected abstract void applyConditionsTo(MyAccountCriteria c);

    protected abstract void applySortsTo(MyAccountCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaAccount getMeta()
    {
        return MyAccount.Meta;
    }

    @Override
    protected MyAccountDao getDao()
    {
        return getAccess().getAccountDao();
    }

    @Override
    protected MyAccountCriteria createCriteria()
    {
        return new MyAccountCriteria(createGenericCriteria());
    }
}
