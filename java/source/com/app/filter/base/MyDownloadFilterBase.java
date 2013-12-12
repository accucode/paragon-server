//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.filter.base;

import com.kodemore.hibernate.criteria.KmModelCriteria;

import com.app.criteria.MyDownloadCriteria;
import com.app.dao.MyDownloadDao;
import com.app.dao.base.MyDownloadDaoConstantsIF;
import com.app.filter.core.MyBasicFilter;
import com.app.model.MyDownload;
import com.app.model.meta.MyMetaDownload;

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
