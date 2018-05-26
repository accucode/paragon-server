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

public abstract class MyEmailTemplateFilterBase
    extends MyBasicFilter<MyEmailTemplate>
    implements MyEmailTemplateDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyEmailTemplate> c)
    {
        applyConditionsTo((MyEmailTemplateCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyEmailTemplate> c)
    {
        applySortsTo((MyEmailTemplateCriteria)c);
    }

    protected abstract void applyConditionsTo(MyEmailTemplateCriteria c);

    protected abstract void applySortsTo(MyEmailTemplateCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaEmailTemplate getMeta()
    {
        return MyEmailTemplate.Meta;
    }

    @Override
    protected MyEmailTemplateDao getDao()
    {
        return getAccess().getEmailTemplateDao();
    }

    @Override
    protected MyEmailTemplateCriteria createCriteria()
    {
        return new MyEmailTemplateCriteria(_createCriteria());
    }
}
