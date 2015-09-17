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

public abstract class MyFileFilterBase
    extends MyBasicFilter<MyFile>
    implements MyFileDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyFile> c)
    {
        applyConditionsTo((MyFileCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyFile> c)
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
        return new MyFileCriteria(_createCriteria());
    }
}
