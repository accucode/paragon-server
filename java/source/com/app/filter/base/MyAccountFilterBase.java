//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.filter.base;

import com.app.criteria.MyAccountCriteria;
import com.app.dao.MyAccountDao;
import com.app.dao.base.MyAccountDaoConstantsIF;
import com.app.filter.core.MyBasicFilter;
import com.app.model.MyAccount;
import com.app.model.meta.MyMetaAccount;

import com.kodemore.hibernate.criteria.KmModelCriteria;

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
