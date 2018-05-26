package com.app.ui.page.crud.blurb;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScDomainNotebook;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScLiteral;
import com.kodemore.servlet.control.layout.ScLayout;

import com.app.model.MyBlurb;
import com.app.model.meta.MyMetaBlurb;
import com.app.ui.page.crud.abstractBase.MyCrudViewNotebookCard;

public class MyBlurbViewCard
    extends MyCrudViewNotebookCard<MyBlurb>
{
    //##################################################
    //# constructor
    //##################################################

    public MyBlurbViewCard()
    {
        super(new MyBlurbBuilder());
    }

    public MyBlurbViewCard(MyBlurbBuilder e)
    {
        super(e);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installNotebookTabs()
    {
        ScDomainNotebook<MyBlurb> e;
        e = getNotebook();
        e.add(createDetailsTab());
        e.add(createPreviewTab());
    }

    //==================================================
    //= install :: details tab
    //==================================================

    private ScControl createDetailsTab()
    {
        ScLayout e;
        e = new ScLayout();
        e.setTypeFieldset();
        e.css().fill().auto();
        e.add(createGeneralSection());
        e.add(createTemplateSection());
        return e.inNotebookTab("Blurb", "Details");
    }

    private ScControl createGeneralSection()
    {
        MyMetaBlurb x = MyBlurb.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("General");
        e.addFieldText(x.Name);
        e.addFieldText(x.OwnerTypeName, "Type");
        e.add(createActiveRow());
        return e;
    }

    private ScControl createActiveRow()
    {
        MyMetaBlurb x = MyBlurb.Meta;

        ScDiv e;
        e = new ScDiv();
        e.css().flexRow().rowSpacer5().flexCrossAlignCenter();
        e.setLabel("Active");
        e.addFieldText(x.EnabledStatus);
        e.addLink("toggle", newCheckedAction(this::handleToggleActive));
        return e;
    }

    private ScControl createTemplateSection()
    {
        MyMetaBlurb x = MyBlurb.Meta;

        ScLiteral e;
        e = new ScLiteral();
        e.setLabel("Template");
        e.setValue(x.MessageHtml);
        return e;
    }

    //==================================================
    //= install :: preview tab
    //==================================================

    private ScControl createPreviewTab()
    {
        ScGroup e;
        e = new ScGroup();
        e.setNotebookTab("Preview");
        e.setFlavorDetail();
        e.css().fill();
        e.getBody().add(createPreviewLayout());
        return e;
    }

    private ScControl createPreviewLayout()
    {
        ScLayout e;
        e = new ScLayout();
        e.setTypeFieldset();
        e.css().fill().auto();
        e.add(createPreviewSection());
        return e;
    }

    private ScControl createPreviewSection()
    {
        MyMetaBlurb x = MyBlurb.Meta;

        ScLiteral e;
        e = new ScLiteral();
        e.setLabel("Preview");
        e.setValue(x.SampleMessageHtml);
        return e;
    }

    //##################################################
    //# handle
    //##################################################

    private void handleToggleActive()
    {
        MyBlurb blurb;
        blurb = getDomainChild();
        blurb.toggleEnabled();
        blurb.validateAndCheck();

        ajaxReplace();
        fireChildChanged(blurb);
    }
}
