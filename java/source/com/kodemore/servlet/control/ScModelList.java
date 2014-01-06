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

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.utility.ScJquery;
import com.kodemore.servlet.variable.ScLocalList;

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
public abstract class ScModelList<T>
    extends ScElement
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The list of values (models) to be displayed in the list.
     */
    private ScLocalList<T> _values;

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
    //# values
    //##################################################

    public KmList<T> getValues()
    {
        return _values.getValue();
    }

    public void setValues(KmList<T> v)
    {
        _values.setValue(v);
    }

    //##################################################
    //# abstract
    //##################################################

    public abstract String getModelKeyFor(T value);

    /**
     * The root is a transient object and may be safely manipulated by the client.
     * The client may add and remove child elements, and may also manipulate the
     * root's style as needed.  By default, the root has the default (box) style,
     * which means it has no visible border or background.
     * 
     * NOTE: the root does have a specific htmlId already set, and clients should
     * not change this.  The htmlId is used to coordinate dynamic ajax changes
     * with the dynamic view.
     */
    public abstract void renderModelOn(ScBox root, T value);

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

    private void renderValueOn(KmHtmlBuilder out, T value)
    {
        ScBox root;
        root = new ScBox();
        root.setHtmlId(getHtmlIdFor(value));

        renderModelOn(root, value);
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxRemoveAll()
    {
        ajax().clearContents();
    }

    public void ajaxRemoveModel(T value)
    {
        String sel = getSelectorFor(value);

        ajax().hide(sel).slide();

        new ScHtmlIdAjax(delegate, target)
        getRootScript().get
    }

    //##################################################
    //# support
    //##################################################

    private String getHtmlIdFor(T value)
    {
        String parentId = getHtmlId();
        String modelKey = getModelKeyFor(value);

        return parentId + "-" + modelKey;
    }

    private String getSelectorFor(T value)
    {
        String htmlId = getHtmlIdFor(value);
        return ScJquery.formatIdSelector(htmlId);
    }
}
