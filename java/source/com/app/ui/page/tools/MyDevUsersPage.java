package com.app.ui.page.tools;

import com.kodemore.filter.KmFilter;
import com.kodemore.filter.KmFilterFactoryIF;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFilterBox;
import com.kodemore.servlet.control.ScGrid;
import com.kodemore.servlet.control.ScGridGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScTwoPanelLayout;
import com.kodemore.servlet.field.ScTextField;

import com.app.filter.MyUserFilter;
import com.app.model.MyUser;
import com.app.model.meta.MyMetaUser;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyDevUsersPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyDevUsersPage _instance;

    public static void installInstance()
    {
        _instance = new MyDevUsersPage();
    }

    public static MyDevUsersPage getInstance()
    {
        return _instance;
    }

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

        ScTwoPanelLayout layout;
        layout = root.addTwoPanelLayout();
        layout.css().fill();
        layout.getLeftGroup().setTitle("Users");
        layout.getRightGroup().setTitle("Edit");

        ScDiv leftBox;
        leftBox = layout.getLeftBox();
        leftBox.css().flexColumn().columnSpacer10();

        ScDiv rightBox = layout.getRightBox();

        installFilterOn(leftBox);
        installGridOn(leftBox);
        installFrameOn(rightBox);
    }

    private void installFilterOn(ScContainer root)
    {
        _searchField = new ScTextField();
        _searchField.setLabel("Find");
        _searchField.disableChangeTracking();

        ScFilterBox box;
        box = root.addFilterBox();
        box.setTitle("Search");
        box.setAction(this::handleSearch);
        box.getGroup().setFlavorPrimary();

        ScFieldTable fields;
        fields = box.addFieldTable();
        fields.add(_searchField);

        _filterBox = box;
    }

    //==================================================
    //= install :: grid
    //==================================================

    private void installGridOn(ScContainer root)
    {
        MyMetaUser x = MyUser.Meta;

        ScGrid<MyUser> grid;
        grid = new ScGrid<>();
        grid.trackAll(_filterBox);
        grid.setFilterFactory(newFetcher());
        grid.addLinkColumn(x.FullName, this::handleView, x.Uid);
        grid.addColumn(x.Email);
        grid.addColumn(x.RoleName);
        grid.layoutFill();

        _grid = grid;

        ScGridGroup<MyUser> group;
        group = root.addGroup("Results", grid);
        group.css().flexChildFiller();
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

    //==================================================
    //= install :: frame
    //==================================================

    private void installFrameOn(ScContainer root)
    {
        _frame = new MyDevUserFrame();
        _frame.setOnChange(this::handleOnChange);

        root.add(_frame);
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
