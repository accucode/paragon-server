package com.app.ui.page.crud.siteContact;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.layout.ScLayout;

import com.app.model.MySiteContact;
import com.app.model.meta.MyMetaSiteContact;
import com.app.ui.info.MyRelatedInfoSection;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;

public class MySiteContactViewCard
    extends MyCrudViewCard<MySiteContact>
{
    //##################################################
    //# variables
    //##################################################

    private ScFieldTable _roleSection;

    //##################################################
    //# constructor
    //##################################################

    public MySiteContactViewCard()
    {
        super(new MySiteContactBuilder());
    }

    public MySiteContactViewCard(MySiteContactBuilder e)
    {
        super(e);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installBodyOn(ScDiv body)
    {
        body.add(createDetailLayout());
    }

    private ScControl createDetailLayout()
    {
        ScLayout e;
        e = new ScLayout();
        e.setTypeFieldset();
        e.css().fill().auto();
        e.add(createGeneralSection());
        e.add(createRelatedSection());
        e.add(createRoleSection());
        return e;
    }

    private ScControl createGeneralSection()
    {
        MyMetaSiteContact x = MySiteContact.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("General");
        e.addFieldText(x.FullName);
        e.addFieldText(x.Title);
        e.addFieldText(x.Phone);
        e.addFieldText(x.Email);
        e.addSpace();
        e.addFieldText(x.EnabledStatus);
        return e;
    }

    private ScControl createRelatedSection()
    {
        MyMetaSiteContact x = MySiteContact.Meta;

        MyRelatedInfoSection e;
        e = new MyRelatedInfoSection();
        e.addSiteInfo(x.Site);
        return e;
    }

    private ScControl createRoleSection()
    {
        MyMetaSiteContact x = MySiteContact.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("Is Primary For");
        e.addFieldText(x.MainContact, "Main");
        e.addSpace();
        e.addFieldText(x.EffectiveInstallContact, "Install");
        e.addFieldText(x.EffectiveTechnicalContact, "Technical");
        e.addFieldText(x.EffectiveSchedulingContact, "Scheduling");
        e.addFieldText(x.EffectiveSalesContact, "Sales");
        e.addFieldText(x.EffectiveRequesterContact, "Requester");
        e.hide();
        _roleSection = e;
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRenderDetails(MySiteContact contact)
    {
        super.preRenderDetails(contact);

        if ( contact.isEnabled() )
            _roleSection.show();
    }
}
