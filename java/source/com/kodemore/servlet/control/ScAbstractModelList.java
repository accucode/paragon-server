/*
  Copyright (c) 2005-2016 www.kodemore.com

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

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.field.ScHtmlId;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.utility.ScJquery;
import com.kodemore.servlet.variable.ScLocalList;
import com.kodemore.utility.Kmu;

/**
 * I am a container that displays an element for each model in the list.
 * For example, I may be used to display a list of Dogs.  I provide an
 * alternative to the ScRepeater, and provide a more ajax friendly approach.
 *
 * Rather than defining a static structure and applying the model to it,
 * a dynamic structure is created for each model.  Clients can easily create
 * different views for each model in the list.
 *
 * Clients are responsible for defining a unique key for each model, typically
 * the model's primary key (uid).  This allows ajax methods to dynamically update
 * the view - adding, removing, and replacing individual list elements as needed.
 *
 * NOTE: because my children are dynamically drawn, I am generally NOT suited
 * for data entry.  I should instead be used for read only views.  However,
 * action triggers such as links and buttons are fine.
 *
 * Additionally, I am intended for relatively short lists.  All models in the list
 * are passed to the browser and added to the DOM.  If there are one million elements,
 * we will attempt to display all one million elements at once.  Not good.  The practical
 * limits will vary widely depending on the specific browser, network speed, and other
 * factors.  The complexity of the individual UI elements is a significant factor.  That
 * said, this control is generally fine for 100s of elements, and perhaps even 1000s.
 */
