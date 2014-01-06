/*
  Copyright (c) 2005-2014 www.kodemore.com

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
*/

package com.kodemore.sql;

import com.kodemore.sql.adaptor.KmSqlAdaptor;

/**
 * I provide a basic implementation for create connections using a data source.
 */
public class KmSqlDataSourceConnectionFactory
    implements KmSqlConnectionFactoryIF
{
    //##################################################
    //# variables
    //##################################################

    private String       _path;
    private String       _factory;
    private String       _url;
    private String       _login;
    private String       _password;
    private KmSqlAdaptor _adaptor;

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return getUrl();
    }

    public String getPath()
    {
        return _path;
    }

    public void setPath(String e)
    {
        _path = e;
    }

    public String getFactory()
    {
        return _factory;
    }

    public void setFactory(String e)
    {
        _factory = e;
    }

    public String getUrl()
    {
        return _url;
    }

    public void setUrl(String e)
    {
        _url = e;
    }

    public String getLogin()
    {
        return _login;
    }

    public void setLogin(String e)
    {
        _login = e;
    }

    public String getPassword()
    {
        return _password;
    }

    public void setPassword(String e)
    {
        _password = e;
    }

    public KmSqlAdaptor getAdaptor()
    {
        return _adaptor;
    }

    public void setAdaptor(KmSqlAdaptor e)
    {
        _adaptor = e;
    }

    //##################################################
    //# actions
    //##################################################

    @Override
    public KmSqlConnection open()
    {
        return KmSqlUtility.openDataSourceConnection(
            _path,
            _factory,
            _url,
            _login,
            _password,
            _adaptor);
    }

}
