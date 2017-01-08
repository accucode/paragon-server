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

import java.util.Collections;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDaoRollbackException;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.json.KmJsonUtility;
import com.kodemore.log.KmLog;
import com.kodemore.meta.KmMetaAttribute;
import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.servlet.ScEncodedValueIF;
import com.kodemore.servlet.ScModelApplicatorIF;
import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScContextSupplierIF;
import com.kodemore.servlet.action.ScErrorManagerIF;
import com.kodemore.servlet.action.ScGlobalContext;
import com.kodemore.servlet.action.ScSecurityManagerIF;
import com.kodemore.servlet.encoder.ScDecoder;
import com.kodemore.servlet.encoder.ScEncoder;
import com.kodemore.servlet.field.ScHtmlId;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.script.ScToastScript;
import com.kodemore.servlet.utility.ScBridge;
import com.kodemore.servlet.utility.ScControlRegistry;
import com.kodemore.servlet.utility.ScFormatter;
import com.kodemore.servlet.utility.ScKeyIF;
import com.kodemore.servlet.utility.ScUrlBridge;
import com.kodemore.servlet.utility.ScUrls;
import com.kodemore.servlet.variable.ScLocalControl;
import com.kodemore.servlet.variable.ScLocalObject;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.KmCompressMemoryIF;
import com.kodemore.utility.Kmu;

