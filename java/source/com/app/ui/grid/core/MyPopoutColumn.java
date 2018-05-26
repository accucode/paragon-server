package com.app.ui.grid.core;

import java.util.function.Function;

import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.control.ScGridColumn;

import com.app.dao.base.MyDaoAccess;
import com.app.utility.MyGlobals;

public abstract class MyPopoutColumn<P extends KmUidDomainIF, C extends KmUidDomainIF>
    extends ScGridColumn<P>
{
    //##################################################
    //# variables
    //##################################################

    /**
     * Used to get the single child of a particular parent.
     */
    private Function<P,C> _childFunction;

    //##################################################
    //# constructor
    //##################################################

    public MyPopoutColumn()
    {
        this(null);
    }

    public MyPopoutColumn(Function<P,C> fn)
    {
        _childFunction = fn;
        setDisplayControl(createControl());
        setExportFunction(p -> getChildTitleFor(p));
        install();
    }

    protected abstract void install();

    //##################################################
    //# override
    //##################################################

    protected abstract String getTitleFor(C child);

    protected abstract void ajaxViewChild(C site);

    protected abstract String getPopoutUrlFor(C site);

    protected abstract C findChild(String uid);

    //##################################################
    //# child
    //##################################################

    public void setChildFunction(Function<P,C> e)
    {
        _childFunction = e;
    }

    @SuppressWarnings("unchecked")
    protected C getChildFor(P p)
    {
        if ( p == null )
            return null;

        return _childFunction == null
            ? (C)p
            : _childFunction.apply(p);
    }

    private String getChildTitleFor(P p)
    {
        C c = getChildFor(p);
        return c == null
            ? ""
            : getTitleFor(c);
    }

    //##################################################
    //# control
    //##################################################

    private MyPopoutColumnControl<P,C> createControl()
    {
        return new MyPopoutColumnControl<P,C>()
        {
            @Override
            protected String getTitleFor(C child)
            {
                return MyPopoutColumn.this.getTitleFor(child);
            }

            @Override
            protected void ajaxViewChild(C child)
            {
                MyPopoutColumn.this.ajaxViewChild(child);
            }

            @Override
            protected String getPopoutUrlFor(C child)
            {
                return MyPopoutColumn.this.getPopoutUrlFor(child);
            }

            @Override
            protected C findChild(String uid)
            {
                return MyPopoutColumn.this.findChild(uid);
            }

            @Override
            protected C getChildFor(P p)
            {
                return MyPopoutColumn.this.getChildFor(p);
            }
        };
    }

    //##################################################
    //# support
    //##################################################

    protected ScServletData getData()
    {
        return ScServletData.getLocal();
    }

    protected MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }
}
