package com.kodemore.servlet.action;

import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.utility.ScControlRegistry;

public abstract class ScAbstractAction
    implements ScActionIF
{
    //##################################################
    //# static
    //##################################################

    private static String nextKey()
    {
        return ScControlRegistry.getInstance().getNextKey();
    }

    //##################################################
    //# variables
    //##################################################

    private String                    _key;
    private ScContextSupplierIF _contextSupplier;

    //##################################################
    //# constructor
    //##################################################

    protected ScAbstractAction()
    {
        this(null);
    }

    protected ScAbstractAction(ScContextSupplierIF e)
    {
        _key = nextKey();
        _contextSupplier = e;

        ScControlRegistry.getInstance().register(this);
    }

    //##################################################
    //# key
    //##################################################

    @Override
    public String getKey()
    {
        return _key;
    }

    public boolean hasKey(String s)
    {
        return _key.equals(s);
    }

    //##################################################
    //# context
    //##################################################

    @Override
    public ScContextIF getContext()
    {
        if ( _contextSupplier == null )
            return null;

        return _contextSupplier.getContext();
    }

    public boolean hasContext()
    {
        return getContext() != null;
    }

    //##################################################
    //# equals
    //##################################################

    @Override
    public boolean equals(Object e)
    {
        if ( e instanceof ScAbstractAction )
            return ((ScAbstractAction)e).hasKey(_key);

        return false;
    }

    @Override
    public int hashCode()
    {
        return _key.hashCode();
    }

    //##################################################
    //# run
    //##################################################

    protected abstract void handle();

    //##################################################
    //# suport
    //##################################################

    protected ScServletData getData()
    {
        return ScServletData.getLocal();
    }

    protected ScBlockScript ajax()
    {
        return getData().ajax();
    }

}
