package com.app.ui.page.tools;

import com.kodemore.filter.KmFilter;
import com.kodemore.filter.KmFilterFactoryIF;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBorderLayout;
import com.kodemore.servlet.control.ScBox;
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
import com.kodemore.servlet.field.ScDropdown;
import com.kodemore.servlet.variable.ScLocalString;

import com.app.filter.MyEmailFilter;
import com.app.model.MyEmail;
import com.app.model.MyEmailStatus;
import com.app.model.meta.MyMetaEmail;
import com.app.ui.page.admin.MyAbstractAdminEntryPage;

public class MyDevEmailsPage
    extends MyAbstractAdminEntryPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyDevEmailsPage instance = new MyDevEmailsPage();

    private MyDevEmailsPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScLocalString   _emailUid;

    private ScFilterBox     _filterBox;
    private ScDateField     _createdStartField;
    private ScDateField     _createdEndField;
    private ScDropdown      _statusField;

    private ScGrid<MyEmail> _grid;

    private ScCardFrame     _emailFrame;
    private ScCard          _emailViewCard;

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        _emailUid = new ScLocalString();
        _emailUid.setAutoSave();

        ScBorderLayout layout;
        layout = root.addBorderLayout();
        layout.pad();

        ScDiv top = layout.addTop(200);
        layout.padTop();

        ScDiv left = layout.addLeft(500);
        ScDiv center = layout.addCenter();

        installFilter(top);
        installGrid(left);
        installFrame(center);
    }

    private void installFilter(ScContainer root)
    {
        _statusField = MyEmail.Tools.newStatusDropdown();
        _statusField.setLabel("Status");
        _statusField.addNullAnyPrefix();

        _createdStartField = new ScDateField();
        _createdStartField.setLabel("Created Start");

        _createdEndField = new ScDateField();
        _createdEndField.setLabel("Created End");

        _filterBox = root.addFilterBox("Emails");
        _filterBox.layoutFill();

        ScFieldTable fields;
        fields = _filterBox.addFields();
        fields.add(_statusField);
        fields.add(_createdStartField);
        fields.add(_createdEndField);
    }

    private void installGrid(ScContainer root)
    {
        MyMetaEmail x = MyEmail.Meta;

        ScGrid<MyEmail> grid;
        grid = new ScGrid<MyEmail>();
        grid.layoutFill();
        grid.setFilterFactory(newFetcher());
        grid.trackAll(_filterBox);

        ScGridColumn<MyEmail> link;
        link = grid.addLinkColumn("View", newViewAction(), x.Uid);
        link.setWidth(50);

        grid.addColumn(x.StatusName, 50);
        grid.addColumn(x.Subject);
        grid.addColumn(x.ToAddressesLabel);
        grid.addColumn(x.SentLocalTsMessage);

        ScGroup group;
        group = root.addGroup("Results");
        group.layoutFillWithButtonFooter();
        group.add(grid);

        ScBox buttons;
        buttons = group.getFooter().addButtonBoxLeft();
        buttons.addButton("Resend All Pending", newResendAllPendingAction());
        buttons.addButton("Resend All Errors", newResendAllErrorsAction());

        _grid = grid;
    }

    private KmFilterFactoryIF<MyEmail> newFetcher()
    {
        return new KmFilterFactoryIF<MyEmail>()
        {
            @Override
            public KmFilter<MyEmail> createFilter()
            {
                return getFilter();
            }
        };
    }

    //##################################################
    //# frame
    //##################################################

    private void installFrame(ScContainer root)
    {
        MyMetaEmail x = MyEmail.Meta;

        _emailFrame = root.addFrame();
        _emailFrame.css().fill();

        _emailViewCard = _emailFrame.addCard();
        _emailViewCard.css().fill();

        ScGroup group;
        group = _emailViewCard.addGroup("Email");
        group.layoutFillWithButtonFooter();
        group.css().leftOffset();
        group.bodyCss().pad();

        ScFieldTable fields;
        fields = group.addFields();
        fields.addText(x.Subject);
        fields.addText(x.ToAddressesLabel);
        fields.addText(x.CcAddressesLabel);
        fields.addSpace();
        fields.addText(x.Uid);
        fields.addText(x.CreatedLocalTsMessage);
        fields.addText(x.FromAddress);
        fields.addSpace();
        fields.addText(x.StatusName);
        fields.addText(x.SentLocalTsMessage);
        fields.addText(x.ErrorNotes);

        group.addBreak();
        group.addLiteral(x.PartsAsHtml);

        ScBox buttons;
        buttons = group.getFooter().addButtonBox();
        buttons.addButton("Re-Send", newResendAction(), x.Uid);
        buttons.addButton("Ignore", newIgnoreAction(), x.Uid);
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newViewAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleView();
            }
        };
    }

    private ScActionIF newResendAllPendingAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleResendAllPending();
            }
        };
    }

    private ScActionIF newResendAllErrorsAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleResendAllErrors();
            }
        };
    }

    private ScActionIF newResendAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleResend();
            }
        };
    }

    private ScActionIF newIgnoreAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleIgnore();
            }
        };
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
        ajax().updatePageSession();
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
            f.setStatusCode(_statusField.getStringValue());

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
        _emailViewCard.ajaxPrint();
    }

    private MyEmail getEmail()
    {
        String uid = _emailUid.getValue();
        return getAccess().findEmailUid(uid);
    }
}