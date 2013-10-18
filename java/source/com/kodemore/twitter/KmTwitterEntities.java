package com.kodemore.twitter;

import com.kodemore.collection.KmList;

/**
 * I am and object with values for all the returned paramaters of a twitter user.
 * 
 * https://dev.twitter.com/docs/platform-objects/entities
 * 
 * review_steve KmTwitterEntities
 */
public class KmTwitterEntities
    extends Object
{

    //##################################################
    //# variables 
    //##################################################

    private KmList<String>               _hashtags;
    private KmList<String>               _urls;
    private KmList<KmTwitterUserMention> _mentions;
    private KmList<String>               _symbols;

    //##################################################
    //# access
    //##################################################//

    public KmList<String> getHashtags()
    {
        return _hashtags;
    }

    public void setHashtags(KmList<String> hashtags)
    {
        _hashtags = hashtags;
    }

    public KmList<String> getUrls()
    {
        return _urls;
    }

    public void setUrls(KmList<String> urls)
    {
        _urls = urls;
    }

    public KmList<KmTwitterUserMention> getMentions()
    {
        return _mentions;
    }

    public void setMentions(KmList<KmTwitterUserMention> mentions)
    {
        _mentions = mentions;
    }

    public KmList<String> getSymbols()
    {
        return _symbols;
    }

    public void setSymbols(KmList<String> symbols)
    {
        _symbols = symbols;
    }
}
