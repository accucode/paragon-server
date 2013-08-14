package com.app.ui.activity.test;

import com.kodemore.collection.KmCollection;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.dao.MyUserDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyAccount;
import com.app.model.MyAccountUser;
import com.app.model.MyUser;

public class MyHackTestPage
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyHackTestPage instance = new MyHackTestPage();

    private MyHackTestPage()
    {
        // singleton
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScPageRoot installRoot()
    {
        ScPageRoot root;
        root = newPageRoot();

        ScBox buttons;
        buttons = root.addButtonBox();
        buttons.addButton("Reset", newResetAction());

        buttons = root.addButtonBox();
        buttons.addButton("Test 1a", newTest1aAction());
        buttons.addButton("Test 1b", newTest1bAction());
        buttons.addButton("Test 1c", newTest1cAction());
        buttons.addButton("Test 1d", newTest1dAction());

        buttons = root.addButtonBox();
        buttons.addButton("Test 2a", newTest2aAction());
        buttons.addButton("Test 2b", newTest2bAction());

        return root;
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newResetAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleReset();
            }
        };
    }

    private ScActionIF newTest1aAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleTest1a();
            }
        };
    }

    private ScActionIF newTest1bAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleTest1b();
            }
        };
    }

    private ScActionIF newTest1cAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleTest1c();
            }
        };
    }

    private ScActionIF newTest1dAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleTest1d();
            }
        };
    }

    private ScActionIF newTest2aAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleTest2a();
            }
        };
    }

    private ScActionIF newTest2bAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleTest2b();
            }
        };
    }

    //##################################################
    //# handle
    //##################################################

    private void handleReset()
    {
        reset();
    }

    //##################################################
    //# test 1
    //##################################################

    private void handleTest1a()
    {
        createUser("wlove");
        System.out.println("created");
    }

    private void handleTest1b()
    {
        MyUser u = findUser("wlove");
        KmCollection<MyAccountUser> v = u.getAccountUsers();
        System.out.println("Account Users: " + v.size());
    }

    private void handleTest1c()
    {
        MyUser u = findUser("wlove");
        MyAccount a = u.getAccountUsers().getFirst().getAccount();
        a.setName(u.getName());
        System.out.println("Account: " + a);
    }

    private void handleTest1d()
    {
        findUser("wlove").deleteDao();
    }

    //##################################################
    //# test 2
    //##################################################

    private void handleTest2a()
    {
        reset();

        String name = "wlove";
        createUser(name);

        MyUser u = findUser(name);
        MyAccount a = u.getAccountUsers().getFirst().getAccount();

        a.setName(name);
        System.out.println("Created user and updated account");
    }

    private void handleTest2b()
    {
        findAccount("wlove").deleteDao();
    }

    //##################################################
    //# utility
    //##################################################

    private void reset()
    {
        MyDaoRegistry access;
        access = getAccess();
        access.getAccountUserDao().deleteAll();
        access.getAccountDao().deleteAll();
        access.getUserDao().deleteAll();
        access.getUserDao().createRootUser();

        System.out.println("reset");
        System.out.println("---------------------------------------------------------------------");
    }

    private void createUser(String name)
    {
        String email = name + "@acme.com";
        String pwd = null;

        MyUserDao dao;
        dao = getAccess().getUserDao();
        dao.createNewUserInvitation(name, email, pwd);
    }

    private MyUser findUser(String name)
    {
        return getAccess().getUserDao().findName(name);
    }

    private MyAccount findAccount(String name)
    {
        return getAccess().getAccountDao().findName(name);
    }
}
