package com.kodemore.twitter;

import com.kodemore.json.KmJsonMap;
import com.kodemore.utility.Kmu;

/**
 * I am used to search for users.
 * 
 * api documentation https://dev.twitter.com/docs/api/1.1/get/users/show
 */
public class KmTwitterShowUserRequest
{
    //##################################################
    //# constants
    //##################################################

    //##################################################
    //# variables 
    //##################################################

    private KmTwitterConnection _connection;

    //##################################################
    //# constructor
    //##################################################

    public KmTwitterShowUserRequest()
    {
        _connection = new KmTwitterConnection();
        //        {
        //            @Override
        //            public KmJsonMap getResponseJson()
        //            {
        //                String s = getResponseString();
        //                /**
        //                 * review_steve hax
        //                 * 
        //                 * review_wyatt (steve) this is totoal hax!
        //                 * looks like the kmTwitterSearchUsersRequest is returning an array, so i wrapped it in a 
        //                 * json object so the parser wouldn't break.
        //                 */
        //                return KmJsonReader.parseJsonMap("{\"RESPONSE\":" + s + "}");
        //                //        return KmJsonReader.parseJsonMap(s);
        //            }
        //        };
        _connection.setPath("/1.1/users/show.json");

    }

    //##################################################
    //# accessing
    //##################################################

    protected KmTwitterConnection getConnection()
    {
        return _connection;
    }

    //##################################################
    //# parameters
    //##################################################//

    protected void setQuery(String s)
    {
        getConnection().setParameter("user_id", s);
    }

    protected void setPage(int i)
    {
        getConnection().setParameter("page", Kmu.toStringSafe(i));
    }

    protected void setCount(int i)
    {
        getConnection().setParameter("count", Kmu.toStringSafe(i));
    }

    //##################################################
    //# oauth
    //##################################################//

    protected void setConsumerKey(String s)
    {
        getConnection().setConsumerKey(s);
    }

    protected void setConsumerSecret(String s)
    {
        getConnection().setConsumerSecret(s);
    }

    protected void setAuthToken(String s)
    {
        getConnection().setAuthToken(s);
    }

    protected void setAuthSecret(String s)
    {
        getConnection().setAuthSecret(s);
    }

    //##################################################
    //# response
    //##################################################//

    protected KmJsonMap getResponseJson()
    {
        return getConnection().getResponseJsonMap();
    }

    protected String getResponseId()
    {
        int i = getResponseJson().getInteger("id");
        return Kmu.toStringSafe(i);
    }

    protected String getResponseDescription()
    {
        return getResponseJson().getString("description");
    }

    protected String getResponseName()
    {
        return getResponseJson().getString("name");
    }

    protected String getResponseLocation()
    {
        return getResponseJson().getString("location");
    }

    protected String getResponseScreenName()
    {
        String s = getResponseJson().getString("screen_name");
        return "@" + s;
    }

    //##################################################
    //# submit
    //##################################################//

    protected void submit()
    {
        getConnection().submit();
    }
}
