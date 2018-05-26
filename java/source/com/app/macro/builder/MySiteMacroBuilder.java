package com.app.macro.builder;

import com.app.macro.MyMacroDomainType;
import com.app.model.MySite;
import com.app.model.address.MyAddressVo;
import com.app.model.meta.MyMetaSite;

/**
 * I build the macros for a specific domain type.
 */
public class MySiteMacroBuilder
    extends MyAbstractMacroBuilder
{
    //##################################################
    //# setup
    //##################################################

    @Override
    protected MyMacroDomainType getDomainType()
    {
        return MyMacroDomainType.Site;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void addAll()
    {
        addSummary();
        addAddress();

        addSiteMainContact();
        addSiteInstallContact();
        addSiteSalesContact();
        addSiteSchedulingContact();
        addSiteRequesterContact();
        addSiteTechnicalContact();
    }

    private void addSummary()
    {
        MyMetaSite x = MySite.Meta;

        addText("Number", "001", x.Number);
        addText("Name", "North Gym", x.Name);
        addText("FullName", "001 - North Gym", x.FullName);
        addText("Type", "Gym", x.TypeName);
        addText("TimeZone", "US/Mountain", x.TimeZoneName);
        addText("PostalCode", "80237", x.AddressPostalCode);
    }

    private void addAddress()
    {
        MyMetaSite x = MySite.Meta;

        MyAddressVo addr = getSampleAddress();
        addText("AddressLongLine", addr.formatLongLine(), x.AddressLongLine);
        addText("AddressMultiLine", addr.formatMultiLine(), x.AddressMultiLine);
    }

    private void addSiteMainContact()
    {
        MyMetaSite x = MySite.Meta;
        String assoc = "MainContact";

        addText(assoc, "FullName", "Megan Main", x.MainContactFullName);
        addText(assoc, "ShortName", "Megan", x.MainContactShortName);
        addText(assoc, "Email", "megan@sample.com", x.MainContactEmail);
        addText(assoc, "Phone", "303-123-4567", x.MainContactPhone);
    }

    private void addSiteInstallContact()
    {
        MyMetaSite x = MySite.Meta;
        String assoc = "InstallContact";

        addText(assoc, "FullName", "Ivan Installer", x.EffectiveInstallContactFullName);
        addText(assoc, "ShortName", "Ivan", x.EffectiveInstallContactShortName);
        addText(assoc, "Email", "ivan@sample.com", x.EffectiveInstallContactEmail);
        addText(assoc, "Phone", "303-123-4567", x.EffectiveInstallContactPhone);
    }

    private void addSiteRequesterContact()
    {
        MyMetaSite x = MySite.Meta;
        String assoc = "RequesterContact";

        addText(assoc, "FullName", "Ray Requestor", x.EffectiveRequesterContactFullName);
        addText(assoc, "ShortName", "Ray", x.EffectiveRequesterContactShortName);
        addText(assoc, "Email", "ray@sample.com", x.EffectiveRequesterContactEmail);
        addText(assoc, "Phone", "303-123-4567", x.EffectiveRequesterContactPhone);
    }

    private void addSiteSalesContact()
    {
        MyMetaSite x = MySite.Meta;
        String assoc = "SalesContact";

        addText(assoc, "FullName", "Sue Salesman", x.EffectiveSalesContactFullName);
        addText(assoc, "ShortName", "Sue", x.EffectiveSalesContactShortName);
        addText(assoc, "Email", "sue@sample.com", x.EffectiveSalesContactEmail);
        addText(assoc, "Phone", "303-123-4567", x.EffectiveSalesContactPhone);
    }

    private void addSiteSchedulingContact()
    {
        MyMetaSite x = MySite.Meta;
        String assoc = "SchedulingContact";

        addText(assoc, "FullName", "Sally Scheduler", x.EffectiveSchedulingContactFullName);
        addText(assoc, "ShortName", "Sally", x.EffectiveSchedulingContactShortName);
        addText(assoc, "Email", "sally@sample.com", x.EffectiveSchedulingContactEmail);
        addText(assoc, "Phone", "303-123-4567", x.EffectiveSchedulingContactPhone);
    }

    private void addSiteTechnicalContact()
    {
        MyMetaSite x = MySite.Meta;
        String assoc = "TechnicalContact";

        addText(assoc, "FullName", "Terry Technician", x.EffectiveTechnicalContactFullName);
        addText(assoc, "ShortName", "Terry", x.EffectiveTechnicalContactShortName);
        addText(assoc, "Email", "terry@sample.com", x.EffectiveTechnicalContactEmail);
        addText(assoc, "Phone", "303-123-4567", x.EffectiveTechnicalContactPhone);
    }

}
