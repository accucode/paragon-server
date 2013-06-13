package com.app.ui.activity;

import com.kodemore.dao.KmDaoSession;
import com.kodemore.servlet.ScActivity;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoRegistry;
import com.app.file.MyFilePaths;
import com.app.model.MyServerSession;
import com.app.model.MySettings;
import com.app.model.MyUser;
import com.app.property.MyPropertyRegistry;
import com.app.ui.core.MyCookieSession;
import com.app.ui.core.MyPageSession;
import com.app.ui.core.MyServletData;
import com.app.ui.layout.MyPageLayout;
import com.app.utility.MyGlobals;

public abstract class MyActivity
    extends ScActivity
{
    //##################################################
    //# settings
    //##################################################

    public void defineRoles()
    {
        // none
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        String s;
        s = getShortClassName();
        s = Kmu.formatCamelCaseAsCapitalizedWords(s);
        return s;
    }

    @Override
    public String getNavigationHash()
    {
        String s;
        s = getShortClassName();
        s = Kmu.lowercaseFirstLetter(s);
        return s;
    }

    private String getShortClassName()
    {
        String s;
        s = getClass().getSimpleName();
        s = Kmu.removePrefix(s, "My");
        s = Kmu.removeSuffix(s, "Activity");
        s = Kmu.removeSuffix(s, "Page");
        return s;
    }

    //##################################################
    //# convenience
    //##################################################

    @Override
    protected MyServletData getData()
    {
        return MyGlobals.getData();
    }

    @Override
    protected MyPageSession getPageSession()
    {
        return MyGlobals.getPageSession();
    }

    protected MyServerSession getServerSession()
    {
        return MyGlobals.getServerSession();
    }

    protected MyCookieSession getCookieSession()
    {
        return MyGlobals.getCookieSession();
    }

    //##################################################
    //# user
    //##################################################

    public MyUser getCurrentUser()
    {
        MyServerSession ss = getServerSession();
        if ( ss == null )
            return null;

        return ss.getUser();
    }

    public String getCurrentUserUid()
    {
        MyUser u = getCurrentUser();
        if ( u == null )
            return null;

        return u.getUid();
    }

    public boolean hasCurrentUser()
    {
        return getCurrentUser() != null;
    }

    //##################################################
    //# action context 
    //##################################################

    @Override
    public void checkSecurity()
    {
        super.checkSecurity();

        if ( requiresUser() )
            if ( !getServerSession().hasUser() )
                throwUserAccessError();
    }

    protected void throwUserAccessError()
    {
        Kmu.accessError("User Access Security Error");
    }

    protected boolean requiresUser()
    {
        return true;
    }

    //##################################################
    //# ajax download
    //##################################################

    /**
     * Used to download files to the client browser.
     * This opens a new window to manage the download in order
     * to avoid disrupting the primary ajax application flow. 
     */

    /*
     * 
    protected void ajaxDownload(String name, CharSequence value)
    {
        ajaxDownload(name, value.toString().getBytes());
    }

    protected void ajaxDownload(String name, byte[] value)
    {
        MyUser user;
        user = getServerSession().getUser();

        MyDownload d;
        d = new MyDownload();
        d.setName(name);
        d.setUser(user);
        d.saveDao();

        d.getFile().write(value);

        String html;
        html = formatAjaxDownloadHtml(d);

        ajax().openWindowHtml(html);
    }

    private String formatAjaxDownloadHtml(MyDownload e)
    {
        String onload = Kmu.format("window.location='%s';", e.getUrl());

        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.printDocType401Strict();
        out.beginHtml();
        out.printTitle("Download");

        out.openBody();
        out.printAttribute("onload", onload);
        out.close();

        out.printHeader1("Downloading: " + e.getName());
        out.println("Your download will begin shortly...");

        out.open("button");
        out.printAttribute("onclick", "window.close();");
        out.close();
        out.print("Close");
        out.end("button");

        out.endBody();
        out.endHtml();

        return out.toString();
    }
     */

    //##################################################
    //# convenience
    //##################################################

    protected KmDate getTodayUtc()
    {
        return getNowUtc().getDate();
    }

    protected KmTimestamp getNowUtc()
    {
        return MyGlobals.getNowUtc();
    }

    protected MyPropertyRegistry getProperties()
    {
        return MyGlobals.getProperties();
    }

    protected MySettings getSettings()
    {
        return getAccess().getSettingsDao().getSettings();
    }

    protected KmDaoSession getDaoSession()
    {
        return MyGlobals.getDaoSession();
    }

    protected void flushDao()
    {
        getDaoSession().flush();
    }

    protected MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }

    //##################################################
    //# utility
    //##################################################

    protected void writeTempWebFile(String file, ScControl c)
    {
        String path = MyFilePaths.getWebPath(file);
        String html = c.render().formatHtml();

        Kmu.writeFile(path, html);
    }

    protected MyPageLayout getPageLayout()
    {
        return MyPageLayout.getInstance();
    }

}
