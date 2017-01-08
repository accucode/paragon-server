package com.kodemore.twitter;

import com.kodemore.collection.KmList;

/**
 * I am and object representing a user that has been mentioned in a tweet.
 *
 * https://dev.twitter.com/docs/tweet-entities
 *
 * KmTwitterStatus
 */
public class KmTwitterStatus
    extends Object
{
    //##################################################
    //# variables
    //##################################################

    private KmList<String>    _contributors;
    private String            _text;
    private Boolean           _retweeted;
    private String            _inReplyToScreenName;
    private String            _inReplyToStatusId;
    private String            _inReplyToUserId;
    private Boolean           _truncated;
    private String            _language;
    private String            _source;
    private Boolean           _favorited;
    private Integer           _retweetCount;
    private String            _createdAt;
    private Integer           _favoriteCount;
    private KmTwitterPlace    _place;
    private KmTwitterEntities _entities;

    //##################################################
    //# access
    //##################################################

    public KmList<String> getContributors()
    {
        return _contributors;
    }

    public void setContributors(KmList<String> contributors)
    {
        _contributors = contributors;
    }

    public String getText()
    {
        return _text;
    }

    public void setText(String e)
    {
        _text = e;
    }

    public Boolean getRetweeted()
    {
        return _retweeted;
    }

    public void setRetweeted(Boolean e)
    {
        _retweeted = e;
    }

    public String getInReplyToScreenName()
    {
        return _inReplyToScreenName;
    }

    public void setInReplyToScreenName(String e)
    {
        _inReplyToScreenName = e;
    }

    public String getInReplyToStatusId()
    {
        return _inReplyToStatusId;
    }

    public void setInReplyToStatusId(String e)
    {
        _inReplyToStatusId = e;
    }

    public String getInReplyToUserId()
    {
        return _inReplyToUserId;
    }

    public void setInReplyToUserId(String e)
    {
        _inReplyToUserId = e;
    }

    public Boolean getTruncated()
    {
        return _truncated;
    }

    public void setTruncated(Boolean e)
    {
        _truncated = e;
    }

    public String getLanguage()
    {
        return _language;
    }

    public void setLanguage(String e)
    {
        _language = e;
    }

    public String getSource()
    {
        return _source;
    }

    public void setSource(String e)
    {
        _source = e;
    }

    public Boolean getFavorited()
    {
        return _favorited;
    }

    public void setFavorited(Boolean e)
    {
        _favorited = e;
    }

    public Integer getRetweetCount()
    {
        return _retweetCount;
    }

    public void setRetweetCount(Integer e)
    {
        _retweetCount = e;
    }

    public String getCreatedAt()
    {
        return _createdAt;
    }

    public void setCreatedAt(String e)
    {
        _createdAt = e;
    }

    public Integer getFavoriteCount()
    {
        return _favoriteCount;
    }

    public void setFavoriteCount(Integer e)
    {
        _favoriteCount = e;
    }

    public KmTwitterPlace getPlace()
    {
        return _place;
    }

    public void setPlace(KmTwitterPlace e)
    {
        _place = e;
    }

    public KmTwitterEntities getEntities()
    {
        return _entities;
    }

    public void setEntities(KmTwitterEntities e)
    {
        _entities = e;
    }

}
