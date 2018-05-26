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

public abstract class MyChoiceFilterBase
    extends MyBasicFilter<MyChoice>
    implements MyChoiceDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyChoice> c)
    {
        applyConditionsTo((MyChoiceCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyChoice> c)
    {
        applySortsTo((MyChoiceCriteria)c);
    }

    protected abstract void applyConditionsTo(MyChoiceCriteria c);

    protected abstract void applySortsTo(MyChoiceCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaChoice getMeta()
    {
        return MyChoice.Meta;
    }

    @Override
    protected MyChoiceDao getDao()
    {
        return getAccess().getChoiceDao();
    }

    @Override
    protected MyChoiceCriteria createCriteria()
    {
        return new MyChoiceCriteria(_createCriteria());
    }
}
