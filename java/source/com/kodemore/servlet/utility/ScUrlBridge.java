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

package com.kodemore.servlet.utility;

public abstract class ScUrlBridge
{
    //##################################################
    //# install
    //##################################################

    private static ScUrlBridge _instance;

    protected static void install(ScUrlBridge e)
    {
        if ( _instance != null )
            throw new RuntimeException("Already installed.");

        _instance = e;
    }

    public static ScUrlBridge getInstance()
    {
        if ( _instance == null )
            throw new RuntimeException("Not installed.");

        return _instance;
    }

    //##################################################
    //# general
    //##################################################

    /**
     * Typically the same as the servlet context, with a preceeding slash
     * to use absolute pathing.  If the preceeding slash is omitted, then
     * paths will be relative instead of absolute.
     */
    public abstract String getWeb(String... path);

    /**
     * Get application specific files that are shared across all themes.
     */
    public abstract String getCommon(String... path);

    /**
     * Get application specific files for the current ui theme.
     */
    public abstract String getTheme(String... path);

    //##################################################
    //# css
    //##################################################

    public abstract String getResetCss();

    public abstract String getThemeCss();

    public abstract String getCkEditorOverridesCss();

    //##################################################
    //# download
    //##################################################

    public abstract String createDownloadFor(String name, byte[] value);

    //##################################################
    //# icons
    //##################################################

    public abstract String getErrorUrl();

    public abstract String getWarnUrl();

    //##################################################
    //# buttons
    //##################################################

    public abstract String getHelpTriangleUrl();

    public abstract String getBarcodeButtonUrl();

    public abstract String getMenuBlackIcon();

    public abstract String getMenuWhiteIcon();
}
