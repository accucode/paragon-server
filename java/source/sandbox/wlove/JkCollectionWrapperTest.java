package sandbox.wlove;

import java.util.Iterator;

import com.kodemore.collection.KmCollectionWrapper;

public class JkCollectionWrapperTest
{
    public static void main(String[] args)
    {
        new JkCollectionWrapperTest().run();
    }

    private void run()
    {
        KmCollectionWrapper<Integer> c;
        c = new KmCollectionWrapper<>();
        c.add(1);
        c.add(2);
        c.add(3);

        System.out.println();
        Iterator<Integer> i = c.iterator();
        while ( i.hasNext() )
        {
            Integer e = i.next();
            System.out.println(e);
            if ( e.equals(2) )
                i.remove();
        }

        System.out.println();
        for ( Integer e : c )
            System.out.println(e);
    }
}
