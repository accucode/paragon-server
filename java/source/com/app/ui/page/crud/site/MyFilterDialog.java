package com.app.ui.page.crud.site;

import java.util.function.Consumer;

import com.kodemore.collection.KmCollection;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScNotebook;
import com.kodemore.servlet.field.ScHiddenField;
import com.kodemore.utility.Kmu;

import com.app.filter.core.MyLoadableFilterIF;
import com.app.model.MyFilterTemplate;
import com.app.model.meta.MyMetaFilterTemplate;
import com.app.ui.control.MyFormDialog;
import com.app.ui.control.MySummaryView;

public abstract class MyFilterDialog<F extends MyLoadableFilterIF<?>>
    extends MyFormDialog
{
    //##################################################
    //# variables
    //##################################################

    private ScHiddenField<String>           _templateJsonField;
    private MySummaryView<MyFilterTemplate> _summaryView;
    private ScNotebook                      _book;
    private Consumer<MyFilterTemplate>      _applyListener;

    //##################################################
    //# constructor
    //##################################################

    public MyFilterDialog()
    {
        super();
        install();
    }

    //##################################################
    //# install
    //##################################################

    protected void install()
    {
        onSubmit(newUncheckedAction(this::handleApply));

        installHeader();
        installBody();
        installFooter();
    }

    //==================================================
    //= install :: header
    //==================================================

    private void installHeader()
    {
        ScDiv header;
        header = showHeader();
        header.add(createTemplateJsonField());
        header.add(createSummaryView());
    }

    private ScControl createTemplateJsonField()
    {
        ScHiddenField<String> e;
        e = new ScHiddenField<>();
        e.disableChangeTracking();
        _templateJsonField = e;
        return e;
    }

    private ScControl createSummaryView()
    {
        MyMetaFilterTemplate x = MyFilterTemplate.Meta;

        MySummaryView<MyFilterTemplate> e;
        e = new MySummaryView<>();
        e.setTitle(x.DomainTitle);
        e.setSubtitle(x.DomainSubtitle);
        _summaryView = e;
        return e;
    }

    //==================================================
    //= install :: body
    //==================================================

    private void installBody()
    {
        ScDiv body;
        body = getBody();
        body.css().relative();
        body.add(createNotebook());
    }

    protected ScControl createNotebook()
    {
        ScNotebook book;
        book = new ScNotebook();
        book.css().fillOffset10();
        book.setFlavorWide();
        book.onTabChanging(this::handleTabChanging);
        book.onTabPreRender(this::handleTabPreRender);
        _book = book;

        installNotebook(book);

        return book;
    }

    protected abstract void installNotebook(ScNotebook book);

    //==================================================
    //= install :: footer
    //==================================================

    private void installFooter()
    {
        ScDiv footer;
        footer = showFooter();
        footer.css().flexRow().flexAlignSpaced();

        ScDiv buttons;
        buttons = footer.addButtonBox();
        buttons.addSubmitButton("Apply");
        buttons.addCancelButton(newUncheckedAction(this::handleCancel));
    }

    //##################################################
    //# listener
    //##################################################

    public void onApply(Consumer<MyFilterTemplate> e)
    {
        _applyListener = e;
    }

    public void fireApply(MyFilterTemplate e)
    {
        fire(_applyListener, e);
    }

    //##################################################
    //# open
    //##################################################

    public void ajaxOpen(MyFilterTemplate template)
    {
        _templateJsonField.setValue(template.toJson());
        ajaxOpen();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        preRenderSummary();
    }

    private void preRenderSummary()
    {
        MyFilterTemplate template = getDetachedTemplate();
        _summaryView.applyFromModel(template);
    }

    protected abstract void preRenderTab(ScControl tab);

    //##################################################
    //# handle
    //##################################################

    /**
     * @param newTab the tab that is about to be selected, not used.
     */
    private boolean handleTabChanging(ScControl newTab)
    {
        saveCurrentTab();
        return true;
    }

    private void handleTabPreRender(ScControl tab)
    {
        preRenderTab(tab);
    }

    private void handleApply()
    {
        saveCurrentTab();

        MyFilterTemplate e = apply();
        getAccess().flush();
        ajaxClose();

        fireApply(e);
    }

    private void handleCancel()
    {
        ajaxClose();
    }

    //##################################################
    //# template
    //##################################################

    public MyFilterTemplate getAttachedTemplate()
    {
        String uid = getDetachedTemplate().getUid();
        return getAccess().findFilterTemplateUid(uid);
    }

    protected MyFilterTemplate getDetachedTemplate()
    {
        String json = _templateJsonField.getValue();

        MyFilterTemplate e;
        e = new MyFilterTemplate();
        e.fromJson(json, true);
        return e;
    }

    protected void saveDetachedTemplate(MyFilterTemplate template)
    {
        String json = template.toJson();

        _templateJsonField.setValue(json);
        _templateJsonField.ajaxUpdateValue();
    }

    //##################################################
    //# support
    //##################################################

    protected abstract F createFilter();

    protected ScControl getSelectedTab()
    {
        return _book.getSelectedTab();
    }

    protected ScGroup createTab(String title)
    {
        ScGroup group;
        group = new ScGroup();
        group.setNotebookTab(title);

        ScDiv body;
        body = group.getBody();
        body.css().pad10().auto();

        return group;
    }

    private void saveCurrentTab()
    {
        MyFilterTemplate detached;
        detached = getDetachedTemplate();

        F filter;
        filter = createFilter();
        filter.loadFromTemplate(detached);

        ScControl oldTab = _book.getSelectedTab();
        saveTabTo(oldTab, filter);

        filter.saveToTemplate(detached);
        saveDetachedTemplate(detached);
    }

    protected abstract void saveTabTo(ScControl tab, F filter);

    private MyFilterTemplate apply()
    {
        MyFilterTemplate detached = getDetachedTemplate();
        MyFilterTemplate attached = getAttachedTemplate();

        if ( isSame(detached, attached) )
            return attached;

        if ( detached.isModified() )
        {
            attached.applyFrom(detached, false);
            attached.validateAndCheck();
            return attached;
        }

        MyFilterTemplate e;
        e = new MyFilterTemplate();
        e.applyFrom(detached, false);
        e.setModified(true);
        e.setPreferred(false);
        e.daoAttach();
        return e;
    }

    private boolean isSame(MyFilterTemplate detached, MyFilterTemplate attached)
    {
        KmCollection<String> detachedCodes = detached.getUsedAttributeCodes();
        KmCollection<String> attachedCodes = attached.getUsedAttributeCodes();

        boolean sameCodes = detachedCodes.containsSame(attachedCodes);
        if ( !sameCodes )
            return false;

        for ( String code : detachedCodes )
        {
            String detachedValue = detached.getItem(code).getValue();
            String attachedValue = attached.getItem(code).getValue();

            boolean sameValue = Kmu.isEqual(detachedValue, attachedValue);
            if ( !sameValue )
                return false;
        }

        return true;
    }
}
