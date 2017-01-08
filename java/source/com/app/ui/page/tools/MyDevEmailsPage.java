package com.app.ui.page.tools;

import com.kodemore.filter.KmFilter;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScCard;
import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFilterBox;
import com.kodemore.servlet.control.ScGrid;
import com.kodemore.servlet.control.ScGridColumn;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScDateField;
import com.kodemore.servlet.field.ScDropdownField;
import com.kodemore.servlet.variable.ScLocalString;

import com.app.filter.MyEmailFilter;
import com.app.model.MyEmail;
import com.app.model.base.MyEmailStatus;
import com.app.model.meta.MyMetaEmail;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyDevEmailsPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyDevEmailsPage _instance;

    public static void installInstance()
    {
        _instance = new MyDevEmailsPage();
    }

    public static MyDevEmailsPage getInstance()
    {
        return _instance;
    }

    private MyDevEmailsPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScLocalString           _emailUid;

    private ScFilterBox             _filterBox;
    private ScDateField             _createdStartField;
    private ScDateField             _createdEndField;
    private ScDropdownField<String> _statusField;

    private ScGrid<MyEmail>         _grid;

    private ScCardFrame             _emailFrame;
    private ScCard                  _emailViewCard;

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
        _emailUid = new ScLocalString();
        _emailUid.setAutoSave();

        root.css().fill().flexColumn().columnSpacer10();
        installFilterOn(root);

        ScDiv row;
        row = root.addFlexRow();
        row.css().flexChildFiller().rowSpacer10();

        installGridOn(row);
        installFrameOn(row);
    }

    private void installFilterOn(ScContainer root)
    {
        _statusField = MyEmail.Tools.newStatusDropdown();
        _statusField.setLabel("Status");
        _statusField.setNullAnyPrefix();
        _statusField.disableChangeTracking();

        _createdStartField = new ScDateField();
        _createdStartField.setLabel("Created Start");
        _createdStartField.disableChangeTracking();

        _createdEndField = new ScDateField();
        _createdEndField.setLabel("Created End");
        _createdEndField.disableChangeTracking();

        _filterBox = root.addFilterBox("Search");
        _filterBox.getFormWrapper().css().flexChildStatic();

        ScFieldTable fields;
        fields = _filterBox.addFieldTable();
        fields.add(_statusField);
        fields.add(_createdStartField);
        fields.add(_createdEndField);
    }

    private void installGridOn(ScContainer root)
    {
        MyMetaEmail x = MyEmail.Meta;

        ScGroup group;
        group = root.addGroup("Results");
        group.css().flexChildFiller0();

        ScDiv body;
        body = group.getBody();

        _grid = body.addGrid();
        _grid.layoutFill();
        _grid.setFilterFactory(this::getFilter);
        _grid.trackAll(_filterBox);

        ScGridColumn<MyEmail> link;
        link = _grid.addLinkColumn("View", this::handleView, MyEmail::getUid);
        link.setWidth(50);

        _grid.addColumn(x.StatusName, 50);
        _grid.addColumn(x.Subject);
        _grid.addColumn(x.ToAddressesLabel);
        _grid.addColumn(x.SentLocalTsMessage);

        ScDiv footer;
        footer = group.getFooter();
        footer.show();

        ScDiv buttons;
        buttons = footer.addButtonBox();
        buttons.addButton("Resend All Pending", this::handleResendAllPending);
        buttons.addButton("Resend All Errors", this::handleResendAllErrors);
    }

    //==================================================
    //= install :: frame
    //==================================================

    private void installFrameOn(ScContainer root)
    {
        MyMetaEmail x = MyEmail.Meta;

        _emailFrame = root.addCardFrame();
        _emailFrame.css().flexChildFiller0().relative();

        _emailViewCard = _emailFrame.addCard();
        _emailViewCard.css().fill();

        ScGroup group;
        group = _emailViewCard.addGroup("Email");
        group.css().fill();
        group.bodyCss().pad();

        ScDiv body;
        body = group.getBody();

        ScFieldTable fields;
        fields = body.addFieldTable();
        fields.addFieldText(x.Subject);
        fields.addFieldText(x.ToAddressesLabel);
        fields.addFieldText(x.CcAddressesLabel);
        fields.addSpace();
        fields.addFieldText(x.Uid);
        fields.addFieldText(x.CreatedLocalTsMessage);
        fields.addFieldText(x.FromAddress);
        fields.addSpace();
        fields.addFieldText(x.StatusName);
        fields.addFieldText(x.SentLocalTsMessage);
        fields.addFieldText(x.ErrorNotes);

        body.addBreak();
        body.addLiteral(x.PartsAsHtml);

        ScDiv footer;
        footer = group.getFooter();
        footer.show();

        ScDiv buttons;
        buttons = footer.addButtonBox();
        buttons.addButton("Re-Send", this::handleResend, x.Uid);
        buttons.addButton("Ignore", this::handleIgnore, x.Uid);
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        // none
    }

    //##################################################
    //# handle
    //##################################################

    private void handleResendAllErrors()
    {
        MyEmailFilter f;
        f = new MyEmailFilter();
        f.setStatusCode(MyEmailStatus.Error);

        for ( MyEmail e : f )
            e.markReady();

        refresh();
    }

    private void handleResendAllPending()
    {
        MyEmailFilter f;
        f = new MyEmailFilter();
        f.setStatusCode(MyEmailStatus.Pending);

        for ( MyEmail e : f )
            e.markReady();

        refresh();
    }

    private void handleView()
    {
        String uid = getStringArgument();
        _emailUid.setValue(uid);

        refresh();
    }

    private void handleResend()
    {
        MyEmail e = getEmail();

        if ( e != null )
            e.markReady();

        refresh();
    }

    private void handleIgnore()
    {
        MyEmail e = getEmail();

        if ( e != null )
            e.markIgnored();

        refresh();
    }

    //##################################################
    //# support
    //##################################################

    private KmFilter<MyEmail> getFilter()
    {
        MyEmailFilter f;
        f = new MyEmailFilter();

        if ( _createdStartField.hasValue() )
            f.setCreatedStartDate(_createdStartField.getValue());

        if ( _createdEndField.hasValue() )
            f.setCreatedEndDate(_createdEndField.getValue());

        if ( _statusField.hasValue() )
            f.setStatusCode(_statusField.getValue());

        f.sortOnCreatedUtcTs();
        f.sortDescending();
        return f;
    }

    private void refresh()
    {
        _grid.ajaxReload();

        MyEmail email = getEmail();
        if ( email == null )
        {
            _emailFrame.ajaxClose();
            return;
        }

        _emailViewCard.applyFromModel(email);
        _emailViewCard.ajaxPrintCard();
    }

    private MyEmail getEmail()
    {
        String uid = _emailUid.getValue();
        return getAccess().findEmailUid(uid);
    }
}
