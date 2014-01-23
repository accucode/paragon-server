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
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.utility.ScJquery;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalCss;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.servlet.variable.ScLocalStyle;
import com.kodemore.utility.Kmu;

/**
 * I am a 'group box' container with three predefined areas: header, body, footer.
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
 *      than a standard background color.  Children that are added directly to the group
 *      are delegated to the body.  E.g.: the following are equivalent...
 *
 *          aGroup.getBody().addDiv();
 *          aGroup.addDiv();
 * 
 *      Footer:
 *      The footer is displayed at the bottom, but is hidden by default.  The footer is 
 *      always rendered in the html content, even when it is hidden.
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
 *      Static:
 *      The default "static" layout render the group as a normally positioned block element.
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
    extends ScContainer
    implements ScHtmlIdIF
{
    //##################################################
    //# constants
    //##################################################

    private static final String PREFIX         = KmCssDefaultConstantsIF.oldGroup_prefix;

    private static final String PART_WRAPPER   = KmCssDefaultConstantsIF.oldGroup_part_wrapper;
    private static final String PART_HEADER    = KmCssDefaultConstantsIF.oldGroup_part_header;
    private static final String PART_TITLE     = KmCssDefaultConstantsIF.oldGroup_part_title;

    private static final String PART_DIVIDER   = KmCssDefaultConstantsIF.oldGroup_part_divider;

    private static final String FLAVOR_DEFAULT = KmCssDefaultConstantsIF.oldGroup_flavor_default;
    private static final String FLAVOR_ERROR   = KmCssDefaultConstantsIF.oldGroup_flavor_error;

    //##################################################
    //# variables
    //##################################################

    /**
     * The htmlId used for the table that wraps this control.
     */
    private ScLocalString       _htmlId;

    /**
     * Groups support several common flavors for both simplicity and
     * consistency.  The available flavors are defined in constants
     * above.
     */
    private ScLocalString       _flavor;

    /**
     * This style is applied to the outer wrapper.  Clients typically use
     * this to adjust layout attributes such as margins and size.  Attempting
     * to use this to modify the flavor will have unpredicable results based
     * on the css classes defined in the theme.css files.
     */
    private ScLocalCss          _css;

    /**
     * This style is applied to the outer wrapper.  Clients typically use
     * this to adjust layout attributes such as margins and size.  Attemping
     * to use this to modify the flavor will have unpredicable results based
     * on the css classes defined in the theme.css files.
     */
    private ScLocalStyle        _style;

    /**
     * The controls in these containers are added to the corresponding
     * sections of the group.  Note that the containers are not intended
     * to be changed. 
     */
    private ScBox               _header;

    /**
     * The divider between the header and the body.
     */
    private ScDiv               _divider;

    /**
     * The body.  Any children added to the group are actually 
     * delegated to the body.  The body itself does not provide
     * any styling or structure.
     */
    private ScSimpleContainer   _body;

    /**
     * Determine if I should act as the block root for ajax requests.
     * See ScControl.findBlockWrapper().  True by default.
     */
    private ScLocalBoolean      _blockWrapper;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _htmlId = new ScLocalString(getKey());

        _flavor = new ScLocalString();
        setFlavorDefault();

        _css = new ScLocalCss();
        _style = new ScLocalStyle();

        _header = new ScBox();
        _header.setParent(this);

        _divider = new ScDiv();
        _divider.setParent(this);

        _body = new ScSimpleContainer();
        _body.setParent(this);

        _blockWrapper = new ScLocalBoolean(true);
    }

    //##################################################
    //# html id
    //##################################################

    @Override
    public String getHtmlId()
    {
        return _htmlId.getValue();
    }

    public void setHtmlId(String e)
    {
        _htmlId.setValue(e);
    }

    @Override
    public String getJquerySelector()
    {
        return ScJquery.formatSelector(this);
    }

    @Override
    public String getJqueryReference()
    {
        return ScJquery.formatReference(this);
    }

    @Override
    public ScHtmlIdAjax ajax()
    {
        return new ScHtmlIdAjax(getRootScript(), this);
    }

    //##################################################
    //# flavor
    //##################################################

    public String getFlavor()
    {
        return _flavor.getValue();
    }

    public void setFlavor(String e)
    {
        _flavor.setValue(e);
    }

    public void setFlavorDefault()
    {
        setFlavor(FLAVOR_DEFAULT);
    }

    public void setFlavorError()
    {
        setFlavor(FLAVOR_ERROR);
    }

    //##################################################
    //# css
    //##################################################

    public String getCss()
    {
        return _css.getValue();
    }

    public void setCss(String e)
    {
        _css.setValue(e);
    }

    public KmCssDefaultBuilder css()
    {
        return _css.toBuilder();
    }

    private KmCssDefaultBuilder formatCss()
    {
        KmCssDefaultBuilder css;
        css = css().getCopy();
        css.add(PREFIX);
        css.add(PREFIX, PART_WRAPPER, getFlavor());
        css.clearfix();
        return css;
    }

    //##################################################
    //# style
    //##################################################

    public String getStyle()
    {
        return _style.getValue();
    }

    public void setStyle(String e)
    {
        _style.setValue(e);
    }

    public KmStyleBuilder style()
    {
        return _style.toBuilder();
    }

    private KmStyleBuilder formatStyle()
    {
        return style();
    }

    //##################################################
    //# body
    //##################################################

    public ScSimpleContainer getBody()
    {
        return _body;
    }

    @Override
    public <T extends ScControl> T add(T e)
    {
        return getBody().add(e);
    }

    @Override
    public boolean isEmpty()
    {
        return getBody().isEmpty();
    }

    @Override
    public void clear()
    {
        getBody().clear();
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
    //# convenience
    //##################################################

    @Override
    public ScDivider addDivider()
    {
        ScDivider e;
        e = super.addDivider();
        e.innerCss().clear().add(PREFIX, PART_DIVIDER, getFlavor());
        return e;
    }

    //##################################################
    //# header
    //##################################################

    public ScBox getHeader()
    {
        return _header;
    }

    /**
     * Replace header contents (if any) with a standard title.
     * This will automatically apply a default style for the text
     * based on the current flavor.
     */
    public ScText setTitle(String msg, Object... args)
    {
        String s = Kmu.format(msg, args);

        ScContainer header;
        header = getHeader();
        header.clear();

        ScDiv div;
        div = header.addDiv();
        div.css().floatLeft().add(PREFIX, PART_TITLE, getFlavor());

        return div.addText(s);
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
        div.css().floatLeft().add(PREFIX, PART_TITLE, getFlavor());

        ScGroupIconHeader iconHeader = new ScGroupIconHeader();
        iconHeader.setImageSource(iconSource);
        iconHeader.setText(s);

        return div.add(iconHeader);
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

        i.add(getHeader());
        i.add(getBody());

        return i;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.openDiv();
        out.printAttribute("id", getHtmlId());
        out.printAttribute(formatCss());
        out.printAttribute(formatStyle());
        out.close();

        renderHeaderOn(out);
        renderDividerOn(out);
        renderBodyOn(out);

        out.endDiv();
    }

    private void renderHeaderOn(KmHtmlBuilder out)
    {
        ScDiv div;
        div = _header;
        div.css().add(PREFIX, PART_HEADER, getFlavor());
        div.renderOn(out);
    }

    private void renderDividerOn(KmHtmlBuilder out)
    {
        ScDiv div;
        div = _divider;
        div.css().add(PREFIX, PART_DIVIDER, getFlavor());
        div.renderOn(out);
    }

    private void renderBodyOn(KmHtmlBuilder out)
    {
        _body.renderOn(out);
    }
}
