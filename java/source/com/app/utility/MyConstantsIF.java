package com.app.utility;

public interface MyConstantsIF
{
    //##################################################
    //# application
    //##################################################

    /**
     * The name of the project.  It is used in a variety of
     * contexts and may be displayed on screen to users.
     */
    String APPLICATION_NAME     = "Field Service Portal";

    /**
     * The build number is important.  It should be updated
     * any time you are deploying a new version to production.
     * Typical format is Build-YYMMDD-R.  Where R is the number
     * of revisions on a given day.
     */
    String APPLICATION_VERSION  = "Build-150811-1";

    /**
     * This should be a globally unique value, that identifies
     * the application.  This value MUST be randomly updated
     * for each new project, but should NOT be updated for new
     * versions of the same application.
     *
     * Changing this salt will invalidate preexisting passwords
     * and authentications used to access the application.
     * New values can be generated via Kmu.newUid().
     *
     * This salt has been UPDATED for fieldService-server.
     */
    String APPLICATION_SHA_SALT = "6GNFMQX-Y22IT0-FJWVBZ-3KMU1J";

    //##################################################
    //# copyright
    //##################################################

    String COPYRIGHT_TEXT       = "Copyright 2015 Accucode Inc.";
    String COPYRIGHT_HTML       = "&copy; 2015 Accucode Inc.";
}
