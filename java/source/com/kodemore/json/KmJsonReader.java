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

    public static KmJsonObject readJsonMap(String file)
    {
        String json = Kmu.readTextFile(file);
        return parseJsonObject(json);
    }

    public static KmJsonList readJsonList(String file)
    {
        String json = Kmu.readTextFile(file);
        return parseJsonList(json);
    }

    //##################################################
    //# parse
    //##################################################

    public static KmJsonObject parseJsonObject(String json)
    {
        try
        {
            Object e = new JSONParser().parse(json);
            return new KmJsonObject((JSONObject)e);
        }
        catch ( ParseException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public static KmJsonList parseJsonList(String json)
    {
        try
        {
            Object e = new JSONParser().parse(json);
            return new KmJsonList((JSONArray)e);
        }
        catch ( ParseException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

}
