package com.kodemore.facebook;

import com.kodemore.collection.KmOrderedMap;
import com.kodemore.http.KmHttpGet;
import com.kodemore.http.KmHttpRequest;
import com.kodemore.json.KmJsonMap;
import com.kodemore.json.KmJsonReader;

/**
 * review_wyatt (aaron)
 * 
 * I am used connect to Facebook to make various requests.
 * 
 * Facebook Graph Api documentation: http://goo.gl/cj4rBE
 */
public class KmFacebookConnection
{
    //##################################################
    //# constants
    //##################################################

    private static String               HOST = "graph.facebook.com";

    private String                      _path;
    private KmOrderedMap<String,String> _parameters;

    //##################################################
    //# variables (private)
    //##################################################

    /**
     * The http request wrapper.
     */
    private KmHttpRequest               _request;

    //##################################################
    //# constructor
    //##################################################

    public KmFacebookConnection()
    {
        _parameters = new KmOrderedMap<String,String>();
    }

    //##################################################
    //# accessing
    //##################################################

    public String getPath()
    {
        return _path;
    }

    public void setPath(String e)
    {
        _path = e;
    }

    public KmOrderedMap<String,String> getRequestParameters()
    {
        return _parameters;
    }

    public void setParameter(String key, String value)
    {
        _parameters.put(key, value);
    }

    //##################################################
    //# public
    //##################################################

    public void submit()
    {
        _request = new KmHttpGet();
        _request.setHost(HOST);
        _request.setHttps();
        _request.setPort(443);
        _request.setPath(getPath());
        _request.setParameters(getRequestParameters());
        _request.submit();

        // remove_aaron: 
        System.out.println("    _request.getUrl().toString(): " + _request.getUrl().toString());

        _request.checkException();
    }

    //##################################################
    //# response
    //##################################################

    public String getResponseString()
    {
        return _request.getResponseString();
    }

    public KmJsonMap getResponseJson()
    {
        String s = getResponseString();
        return KmJsonReader.parseJsonMap(s);
    }
}
