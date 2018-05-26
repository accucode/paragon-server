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

public abstract class MyHolidayFilterBase
    extends MyBasicFilter<MyHoliday>
    implements MyHolidayDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyHoliday> c)
    {
        applyConditionsTo((MyHolidayCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyHoliday> c)
    {
        applySortsTo((MyHolidayCriteria)c);
    }

    protected abstract void applyConditionsTo(MyHolidayCriteria c);

    protected abstract void applySortsTo(MyHolidayCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaHoliday getMeta()
    {
        return MyHoliday.Meta;
    }

    @Override
    protected MyHolidayDao getDao()
    {
        return getAccess().getHolidayDao();
    }

    @Override
    protected MyHolidayCriteria createCriteria()
    {
        return new MyHolidayCriteria(_createCriteria());
    }
}