public abstract class ScAbstractModelList<T>
    extends ScElement
{
    //##################################################
    //# variables
    //##################################################

    /**
     * I am used to get each model's key.
     *
     * This is optional.  However, if not specified, then many of the
     * ajax methods will not be able to dynamically update the view.
     *
     * Usually, the keyAdapter is simply configured to return each
     * model's primary key (as a string).  However, if a given model
     * may appear multiple times in the same list, then an artificial
     * key must be returned to uniquely identifies each element.
     */
    private Function<T,String> _keyFunction;

    /**
     * The list of values (models) to be displayed in the list.
     * If empty, the container will still be rendered, thus allowing
     * for subsequent dynamic updates via ajax.
     */
    private ScLocalList<T>     _values;

    //##################################################
    //# constructor
    //##################################################

    public ScAbstractModelList()
    {
        _values = new ScLocalList<>();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmList<T> getValues()
    {
        return _values.getValue();
    }

    public void setValues(KmList<T> v)
    {
        _values.setValue(v);
    }

    public void clearValues()
    {
        setValues(KmList.createEmpty());
    }

    //==================================================
    //= accessing :: key adapter
    //==================================================

    public Function<T,String> getKeyFunction()
    {
        return _keyFunction;
    }

    public void setKeyFunction(Function<T,String> e)
    {
        _keyFunction = e;
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

        renderItemsOn(out);

        out.endDiv();
    }

    @Override
    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        super.renderAttributesOn(out);
    }

    private void renderItemsOn(KmHtmlBuilder out)
    {
        KmList<T> v = getValues();
        for ( T e : v )
            renderItemOn(out, e);
    }

    private KmHtmlBuilder renderItem(T value, boolean visible)
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();

        renderItemOn(out, value, visible);

        return out;
    }

    private void renderItemOn(KmHtmlBuilder out, T value)
    {
        renderItemOn(out, value, true);
    }

    private void renderItemOn(KmHtmlBuilder out, T value, boolean visible)
    {
        ScDiv box;
        box = composeItemBoxFor(value, visible);
        box.renderOn(out);
    }

    protected ScDiv composeItemBoxFor(T value)
    {
        return composeItemBoxFor(value, true);
    }

    protected ScDiv composeItemBoxFor(T value, boolean visible)
    {
        ScDiv root = createBoxFor(value);

        if ( !visible )
            root.style().hide();

        composeItemOn(root, value);

        return root;
    }

    protected abstract void composeItemOn(ScDiv root, T value);

    //##################################################
    //# ajax
    //##################################################

    public void ajaxSetValues(KmList<T> values)
    {
        ajaxRemoveAll();
        ajaxAddAll(values);
    }

    public void ajaxAddAll(KmList<T> values)
    {
        KmHtmlBuilder out = new KmHtmlBuilder();

        for ( T e : values )
            renderItemOn(out, e);

        ScHtmlIdAjax ajax;
        ajax = _htmlIdAjax();
        ajax.appendContents(out);
        ajax.run(out.getPostDom());
        ajax.run(out.getPostRender());
    }

    public void ajaxRemoveAll()
    {
        _htmlIdAjax().clearContents();
    }

    public void ajaxRemoveValue(T value)
    {
        ScHtmlIdAjax ajax;
        ajax = ajaxFor(value);
        ajax.hide().slide();
        ajax.whenDone().remove();
    }

    public void ajaxAppendValue(T value)
    {
        KmHtmlBuilder out = renderItem(value, false);
        String html = out.formatHtml();
        ScBlockScript postDom = out.getPostDom();
        ScBlockScript postRender = out.getPostRender();

        ScHtmlIdAjax listAjax;
        listAjax = _htmlIdAjax();
        listAjax.appendContents(html);
        listAjax.run(postDom);

        ScHtmlIdAjax valueAjax;
        valueAjax = ajaxFor(value);
        valueAjax.show().slide();
        valueAjax.whenDone().run(postRender);
    }

    public void ajaxPrependValue(T value)
    {
        KmHtmlBuilder out = renderItem(value, false);
        String html = out.formatHtml();

        ScHtmlIdAjax listAjax;
        listAjax = _htmlIdAjax();
        listAjax.prependContents(html);
        listAjax.run(out.getPostDom());

        ScHtmlIdAjax valueAjax;
        valueAjax = ajaxFor(value);
        valueAjax.show().slide();
        valueAjax.whenDone().run(out.getPostRender());
    }

    /**
     * Insert the value, after the EXISTING prev value.
     */
    public void ajaxInsertAfter(T value, T prev)
    {
        KmHtmlBuilder out = renderItem(value, false);
        String html = out.formatHtml();

        ScHtmlIdAjax ajax;
        ajax = ajaxFor(prev);
        ajax.insertContentsAfter(html);
        ajax.run(out.getPostDom());

        ScHtmlIdAjax valueAjax;
        valueAjax = ajaxFor(value);
        valueAjax.show().slide();
        valueAjax.whenDone().run(out.getPostRender());
    }

    public void ajaxRefreshAll(KmList<T> values)
    {
        for ( T e : values )
            ajaxRefresh(e);
    }

    public void ajaxRefresh(T value)
    {
        ScDiv box;
        box = composeItemBoxFor(value);
        box.ajaxReplace();
    }

    //##################################################
    //# support
    //##################################################

    private ScDiv createBoxFor(T value)
    {
        ScDiv root;
        root = new ScDiv();
        root.setHtmlId(getHtmlIdFor(value));
        return root;
    }

    protected String getSelectorFor(T value)
    {
        String id = _getHtmlIdFor(value);
        return ScJquery.formatIdSelector(id);
    }

    protected ScHtmlId getHtmlIdFor(T value)
    {
        String id = _getHtmlIdFor(value);
        return new ScHtmlId(id, getRootScript());
    }

    private String _getHtmlIdFor(T value)
    {
        String parentId = getHtmlId();
        String modelKey = getKeyFor(value);
        String id = parentId + "-" + modelKey;
        return id;
    }

    protected ScHtmlIdAjax ajaxFor(T value)
    {
        return getHtmlIdFor(value)._htmlIdAjax();
    }

    protected String getKeyFor(T value)
    {
        return Kmu.applySafe(getKeyFunction(), value);
    }
}
