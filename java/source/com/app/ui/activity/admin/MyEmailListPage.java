package com.app.ui.activity.admin;

import com.kodemore.filter.KmFilter;
import com.kodemore.filter.KmFilterFactoryIF;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScButton;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFilterBox;
import com.kodemore.servlet.control.ScGrid;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScDateField;
import com.kodemore.servlet.field.ScDropdown;

import com.app.filter.MyEmailFilter;
import com.app.model.MyEmail;
import com.app.model.MyEmailStatus;
import com.app.model.meta.MyMetaEmail;

public class MyEmailListPage
    extends MyAbstractAdminPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyEmailListPage instance = new MyEmailListPage();

    private MyEmailListPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScFilterBox _filterBox;
    private ScDateField _createdStartField;
    private ScDateField _createdEndField;
    private ScDropdown  _statusField;

    private ScButton    _addButton;

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScPageRoot installRoot()
    {
        ScPageRoot root;
        root = newPageRoot();
        root.css().gap();

        addFilter(root);
        addGrid(root);
        addButtons(root);

        return root;
    }

    private void addFilter(ScContainer root)
    {
        _statusField = MyEmail.Tools.newStatusDropdown();
        _statusField.setLabel("Status");
        _statusField.addNullAnyPrefix();

        _createdStartField = new ScDateField();
        _createdStartField.setLabel("Created Start");

        _createdEndField = new ScDateField();
        _createdEndField.setLabel("Created End");

        _filterBox = root.addFilterBox();

        ScFieldTable fields;
        fields = _filterBox.addFields();
        fields.add(_statusField);
        fields.add(_createdStartField);
        fields.add(_createdEndField);
    }

    private void addGrid(ScContainer root)
    {
        MyMetaEmail x = MyEmail.Meta;

        ScGrid<MyEmail> grid;
        grid = new ScGrid<MyEmail>();
        grid.setFilterFactory(newFetcher());
        grid.trackAll(_filterBox);

        grid.addLinkColumn("View", newViewAction(), x.Uid);
        grid.addColumn(x.StatusName);
        grid.addColumn(x.CreatedLocalTsMessage).hide();
        grid.addColumn(x.SentLocalTsMessage);
        grid.addColumn(x.ToAddressesLabel);
        grid.addColumn(x.FromAddress);
        grid.addColumn(x.Subject);
        grid.addColumn(x.ErrorNotes);

        ScGroup group;
        group = root.addGroup("Emails");
        group.add(grid);
    }

    private void addButtons(ScContainer root)
    {
        ScBox buttons;
        buttons = root.addButtonBox();
        buttons.addButton("Resend All Pending", newResendAllPendingAction());
        buttons.addButton("Resend All Errors", newResendAllErrorsAction());

        _addButton = buttons.addButton("Add New", newAddAction());
        _addButton.hide();
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

    private ScActionIF newAddAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleAdd();
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

        for ( MyEmail e : f.getCursor() )
            e.markReady();

        //        print();
    }

    private void handleResendAllPending()
    {
        MyEmailFilter f;
        f = new MyEmailFilter();
        f.setStatusCode(MyEmailStatus.Pending);

        for ( MyEmail e : f.getCursor() )
            e.markReady();

        //        print();
    }

    private void handleAdd()
    {
        MyEmail e;
        e = new MyEmail();
        e.saveDao();

        //        MyEmailEditPage.instance.printEmail(e.getId());
    }

    private void handleView()
    {
        MyEmailViewPage.instance.startEmail(getStringArgument());
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

}
