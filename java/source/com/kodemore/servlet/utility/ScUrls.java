/*return
  Copyright (c) 2005-2014 www.kodemore.com

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

public class ScUrls
{
    //##################################################
    //# common
    //##################################################

    public static String getCommonScript(String file)
    {
        return getBridge().getCommon("script", file);
    }

    public static String getCommonImage(String file)
    {
        return getBridge().getCommon("image", file);
    }

    public static String getCommonCss(String file)
    {
        return getBridge().getCommon("css", file);
    }

    //##################################################
    //# theme
    //##################################################

    public static String getThemeImage(String file)
    {
        return getBridge().getTheme("image", file);
    }

    public static String getThemeCss(String file)
    {
        return getBridge().getTheme("css", file);
    }

    //##################################################
    //# third party
    //##################################################

    /**
     * The the path to an icon in the Glyphish library.
     */
    public static String getGlyphishIcon(String... path)
    {
        return getBridge().getGlyphishIcon(path);
    }

    /**
     * The the path to an icon in the LED-icons library.
     */
    public static String getLedIcon(String... path)
    {
        return getBridge().getLedIcon(path);
    }

    //##################################################
    //# convenience
    //##################################################

    public static String getBlankImage()
    {
        return getThemeImage("b.gif");
    }

    public static String getPrimaryButtonImage()
    {
        return getThemeImage("buttonPrimary.png");
    }

    public static String getPositiveButtonImage()
    {
        return getThemeImage("buttonPositive.png");
    }

    public static String getNegativeButtonImage()
    {
        return getThemeImage("buttonNegative.png");
    }

    //##################################################
    //# support
    //##################################################

    private static ScUrlBridge getBridge()
    {
        return ScUrlBridge.getInstance();
    }
}
