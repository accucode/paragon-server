package com.app.ui.page.guide.base;

import com.app.ui.page.MySecurityLevel;

/**
 * An empty section of a guide group.  By default this section has no
 * security restrictions but a security level can be optionally set.
 */
public class MyGuideSection
    extends MyAbstractGuideSection
{
    //##################################################
    //# variables
    //##################################################

    private MySecurityLevel _securityLevel;

    //##################################################
    //# accessing
    //##################################################

    public void setSecurityLevel(MySecurityLevel e)
    {
        _securityLevel = e;
    }

    //##################################################
    //# security
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return _securityLevel == null
            ? MySecurityLevel.none
            : _securityLevel;
    }
}
