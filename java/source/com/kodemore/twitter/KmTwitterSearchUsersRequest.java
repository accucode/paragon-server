package com.kodemore.twitter;

import com.kodemore.collection.KmList;
import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;
import com.kodemore.utility.Kmu;

/**
 * I am used to search for users.
 * 
 * api documentation https://dev.twitter.com/docs/api/1.1/get/users/search
 * 
 * review_steve KmTwitterSearchUserRequest
 * review_wyatt (steve) 
 */
public class KmTwitterSearchUsersRequest
{
    //##################################################
    //# variables 
    //##################################################

    private KmTwitterConnection _connection;

    //##################################################
    //# constructor
    //##################################################

    public KmTwitterSearchUsersRequest()
    {
        _connection = new KmTwitterConnection();
        _connection.setPath("/1.1/users/search.json");
    }

    //##################################################
    //# accessing
    //##################################################

    protected KmTwitterConnection getConnection()
    {
        return _connection;
    }

    //##################################################
    //# parameters
    //##################################################//

    protected void setQuery(String s)
    {
        getConnection().setParameter("q", s);
    }

    protected void setPage(int i)
    {
        getConnection().setParameter("page", Kmu.toStringSafe(i));
    }

    protected void setCount(int i)
    {
        getConnection().setParameter("count", Kmu.toStringSafe(i));
    }

    //##################################################
    //# oauth
    //##################################################//

    protected void setConsumerKey(String s)
    {
        getConnection().setConsumerKey(s);
    }

    protected void setConsumerSecret(String s)
    {
        getConnection().setConsumerSecret(s);
    }

    protected void setAuthToken(String s)
    {
        getConnection().setAuthToken(s);
    }

    protected void setAuthSecret(String s)
    {
        getConnection().setAuthSecret(s);
    }

    //##################################################
    //# response
    //##################################################//

    protected KmJsonArray getResponseJson()
    {
        return getConnection().getResponseJsonArray();
    }

    protected KmList<KmTwitterUser> getResponseUsers()
    {
        KmJsonArray resp = getResponseJson();

        KmList<KmTwitterUser> v = new KmList<KmTwitterUser>();

        int n = resp.size();
        for ( int i = 0; i < n; i++ )
        {
            KmJsonMap jsonObject = resp.getMapAt(i);
            v.add(createTwitterUser(jsonObject));
        }
        return v;
    }

    //##################################################
    //# submit
    //##################################################//

    protected void submit()
    {
        getConnection().submit();
    }

    protected KmTwitterUser createTwitterUser(KmJsonMap json)
    {
        KmTwitterUser u = new KmTwitterUser();

        if ( json != null )
        {
            u.setLocation(json.getString("location"));
            u.setDefaultProfile(json.getBoolean("default_profile"));
            u.setProfileBackgroundTitle(json.getBoolean("profile_background_tile"));
            u.setStatusesCount(json.getInteger("statuses_count"));
            u.setLanguage(json.getString("lang"));
            u.setProfileLinkColor(json.getString("profile_link_color"));
            u.setId(json.getString("id_str"));
            u.setFollowing(json.getBoolean("following"));
            u.setProtected(json.getBoolean("protected"));
            u.setFavoritesCount(json.getInteger("favourites_count"));
            u.setProfileTextColor(json.getString("profile_text_color"));
            u.setDescription(json.getString("description"));
            u.setVerified(json.getBoolean("verified"));
            u.setContributorsEnabled(json.getBoolean("contributors_enabled"));
            u.setProfileSidebarBoraderColor(json.getString("profile_sidebar_border_color"));
            u.setName(json.getString("name"));
            u.setProfileBackgroundColor(json.getString("profile_background_color"));
            u.setCreatedAt(json.getString("created_at"));
            u.setDefaultProflieImage(json.getBoolean("default_profile_image"));
            u.setFollowersCount(json.getInteger("followers_count"));
            u.setProfileImageUrlHttps(json.getString("profile_image_url_https"));
            u.setGeoEmbed(json.getBoolean("geo_enabled"));
            u.setStatus(createTwitterStatus(json.getMap("status")));
            u.setProfileBackgroundImageUrl(json.getString("profile_background_image_url"));
            u.setProfileBackgroundImageUrlHttps(json.getString("profile_background_image_url_https"));
            u.setFollowRequestSent(json.getBoolean("follow_request_sent"));
            u.setUrl(json.getString("url"));
            u.setUtcOffset(json.getInteger("utc_offset"));
            u.setTimeZone(json.getString("time_zone"));
            u.setNotifications(json.getBoolean("notifications"));
            u.setProfileUseBackgroundImage(json.getBoolean("profile_use_background_image"));
            u.setFriendsCount(json.getInteger("friends_count"));
            u.setProfileSidebarFillColor(json.getString("profile_sidebar_fill_color"));
            u.setScreenName(json.getString("screen_name"));
            u.setProfileImageUrl(json.getString("profile_image_url"));
            u.setListedCount(json.getInteger("listed_count"));
            u.setIsTranslator(json.getBoolean("is_translator"));
        }

        return u;
    }

    //##################################################
    //# users
    //##################################################//

