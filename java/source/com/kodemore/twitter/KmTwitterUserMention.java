package com.kodemore.twitter;

/**
 * I am and object representing a user that has been mentioned in a tweet.
 * 
 * https://dev.twitter.com/docs/tweet-entities
 * 
 * review_wyatt (steve) 
 */
public class KmTwitterUserMention
    extends Object
{

    //##################################################
    //# variables 
    //##################################################

    private String _id;
    private String _name;
    private String _screenName;

    //##################################################
    //# access
    //##################################################//

    public String getId()
    {
        return _id;
    }

    public void setId(String e)
    {
        _id = e;
    }

    public String getName()
    {
        return _name;
    }

    public void setName(String e)
    {
        _name = e;
    }

    public String getScreenName()
    {
        return _screenName;
    }

    public void setScreenName(String e)
    {
        _screenName = e;
    }
}
