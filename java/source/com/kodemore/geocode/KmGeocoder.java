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

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;
import com.kodemore.json.KmJsonReader;
import com.kodemore.utility.Kmu;

/**
 * I am used to convert an address into a location: latitude & longitude.
 * Also, I can compute the distance between to locations.
 *
 * This relies on Google's Geocoding API.
 * c. 2017, they allow 2500 free requests per day, and more if you configure billing.
 * https://developers.google.com/maps/documentation/geocoding/start
 *
 * An API Key is required, but is easy to generate if you have a Google Apps account.
 * https://developers.google.com/maps/documentation/geocoding/get-api-key
 */
public class KmGeocoder
{
    //##################################################
    //# variables
    //##################################################

    private String _apiKey;

    //##################################################
    //# constructor
    //##################################################

    public KmGeocoder(String apiKey)
    {
        _apiKey = apiKey;
    }

    //##################################################
    //# accessing
    //##################################################

    public KmGeocodeResult geocode(String address)
    {
        try
        {
            String urlString = formatUrl(address);
            URL url = new URL(urlString);
            HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
            String json = Kmu.readStringFrom(con.getInputStream());
            return toResult(json);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    private String formatUrl(String address)
    {
        return ""
            + "https://maps.googleapis.com"
            + "/maps/api/geocode/json"
            + "?key="
            + encode(_apiKey)
            + "&address="
            + encode(address);
    }

    //##################################################
    //# support
    //##################################################

    private String encode(String e)
    {
        try
        {
            return URLEncoder.encode(e, "UTF-8");
        }
        catch ( UnsupportedEncodingException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    private KmGeocodeResult toResult(String json)
    {
        KmJsonMap response = KmJsonReader.parseJsonMap(json);

        String status = response.getString("status");
        String error = response.getString("error_message");

        KmGeocodeResult result;
        result = new KmGeocodeResult();
        result.setJson(json);
        result.setStatus(status);
        result.setErrorMessage(error);

        if ( !result.isOk() )
            return result;

        KmJsonArray arr = response.getArray("results");
        int n = arr.size();
        for ( int i = 0; i < n; i++ )
        {
            KmJsonMap map = arr.getMapAt(i);
            KmJsonMap geo = map.getMapAtPath("geometry/location");

            KmGeocodeLocation loc;
            loc = new KmGeocodeLocation();
            loc.setAddress(map.getString("formatted_address"));
            loc.setPlaceId(map.getString("place_id"));
            loc.setLatitude(geo.getDouble("lat"));
            loc.setLongitude(geo.getDouble("lng"));
            result.addLocation(loc);
        }

        return result;
    }

}
