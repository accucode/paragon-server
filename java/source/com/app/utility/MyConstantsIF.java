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
    String APPLICATION_NAME     = "Paragon Server";

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
     * This salt is TEMPORARY, and should be changed for real projects.
     */
    String APPLICATION_SHA_SALT = "000000-000000-000000-000000";

    /**
     * The build number is important.  It should be updated any time you
     * are deploying a new version to production.  Typical format is Build-YYMMDD-R.
     * Where R is the number of revisions on a given day.
     *
     * A different pattern can be used, but the build numbers should increase
     * alpha-numerically with each version.  Also, the version number is
     * used to compose the url/file path so it needs to be limited to text
     * that is compatible with paths.
     */
    String APPLICATION_VERSION  = "Build-150101-1";

    //##################################################
    //# copyright
    //##################################################

    /**
     * This should be replaced with a copyright notice appropriate to your project.
     */
    String COPYRIGHT_TEXT       = "Copyright 2015, Accucode Inc., (Apache License, Open Source)";
    String COPYRIGHT_HTML       = "&copy; 2015, Accucode Inc., (Apache License, Open Source)";

}
