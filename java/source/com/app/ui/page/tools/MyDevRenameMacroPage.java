package com.app.ui.page.tools;

import org.apache.commons.lang.StringUtils;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScParagraph;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.Kmu;

import com.app.model.MyBlurb;
import com.app.model.MyEmailTemplate;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyDevRenameMacroPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyDevRenameMacroPage _instance;

    public static void installInstance()
    {
        _instance = new MyDevRenameMacroPage();
    }

    public static MyDevRenameMacroPage getInstance()
    {
        return _instance;
    }

    private MyDevRenameMacroPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScGroup     _findGroup;
    private ScTextField _findField;

    private ScGroup     _renameGroup;
    private ScTextField _fromField;
    private ScTextField _toField;

    //##################################################
    //# settings
    //##################################################

    @Override
    public final MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.developer;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().fill().auto();

        ScForm form;
        form = root.addForm();
        form.css().flexColumn().columnSpacer20();
        form.add(createWarning());
        form.add(createInfo());
        form.add(createCountGroup());
        form.add(createRenameMacroGroup());
        form.add(createRenameListGroup());
    }

    private ScControl createWarning()
    {
        String msg = ""
            + "WARNING, the tool on this page will cause significant changes to the "
            + "database. This tool may change the value of ALL Blurbs, Email "
            + "Templates, and Task Step Items in the database.";

        ScParagraph e;
        e = new ScParagraph();
        e.addText(msg);
        e.css().boxRed().pad();
        return e;
    }

    private ScControl createInfo()
    {
        String msg = ""
            + "NOTE, In the fields below, you may enter either the token/key, or the "
            + "full macro. In other words both 'JobNumber' and '$(JobNumber) will work "
            + "the same way. If the $() is missing it will automatically be added. ";

        ScParagraph e;
        e = new ScParagraph();
        e.addText(msg);
        e.css().boxGreen().pad();
        return e;
    }

    //==================================================
    //= install :: count
    //==================================================

    private ScControl createCountGroup()
    {
        ScGroup group;
        group = new ScGroup();
        group.setTitle("Find Macro Count");

        installCountBodyOn(group);
        installCountFooterOn(group);

        _findGroup = group;
        return group;
    }

    private void installCountBodyOn(ScGroup group)
    {
        ScDiv body;
        body = group.getBody();
        body.css().pad10();
        body.addText("The the number of times a macro is used.");

        ScFieldTable fields;
        fields = body.addFieldTable();
        fields.add(createFindField());
    }

    private ScTextField createFindField()
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel("Find");
        e.setHelp("The macro to be counted.");
        e.disableChangeTracking();
        e.setRequired();
        _findField = e;
        return e;
    }

    private void installCountFooterOn(ScGroup group)
    {
        ScDiv footer;
        footer = group.showFooter();
        footer.css().buttonBox();
        footer.add(createCountButton());
    }

    private ScActionButton createCountButton()
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setText("Find Count");
        e.setAction(newCheckedAction(this::handleFindCount));
        return e;
    }

    //==================================================
    //= install :: rename single
    //==================================================

    private ScControl createRenameMacroGroup()
    {
        ScGroup group;
        group = new ScGroup();
        group.setTitle("Rename Macro");

        ScDiv body;
        body = group.getBody();
        body.css().pad10().columnSpacer20();
        body.addText("Rename a single macro.");
        body.add(createRenameMacroFields());

        ScDiv footer;
        footer = group.showFooter();
        footer.css().buttonBox();
        footer.add(createRenameButton());

        _renameGroup = group;
        return group;
    }

    private ScControl createRenameMacroFields()
    {
        ScFieldTable fields;
        fields = new ScFieldTable();
        fields.add(createFromField());
        fields.add(createToField());
        return fields;
    }

    private ScTextField createFromField()
    {
        ScTextField e = new ScTextField();
        e.setLabel("From");
        e.setHelp("The macro to search for.");
        e.disableChangeTracking();
        e.setRequired();
        _fromField = e;
        return e;
    }

    private ScTextField createToField()
    {
        ScTextField e = new ScTextField();
        e.setLabel("To");
        e.setHelp("The new value to replace it with.");
        e.disableChangeTracking();
        e.setRequired();
        _toField = e;
        return e;
    }

    private ScActionButton createRenameButton()
    {
        ScAction action;
        action = newCheckedAction(this::handleRename);
        action.disableSlowCommandWarning();

        ScActionButton e;
        e = new ScActionButton();
        e.setText("Rename Macro");
        e.setConfirmationMessageHtml("This will change ALL matching macros. Continue?");
        e.setAction(action);
        return e;
    }

    //==================================================
    //= install :: rename list
    //==================================================

    private ScControl createRenameListGroup()
    {
        ScGroup group;
        group = new ScGroup();
        group.setTitle("Rename ALL Macros");

        ScDiv body;
        body = group.getBody();
        body.css().pad10();
        body.addText("Rename all macros from the pre-specified list.");

        ScDiv footer;
        footer = group.showFooter();
        footer.css().buttonBox();
        footer.add(createRenameSalesOrderToJobButton());
        footer.add(createRenameJobToSalesOrderButton());

        return group;
    }

    private ScActionButton createRenameSalesOrderToJobButton()
    {
        ScAction action;
        action = newCheckedAction(this::handleSalesOrderToJob);
        action.disableSlowCommandWarning();

        ScActionButton e;
        e = new ScActionButton();
        e.setText("Rename ALL, Sales Order => Job");
        e.setConfirmationMessageHtml("Rename ALL sales order macros?");
        e.setAction(action);
        return e;
    }

    private ScActionButton createRenameJobToSalesOrderButton()
    {
        ScAction action;
        action = newCheckedAction(this::handleJobToSalesOrder);
        action.disableSlowCommandWarning();

        ScActionButton e;
        e = new ScActionButton();
        e.setText("Rename ALL, Job => Sales Order");
        e.setConfirmationMessageHtml("Rename ALL Job macros?");
        e.setAction(action);
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        // none
    }

    //##################################################
    //# handle
    //##################################################

    private void handleFindCount()
    {
        _findGroup.validateAndCheck();

        String macro = formatMacro(_findField.getValue());
        int count = countAll(macro);

        String msg = Kmu.format("Found %s occurrences of %s.", count, macro);
        ajax().toast(msg).sticky();
    }

    private void handleRename()
    {
        _renameGroup.validateAndCheck();

        String from = formatMacro(_fromField.getValue());
        String to = formatMacro(_toField.getValue());

        KmMap<String,String> macroMap = toMacroMap(from, to);
        renameAll(macroMap);

        String msg = Kmu.format("All macro tokens matching %s have been changed to %s.", from, to);
        ajax().toast(msg);
    }

    private void handleSalesOrderToJob()
    {
        KmMap<String,String> macroMap = getSalesOrderToJobMap();
        renameAll(macroMap);

        String msg = Kmu.format("Changes sales order macros to job.");
        ajax().toast(msg);
    }

    private void handleJobToSalesOrder()
    {
        KmMap<String,String> macroMap = getJobToSalesOrderMap();
        renameAll(macroMap);

        String msg = Kmu.format("Changes job macros to sales order.");
        ajax().toast(msg);
    }

    //##################################################
    //# count
    //##################################################

    private int countAll(String macro)
    {
        int n = 0;
        n += countInBlurbs(macro);
        n += countInEmails(macro);
        return n;
    }

    private int countInBlurbs(String macro)
    {
        KmList<MyBlurb> v = getAccess().getBlurbDao().findAll();
        return v.sumInt(e -> countMatches(e.getMessageHtml(), macro));
    }

    private int countInEmails(String macro)
    {
        KmList<MyEmailTemplate> v = getAccess().getEmailTemplateDao().findAll();
        int subjectCount = v.sumInt(e -> countMatches(e.getSubjectText(), macro));
        int bodyCount = v.sumInt(e -> countMatches(e.getBodyHtml(), macro));
        return subjectCount + bodyCount;
    }

    private int countMatches(String source, String macro)
    {
        return Kmu.isEmpty(source)
            ? 0
            : StringUtils.countMatches(source, macro);
    }

    //##################################################
    //# rename
    //##################################################

    private void renameAll(KmMap<String,String> macroMap)
    {
        renameAllInBlurbs(macroMap);
        renameAllInEmails(macroMap);
    }

    private void renameAllInBlurbs(KmMap<String,String> macroMap)
    {
        KmList<MyBlurb> v = getAccess().getBlurbDao().findAll();
        for ( MyBlurb blurb : v )
        {
            String content;
            content = blurb.getMessageHtml();
            content = Kmu.replaceAll(content, macroMap);
            blurb.setMessageHtml(content);
        }
    }

    private void renameAllInEmails(KmMap<String,String> macroMap)
    {
        KmList<MyEmailTemplate> v = getAccess().getEmailTemplateDao().findAll();
        for ( MyEmailTemplate email : v )
        {
            String subject;
            subject = email.getSubjectText();
            subject = Kmu.replaceAll(subject, macroMap);
            email.setSubjectText(subject);

            String body;
            body = email.getBodyHtml();
            body = Kmu.replaceAll(body, macroMap);
            email.setBodyHtml(body);
        }
    }

    //##################################################
    //# support
    //##################################################

    private String formatMacro(String s)
    {
        String prefix = "$(";
        String suffix = ")";

        boolean hasPrefix = s.startsWith(prefix);
        boolean hasSuffix = s.endsWith(suffix);

        return hasPrefix && hasSuffix
            ? s
            : prefix + s + suffix;
    }

    private KmMap<String,String> toMacroMap(String from, String to)
    {
        KmMap<String,String> map;
        map = new KmMap<>();
        map.put(from, to);
        return map;
    }

    //##################################################
    //# job to so
    //##################################################

    private KmMap<String,String> getSalesOrderToJobMap()
    {
        return getJobMacros("SalesOrder", "Job");
    }

    private KmMap<String,String> getJobToSalesOrderMap()
    {
        return getJobMacros("Job", "SalesOrder");
    }

    private KmMap<String,String> getJobMacros(String fromPrefix, String toPrefix)
    {
        return getJobKeySuffixes().toMap(
            suffix -> formatMacro(fromPrefix + suffix),
            suffix -> formatMacro(toPrefix + suffix));
    }

    private KmList<String> getJobKeySuffixes()
    {
        return KmList.createStrings(
            "CustomerName",
            "DeliverBy",
            "InstallBy",
            "InstallContactEmail",
            "InstallContactFullName",
            "InstallContactPhone",
            "InstallContactShortName",
            "InstallType",
            "LineExtendedPrice",
            "LineOrderedQuantity",
            "LineProductName",
            "LineTax",
            "LineUnitPrice",
            "MainContactEmail",
            "MainContactFullName",
            "MainContactPhone",
            "MainContactShortName",
            "Number",
            "PurchaseOrderNumber",
            "RecentShippedTrackingNumbers",
            "Region",
            "RequesterContactEmail",
            "RequesterContactFullName",
            "RequesterContactPhone",
            "RequesterContactShortName",
            "SalesContactEmail",
            "SalesContactFullName",
            "SalesContactPhone",
            "SalesContactShortName",
            "SchedulingContactEmail",
            "SchedulingContactFullName",
            "SchedulingContactPhone",
            "SchedulingContactShortName",
            "ShippedTrackingNumbers",
            "ShippingAddressLongLine",
            "ShippingAddressMultiLine",
            "SiteAddressLongLine",
            "SiteAddressMultiLine",
            "SiteCableRunLength",
            "SiteCeilingHeight",
            "SiteFullName",
            "SiteName",
            "SiteNumber",
            "SiteType",
            "Status",
            "TechnicalContactEmail",
            "TechnicalContactFullName",
            "TechnicalContactPhone",
            "TechnicalContactShortName",
            "ViewLink");
    }
}
