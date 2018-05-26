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

public abstract class MyAttachmentFilterBase
    extends MyBasicFilter<MyAttachment>
    implements MyAttachmentDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyAttachment> c)
    {
        applyConditionsTo((MyAttachmentCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyAttachment> c)
    {
        applySortsTo((MyAttachmentCriteria)c);
    }

    protected abstract void applyConditionsTo(MyAttachmentCriteria c);

    protected abstract void applySortsTo(MyAttachmentCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaAttachment getMeta()
    {
        return MyAttachment.Meta;
    }

    @Override
    protected MyAttachmentDao getDao()
    {
        return getAccess().getAttachmentDao();
    }

    @Override
    protected MyAttachmentCriteria createCriteria()
    {
        return new MyAttachmentCriteria(_createCriteria());
    }
}
