/*
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

package com.kodemore.servlet.control;

import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.utility.Kmu;

/**
 * Introduction
 *      I am a 'group box' container with predefined areas for: banner, header, body, footer.
 *      The banner typically displays a title.
 *      The header and footer provide standard sections for navigation and control.
 *      The body contains the content.
 *
 * Flexbox
 *     Groups currently rely on the 'flex' layout; the display:flex is applied to the container.
 *     By default, groups use the 'flex' layout and are displayed as 'block' elements.
 *     However, you can switch to inline layout by simply calling setInline() which will
 *     then use display:inline-flex instead.
 *
 * Styling
 *     The group and its sections have minimal styling.  Other than the flex layout itself,
 *     only the background colors and borders are specified, this includes things like rounded
 *     corners and a box shadow around the group.  Clients are responsible for adding any
 *     padding, fonts, and other styling to the contents.
 */
public class ScGroup
    extends ScDivWrapper
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The banner is always displayed, and typically just displays text in a standard
     * style.  However, the banner is a div and clients easily style it, or insert alternate
     * content such as an extra button (or link) on the right.  In simple cases, clients
     * should use the setBannerTitle() method to set a simple text title with default theming.
     */
    private ScDiv          _banner;

    /**
     * The header is optionally displayed between the banner and the body.  This provides
     * an area to display navigation/action control such as save/cancel.  The header and
     * footer are often configured to display the same content.  The header is hidden by
     * default.
     */
    private ScDiv          _header;

    /**
     * The body is always displayed, and is the only section that is intended to contain
     * scrollable content.  By default, the body will grow to accommodate its content.
     * However, if the group is given a fixed size, then the body will shrink to accommodate
     * the intended size.
     */
    private ScDiv          _body;

    /**
     * The footer is just like the header, but displayed after the body.  The footer is
     * hidden by default.
     */
    private ScDiv          _footer;

    /**
     * Determine if I should act as the block root for ajax requests.
     * See ScControl.findBlockWrapper().  True by default.
     */
    private ScLocalBoolean _blockWrapper;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        css().group();

        ScDiv root;
        root = getInner();

        _banner = root.addDiv();
        _banner.css().groupBanner();

        _header = root.addDiv();
        _header.css().groupHeader();
        _header.hide();

        _body = root.addDiv();
        _body.css().groupBody();

        _footer = root.addDiv();
        _footer.css().groupFooter();
        _footer.hide();

        _blockWrapper = new ScLocalBoolean(true);

        layoutBlock();
    }

    //##################################################
    //# layout
    //##################################################

    public void layoutBlock()
    {
        css().remove().groupInline();
        css().groupBlock();
    }

    public void layoutInline()
    {
        css().remove().groupBlock();
        css().groupInline();
    }

    //##################################################
    //# block wrapper
    //##################################################

    public boolean getBlockWrapper()
    {
        return _blockWrapper.getValue();
    }

    public void setBlockWrapper(boolean e)
    {
        _blockWrapper.setValue(e);
    }

    @Override
    public boolean isBlockWrapper()
    {
        return getBlockWrapper();
    }

    //##################################################
    //# banner
    //##################################################

    public ScDiv getBanner()
    {
        return _banner;
    }

    public KmCssDefaultBuilder bannerCss()
    {
        return getBanner().css();
    }

    public KmStyleBuilder bannerStyle()
    {
        return getBanner().style();
    }

    /**
     * Replace banner contents (if any) with a standard title.
     */
    public ScTextSpan setTitle(String msg, Object... args)
    {
        String s = Kmu.format(msg, args);

        ScContainer banner;
        banner = getBanner();
        banner.clear();

        ScTextSpan span;
        span = banner.addTextSpan(s);
        span.css().groupBannerTitle();
        return span;
    }

    /**
     * Replace banner contents (if any) with a standard title.
     * This will automatically apply a default style for the text
     * based on the current flavor.
     */
    public ScGroupBannerIcon setTitleWithIcon(String iconSource, String msg, Object... args)
    {
        String s = Kmu.format(msg, args);

        ScContainer banner;
        banner = getBanner();
        banner.clear();

        ScDiv div;
        div = banner.addDiv();
        div.css().groupBannerTitle();

        ScGroupBannerIcon icon;
        icon = new ScGroupBannerIcon();
        icon.setImageSource(iconSource);
        icon.setText(s);

        return div.add(icon);
    }

    //##################################################
    //# header
    //##################################################

    public ScDiv getHeader()
    {
        return _header;
    }

    public ScDiv showHeader()
    {
        ScDiv e;
        e = getHeader();
        e.show();
        return e;
    }

    public KmCssDefaultBuilder headerCss()
    {
        return getHeader().css();
    }

    public KmStyleBuilder headerStyle()
    {
        return getHeader().style();
    }

    //##################################################
    //# body
    //##################################################

    public ScDiv getBody()
    {
        return _body;
    }

    public KmCssDefaultBuilder bodyCss()
    {
        return getBody().css();
    }

    public KmStyleBuilder bodyStyle()
    {
        return getBody().style();
    }

    /**
     * Add an extra divider to the body, styled the same as the dividers between the
     * banner, header, body, and footer.
     */
    public void addBodyDivider()
    {
        getBody().addDiv().css().groupDivider();
    }

    //##################################################
    //# footer
    //##################################################

    public ScDiv getFooter()
    {
        return _footer;
    }

    public ScDiv showFooter()
    {
        ScDiv e;
        e = getFooter();
        e.show();
        return e;
    }

    public KmCssDefaultBuilder footerCss()
    {
        return getFooter().css();
    }

    public KmStyleBuilder footerStyle()
    {
        return getFooter().style();
    }

}
