package com.kodemore.zendesk;

import com.kodemore.json.KmJsonMap;

/**
 * I am a via object
 *
 * Api documentation
 *      http://developer.zendesk.com/documentation/rest_api/ticket_audits.html#the-via-object
 */

public class KmZendeskVia
{

    //##################################################
    //# variables (public)
    //##################################################
    private String    _channel;
    private KmJsonMap _source;

    //##################################################
    //# accessing
    //##################################################

    public String getChannel()
    {
        return _channel;
    }

    public void setChannel(String channel)
    {
        _channel = channel;
    }

    public KmJsonMap getSource()
    {
        return _source;
    }

    public void setSource(KmJsonMap source)
    {
        _source = source;
    }

    public String format()
    {
        return "channel=" + _channel + ", source=" + _source;
    }
}
