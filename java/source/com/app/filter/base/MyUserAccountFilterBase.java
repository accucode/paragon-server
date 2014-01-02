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

public abstract class MyUserAccountFilterBase
    extends MyBasicFilter<MyUserAccount>
    implements MyUserAccountDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MyUserAccount> c)
    {
        applyConditionsTo((MyUserAccountCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MyUserAccount> c)
    {
        applySortsTo((MyUserAccountCriteria)c);
    }

    protected abstract void applyConditionsTo(MyUserAccountCriteria c);

    protected abstract void applySortsTo(MyUserAccountCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaUserAccount getMeta()
    {
        return MyUserAccount.Meta;
    }

    @Override
    protected MyUserAccountDao getDao()
    {
        return getAccess().getUserAccountDao();
    }

    @Override
    protected MyUserAccountCriteria createCriteria()
    {
        return new MyUserAccountCriteria(createGenericCriteria());
    }
}
