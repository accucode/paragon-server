package com.kodemore.servlet.control;

import com.app.dao.base.MyDaoRegistry;
import com.app.ui.core.MyPageSession;
import com.app.utility.MyGlobals;

import com.kodemore.exception.KmApplicationException;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.action.ScActionContextIF;
import com.kodemore.servlet.script.ScScript;

public abstract class ScTabManager
    implements ScActionContextIF
{
    //##################################################
    //# variables
    //##################################################

    private ScActionContextIF _innerContext;

    //##################################################
    //# constructor
    //##################################################

    public ScTabManager(ScActionContextIF e)
    {
        _innerContext = e;
    }

    //##################################################
    //# install
    //##################################################

    public abstract ScControl createTab();

    //##################################################
    //# accessing
    //##################################################

    public ScActionContextIF getInnerContext()
    {
        return _innerContext;
    }

    //##################################################
    //# ScActionContextIF 
    //##################################################

    @Override
    public void checkSecurity()
    {
        getInnerContext().checkSecurity();
    }

    @Override
    public void handleError(KmApplicationException ex)
    {
        getInnerContext().handleError(ex);
    }

    @Override
    public void handleFatal(RuntimeException ex)
    {
        getInnerContext().handleFatal(ex);
    }

    //##################################################
    //# convenience
    //##################################################

    protected ScScript ajax()
    {
        return getData().getAjaxResult().getScript();
    }

    protected ScServletData getData()
    {
        return ScServletData.getLocal();
    }

    protected String getStringArgument()
    {
        return getData().getStringArgument();
    }

    protected MyPageSession getPageSession()
    {
        return MyGlobals.getPageSession();
    }

    protected MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
}
