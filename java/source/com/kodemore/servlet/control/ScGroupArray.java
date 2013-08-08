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
import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.servlet.variable.ScLocalStyle;

/**
 * I am a 'group box' container that surrounds my contents with a
 * shaded/colored area.  I also display a title bar.
 */
public class ScGroupArray
    extends ScControl
{
    //##################################################
    //# constants
    //##################################################

    private static final String FLAVOR_DEFAULT = KmCssDefaultConstantsIF.group_flavor_default;

    //##################################################
    //# variables
    //##################################################

    /**
     * The list of child groups.
     */
    private KmList<ScGroup>     _groups;

    /**
     * The flavor to apply to child groups.
     */
    private ScLocalString       _flavor;

    /**
     * The style to apply to child groups.
     */
    private ScLocalStyle        _style;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _groups = new KmList<ScGroup>();
        _flavor = new ScLocalString();
        _style = new ScLocalStyle();

        setFlavorDefault();
    }

    //##################################################
    //# groups
    //##################################################

    public KmList<ScGroup> getGroups()
    {
        return _groups;
    }

    public ScGroup addGroup()
    {
        ScGroup e;
        e = new ScGroup();
        e.setParent(this);

        applyDefaultsTo(e);

        _groups.add(e);

        return e;
    }

    public ScGroup addGroup(String title)
    {
        ScGroup e;
        e = addGroup();
        e.setTitle(title);
        return e;
    }

    //##################################################
    //# apply
    //##################################################

    public void reapplyDefaults()
    {
        KmList<ScGroup> v = _groups;
        for ( ScGroup e : v )
            applyDefaultsTo(e);
    }

    private void applyDefaultsTo(ScGroup e)
    {
        e.setFlavor(getFlavor());
        e.setStyle(getStyle());
    }

    //##################################################
    //# flavor
    //##################################################

    public String getFlavor()
    {
        return _flavor.getValue();
    }

    private void setFlavor(String e)
    {
        _flavor.setValue(e);
    }

    public void setFlavorDefault()
    {
        setFlavor(FLAVOR_DEFAULT);
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

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        for ( ScGroup e : _groups )
            out.render(e);
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
        i.addAll(getGroups());

        return i;
    }
}
