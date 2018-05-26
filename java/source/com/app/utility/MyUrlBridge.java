/*
  Copyright (c) 2005-2018 www.kodemore.com

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
*/

package com.app.utility;

import com.kodemore.servlet.utility.ScUrlBridge;
import com.kodemore.servlet.utility.ScUrls;
import com.kodemore.utility.KmConstantsIF;
import com.kodemore.utility.KmRandom;
import com.kodemore.utility.Kmu;

import com.app.model.MyDownload;
import com.app.model.MyServerSession;
import com.app.model.MyUser;
import com.app.property.MyProperties;
import com.app.ui.servlet.MyServletConstantsIF;

public class MyUrlBridge
    extends ScUrlBridge
    implements KmConstantsIF
{
    //##################################################
    //# install
    //##################################################

    public static void install()
    {
        install(new MyUrlBridge());
    }

    public static MyUrlBridge getInstance()
    {
        return (MyUrlBridge)ScUrlBridge.getInstance();
    }

    //##################################################
    //# variables
    //##################################################

    private String _developmentVersion;

    //##################################################
    //# constructor
    //##################################################

    private MyUrlBridge()
    {
        _developmentVersion = "dev-" + KmRandom.getInstance().getPositiveInteger();
    }

    //##################################################
    //# general
    //##################################################

    @Override
    public String getWeb(String... path)
    {
        // Assumes ROOT (implied) context
        return join("/", join(path));
    }

    @Override
    public String getCommon(String... path)
    {
        return getStatic("app/common", join(path));
    }

    @Override
    public String getTheme(String... path)
    {
        return getStatic("app/theme", MyServletConstantsIF.THEME_TOKEN, join(path));
    }

    public String getStatic(String... path)
    {
        return getWeb("static", getVersionFolder(), join(path));
    }

    //##################################################
    //# downloads
    //##################################################

    /**
     * Used to download files to the client browser.
     * The url returned is compatible with MyDownloadServlet.
     */
    @Override
    public String createDownloadFor(String name, byte[] value)
    {
        MyServerSession ss;
        ss = MyGlobals.getServerSession();

        MyUser user;
        user = ss.getUser();

        MyDownload d;
        d = new MyDownload();
        d.setName(name);
        d.setTypeBytes();
        d.setByteArray(value);
        d.setUser(user);
        d.daoAttach();

        return d.getUrl();
    }

    //##################################################
    //# version subfolder
    //##################################################

    /**
     * We use dynamically update the "version" subfolder
     * in the web resource path in order to manage browser
     * caching.
     */
    public String getVersionFolder()
    {
        MyProperties p = MyGlobals.getProperties();
        String mode = p.getWebResourceVersioning();

        if ( mode == null )
            return getStaticVersionFolder();

        if ( mode.equals("none") )
            return getStaticVersionFolder();

        if ( mode.equals("deploy") )
            return getDeployVersionFolder();

        if ( mode.equals("dev") )
            return getDevelopmentVersionFolder();

        return getStaticVersionFolder();
    }

    public String getStaticVersionFolder()
    {
        return "version";
    }

    private String getDeployVersionFolder()
    {
        String prefix = getStaticVersionFolder();
        String suffix = MyConstantsIF.APPLICATION_VERSION;

        return prefix + "-" + suffix;
    }

    private String getDevelopmentVersionFolder()
    {
        String prefix = getStaticVersionFolder();
        String suffix = _developmentVersion;

        return prefix + "-" + suffix;
    }

    //##################################################
    //# css
    //##################################################

    @Override
    public String getResetCss()
    {
        return getCommon("css/reset.css");
    }

    @Override
    public String getThemeCss()
    {
        return getTheme("css/theme.css");
    }

    @Override
    public String getCkEditorOverridesCss()
    {
        return getCommon("css/ckEditorOverrides.css");
    }

    //##################################################
    //# icons
    //##################################################

    @Override
    public String getErrorUrl()
    {
        return getTheme("image/error.png");
    }

    @Override
    public String getWarnUrl()
    {
        return getTheme("image/warn.png");
    }

    //##################################################
    //# buttons
    //##################################################

    @Override
    public String getHelpTriangleUrl()
    {
        return ScUrls.getThemeImage("helpTriangle.png");
    }

    @Override
    public String getBarcodeButtonUrl()
    {
        return MyButtonUrls.barcode();
    }

    @Override
    public String getMenuBlackIcon()
    {
        return MyButtonUrls.menuBlack();
    }

    @Override
    public String getMenuWhiteIcon()
    {
        return MyButtonUrls.menuWhite();
    }

    //##################################################
    //# support
    //##################################################

    private String join(String... path)
    {
        return Kmu.joinUrlPath(path);
    }
}
