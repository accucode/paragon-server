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

    private String            _key;
    private ScActionContextIF _context;

    //##################################################
    //# constructor
    //##################################################

    protected ScAbstractAction()
    {
        this(null);
    }

    protected ScAbstractAction(ScActionContextIF context)
    {
        _key = nextKey();
        _context = context;

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
    public ScActionContextIF getContext()
    {
        return _context;
    }

    public boolean hasContext()
    {
        return _context != null;
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
