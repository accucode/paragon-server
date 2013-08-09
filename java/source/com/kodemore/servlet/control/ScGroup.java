/*
  Copyright (c) 2005-2011 www.kodemore.com

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
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.servlet.variable.ScLocalStyle;
import com.kodemore.utility.Kmu;

/**
 * I am a 'group box' container that surrounds my contents with a
 * shaded/colored area.  I also display a title bar.
 */
public class ScGroup
    extends ScContainer
    implements ScHtmlIdIF
{
    //##################################################
    //# constants
    //##################################################

    private static final String PREFIX         = KmCssDefaultConstantsIF.group_prefix;

    private static final String PART_WRAPPER   = KmCssDefaultConstantsIF.group_part_wrapper;
    private static final String PART_HEADER    = KmCssDefaultConstantsIF.group_part_header;
    private static final String PART_TITLE     = KmCssDefaultConstantsIF.group_part_title;

    private static final String PART_DIVIDER   = KmCssDefaultConstantsIF.group_part_divider;

    private static final String FLAVOR_DEFAULT = KmCssDefaultConstantsIF.group_flavor_default;
    private static final String FLAVOR_ERROR   = KmCssDefaultConstantsIF.group_flavor_error;

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
    public String formatJquerySelector()
    {
        return ScJquery.formatSelector(this);
    }

    @Override
    public String formatJqueryReference()
    {
        return ScJquery.formatReference(this);
    }

    @Override
    public ScHtmlIdAjax ajax()
    {
        return new ScHtmlIdAjax(this);
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
        KmCssDefaultBuilder css;
        // review_aaron: added additional 'group' to class 
        //        css = newCssBuilder().add(PREFIX, PART_WRAPPER, getFlavor());
        css = newCssBuilder();
        css.add(PREFIX);
        css.add(PREFIX, PART_WRAPPER, getFlavor());
        // review_aaron: added clearfix to group, fix button box issue caused by Overflow: visible
        css.add(KmCssDefaultConstantsIF.clearfix);

        out.openDiv();
        out.printAttribute("id", getHtmlId());
        out.printAttribute(css);
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
