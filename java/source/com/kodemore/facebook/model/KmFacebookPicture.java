package com.kodemore.facebook.model;

import com.kodemore.json.KmJsonMap;

/**
 * A user's Facebook profile picture
 */
public class KmFacebookPicture
    extends Object
{
    //##################################################
    //# constants
    //##################################################

    public static final String URL_KEY          = "url";
    public static final String IS_SILOUETTE_KEY = "is_silhouette";

    //##################################################
    //# variables
    //##################################################

    // review_aaron: do we want to save the actual photo?
    /**
     * The url of the photo
     */
    private String             _url;

    /**
     * Is true if the user has not selected a profile picture
     * and a silouette placeholder is displayed instead.
     */
    private Boolean            _isSilouette;

    //##################################################
    //# accessing
    //##################################################

    public String getUrl()
    {
        return _url;
    }

    public void setUrl(String url)
    {
        _url = url;
    }

    public Boolean getIsSilouette()
    {
        return _isSilouette;
    }

    public void setIsSilouette(Boolean isSilouette)
    {
        _isSilouette = isSilouette;
    }

    //##################################################
    //# convenience
    //##################################################

    public static KmFacebookPicture createWith(KmJsonMap map)
    {
        KmFacebookPicture e;
        e = new KmFacebookPicture();
        e.setUrl(map.getString(URL_KEY));
        e.setIsSilouette(map.getBoolean(IS_SILOUETTE_KEY));
        return e;
    }
}
