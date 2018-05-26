package com.kodemore.utility;

/**
 * I define a basic interface for common enums.  This creates
 * a convenient contract that applies to "99%" of the enums
 * used in simple business apps.
 */
public interface KmEnumIF
{
    //##################################################
    //# static
    //##################################################

    static String getCodeFor(KmEnumIF e)
    {
        return e == null
            ? null
            : e.getCode();
    }

    static String getLabelFor(KmEnumIF e)
    {
        return e == null
            ? null
            : e.getLabel();
    }

    static <E extends KmEnumIF> E getValueFor(E[] arr, String code)
    {
        if ( arr == null )
            return null;

        int n = arr.length;
        for ( int i = 0; i < n; i++ )
            if ( arr[i].hasCode(code) )
                return arr[i];

        return null;
    }

    //##################################################
    //# primitives
    //##################################################

    /**
     * Returns the 0-based position in its enum declaration.
     * Do NOT override this.
     */
    int ordinal();

    /**
     * Returns the name of this enum constant, exactly as declared in its enum declaration.
     * This is compatible with Enum.valueof(String).
     * Do NOT override this.
     */
    String name();

    //##################################################
    //# code
    //##################################################

    /**
     * Return a unique non-null string code.
     * This may be used in place of the ordinal/name as a unique value
     * to be used by the application as a long term key.
     * The default is to return the name().
     */
    default String getCode()
    {
        return name();
    }

    default boolean hasCode(String e)
    {
        return getCode().equals(e);
    }

    //##################################################
    //# label
    //##################################################

    /**
     * Return a unique non-null display label, suitable for display to end users.
     * By default, return the name() split into capitalized words.
     */
    default String getLabel()
    {
        return Kmu.formatCamelCaseAsCapitalizedWords(name());
    }

    default boolean hasLabel(String e)
    {
        return getLabel().equals(e);
    }
}
