package com.kodemore.twitter;

import com.kodemore.collection.KmList;

/**
 * I am and object representing a user that has been mentioned in a tweet.
 *
 * https://dev.twitter.com/docs/tweet-entities
 *
 * KmTwitterBoundingBox
 */
public class KmTwitterBoundingBox
    extends Object
{
    //##################################################
    //# variables
    //##################################################

    private KmList<KmTwitterCoordinate> _coordinates;
    private String                      _type;

    //##################################################
    //# access
    //##################################################

    public KmList<KmTwitterCoordinate> getCoordinates()
    {
        return _coordinates;
    }

    public void setCoordinates(KmList<KmTwitterCoordinate> e)
    {
        _coordinates = e;
    }

    public String getType()
    {
        return _type;
    }

    public void setType(String e)
    {
        _type = e;
    }

}
