package com.app.model;

import com.kodemore.collection.KmList;
import com.kodemore.string.KmStringBuilder;

import com.app.model.base.MyCustomerContactBase;
import com.app.model.core.MyProjectDomainIF;
import com.app.model.support.MyPersonNameUtility;
import com.app.model.transfer.MyTransferrableIF;
import com.app.model.transfer.detail.MyTransferCustomerContactDetail;

public class MyCustomerContact
    extends MyCustomerContactBase
    implements MyProjectDomainIF, MyContactIF, MyTransferrableIF<MyCustomerContact>
{
    //##################################################
    //# constructor
    //##################################################

    public MyCustomerContact()
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

    @Override
    public MyProject getProject()
    {
        return getCustomer().getProject();
    }

    //##################################################
    //# role
    //##################################################

    @Override
    public Boolean getApprovalContact()
    {
        return getCustomer().hasApprovalContact(this);
    }

    @Override
    public Boolean getBillingContact()
    {
        return getCustomer().hasBillingContact(this);
    }

    //##################################################
    //# name
    //##################################################

    @Override
    public void updateFullName()
    {
        String s = MyPersonNameUtility.getFullName(this);
        setFullName(s);
        truncateFullName();
    }

    @Override
    public String getFormalName()
    {
        return MyPersonNameUtility.getFormalName(this);
    }

    @Override
    public String getShortName()
    {
        return MyPersonNameUtility.getShortName(this);
    }

    @Override
    public String getLongName()
    {
        return MyPersonNameUtility.getLongName(this);
    }

    //##################################################
    //# message
    //##################################################

    @Override
    public String getSummaryMultiline()
    {
        KmStringBuilder out;
        out = new KmStringBuilder();

        out.print(getFullName());

        if ( hasPhone() )
        {
            out.println();
            out.print(getPhone());
        }

        if ( hasEmail() )
        {
            out.println();
            out.print(getEmail());
        }

        return out.toString();
    }

    public String getRolesMessage()
    {
        KmList<String> v;
        v = new KmList<>();

        if ( getCustomer().hasApprovalContact(this) )
            v.add("Approval");

        if ( getCustomer().hasBillingContact(this) )
            v.add("Billing");

        return v.join();
    }

    //##################################################
    //# transfer
    //##################################################

    @Override
    public MyTransferCustomerContactDetail newTransferDetail()
    {
        return new MyTransferCustomerContactDetail(this);
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
        return getRolesMessage();
    }

}
