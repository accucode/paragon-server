package sandbox.aledbetter;

import com.kodemore.collection.KmList;
import com.kodemore.time.KmTimeUnit;
import com.kodemore.utility.Kmu;

public class AlTest
{
    //##################################################
    //# run
    //##################################################

    private void run()
    {
        KmList<KmTimeUnit> v = KmTimeUnit.getValues();

        System.out.println(
            "########################################\r\n"
                + "#! UPGRADE\r\n"
                + "########################################");
        System.out.println();

        for ( KmTimeUnit unit : v )
        {
            String table = "project";
            String col = "expectedResponseDurationUnit";
            String newCode = unit.getCode();
            String oldCode = unit.getLabel() + "s";

            System.out.println(
                Kmu.format(
                    "update %s set %s = '%s' where %s = '%s';",
                    table,
                    col,
                    newCode,
                    col,
                    oldCode));
        }
        System.out.println();

        for ( KmTimeUnit unit : v )
        {
            String table = "project";
            String col = "taskIdleDurationUnit";
            String newCode = unit.getCode();
            String oldCode = unit.getLabel() + "s";

            System.out.println(
                Kmu.format(
                    "update %s set %s = '%s' where %s = '%s';",
                    table,
                    col,
                    newCode,
                    col,
                    oldCode));
        }
        System.out.println();

        for ( KmTimeUnit unit : v )
        {
            String table = "taskMaster";
            String col = "expectedResponseDurationUnit";
            String newCode = unit.getCode();
            String oldCode = unit.getLabel() + "s";

            System.out.println(
                Kmu.format(
                    "update %s set %s = '%s' where %s = '%s';",
                    table,
                    col,
                    newCode,
                    col,
                    oldCode));
        }
        System.out.println();

        for ( KmTimeUnit unit : v )
        {
            String table = "taskMaster";
            String col = "idleDurationUnit";
            String newCode = unit.getCode();
            String oldCode = unit.getLabel() + "s";

            System.out.println(
                Kmu.format(
                    "update %s set %s = '%s' where %s = '%s';",
                    table,
                    col,
                    newCode,
                    col,
                    oldCode));
        }
        System.out.println();

        System.out.println(
            "########################################\r\n"
                + "#! DOWNGRADE\r\n"
                + "########################################");
        System.out.println();

        for ( KmTimeUnit unit : v )
        {
            String table = "project";
            String col = "expectedResponseDurationUnit";
            String newCode = unit.getCode();
            String oldCode = unit.getLabel() + "s";

            System.out.println(
                Kmu.format(
                    "update %s set %s = '%s' where %s = '%s';",
                    table,
                    col,
                    oldCode,
                    col,
                    newCode));
        }
        System.out.println();

        for ( KmTimeUnit unit : v )
        {
            String table = "project";
            String col = "taskIdleDurationUnit";
            String newCode = unit.getCode();
            String oldCode = unit.getLabel() + "s";

            System.out.println(
                Kmu.format(
                    "update %s set %s = '%s' where %s = '%s';",
                    table,
                    col,
                    oldCode,
                    col,
                    newCode));
        }
        System.out.println();

        for ( KmTimeUnit unit : v )
        {
            String table = "taskMaster";
            String col = "expectedResponseDurationUnit";
            String newCode = unit.getCode();
            String oldCode = unit.getLabel() + "s";

            System.out.println(
                Kmu.format(
                    "update %s set %s = '%s' where %s = '%s';",
                    table,
                    col,
                    oldCode,
                    col,
                    newCode));
        }
        System.out.println();

        for ( KmTimeUnit unit : v )
        {
            String table = "taskMaster";
            String col = "idleDurationUnit";
            String newCode = unit.getCode();
            String oldCode = unit.getLabel() + "s";

            System.out.println(
                Kmu.format(
                    "update %s set %s = '%s' where %s = '%s';",
                    table,
                    col,
                    oldCode,
                    col,
                    newCode));
        }
        System.out.println();

        //        KmDao.run(this::runDao);
    }

    //##################################################
    //# run dao
    //##################################################

    //    private void runDao()
    //    {
    //        System.out.println("test");
    //    }

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        //        MyInstaller.installDatabase();

        System.out.println("========== START ==========");
        new AlTest().run();
        System.out.println("==========  END  ==========");
    }
}
