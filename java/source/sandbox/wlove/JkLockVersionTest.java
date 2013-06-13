package sandbox.wlove;

public class JkLockVersionTest
{
    //    public static void main(String[] args)
    //    {
    //        new JkLockVersionTest().run();
    //    }
    //
    //    private void run()
    //    {
    //        MyInstaller.installDatabase();
    //
    //        reset();
    //        createMaster();
    //        addChildInParallel(3);
    //        addChildInParallel(5);
    //    }
    //
    //    private void reset()
    //    {
    //        new KmDaoCommand()
    //        {
    //            @Override
    //            protected void handle()
    //            {
    //                getTestMasterDao()._truncate();
    //                getTestChildDao()._truncate();
    //            }
    //        }.run();
    //    }
    //
    //    private void createMaster()
    //    {
    //        new KmDaoCommand()
    //        {
    //            @Override
    //            protected void handle()
    //            {
    //                MyTestMaster e;
    //                e = new MyTestMaster();
    //                e.saveDao();
    //            }
    //        }.run();
    //    }
    //
    //    private void addChildInParallel(final int delta)
    //    {
    //        new Thread()
    //        {
    //            @Override
    //            public void run()
    //            {
    //                addChildRetry(delta, 1);
    //            }
    //        }.start();
    //    }
    //
    //    private void addChildRetry(final int delta, final int delay)
    //    {
    //        while ( true )
    //            try
    //            {
    //                addChild(delta, delay);
    //                return;
    //            }
    //            catch ( RuntimeException ex )
    //            {
    //                Throwable root = Kmu.getRootCause(ex);
    //                if ( root instanceof StaleObjectStateException )
    //                    continue;
    //                throw ex;
    //            }
    //    }
    //
    //    private void addChild(final int delta, final int delay)
    //    {
    //        new KmDaoCommand()
    //        {
    //            @Override
    //            protected void handle()
    //            {
    //                Kmu.sleepSeconds(delay);
    //
    //                MyTestMaster m;
    //                m = getTestMasterDao().findAll().getFirst();
    //
    //                int oldValue = m.getValue();
    //                int newValue = oldValue + delta;
    //
    //                MyTestChild c;
    //                c = m.addChild();
    //                c.setDelta(delta);
    //                c.setOldValue(oldValue);
    //                c.setNewValue(newValue);
    //
    //                m.setValue(newValue);
    //            }
    //        }.run();
    //    }
}
