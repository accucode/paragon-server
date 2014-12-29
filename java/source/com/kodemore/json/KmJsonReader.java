package com.kodemore.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.kodemore.utility.Kmu;

/**
 * Wraps the json-simple library.
 * http://code.google.com/p/json-simple/
 * Apache License 2.0
 */
public abstract class KmJsonReader
{
    //##################################################
    //# read
    //##################################################

    public static KmJsonMap readJsonMap(String file)
    {
        String json = Kmu.readFileString(file);
        return parseJsonMap(json);
    }

    public static KmJsonArray readJsonArray(String file)
    {
        String json = Kmu.readFileString(file);
        return parseJsonArray(json);
    }

    //##################################################
    //# parse
    //##################################################

    public static KmJsonMap parseJsonMap(String json)
    {
        try
        {
            Object e = new JSONParser().parse(json);
            return new KmJsonMap((JSONObject)e);
        }
        catch ( ParseException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public static KmJsonArray parseJsonArray(String json)
    {
        try
        {
            Object e = new JSONParser().parse(json);
            return new KmJsonArray((JSONArray)e);
        }
        catch ( ParseException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

}
