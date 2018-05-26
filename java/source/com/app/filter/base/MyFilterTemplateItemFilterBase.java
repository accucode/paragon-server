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

public abstract class MyFilterTemplateItemFilterBase
    extends MyBasicFilter<MyFilterTemplateItem>
    implements MyFilterTemplateItemDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyFilterTemplateItem> c)
    {
        applyConditionsTo((MyFilterTemplateItemCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyFilterTemplateItem> c)
    {
        applySortsTo((MyFilterTemplateItemCriteria)c);
    }

    protected abstract void applyConditionsTo(MyFilterTemplateItemCriteria c);

    protected abstract void applySortsTo(MyFilterTemplateItemCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaFilterTemplateItem getMeta()
    {
        return MyFilterTemplateItem.Meta;
    }

    @Override
    protected MyFilterTemplateItemDao getDao()
    {
        return getAccess().getFilterTemplateItemDao();
    }

    @Override
    protected MyFilterTemplateItemCriteria createCriteria()
    {
        return new MyFilterTemplateItemCriteria(_createCriteria());
    }
}
