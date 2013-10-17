package com.kodemore.facebook;

import com.kodemore.collection.KmList;

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
        String accessToken = "CAACEdEose0cBAAuEmR6UXOeZBT4rXcQEMKuZCGqkz9roiGCZCZB8AgoqSujZAN6RjrrOZAPxuwjPqRkD38ZBKVNUYH1OG44R1vssqrX3H4XnALq5thGJin4tUUPGLIyPoPW7Hk7QiwKsZAQN7xLeePvZAT0ZA4ZCIJSEqTk1EcDRo29eCVhbFhYia9aACVErvmHvAgZD";

        /**
         *  review_aaron: This will not work unless you omit the port from the 
         *  request url,  fix this in KmHttpRequest in _openConnection() 
         */
        KmFacebookUserSearchRequest req;
        req = new KmFacebookUserSearchRequest();
        req.setSearch("aaron ledbetter");
        req.setAccessToken(accessToken);
        req.submit();

        KmList<KmFacebookUser> users;
        users = req.getResponseUsers();

        if ( users == null )
        {
            System.out.println("Users is null");
            return;
        }

        if ( users.isEmpty() )
        {
            System.out.println("Users is empty");
            return;
        }

        System.out.println("    users.size(): " + users.size());

        for ( KmFacebookUser e : users )
        {
            String id = e.getId();
            //            String username = e.getUsername();
            String name = e.getName();
            //            String firstName = e.getFisrtName();
            //            String lastName = e.getLastName();
            //            String link = e.getLink();
            //            String locale = e.getLocale();

            //            System.out.println("user: " + users);
            System.out.println("id: " + id);
            //            System.out.println("username: " + username);
            System.out.println("name: " + name);
            //            System.out.println("firstName: " + firstName);
            //            System.out.println("lastName: " + lastName);
            //            System.out.println("link: " + link);
            //            System.out.println("locale: " + locale);
        }
    }
}
