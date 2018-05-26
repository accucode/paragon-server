package com.app.macro.builder;

import com.app.macro.MyMacroDomainType;
import com.app.model.MyCustomer;
import com.app.model.meta.MyMetaCustomer;

/**
 * I build the macros for a specific domain type.
 */
public class MyCustomerMacroBuilder
    extends MyAbstractMacroBuilder
{
    //##################################################
    //# setup
    //##################################################

    @Override
    protected MyMacroDomainType getDomainType()
    {
        return MyMacroDomainType.Customer;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void addAll()
    {
        addSummary();
        addApprovalContact();
        addBillingContact();
    }

    private void addSummary()
    {
        MyMetaCustomer x = MyCustomer.Meta;

        addText("Name", "Acme Inc", x.Name);
    }

    private void addApprovalContact()
    {
        MyMetaCustomer x = MyCustomer.Meta;
        String assoc = "ApprovalContact";

        addText(assoc, "FullName", "Andrew Approver", x.ApprovalContactFullName);
        addText(assoc, "ShortName", "Andrew", x.ApprovalContactShortName);
        addText(assoc, "Email", "andrew@sample.com", x.ApprovalContactEmail);
        addText(assoc, "Phone", "303-123-4567", x.ApprovalContactPhone);
    }

    private void addBillingContact()
    {
        MyMetaCustomer x = MyCustomer.Meta;
        String assoc = "BillingContact";

        addText(assoc, "FullName", "Bill Billing", x.BillingContactFullName);
        addText(assoc, "ShortName", "Bill", x.BillingContactShortName);
        addText(assoc, "Email", "bill@sample.com", x.BillingContactEmail);
        addText(assoc, "Phone", "303-123-4567", x.BillingContactPhone);
    }

}
