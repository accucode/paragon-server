package com.app.ui.page.login;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.utility.Kmu;

import com.app.ui.page.MyBookmark;
import com.app.ui.page.MyPage;

public class MyLoginBookmark
    extends MyBookmark
{
    //##################################################
    //# constants
    //##################################################

    private static final String PARAM_QUERY = "q";
    private static final String PARAM_ERROR = "error";

    //##################################################
    //# variables
    //##################################################

    private String _query;
    private String _error;

    //##################################################
    //# constructor
    //##################################################

    public MyLoginBookmark(MyPage e)
    {
        super(e);
    }

    //##################################################
    //# query
    //##################################################

    public String getQuery()
    {
        return _query;
    }

    public void setQuery(String e)
    {
        _query = e;
    }

    public boolean hasQuery()
    {
        return Kmu.hasValue(getQuery());
    }

    //##################################################
    //# error
    //##################################################

    public String getError()
    {
        return _error;
    }

    public void setError(String e)
    {
        _error = e;
    }

    public boolean hasError()
    {
        return Kmu.hasValue(_error);
    }

    //##################################################
    //# params
    //##################################################

    @Override
    public void readFrom(ScParameterList params)
    {
        super.readFrom(params);

        setQuery(params.getString(PARAM_QUERY));
        setError(params.getString(PARAM_ERROR));
    }

    @Override
    public void writeTo(ScParameterList params)
    {
        super.writeTo(params);

        params.setString(PARAM_QUERY, getQuery());
        params.setString(PARAM_ERROR, getError());
    }

}
