package com.app.model;

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

import com.app.criteria.MyAttachmentCriteria;
import com.app.criteria.MyNoteCriteria;
import com.app.criteria.MySiteCriteria;
import com.app.model.address.MyAddressDelegate;
import com.app.model.address.MyAddressIF;
import com.app.model.base.MyAttachmentOwnerType;
import com.app.model.base.MyCustomerBase;
import com.app.model.base.MyNoteOwnerType;
import com.app.model.support.MyPageDomainIF;
import com.app.model.transfer.MyTransferrableIF;
import com.app.model.transfer.detail.MyTransferCustomerDetail;
import com.app.ui.page.crud.customer.MyCustomerListPage;

public class MyCustomer
    extends MyCustomerBase
    implements MyTransferrableIF<MyCustomer>, MyPageDomainIF, MyNoteOwnerIF, MyAttachmentOwnerIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyCustomer()
    {
        super();
    }

    //##################################################
    //# context
    //##################################################

    @Override
    public MyTenant getTenant()
    {
        return getProject().getTenant();
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
    //# address
    //##################################################

    public MyAddressDelegate<MyCustomer> getBillingAddress()
    {
        return new MyAddressDelegate<>(
            this,
            Meta.BillingStreet1,
            Meta.BillingStreet2,
            Meta.BillingCity,
            Meta.BillingRegion,
            Meta.BillingPostalCode,
            Meta.BillingCountry,
            Meta.BillingAttention,
            Meta.BillingPhone);
    }

    public void setBillingAddress(MyAddressIF e)
    {
        getBillingAddress().applyFrom(e);
    }

    public boolean hasBillingAddress()
    {
        return getBillingAddress().hasValue();
    }

    public static KmAdaptorIF<MyCustomer,MyAddressIF> getBillingAddressAdaptor()
    {
        return new KmAdaptorIF<MyCustomer,MyAddressIF>()
        {
            @Override
            public void setValue(MyCustomer model, MyAddressIF value)
            {
                model.setBillingAddress(value);
            }

            @Override
            public MyAddressIF getValue(MyCustomer model)
            {
                return model.getBillingAddress();
            }
        };
    }

    @Override
    public String getBillingAddressShortLine()
    {
        return getBillingAddress().formatShortLine();
    }

    @Override
    public String getBillingAddressLongLine()
    {
        return getBillingAddress().formatLongLine();
    }

    @Override
    public String getBillingAddressMultiLine()
    {
        return getBillingAddress().formatMultiLine();
    }

    @Override
    public String getBillingAddressMultiLineHtml()
    {
        return getBillingAddress().formatMultiLineHtml();
    }

    //##################################################
    //# contact
    //##################################################

    public KmList<MyCustomerContact> getContactsByFullName()
    {
        return getContacts().toList(e -> Kmu.toLowerCase(e.getFullName()));
    }

    //##################################################
    //# sites
    //##################################################

    public KmList<MySite> getSites()
    {
        MySiteCriteria c;
        c = getAccess().getSiteDao().createCriteria();
        c.whereCustomerIs(this);
        return c.findAll();
    }

    //##################################################
    //# convenience
    //##################################################

    public KmList<MySite> getSitesByFullName()
    {
        KmList<MySite> v;
        v = getSites();
        v.sortOn(e -> e.getFullName());
        return v;
    }

    public KmList<MySite> getEnabledSitesByFullName()
    {
        return getSitesByFullName().select(e -> e.isEnabled());
    }

    //##################################################
    //# transfer
    //##################################################

    @Override
    public MyTransferCustomerDetail newTransferDetail()
    {
        return new MyTransferCustomerDetail(this);
    }

    //##################################################
    //# page
    //##################################################

    @Override
    public void ajaxEnterPage()
    {
        MyCustomerListPage.getInstance().ajaxEnterChild(this);
    }

    @Override
    public String formatEntryUrl()
    {
        return MyCustomerListPage.getInstance().formatEntryUrlFor(this);
    }

    //##################################################
    //# notes
    //##################################################

    @Override
    public MyNoteOwnerType getNoteOwnerType()
    {
        return MyNoteOwnerType.Customer;
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
        e.whereCustomerIs(this);
    }

    //##################################################
    //# attachments
    //##################################################

    @Override
    public MyAttachmentOwnerType getAttachmentOwnerType()
    {
        return MyAttachmentOwnerType.Customer;
    }

    @Override
    public void applyAttachmentOwnerTo(MyAttachment e)
    {
        e.setOwner(this);
    }

    @Override
    public void applyAttachmentOwnerTo(MyAttachmentCriteria e)
    {
        e.whereOwnerTypeIsCustomer();
        e.whereCustomerIs(this);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getAuditLogTitle()
    {
        return getName();
    }

    @Override
    public String getDomainTitle()
    {
        return getName();
    }

    @Override
    public String getDomainSubtitle()
    {
        KmList<String> v;
        v = new KmList<>();
        v.addNonNull(getBillingCity());
        v.addNonNull(getBillingRegion());
        return v.join();
    }

}
