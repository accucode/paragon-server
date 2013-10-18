package com.kodemore.twitter;

/**
 * I am and object with values for all the returned paramaters of a twitter user.
 * 
 * https://dev.twitter.com/docs/platform-objects/users
 * 
 * review_steve KmTwitterUser
 * review_wyatt (steve) 
 */
public class KmTwitterUser
    extends Object
{

    //##################################################
    //# variables 
    //##################################################

    private String          _id;
    private String          _name;
    private String          _location;
    private String          _language;
    private String          _description;
    private String          _createdAt;
    private String          _screenName;
    private String          _url;
    private KmTwitterStatus _status;

    private Integer         _statusesCount;
    private Integer         _favoritesCount;
    private Integer         _friendsCount;
    private Integer         _followersCount;
    private Integer         _listedCount;

    private Boolean         _following;
    private Boolean         _protected;
    private Boolean         _verified;
    private Boolean         _defaultProfile;
    private Boolean         _isTranslator;
    private Boolean         _contributorsEnabled;
    private Boolean         _geoEmbed;
    private Boolean         _followRequestSent;
    private Boolean         _notifications;

    private Boolean         _defaultProflieImage;
    private Boolean         _profileUseBackgroundImage;
    private Boolean         _profileBackgroundTitle;

    private String          _profileSidebarFillColor;
    private String          _profileLinkColor;
    private String          _profileSidebarBoraderColor;
    private String          _profileBackgroundColor;
    private String          _profileTextColor;
    private String          _profileBackgroundImageUrl;
    private String          _profileBackgroundImageUrlHttps;
    private String          _profileImageUrl;
    private String          _profileImageUrlHttps;

    private Integer         _utcOffset;
    private String          _timeZone;

    //##################################################
    //# access
    //##################################################//

    public String getId()
    {
        return _id;
    }

    public void setId(String e)
    {
        _id = e;
    }

    public String getName()
    {
        return _name;
    }

    public void setName(String e)
    {
        _name = e;
    }

    public String getLocation()
    {
        return _location;
    }

    public void setLocation(String e)
    {
        _location = e;
    }

    public String getLanguage()
    {
        return _language;
    }

    public void setLanguage(String e)
    {
        _language = e;
    }

    public String getDescription()
    {
        return _description;
    }

    public void setDescription(String e)
    {
        _description = e;
    }

    public String getCreatedAt()
    {
        return _createdAt;
    }

    public void setCreatedAt(String e)
    {
        _createdAt = e;
    }

    public String getScreenName()
    {
        return _screenName;
    }

    public void setScreenName(String e)
    {
        _screenName = e;
    }

    public KmTwitterStatus getStatus()
    {
        return _status;
    }

    public void setStatus(KmTwitterStatus e)
    {
        _status = e;
    }

    public String getUrl()
    {
        return _url;
    }

    public void setUrl(String e)
    {
        _url = e;
    }

    public Integer getStatusesCount()
    {
        return _statusesCount;
    }

    public void setStatusesCount(Integer e)
    {
        _statusesCount = e;
    }

    public Integer getFavoritesCount()
    {
        return _favoritesCount;
    }

    public void setFavoritesCount(Integer e)
    {
        _favoritesCount = e;
    }

    public Integer getFriendsCount()
    {
        return _friendsCount;
    }

    public void setFriendsCount(Integer e)
    {
        _friendsCount = e;
    }

    public Integer getFollowersCount()
    {
        return _followersCount;
    }

    public void setFollowersCount(Integer e)
    {
        _followersCount = e;
    }

    public Integer getListedCount()
    {
        return _listedCount;
    }

    public void setListedCount(Integer e)
    {
        _listedCount = e;
    }

    public Boolean getFollowing()
    {
        return _following;
    }

    public void setFollowing(Boolean e)
    {
        _following = e;
    }

    public Boolean getProtected()
    {
        return _protected;
    }

    public void setProtected(Boolean e)
    {
        _protected = e;
    }

    public Boolean getVerified()
    {
        return _verified;
    }

    public void setVerified(Boolean e)
    {
        _verified = e;
    }

    public Boolean getDefaultProfile()
    {
        return _defaultProfile;
    }

    public void setDefaultProfile(Boolean e)
    {
        _defaultProfile = e;
    }

    public Boolean getIsTranslator()
    {
        return _isTranslator;
    }

    public void setIsTranslator(Boolean e)
    {
        _isTranslator = e;
    }

    public Boolean getContributorsEnabled()
    {
        return _contributorsEnabled;
    }

    public void setContributorsEnabled(Boolean e)
    {
        _contributorsEnabled = e;
    }

    public Boolean getGeoEmbed()
    {
        return _geoEmbed;
    }

    public void setGeoEmbed(Boolean e)
    {
        _geoEmbed = e;
    }

    public Boolean getFollowRequestSent()
    {
        return _followRequestSent;
    }

    public void setFollowRequestSent(Boolean e)
    {
        _followRequestSent = e;
    }

    public Boolean getNotifications()
    {
        return _notifications;
    }

    public void setNotifications(Boolean e)
    {
        _notifications = e;
    }

    public Boolean getDefaultProflieImage()
    {
        return _defaultProflieImage;
    }

    public void setDefaultProflieImage(Boolean e)
    {
        _defaultProflieImage = e;
    }

    public Boolean getProfileUseBackgroundImage()
    {
        return _profileUseBackgroundImage;
    }

    public void setProfileUseBackgroundImage(Boolean e)
    {
        _profileUseBackgroundImage = e;
    }

    public Boolean getProfileBackgroundTitle()
    {
        return _profileBackgroundTitle;
    }

    public void setProfileBackgroundTitle(Boolean e)
    {
        _profileBackgroundTitle = e;
    }

    public String getProfileSidebarFillColor()
    {
        return _profileSidebarFillColor;
    }

    public void setProfileSidebarFillColor(String e)
    {
        _profileSidebarFillColor = e;
    }

    public String getProfileLinkColor()
    {
        return _profileLinkColor;
    }

    public void setProfileLinkColor(String e)
    {
        _profileLinkColor = e;
    }

    public String getProfileSidebarBoraderColor()
    {
        return _profileSidebarBoraderColor;
    }

    public void setProfileSidebarBoraderColor(String e)
    {
        _profileSidebarBoraderColor = e;
    }

    public String getProfileBackgroundColor()
    {
        return _profileBackgroundColor;
    }

    public void setProfileBackgroundColor(String e)
    {
        _profileBackgroundColor = e;
    }

    public String getProfileTextColor()
    {
        return _profileTextColor;
    }

    public void setProfileTextColor(String e)
    {
        _profileTextColor = e;
    }

    public String getProfileBackgroundImageUrl()
    {
        return _profileBackgroundImageUrl;
    }

    public void setProfileBackgroundImageUrl(String e)
    {
        _profileBackgroundImageUrl = e;
    }

    public String getProfileBackgroundImageUrlHttps()
    {
        return _profileBackgroundImageUrlHttps;
    }

    public void setProfileBackgroundImageUrlHttps(String e)
    {
        _profileBackgroundImageUrlHttps = e;
    }

    public String getProfileImageUrl()
    {
        return _profileImageUrl;
    }

    public void setProfileImageUrl(String e)
    {
        _profileImageUrl = e;
    }

    public String getProfileImageUrlHttps()
    {
        return _profileImageUrlHttps;
    }

    public void setProfileImageUrlHttps(String e)
    {
        _profileImageUrlHttps = e;
    }

    public Integer getUtcOffset()
    {
        return _utcOffset;
    }

    public void setUtcOffset(Integer e)
    {
        _utcOffset = e;
    }

    public String getTimeZone()
    {
        return _timeZone;
    }

    public void setTimeZone(String e)
    {
        _timeZone = e;
    }

}
