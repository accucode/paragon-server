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

public abstract class MyFeedbackFilterBase
    extends MyBasicFilter<MyFeedback>
    implements MyFeedbackDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyFeedback> c)
    {
        applyConditionsTo((MyFeedbackCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyFeedback> c)
    {
        applySortsTo((MyFeedbackCriteria)c);
    }

    protected abstract void applyConditionsTo(MyFeedbackCriteria c);

    protected abstract void applySortsTo(MyFeedbackCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaFeedback getMeta()
    {
        return MyFeedback.Meta;
    }

    @Override
    protected MyFeedbackDao getDao()
    {
        return getAccess().getFeedbackDao();
    }

    @Override
    protected MyFeedbackCriteria createCriteria()
    {
        return new MyFeedbackCriteria(_createCriteria());
    }
}
