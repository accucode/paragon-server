package sandbox.wlove;

import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyAccount;
import com.app.model.MyUser;
import com.app.utility.MyGlobals;
import com.app.utility.MyInstaller;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDaoCommand;
import com.kodemore.utility.Kmu;

@SuppressWarnings("unused")
public class JkDaoTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        new JkDaoTest().run();
    }

    //##################################################
    //# run
    //##################################################

    private void run()
    {
        MyInstaller.installDatabase();

        newResetCommand().run();

        newTest1Command().run();
        newTest2Command().run();
        newTest3Command().run();
        newTest4Command().run();
        newTest5Command().run();

        printHeader("end");
    }

    //##################################################
    //# commands
    //##################################################

    private KmDaoCommand newResetCommand()
    {
        return new KmDaoCommand()
        {
            @Override
            protected void handle()
            {
                handleReset();
            }
        };
    }

    private KmDaoCommand newTest1Command()
    {
        return new KmDaoCommand()
        {
            @Override
            protected void handle()
            {
                handleTest1();
            }
        };
    }

    private KmDaoCommand newTest2Command()
    {
        return new KmDaoCommand()
        {
            @Override
            protected void handle()
            {
                handleTest2();
            }
        };
    }

    private KmDaoCommand newTest3Command()
    {
        return new KmDaoCommand()
        {
            @Override
            protected void handle()
            {
                handleTest3();
            }
        };
    }

    private KmDaoCommand newTest4Command()
    {
        return new KmDaoCommand()
        {
            @Override
            protected void handle()
            {
                handleTest4();
            }
        };
    }

    private KmDaoCommand newTest5Command()
    {
        return new KmDaoCommand()
        {
            @Override
            protected void handle()
            {
                handleTest5();
            }
        };
    }

    //##################################################
    //# reset
    //##################################################

    private void handleReset()
    {
        printHeader("Reset");

        MyDaoRegistry access;
        access = getAccess();
        access.getAccountUserDao().deleteAll();
        access.getAccountDao().deleteAll();
        access.getUserDao().deleteAll();
        access.getUserDao().createRootUser();

        printResults();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleTest1()
    {
        printHeader("test 1");

        /**
         * This works...
         * In the simplest case you can just grab the account and delete it.
         * The associated accountUsers will automatically be deleted too.
         */
        //        findRootAccount().deleteDao();

        /**
         * This works too...
         * If you touch the user within the session, then you need to explicitly remove
         * the accountUser from the user before deleting the account.
         */
        //        MyUser u = findRootUser();
        //        MyAccountUser au = u.getAccountUsers().getFirst();
        //        MyAccount a = au.getAccount();
        //
        //        u.removeAccountUser(au);
        //        a.deleteDao();

    }

    private void handleTest2()
    {
        printHeader("test 2");

        MyUser bob = createUser("Bob");
        MyUser riley = createUser("Riley");

        MyAccount blueCo = bob.addBusinessAccount("BlueCo");
        riley.joinAccount(blueCo);

        MyAccount redCo = riley.addBusinessAccount("RedCo");
        bob.joinAccount(redCo);

        printResults();
    }

    private void handleTest3()
    {
        printHeader("test 3");
        printResults();
    }

    private void handleTest4()
    {
        // none
    }

    private void handleTest5()
    {
        // none
    }

    //##################################################
    //# utility
    //##################################################

    private MyUser createUser(String name)
    {
        String email = name + "@acme.com";

        MyUser u;
        u = new MyUser();
        u.setName(name);
        u.setEmail(email);
        u.addPersonalAccount();
        u.saveDao();
        return u;
    }

    private KmList<MyAccount> findAccounts(String name)
    {
        return getAccess().getAccountDao().findName(name);
    }

    private KmList<MyUser> findUsers(String name)
    {
        return getAccess().getUserDao().findName(name);
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }

    //##################################################
    //# print
    //##################################################

    private void printHeader(String s)
    {
        String prefix = "-- " + s.toUpperCase() + " ";

        System.out.println();
        System.out.print(prefix);
        System.out.println(Kmu.dashes(80 - prefix.length()));
        System.out.println();
    }

    private void printResults()
    {
        printUsers();
        printAccounts();
    }

    private void printUsers()
    {
        KmList<MyUser> users = getAccess().findAllUsers();
        System.out.printf("Users(%s)\n", users.size());

        for ( MyUser e : users )
            System.out.printf("    %s: %s.\n", e.getName(), e.getAccountNames().format());
    }

    private void printAccounts()
    {
        KmList<MyAccount> accounts = getAccess().findAllAccounts();
        System.out.printf("Accounts(%s)\n", accounts.size());

        for ( MyAccount e : accounts )
            System.out.printf("    %s: %s.\n", e.getName(), e.getUserNames().format());
    }

}
