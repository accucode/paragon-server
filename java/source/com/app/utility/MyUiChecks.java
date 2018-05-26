package com.app.utility;

import com.app.model.MyProject;
import com.app.model.core.MyProjectDomainIF;
import com.app.ui.dialog.MyDialogs;
import com.app.ui.dialog.MyNotifyDialog;

public class MyUiChecks
{
    //##################################################
    //# checks
    //##################################################

    public static boolean checkViewNonNull(Object e)
    {
        if ( e != null )
            return true;

        ajaxAlertDialog(
            "Cannot View",
            "The requested value does not exist.",
            "This may be caused when another user has modified or removed the selected value.");

        return false;
    }

    public static boolean checkViewProject(MyProjectDomainIF e)
    {
        if ( !checkViewNonNull(e) )
            return false;

        MyProject p = MyGlobals.getCurrentProject();
        boolean ok = p != null && p.equals(e.getProject());

        if ( ok )
            return true;

        ajaxAlertDialog(
            "Cannot View",
            "Not current project.",
            "The requested value does not belong to the current project.");

        return false;
    }

    //##################################################
    //# support
    //##################################################

    public static void ajaxAlertDialog(String title, String subtitle, String message)
    {
        MyNotifyDialog e;
        e = MyDialogs.getNotifyDialog();
        e.setTitle(title);
        e.setSubtitle(subtitle);
        e.setMessage(message);
        e.setFlavorAlert();
        e.ajaxOpen();
        return;
    }

}
