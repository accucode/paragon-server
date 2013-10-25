package com.kodemore.facebook;

import com.kodemore.facebook.model.KmFacebookUser;

public class KmFacebookTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        /**
         *  review_aaron this expires after about an hour, to generate a new one
         *  go to https://developers.facebook.com/tools/explorer
         */
        String accessToken = "CAACEdEose0cBAMSZCMCqtyMXJuD44SHErCQOQHnatOzypJuDHZCE0cLnxUbMCOyo4e2ElZCZBUYEwmzyhIIwZAGIzZAZBKybLFSiY07ZBwfudhOBcIpE3N84z4REZAZBwIOXnT0Os41YhbxghK9H4fOqAMZCafRbWbai8uyGsxcDhNF6erXUN8AQcuygQ4cwf0uF7YZD";

        // review_aaron: search request, requires access token
        //        KmFacebookUserSearchRequest req;
        //        req = new KmFacebookUserSearchRequest();
        //        req.setSearch("aaron ledbetter");
        //
        //        req.setAccessToken(accessToken);
        //        req.submit();
        //
        //        KmList<KmFacebookUser> users;
        //        users = req.getResponseUsers();
        //
        //        if ( users == null )
        //        {
        //            System.out.println("Users is null");
        //            return;
        //        }
        //
        //        if ( users.isEmpty() )
        //        {
        //            System.out.println("Users is empty");
        //            return;
        //        }
        //
        //        System.out.println("    users.size(): " + users.size());
        //
        //        for ( KmFacebookUser e : users )
        //        {
        //            String id = e.getId();
        //            String username = e.getUsername();
        //            String name = e.getName();
        //            String firstName = e.getFirstName();
        //            String middleName = e.getMiddleName();
        //            String lastName = e.getLastName();
        //            String link = e.getLink();
        //            String locale = e.getLocale();
        //
        //            System.out.println("id: " + id);
        //            System.out.println("username: " + username);
        //            System.out.println("name: " + name);
        //            System.out.println("firstName: " + firstName);
        //            System.out.println("middleName: " + middleName);
        //            System.out.println("lastName: " + lastName);
        //            System.out.println("link: " + link);
        //            System.out.println("locale: " + locale);
        //            System.out.println();
        //        }

        KmFacebookIdRequest req;
        req = new KmFacebookIdRequest();
        req.setQuery("steveganado12");
        req.setAccessToken(accessToken);

        KmFacebookUser u = req.findUser();
        if ( u == null )
        {
            System.out.println("User is Null");
            return;
        }

        String id = u.getId();
        String username = u.getUsername();
        String name = u.getName();
        String firstName = u.getFirstName();
        String middleName = u.getMiddleName();
        String lastName = u.getLastName();
        String link = u.getLink();
        String locale = u.getLocale();

        System.out.println("id: " + id);
        System.out.println("username: " + username);
        System.out.println("name: " + name);
        System.out.println("firstName: " + firstName);
        System.out.println("middleName: " + middleName);
        System.out.println("lastName: " + lastName);
        System.out.println("link: " + link);
        System.out.println("locale: " + locale);
        System.out.println();
    }
}
