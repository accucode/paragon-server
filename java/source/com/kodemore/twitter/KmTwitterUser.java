package com.kodemore.twitter;

import com.kodemore.json.KmJsonMap;

/**
 * I am and object with values for all the returned paramaters of a twitter user.
 */
public class KmTwitterUser
    extends Object
{

    //##################################################
    //# variables 
    //##################################################

    private String  _location;
    private Boolean _defaultProfile;
    private Boolean _profileBackgroundTitle;
    private Integer _statusesCount;
    private String  _profileLinkColor;
    private String  _language;
    /**
     * id is returned as an int, so we need to remember to change it into a string in the getters
     * 
     * use the id_str parameter
     */
    private String  _id;
    private Boolean _following;
    private Boolean _protected;
    private Integer _favoritesCount;
    private String  _profileTextColor;
    private String  _description;
    private Boolean _verified;
    private Boolean _contributorsEnabled;
    private String  _profileSidebarBoraderColor;
    private String  _name;
    private String  _profileBackgroundColor;
    private String  _createdAt;
    private Boolean _defaultProflieImage;
    private Integer _followersCount;
    private String  _profileImageUrlHttps;
    private Boolean _geoEmbed;
    /**
     * create a KmTwitterStatus
     */
    private String  _status;
    private String  _profileBackgroundImageUrl;
    private String  _profileBackgroundImageUrlHttps;
    private Boolean _followRequestSent;
    /**
     * create KmUserEntities class
     */
    private String  _entities;
    /**
     * i don't know what data type the url is.
     */
    private String  _url;
    private Integer _utcOffset;
    private String  _timeZone;
    private Boolean _notifications;
    private Boolean _profileUseBackgroundImage;
    private Integer _friendsCount;
    private String  _profileSidebarFillColor;
    private String  _screenName;

    private String  _profileImageUrl;
    private Integer _listedCount;
    private Boolean _isTranslator;

    //##################################################
    //# constructor
    //##################################################//

    public KmTwitterUser(KmJsonMap user)
    {
        setTwitterUser(user);
    }

    //##################################################
    //# access
    //##################################################//

    protected String getLocation()
    {
        return _location;
    }

    protected void setLocation(String location)
    {
        _location = location;
    }

    protected Boolean getDefaultProfile()
    {
        return _defaultProfile;
    }

    protected void setDefaultProfile(Boolean defaultProfile)
    {
        _defaultProfile = defaultProfile;
    }

    protected Boolean getProfileBackgroundTitle()
    {
        return _profileBackgroundTitle;
    }

    protected void setProfileBackgroundTitle(Boolean profileBackgroundTitle)
    {
        _profileBackgroundTitle = profileBackgroundTitle;
    }

    protected int getStatusesCount()
    {
        return _statusesCount;
    }

    protected void setStatusesCount(int statusesCount)
    {
        _statusesCount = statusesCount;
    }

    protected String getProfileLinkColor()
    {
        return _profileLinkColor;
    }

    protected void setProfileLinkColor(String profileLinkColor)
    {
        _profileLinkColor = profileLinkColor;
    }

    protected String getLanguage()
    {
        return _language;
    }

    protected void setLanguage(String profileLinkColor)
    {
        _language = profileLinkColor;
    }

    protected String getId()
    {
        return _id;
    }

    protected void setId(String id)
    {
        _id = id;
    }

    protected Boolean getFollowing()
    {
        return _following;
    }

    protected void setFollowing(Boolean following)
    {
        _following = following;
    }

    protected Boolean getProtected()
    {
        return _protected;
    }

    protected void setProtected(Boolean protected1)
    {
        _protected = protected1;
    }

    protected int getFavoritesCount()
    {
        return _favoritesCount;
    }

    protected void setFavoritesCount(int favoritesCount)
    {
        _favoritesCount = favoritesCount;
    }

    protected String getProfileTextColor()
    {
        return _profileTextColor;
    }

    protected void setProfileTextColor(String profileTextColor)
    {
        _profileTextColor = profileTextColor;
    }

    protected String getDescription()
    {
        return _description;
    }

    protected void setDescription(String description)
    {
        _description = description;
    }

    protected Boolean getVerified()
    {
        return _verified;
    }

    protected void setVerified(Boolean verified)
    {
        _verified = verified;
    }

    protected Boolean getContributorsEnabled()
    {
        return _contributorsEnabled;
    }

    protected void setContributorsEnabled(Boolean contributorsEnabled)
    {
        _contributorsEnabled = contributorsEnabled;
    }

    protected String getProfileSidebarBoraderColor()
    {
        return _profileSidebarBoraderColor;
    }

    protected void setProfileSidebarBoraderColor(String profileSidebarBoraderColor)
    {
        _profileSidebarBoraderColor = profileSidebarBoraderColor;
    }

    protected String getName()
    {
        return _name;
    }

    protected void setName(String profileSidebarBoraderColor)
    {
        _name = profileSidebarBoraderColor;
    }

    protected String getProfileBackgroundColor()
    {
        return _profileBackgroundColor;
    }

    protected void setProfileBackgroundColor(String profileSidebarBoraderColor)
    {
        _profileBackgroundColor = profileSidebarBoraderColor;
    }

    protected String getCreatedAt()
    {
        return _createdAt;
    }

    protected void setCreatedAt(String createdAt)
    {
        _createdAt = createdAt;
    }

    protected Boolean getDefaultProflieImage()
    {
        return _defaultProflieImage;
    }

    protected void setDefaultProflieImage(Boolean defaultProflieImage)
    {
        _defaultProflieImage = defaultProflieImage;
    }

    protected int getFollowersCount()
    {
        return _followersCount;
    }

    protected void setFollowersCount(int followersCount)
    {
        _followersCount = followersCount;
    }

    protected String getProfileImageUrlHttps()
    {
        return _profileImageUrlHttps;
    }

    protected void setProfileImageUrlHttps(String profileImageUrlHttps)
    {
        _profileImageUrlHttps = profileImageUrlHttps;
    }

    protected Boolean getGeoEmbed()
    {
        return _geoEmbed;
    }

    protected void setGeoEmbed(Boolean geoEmbed)
    {
        _geoEmbed = geoEmbed;
    }

    protected String getStatus()
    {
        return _status;
    }

    protected void setStatus(String status)
    {
        _status = status;
    }

    protected String getProfileBackgroundImageUrl()
    {
        return _profileBackgroundImageUrl;
    }

    protected void setProfileBackgroundImageUrl(String profileBackgroundImageUrl)
    {
        _profileBackgroundImageUrl = profileBackgroundImageUrl;
    }

    protected String getProfileBackgroundImageUrlHttps()
    {
        return _profileBackgroundImageUrlHttps;
    }

    protected void setProfileBackgroundImageUrlHttps(String profileBackgroundImageUrlHttps)
    {
        _profileBackgroundImageUrlHttps = profileBackgroundImageUrlHttps;
    }

    protected Boolean getFollowRequestSent()
    {
        return _followRequestSent;
    }

    protected void setFollowRequestSent(Boolean followRequestSent)
    {
        _followRequestSent = followRequestSent;
    }

    protected String getEntities()
    {
        return _entities;
    }

    protected void setEntities(String entities)
    {
        _entities = entities;
    }

    protected String getUrl()
    {
        return _url;
    }

    protected void setUrl(String url)
    {
        _url = url;
    }

    protected int getUtcOffset()
    {
        return _utcOffset;
    }

    protected void setUtcOffset(int utcOffset)
    {
        _utcOffset = utcOffset;
    }

    protected String getTimeZone()
    {
        return _timeZone;
    }

    protected void setTimeZone(String timeZone)
    {
        _timeZone = timeZone;
    }

    protected Boolean getNotifications()
    {
        return _notifications;
    }

    protected void setNotifications(Boolean notifications)
    {
        _notifications = notifications;
    }

    protected Boolean getProfileUseBackgroundImage()
    {
        return _profileUseBackgroundImage;
    }

    protected void setProfileUseBackgroundImage(Boolean profileUseBackgroundImage)
    {
        _profileUseBackgroundImage = profileUseBackgroundImage;
    }

    protected int getFriendsCount()
    {
        return _friendsCount;
    }

    protected void setFriendsCount(int friendsCount)
    {
        _friendsCount = friendsCount;
    }

    protected String getProfileSidebarFillColor()
    {
        return _profileSidebarFillColor;
    }

    protected void setProfileSidebarFillColor(String profileSidebarFillColor)
    {
        _profileSidebarFillColor = profileSidebarFillColor;
    }

    protected String getScreenName()
    {
        return _screenName;
    }

    protected void setScreenName(String screenName)
    {
        _screenName = screenName;
    }

    protected String getProfileImageUrl()
    {
        return _profileImageUrl;
    }

    protected void setProfileImageUrl(String profileImageUrl)
    {
        _profileImageUrl = profileImageUrl;
    }

    protected int getListedCount()
    {
        return _listedCount;
    }

    protected void setListedCount(int listedCount)
    {
        _listedCount = listedCount;
    }

    protected Boolean getIsTranslator()
    {
        return _isTranslator;
    }

    protected void setIsTranslator(Boolean isTranslator)
    {
        _isTranslator = isTranslator;
    }

    protected void setTwitterUser(KmJsonMap user)
    {
        setLocation(user.getString("location"));
        setDefaultProfile(user.getBoolean("default_profile"));
        setProfileBackgroundTitle(user.getBoolean("profile_background_tile"));
        setStatusesCount(user.getInteger("statuses_count"));
        setLanguage(user.getString("lang"));
        setProfileLinkColor(user.getString("profile_link_color"));
        setId(user.getString("id_str"));
        setFollowing(user.getBoolean("following"));
        setProtected(user.getBoolean("protected"));
        setFavoritesCount(user.getInteger("favourites_count"));
        setProfileTextColor(user.getString("profile_text_color"));
        setDescription(user.getString("description"));
        setVerified(user.getBoolean("verified"));
        setContributorsEnabled(user.getBoolean("contributors_enabled"));
        setProfileSidebarBoraderColor(user.getString("profile_sidebar_border_color"));
        setName(user.getString("name"));
        setProfileBackgroundColor(user.getString("profile_background_color"));
        setCreatedAt(user.getString("created_at"));
        setDefaultProflieImage(user.getBoolean("default_profile_image"));
        setFollowersCount(user.getInteger("followers_count"));
        setProfileImageUrlHttps(user.getString("profile_image_url_https"));
        setGeoEmbed(user.getBoolean("geo_enabled"));
        //        setStatus(user.getString("status"));
        setProfileBackgroundImageUrl(user.getString("profile_background_image_url"));
        setProfileBackgroundImageUrlHttps(user.getString("profile_background_image_url_https"));
        setFollowRequestSent(user.getBoolean("follow_request_sent"));
        //        setEntities(user.getString("location"));
        setUrl(user.getString("url"));
        setUtcOffset(user.getInteger("utc_offset"));
        setTimeZone(user.getString("time_zone"));
        setNotifications(user.getBoolean("notifications"));
        setProfileUseBackgroundImage(user.getBoolean("profile_use_background_image"));
        setFriendsCount(user.getInteger("friends_count"));
        setProfileSidebarFillColor(user.getString("profile_sidebar_fill_color"));
        setScreenName(user.getString("screen_name"));
        setProfileImageUrl(user.getString("profile_image_url"));
        setListedCount(user.getInteger("listed_count"));
        setIsTranslator(user.getBoolean("is_translator"));
    }
}
