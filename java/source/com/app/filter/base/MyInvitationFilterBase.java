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

public abstract class MyInvitationFilterBase
    extends MyBasicFilter<MyInvitation>
    implements MyInvitationDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyInvitation> c)
    {
        applyConditionsTo((MyInvitationCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyInvitation> c)
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
        return new MyInvitationCriteria(_createCriteria());
    }
}
