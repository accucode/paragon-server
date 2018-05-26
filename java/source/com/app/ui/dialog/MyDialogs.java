package com.app.ui.dialog;

import com.app.ui.page.crud.appFeedback.MyFeedbackDialog;

/**
 * I define some global dialogs that can be reused throughout
 * the application. It is the page's responsiblity to ensure
 * that the user cannot open the same dialog more than once
 * at a given time.
 */
public class MyDialogs
{
    //##################################################
    //# install
    //##################################################

    public static void install()
    {
        _confirmDialog = new MyConfirmDialog();
        _notifyDialog = new MyNotifyDialog();
        _feedbackDialog = new MyFeedbackDialog();
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * A global dialog managed by the layout.
     */
    private static MyConfirmDialog _confirmDialog;

    /**
     * A global dialog managed by the layout.
     */
    private static MyNotifyDialog _notifyDialog;

    /**
     * A global dialog managed by the layout.
     */
    private static MyFeedbackDialog _feedbackDialog;

    //##################################################
    //# accessing
    //##################################################

    public static MyConfirmDialog getConfirmDialog()
    {
        return _confirmDialog;
    }

    public static MyNotifyDialog getNotifyDialog()
    {
        return _notifyDialog;
    }

    public static MyFeedbackDialog getFeedbackDialog()
    {
        return _feedbackDialog;
    }
}
