package com.kodemore.twitter;

/**
 * I am and object with values for all the returned paramaters of a twitter user.
 * 
 * https://dev.twitter.com/docs/platform-objects/users
 * 
 * review_steve KmTwitterCoordinates
 * review_wyatt (steve) 
 */
public class KmTwitterCoordinate
    extends Object
{

    //##################################################
    //# variables 
    //##################################################

    private Double _longitude;
    private Double _latitude;

    //##################################################
    //# access
    //##################################################//

    public Double getLongitude()
    {
        return _longitude;
    }

    public void setLongitude(Double e)
    {
        _longitude = e;
    }

    public Double getLatitude()
    {
        return _latitude;
    }

    public void setLatitude(Double e)
    {
        _latitude = e;
    }
}