    protected KmTwitterStatus createTwitterStatus(KmJsonMap json)
    {
        KmTwitterStatus u = new KmTwitterStatus();

        if ( json != null )
        {
            u.setContributors(createContributors(json.getArray("contributors")));
            u.setText(json.getString("text"));
            u.setRetweeted(json.getBoolean("retweeted"));
            u.setInReplyToScreenName(json.getString("in_reply_to_screen_name"));
            u.setInReplyToStatusId(json.getString("in_reply_to_status_id_str"));
            u.setInReplyToUserId(json.getString("in_reply_to_user_id_str"));
            u.setTruncated(json.getBoolean("truncated"));
            u.setLanguage(json.getString("lang"));
            u.setSource(json.getString("source"));
            u.setFavorited(json.getBoolean("favorited"));
            u.setRetweetCount(json.getInteger("retweet_count"));
            u.setCreatedAt(json.getString("created_at"));
            u.setFavoriteCount(json.getInteger("favorite_count"));
            u.setPlace(createTwitterPlace(json.getMap("place")));
            u.setEntities(createEntities(json.getMap("entities")));
        }
        return u;
    }

    //##################################################
    //# status
    //##################################################//

    private KmTwitterPlace createTwitterPlace(KmJsonMap json)
    {
        KmTwitterPlace u = new KmTwitterPlace();

        if ( json != null )
        {
            //review_steve figure out what in the world place "attributes" are
            u.setAttributes(json.getMap("attributes").formatJson());
            u.setCountry(json.getString("country"));
            u.setCountryCode(json.getString("country_code"));
            u.setFullName(json.getString("full_name"));
            u.setId(json.getString("id"));
            u.setName(json.getString("name"));
            u.setPlaceType(json.getString("place_type"));
            u.setUrl(json.getString("url"));
            u.setBoundingbox(createBoundingBox(json.getMap("bounding_box")));
        }
        return u;
    }

    private KmTwitterEntities createEntities(KmJsonMap json)
    {
        KmTwitterEntities u = new KmTwitterEntities();

        if ( json != null )
        {
            u.setHashtags(createHashtags(json.getArray("hashtags")));
            u.setSymbols(createSymbols(json.getArray("symbols")));
            u.setUrls(createUrls(json.getArray("urls")));
            u.setMentions(createMentions(json.getArray("user_mentions")));
        }
        return u;
    }

    //##################################################
    //# place
    //##################################################//

    /**
     * coordinates are wierd, the json object has an array of an 
     * array of arrays with long and lat inside, so the line 
     * " KmJsonArray coordinatesArray = json.getArray("coordinates").getArray(0); " 
     * is unpacking the outer array to get at the actual array of coordinate arrays.
     */
    private KmTwitterBoundingBox createBoundingBox(KmJsonMap json)
    {
        KmTwitterBoundingBox u = new KmTwitterBoundingBox();

        if ( json != null )
        {
            KmJsonArray coordinatesArray = json.getArray("coordinates").getArray(0);
            u.setCoordinates(createCoordinates(coordinatesArray));
            u.setType(json.getString("type"));
        }

        return u;
    }

    //##################################################
    //# entities
    //##################################################//

    public KmList<KmTwitterUserMention> createMentions(KmJsonArray json)
    {
        KmList<KmTwitterUserMention> v = new KmList<KmTwitterUserMention>();

        if ( json != null )
        {
            int n = json.size();
            for ( int i = 0; i < n; i++ )
            {
                KmTwitterUserMention u = new KmTwitterUserMention();
                u.setId(json.getMapAt(i).getString("id_str"));
                u.setName(json.getMapAt(i).getString("name"));
                u.setScreenName(json.getMapAt(i).getString("screen_name"));

                v.add(u);
            }
        }
        return v;
    }

    public KmList<String> createSymbols(KmJsonArray json)
    {
        KmList<String> v = new KmList<String>();

        if ( json != null )
        {
            int n = json.size();
            for ( int i = 0; i < n; i++ )
                v.add(json.getMapAt(i).getString("text"));
        }
        return v;
    }

    public KmList<String> createUrls(KmJsonArray json)
    {
        KmList<String> v = new KmList<String>();

        if ( json != null )
        {
            int n = json.size();
            for ( int i = 0; i < n; i++ )
                v.add(json.getMapAt(i).getString("expanded_url"));
        }
        return v;
    }

    public KmList<String> createHashtags(KmJsonArray json)
    {
        KmList<String> v = new KmList<String>();

        if ( json != null )
        {
            int n = json.size();
            for ( int i = 0; i < n; i++ )
                v.add(json.getMapAt(i).getString("text"));
        }
        return v;
    }

    //##################################################
    //# bounding box
    //##################################################//
    /**
     * coordinates are wierd, the json object has an array of an array of arrays with long and lat
     * inside, so the line " json = json.getArray(i); " is unpacking the long and lat to put into
     * the coordinate object. we did the initial unpacking in the createBoundingBox method above.
     */
    public KmList<KmTwitterCoordinate> createCoordinates(KmJsonArray json)
    {
        KmList<KmTwitterCoordinate> v = new KmList<KmTwitterCoordinate>();

        if ( json != null )
        {
            int n = json.size();
            for ( int i = 0; i < n; i++ )
            {
                json = json.getArray(i);

                KmTwitterCoordinate coord = new KmTwitterCoordinate();
                coord.setLongitude(json.getDoubleAt(0));
                coord.setLatitude(json.getDoubleAt(1));

                v.add(coord);
            }
        }
        return v;
    }

    //##################################################
    //# status
    //##################################################//

    public KmList<String> createContributors(KmJsonArray json)
    {
        KmList<String> v = new KmList<String>();

        if ( json != null )
        {
            int n = json.size();
            for ( int i = 0; i < n; i++ )
            {
                KmJsonMap jsonObject = json.getMapAt(i);
                v.add(jsonObject.getString("id_str"));
            }
        }
        return v;
    }
}
