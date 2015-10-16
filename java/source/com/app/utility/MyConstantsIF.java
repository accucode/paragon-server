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
    String APPLICATION_NAME = "Paragon";

    /**
     * The build number is important.  It should be updated
     * any time you are deploying a new version to production.
     * Typical format is Build-YYMMDD-R.  Where R is the number
     * of revisions on a given day.
     */
    String APPLICATION_VERSION = "Build-150811-1";

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
     * This salt should be updated for each new project.
     */
    String APPLICATION_SHA_SALT = "FOR PARAGON TESTING ONLY";

    //##################################################
    //# copyright
    //##################################################

    String COPYRIGHT_TEXT = "Open Source MIT/Apache License";
    String COPYRIGHT_HTML = "Open Source MIT/Apache License";
}
