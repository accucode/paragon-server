package com.app.model.support;

import com.kodemore.collection.KmList;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

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
public abstract class MyPersonNameUtility
{
    //##################################################
    //# constants
    //##################################################

    private static final String ANONYMOUS = "<anonymous>";

    /**
     * Ideally, this should never return false, but is included
     * for safety checks.
     */
    public static boolean hasName(MyPersonNameIF e)
    {
        return Kmu.hasValue(e.getFirstName())
            || Kmu.hasValue(e.getLastName())
            || Kmu.hasValue(e.getNickname());
    }

    /**
     * Usually joins the first and last names.
     * Return the nickname if the first/last are both null.
     * E.g.: John Smith
     */
    public static String getFullName(MyPersonNameIF e)
    {
        if ( !hasName(e) )
            return ANONYMOUS;

        KmList<String> v;
        v = new KmList<>();
        v.addNonNullDistinct(e.getFirstName());
        v.addNonNullDistinct(e.getLastName());

        return v.isEmpty()
            ? e.getNickname()
            : v.join(" ");
    }

    /**
     * Usually joins the last and first names.
     * Return the nickname if the first/last are both null.
     * E.g.: Smith, John
     */
    public static String getFormalName(MyPersonNameIF e)
    {
        if ( !hasName(e) )
            return ANONYMOUS;

        KmList<String> v;
        v = new KmList<>();
        v.addNonNullDistinct(e.getLastName());
        v.addNonNullDistinct(e.getFirstName());

        return v.isEmpty()
            ? e.getNickname()
            : v.join(", ");
    }

    /**
     * Return a short version of the name.
     * Return the first non-null name: nickname, first name, last name.
     * E.g.: Smitty
     */
    public static String getShortName(MyPersonNameIF e)
    {
        if ( !hasName(e) )
            return ANONYMOUS;

        if ( Kmu.hasValue(e.getNickname()) )
            return e.getNickname();

        if ( Kmu.hasValue(e.getFirstName()) )
            return e.getFirstName();

        return e.getLastName();
    }

    /**
     * Return all three names on a single line.
     * E.g.: John Smith (Smitty)
     */
    public static String getLongName(MyPersonNameIF e)
    {
        if ( !hasName(e) )
            return ANONYMOUS;

        String first = e.getFirstName();
        String last = e.getLastName();
        String nick = e.getNickname();

        if ( Kmu.isEmpty(first) && Kmu.isEmpty(last) )
            return nick;

        KmStringBuilder out;
        out = new KmStringBuilder();
        out.print(e.getFullName());

        if ( Kmu.hasValue(nick) )
            out.printf(" (%s)", nick);

        return out.toString();
    }
}
