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

package com.kodemore.servlet.control;

import java.util.function.Function;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.meta.KmMetaStringProperty;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.script.ScSimpleBlockScript;
import com.kodemore.utility.Kmu;

/**
 * I display a link and a separate popout button for use in grids.
 *
 * @deprecated This class is deprecated.
 * Clients should usually create a domain specific subclass popout column.
 * For an example, see MySiteColumn.
 */
@Deprecated
public class ScPopoutLinkControl<T>
    extends ScControl
{
    //##################################################
    //# variables
    //##################################################

    private ScTransientContainer _transientContainer;

    private Function<T,Object> _linkTextFunction;
    private ScAction           _linkAction;
    private Function<T,Object> _linkArgumentFunction;

    private Function<T,Object> _popoutUrlFunction;

    //##################################################
    //# constructors
    //##################################################

    public ScPopoutLinkControl()
    {
        _transientContainer = new ScTransientContainer();
    }

    //##################################################
    //# link text function
    //##################################################

    public Function<T,Object> getLinkTextFunction()
    {
        return _linkTextFunction;
    }

    public void setLinkTextFunction(Function<T,Object> e)
    {
        _linkTextFunction = e;
    }

    public void setLinkTextProperty(KmMetaStringProperty<T> prop)
    {
        setLinkTextFunction(prop.toObjectFunction());
    }

    public void setLinkText(String s)
    {
        setLinkTextFunction(Kmu.toFunction(s));
    }

    //##################################################
    //# link action
    //##################################################

    public ScAction getLinkAction()
    {
        return _linkAction;
    }

    public void setLinkAction(ScAction e)
    {
        _linkAction = e;
    }

    //##################################################
    //# link argument function
    //##################################################

    public Function<T,Object> getLinkArgumentFunction()
    {
        return _linkArgumentFunction;
    }

    public void setLinkArgumentFunction(Function<T,Object> fn)
    {
        _linkArgumentFunction = fn;
    }

    public void setLinkArgumentProperty(KmMetaStringProperty<T> p)
    {
        setLinkArgumentFunction(p.toObjectFunction());
    }

    //##################################################
    //# popout url function
    //##################################################

    public Function<T,Object> getPopoutUrlFunction()
    {
        return _popoutUrlFunction;
    }

    public void setPopoutUrlFunction(Function<T,Object> fn)
    {
        _popoutUrlFunction = fn;
    }

    public void setPopoutUrlProperty(KmMetaStringProperty<T> p)
    {
        setPopoutUrlFunction(p.toObjectFunction());
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        _transientContainer.clear();
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        T model = (T)getModel();

        ScSpan span;
        span = _transientContainer.addSpan();
        span.css().flexRow().flexChildCrossOverrideCenter().rowSpacer5();
        span.add(createPopoutButtonFor(model));
        span.add(createLinkFor(model));

        _transientContainer.renderControlOn(out);
    }

    private ScControl createPopoutButtonFor(T model)
    {
        String url = (String)getPopoutUrlFunction().apply(model);

        ScBlockScript js;
        js = ScSimpleBlockScript.create();
        js.openWindowUrl(url);

        ScScriptButton e;
        e = new ScScriptButton();
        e.setFlavorSmallIcon();
        e.setIcon().nameOpenInNew();
        e.setScript(js);
        return e;
    }

    private ScControl createLinkFor(T model)
    {
        String text = (String)getLinkTextFunction().apply(model);
        ScAction action = getLinkAction();
        String argument = (String)getLinkArgumentFunction().apply(model);

        ScLink e;
        e = new ScLink();
        e.setText(text);
        e.setAction(action, argument);
        return e;
    }
}
