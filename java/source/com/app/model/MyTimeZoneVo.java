package com.app.model;

import java.util.EnumSet;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.servlet.field.ScDropdown;
import com.kodemore.time.KmTimeZoneIF;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.Kmu;

import com.app.model.meta.MyMetaTimeZoneVo;

public enum MyTimeZoneVo
    implements KmTimeZoneIF
{
    //##################################################
    //# values
    //##################################################

    UTC("UTC", "Coordinated Universal Time", 0),

    EST("EST", "Eastern Standard Time (no DST)", -300),
    ESTD("EST-D", "Eastern Time (with DST)", -300, "EDT", 60, 3, 9, 11, 4),

    CST("CST", "Central Standard Time (no DST)", -360),
    CSTD("CST-D", "Central Time (with DST)", -360, "CDT", 60, 3, 9, 11, 4),

    MST("MST", "Mountain Standard Time (no DST)", -420),
    MSTD("MST-D", "Mountain Time (with DST)", -420, "MDT", 60, 3, 9, 11, 4),
    AZ("AZ", "Arizona (no DST)", -420),

    PST("PST", "Pacific Standard Time (no DST)", -480),
    PSTD("PST-D", "Pacific Time (with DST)", -480, "PDT", 60, 3, 9, 11, 4);

    //##################################################
    //# meta
    //##################################################

    public static final MyMetaTimeZoneVo Meta = MyMetaTimeZoneVo.instance;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyTimeZoneVo> _values;
    private static final KmMap<String,MyTimeZoneVo> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyTimeZoneVo e : EnumSet.allOf(MyTimeZoneVo.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyTimeZoneVo> getValues()
    {
        return _values;
    }

    public static MyTimeZoneVo findCode(String code)
    {
        return _codes.get(code);
    }

    //##################################################
    //# variables
    //##################################################

    private String _code;
    private String _name;
    private Integer _utcOffsetMinutes;

    private String _dstCode;
    private Integer _dstOffsetMinutes;
    private Integer _dstStartMonth;
    private Integer _dstStartDay;
    private Integer _dstEndMonth;
    private Integer _dstEndDay;

    //##################################################
    //# constructor
    //##################################################

    private MyTimeZoneVo(String code, String name, Integer utcOffsetMinutes)
    {
        _code = code;
        _name = name;
        _utcOffsetMinutes = utcOffsetMinutes;
    }

    private MyTimeZoneVo(
        String code,
        String name,
        Integer utcOffsetMinutes,
        String dstCode,
        Integer dstOffsetMinutes,
        Integer dstStartMonth,
        Integer dstStartDay,
        Integer dstEndMonth,
        Integer dstEndDay)
    {
        this(code, name, utcOffsetMinutes);
        _dstCode = dstCode;
        _dstOffsetMinutes = dstOffsetMinutes;
        _dstStartMonth = dstStartMonth;
        _dstStartDay = dstStartDay;
        _dstEndMonth = dstEndMonth;
        _dstEndDay = dstEndDay;
    }

    //##################################################
    //# code
    //##################################################

    @Override
    public String getCode()
    {
        return _code;
    }

    public boolean hasCode(String e)
    {
        return getCode().equals(e);
    }

    public boolean hasCode()
    {
        return true;
    }

    //##################################################
    //# name
    //##################################################

    @Override
    public String getName()
    {
        return _name;
    }

    public boolean hasName(String e)
    {
        return getName().equals(e);
    }

    public boolean hasName()
    {
        return true;
    }

    //##################################################
    //# offset minutes
    //##################################################

    public Integer getUtcOffsetMinutes()
    {
        return _utcOffsetMinutes;
    }

    public boolean hasUtcOffsetMinutes(Integer e)
    {
        return getUtcOffsetMinutes().equals(e);
    }

    //##################################################
    //# dst code
    //##################################################

    public String getDstCode()
    {
        return _dstCode;
    }

    public boolean hasDstCode(String e)
    {
        return getDstCode().equals(e);
    }

    public boolean hasDstCode()
    {
        return getDstCode() != null;
    }

    //##################################################
    //# dst offset minutes
    //##################################################

    public Integer getDstOffsetMinutes()
    {
        return _dstOffsetMinutes;
    }

    public boolean hasDstOffsetMinutes(Integer e)
    {
        return Kmu.isEqual(getDstOffsetMinutes(), e);
    }

    //##################################################
    //# dst start
    //##################################################

    public Integer getDstStartMonth()
    {
        return _dstStartMonth;
    }

    public boolean hasDstStartMonth(Integer e)
    {
        return Kmu.isEqual(getDstStartMonth(), e);
    }

    public Integer getDstStartDay()
    {
        return _dstStartDay;
    }

    public boolean hasDstStartDay(Integer e)
    {
        return Kmu.isEqual(getDstStartDay(), e);
    }

    //##################################################
    //# dst end
    //##################################################

    public Integer getDstEndMonth()
    {
        return _dstEndMonth;
    }

    public boolean hasDstEndMonth(Integer e)
    {
        return Kmu.isEqual(getDstEndMonth(), e);
    }

    public Integer getDstEndDay()
    {
        return _dstEndDay;
    }

    public boolean hasDstEndDay(Integer e)
    {
        return Kmu.isEqual(getDstEndDay(), e);
    }

    //##################################################
    //# conversion
    //##################################################

    @Override
    public KmTimestamp toLocal(KmTimestamp utc)
    {
        if ( utc == null )
            return null;

        KmTimestamp local = utc.addMinutes(getUtcOffsetMinutes());
        if ( !isLocalDstDate(local) )
            return local;

        return local.addMinutes(getDstOffsetMinutes());
    }

    @Override
    public KmTimestamp toUtc(KmTimestamp local)
    {
        if ( local == null )
            return null;

        KmTimestamp utc = local.subtractMinutes(getUtcOffsetMinutes());
        if ( !isLocalDstDate(local) )
            return utc;

        return utc.subtractMinutes(getDstOffsetMinutes());
    }

    //##################################################
    //# ui
    //##################################################

    public static ScDropdown newDropdown()
    {
        ScDropdown e;
        e = new ScDropdown();
        e.setLabel("Time Zone");
        e.addCodedOptions(getValues());
        return e;
    }

    //##################################################
    //# private
    //##################################################

    /**
     * Determine if the specified date is within the dst date interval.
     */
    private boolean isLocalDstDate(KmTimestamp ts)
    {
        if ( !hasDstCode() )
            return false;

        if ( ts.isBeforeMonthDay(getDstStartMonth(), getDstStartDay()) )
            return false;

        if ( ts.isAfterMonthDay(getDstEndMonth(), getDstEndDay()) )
            return false;

        return true;
    }

}
