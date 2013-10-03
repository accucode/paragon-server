package sandbox.wlove;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import twitter4j.RateLimitStatus;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class JkTwitterTimelineTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        new JkTwitterTimelineTest().run();
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

        ResponseList<Status> statuses = new ResponseList<Status>()
        {
            @Override
            public <T> T[] toArray(T[] a)
            {
                // todo_steve Auto-generated method stub
                return null;
            }

            @Override
            public Object[] toArray()
            {
                // todo_steve Auto-generated method stub
                return null;
            }

            @Override
            public List<Status> subList(int fromIndex, int toIndex)
            {
                // todo_steve Auto-generated method stub
                return null;
            }

            @Override
            public int size()
            {
                // todo_steve Auto-generated method stub
                return 0;
            }

            @Override
            public Status set(int index, Status element)
            {
                // todo_steve Auto-generated method stub
                return null;
            }

            @Override
            public boolean retainAll(Collection<?> c)
            {
                // todo_steve Auto-generated method stub
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c)
            {
                // todo_steve Auto-generated method stub
                return false;
            }

            @Override
            public Status remove(int index)
            {
                // todo_steve Auto-generated method stub
                return null;
            }

            @Override
            public boolean remove(Object o)
            {
                // todo_steve Auto-generated method stub
                return false;
            }

            @Override
            public ListIterator<Status> listIterator(int index)
            {
                // todo_steve Auto-generated method stub
                return null;
            }

            @Override
            public ListIterator<Status> listIterator()
            {
                // todo_steve Auto-generated method stub
                return null;
            }

            @Override
            public int lastIndexOf(Object o)
            {
                // todo_steve Auto-generated method stub
                return 0;
            }

            @Override
            public Iterator<Status> iterator()
            {
                // todo_steve Auto-generated method stub
                return null;
            }

            @Override
            public boolean isEmpty()
            {
                // todo_steve Auto-generated method stub
                return false;
            }

            @Override
            public int indexOf(Object o)
            {
                // todo_steve Auto-generated method stub
                return 0;
            }

            @Override
            public Status get(int index)
            {
                // todo_steve Auto-generated method stub
                return null;
            }

            @Override
            public boolean containsAll(Collection<?> c)
            {
                // todo_steve Auto-generated method stub
                return false;
            }

            @Override
            public boolean contains(Object o)
            {
                // todo_steve Auto-generated method stub
                return false;
            }

            @Override
            public void clear()
            {
                // todo_steve Auto-generated method stub

            }

            @Override
            public boolean addAll(int index, Collection<? extends Status> c)
            {
                // todo_steve Auto-generated method stub
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Status> c)
            {
                // todo_steve Auto-generated method stub
                return false;
            }

            @Override
            public void add(int index, Status element)
            {
                // todo_steve Auto-generated method stub

            }

            @Override
            public boolean add(Status e)
            {
                // todo_steve Auto-generated method stub
                return false;
            }

            @Override
            public int getAccessLevel()
            {
                // todo_steve Auto-generated method stub
                return 0;
            }

            @Override
            public RateLimitStatus getRateLimitStatus()
            {
                // todo_steve Auto-generated method stub
                return null;
            }
        };
        try
        {
            statuses = twitter.getHomeTimeline();
        }
        catch ( TwitterException ex )
        {
            // todo_steve Auto-generated catch block
            ex.printStackTrace();
        }

        System.out.println("Showing home timeline.");
        for ( Status status : statuses )
        {
            System.out.println("---------------------------------------------------"
                + "-----------------------------------------------------------------"
                + "-----------------------");
            System.out.println(status.getUser().getName() + ":" + status.getText());
        }
    }
}
