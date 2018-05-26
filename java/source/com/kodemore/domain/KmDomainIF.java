package com.kodemore.domain;

/**
 * I define some methods that are common to all domain models.
 */
public interface KmDomainIF
{
    //##################################################
    //# validation
    //##################################################

    /**
     * Validate the domain, and throw a KmApplicationException
     * if any errors are detected. This is typically called
     * before the domain is persisted.
     *
     * Declaring this method here simplifies the auto-generation.
     */
    void validateAndCheck();

    //##################################################
    //# active
    //##################################################

    /**
     * Indicates whether this domain is considered to be "enabled".
     * This is used by various screens and frameworks.
     *
     * This defaults to true. The most common override is by classes
     * that implement a simple "active" field. However, this method
     * may be calculated based on some combination of other state
     * rather than a simple field.
     *
     * Disabled values still exist in the database, and are still displayed
     * if they are already in used. However, disabled values are generally
     * omitted when listing options for new work.
     *
     * For example, Products may be configured as enabled or disabled.
     * Any products already added to a Job should be displayed
     * regardless of their current enablement status. However, when adding
     * a new Line to a Job, we should prompt the user to select
     * from the list of currently enabled Products.
     */
    default boolean isDomainEnabled()
    {
        return true;
    }

    //##################################################
    //# display
    //##################################################

    /**
     * A short single line of text that identifies this domain
     * on various user interfaces.
     *
     * This is not required to be strictly unique, but it should
     * be distinct enough to distinguish between different values
     * for typical screens and reports.
     *
     * This should never return a null (or empty) string.
     */
    String getDomainTitle();

    /**
     * A short single line of text that includes supplemental
     * information about the domain. This may be used on a
     * variety of screens and reports.
     *
     * This is optional, and may return null.
     */
    String getDomainSubtitle();

}
