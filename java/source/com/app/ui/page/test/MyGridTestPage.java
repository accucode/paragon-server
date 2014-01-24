package com.app.ui.page.test;

import com.kodemore.filter.KmFilter;
import com.kodemore.filter.KmFilterFactoryIF;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFilterBox;
import com.kodemore.servlet.control.ScGrid;
import com.kodemore.servlet.control.ScGridColumn;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.Kmu;

import com.app.filter.MyUserFilter;
import com.app.model.MyUser;
import com.app.model.meta.MyMetaUser;

public class MyGridTestPage
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyGridTestPage instance = new MyGridTestPage();

    private MyGridTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScFilterBox          _filterBox;
    private ScTextField          _nameField;

    private ScGrid<MyUser>       _grid;
    private ScGridColumn<MyUser> _emailColumn;
    private ScGridColumn<MyUser> _nameColumn;

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
        root.css().gap();

        installFilter(root);
        installGrid(root);
    }

    private void installFilter(ScContainer root)
    {
        _nameField = new ScTextField();
        _nameField.setLabel("Name");

        _filterBox = root.addFilterBox();
        _filterBox.addFields().add(_nameField);
        _filterBox.setAction(newSearchAction());
    }

    private void installGrid(ScContainer root)
    {
        MyMetaUser x = MyUser.Meta;

        ScGroup group;
        group = root.addGroup();
        group.setTitle("Users");

        ScDiv buttons;
        buttons = group.getHeader().addBox();
        buttons.css().floatRight().gap5();

        buttons.addButton("Add Sample Users", newAddUsersAction());
        buttons.addButton("Export CSV", newExportAction());

        ScGrid<MyUser> grid;
        grid = group.addGrid();
        grid.trackAll(_filterBox);
        grid.setFilterFactory(newFetcher());
        grid.setWidthAuto();
        grid.addLinkColumn("Select", newSelectAction(), x.Uid).width(50);
        grid.addColumn(x.Uid).width(200).hide();

        _nameColumn = grid.addColumn(x.Name);
        _nameColumn.setSortable();

        _emailColumn = grid.addColumn(x.Email);
        _emailColumn.setSortable();
        _emailColumn.setDefaultSort();

        _grid = grid;
    }

    private KmFilterFactoryIF<MyUser> newFetcher()
    {
        return new KmFilterFactoryIF<MyUser>()
        {
            @Override
            public KmFilter<MyUser> createFilter()
            {
                return getFilter();
            }
        };
    }

    private KmFilter<MyUser> getFilter()
    {
        MyUserFilter f;
        f = new MyUserFilter();

        if ( _nameField.hasValue() )
            f.setLooseName(_nameField.getValue());

        if ( _emailColumn.isSorted() )
        {
            f.sortOnEmail();
            f.sortAscending(_emailColumn.getSortOrder());
        }

        if ( _nameColumn.isSorted() )
        {
            f.sortOnName();
            f.sortAscending(_nameColumn.getSortOrder());
        }

        return f;
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newSelectAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleSelect();
            }
        };
    }

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

    private ScActionIF newAddUsersAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleAddUsers();
            }
        };
    }

    private ScActionIF newExportAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleExport();
            }
        };
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSearch()
    {
        _grid.ajaxReload();
    }

    private void handleAddUsers()
    {
        int n = 1000;
        for ( int i = 0; i < n; i++ )
        {
            String suffix = Kmu.leadZero(i, 4);

            MyUser e;
            e = new MyUser();
            e.setVerified(true);
            e.setEmail("email-" + suffix);
            e.setName("name-" + suffix);
            e.saveDao();
        }

        ajax().toast("Added %s user(s).", n);

        _grid.ajaxReload();
    }

    private void handleSelect()
    {
        String uid = getStringArgument();

        ajax().toast("Selected user: %s.", uid);
    }

    private void handleExport()
    {
        _grid.ajaxDownloadCsv();
    }
}
