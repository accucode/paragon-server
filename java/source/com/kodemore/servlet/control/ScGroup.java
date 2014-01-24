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

import java.util.Iterator;

import com.kodemore.collection.KmCompositeIterator;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.utility.Kmu;

/**
 * I am a 'group box' container with three predefined areas: header, body, footer.
 * 
 * 
 * Sections:
 * 
 *      Header:
 *      The header is always displayed, and is typically just displays text in a standard
 *      style.  However, the header is a div and clients can add additional content
 *      (e.g.: a link or button) to the header is desired.
 * 
 *      Body:
 *      The body is always displayed, and typically does not have much styling other
 *      than a standard background color.  
 * 
 *      Footer:
 *      The footer is displayed at the bottom, but is hidden by default.  The footer is 
 *      always rendered in the html content, even when it is hidden.  If you want to display
 *      the footer, you should use one of the layout* methods rather than showing it directly.
 *      
 *      Wrapper:
 *      The wrapper is not really a section.  The wrapper is a single div that acts as the
 *      parent for the header, body, and footer.  Having a single parent allows us to apply
 *      styles such as borders, and drop shadows to the group in a consistent way.  Clients
 *      will generally not add or remove children to the wrapper directly.
 *      
 * 
 * Layouts:
 * 
 *      Groups are always organized in roughly the same layout, with the header at the top,
 *      the footer (if visible) at the bottom, and the body nominally filling the area in
 *      between.  However, depending on how you want to incorporate the group into you page
 *      you need to apply different layout strategies.  In particular, it is necessary to 
 *      specify the position in different ways depending on the effect desired.
 *      
 *      Normal:
 *      The default "normal" layout renders the group as a statically positioned block element.
 *          - all of the sections (and the wrapper) use the default style position:static.
 *          - the sections do not have a fixed size by default.
 *          - content added to the sections will cause those sections to grow vertically.
 *          - you may need to clearfix the sections manually, this is not done by default.
 *          - you may specify a fixed height for the body, header, or footer.
 *          - you should NOT specify a fixed height for the wrapper.
 *          
 *      Fixed:
 *      This layout is used to apply a fixed height to the group as a whole.  The header
 *      and footer (if displayed) have a fixed height, and the body fills the space between
 *      them.  
 *          - the wrapper uses position:relative.
 *          - the header, body, and footer use position:absolute.
 *          - css styles are used to ensure the sections fit together. 
 *          - you should specify a fixed height for the wrapper.
 *          - you should NOT specify an explicit height for the header, body, or footer.
 *
 *      Fill:
 *      The fill layout is similar to "fixed", but causes the group to completely fill its
 *      parent rather than using a fixed size.
 *          - the wrapper uses position:absolute.
 *          - the header, body, and footer use position:absolute.
 *          - the group's parent must have a non-static position.
 *          - css styles are used to ensure the sections fit together. 
 *          - you should NOT specify any explicit sizes.
 *          - you may override the wrapper position (left, top, etc) using the style attributes.
 */
public class ScGroup
    extends ScElement
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The wrapper around the header.  This is used to manage the layout
     * and is typically not accessed by the client directly.
     */
    private ScDiv          _headerWrapper;

    /**
     * The header section.  Clients may add content to this.  In many cases,
     * clients simply use the convenience method setTitle() to add auto-styled text. 
     */
    private ScDiv          _header;

    /**
     * The body section. 
     */
    private ScDiv          _body;

    /**
     * The wrapper around the footer.  This is use to manage the layout
     * and is typically not accessed by the client directly.
     */
    private ScDiv          _footerWrapper;

    /**
     * The footer section.  Clients may add content to this. 
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

        _headerWrapper = new ScDiv();
        _headerWrapper.setParent(this);
        _header = _headerWrapper.addDiv();
        _headerWrapper.addDiv().css().groupDivider();

        _body = new ScDiv();
        _body.setParent(this);

        _footerWrapper = new ScDiv();
        _footerWrapper.setParent(this);
        _footerWrapper.addDiv().css().groupDivider();
        _footer = _footerWrapper.addDiv();

        _blockWrapper = new ScLocalBoolean(true);

        layoutStatic();
    }

    //##################################################
    //# layout
    //##################################################

    public void layoutStatic()
    {
        _layoutReset();
        getFooterWrapper().hide();
    }

    public void layoutStaticWithFooter()
    {
        _layoutReset();
    }

    public void layoutFixed()
    {
        _layoutReset();

        css().groupWrapper_fixed();
        getHeaderWrapper().css().groupHeader_fixed();
        getBody().css().groupBody_fixedNoFooter();
        getFooterWrapper().hide();
    }

    public void layoutFixedWithFooter()
    {
        _layoutReset();

        css().groupWrapper_fixed();
        getHeaderWrapper().css().groupHeader_fixed();
        getBody().css().groupBody_fixedFooter();
        getFooterWrapper().css().groupFooter_fixed();
    }

    public void layoutFill()
    {
        _layoutReset();

        css().groupWrapper_fill();
        getHeaderWrapper().css().groupHeader_fixed();
        getBody().css().groupBody_fixedNoFooter();
        getFooterWrapper().hide();
    }

    public void layoutFillWithFooter()
    {
        _layoutReset();

        css().groupWrapper_fill();
        getHeaderWrapper().css().groupHeader_fixed();
        getBody().css().groupBody_fixedFooter();
        getFooterWrapper().css().groupFooter_fixed();
    }

    private void _layoutReset()
    {
        css().clear().group().groupWrapper().clearfix();
        getHeaderWrapper().css().clear().groupHeader();
        getFooterWrapper().css().clear().groupFooter();
        getBody().css().clear().groupBody();
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
    //# header
    //##################################################

    public ScDiv getHeader()
    {
        return _header;
    }

    private ScDiv getHeaderWrapper()
    {
        return _headerWrapper;
    }

    /**
     * Replace header contents (if any) with a standard title.
     * This will automatically apply a default style for the text
     * based on the current flavor.
     */
    public ScText setTitle(String msg, Object... args)
    {
        ScContainer header;
        header = getHeader();
        header.clear();

        ScDiv div;
        div = header.addDiv();
        div.css().groupTitle();

        return div.addText(msg, args);
    }

    /**
     * Replace header contents (if any) with a standard title.
     * This will automatically apply a default style for the text
     * based on the current flavor.
     */
    public ScGroupIconHeader setTitleWithIcon(String iconSource, String msg, Object... args)
    {
        String s = Kmu.format(msg, args);

        ScContainer header;
        header = getHeader();
        header.clear();

        ScDiv div;
        div = header.addDiv();
        div.css().groupTitle();

        ScGroupIconHeader iconHeader;
        iconHeader = new ScGroupIconHeader();
        iconHeader.setImageSource(iconSource);
        iconHeader.setText(s);

        return div.add(iconHeader);
    }

    //##################################################
    //# body
    //##################################################

    public ScDiv getBody()
    {
        return _body;
    }

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

    public ScDiv getFooterWrapper()
    {
        return _footerWrapper;
    }

    //##################################################
    //# components
    //##################################################

    @Override
    public Iterator<ScControl> getComponents()
    {
        KmCompositeIterator<ScControl> i;
        i = new KmCompositeIterator<ScControl>();
        i.addAll(super.getComponents());

        i.add(getHeaderWrapper());
        i.add(getBody());
        i.add(getFooterWrapper());

        return i;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.openDiv();
        renderAttributesOn(out);
        out.close();

        out.render(getHeaderWrapper());
        out.render(getBody());
        out.render(getFooterWrapper());

        out.endDiv();
    }
}
