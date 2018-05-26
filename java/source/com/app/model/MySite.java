package com.app.model;

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.collection.KmList;
import com.kodemore.time.KmTimeZone;
import com.kodemore.utility.Kmu;

import com.app.criteria.MyAttachmentCriteria;
import com.app.criteria.MyNoteCriteria;
import com.app.model.address.MyAddressDelegate;
import com.app.model.address.MyAddressIF;
import com.app.model.base.MyAttachmentOwnerType;
import com.app.model.base.MyBlurbOwnerType;
import com.app.model.base.MyEmailTemplateContextType;
import com.app.model.base.MyNoteOwnerType;
import com.app.model.base.MySiteBase;
import com.app.model.support.MyPageDomainIF;
import com.app.model.transfer.MyTransferrableIF;
import com.app.model.transfer.detail.MyTransferSiteDetail;
import com.app.ui.page.crud.site.MySiteListPage;

public class MySite
    extends MySiteBase
    implements MyTransferrableIF<MySite>, MyPageDomainIF, MyNoteOwnerIF, MyAttachmentOwnerIF,
    MyBlurbOwnerIF, MyEmailTemplateContextIF
{
    //##################################################
    //# constructor
    //##################################################

    public MySite()
    {
        super();
    }

    //##################################################
    //# domain
    //##################################################

    @Override
    public MyTenant getTenant()
    {
        return getProject().getTenant();
    }

    @Override
    public MyProject getProject()
    {
        return getCustomer().getProject();
    }

    //##################################################
    //# enabled
    //##################################################

    @Override
    public boolean isDomainEnabled()
    {
        return isEnabled();
    }

    @Override
    public String getEnabledStatus()
    {
        return Kmu.formatEnabled(getEnabled());
    }

    //##################################################
    //# name
    //##################################################

    @Override
    public void updateFullName()
    {
        String number = getNumber();
        String name = getName();

        if ( hasNumber() && hasName() )
            if ( name.startsWith(number) )
            {
                setFullName(name);
                return;
            }

        if ( !hasNumber() && !hasName() )
        {
            clearFullName();
            return;
        }

        KmList<String> v;
        v = new KmList<>();
        v.addNonNull(number);
        v.addNonNull(name);

        String fullName = v.join(" - ");
        setFullName(fullName);
    }

    //##################################################
    //# address
    //##################################################

    public MyAddressIF getAddress()
    {
        return getAddressDelegate();
    }

    public void setAddress(MyAddressIF e)
    {
        getAddressDelegate().applyFrom(e);
    }

    public boolean hasAddress()
    {
        return getAddressDelegate().hasValue();
    }

    private MyAddressDelegate<MySite> getAddressDelegate()
    {
        return new MyAddressDelegate<>(
            this,
            Meta.AddressStreet1,
            Meta.AddressStreet2,
            Meta.AddressCity,
            Meta.AddressRegion,
            Meta.AddressPostalCode,
            Meta.AddressCountry,
            Meta.AddressAttention,
            Meta.AddressPhone);
    }

    public static KmAdaptorIF<MySite,MyAddressIF> getAddressAdaptor()
    {
        return new KmAdaptorIF<MySite,MyAddressIF>()
        {
            @Override
            public void setValue(MySite model, MyAddressIF value)
            {
                model.setAddress(value);
            }

            @Override
            public MyAddressIF getValue(MySite model)
            {
                return model.getAddress();
            }
        };
    }

    @Override
    public String getAddressShortLine()
    {
        return getAddress().formatShortLine();
    }

    @Override
    public String getAddressLongLine()
    {
        return getAddress().formatLongLine();
    }

    @Override
    public String getAddressMultiLine()
    {
        return getAddress().formatMultiLine();
    }

    //##################################################
    //# timezone
    //##################################################

    public KmTimeZone getTimeZone()
    {
        return KmTimeZone.findCode(getTimeZoneCode());
    }

    public void setTimeZone(KmTimeZone e)
    {
        setTimeZoneCode(KmTimeZone.getCodeFor(e));
    }

    public boolean hasTimeZone()
    {
        return getTimeZone() != null;
    }

    @Override
    public String getTimeZoneName()
    {
        return hasTimeZone()
            ? getTimeZone().getName()
            : null;
    }

    //##################################################
    //# priority
    //##################################################

    @Override
    public String getPriorityName()
    {
        return hasPriority()
            ? getPriority().getName()
            : null;
    }

    //##################################################
    //# contacts
    //##################################################

    public KmList<MySiteContact> getContactsByFullName()
    {
        return getContacts().toList(e -> e.getFullName());
    }

    public MySiteContact getContactFor(MyContactType type)
    {
        switch ( type )
        {
            case Main:
                return getMainContact();

            case Install:
                return getInstallContact();

            case Requester:
                return getRequesterContact();

            case Sales:
                return getSalesContact();

            case Scheduling:
                return getSchedulingContact();

            case Technical:
                return getTechnicalContact();

            case EffectiveInstall:
                return getEffectiveInstallContact();

            case EffectiveRequester:
                return getEffectiveRequesterContact();

            case EffectiveSales:
                return getEffectiveSalesContact();

            case EffectiveScheduling:
                return getEffectiveSchedulingContact();

            case EffectiveTechnical:
                return getEffectiveTechnicalContact();
        }
        throw Kmu.newEnumError(type);
    }

    @Override
    public MySiteContact getEffectiveInstallContact()
    {
        return hasInstallContact()
            ? getInstallContact()
            : getMainContact();
    }

    @Override
    public MySiteContact getEffectiveTechnicalContact()
    {
        return hasTechnicalContact()
            ? getTechnicalContact()
            : getMainContact();
    }

    @Override
    public MySiteContact getEffectiveSchedulingContact()
    {
        return hasSchedulingContact()
            ? getSchedulingContact()
            : getMainContact();
    }

    @Override
    public MySiteContact getEffectiveSalesContact()
    {
        return hasSalesContact()
            ? getSalesContact()
            : getMainContact();
    }

    @Override
    public MySiteContact getEffectiveRequesterContact()
    {
        return hasRequesterContact()
            ? getRequesterContact()
            : getMainContact();
    }

    //##################################################
    //# transfer
    //##################################################

    @Override
    public MyTransferSiteDetail newTransferDetail()
    {
        return new MyTransferSiteDetail(this);
    }

    //##################################################
    //# page
    //##################################################

    @Override
    public void ajaxEnterPage()
    {
        MySiteListPage.getInstance().ajaxEnterChild(this);
    }

    @Override
    public String formatEntryUrl()
    {
        return MySiteListPage.getInstance().formatEntryUrlFor(this);
    }

    //##################################################
    //# notes
    //##################################################

    @Override
    public MyNoteOwnerType getNoteOwnerType()
    {
        return MyNoteOwnerType.Site;
    }

    @Override
    public void applyNoteOwnerTo(MyNote e)
    {
        e.setOwner(this);
    }

    @Override
    public void applyNoteOwnerTo(MyNoteCriteria e)
    {
        e.whereOwnerTypeIs(getNoteOwnerType());
        e.whereSiteIs(this);
    }

    //##################################################
    //# attachments
    //##################################################

    @Override
    public MyAttachmentOwnerType getAttachmentOwnerType()
    {
        return MyAttachmentOwnerType.Site;
    }

    @Override
    public void applyAttachmentOwnerTo(MyAttachment e)
    {
        e.setOwner(this);
    }

    @Override
    public void applyAttachmentOwnerTo(MyAttachmentCriteria e)
    {
        e.whereOwnerTypeIsSite();
        e.whereSiteIs(this);
    }

    //##################################################
    //# blubs
    //##################################################

    @Override
    public MyBlurbOwnerType getBlurbOwnerType()
    {
        return MyBlurbOwnerType.Site;
    }

    //##################################################
    //# email
    //##################################################

    @Override
    public MyEmailTemplateContextType getEmailTemplateContextType()
    {
        return MyEmailTemplateContextType.Site;
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getAuditLogTitle()
    {
        return getFullName();
    }

    @Override
    public String getDomainTitle()
    {
        return getFullName();
    }

    @Override
    public String getDomainSubtitle()
    {
        return getAddressShortLine();
    }

}
