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

import com.kodemore.collection.KmEmptyIterator;
import com.kodemore.collection.KmList;
import com.kodemore.command.KmDaoRollbackException;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.json.KmJsonUtility;
import com.kodemore.log.KmLog;
import com.kodemore.meta.KmMetaAttribute;
import com.kodemore.meta.KmMetaProperty;
import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.servlet.ScModelApplicatorIF;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScContextIF;
import com.kodemore.servlet.action.ScContextSupplierIF;
import com.kodemore.servlet.action.ScGlobalContext;
import com.kodemore.servlet.encoder.ScDecoder;
import com.kodemore.servlet.encoder.ScEncoder;
import com.kodemore.servlet.field.ScControlVisitorIF;
import com.kodemore.servlet.field.ScField;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.field.ScStoppableControlVisitorIF;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.utility.ScBridge;
import com.kodemore.servlet.utility.ScControlRegistry;
import com.kodemore.servlet.utility.ScFormatter;
import com.kodemore.servlet.utility.ScKeyIF;
import com.kodemore.servlet.utility.ScUrls;
import com.kodemore.servlet.variable.ScLocalObject;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

public abstract class ScControl
    implements ScControlIF, ScKeyIF, ScModelApplicatorIF, ScContextSupplierIF
{
    //##################################################
    //# constants
    //##################################################

    protected static final Iterator<ScControlIF> EMPTY_CONTROLS = new KmEmptyIterator<>();

    //##################################################
    //# variables
    //##################################################

    /**
     * This key uniquely identifies the control within the application.
     * Keys are expected to remain consistent across applicatino restarts,
     * but NOT across different application versions.  Keys are typically
     * assigned automatically when the control is created.
     */
    private String _key;

    /**
     * Controls organized in a simple tree hierarchy.
     *
     * In general, it is important to ensure that all controls are attached
     * to the hierarchy. Controls use the parent hierarchy for a couple of
     * important convenience mechanisms.  For example...
     * - Find the containing ScForm.
     * - Find the containing ScContextIF.
     */
    private ScControl _parent;

    /**
     * The label attribute is strictly an application feature,
     * and does not correspond directly to any html attribute.
     * Various containers use their children's labels to more
     * conveniently manage the layout.  Although all controls
     * have the label attribute, the actual usage varies widely.
     */
    private ScLocalString _label;

    /**
     * The help text associated with this control.  This is primarily
     * used for fields, but may also be associated with other controls.
     * Some of the layout controls such as ScFieldLayout, ScFieldTable,
     * use the help (if present) to display a on screen tooltips.
     */
    private ScLocalString _help;

    /**
     * Many controls support dynamic content based on the current
     * state of the model.  For instance this allows the client
     * to apply a common model (e.g.: a Person) to an entire
     * subtree of controls, and have different children apply
     * that Person in different ways - one control may apply
     * the person's name.
     */
    private ScLocalObject _model;

    /**
     * The scripts to run after the dom has been updated.
     *
     * Note that these are scripts are not thread safe.  The
     * general assumption is that dynamic behavior will be handled
     * outside the configuration of the control.  That said,
     * the script can contains ScScriptIFs that will be evaluated
     * upon request.
     */
    private ScBlockScript _postDomScript;

    /**
     * The scripts to run after the display has been rendered.
     *
     * Some actions (e.g.: focus) cannot be reliably executed
     * after the dom has been updated, and must wait until after
     * the display has been fully rendered.
     */
    private ScBlockScript _postRenderScript;

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
        _help = new ScLocalString();
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
     * been locked at the end of the servlet installation process will fail.
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
    //# action
    //##################################################

    protected ScAction newAction(Runnable r)
    {
        if ( r == null )
            return null;

        return new ScAction(this, r);
    }

    //##################################################
    //# context
    //##################################################

    @Override
    public ScContextIF getContext()
    {
        if ( isRoot() )
            return ScGlobalContext.getInstance();

        return getParent().getContext();
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

    /**
     * Return the root/top-most control for the purpose of error handling.
     * This is normally the ScPageRoot, but in some special cases we root
     * error handling at a lower container such as an ScDialog.
     */
    public ScControl getErrorRoot()
    {
        if ( hasParent() )
            return getParent().getErrorRoot();

        return this;
    }

    public ScControl getParent()
    {
        return _parent;
    }

    @Override
    public final void setParent(ScControl e)
    {
        if ( _parent != null )
            throw Kmu.newFatal("Attempt to change parent after initial assignment.");

        _parent = e;
        attached();
    }

    public boolean hasParent()
    {
        return _parent != null;
    }

    public boolean hasParent(ScControl e)
    {
        return Kmu.isEqual(getParent(), e);
    }

    public void printParentHierarchy()
    {
        ScControl e = this;
        int i = 0;

        while ( e != null )
        {
            String prefix = Kmu.repeat("  ", i);
            String name = e.getClass().getSimpleName();
            KmLog.info(prefix + name);

            i++;
            e = e.getParent();
        }
    }

    /**
     * This method provides child controls the opportunity to perform
     * some action after they have been added to a container.  Subclasses
     * should normally override the install() method and perform initialization
     * there since that thread is always guaranteed to be run.  However, some
     * special cases may require that initialization be deferred until the control
     * is attached to the parent; in which case, this method may safely perform
     * the same type of initialization that would nomrally be performed by the install()
     * method.
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

    @Override
    public ScHtmlIdIF getFocusTarget()
    {
        if ( this instanceof ScHtmlIdIF )
            return (ScHtmlIdIF)this;

        return null;
    }

    public boolean hasFocusTarget()
    {
        return getFocusTarget() != null;
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

    @Override
    public void readParameters(ScServletData data)
    {
        Iterator<ScControlIF> i = getComponents();
        while ( i.hasNext() )
            i.next().readParameters(data);
    }

    //##################################################
    //# validate
    //##################################################

    /**
     * Validate
     */
    @Override
    public final void validate()
    {
        validateQuietly();
        getErrorRoot().checkErrors();
    }

    @Override
    public boolean validateQuietly()
    {
        boolean ok = true;

        Iterator<ScControlIF> i = getComponents();
        while ( i.hasNext() )
            if ( !i.next().validateQuietly() )
                ok = false;

        return ok;
    }

    public RuntimeException newRollbackException()
    {
        throw new KmDaoRollbackException();
    }

    /**
     * Check if there are any errors in the control hierarchy; and, if so,
     * show the error messages and throw a rollback throwable.
     */
    public void checkErrors()
    {
        if ( !isRoot() )
        {
            getRoot().checkErrors();
            return;
        }

        if ( hasErrors() )
        {
            ajaxShowErrors();
            Kmu.throwDaoRollback();
        }
    }

    @Override
    public boolean hasErrors()
    {
        Iterator<ScControlIF> i = getComponents();

        while ( i.hasNext() )
            if ( i.next().hasErrors() )
                return true;

        return false;
    }

    public KmList<String> collectErrors()
    {
        KmList<String> v = new KmList<>();
        collectErrorsOn(v);
        return v;
    }

    @Override
    public void collectErrorsOn(KmList<String> v)
    {
        Iterator<ScControlIF> i = getComponents();
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

    @Override
    @SuppressWarnings("rawtypes")
    public ScField findFieldFor(KmMetaAttribute<?,?> attr)
    {
        Iterator<ScControlIF> i = getComponents();

        while ( i.hasNext() )
        {
            ScField f = i.next().findFieldFor(attr);
            if ( f != null )
                return f;
        }

        return null;
    }

    public void addErrorTo(KmMetaAttribute<?,?> attr, String msg, Object... args)
    {
        findFieldFor(attr).addError(msg, args);
    }

    //##################################################
    //# children
    //##################################################

    @Override
    public Iterator<ScControlIF> getComponents()
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

    public final String renderHtml()
    {
        return render().formatHtml();
    }

    /**
     * Convenience method to render this control into a literal control.
     */
    public final void renderOn(ScLiteral e)
    {
        KmHtmlBuilder out = new KmHtmlBuilder();
        renderOn(out);
        e.setValue(out);
    }

    /**
     * This is the method that everyone should generally call
     * when they want to render this control.  This provides
     * a standard hook for framework intercepts.
     */
    @Override
    public final void renderOn(KmHtmlBuilder out)
    {
        preRender();
        renderControlOn(out);
        renderPostDomOn(out);
        renderPostRenderOn(out);
    }

    /**
     * I am called immediately before the control is rendered.
     * This method is intended to provide a simple way for business logic
     * specific subclasses to perform some setup before the control is rendered.
     */
    protected void preRender()
    {
        // subclass
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

    protected void renderPostRenderOn(KmHtmlBuilder out)
    {
        out.getPostRender().run(_postRenderScript);
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

        Iterator<? extends ScControlIF> i = getComponents();
        while ( i.hasNext() )
            i.next().applyFromModel(model, skipFields);
    }

    @Override
    public void applyToModel(Object model)
    {
        Iterator<? extends ScControlIF> i = getComponents();
        while ( i.hasNext() )
            i.next().applyToModel(model);
    }

    //##################################################
    //# field values
    //##################################################

    @Override
    public void saveFieldValues()
    {
        Iterator<ScControlIF> i = getComponents();
        while ( i.hasNext() )
            i.next().saveFieldValues();
    }

    @Override
    public void resetFieldValues()
    {
        Iterator<ScControlIF> i = getComponents();
        while ( i.hasNext() )
            i.next().resetFieldValues();
    }

    //##################################################
    //# formatter
    //##################################################

    public ScFormatter getFormatter()
    {
        return ScFormatter.getInstance();
    }

    public String formatAny(Object e)
    {
        return getFormatter().formatAny(e);
    }

    //##################################################
    //# data / key parameter
    //##################################################

    protected ScServletData getData()
    {
        return ScServletData.getLocal();
    }

    public String getStringArgument()
    {
        return getData().getStringArgument();
    }

    public Integer getIntegerArgument()
    {
        return getData().getIntegerArgument();
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

    protected final ScBlockScript getRootScript()
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
    //# label
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
        return getLabel() != null;
    }

    public boolean hasLabel(String e)
    {
        return Kmu.isEqual(getLabel(), e);
    }

    //##################################################
    //# help
    //##################################################

    public String getHelp()
    {
        return _help.getValue();
    }

    public void setHelp(String e)
    {
        _help.setValue(e);
    }

    public void setHelp(KmMetaProperty<?,?> p)
    {
        setHelp(p.getHelp());
    }

    public boolean hasHelp()
    {
        return Kmu.hasValue(getHelp());
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

    protected final void warnIfInstalled()
    {
        ScBridge.getInstance().warnIfInstalled();
    }

    //##################################################
    //# print old value
    //##################################################

    protected void printOldValueAttributeOn(KmHtmlBuilder out, String value)
    {
        if ( value == null )
            value = "";

        out.printDataAttribute(ScConstantsIF.DATA_ATTRIBUTE_OLD_VALUE, value);
    }

    protected void printOldCheckedAttributeOn(KmHtmlBuilder out, Boolean value)
    {
        if ( value == null )
            value = false;

        out.printDataAttribute(ScConstantsIF.DATA_ATTRIBUTE_OLD_CHECKED, value);
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

    @Override
    public void accept(ScControlVisitorIF e)
    {
        e.visit(this);

        Iterator<ScControlIF> i = getComponents();
        while ( i.hasNext() )
            i.next().accept(e);
    }

    @Override
    public boolean accept(ScStoppableControlVisitorIF e)
    {
        e.visit(this);

        Iterator<? extends ScControlIF> i = getComponents();
        while ( i.hasNext() )
            if ( i.next().accept(e) )
                return true;

        return false;
    }

    //##################################################
    //# post scripts
    //##################################################

    public ScBlockScript getPostDomScript()
    {
        if ( _postDomScript == null )
            _postDomScript = createPostScript();

        return _postDomScript;
    }

    public ScBlockScript getPostRenderScript()
    {
        if ( _postRenderScript == null )
            _postRenderScript = createPostScript();

        return _postRenderScript;
    }

    protected ScBlockScript createPostScript()
    {
        return ScBlockScript.create();
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
