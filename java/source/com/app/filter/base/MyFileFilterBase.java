//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.filter.base;

import com.app.criteria.MyFileCriteria;
import com.app.dao.MyFileDao;
import com.app.dao.base.MyFileDaoConstantsIF;
import com.app.filter.core.MyBasicFilter;
import com.app.model.MyFile;
import com.app.model.meta.MyMetaFile;

import com.kodemore.hibernate.criteria.KmModelCriteria;

public abstract class MyFileFilterBase
    extends MyBasicFilter<MyFile>
    implements MyFileDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MyFile> c)
    {
        applyConditionsTo((MyFileCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MyFile> c)
    {
        applySortsTo((MyFileCriteria)c);
    }

    protected abstract void applyConditionsTo(MyFileCriteria c);

    protected abstract void applySortsTo(MyFileCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaFile getMeta()
    {
        return MyFile.Meta;
    }

    @Override
    protected MyFileDao getDao()
    {
        return getAccess().getFileDao();
    }

    @Override
    protected MyFileCriteria createCriteria()
    {
        return new MyFileCriteria(createGenericCriteria());
    }
}
