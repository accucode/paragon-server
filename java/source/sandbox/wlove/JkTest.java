package sandbox.wlove;

import twitter4j.ResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.UserList;
import twitter4j.conf.ConfigurationBuilder;

public class JkTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        new JkTest().run();
    }

    //##################################################
    //# run
    //##################################################

    private void run()
    {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true).setOAuthConsumerKey("Udran5zmhShyr5etGhFRgg").setOAuthConsumerSecret(
            "ggtZ1KzsoGYlid6CBXk7327NgRfZsUsi8w68p1WpBw").setOAuthAccessToken(
            "1927388761-AULOl5HVWeOoQztUF0hPsyo6SmOkz17lfuQ7Cau").setOAuthAccessTokenSecret(
            "4jVUX0UXulgHBSeX2SJBhUuBJB3IZAFljGSwLPtnsE");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        ResponseList<UserList> users = null;
        try
        {
            users = twitter.getUserLists(0);
        }
        catch ( TwitterException ex )
        {
            // todo_steve Auto-generated catch block
            ex.printStackTrace();
        }
        if ( users != null )
            for ( UserList ul : users )
            {
                User u = ul.getUser();

                System.out.println("name: " + u.getName());
                System.out.println("ID: " + u.getId());
                System.out.println("Access Level: " + u.getAccessLevel());
                System.out.println("favorites count: " + u.getFavouritesCount());
                System.out.println("friends count: " + u.getFriendsCount());

            }

    }
}
