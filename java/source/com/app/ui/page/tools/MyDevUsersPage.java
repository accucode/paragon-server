package com.app.ui.page.tools;

import com.kodemore.filter.KmFilter;
import com.kodemore.filter.KmFilterFactoryIF;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScAbsoluteLayout;
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

public class MyDevUsersPage
    extends MyDevAbstractPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyDevUsersPage instance = new MyDevUsersPage();

    private MyDevUsersPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScFilterBox    _filterBox;
    private ScTextField    _searchField;
    private ScGrid<MyUser> _grid;
    private MyDevUserFrame _frame;

    //##################################################
    //# navigation
    //##################################################

    @Override
    public ScParameterList composeQueryParameters()
    {
        return null;
    }

    @Override
    public void applyQueryParameters(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css();

        ScAbsoluteLayout layout;
        layout = root.addAbsoluteLayout();
        layout.pad();

        ScDiv top = layout.addTop(140);
        layout.padTop();

        ScDiv left = layout.addLeftPercent(50);
        ScDiv center = layout.addCenter();

        installFilter(top);
        installGrid(left);
        installFrame(center);
    }

    private void installFilter(ScContainer root)
    {
        _searchField = new ScTextField();
        _searchField.setLabel("Find");

        ScFilterBox box;
        box = root.addFilterBox();
        box.layoutFill();
        box.setTitle("Search");
        box.setAction(newSearchAction());

        ScFieldTable fields;
        fields = box.addFieldTable();
        fields.add(_searchField);

        _filterBox = box;
    }

    //##################################################
    //# grid
    //##################################################

    private void installGrid(ScContainer root)
    {
        MyMetaUser x = MyUser.Meta;

        ScGroup group;
        group = root.addGroup();
        group.setTitle("Results");
        group.css().fill().marginRight();

        ScDiv body;
        body = group.getBody();
        body.css().relative().noBorder();

        ScGrid<MyUser> grid;
        grid = body.addGrid();
        grid.layoutFill();
        grid.trackAll(_filterBox);
        grid.setFilterFactory(newFetcher());
        grid.addLinkColumn(x.Name, newViewAction(), x.Uid);
        grid.addColumn(x.Email);
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

    private void installFrame(ScContainer root)
    {
        _frame = new MyDevUserFrame();
        _frame.setOnChangeAction(newOnChangeAction());
        _frame.css().fill().marginLeft();

        root.add(_frame);
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

    private void handleSearch()
    {
        _grid.ajaxReload();
    }

    private void handleOnChange()
    {
        _grid.ajaxReload();
    }
}
