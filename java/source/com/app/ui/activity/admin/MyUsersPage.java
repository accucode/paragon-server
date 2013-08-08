package com.app.ui.activity.admin;

import com.kodemore.filter.KmFilter;
import com.kodemore.filter.KmFilterFactoryIF;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScArray;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFilterBox;
import com.kodemore.servlet.control.ScGrid;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScTextField;

import com.app.filter.MyUserFilter;
import com.app.model.MyUser;
import com.app.model.meta.MyMetaUser;
import com.app.utility.MyButtonUrls;

public class MyUsersPage
    extends MyAbstractAdminPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyUsersPage instance = new MyUsersPage();

    private MyUsersPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScFilterBox    _filterBox;
    private ScTextField    _searchField;

    private ScGrid<MyUser> _grid;

    private MyUserFrame    _frame;

    //##################################################
    //# install
    //##################################################

    @Override
    public String getName()
    {
        return "Users";
    }

    @Override
    protected ScPageRoot installRoot()
    {
        ScPageRoot root;
        root = newPageRoot();
        root.css().padSpaced();

        installFilter(root);

        ScArray row;
        row = root.addRow();

        installGrid(row);
        installFrame(row);

        return root;
    }

    private void installFilter(ScContainer root)
    {
        _searchField = new ScTextField();
        _searchField.setLabel("Find");

        ScFilterBox box;
        box = root.addFilterBox();
        box.setTitle("Find Users");
        box.setAction(newSearchAction());

        ScFieldTable fields;
        fields = box.addFields();
        fields.add(_searchField);

        _filterBox = box;
    }

    //##################################################
    //# grid
    //##################################################

    private void installGrid(ScArray root)
    {
        MyMetaUser x = MyUser.Meta;

        ScActionIF addAction;
        addAction = newAddAction();

        ScGroup group;
        group = root.addGroup();
        group.setTitle("Users");

        ScDiv right;
        right = group.getHeader().addFloatRight();
        right.css().pad5();

        ScActionButton button;
        button = right.addButton("Add", addAction);
        button.setImage(MyButtonUrls.add());

        ScGrid<MyUser> grid;
        grid = group.addGrid();
        grid.trackAll(_filterBox);
        grid.setFilterFactory(newFetcher());
        grid.addLinkColumn(x.Name, newViewAction(), x.Uid);
        grid.addColumn(x.Email);
        grid.addColumn(x.Verified);
        grid.addColumn(x.RoleName);

        _grid = grid;
    }

    private KmFilterFactoryIF<MyUser> newFetcher()
    {
        return new KmFilterFactoryIF<MyUser>()
        {
            @Override
            public KmFilter<MyUser> createFilter()
            {
                return newUserFilter();
            }
        };
    }

    private KmFilter<MyUser> newUserFilter()
    {
        MyUserFilter f;
        f = new MyUserFilter();
        f.sortOnName();

        if ( _searchField.hasValue() )
            f.setLooseName(_searchField.getValue());

        return f;
    }

    //##################################################
    //# frames
    //##################################################

    // review_aaron: Flip effect on user frame.
    private void installFrame(ScArray row)
    {
        _frame = new MyUserFrame();
        _frame.setOnChangeAction(newOnChangeAction());
        _frame.setHideFlip();
        //        _frame.setHideSpeed(150);
        _frame.setShowFlip();
        //        _frame.setShowSpeed(150);

        row.add(_frame);
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newSearchAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleSearch();
            }
        };
    }

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

    private ScActionIF newOnChangeAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleOnChange();
            }
        };
    }

    //##################################################
    //# handle
    //##################################################

    private void handleView()
    {
        String uid = getStringArgument();
        MyUser user = getAccess().findUserUid(uid);

        _frame.ajaxPrintViewUser(user);
    }

    private void handleAdd()
    {
        _frame.ajaxPrintAddUser();
    }

    private void handleSearch()
    {
        _grid.ajaxReload();
    }

    private void handleOnChange()
    {
        _grid.ajaxReload();
    }
}
