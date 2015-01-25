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

public abstract class MyDownloadFilterBase
    extends MyBasicFilter<MyDownload>
    implements MyDownloadDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MyDownload> c)
    {
        applyConditionsTo((MyDownloadCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MyDownload> c)
    {
        applySortsTo((MyDownloadCriteria)c);
    }

    protected abstract void applyConditionsTo(MyDownloadCriteria c);

    protected abstract void applySortsTo(MyDownloadCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaDownload getMeta()
    {
        return MyDownload.Meta;
    }

    @Override
    protected MyDownloadDao getDao()
    {
        return getAccess().getDownloadDao();
    }

    @Override
    protected MyDownloadCriteria createCriteria()
    {
        return new MyDownloadCriteria(createGenericCriteria());
    }
}
