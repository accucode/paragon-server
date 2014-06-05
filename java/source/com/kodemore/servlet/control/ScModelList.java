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

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.meta.KmMetaAttribute;
import com.kodemore.servlet.field.ScHtmlId;
import com.kodemore.servlet.script.ScHtmlIdAjax;
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
 * the model's primary key.  This allows ajax methods to dynamically update
 * the view - adding, removing, and replacing individual list elements as needed.
 * 
 * NOTE: because my children are dynamically drawn, I am generally NOT suited
 * for data entry.  I should instead be used for read only views.  However,
 * action triggers such as links and buttons are fine.
 */
public class ScModelList<T>
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
     * may appear multiple times in the same list, then a key that 
     * uniquely identifies each element is needed.
     */
    private KmAdaptorIF<T,String> _keyAdapter;

    /**
     * I am responsible for rendering each model.
     * 
     * Although optional, clients will normally need to specify this 
     * in order to get something useful.  The default is to simply 
     * display the toString of each model.
     * 
     * The root is a transient object and may be safely manipulated by the client.
     * The client may add and remove child elements, and may also manipulate the
     * root's style as needed.  By default, the root has the default (box) style,
     * which means it has no visible border or background.
     * 
     * The root DOES have a specific htmlId already set, and clients should
     * NOT change this.  The htmlId is used to coordinate dynamic ajax changes
     * with the dynamic view.
     */
    private ScBoxRendererIF<T>    _renderer;

    /**
     * The list of values (models) to be displayed in the list.
     * If empty, the container will still be rendered, thus allowing
     * for subsequent dynamic updates via ajax. 
     */
    private ScLocalList<T>        _values;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _values = new ScLocalList<T>();
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

    //==================================================
    //= accessing :: key adapter
    //==================================================

    public KmAdaptorIF<T,String> getKeyAdapter()
    {
        return _keyAdapter;
    }

    public void setKeyAdapter(KmAdaptorIF<T,String> e)
    {
        _keyAdapter = e;
    }

    public void setKeyAdapter(KmMetaAttribute<T,String> e)
    {
        setKeyAdapter(e.getAdaptor());
    }

    //==================================================
    //= renderer
    //==================================================

    public ScBoxRendererIF<T> getRenderer()
    {
        return _renderer;
    }

    public void setRenderer(ScBoxRendererIF<T> e)
    {
        _renderer = e;
    }

    //##################################################
    //# components
    //##################################################

    @Override
    public Iterator<ScControl> getComponents()
    {
        // empty
        return super.getComponents();
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

        renderValuesOn(out);

        out.endDiv();
    }

    @Override
    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        super.renderAttributesOn(out);
    }

    private void renderValuesOn(KmHtmlBuilder out)
    {
        KmList<T> v = getValues();
        for ( T e : v )
            renderValueOn(out, e);
    }

    private KmHtmlBuilder renderValue(T value, boolean visible)
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();

        renderValueOn(out, value, visible);

        return out;
    }

    private void renderValueOn(KmHtmlBuilder out, T value)
    {
        renderValueOn(out, value, true);
    }

    private void renderValueOn(KmHtmlBuilder out, T value, boolean visible)
    {
        ScBox root;
        root = createBoxFor(value);
        root.show(visible);

        renderValueOn(root, value);

        root.renderOn(out);
    }

    private void renderValueOn(ScBox root, T value)
    {
        if ( _renderer == null )
            renderDefaultModelOn(root, value);
        else
            _renderer.renderOn(root, value);
    }

    private void renderDefaultModelOn(ScBox root, T value)
    {
        String s = Kmu.toDisplayString(value);

        root.css().border().pad();
        root.addText(s);
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxRemoveAll()
    {
        ajax().clearContents();
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
        KmHtmlBuilder out = renderValue(value, false);
        String html = out.formatHtml();

        ScHtmlIdAjax listAjax;
        listAjax = ajax();
        listAjax.appendContents(html);
        listAjax.run(out.getPostDom());

        ScHtmlIdAjax valueAjax;
        valueAjax = ajaxFor(value);
        valueAjax.show().slide();
        valueAjax.whenDone().glow();
        valueAjax.whenDone().run(out.getPostRender());
    }

    public void ajaxPrependValue(T value)
    {
        KmHtmlBuilder out = renderValue(value, false);
        String html = out.formatHtml();

        ScHtmlIdAjax listAjax;
        listAjax = ajax();
        listAjax.prependContents(html);
        listAjax.run(out.getPostDom());

        ScHtmlIdAjax valueAjax;
        valueAjax = ajaxFor(value);
        valueAjax.show().slide();
        valueAjax.whenDone().glow();
        valueAjax.whenDone().run(out.getPostRender());
    }

    //##################################################
    //# support
    //##################################################

    private ScBox createBoxFor(T value)
    {
        ScBox root;
        root = new ScBox();
        root.setHtmlId(getHtmlIdFor(value));
        return root;
    }

    public ScHtmlId getHtmlIdFor(T value)
    {
        String parentId = getHtmlId();
        String modelKey = getKeyFor(value);
        String id = parentId + "-" + modelKey;

        return new ScHtmlId(id, ajax());
    }

    public ScHtmlIdAjax ajaxFor(T value)
    {
        return getHtmlIdFor(value).ajax();
    }

    public String getKeyFor(T value)
    {
        KmAdaptorIF<T,String> a = getKeyAdapter();

        if ( a == null )
            return null;

        return a.getValue(value);
    }
}
