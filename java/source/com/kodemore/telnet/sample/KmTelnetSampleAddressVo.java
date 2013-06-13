/*
  Copyright (c) 2005-2011 www.kodemore.com

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

package com.kodemore.telnet.sample;

public class KmTelnetSampleAddressVo
{
    //##################################################
    //# variables
    //##################################################

    private String _street;
    private String _city;
    private String _state;
    private String _zip;

    //##################################################
    //# constructor
    //##################################################

    public KmTelnetSampleAddressVo()
    {
        _street = "";
        _city = "";
        _state = "";
        _zip = "";
    }

    //##################################################
    //# accessing
    //##################################################

    public String getStreet()
    {
        return _street;
    }

    public void setStreet(String e)
    {
        _street = e;
    }

    public String getCity()
    {
        return _city;
    }

    public void setCity(String e)
    {
        _city = e;
    }

    public String getState()
    {
        return _state;
    }

    public void setState(String e)
    {
        _state = e;
    }

    public String getZip()
    {
        return _zip;
    }

    public void setZip(String e)
    {
        _zip = e;
    }

}
