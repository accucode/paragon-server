package com.app.utility;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.exception.KmApplicationException;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.field.ScDropdownField;
import com.kodemore.servlet.field.ScStaticDropdownField;
import com.kodemore.servlet.utility.ScUrlBridge;
import com.kodemore.types.KmMoney;
import com.kodemore.utility.KmFiles;
import com.kodemore.utility.KmRandom;
import com.kodemore.utility.KmSha1;
import com.kodemore.utility.KmVirtualOptions;
import com.kodemore.utility.Kmu;

import com.app.file.MyFilePaths;
import com.app.model.MyProject;
import com.app.model.MyTenant;
import com.app.model.core.MyProjectDomainIF;
import com.app.model.core.MyTenantDomainIF;
import com.app.property.MyProperties;
import com.app.ui.dialog.MyDialogs;
import com.app.ui.dialog.MyNotifyDialog;

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
        if ( Kmu.isEmpty(password) )
            return null;

        String appSalt = MyConstantsIF.APPLICATION_SHA_SALT;
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

    public static ScDropdownField<String> newStateDropdown()
    {
        KmMap<String,String> states = getStates();

        KmList<String> names;
        names = states.getKeys();
        names.sort();

        ScStaticDropdownField<String> e;
        e = new ScStaticDropdownField<>();
        e.setLabel("State");

        for ( String name : names )
        {
            String code = states.get(name);
            e.addOption(code, name);
        }

        return e;
    }

    public static String formatDeletedLabel(boolean deleted)
    {
        return deleted
            ? "DELETED"
            : "";
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
     * The intent is to use this for things like job
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

    public static String formatActive(Boolean e)
    {
        if ( e == null )
            return "Unknown";

        return e
            ? "Active"
            : "Inactive";
    }

    public static String formatRate(Double rate)
    {
        return formatRate(rate, KmVirtualOptions.NONE);
    }

    public static String formatRate(Double rate, String ifNull)
    {
        return rate == null
            ? ifNull
            : rate * 100.0 + "%";
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

        MyProperties p = MyGlobals.getProperties();
        int start = p.getMaintenancePeriodStartHour();
        int end = p.getMaintenancePeriodEndHour();

        return start <= end
            ? hour >= start && hour <= end
            : hour >= start || hour <= end;
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

        KmFiles.writeString(path, html);
    }

    //##################################################
    //# html
    //##################################################

    /**
     * This is a bit awkward, but at least this is now in a single
     * place rather than copying the list of css files in multiple
     * places.
     */
    public static void printStyleLinksOn(KmHtmlBuilder out)
    {
        ScUrlBridge urls = ScUrlBridge.getInstance();

        out.printStyleLink(urls.getResetCss());
        out.printStyleLink(urls.getThemeCss());
    }

    //##################################################
    //# context
    //##################################################

    public static MyTenant getTenantFor(Object e)
    {
        if ( e instanceof MyTenantDomainIF )
            return ((MyTenantDomainIF)e).getTenant();

        if ( e instanceof MyProjectDomainIF )
            return ((MyProjectDomainIF)e).getTenant();

        return null;
    }

    public static MyProject getProjectFor(Object e)
    {
        return e instanceof MyProjectDomainIF
            ? ((MyProjectDomainIF)e).getProject()
            : null;
    }

    /**
     * Check if all of the parameters are associated with the same tenant.
     * If any mismatch is found, throw an unchecked runtime exception.
     */
    public static void checkTenant(Object... arr)
    {
        int n = arr.length;
        if ( n <= 1 )
            return;

        MyTenant a = getTenantFor(arr[0]);
        for ( Object e : arr )
        {
            MyTenant b = getTenantFor(e);
            if ( !Kmu.isEqual(a, b) )
                throw Kmu.newFatal("Unexpected tenant mismatch.");
        }
    }

    //##################################################
    //# dialog
    //##################################################

    public static boolean tryErrorDialog(String title, Runnable r)
    {
        try
        {
            r.run();
            return true;
        }
        catch ( KmApplicationException ex )
        {
            MyNotifyDialog e;
            e = MyDialogs.getNotifyDialog();
            e.setTitle(title);
            e.setMessage(ex.getMessage());
            e.ajaxOpen();
            return false;
        }
    }

}
