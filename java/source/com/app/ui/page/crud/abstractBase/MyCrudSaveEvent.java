package com.app.ui.page.crud.abstractBase;

import com.kodemore.domain.KmUidDomainIF;

/**
 * I provide information about a child that was save so
 * the proper actions can be taken as a result
 */
public class MyCrudSaveEvent<C extends KmUidDomainIF>
{
    //##################################################
    //# variables
    //##################################################

    private C       _child;
    private boolean _addMore;
    private boolean _updateList;

    //##################################################
    //# constructor
    //##################################################

    public MyCrudSaveEvent(C e)
    {
        _child = e;
    }

    //##################################################
    //# accessing
    //##################################################

    public C getChild()
    {
        return _child;
    }

    public boolean getAddMore()
    {
        return _addMore;
    }

    public void setAddMore(boolean e)
    {
        _addMore = e;
    }

    public boolean getUpdateList()
    {
        return _updateList;
    }

    public void setUpdateList(boolean e)
    {
        _updateList = e;
    }
}
