package com.app.ui.page.test;

import com.kodemore.intacct.KmIntacctConnection;
import com.kodemore.intacct.KmIntacctGetList;
import com.kodemore.intacct.KmIntacctGetListObject;
import com.kodemore.intacct.KmIntacctRequest;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScErrorWrapper;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScCheckboxField;
import com.kodemore.servlet.field.ScEnumDropdownField;
import com.kodemore.servlet.field.ScTextArea;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.Kmu;

import com.app.model.MyTenant;
import com.app.property.MyProperties;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyIntacctTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyIntacctTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyIntacctTestPage();
    }

    public static MyIntacctTestPage getInstance()
    {
        return _instance;
    }

    private MyIntacctTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScTextField         _senderIdField;
    private ScTextField         _senderPasswordField;

    private ScTextField         _controlIdField;
    private ScCheckboxField     _uniqueIdField;

    private ScTextField         _companyIdField;
    private ScTextField         _userIdField;
    private ScTextField         _userPasswordField;

    private ScEnumDropdownField _getListField;

    private ScTextArea          _requestField;
    private ScTextArea          _responseField;

    //##################################################
    //# settings
    //##################################################

    @Override
    public final MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.developer;
    }

    //##################################################
    //# bookmark
    //##################################################

    @Override
    public void composeBookmarkOn(ScParameterList v)
    {
        // none
    }

    @Override
    public void applyBookmark(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        ScForm form;
        form = root.addForm();
        form.css().fill().flexColumn().columnSpacer20();

        installSetupOn(form);
        installRequestResponseOn(form);
    }

    private void installRequestResponseOn(ScContainer root)
    {
        ScDiv row;
        row = root.addFlexRow();
        row.css().rowSpacer20().flexChildFiller();

        installRequestOn(row);
        installResponseOn(row);
    }

    //==================================================
    //= install :: setup
    //==================================================

    private void installSetupOn(ScContainer root)
    {
        ScGroup group;
        group = root.addGroup("Samples");

        ScDiv body;
        body = group.getBody();
        body.css().flexRow().rowSpacer20().pad20();

        installWebServiceFieldsOn(body);
        installControlFieldsOn(body);
        installCompanyFieldsOn(body);

        ScDiv footer;
        footer = group.showFooter();
        footer.css().flexRow().flexCrossAlignCenter().buttonBox();
        footer.addTextSpan("Get List...").css().bold();
        footer.add(createGetListField());

        ScActionButton button;
        button = footer.addButton("basic", newUncheckedAction(this::handleBasicSample));
        button.setHelp(""
            + "Use 'get_list' to fetch a single object of the type requested. "
            + "This sample should be valid as-is, and can be used to list the "
            + "available fields for an object.");

        button = footer.addButton("advanced", newUncheckedAction(this::handleAdvancedSample));
        button.setHelp(""
            + "Use 'get_list' to fetch a batch of the type requested. This sample "
            + "includes fake fields, filters, and sorts. The sample must be manually "
            + "edited before posting to Intacct.");
    }

    private void installWebServiceFieldsOn(ScDiv body)
    {
        ScFieldset set;
        set = body.addFieldset("Web Service");

        ScFieldTable fields;
        fields = set.addFieldTable();
        fields.add(createSenderIdField());
        fields.add(createSenderPasswordField());
    }

    private void installControlFieldsOn(ScDiv body)
    {
        ScFieldset set;
        set = body.addFieldset("Control");

        ScFieldTable fields;
        fields = set.addFieldTable();
        fields.add(createControlIdField());
        fields.add(createUniqueIdField());
    }

    private void installCompanyFieldsOn(ScDiv body)
    {
        ScFieldset set;
        set = body.addFieldset("Company");

        ScFieldTable fields;
        fields = set.addFieldTable();
        fields.add(createCompanyIdField());
        fields.add(createUserIdField());
        fields.add(createUserPasswordField());
    }

    //==================================================
    //= install :: fields
    //==================================================

    private ScControl createSenderIdField()
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel("Sender");
        e.setHelp("Used to connect to Web Services, does NOT connect to a company.");
        e.setRequired();
        _senderIdField = e;
        return e;
    }

    private ScControl createSenderPasswordField()
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel("Password");
        e.setHelp("Used to connect to Web Services, does NOT connect to a company.");
        e.setRequired();
        _senderPasswordField = e;
        return e;
    }

    private ScControl createControlIdField()
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel("Control ID");
        e.setHelp("Used by Intacct to identify the request and prevent duplicates.");
        e.setValue("test");
        e.setRequired();
        _controlIdField = e;
        return e;
    }

    private ScControl createUniqueIdField()
    {
        ScCheckboxField e;
        e = new ScCheckboxField();
        e.setLabel("Unique");
        e.setHelp(""
            + "If checked, Intacct will allow duplicate Control IDs. "
            + "This is safe for requests that do NOT modify any data such as get_list.");
        e.setValue(false);
        _uniqueIdField = e;
        return e;
    }

    private ScControl createCompanyIdField()
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel("Company");
        e.setHelp("The specific company to be accessed.");
        e.setRequired();
        _companyIdField = e;
        return e;
    }

    private ScControl createUserIdField()
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel("User");
        e.setHelp("The user to log in as, this determines your access and permissions.");
        e.setRequired();
        _userIdField = e;
        return e;
    }

    private ScControl createUserPasswordField()
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel("Password");
        e.setHelp("The user's password.");
        e.setRequired();
        _userPasswordField = e;
        return e;
    }

    private ScControl createGetListField()
    {
        ScEnumDropdownField e;
        e = new ScEnumDropdownField();
        e.setOptions(KmIntacctGetListObject.values());
        e.setNullPrefix("<Get List>");
        _getListField = e;

        ScErrorWrapper w;
        w = new ScErrorWrapper();
        w.setChild(e);
        return w;
    }

    //==================================================
    //= install :: request
    //==================================================

    private void installRequestOn(ScDiv root)
    {
        ScGroup group;
        group = root.addGroup("Request");
        group.css().flexChildFiller();

        ScDiv header;
        header = group.showHeader();
        header.css().flexRow().flexAlignEnd().buttonBox();
        header.addButton("RUN =>", newUncheckedAction(this::handleRun));

        group.getBody().add(createRequestField());
    }

    private ScTextArea createRequestField()
    {
        ScTextArea e;
        e = new ScTextArea();
        e.layoutFill();
        e.disableSpellCheck();
        _requestField = e;
        return e;
    }

    //==================================================
    //= install :: response
    //==================================================

    private void installResponseOn(ScDiv root)
    {
        ScGroup group;
        group = root.addGroup("Response");
        group.css().flexChildFiller();

        ScDiv header;
        header = group.showHeader();
        header.css().flexRow().flexAlignEnd().buttonBox();
        header.addButton("Clear", newUncheckedAction(this::handleClearResponse));

        group.getBody().add(createResponseField());
    }

    private ScTextArea createResponseField()
    {
        ScTextArea e;
        e = new ScTextArea();
        e.layoutFill();
        e.disableSpellCheck();
        _responseField = e;
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        MyProperties properties = getProperties();
        _senderIdField.setValue(properties.getIntacctSenderId());
        _senderPasswordField.setValue(properties.getIntacctSenderPassword());

        MyTenant tenant = getCurrentTenant();
        _companyIdField.setValue(tenant.getIntacctCompanyId());
        _userIdField.setValue(tenant.getIntacctUserId());
        _userPasswordField.setValue(tenant.getIntacctUserPassword());
    }

    //##################################################
    //# handle
    //##################################################

    private void handleBasicSample()
    {
        KmIntacctGetListObject obj = getSelectedGetListObject();
        KmIntacctRequest req = createBasicGetListRequest(obj);
        String xml = req.composeXml();

        _requestField.ajaxSetFieldValue(xml);
        ajaxToast("Updated sample request.");
    }

    private void handleAdvancedSample()
    {
        KmIntacctGetListObject obj = getSelectedGetListObject();
        KmIntacctRequest req = createAdvancedGetListRequest(obj);
        String xml = req.composeXml();

        _requestField.ajaxSetFieldValue(xml);
        ajaxToast("Updated sample request.");
    }

    private void handleRun()
    {
        String in = _requestField.getValue();
        if ( Kmu.isEmpty(in) )
            _requestField.error("Required.");

        String req = _requestField.getValue();

        KmIntacctConnection con;
        con = new KmIntacctConnection();
        con.setHttpRequestForXml(req);
        con.send();

        String res = con.getXmlResponse();
        _responseField.ajaxSetFieldValue(res);

        ajaxToast("Success");
    }

    private void handleClearResponse()
    {
        _responseField.ajaxClearFieldValue();
    }

    //##################################################
    //# support
    //##################################################

    private KmIntacctGetListObject getSelectedGetListObject()
    {
        ScEnumDropdownField field = _getListField;

        if ( !field.hasValue() )
            field.error("Select an object");

        String code = field.getValue();
        return KmIntacctGetListObject.valueOf(code);
    }

    private KmIntacctRequest createBasicGetListRequest(KmIntacctGetListObject obj)
    {
        KmIntacctGetList action;
        action = createBasicGetList(obj);

        KmIntacctRequest req;
        req = createIntacctRequest();
        req.addFunction(action);
        return req;
    }

    private KmIntacctRequest createAdvancedGetListRequest(KmIntacctGetListObject obj)
    {
        KmIntacctGetList action;
        action = createAdvancedGetList(obj);

        KmIntacctRequest req;
        req = createIntacctRequest();
        req.addFunction(action);
        return req;
    }

    private KmIntacctGetList createBasicGetList(KmIntacctGetListObject obj)
    {
        KmIntacctGetList e;
        e = new KmIntacctGetList();
        e.setObject(obj);
        e.setIndex(0);
        e.setCount(1);
        e.setShowsPrivate(true);
        return e;
    }

    private KmIntacctGetList createAdvancedGetList(KmIntacctGetListObject obj)
    {
        KmIntacctGetList e;
        e = createBasicGetList(obj);
        e.selectField("field1");
        e.selectField("field2");
        e.selectField("field3");
        e.where("field4").isGreaterThan("100");
        e.where("field5").isLessThan("200");
        e.sortOn("field6");
        e.sortOn("field7").descending();
        return e;
    }

    private KmIntacctRequest createIntacctRequest()
    {
        ajax().hideAllErrors();
        validate();

        KmIntacctRequest e;
        e = new KmIntacctRequest();
        e.setSenderId(_senderIdField.getValue());
        e.setSenderPassword(_senderPasswordField.getValue());
        e.setControlId(_controlIdField.getValue());
        e.setControlIdUnique(_uniqueIdField.isChecked());
        e.setCompanyId(_companyIdField.getValue());
        e.setUserId(_userIdField.getValue());
        e.setUserPassword(_userPasswordField.getValue());
        return e;
    }

}
