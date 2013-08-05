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

import com.kodemore.collection.KmEmptyIterator;
import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.json.KmJsonUtility;
import com.kodemore.servlet.ScModelApplicatorIF;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.action.ScActionContextIF;
import com.kodemore.servlet.encoder.ScDecoder;
import com.kodemore.servlet.encoder.ScEncoder;
import com.kodemore.servlet.field.ScAbstractTextField;
import com.kodemore.servlet.field.ScControlVisitorIF;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.field.ScStoppableControlVisitorIF;
import com.kodemore.servlet.script.ScScript;
import com.kodemore.servlet.utility.ScControlRegistry;
import com.kodemore.servlet.utility.ScFormatter;
import com.kodemore.servlet.utility.ScKeyIF;
import com.kodemore.servlet.utility.ScUrls;
import com.kodemore.servlet.variable.ScLocalObject;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

public abstract class ScControl
    implements ScControlIF, ScKeyIF, ScModelApplicatorIF
{
    //##################################################
    //# constants
    //##################################################

    protected static final Iterator<ScControl> EMPTY_CONTROLS = new KmEmptyIterator<ScControl>();

    //##################################################
    //# variables
    //##################################################

    /**
     * This key uniquely identifies the control within the application.
     * Keys are expected to remain consistent across applicatino restarts,
     * but NOT across different application versions.  Keys are typically
     * assigned automatically when the control is created.
     */
    private String                             _key;

    /**
     * Controls organized in a simple tree hierarchy.
     * However, the parent can be null for non-root elements, typically
     * when managing dynamic content.
     */
    private ScControl                          _parent;

    /**
     * The label attribute is strictly an application feature,
     * and does not correspond directly to any html attribute.
     * Various containers use their children's labels to more 
     * conveniently manage the layout.  Although all controls 
     * have the label attribute, the actual usage varies widely.
     */
    private ScLocalString                      _label;

    /**
     * Many controls support dynamic content based on the current
     * state of the model.  For instance this allows the client 
     * to apply a common model (e.g.: a Person) to an entire
     * subtree of controls, and have different children apply
     * that Person in different ways - one control may apply
     * the person's name.
     */
    private ScLocalObject                      _model;

    /**
     * The scripts to run after the dom has been updated.  
     * 
     * Note that these are scripts are not thread safe.  The
     * general assumption is that dynamic behavior will be handled
     * outside the configuration of the control.  That said,
     * the script can contains ScScriptIFs that will be evaluated
     * upon request.
     */
    private ScScript                           _postDomScript;

    //##################################################
    //# constructor
    //##################################################

    /**
     * Register the control with a default key, then
     * perform any default initialization. 
     */
    public ScControl()
    {
        register();
        install();
    }

    //##################################################
    //# initialize
    //##################################################

    /**
     * Bind this instance to a unique key and register this instance
     * with the ScControlRegistry.
     */
    private void register()
    {
        ScControlRegistry r = getRegistry();

        _key = r.getNextKey();
        r.register(this);
    }

    /**
     * Initialize is typically responsible for setting the initial
     * state of various intstance variables.  Any method calls made from
     * initialize() must be aware that the instance may not be
     * fully initialized yet.  This method should only be called
     * during the instance creation cycle.
     */
    protected void install()
    {
        _parent = null;
        _label = new ScLocalString();
        _model = new ScLocalObject();
    }

    //##################################################
    //# key
    //##################################################

    @Override
    public String getKey()
    {
        return _key;
    }

    /**
     * Set the key to a new unique, non-null value; and re-register 
     * this control for the new key.  
     * 
     * Although clients are allowed to modified the key, doing so should 
     * normally be done immediately after the control is created.  In 
     * particular, attempting to modify the key after the registry has
     * been locked at the end of the application install process will fail.
     * 
     * In most cases, setting an explicit key is not required.
     */
    public void setKey(String e)
    {
        ScControlRegistry r;
        r = getRegistry();
        r.unregister(this);

        _key = e;
        r.register(this);
    }

    public boolean hasKey(String e)
    {
        return Kmu.isEqual(getKey(), e);
    }

    /**
     * This should only be used for controls that are
     * rerended as part of a larger control.  E.g.:
     * a single checkbox that is being rerendered
     * multiple times inside of a checkbox group.
     * Also, this should only be used if the control
     * was initially constructed with a NULL key.
     */
    public void _setKey(String e)
    {
        _key = e;
    }

    //##################################################
    //# tree
    //##################################################

    public ScControl getRoot()
    {
        if ( hasParent() )
            return getParent().getRoot();

        return this;
    }

    public boolean isRoot()
    {
        return _parent == null;
    }

    public ScControl getParent()
    {
        return _parent;
    }

    public void setParent(ScControl e)
    {
        if ( _parent != null )
            Kmu.fatal("Attempt to change parent after initial assignment.");

        _parent = e;
        attached();
    }

    public boolean hasParent()
    {
        return _parent != null;
    }

    /**
     * This method provides child controls the opportunity to perform
     * some action after they have been added to a container.  
     */
    public void attached()
    {
        // none   
    }

    //##################################################
    //# form
    //##################################################

    /**
     * Return the nearest ancestor that is a form.
     * This may return myself if I am a form.
     * Return null if no form is found.
     */
    public final ScForm findFormWrapper()
    {
        if ( isForm() )
            return asForm();

        if ( hasParent() )
            return getParent().findFormWrapper();

        return null;
    }

    public boolean isForm()
    {
        return false;
    }

    public ScForm asForm()
    {
        return (ScForm)this;
    }

    //##################################################
    //# block
    //##################################################

    /**
     * Return the nearest ancestor that is a block wrapper.
     * This may return myself; or null if no block wrapper is found.
     * The block wrapper is used when auto-selecting a parent to
     * visually block during the ajax submit process.
     * 
     * Form act as block wrappers by default, but it is sometimes
     * appropriate to use some other container as the block
     * wrapper instead.
     * 
     * Note that the block wrapper must implement ScHtmlIdIF.
     * 
     * Subclasses should usually override isBlockWrapper rather 
     * than findBlockWrapper.
     */
    public final ScHtmlIdIF findBlockWrapper()
    {
        if ( isBlockWrapper() )
            return (ScHtmlIdIF)this;

        if ( hasParent() )
            return getParent().findBlockWrapper();

        return null;
    }

    public boolean isBlockWrapper()
    {
        return false;
    }

    //##################################################
    //# action context
    //##################################################

    public ScActionContextIF findActionContextWrapper()
    {
        if ( isActionContextWrapper() )
            return (ScActionContextIF)this;

        if ( hasParent() )
            return getParent().findActionContextWrapper();

        return null;
    }

    public boolean isActionContextWrapper()
    {
        return this instanceof ScActionContextIF;
    }

    //##################################################
    //# parameters
    //##################################################

    /**
     * Read parameters from the http request and apply them
     * to myself and my sub-components.
     */
    public void readParameters()
    {
        readParameters(getData());
    }

    public void readParameters(ScServletData data)
    {
        Iterator<? extends ScControl> i = getComponents();
        while ( i.hasNext() )
            i.next().readParameters(data);
    }

    //##################################################
    //# validate
    //##################################################

    public void validate()
    {
        if ( validateQuietly() )
            return;

        ajaxShowErrors();
        Kmu.cancel();
    }

    public boolean validateQuietly()
    {
        boolean ok = true;

        Iterator<ScControl> i = getComponents();
        while ( i.hasNext() )
            if ( !i.next().validateQuietly() )
                ok = false;

        return ok;
    }

    public boolean hasErrors()
    {
        Iterator<ScControl> i = getComponents();
        while ( i.hasNext() )
            if ( i.next().hasErrors() )
                return true;

        return false;
    }

    public KmList<String> collectErrors()
    {
        KmList<String> v = new KmList<String>();
        collectErrorsOn(v);
        return v;
    }

    public void collectErrorsOn(KmList<String> v)
    {
        Iterator<ScControl> i = getComponents();
        while ( i.hasNext() )
            i.next().collectErrorsOn(v);
    }

    public String formatErrors()
    {
        KmList<String> v = collectErrors();

        if ( v.isEmpty() )
            return null;

        KmStringBuilder out;
        out = new KmStringBuilder();

        for ( String e : v )
            out.println(e);

        return out.toString().trim();
    }

    public boolean isOk()
    {
        return !hasErrors();
    }

    //##################################################
    //# children
    //##################################################

    public Iterator<ScControl> getComponents()
    {
        return EMPTY_CONTROLS;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    public final KmHtmlBuilder render()
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();

        renderOn(out);

        return out;
    }

    /**
     * This is the method that everyone should generally call
     * when they want to render this control.  This provides
     * a standard hook for framework intercepts.
     */
    @Override
    public final void renderOn(KmHtmlBuilder out)
    {
        _renderOn(out);
    }

    /**
     * Convenience method to render this control into a literal control.
     */
    public final void renderOn(ScLiteral e)
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();

        renderOn(out);
        e.setValue(out);
    }

    protected void _renderOn(KmHtmlBuilder out)
    {
        renderControlOn(out);
        renderPostDomOn(out);
    }

    /**
     * This is the method that is actually responsible for
     * rendering this individual control on the specified
     * buffer.  This method should generally NOT be called
     * directly, instead call render(data, out).
     */
    protected abstract void renderControlOn(KmHtmlBuilder out);

    protected void renderPostDomOn(KmHtmlBuilder out)
    {
        out.getPostDom().run(_postDomScript);
    }

    //##################################################
    //# typing
    //##################################################

    public boolean isTextField()
    {
        return false;
    }

    public ScAbstractTextField<?> asTextField()
    {
        return (ScAbstractTextField<?>)this;
    }

    //##################################################
    //# model
    //##################################################

    public final void applyFromModel(Object model)
    {
        boolean skipFields = getData().hasErrors();

        applyFromModel(model, skipFields);
    }

    @Override
    public void applyFromModel(Object model, boolean skipFields)
    {
        _model.setValue(model);

        Iterator<? extends ScControl> i = getComponents();
        while ( i.hasNext() )
            i.next().applyFromModel(model, skipFields);
    }

    @Override
    public void applyToModel(Object model)
    {
        Iterator<? extends ScControl> i = getComponents();
        while ( i.hasNext() )
            i.next().applyToModel(model);
    }

    //##################################################
    //# field values
    //##################################################

    public void saveFieldValues()
    {
        Iterator<? extends ScControl> i = getComponents();
        while ( i.hasNext() )
            i.next().saveFieldValues();
    }

    public void resetFieldValues()
    {
        Iterator<? extends ScControl> i = getComponents();
        while ( i.hasNext() )
            i.next().resetFieldValues();
    }

    //##################################################
    //# convenience
    //##################################################

    public ScFormatter getFormatter()
    {
        return ScFormatter.getInstance();
    }

    //##################################################
    //# data / key parameter
    //##################################################

    protected ScServletData getData()
    {
        return ScServletData.getLocal();
    }

    protected boolean hasData()
    {
        return getData() != null;
    }

    public String getKeyParameter(ScServletData data)
    {
        return data.getParameter(_key);
    }

    public Object getKeyParameterValue(ScServletData data)
    {
        String s = getKeyParameter(data);
        return ScDecoder.staticDecode(s);
    }

    public boolean hasKeyParameter(ScServletData data)
    {
        return data.hasParameter(_key);
    }

    protected final ScScript _ajax()
    {
        return getData().ajax();
    }

    protected String json(CharSequence s)
    {
        return KmJsonUtility.format(s);
    }

    //##################################################
    //# other
    //##################################################

    public Object getModel()
    {
        return _model.getValue();
    }

    //##################################################
    //# state
    //##################################################

    public void setLabel(String msg, Object... args)
    {
        String s = Kmu.format(msg, args);
        _label.setValue(s);
    }

    public String getLabel()
    {
        return _label.getValue();
    }

    public boolean hasLabel()
    {
        // Non-standard: In this case, an empty string should be considered a value.
        return _label.isNotNull();
    }

    public boolean hasLabel(String e)
    {
        return Kmu.isEqual(getLabel(), e);
    }

    //##################################################
    //# encoding
    //##################################################

    protected final String encode(Object e)
    {
        return ScEncoder.staticEncode(e);
    }

    protected final Object decode(String s)
    {
        return ScDecoder.staticDecode(s);
    }

    protected final Object decodeKeyParameter(ScServletData data)
    {
        String s = getKeyParameter(data);
        return decode(s);
    }

    @SuppressWarnings("unchecked")
    protected final <T> T decodeKeyParameterSafe(ScServletData data)
    {
        Object o = decodeKeyParameter(data);
        try
        {
            return (T)o;
        }
        catch ( ClassCastException ex )
        {
            return null;
        }
    }

    //##################################################
    //# support
    //##################################################

    protected static final ScControlRegistry getRegistry()
    {
        return ScControlRegistry.getInstance();
    }

    protected final KmCssDefaultBuilder newCssBuilder()
    {
        return new KmCssDefaultBuilder();
    }

    //##################################################
    //# resources
    //##################################################

    public static String getThemeImageUrl(String file)
    {
        return ScUrls.getThemeImage(file);
    }

    protected final String getBlankImageUrl()
    {
        return ScUrls.getBlankImage();
    }

    //##################################################
    //# visitor (accept)
    //##################################################

    public void accept(ScControlVisitorIF e)
    {
        e.visit(this);

        Iterator<? extends ScControl> i = getComponents();
        while ( i.hasNext() )
            i.next().accept(e);
    }

    public boolean accept(ScStoppableControlVisitorIF e)
    {
        e.visit(this);

        Iterator<? extends ScControl> i = getComponents();
        while ( i.hasNext() )
            if ( i.next().accept(e) )
                return true;

        return false;
    }

    //##################################################
    //# script
    //##################################################

    public ScScript getPostDomScript()
    {
        if ( _postDomScript == null )
            _postDomScript = new ScScript();

        return _postDomScript;
    }

    //##################################################
    //# ajax
    //##################################################

    public final void ajaxUpdateValues()
    {
        accept(new ScControlVisitorIF()
        {
            @Override
            public void visit(ScControl e)
            {
                if ( e instanceof ScAjaxValueIF )
                    ((ScAjaxValueIF)e).ajaxUpdateValue();
            }
        });
    }

    public final void ajaxShowErrors()
    {
        accept(new ScControlVisitorIF()
        {
            @Override
            public void visit(ScControl e)
            {
                e.ajaxShowError();
            }
        });
    }

    protected void ajaxShowError()
    {
        // subclass
    }

    protected void ajaxHideError()
    {
        // subclass
    }
}
