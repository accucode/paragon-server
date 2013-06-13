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

public abstract class MySettingsFilterBase
    extends MyBasicFilter<MySettings>
    implements MySettingsDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MySettings> c)
    {
        applyConditionsTo((MySettingsCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MySettings> c)
    {
        applySortsTo((MySettingsCriteria)c);
    }

    protected abstract void applyConditionsTo(MySettingsCriteria c);

    protected abstract void applySortsTo(MySettingsCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaSettings getMeta()
    {
        return MySettings.Meta;
    }

    @Override
    protected MySettingsDao getDao()
    {
        return getAccess().getSettingsDao();
    }

    @Override
    protected MySettingsCriteria createCriteria()
    {
        return new MySettingsCriteria(createGenericCriteria());
    }
}
