package com.kodemore.command;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

public class KmDaoCompositeCommand
    extends KmDaoCommand
{
    //##################################################
    //# variables
    //##################################################

    private KmList<KmCommand> _list;

    //##################################################
    //# constructor
    //##################################################

    public KmDaoCompositeCommand()
    {
        _list = new KmList<>();
    }

    //##################################################
    //# accessing
    //##################################################

    public void add(KmCommand e)
    {
        _list.add(e);
    }

    //##################################################
    //# run
    //##################################################

    @Override
    public void handle()
    {
        for ( KmCommand e : _list )
            e.run();
    }

    //##################################################
    //# lock
    //##################################################

    @Override
    public String getLockKey()
    {
        KmList<KmDaoCommand> cmds = getLockCommands();
        if ( cmds.isEmpty() )
            return null;

        KmList<String> locks = new KmList<>();
        for ( KmDaoCommand e : cmds )
            locks.addDistinct(e.getLockKey());

        if ( locks.isSingleton() )
            return locks.getFirst();

        throw Kmu.newFatal(
            "Command(%s) requires conflicting locks(%s).",
            getSimpleClassName(),
            locks.format());
    }

    @Override
    public int getLockTimeoutSeconds()
    {
        KmList<KmDaoCommand> v = getLockCommands();
        if ( v.isEmpty() )
            return 0;

        int i = v.getFirst().getLockTimeoutSeconds();

        for ( KmDaoCommand e : v )
            i = Math.min(i, e.getLockTimeoutSeconds());

        return i;
    }

    @Override
    public int getLockRetryCount()
    {
        KmList<KmDaoCommand> v = getLockCommands();
        if ( v.isEmpty() )
            return 0;

        int i = v.getFirst().getLockRetryCount();
        for ( KmDaoCommand e : v )
            i = Math.min(i, e.getLockRetryCount());

        return i;
    }

    @Override
    public int getLockRetryDelayMs()
    {
        KmList<KmDaoCommand> v = getLockCommands();
        if ( v.isEmpty() )
            return 0;

        int i = v.getFirst().getLockRetryDelayMs();
        for ( KmDaoCommand e : v )
            i = Math.min(i, e.getLockRetryDelayMs());

        return i;
    }

    //##################################################
    //# support
    //##################################################

    public KmList<KmDaoCommand> getDaoCommands()
    {
        KmList<KmDaoCommand> v = new KmList<>();
        for ( KmCommand e : _list )
            if ( e instanceof KmDaoCommand )
                v.add((KmDaoCommand)e);

        return v;
    }

    public KmList<KmDaoCommand> getLockCommands()
    {
        KmList<KmDaoCommand> v = new KmList<>();
        for ( KmDaoCommand e : getDaoCommands() )
            if ( e.requiresLock() )
                v.add(e);

        return v;
    }
}
