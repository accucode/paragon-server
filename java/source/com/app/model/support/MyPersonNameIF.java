package com.app.model.support;

/**
 * A common interface for dealing with person names.
 *
 * Although any of the three basic attributes (first, last, nickname) may
 * be null, they should not ALL be null. At least one of the three names
 * should be populated with a non-empty value.
 *
 * The calculated values should be safe for display, and are guaranteed
 * to never return a null/empty value.
 */
public interface MyPersonNameIF
{
    //##################################################
    //# constants
    //##################################################

    public static final String ANONYMOUS = "<anonymous>";

    //##################################################
    //# basic fields
    //##################################################

    /**
     * The first name, may be null.
     * E.g.: John.
     */
    String getFirstName();

    /**
     * The last name, may be null.
     * E.g.: Smith.
     */
    String getLastName();

    /**
     * The nickname, may be null.
     * E.g.: Smitty.
     */
    String getNickname();

    //##################################################
    //# calculated values (not null)
    //##################################################

    /**
     * Ideally, this should never return false, but is included
     * for safety checks.
     */
    default boolean hasName()
    {
        return MyPersonNameUtility.hasName(this);
    }

    /**
     * Usually joins the first and last names.
     * Return the nickname if the first/last are both null.
     * E.g.: John Smith
     */
    default String getFullName()
    {
        return MyPersonNameUtility.getFullName(this);
    }

    /**
     * Usually joins the last and first names.
     * Return the nickname if the first/last are both null.
     * E.g.: Smith, John
     */
    default String getFormalName()
    {
        return MyPersonNameUtility.getFormalName(this);
    }

    /**
     * Return a short version of the name.
     * Return the first non-null name: nickname, first name, last name.
     * E.g.: Smitty
     */
    default String getShortName()
    {
        return MyPersonNameUtility.getShortName(this);
    }

    /**
     * Return all three names on a single line.
     * E.g.: John Smith (Smitty)
     */
    default String getLongName()
    {
        return MyPersonNameUtility.getLongName(this);
    }
}
