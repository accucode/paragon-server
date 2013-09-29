//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.filter.base;

import com.app.criteria.MySettingsCriteria;
import com.app.dao.MySettingsDao;
import com.app.dao.base.MySettingsDaoConstantsIF;
import com.app.filter.core.MyBasicFilter;
import com.app.model.MySettings;
import com.app.model.meta.MyMetaSettings;

import com.kodemore.hibernate.criteria.KmModelCriteria;

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
