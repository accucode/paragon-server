package com.app.ui.info;

import java.util.function.Function;

import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScDivWrapper;
import com.kodemore.servlet.control.ScFieldText;
import com.kodemore.servlet.control.ScLink;
import com.kodemore.servlet.control.ScScriptButton;
import com.kodemore.servlet.control.ScTextSpan;
import com.kodemore.servlet.script.ScOpenWindowScript;

import com.app.dao.base.MyDaoAccess;
import com.app.utility.MyGlobals;

public abstract class MyDomainInfo<T extends KmUidDomainIF>
    extends ScDivWrapper
{
    //##################################################
    //# variables
    //##################################################

    /**
     * A function that returns the TARGET model from the SOURCE model.
     * E.g.: On a customerInfo, this may return a customer from a job.
     */
    private Function<?,T> _targetFunction;

    private ScTextSpan     _labelText;
    private ScLink         _viewLink;
    private ScScriptButton _popoutButton;
    private ScFieldText    _nameText;

    //##################################################
    //# constructor
    //##################################################

    public MyDomainInfo()
    {
        ScDiv root = getInner();
        installOn(root);
    }

    //##################################################
    //# install
    //##################################################

    private void installOn(ScDiv root)
    {
        hide();

        root.css().flexRow().flexCrossAlignCenter().rowSpacer10();
        root.add(createPopoutButton());
        root.add(createViewLink());
        root.add(createName());
        root.add(createLabel());
    }

    //==================================================
    //= install :: fields
    //==================================================

    private ScControl createLabel()
    {
        ScTextSpan e;
        e = new ScTextSpan();
        e.css().label();
        e.hide();
        _labelText = e;
        return e;
    }

    private ScControl createName()
    {
        ScFieldText e;
        e = new ScFieldText();
        _nameText = e;
        return e;
    }

    private ScControl createViewLink()
    {
        ScLink e;
        e = new ScLink();
        e.setText("View");
        e.setAction(newCheckedAction(this::handleLink));
        _viewLink = e;
        return e;
    }

    private ScControl createPopoutButton()
    {
        ScScriptButton e;
        e = new ScScriptButton();
        e.clearScript(); // set in pre render
        e.setIcon().nameOpenInNew();
        e.setFlavorIcon();
        e.hide();
        _popoutButton = e;
        return e;
    }

    //##################################################
    //# accessing
    //##################################################

    public void setTargetFunction(Function<?,T> e)
    {
        _targetFunction = e;
    }

    //##################################################
    //# apply
    //##################################################

    @Override
    protected boolean applyFromModel_here(Object source)
    {
        if ( _targetFunction == null )
            return false;

        @SuppressWarnings("unchecked")
        Function<Object,T> fn = (Function<Object,T>)_targetFunction;

        T target = fn.apply(source);
        if ( target == null )
            return false;

        applyTarget(target);
        return false;
    }

    //==================================================
    //= apply :: info
    //==================================================

    public void applyTarget(T target)
    {
        if ( target == null )
        {
            hide();
            return;
        }

        String uid = target.getUid();
        String label = getLabelFor(target);
        String name = getNameFor(target);
        String help = getHelpFor(target);

        setLabel(label);
        _labelText.setValue(label);
        _nameText.setValue(name);
        _nameText.setHelp(help);
        _viewLink.setArgument(uid);

        ScOpenWindowScript popout = getPopoutScriptFor(target);
        if ( popout != null )
        {
            _popoutButton.show();
            _popoutButton.setScript(popout);
        }

        show();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleLink()
    {
        String uid = getData().getStringArgument();
        T e = findTargetFor(uid);

        if ( e == null )
        {
            ajaxToast("No info available.").error();
            return;
        }

        openLinkFor(e);
    }

    //##################################################
    //# text
    //##################################################

    protected abstract String getLabelFor(T e);

    protected abstract String getNameFor(T e);

    protected abstract String getHelpFor(T e);

    //##################################################
    //# find
    //##################################################

    protected abstract T findTargetFor(String uid);

    //##################################################
    //# view
    //##################################################

    protected abstract void openLinkFor(T e);

    //##################################################
    //# popout
    //##################################################

    private ScOpenWindowScript getPopoutScriptFor(T target)
    {
        String url = formatPopoutUrlFor(target);
        if ( url == null )
            return null;

        ScOpenWindowScript s;
        s = new ScOpenWindowScript();
        s.setUrl(url);
        return s;
    }

    protected abstract String formatPopoutUrlFor(T e);

    //##################################################
    //# support
    //##################################################

    protected MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }
}
