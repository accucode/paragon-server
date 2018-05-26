package com.app.ui.servlet;

import com.kodemore.command.KmDao;
import com.kodemore.file.KmFile;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.utility.KmResult;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoAccess;
import com.app.model.MyAttachment;
import com.app.model.MyDownload;
import com.app.model.MyServerSession;
import com.app.model.MyUser;
import com.app.model.base.MyDownloadType;
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
        KmDao.run(this::handleDao);
    }

    private void handleDao()
    {
        KmResult<MyDownload> result = findDownload();
        if ( result.hasError() )
        {
            writeError(result.getError());
            return;
        }

        download(result.getValue());
    }

    //##################################################
    //# find
    //##################################################

    private KmResult<MyDownload> findDownload()
    {
        MyServletData data = getData();

        MyServerSession ss = MyGlobals.getServerSession();
        if ( ss == null )
            return KmResult.createError("No Session");

        MyUser user = ss.getUser();
        if ( user == null )
            return KmResult.createError("No User");

        String uid = data.getExtraPath();
        if ( Kmu.isEmpty(uid) )
            return KmResult.createError("No Download");

        MyDaoAccess access = MyGlobals.getAccess();
        MyDownload e = access.findDownloadUid(uid);
        if ( e == null )
            return KmResult.createError("Invalid Download");

        if ( !e.hasUser(user) )
            return KmResult.createError("Invalid User");

        return KmResult.createValue(e);
    }

    //##################################################
    //# download
    //##################################################

    private void download(MyDownload e)
    {
        MyDownloadType type = e.getType();
        switch ( type )
        {
            case Attachment:
                downloadAttachment(e);
                break;

            case Bytes:
                downloadBytes(e);
                break;

            case File:
                downloadFile(e);
                break;
        }
    }

    private void downloadAttachment(MyDownload download)
    {
        MyAttachment attachment = download.getAttachment();
        if ( attachment == null )
        {
            writeError("No Attachment");
            return;
        }

        String name = download.getName();
        byte[] bytes = attachment.getContentBytes();
        writeBytes(name, bytes);
    }

    private void downloadBytes(MyDownload download)
    {
        byte[] bytes = download.getByteArray();
        if ( bytes == null )
        {
            writeError("No Bytes");
            return;
        }

        String name = download.getName();
        writeBytes(name, bytes);
    }

    private void downloadFile(MyDownload download)
    {
        KmFile file = download.getFile();
        if ( !file.exists() )
        {
            writeError("File Not Found");
            return;
        }

        String name = download.getName();
        byte[] bytes = file.readBytes();
        writeBytes(name, bytes);
    }

    //##################################################
    //# write
    //##################################################

    private void writeError(String msg)
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

    private void writeBytes(String name, byte[] bytes)
    {
        getData().setAttachmentResult(name, bytes);
    }
}
