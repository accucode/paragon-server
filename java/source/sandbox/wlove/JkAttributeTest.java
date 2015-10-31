package sandbox.wlove;

import com.kodemore.command.KmDao;
import com.kodemore.thread.KmThread;
import com.kodemore.utility.KmRandom;
import com.kodemore.utility.KmTimer;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoRegistry;
import com.app.filter.MyMasterProductFilter;
import com.app.model.MyAttributeField;
import com.app.model.MyProduct;
import com.app.model.MyProject;
import com.app.utility.MyGlobals;
import com.app.utility.MyInstaller;

public class JkAttributeTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        System.out.println("--------------------");
        new JkAttributeTest().run();
        System.out.println("--------------------");
        System.out.println("ok.");
    }

    private void run()
    {
        MyInstaller.install();
        System.out.println();

        int n = 20;
        for ( int i = 0; i < n; i++ )
            new KmThread(this::testLoop).startLater();

        // Kmu.sleepSeconds(5);
        // MyInstaller.shutdown();
    }

    protected void testOnce()
    {
        try
        {
            KmDao.run(this::updateValue);
        }
        catch ( RuntimeException ex )
        {
            ex.printStackTrace();
            System.exit(1);
        }
    }

    protected void testLoop()
    {
        try
        {
            KmTimer t = KmTimer.run();
            while ( t.getSeconds() < 60 )
            {
                KmDao.run(this::updateValue);
                Kmu.sleepSeconds(1);
            }
        }
        catch ( RuntimeException ex )
        {
            System.out.println();
            System.out.println("Root...");
            System.out.println(Kmu.getRootCause(ex).getClass().getName());
            System.out.println();
            ex.printStackTrace();
            System.exit(1);
        }
    }

    private void updateValue()
    {
        MyProduct product = getProduct();
        MyAttributeField field = getField();
        String value = getRandomValue();

        // product.setDescription(value);
        product.setAttribute(field, value);

        System.out.println("Set value to: " + value);
    }

    private String getRandomValue()
    {
        int i = KmRandom.getInstance().getInteger(5);

        if ( i == 0 )
            return null;

        return i + "";
    }

    private MyAttributeField getField()
    {
        return getProject().findProductAttributeName("Size");
    }

    private MyProduct getProduct()
    {
        MyMasterProductFilter f;
        f = new MyMasterProductFilter();
        f.setProject(getProject());
        f.setPartNumber("MER-MR12");

        return f.findFirst().getPublishedVersion();
    }

    private MyProject getProject()
    {
        return getAccess().getProjectDao().findFirst();
    }

    //##################################################
    //# support
    //##################################################

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }

}
