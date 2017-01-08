package com.app.ui.page.manage.tenant;

import com.kodemore.intacct.KmIntacctConnection;
import com.kodemore.intacct.KmIntacctGetList;
import com.kodemore.intacct.KmIntacctGetListObject;
import com.kodemore.intacct.KmIntacctRequest;
import com.kodemore.intacct.KmIntacctResponse;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScNotebook;

import com.app.model.MyTenant;
import com.app.model.meta.MyMetaTenant;
import com.app.ui.control.MyNotifyDialog;
import com.app.ui.page.manage.crud.MyCrudLayout;
import com.app.ui.page.manage.crud.MyCrudViewCard;
import com.app.ui.page.manage.user.MyUserManageView;

public class MyTenantViewCard
    extends MyCrudViewCard<MyTenant>
{
    //##################################################
    //# constructor
    //##################################################

    public MyTenantViewCard()
    {
        super(new MyTenantBuilder());
    }

    public MyTenantViewCard(MyTenantBuilder e)
    {
        super(e);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected MyCrudLayout getDetailLayout()
    {
        return MyCrudLayout.fill;
    }

    @Override
    protected void installDetailsOn(ScDiv root)
    {
        ScNotebook book;
        book = root.addNotebook();
        book.flexFill();

        ScDiv tab;
        tab = book.addDiv();
        tab.setLabel("Details");
        installDetailsTabOn(tab);

        tab = book.add(new MyUserManageView());
        tab.setLabel("Users");
        tab.css().flexChildFiller();
    }

    private void installDetailsTabOn(ScContainer root)
    {
        ScGroup group;
        group = root.addGroup("Tenant Details");
        group.setFlavorSecondary();
        group.css().fill();

        ScDiv body;
        body = group.getBody();
        body.css().gap20();

        installGeneralOn(body);
        installIntacctOn(body);
    }

    private void installGeneralOn(ScDiv root)
    {
        MyMetaTenant x = MyTenant.Meta;

        ScFieldset set;
        set = root.addFieldset("General");

        ScFieldTable fields;
        fields = set.addFieldTable();
        fields.addFieldText(x.Name);
        fields.addFieldText(x.Hostname);
        fields.addFieldText(x.ThemeName);
    }

    private void installIntacctOn(ScDiv root)
    {
        MyMetaTenant x = MyTenant.Meta;

        ScFieldset set;
        set = root.addFieldset("Intacct");

        ScDiv row;
        row = set.addFlexRow();
        row.css().flexAlignSpaced();

        ScFieldTable fields;
        fields = row.addFieldTable();
        fields.disableFullWidth();
        fields.addFieldText(x.IntacctCompanyId, "Company");
        fields.addFieldText(x.IntacctUserId, "User");
        fields.addFieldText(x.IntacctUserPassword, "Password");

        ScDiv buttons;
        buttons = row.addButtonBox5();

        ScActionButton button;
        button = buttons.addButton("Test", this::handleIntacctTest);
        button.setHelp(""
            + "Perform basic connectivity testing in order to confirm that "
            + "we can access your company with the credentials provided.");
    }

    //##################################################
    //# handle
    //##################################################

    private void handleIntacctTest()
    {
        MyTenant tenant = getDomainChild();

        if ( !tenant.hasIntacctConfiguration() )
        {
            ajaxOpenMissingIntacctConfigurationMessage();
            return;
        }

        KmIntacctGetList action;
        action = new KmIntacctGetList();
        action.setObject(KmIntacctGetListObject.contact);
        action.setCount(1);
        action.setShowsPrivate(true);

        KmIntacctRequest req;
        req = tenant.createIntacctRequest();
        req.addFunction(action);
        req.ignoreControlId();

        KmIntacctConnection con = req.send();
        KmIntacctResponse result = con.getResponse();

        if ( result.isOk() )
            ajaxOpenIntacctSuccessMessage();
        else
            ajaxOpenIntacctErrorMessage(result);
    }

    //##################################################
    //# support
    //##################################################

    private void ajaxOpenMissingIntacctConfigurationMessage()
    {
        String msg = ""
            + "In order to test the Intacct connection, you must first "
            + "configure the Intacct company, user, and password. For a "
            + "short term test, you can use your own personal credentials. "
            + "However, for long term integration it is recommended that "
            + "you configure a permanent 'xml_gateway' user.";

        MyNotifyDialog e;
        e = getGlobalNotifyDialog();
        e.setTitle("Cannot Test Intacct");
        e.setSubtitle("Configure connection before testing.");
        e.setMessage(msg);
        e.ajaxOpen();
    }

    private void ajaxOpenIntacctSuccessMessage()
    {
        String msg = ""
            + "We were successfully able to connect to your Intacct company "
            + "and confirmed limited access.";

        MyNotifyDialog e;
        e = getGlobalNotifyDialog();
        e.setTitle("Intacct Connection - Success!");
        e.setSubtitle("Successful connection to Intacct.");
        e.setMessage(msg);
        e.ajaxOpen();
    }

    private void ajaxOpenIntacctErrorMessage(KmIntacctResponse result)
    {
        String msg = ""
            + "An error occurred while attempting to connect to your Intacct "
            + "company. The most common problem is that your companyId, userId, "
            + "or password is correct. Also, you must ensure that the user provided "
            + "has permissions to read the various business objects in Intacct such "
            + "as sales orders, customers, contacts, etc.\n"
            + "\n"
            + "Intacct response..."
            + "\n\n"
            + result.getStatusSummary()
            + "\n\n"
            + result.formatErrorLines();

        MyNotifyDialog e;
        e = getGlobalNotifyDialog();
        e.setTitle("Intacct Connection - Error!");
        e.setSubtitle("The connection test to Intacct failed.");
        e.setMessage(msg.trim());
        e.ajaxOpen();
    }

}
