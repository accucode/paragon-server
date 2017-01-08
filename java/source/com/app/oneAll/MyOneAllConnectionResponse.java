package com.app.oneAll;

import com.kodemore.collection.KmList;
import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;

public class MyOneAllConnectionResponse
{
    //##################################################
    //# variables
    //##################################################

    private KmJsonMap _doc;

    //##################################################
    //# constructor
    //##################################################

    public MyOneAllConnectionResponse(KmJsonMap doc)
    {
        _doc = doc;
    }

    //##################################################
    //# accessing
    //##################################################

    public KmJsonMap getDoc()
    {
        return _doc;
    }

    //##################################################
    //# convenience
    //##################################################

    /**
     * Indicates if OneAll returned a successful response.
     */
    public boolean isOk()
    {
        return getStatusCode() == 200;
    }

    /**
     * The status code reported by OneAll.
     * This may be useful as a display value if the response is not ok.
     */
    public int getStatusCode()
    {
        return getDoc().getIntegerAtPath("response/result/status/code");
    }

    /**
     * The status message reported by OneAll.
     * This may be useful as a display value if the response is not ok.
     */
    public String getStatusMessage()
    {
        return getDoc().getStringAtPath("response/result/status/info");
    }

    /**
     * The list of all emails that have been verified by OneAll.
     */
    public KmList<String> getVerifiedEmails()
    {
        KmList<String> v = new KmList<>();

        KmJsonArray arr = getDoc().getArrayAtPath("response/result/data/user/identity/emails");
        KmList<KmJsonMap> maps = arr.getAllAsMaps();

        for ( KmJsonMap map : maps )
        {
            boolean verified = map.getBoolean("is_verified");
            String value = map.getString("value");

            if ( verified )
                v.addNonNullDistinct(value);
        }

        return v;
    }

    /**
     * This uniquely identifies the user in the OneAll systesm.
     */
    public String getUserToken()
    {
        return getDoc().getStringAtPath("response/result/data/user/user_token");
    }

    /**
     * The users display name, as reported by OneAll.
     */
    public String getUserName()
    {
        return getDoc().getStringAtPath("response/result/data/user/identity/name/formatted");
    }
}
