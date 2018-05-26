package com.app.utility;

public interface MyConstantsIF
{
    //##################################################
    //# application
    //##################################################

    /**
     * The name of the project. It is used in a variety of
     * contexts and may be displayed on screen to users.
     */
    String APPLICATION_NAME = "Paragon";

    /**
     * The short name of the project. This should be limited
     * to a couple of characters as it is used as a prefix
     * in the browser tab.
     */
    String APPLICATION_ABBREVIATION = "P1";

    /**
     * The build number is important.  It should be updated
     * any time you are deploying a new version to production.
     * Typical format is Build-YYMMDD-R.  Where R is the number
     * of revisions on a given day.
     */
    String APPLICATION_VERSION = "Build-180101-1";

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
     * This salt has been UPDATED for Paragon.
     */
    String APPLICATION_SHA_SALT = "0P7NZNG-0005G9C-0OEXVWI-MFSZ88";

    //##################################################
    //# copyright
    //##################################################

    /**
     * These copyright notices are displayed on various web pages.
     */
    String COPYRIGHT_TEXT = "Copyright 2014-2018 Accucode";
    String COPYRIGHT_HTML = "&copy; 2014-2018 Accucode";

    //##################################################
    //# misc
    //##################################################

    /**
     * Monthly recurring billing is generally restricted to the first
     * X days of the month to avoid confusion related to leap year
     * and months with different number of days.
     */
    int MAXIMUM_BUSINESS_DAY = 25;
}
