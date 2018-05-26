package com.app.ui.page.crud.projectOption.core;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScDomainNotebook;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.layout.ScLayout;

import com.app.model.MyChoice;
import com.app.model.meta.MyMetaChoice;
import com.app.ui.dialog.MyConfirmDialog;
import com.app.ui.dialog.MyDialogs;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;

public class MyChoiceViewCard
    extends MyCrudViewCard<MyChoice>
{
    //##################################################
    //# variables
    //##################################################

    private ScAction _confirmedDisableAction;
    private ScAction _confirmedClearDefaultAction;

    //##################################################
    //# constructor
    //##################################################

    public MyChoiceViewCard(MyChoiceBuilder e)
    {
        super(e);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installBodyOn(ScDiv body)
    {
        detachBody();
        body.add(createNotebook());

        _confirmedDisableAction = newCheckedAction(this::handleConfirmedDisable);
        _confirmedClearDefaultAction = newCheckedAction(this::handleConfirmedClearDefault);
    }

    private ScDomainNotebook<MyChoice> createNotebook()
    {
        ScDomainNotebook<MyChoice> e;
        e = new ScDomainNotebook<>();
        e.css().fill();
        e.setFinder(MyChoice.Finder);
        e.add(createDetailTab());
        return e;
    }

    private ScControl createDetailTab()
    {
        ScGroup e;
        e = new ScGroup();
        e.setNotebookTab("Option", "Details");
        e.getBody().add(createDetailLayout());
        return e;
    }

    private ScControl createDetailLayout()
    {
        ScLayout e;
        e = new ScLayout();
        e.setTypeFieldset();
        e.css().fill().auto();
        e.add(createGeneralSection());
        return e;
    }

    private ScControl createGeneralSection()
    {
        MyMetaChoice x = MyChoice.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("General");
        e.addFieldText(x.Name);
        e.add(createDefaultRow());
        e.add(createEnabledRow());
        return e;
    }

    private ScControl createDefaultRow()
    {
        MyMetaChoice x = MyChoice.Meta;

        ScDiv e;
        e = new ScDiv();
        e.css().flexRow().rowSpacer5().flexCrossAlignCenter();
        e.setLabel(x.DefaultValue);
        e.addFieldText(x.DefaultValue);
        e.addLink("toggle", newCheckedAction(this::handleToggleDefault));
        return e;
    }

    private ScControl createEnabledRow()
    {
        MyMetaChoice x = MyChoice.Meta;

        ScDiv e;
        e = new ScDiv();
        e.css().flexRow().rowSpacer5().flexCrossAlignCenter();
        e.setLabel(x.EnabledStatus);
        e.addFieldText(x.EnabledStatus);
        e.addLink("toggle", newCheckedAction(this::handleToggleEnabled));
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRenderDetails(MyChoice option)
    {
        super.preRenderDetails(option);
    }

    //##################################################
    //# handle :: toggle enabled
    //##################################################

    private void handleToggleEnabled()
    {
        MyChoice e = getDomainChild();

        if ( e.isEnabled() )
            checkDisable(e);
        else
            ajaxUpdateEnabled(e, true);
    }

    private void checkDisable(MyChoice e)
    {
        if ( e.isDefaultValue() )
            confirmDisable();
        else
            ajaxUpdateEnabled(e, false);
    }

    private void confirmDisable()
    {
        MyConfirmDialog e;
        e = MyDialogs.getConfirmDialog();
        e.setTitle("Disable Default?");
        e.setSubtitle("Disable the default option?");
        e.setMessage("If disabled, there will no longer be a default.");
        e.setPositiveText("Disable");
        e.setPositiveAction(_confirmedDisableAction);
        e.ajaxOpen();
    }

    private void handleConfirmedDisable()
    {
        MyChoice e = getDomainChild();
        ajaxUpdateEnabled(e, false);
    }

    private void ajaxUpdateEnabled(MyChoice e, boolean enabled)
    {
        e.setEnabled(enabled);

        if ( !enabled )
            e.setDefaultValue(false);

        ajaxReplace();
        fireChildChanged(e);
    }

    //##################################################
    //# handle :: toggle enabled
    //##################################################

    private void handleToggleDefault()
    {
        MyChoice e = getDomainChild();

        if ( e.isDefaultValue() )
            checkClearDefault();
        else
            ajaxUpdateDefault(e, true);
    }

    private void checkClearDefault()
    {
        MyConfirmDialog e;
        e = MyDialogs.getConfirmDialog();
        e.setTitle("No Default?");
        e.setSubtitle("There will no longer be a default.");
        e.setMessage(
            ""
                + "Clearing the default is not recommended. "
                + "It is usually preferred to choose another option as the new default.");
        e.setPositiveText("No Default");
        e.setPositiveAction(_confirmedClearDefaultAction);
        e.ajaxOpen();
    }

    private void handleConfirmedClearDefault()
    {
        MyChoice e = getDomainChild();

        ajaxUpdateDefault(e, false);
    }

    private void ajaxUpdateDefault(MyChoice e, boolean def)
    {
        getAccess().getChoiceDao().setDefaultValue(e, def);
        ajaxReplace();
        fireChildChanged(e);
    }

}
