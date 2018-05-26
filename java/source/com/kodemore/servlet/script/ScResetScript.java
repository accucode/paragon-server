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

package com.kodemore.servlet.script;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.string.KmStringBuilder;

/**
 * Reset fields to their "old value".  This relies the extra 'data' attributes
 * that many of our custom fields encode into the dom.
 * E.g.: <input km-old-value='sample'>.
 *
 * You can specify either a source, or a target, but should usually not specify both.
 * If neither is specified, the reset will apply to the entire page.
 */
public class ScResetScript
    extends ScAbstractScript
{
    //##################################################
    //# variables
    //##################################################

    /**
     * If set, use the source to find the enclosing changeTrackingScope
     * which is then used as the target.  If no enclosing scope is
     * found reset the entire page.
     */
    private ScControl _source;

    /**
     * If set, use this as the target.  Is is only used when a button
     * on part part of the page is used to reset the content of a different
     * area on the page.
     */
    private ScHtmlIdIF _target;

    //##################################################
    //# constructor
    //##################################################

    public ScResetScript()
    {
        // none
    }

    //##################################################
    //# source
    //##################################################

    public ScControl getSource()
    {
        return _source;
    }

    public void setSource(ScControl e)
    {
        _source = e;
    }

    public boolean hasSource()
    {
        return _source != null;
    }

    //##################################################
    //# target
    //##################################################

    public ScHtmlIdIF getTarget()
    {
        return _target;
    }

    public void setTarget(ScHtmlIdIF e)
    {
        _target = e;
    }

    public boolean hasTarget()
    {
        return _target != null;
    }

    //##################################################
    //# format
    //##################################################

    @Override
    public void formatScriptOn(KmStringBuilder out)
    {
        ScHtmlIdIF target = getEffectiveTarget();

        if ( target == null )
            out.print("Kmu.resetDirtyFields();");
        else
            out.printf("Kmu.resetDirtyFields(%s);", json(target.getJquerySelector()));
    }

    private ScHtmlIdIF getEffectiveTarget()
    {
        if ( hasTarget() )
            return getTarget();

        if ( hasSource() )
            return getSource().findChangeTrackingScopeWrapper();

        return null;
    }
}
