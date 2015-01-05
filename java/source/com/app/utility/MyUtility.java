package com.app.utility;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.exception.KmApplicationException;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.field.ScDropdown;
import com.kodemore.types.KmMoney;
import com.kodemore.utility.KmRandom;
import com.kodemore.utility.KmSha1;
import com.kodemore.utility.Kmu;

import com.app.file.MyFilePaths;
import com.app.property.MyPropertyRegistry;

public class MyUtility
{
    //##################################################
    //# constants
    //##################################################

    private static final double DAYS_PER_YEAR = 365.25;

    //##################################################
    //# support
    //##################################################

    /**
     * Use SHA-1 to create a password hash.
     * The results will be exactly 40 characters.
     * If password is null (or empty string), then return null.
     */
    public static String getPasswordHash(String salt, String password)
    {
        String appSalt = MyConstantsIF.APPLICATION_SHA_SALT;

        if ( Kmu.isEmpty(password) )
            return null;

        return KmSha1.hash(appSalt, salt, password);
    }

    //##################################################
    //# misc
    //##################################################

    public static String getRandomPassword()
    {
        KmRandom r = KmRandom.getInstance();

        String letters = r.getSafeString(8).toLowerCase();
        String digits = r.getDigits(3);
        return letters + digits;
    }

    //##################################################
    //# state codes
    //##################################################

    public static KmMap<String,String> getStates()
    {
        KmMap<String,String> m = new KmMap<>();
        m.put("Alabama", "AL");
        m.put("Alaska", "AK");
        m.put("Arizona", "AZ");
        m.put("Arkansas", "AR");
        m.put("California", "CA");
        m.put("Colorado", "CO");
        m.put("Connecticut", "CT");
        m.put("Delaware", "DE");
        m.put("District of Columbia", "DC");
        m.put("Florida", "FL");
        m.put("Georgia", "GA");
        m.put("Guam", "GU");
        m.put("Hawaii", "HI");
        m.put("Idaho", "ID");
        m.put("Illinois", "IL");
        m.put("Indiana", "IN");
        m.put("Iowa", "IA");
        m.put("Kansas", "KS");
        m.put("Kentucky", "KY");
        m.put("Loiusiana", "LA");
        m.put("Maine", "ME");
        m.put("Marshall Islands", "MH");
        m.put("Maryland", "MD");
        m.put("Massachusetts", "MA");
        m.put("Michigan", "MI");
        m.put("Minnesota", "MN");
        m.put("Mississippi", "MS");
        m.put("Missouri", "MO");
        m.put("Montana", "MT");
        m.put("Nebraska", "NE");
        m.put("Nevada", "NV");
        m.put("New Hampshire", "NH");
        m.put("New Jersey", "NJ");
        m.put("New Mexico", "NM");
        m.put("New York", "NY");
        m.put("North Carolina", "NC");
        m.put("North Dakota", "ND");
        m.put("Ohio", "OH");
        m.put("Oklahoma", "OK");
        m.put("Oregon", "OR");
        m.put("Pennsylvania", "PA");
        m.put("Puerto Rico", "PR");
        m.put("Rhode Island", "RI");
        m.put("South Carolina", "SC");
        m.put("South Dakota", "SD");
        m.put("Tennessee", "TN");
        m.put("Texas", "TX");
        m.put("Utah", "UT");
        m.put("Vermont", "VT");
        m.put("Virgin Islands", "VI");
        m.put("Virginia", "VA");
        m.put("Washington", "WA");
        m.put("West Virginia", "WV");
        m.put("Wisconsin", "WI");
        m.put("Wyoming", "WY");
        return m;
    }

    public static ScDropdown newStateDropdown()
    {
        KmMap<String,String> states = getStates();

        KmList<String> names;
        names = states.getKeys();
        names.sort();

        ScDropdown e;
        e = new ScDropdown();
        e.setLabel("State");

        for ( String name : names )
        {
            String code = states.get(name);
            e.addOption(code, name);
        }

        return e;
    }

