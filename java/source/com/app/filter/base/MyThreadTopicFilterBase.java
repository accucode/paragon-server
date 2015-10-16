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

public abstract class MyThreadTopicFilterBase
    extends MyBasicFilter<MyThreadTopic>
    implements MyThreadTopicDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyThreadTopic> c)
    {
        applyConditionsTo((MyThreadTopicCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyThreadTopic> c)
    {
        applySortsTo((MyThreadTopicCriteria)c);
    }

    protected abstract void applyConditionsTo(MyThreadTopicCriteria c);

    protected abstract void applySortsTo(MyThreadTopicCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaThreadTopic getMeta()
    {
        return MyThreadTopic.Meta;
    }

    @Override
    protected MyThreadTopicDao getDao()
    {
        return getAccess().getThreadTopicDao();
    }

    @Override
    protected MyThreadTopicCriteria createCriteria()
    {
        return new MyThreadTopicCriteria(_createCriteria());
    }
}
