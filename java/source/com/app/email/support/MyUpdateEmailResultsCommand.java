package com.app.email.support;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDaoCommand;
import com.kodemore.email.KmEmailResult;

import com.app.finder.MyEmailFinder;
import com.app.model.MyEmail;

public class MyUpdateEmailResultsCommand
    extends KmDaoCommand
{
    //##################################################
    //# variables
    //##################################################

    private KmList<KmEmailResult> _results;

    //##################################################
    //# constructor
    //##################################################

    public MyUpdateEmailResultsCommand()
    {
        _results = new KmList<KmEmailResult>();
    }

    //##################################################
    //# accessing (input)
    //##################################################

    public void setResults(KmList<KmEmailResult> e)
    {
        _results = e;
    }

    //##################################################
    //# run
    //##################################################

    @Override
    public void handle()
    {
        for ( KmEmailResult r : _results )
        {
            String uid = (String)r.getEmailKey();
            MyEmail email = MyEmailFinder.staticFind(uid);

            if ( r.isOk() )
                email.markSent();
            else
                email.markError(r.getErrorMessage());
        }
    }
}
