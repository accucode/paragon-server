package com.kodemore.zendesk;

import java.io.IOException;

import com.kodemore.http.KmHttpRequest;

public class KmZendeskHttpPut
    extends KmHttpRequest
{
    private String _data;

    //##################################################
    //# constructor
    //##################################################

    public KmZendeskHttpPut()
    {
        setMethodPut();
        setContentTypeJson();
    }

    //##################################################
    //# accessing
    //##################################################//

    public String getData()
    {
        return _data;
    }

    public void setData(String data)
    {
        _data = data;
    }

    @Override
    public String getFullPath()
    {
        return getPath();
    }

    //##################################################
    //# path
    //##################################################

    @Override
    public void _applyRequestValue() throws IOException
    {
        getConnection().setDoOutput(true);
        getConnection().setDoInput(true);
        getConnection().getOutputStream().write(_data.getBytes());

    }
}
