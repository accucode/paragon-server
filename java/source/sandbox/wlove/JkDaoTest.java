package sandbox.wlove;

import java.util.Random;

import com.kodemore.command.KmDaoRunnableCommand;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.KmCrc;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoAccess;
import com.app.model.MyFieldTest;
import com.app.utility.MyGlobals;
import com.app.utility.MyInstaller;

public class JkDaoTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        new JkDaoTest().run();
        System.exit(0);
    }

    //##################################################
    //# run
    //##################################################

    private void run()
    {
        install();
        runCommand();
        print("ok.");
    }

    private void install()
    {
        MyInstaller.installDatabase();
        print("installed.");
        printDivider();
    }

    private void runCommand()
    {
        KmDaoRunnableCommand cmd;
        cmd = new KmDaoRunnableCommand();
        cmd.disableWarningThresholdMs();
        cmd.setRunnable(this::handle);
        cmd.run();

        print("done.");
        printDivider();
    }

    //##################################################
    //# test
    //##################################################

    private Random _random = new Random();

    private void handle()
    {
        MyDaoAccess access = getAccess();

        access.getFieldTestDao().deleteAll();
        access.flush();

        int n = 100;
        for ( int i = 0; i < n; i++ )
        {
            String name = getRandomName();
            int crc = KmCrc.crc(name);

            MyFieldTest e;
            e = new MyFieldTest();
            e.setNameValue(name);
            e.setIntegerValue(crc);
            e.daoAttach();
        }
    }

    private String getRandomName()
    {
        KmStringBuilder out = new KmStringBuilder();

        int n = 50;
        for ( int i = 0; i < n; i++ )
            out.append(getRandomCharacter());

        return out.toString();
    }

    private char getRandomCharacter()
    {
        while ( true )
        {
            char c = (char)_random.nextInt(256);
            if ( Kmu.isSingleLinePrintable(c) )
                return c;
        }
    }

    //##################################################
    //# print
    //##################################################

    private void printDivider()
    {
        print("----------------------------------------");
    }

    private void print(String s)
    {
        System.out.println(s);
    }

    //##################################################
    //# support
    //##################################################

    protected MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

}
