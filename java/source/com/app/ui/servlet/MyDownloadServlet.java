package com.app.ui.servlet;

import com.kodemore.command.KmDaoCommand;
import com.kodemore.file.KmFile;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyDownload;
import com.app.model.MyServerSession;
import com.app.model.MyUser;
import com.app.ui.core.MyServletData;
import com.app.utility.MyGlobals;

/**
 * Handle requests for downloading files.  Files are assumed to
 * have been previously stored; this servlet should do nothing
 * more than verify the user, and download the preexisting file
 * as an http attachment.
 * 
 * POSTs are recommended, but GETs are also allowed. 
 */
public class MyDownloadServlet
    extends MyServlet
    implements MyServletConstantsIF
{
    //##################################################
    //# get / post
    //##################################################

    @Override
    protected void doGet()
    {
        handle();
    }

    @Override
    protected void doPost()
    {
        handle();
    }

    //##################################################
    //# handle
    //##################################################

    private void handle()
    {
        new KmDaoCommand()
        {
            @Override
            protected void handle()
            {
                handleDao();
            }
        }.run();
    }

    private void handleDao()
    {
        MyServletData data = getData();

        MyServerSession ss = MyGlobals.getServerSession();
        if ( ss == null )
        {
            handleError("No Session");
            return;
        }

        MyUser user = ss.getUser();
        if ( user == null )
        {
            handleError("No User.");
            return;
        }

        String uid = data.getExtraPath();
        if ( Kmu.isEmpty(uid) )
        {
            handleError("No Download");
            return;
        }

        MyDaoRegistry access = MyGlobals.getAccess();
        MyDownload d = access.findDownloadUid(uid);
        if ( d == null )
        {
            handleError("Unknown Download");
            return;
        }

        if ( !d.hasUser(user) )
        {
            handleError("Incorrect User");
            return;
        }

        KmFile file = d.getFile();
        if ( !file.exists() )
        {
            handleError("File Not Found");
            return;
        }

        String name = d.getName();
        byte[] bytes = file.readBytes();

        data.setAttachmentResult(name, bytes);
    }

    private void handleError(String msg)
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.printDocType();
        out.beginHtml();
        out.printTitle("Download Failed");
        out.beginBody();
        out.printHeader1("Download Failed");
        out.printHeader2(msg);
        out.endBody();
        out.endHtml();

        getData().setHtmlResult(out);
    }

}
