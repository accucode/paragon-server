package com.app.ui.selector.core;

import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.field.ScHiddenField;
import com.kodemore.servlet.utility.ScControlRegistry;
import com.kodemore.utility.Kmu;

import com.app.ui.control.MyFormDialog;

/**
 * I am used by the to dynamically add a new option/type on the fly.
 */
public abstract class MyAbstractSelectorDialog<P extends KmUidDomainIF, C extends KmUidDomainIF>
    extends MyFormDialog
{
    //##################################################
    //# variables
    //##################################################

    /**
     * This is the KEY that identifies the selector that opened
     * this dialog.
     */
    private ScHiddenField<Integer> _selectorKeyField;

    /**
     * Used to populate the options.
     */
    private ScHiddenField<String> _domainParentUidField;

    //##################################################
    //# constructor
    //##################################################

    protected MyAbstractSelectorDialog()
    {
        install();
    }

    //##################################################
    //# install
    //##################################################

    private void install()
    {
        onSubmit(newUncheckedAction(this::handleSave));

        installHiddenFields();

        ScDiv body;
        body = getBody();
        body.css().pad10();
        installFieldsOn(body);

        ScDiv footer;
        footer = showFooter();
        footer.css().buttonBox();
        footer.addSaveButton();
        footer.addCancelButton(newUncheckedAction(this::ajaxClose));
    }

    /**
     * @param root subclasses can set padding and add children.
     */
    protected void installFieldsOn(ScDiv root)
    {
        // subclass
    }

    protected abstract String getDomainChildTitle();

    //==================================================
    //= install :: hidden fields
    //==================================================

    private void installHiddenFields()
    {
        ScDiv e;
        e = getHeader();
        e.add(createSelectorKeyField());
        e.add(createDomainParentUidField());
        installHiddenFieldsOn(e);
    }

    private ScControl createSelectorKeyField()
    {
        ScHiddenField<Integer> e;
        e = new ScHiddenField<>();
        _selectorKeyField = e;
        return e;
    }

    private ScControl createDomainParentUidField()
    {
        ScHiddenField<String> e;
        e = new ScHiddenField<>();
        _domainParentUidField = e;
        return e;
    }

    /**
     * @param e
     */
    protected void installHiddenFieldsOn(ScDiv e)
    {
        // subclass
    }

    //##################################################
    //# selector
    //##################################################

    @SuppressWarnings("unchecked")
    public MyAbstractSelector<P,C> getSelector()
    {
        int key = _selectorKeyField.getValue();
        ScControl c = ScControlRegistry.getInstance().findKey(key);
        return (MyAbstractSelector<P,C>)c;
    }

    public void setSelector(MyAbstractSelector<P,C> e)
    {
        int key = e.getKey();
        _selectorKeyField.setValue(key);
    }

    //##################################################
    //# domain parent
    //##################################################

    protected final P getDomainParent()
    {
        String uid = _domainParentUidField.getValue();
        return findDomainParent(uid);
    }

    protected abstract P findDomainParent(String uid);

    public void setDomainParent(P e)
    {
        String uid = KmUidDomainIF.getUidFor(e);
        _domainParentUidField.setValue(uid);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();
        setLabel("Add " + getDomainChildTitle());
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSave()
    {
        ajaxHideAllErrors();
        validateAndCheck();

        P parent = getDomainParent();
        if ( parent == null )
            throw Kmu.newFatal("No parent.");

        C child = saveDomainChildFor(parent);

        getAccess().flush();
        ajaxClose();
        getSelector().handleAdded(parent, child);
    }

    protected abstract C saveDomainChildFor(P parent);
}