public abstract class ScControl
    implements ScControlIF, ScKeyIF, ScModelApplicatorIF, ScContextSupplierIF, KmCompressMemoryIF
{
    //##################################################
    //# constants
    //##################################################

    protected static final KmList<ScControl> EMPTY_CHILDREN = new KmList<>(Collections.emptyList());

    //##################################################
    //# variables
    //##################################################

    /**
     * This key uniquely identifies the control within the application.
     * Keys are expected to remain consistent across applicatino restarts,
     * but NOT across different application versions.  Keys are typically
     * assigned automatically when the control is created.
     */
    private String                           _key;

    /**
     * Controls organized in a simple tree hierarchy.
     *
     * In general, it is important to ensure that all controls are attached
     * to the hierarchy. Controls use the parent hierarchy for a couple of
     * important convenience mechanisms.  For example...
     * - Find the containing ScForm.
     * - Find the containing ScContextIF.
     */
    private ScLocalControl                   _parent;

    /**
     * The label attribute is strictly an application feature,
     * and does not correspond directly to any html attribute.
     * Various containers use their children's labels to more
     * conveniently manage the layout.  Although all controls
     * have the label attribute, the actual usage varies widely.
     */
    private ScLocalString                    _label;

    /**
     * The help text associated with this control.  This is primarily
     * used for fields, but may also be associated with other controls.
     * Some of the layout controls such as ScFieldLayout, ScFieldTable,
     * use the help (if present) to display a on screen tooltips.
     */
    private ScLocalString                    _help;

    /**
     * Many controls support dynamic content based on the current
     * state of the model.  For instance this allows the client
     * to apply a common model (e.g.: a Person) to an entire
     * subtree of controls, and have different children apply
     * that Person in different ways - one control may apply
     * the person's name.
     */
    private ScLocalObject                    _model;

    /**
     * The scripts to run after the dom has been updated.
     *
     * Note that these are scripts are not thread safe.  The
     * general assumption is that dynamic behavior will be handled
     * outside the configuration of the control.  That said,
     * the script can contains ScScriptIFs that will be evaluated
     * upon request.
     */
    private ScBlockScript                    _postDomScript;

    /**
     * The scripts to run after the display has been rendered.
     *
     * Some actions (e.g.: focus) cannot be reliably executed
     * after the dom has been updated, and must wait until after
     * the display has been fully rendered.
     */
    private ScBlockScript                    _postRenderScript;

    //##################################################
    //# constructor
    //##################################################

    /**
     * Register the control with a default key, then
     * perform any default initialization.
     */
    public ScControl()
    {
        ScControlRegistry r = getRegistry();
        _key = r.getNextKey();
        r.register(this);

        _parent = new ScLocalControl();
        _label = new ScLocalString();
        _help = new ScLocalString();
        _model = new ScLocalObject();
    }

    //##################################################
    //# install
    //##################################################

    /**
     * @see ScPage#postInstall
     */
    public final void postInstall()
    {
        visitAll(e -> e.postInstall_here());
    }

    /**
     * @see ScPage#postInstall
     */
    protected void postInstall_here()
    {
        // none
    }

    //##################################################
    //# key
    //##################################################

    @Override
    public final String getKey()
    {
        return _key;
    }

    /**
     * Set the key to a new unique, non-null value; and re-register
     * this control for the new key.  This is typically only used
     * for debuggering and should NOT be used as part of normal
     * application development.
     */
    public void _setKey(String e)
    {
        ScControlRegistry r;
        r = getRegistry();
        r.unregister(this);

        _key = e;
        r.register(this);
    }

    public boolean hasKey()
    {
        return _key != null;
    }

    public boolean hasKey(String e)
    {
        return Kmu.isEqual(getKey(), e);
    }

    //##################################################
    //# type
    //##################################################

    /**
     * This provides a safe alternative to casting.
     *
     * Currently, ALL controls should subclass from ScControl.
     * Therefore, there is no corresponding method for isControl.
     */
    @Override
    public final ScControl asControl()
    {
        return this;
    }

    //##################################################
    //# action
    //##################################################

    protected final ScAction newCheckedAction(Runnable r)
    {
        return newAction(r, true);
    }

    protected final ScAction newUncheckedAction(Runnable r)
    {
        return newAction(r, false);
    }

    private final ScAction newAction(Runnable r, boolean checked)
    {
        if ( r == null )
            return null;

        ScAction e;
        e = new ScAction(this, r);
        e.setChangeTracking(checked);
        return e;
    }

    //##################################################
    //# context :: security manager
    //##################################################

    @Override
    public ScSecurityManagerIF getSecurityManager()
    {
        if ( isSecurityManager() )
            return asSecurityManager();

        if ( hasParent() )
            return getParent().getSecurityManager();

        return ScGlobalContext.getInstance();
    }

    public boolean isSecurityManager()
    {
        return this instanceof ScSecurityManagerIF;
    }

    public ScSecurityManagerIF asSecurityManager()
    {
        return (ScSecurityManagerIF)this;
    }

    //##################################################
    //# context :: errors manager
    //##################################################

    @Override
    public ScErrorManagerIF getErrorManager()
    {
        if ( isErrorManager() )
            return asErrorManager();

        if ( hasParent() )
            return getParent().getErrorManager();

        return ScGlobalContext.getInstance();
    }

    public final boolean isErrorManager()
    {
        return this instanceof ScErrorManagerIF;
    }

    public final ScErrorManagerIF asErrorManager()
    {
        return (ScErrorManagerIF)this;
    }

    //##################################################
    //# tree :: parent
    //##################################################

    @Override
    public final ScControl getParent()
    {
        return _parent.getValue();
    }

    @Override
    public final void setParent(ScControl e)
    {
        if ( hasParent() )
            throw Kmu.newFatal("Attempt to change parent after initial assignment.");

        _parent.setValue(e);
        attached();
    }

    public boolean hasParent()
    {
        return getParent() != null;
    }

    public boolean hasParent(ScControl e)
    {
        return Kmu.isEqual(getParent(), e);
    }

    //==================================================
    //= tree :: hierarchy
    //==================================================

    /**
     * Return the list of parents, starting with the root
     * and then listing each control in the hierarchy ending
     * with myself.
     */
    public KmList<ScControl> getParentHierarchy()
    {
        KmList<ScControl> v = new KmList<>();

        ScControl e = this;
        while ( true )
        {
            v.add(e);
            e = e.getParent();
            if ( e == null )
                break;
        }

        v.reverse();
        return v;
    }

    public void printParentHierarchy()
    {
        int i = 0;
        for ( ScControl e : getParentHierarchy() )
        {
            String prefix = Kmu.repeat("  ", i);
            String name = e.getClass().getSimpleName();
            KmLog.info(prefix + name);
            i++;
        }
    }

    //==================================================
    //= tree :: root
    //==================================================

    public final ScControl getRoot()
    {
        return hasParent()
            ? getParent().getRoot()
            : this;
    }

    public final boolean isRoot()
    {
        return !hasParent();
    }

    //==================================================
    //= tree :: misc
    //==================================================

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

    public boolean isErrorRoot()
    {
        return this == getErrorRoot();
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
     * Forms act as block wrappers by default, but it is sometimes
     * appropriate to use some other container as the block
     * wrapper instead.
     *
     * Note that the block wrapper must implement ScHtmlIdIF.
     * Subclasses should override isBlockWrapper rather than findBlockWrapper.
     */
    public final ScHtmlIdIF findBlockWrapper()
    {
        if ( isBlockWrapper() )
            return (ScHtmlIdIF)this;

        if ( hasParent() )
            return getParent().findBlockWrapper();

        return null;
    }

    /**
     * See also any subclasses that override this method.
     */
    public boolean isBlockWrapper()
    {
        return false;
    }

    //##################################################
    //# parameters
    //##################################################

    /**
     * Read parameters from the http request and apply them
     * to myself and all children.
     */
    @Override
    public final void readParameters()
    {
        ScServletData data = getData();
        visitAll(e -> e.readParameters_here(data));
    }

    /**
     * Read ONLY those parameters that apply directly to myself.
     * Subclasses override this to implement internal functionality.
     * Clients should generally call readParameters.
     *
     * @param data The servletData, so we don't have to fetch it from ThreadLocal.
     */
    protected void readParameters_here(ScServletData data)
    {
        // subclass
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

        for ( ScControl e : getChildren() )
            if ( !e.validateQuietly() )
                ok = false;

        return ok;
    }

    public RuntimeException newRollbackException()
    {
        throw new KmDaoRollbackException();
    }

    //##################################################
    //# application errors
    //##################################################

    /**
     * Check if there are any errors in the control hierarchy; and, if so,
     * show the error messages and throw a rollback throwable.
     */
    public void checkErrors()
    {
        if ( !isErrorRoot() )
        {
            getErrorRoot().checkErrors();
            return;
        }

        if ( hasErrors() )
        {
            ajaxShowErrors();
            throw Kmu.newRollbackException();
        }
    }

    @Override
    public boolean hasErrors()
    {
        for ( ScControl e : getChildren() )
            if ( e.hasErrors() )
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
        for ( ScControl e : getChildren() )
            e.collectErrorsOn(v);
    }

    public String formatErrors()
    {
        return collectErrors().joinLines();
    }

    public boolean isOk()
    {
        return !hasErrors();
    }

    //##################################################
    //# children
    //##################################################

    @Override
    public KmList<ScControl> getChildren()
    {
        return EMPTY_CHILDREN;
    }

    @Override
    public void visitAll(Consumer<ScControl> c)
    {
        c.accept(this);

        for ( ScControl e : getChildren() )
            e.visitAll(c);
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
     * Convenience method to render this control into a literal.
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
        renderNonScClassNameOn(out);
        renderControlOn(out);
        renderPostDomOn(out);
        renderPostRenderOn(out);
    }

    private void renderNonScClassNameOn(KmHtmlBuilder out)
    {
        if ( !getBridge().getRenderDebugDomComments() )
            return;

        String name = getClass().getSimpleName();
        if ( !name.startsWith("Sc") )
            out.printComment(name);
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
     * directly, instead call renderOn(out).
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

    /**
     * Get the model currently associated with this control.
     */
    public Object getModel()
    {
        return _model.getValue();
    }

    /**
     * Apply the model to this control and all descendants.
     * By default, this skips (editable) fields if there are currently any errors.
     */
    public final void applyFromModel(Object model)
    {
        boolean skipFields = getData().hasErrors();
        applyFromModel(model, skipFields);
    }

    /**
     * Apply the model to this control and all descendants.
     * If skipFields is true, then EDITABLE fields should not be updated.
     */
    @Override
    public final void applyFromModel(Object model, boolean skipFields)
    {
        boolean downcast = applyFromModel_here(model, skipFields);
        if ( downcast )
            for ( ScControl e : getChildren() )
                e.applyFromModel(model, skipFields);
    }

    /**
     * Apply to the model to this control only, NOT to descendants.
     *
     * Return true; continue the downcast.
     * Return false; stop the downcast.
     *
     * The default implementation updates the Control's Model, and returns true.
     * Subclasses should usually call super, but this is not strictly required
     * if the subclass can guarantee than neither it nor it's descendants need
     * the model.
     *
     * @param skipFields Indicates if (editable) fields should be skipped.
     */
    protected boolean applyFromModel_here(Object model, boolean skipFields)
    {
        _model.setValue(model);
        return true;
    }

    /**
     * Apply this control and all descendants, to the model.
     */
    @Override
    public final void applyToModel(Object model)
    {
        boolean downcast = applyToModel_here(model);
        if ( downcast )
            for ( ScControl e : getChildren() )
                e.applyToModel(model);
    }

    /**
     * Apply this control only to the model, does NOT apply descendants.
     * Return true; continue the downcast.
     * Return false; stop the downcast.
     *
     * The default implementation does NOTHING.
     * Subclasses are NOT required to call super.
     *
     * @param model May be used by subclasse override.
     */
    protected boolean applyToModel_here(Object model)
    {
        return true;
    }

    //##################################################
    //# field values
    //##################################################

    @Override
    public final void saveFieldValues()
    {
        visitAllFields(e -> e.saveValue());
    }

    @Override
    public final void resetFieldValues()
    {
        visitAllFields(e -> e.resetValue());
    }

    //##################################################
    //# formatter
    //##################################################

    protected ScFormatter getFormatter()
    {
        return ScFormatter.getInstance();
    }

    protected String formatAny(Object e)
    {
        return getFormatter().formatAny(e);
    }

    //##################################################
    //# ajax
    //##################################################

    protected final ScBlockScript getRootScript()
    {
        return getData().ajax();
    }

    protected final ScToastScript ajaxToast(String msg, Object... args)
    {
        return getRootScript().toast(msg, args);
    }

    //##################################################
    //# data / key parameter
    //##################################################

    protected ScServletData getData()
    {
        return ScServletData.getLocal();
    }

    protected String json(CharSequence s)
    {
        return KmJsonUtility.format(s);
    }

    protected String json(Boolean s)
    {
        return KmJsonUtility.format(s);
    }

    protected final ScHtmlIdAjax newHtmlIdAjaxOn(String htmlId)
    {
        return new ScHtmlId(htmlId, getRootScript())._htmlIdAjax();
    }

    //##################################################
    //# label
    //##################################################

    @Override
    public final void setLabel(String s)
    {
        _label.setValue(s);
    }

    public void setLabel(KmMetaAttribute<?,?> p)
    {
        setLabel(p.getLabel());
    }

    @Override
    public String getLabel()
    {
        return _label.getValue();
    }

    public final boolean hasLabel()
    {
        // Non-standard: In this case, an empty string should be considered a value.
        return getLabel() != null;
    }

    public final boolean hasLabel(String e)
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

    public void prependHelp(String e)
    {
        if ( !hasHelp() )
        {
            setHelp(e);
            return;
        }

        KmStringBuilder out;
        out = new KmStringBuilder();
        out.println(e);
        out.println(getHelp());
        out.trim();

        setHelp(out.toString());
    }

    public void setHelp(KmMetaAttribute<?,?> e)
    {
        setHelp(e.getHelp());
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

    @SuppressWarnings("unchecked")
    protected final <T> T decodeUnchecked(String s)
    {
        return (T)decode(s);
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

    protected final KmStyleBuilder newStyleBuilder()
    {
        return new KmStyleBuilder();
    }

    protected final void warnIfInstalled()
    {
        getBridge().warnIfInstalled();
    }

    //==================================================
    //= support :: fire
    //==================================================

    protected void fire(Runnable e)
    {
        if ( e != null )
            e.run();
    }

    protected <E> void fire(Consumer<E> c, E arg)
    {
        if ( c != null )
            c.accept(arg);
    }

    //##################################################
    //# bridge
    //##################################################

    protected ScBridge getBridge()
    {
        return ScBridge.getInstance();
    }

    protected ScUrlBridge getUrls()
    {
        return ScUrlBridge.getInstance();
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
    //# ajax value
    //##################################################

    public final void ajaxResetFieldValues()
    {
        resetFieldValues();
        ajaxUpdateFieldValues();
    }

    public final void ajaxUpdateFieldValues()
    {
        ajaxUpdateFieldValues(getChangeTracking());
    }

    public final void ajaxUpdateFieldValues(boolean updateOldValue)
    {
        visitAllFields(e -> e.ajaxUpdateFieldValue_here(updateOldValue));
    }

    public boolean getChangeTracking()
    {
        return false;
    }

    //##################################################
    //# error
    //##################################################

    public final void ajaxShowErrors()
    {
        visitAll(e -> e.ajaxShowError());
    }

    protected void ajaxShowError()
    {
        // subclass
    }

    protected void ajaxHideError()
    {
        // subclass
    }

    //##################################################
    //# fields
    //##################################################

    public final boolean isField()
    {
        return this instanceof ScFieldIF;
    }

    public final ScFieldIF<?> asField()
    {
        return (ScFieldIF<?>)this;
    }

    @Override
    public final void visitAllFields(Consumer<ScFieldIF<?>> c)
    {
        if ( isField() )
            c.accept(asField());

        for ( ScControl e : getChildren() )
            e.visitAllFields(c);
    }

    public final boolean containsRequiredField()
    {
        return find(e -> e.isRequiredField()) != null;
    }

    public boolean isRequiredField()
    {
        return isField() && asField().isRequired();
    }

    /**
     * Find the any descendant that matches the predicate.
     * The search includes myself.
     * The search order is not guaranteed (e.g. depth-first vs breadth-first).
     * Return null if no match is found.
     */
    protected final ScControl find(Predicate<ScControl> p)
    {
        if ( p.test(this) )
            return this;

        for ( ScControl c : getChildren() )
        {
            ScControl result = c.find(p);
            if ( result != null )
                return result;
        }

        return null;
    }

    //##################################################
    //# form
    //##################################################

    public final boolean isForm()
    {
        return this instanceof ScForm;
    }

    public final ScForm asForm()
    {
        return (ScForm)this;
    }

    @Override
    public final void visitAllForms(Consumer<ScForm> c)
    {
        if ( isForm() )
            c.accept(asForm());

        for ( ScControl e : getChildren() )
            e.visitAllForms(c);
    }

    /**
     * Return the nearest ancestor form.
     * This may return myself if I am a form.
     * Return null if no form is found.
     */
    public final ScForm findFormWrapper()
    {
        ScControl e = this;
        while ( true )
        {
            if ( e.isForm() )
                return e.asForm();

            if ( e.isRoot() )
                return null;

            e = e.getParent();
        }
    }

    //##################################################
    //# encoded values
    //##################################################

    public final boolean isEncodedValue()
    {
        return this instanceof ScEncodedValueIF;
    }

    public final ScEncodedValueIF asEncodedValue()
    {
        return (ScEncodedValueIF)this;
    }

    public final void visitAllEncodedValues(Consumer<ScEncodedValueIF> c)
    {
        if ( isEncodedValue() )
            c.accept(asEncodedValue());

        for ( ScControl e : getChildren() )
            e.visitAllEncodedValues(c);
    }

    //##################################################
    //# focus target
    //##################################################

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
    //# compress
    //##################################################

    /**
     * @see KmCompressMemoryIF#compressMemory
     */
    @Override
    public void compressMemory()
    {
        _label.compressMemory();
        _help.compressMemory();

        KmList<ScControl> v = getChildren();
        for ( ScControl e : v )
            e.compressMemory();
    }

    //##################################################
    //# change tracking
    //##################################################

    public final ScHtmlIdIF findChangeTrackingScopeWrapper()
    {
        if ( isChangeTrackingScope() )
            return asChangeTrackingScope();

        return hasParent()
            ? getParent().findChangeTrackingScopeWrapper()
            : null;
    }

    public boolean isChangeTrackingScope()
    {
        return false;
    }

    public final ScHtmlIdIF asChangeTrackingScope()
    {
        return (ScHtmlIdIF)this;
    }
}
