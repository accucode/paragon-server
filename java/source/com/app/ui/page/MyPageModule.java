package com.app.ui.page;

import com.kodemore.exception.KmEnumException;
import com.kodemore.utility.KmEnumIF;

public enum MyPageModule
    implements KmEnumIF
{
    //##################################################
    //# values
    //##################################################

    None,
    Global,
    Developer;

    //##################################################
    //# display
    //##################################################

    public String getDisplayName()
    {
        switch ( this )
        {
            case Developer:
                return "Developer";

            case Global:
                return "Global";

            case None:
                return null;
        }
        throw new KmEnumException(this);
    }

    //##################################################
    //# help
    //##################################################

    public String getHelp()
    {
        switch ( this )
        {
            case Developer:
                return "This page is only available to developers.";

            case Global:
                return ""
                    + "This is a global page that manages cross-project data. "
                    + "Changes made here will affect ALL projects.";

            case None:
                return "This page does not belong to a module.";
        }
        throw new KmEnumException(this);
    }
}
