package com.app.ui.page.crud.abstractBase;

import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.utility.Kmu;

import com.app.ui.page.MyBookmark;
import com.app.ui.page.MyPage;

public class MyCrudListBookmark
    extends MyBookmark
{
    //##################################################
    //# constants
    //##################################################

    private static final String PARAM_CHILD_UID = "childUid";
    private static final String PARAM_SINGLE    = "single";

    /**
     * The old param key for the childUid. We changed the param
     * to childUid, but continue to support this temporarily for
     * backward compatibility. This is no longer used when creating
     * new urls and should be removed later.
     */
    private static final String PARAM_OLD_CHILD_UID = "uid";

    //##################################################
    //# variables
    //##################################################

    private String  _childUid;
    private boolean _single;

    //##################################################
    //# constructor
    //##################################################

    public MyCrudListBookmark(MyPage e)
    {
        super(e);
    }

    //##################################################
    //# child uid
    //##################################################

    public String getChildUid()
    {
        return _childUid;
    }

    public void setChildUid(String e)
    {
        _childUid = e;
    }

    public void setChildUidFor(KmUidDomainIF e)
    {
        setChildUid(KmUidDomainIF.getUidFor(e));
    }

    public boolean hasChildUid()
    {
        return Kmu.hasValue(getChildUid());
    }

    //##################################################
    //# single
    //##################################################

    public boolean getSingle()
    {
        return _single;
    }

    public void setSingle(boolean e)
    {
        _single = e;
    }

    //##################################################
    //# params
    //##################################################

    @Override
    public void readFrom(ScParameterList params)
    {
        super.readFrom(params);

        setChildUid(params.getString(PARAM_OLD_CHILD_UID)); // backward compatibility
        setChildUid(params.getString(PARAM_CHILD_UID));

        setSingle(params.getBoolean(PARAM_SINGLE));
    }

    @Override
    public void writeTo(ScParameterList params)
    {
        super.writeTo(params);

        params.setString(PARAM_CHILD_UID, getChildUid());
        params.setBoolean(PARAM_SINGLE, getSingle());
    }

}
