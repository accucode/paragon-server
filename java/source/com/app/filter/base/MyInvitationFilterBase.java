//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.filter.base;

import com.app.criteria.MyInvitationCriteria;
import com.app.dao.MyInvitationDao;
import com.app.dao.base.MyInvitationDaoConstantsIF;
import com.app.filter.core.MyBasicFilter;
import com.app.model.MyInvitation;
import com.app.model.meta.MyMetaInvitation;

import com.kodemore.hibernate.criteria.KmModelCriteria;

public abstract class MyInvitationFilterBase
    extends MyBasicFilter<MyInvitation>
    implements MyInvitationDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MyInvitation> c)
    {
        applyConditionsTo((MyInvitationCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MyInvitation> c)
    {
        applySortsTo((MyInvitationCriteria)c);
    }

    protected abstract void applyConditionsTo(MyInvitationCriteria c);

    protected abstract void applySortsTo(MyInvitationCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaInvitation getMeta()
    {
        return MyInvitation.Meta;
    }

    @Override
    protected MyInvitationDao getDao()
    {
        return getAccess().getInvitationDao();
    }

    @Override
    protected MyInvitationCriteria createCriteria()
    {
        return new MyInvitationCriteria(createGenericCriteria());
    }
}
