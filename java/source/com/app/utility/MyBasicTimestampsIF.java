package com.app.utility;

import com.kodemore.time.KmClock;
import com.kodemore.time.KmTimestamp;

import com.app.model.MyUser;

//##############################################
//##
//##   WARNING WARNING WARNING
//##
//##   If thise methods/attributes are renamed
//##   you must update MyHibernateInterceptor.
//##
//##############################################
public interface MyBasicTimestampsIF
{
    KmTimestamp getCreatedUtcTs();

    void setCreatedUtcTs(KmTimestamp e);

    MyUser getCreatedBy();

    void setCreatedBy(MyUser e);

    KmTimestamp getUpdatedUtcTs();

    void setUpdatedUtcTs(KmTimestamp e);

    MyUser getUpdatedBy();

    void setUpdatedBy(MyUser e);

    /**
     * Set the created and updated time to now and
     * set the created and updated user to the current user.
     */
    default void resetBasicTimestamps()
    {
        setCreatedUtcTs(KmClock.getUtcTimestamp());
        setCreatedBy(MyGlobals.getCurrentUser());

        setUpdatedUtcTs(KmClock.getUtcTimestamp());
        setUpdatedBy(MyGlobals.getCurrentUser());
    }
}
