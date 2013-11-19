package com.kodemore.zendesk;

import org.apache.commons.codec.binary.*;

import com.kodemore.collection.*;
import com.kodemore.http.*;
import com.kodemore.json.*;

/**
 * I am used connect to Zendesk; make various requests.
 */
public class KmZendeskConnection
{
    //##################################################
    //# constants
    //##################################################

    private static String               HOST = "accucodeit.zendesk.com";

    //##################################################
    //# variables (public)
    //##################################################

    /**
     * The uri path.  In general, don't encode parameters into the path;
     * set the parameters separately.
     */
    private String                      _path;
    private String                      _host;
    private String                      _apiToken;
    private String                      _userId;

    /**
     * The list of parameters.  Parameters are generally stored and used
     * in the sequence that they are set.  Changing the value of a parameter
     * preserves the initial sequence.
     */
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

    public KmZendeskConnection()
    {
        _parameters = new KmOrderedMap<String,String>();
        _host = HOST;
    }

    //##################################################
    //# accessing
    //##################################################

    public String getApiToken()
    {
        return _apiToken;
    }

    public void setApiToken(String apiToken)
    {
        _apiToken = apiToken;
    }

    public String getUserId()
    {
        return _userId;
    }

    public void setUserId(String userId)
    {
        _userId = userId;
    }

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

    public void setParameter(String key, int value)
    {
        _parameters.put(key, value + "");
    }

    public String getHost()
    {
        return _host;
    }

    public void setHost(String host)
    {
        _host = host;
    }

    //##################################################
    //# public
    //##################################################

    public void submitGet()
    {
        _request = new KmHttpGet();
        _request.setHost(HOST);
        _request.setHttps();
        _request.setPort(443);
        _request.setContentTypeHtml();
        _request.setPath(getPath());
        _request.setParameters(_parameters);
        _request.setHeader("Authorization", getAuthorizationHeader());
        _request.submit();
        _request.checkException();
    }

    //##################################################
    //# response
    //##################################################

    public String getResponseString()
    {
        return _request.getResponseString();
    }

    public KmJsonMap getResponseJsonMap()
    {
        String s = getResponseString();
        return KmJsonReader.parseJsonMap(s);
    }

    public KmJsonArray getResponseJsonArray()
    {
        String s = getResponseString();
        return KmJsonReader.parseJsonArray(s);
    }

    //##################################################
    //# authorization header
    //##################################################

    private String getAuthorizationHeader()
    {
        String e = getUserId() + "/token:" + getApiToken();
        String out = toBase64(e.getBytes());

        return "Basic " + out.toString();
    }

    //##################################################
    //# utility
    //##################################################

    private String toBase64(byte[] value)
    {
        byte[] base64 = Base64.encodeBase64(value);
        String s = new String(base64);

        return s.trim();
    }
}
