package com.app.ui.page.test;

import com.kodemore.filter.KmFilter;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFilterBox;
import com.kodemore.servlet.control.ScFlexbox;
import com.kodemore.servlet.control.ScGrid;
import com.kodemore.servlet.control.ScGridColumn;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.Kmu;

import com.app.filter.MyUserFilter;
import com.app.model.MyUser;
import com.app.model.meta.MyMetaUser;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyGridTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyGridTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyGridTestPage();
    }

    public static MyGridTestPage getInstance()
    {
        return _instance;
    }

    private MyGridTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScFilterBox _filterBox;
    private ScTextField _nameField;

    private ScGrid<MyUser>       _grid;
    private ScGridColumn<MyUser> _emailColumn;
    private ScGridColumn<MyUser> _nameColumn;

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
        root.css().fill();

        ScFlexbox col;
        col = root.addColumn();
        col.css().fillOffset();

        installFilterOn(col);
        installGridOn(col);
    }

    private void installFilterOn(ScContainer root)
    {
        _nameField = new ScTextField();
        _nameField.setLabel("Name");
        _nameField.disableChangeTracking();

        _filterBox = root.addFilterBox();
        _filterBox.addFieldTable().add(_nameField);
        _filterBox.setAction(this::handleSearch);
    }

    private void installGridOn(ScContainer root)
    {
        MyMetaUser x = MyUser.Meta;

        ScGroup group;
        group = root.addGroup();
        group.setTitle("Users");

        group.css().flexGrow().flexShrink().marginTop();
        group.getBody().css().relative();

        ScDiv buttons;
        buttons = group.getBanner().addBox();
        buttons.css().floatRight().gap5();

        buttons.addButton("Add Sample Users", this::handleAddUsers);
        buttons.addButton("Export CSV", this::handleExport);

        ScGrid<MyUser> grid;
        grid = group.getBody().addGrid();
        grid.trackAll(_filterBox);
        grid.setFilterFactory(this::getFilter);
        grid.setWidthAuto();
        grid.addLinkColumn("Select", this::handleSelect, MyUser::getUid).width(50);
        grid.addColumn(x.Uid).width(200).hide();
        grid.layoutFill();

        _nameColumn = grid.addColumn(x.Name);
        _nameColumn.setSortable();

        _emailColumn = grid.addColumn(x.Email);
        _emailColumn.setSortable();
        _emailColumn.setDefaultSort();

        _grid = grid;
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
            e.attachDao();
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
