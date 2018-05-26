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

public abstract class MyFilterTemplateFilterBase
    extends MyBasicFilter<MyFilterTemplate>
    implements MyFilterTemplateDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyFilterTemplate> c)
    {
        applyConditionsTo((MyFilterTemplateCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyFilterTemplate> c)
    {
        applySortsTo((MyFilterTemplateCriteria)c);
    }

    protected abstract void applyConditionsTo(MyFilterTemplateCriteria c);

    protected abstract void applySortsTo(MyFilterTemplateCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaFilterTemplate getMeta()
    {
        return MyFilterTemplate.Meta;
    }

    @Override
    protected MyFilterTemplateDao getDao()
    {
        return getAccess().getFilterTemplateDao();
    }

    @Override
    protected MyFilterTemplateCriteria createCriteria()
    {
        return new MyFilterTemplateCriteria(_createCriteria());
    }
}
