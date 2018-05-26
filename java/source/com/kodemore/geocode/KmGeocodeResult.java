/*
  Copyright (c) 2005-2018 www.kodemore.com

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

package com.kodemore.geocode;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

/**
 * I encapsulate a geocode result.
 */
public class KmGeocodeResult
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The full json source. This is primarily for development and
     * debugging. Clients are strongly encouraged to use the convenience
     * methods such as isOk(), and getLocations().
     */
    private String _json;

    /**
     * The status code.
     * This is usually populated, but may be null if we could not connect
     * to the remote web service.
     * https://developers.google.com/maps/documentation/geocoding/intro
     */
    private String _status;

    /**
     * Connection and/or web service error message.
     */
    private String _errorMessage;

    /**
     * The list of locations if the result is ok.
     */
    private KmList<KmGeocodeLocation> _locations;

    //##################################################
    //# constructor
    //##################################################

    public KmGeocodeResult()
    {
        _locations = new KmList<>();
    }

    //##################################################
    //# source
    //##################################################

    public void setJson(String e)
    {
        _json = e;
    }

    public String getJson()
    {
        return _json;
    }

    //##################################################
    //# status
    //##################################################

    public String getStatus()
    {
        return _status;
    }

    public void setStatus(String e)
    {
        _status = e;
    }

    public boolean hasStatus()
    {
        return _status != null;
    }

    public boolean hasStatus(String e)
    {
        return Kmu.isEqual(_status, e);
    }

    public boolean isOk()
    {
        return hasStatus("OK");
    }

    //##################################################
    //# error message
    //##################################################

    public String getErrorMessage()
    {
        return _errorMessage;
    }

    public void setErrorMessage(String e)
    {
        _errorMessage = e;
    }

    public boolean hasErrorMessage()
    {
        return _errorMessage != null;
    }

    //##################################################
    //# locations
    //##################################################

    public KmList<KmGeocodeLocation> getLocations()
    {
        return _locations;
    }

    public void addLocation(KmGeocodeLocation e)
    {
        _locations.add(e);
    }
}
