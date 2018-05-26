package com.app.ui.control;

import com.kodemore.servlet.control.ScDivWrapper;
import com.kodemore.utility.Kmu;

public class MyGoogleMapMarker
    extends ScDivWrapper
{
    //##################################################
    //# variables
    //##################################################

    private String _title;
    private double _latitude;
    private double _longitude;

    //##################################################
    //# constructor
    //##################################################

    public MyGoogleMapMarker()
    {
        // none
    }

    //##################################################
    //# title
    //##################################################

    public String getTitle()
    {
        return _title;
    }

    public void setTitle(String e)
    {
        _title = e;
    }

    public boolean hasTitle()
    {
        return Kmu.hasValue(_title);
    }

    //##################################################
    //# latitude
    //##################################################

    public double getLatitude()
    {
        return _latitude;
    }

    public void setLatitude(double e)
    {
        _latitude = e;
    }

    //##################################################
    //# longitude
    //##################################################

    public double getLongitude()
    {
        return _longitude;
    }

    public void setLongitude(double e)
    {
        _longitude = e;
    }
}