    /**
     * Check the the new password is valid for use.  Call error if not.
     */
    public static void validatePassword(String password, String confirmationPassword)
    {
        if ( Kmu.isNotEqual(password, confirmationPassword) )
            throw newError("Passwords do not match.");

        Integer min = MyGlobals.getProperties().getMinimumPasswordLength();

        if ( min > 0 )
            if ( password == null || password.length() < min )
                throw newError("Password must be at least %s characters.", min);
    }

    public static String formatDeletedLabel(boolean deleted)
    {
        if ( deleted )
            return "DELETED";

        return "";
    }

    public static String formatSerialNumber(String s)
    {
        if ( Kmu.isEmpty(s) )
            return null;

        return "SN#: " + s;
    }

    public static String formatTrackingNumber(String s)
    {
        if ( Kmu.isEmpty(s) )
            return null;

        if ( s.length() == 32 )
            s = s.substring(16, 28);

        return "TRACK#: " + s;
    }

    /**
     * Format a integer in a format that is semi-random,
     * but still guaranteed to be unique.  That is, the
     * value returned for given i, is guaranteed to never
     * be the same as a value returned by a different i.
     *
     * However, the value returned by i is not guaranteed
     * to be the same each time this is called.
     *
     * The intent is to use this for things like order
     * confirmation numbers, where we want to avoid the
     * appears of sequentially generated values, but need
     * to ensure that each value is unique.  We also want
     * to ensure that the next numbers are not readily
     * guessable, even if a person knows the previous values
     * in the sequence.
     */
    public static String formatConfirmationNumber20(int i)
    {
        KmRandom r = new KmRandom();

        String body = "" + i + r.getDigit();
        int rot = r.getInteger(9) + 1;
        String rotated = Kmu.rotate(body, rot);
        String full = "" + rot + rotated;
        long ii = Kmu.parseLong(full);
        return Kmu.formatBase20(ii);
    }

    public static String formatConfirmationNumber10(int i)
    {
        KmRandom r = new KmRandom();

        String body = "" + i + r.getDigit();
        int rot = r.getInteger(9) + 1;
        String rotated = Kmu.rotate(body, rot);
        String full = "" + rot + rotated;
        long ii = Kmu.parseLong(full);
        return ii + "";
    }

    //##################################################
    //# price
    //##################################################

    public static KmMoney convertMonthlyToDaily(KmMoney monthly)
    {
        if ( monthly == null )
            return null;

        return monthly.multiply(12).divide(DAYS_PER_YEAR);
    }

    public static boolean isMaintenancePeriod()
    {
        int hour = MyGlobals.getNowUtc().getHour();

        MyPropertyRegistry p = MyGlobals.getProperties();
        int start = p.getMaintenancePeriodStartHour();
        int end = p.getMaintenancePeriodEndHour();

        if ( start <= end )
            return hour >= start && hour <= end;

        return hour >= start || hour <= end;
    }

    //##################################################
    //# ui
    //##################################################

    public static String getDefaultUiTitleFor(Object e)
    {
        String s;
        s = Kmu.getSimpleClassName(e);
        s = Kmu.removePrefix(s, "My");
        s = Kmu.removePrefix(s, "Abstract");
        s = Kmu.removeSuffix(s, "Page");
        s = Kmu.removeSuffix(s, "Portlet");
        return s;
    }

    //##################################################
    //# files
    //##################################################

    protected void writeTempWebFile(String file, ScControl c)
    {
        String path = MyFilePaths.getWebPath(file);
        String html = c.render().formatHtml();

        Kmu.writeFile(path, html);
    }

    //##################################################
    //# support
    //##################################################

    private static KmApplicationException newError(CharSequence msg, Object... args)
    {
        return Kmu.newError(msg, args);
    }
}
