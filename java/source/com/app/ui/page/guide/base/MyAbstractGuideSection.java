package com.app.ui.page.guide.base;

import com.kodemore.servlet.action.ScSecurityManagerIF;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.utility.KmSimpleResult;
import com.kodemore.utility.Kmu;

import com.app.model.MyProject;
import com.app.model.MyUser;
import com.app.ui.page.MySecurityLevel;
import com.app.utility.MyGlobals;

public abstract class MyAbstractGuideSection
    extends ScDiv
    implements ScSecurityManagerIF
{
    //##################################################
    //# security
    //##################################################

    @Override
    public void checkSecurity()
    {
        MyUser u = getCurrentUser();
        MyProject p = getCurrentProject();

        MySecurityLevel level = getSecurityLevel();
        KmSimpleResult result = level.allows(u, p);

        if ( result.hasError() )
            throw Kmu.newSecurityError(result.getError());
    }

    public abstract MySecurityLevel getSecurityLevel();

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        show(checkSecuritySilently());
    }

    //##################################################
    //# support
    //##################################################

    private MyUser getCurrentUser()
    {
        return MyGlobals.getCurrentUser();
    }

    private MyProject getCurrentProject()
    {
        return MyGlobals.getCurrentProject();
    }
}
