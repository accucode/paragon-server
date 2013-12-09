package com.kodemore.patch;

import com.kodemore.collection.*;
import com.kodemore.console.*;

/**
 * I provide the majority of functionality for a command line
 * tool that runs various patch functions.  The client application
 * must override and implement a few methods.
 */
public abstract class KmPatchConsole
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The arguments, it any passed on the command line.
     */
    private KmList<String> _arguments;

    /**
     * The manager that performs the real work.
     */
    private KmPatchManager _manager;

    //##################################################
    //# run
    //##################################################

    public void run(String[] args)
    {
        _manager = new KmPatchManager();
        _arguments = new KmList<String>();
        _arguments.addAll(args);
        run();
    }

    private void run()
    {
        try
        {
            process();
        }
        catch ( RuntimeException ex )
        {
            ex.printStackTrace();
            System.out.println();
            System.out.println();
            System.out.println("PATCH FAILED !!!");
            System.out.println();
        }
    }

    //##################################################
    //# process
    //##################################################

    private void printUsage()
    {
        System.out.println();
        System.out.println();
        System.out.println("Commands...");
        System.out.println("    menu (the default command)");
        System.out.println("    sync");
        System.out.println("    test");
        System.out.println("    upgradeAll");
        System.out.println("    upgradeLast");
        System.out.println("    upgrade <name>");
        System.out.println("    downgradeAll");
        System.out.println("    downgrade <name>");
        System.out.println("    repeat <name>");
        System.out.println("    repeatLast");
        System.out.println("    rerepeatLast");
        System.out.println("    create");
    }

    private void process()
    {
        System.out.println();
        System.out.println();
        System.out.println("Database Patcher");

        refresh();

        KmList<String> args = _arguments;
        int n = args.size();

        if ( n == 0 )
        {
            menu();
            return;
        }

        String cmd = args.getFirst();

        if ( cmd.equals("sync") )
        {
            sync();
            return;
        }

        if ( cmd.equals("test") )
        {
            test();
            return;
        }

        if ( cmd.equals("upgradeAll") )
        {
            upgradeAll();
            return;
        }

        if ( cmd.equals("upgrade") )
        {
            if ( n != 2 )
            {
                System.out.println("Command 'upgrade' requires a single argument.");
                return;
            }
            upgrade(args.get(1));
            return;
        }

        if ( cmd.equals("downgradeAll") )
        {
            downgradeAll();
            return;
        }

        if ( cmd.equals("downgrade") )
        {
            if ( n != 2 )
            {
                System.out.println("Command 'downgrade' requires a single argument.");
                return;
            }
            downgrade(args.get(1));
            return;
        }

        if ( cmd.equals("repeat") )
        {
            if ( n == 2 )
                repeat(args.get(1));
            else
                repeatLast();
            return;
        }

        if ( cmd.equals("repeatLast") )
        {
            repeatLast();
            return;
        }

        if ( cmd.equals("rerepeatLast") )
        {
            rerepeatLast();
            return;
        }

        if ( cmd.equals("create") )
        {
            create();
            return;
        }

        if ( cmd.equals("menu") )
        {
            menu();
            return;
        }

        if ( cmd.equals("help") )
        {
            printUsage();
            return;
        }

        System.out.println("Unknown command: " + cmd);
    }

    //##################################################
    //# commands
    //##################################################

    private void refresh()
    {
        _manager.refresh();
    }

    private void sync()
    {
        _manager.sync();
    }

    private void test()
    {
        _manager.test();
    }

    private void upgradeAll()
    {
        _manager.upgradeAll();
    }

    private void upgrade(String name)
    {
        _manager.upgrade(name);
    }

    private void downgradeAll()
    {
        _manager.downgradeAll();
    }

    private void downgrade(String name)
    {
        _manager.downgrade(name);
    }

    private void repeat(String name)
    {
        _manager.repeat(name);
    }

    private void repeatLast()
    {
        _manager.repeatLast();
    }

    private void rerepeatLast()
    {
        _manager.rerepeatLast();
    }

    private void create()
    {
        _manager.create();
    }

    private void menu()
    {
        while ( true )
        {
            System.out.println();
            System.out.print("(C)reate");
            System.out.print(" (S)ync");
            System.out.print(" (R)epeat");
            System.out.print(" (U)pgrade");
            System.out.print(" (D)owngrade");
            System.out.print(" (H)elp");
            System.out.print(" (Q)uit");

            String s = KmConsoleInput.readString(": ");
            System.out.println();

            refresh();

            if ( s == null )
                continue;

            s = s.toUpperCase().trim();
            if ( s.length() == 0 )
                continue;

            if ( s.equals("C") )
            {
                create();
                continue;
            }

            if ( s.equals("S") )
            {
                sync();
                continue;
            }

            if ( s.equals("T") )
            {
                test();
                continue;
            }

            if ( s.equals("R") )
            {
                repeatLast();
                continue;
            }

            if ( s.equals("U") )
            {
                upgradeAll();
                continue;
            }

            if ( s.equals("D") )
            {
                downgradeAll();
                continue;
            }

            if ( s.equals("H") )
            {
                printUsage();
                continue;
            }

            if ( s.equals("Q") )
                break;

            System.out.println("Unknown command.");
        }
    }
}
