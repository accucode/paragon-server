package com.app.ui.page.crud.appFeedback;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScDomainNotebook;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldText;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.layout.ScLayout;

import com.app.model.MyFeedback;
import com.app.model.base.MyFeedbackStatus;
import com.app.model.meta.MyMetaFeedback;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;

public class MyFeedbackViewCard
    extends MyCrudViewCard<MyFeedback>
{
    //##################################################
    //# variables
    //##################################################

    private MyFeedbackCloseDialog _dialog;

    //##################################################
    //# constructor
    //##################################################

    public MyFeedbackViewCard()
    {
        super(new MyFeedbackBuilder());
    }

    public MyFeedbackViewCard(MyFeedbackBuilder e)
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

        installDialog();
    }

    //==================================================
    //= install :: dialog
    //==================================================

    private void installDialog()
    {
        _dialog = new MyFeedbackCloseDialog();
        _dialog.onClosed(this::fireChildChanged);
    }

    //==================================================
    //= install :: notebook
    //==================================================

    private ScControl createNotebook()
    {
        ScDomainNotebook<MyFeedback> e;
        e = new ScDomainNotebook<>();
        e.css().fill();
        e.setFinder(MyFeedback.Finder);
        e.add(createDetailsTab());
        return e;
    }

    //==================================================
    //= notebook :: details tab
    //==================================================

    private ScControl createDetailsTab()
    {
        ScGroup group;
        group = new ScGroup();
        group.setNotebookTab("Feedback", "Details");
        group.showHeader().add(createButtons());
        group.getBody().add(createGroupBody());
        return group;
    }

    private ScControl createButtons()
    {
        ScDiv e;
        e = new ScDiv();
        e.css().flexRow().rowSpacer5().pad10().flexAlignEnd();
        e.addButton("Resolve", newUncheckedAction(this::handleResolve));
        e.addButton("Drop", newUncheckedAction(this::handleDrop));
        return e;
    }

    private ScControl createGroupBody()
    {
        ScLayout e;
        e = new ScLayout();
        e.setTypeFieldset();
        e.css().fill().auto();
        e.add(createGeneralSection());
        e.add(createDescriptionSection());
        e.add(createDetailsSection());
        e.add(createResolutionSection());
        return e;
    }

    private ScControl createGeneralSection()
    {
        MyMetaFeedback x = MyFeedback.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("General");
        e.addFieldText(x.TypeName);
        e.addFieldText(x.StatusName);
        e.addFieldText(x.CreatedByFullName, "Submitted By");
        e.addSpace();
        e.addFieldText(x.TenantName);
        e.addFieldText(x.ProjectName);
        e.addFieldText(x.PageName);
        return e;
    }

    private ScControl createDescriptionSection()
    {
        MyMetaFeedback x = MyFeedback.Meta;

        ScFieldText e;
        e = new ScFieldText();
        e.setValue(x.Description);
        e.setHelp(x.Description);
        e.setLabel(x.Description);
        return e;
    }

    private ScControl createDetailsSection()
    {
        MyMetaFeedback x = MyFeedback.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("Details");
        e.addFieldText(x.PageKey);
        e.addFieldText(x.WindowLocation);
        e.addFieldText(x.RequestUrl);
        e.addFieldText(x.QueryString);
        return e;
    }

    private ScControl createResolutionSection()
    {
        MyMetaFeedback x = MyFeedback.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("Resolution");
        e.addFieldText(x.ClosedByFullName);
        e.addFieldText(x.ClosedDate);
        e.addFieldText(x.Notes);
        return e;
    }

    //##################################################
    //# handle
    //##################################################

    private void handleResolve()
    {
        openCloseDialogFor(MyFeedbackStatus.Resolved);
    }

    private void handleDrop()
    {
        openCloseDialogFor(MyFeedbackStatus.Dropped);
    }

    //##################################################
    //# support
    //##################################################

    private void openCloseDialogFor(MyFeedbackStatus e)
    {
        _dialog.ajaxOpen(getDomainChild(), e);
    }
}
