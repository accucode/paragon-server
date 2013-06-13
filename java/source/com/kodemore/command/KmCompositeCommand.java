package com.kodemore.command;

import com.kodemore.collection.KmList;

public class KmCompositeCommand
    extends KmCommand
{
    //##################################################
    //# variables
    //##################################################

    private KmList<KmCommand> _list;

    //##################################################
    //# constructor
    //##################################################

    public KmCompositeCommand()
    {
        _list = new KmList<KmCommand>();
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
    public void run()
    {
        for ( KmCommand e : _list )
            e.run();
    }
}
