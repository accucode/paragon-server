package com.app.ui.page.crud.abstractBase;

import java.util.function.Consumer;

import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.variable.ScLocalString;

import com.app.dao.base.MyDaoAccess;
import com.app.utility.MyGlobals;

public abstract class MyChildViewPanel<T extends KmUidDomainIF>
    extends ScDiv
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalString _childUid;

    private Consumer<T> _childChangedListener;
    private Consumer<T> _childListChangedListener;

    //##################################################
    //# constructor
    //##################################################

    public MyChildViewPanel()
    {
        install();
    }

    private void install()
    {
        _childUid = new ScLocalString();
        _childUid.setAutoSave();
    }

    //##################################################
    //# child
    //##################################################

    protected abstract T getChild();

    protected String getChildUid()
    {
        return _childUid.getValue();
    }

    //##################################################
    //# listener :: child changed
    //##################################################

    public final void onChildChanged(Consumer<T> e)
    {
        _childChangedListener = e;
    }

    protected void fireChildChanged(T e)
    {
        fire(_childChangedListener, e);
    }

    public final void onChildListChanged(Consumer<T> e)
    {
        _childListChangedListener = e;
    }

    protected void fireChildListChanged(T e)
    {
        fire(_childListChangedListener, e);
    }

    @Override
    protected void preRender()
    {
        super.preRender();

        applyFromModel(getChild());
    }

    //##################################################
    //# support
    //##################################################

    protected MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

}
