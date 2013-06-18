package com.app.ui.activity.admin;

import com.kodemore.filter.KmFilter;
import com.kodemore.filter.KmFilterFactoryIF;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScArray;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFilterBox;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScFrame;
import com.kodemore.servlet.control.ScFrameChild;
import com.kodemore.servlet.control.ScGrid;
import com.kodemore.servlet.control.ScGroup;
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

    private ScFrame        _frame;
    private ScFrameChild   _viewChild;
    private ScFrameChild   _editChild;
    private ScFrameChild   _addChild;

    //##################################################
    //# install
    //##################################################

    @Override
    public String getName()
    {
        return "Users";
    }

    @Override
    protected ScControl installRoot()
    {
        ScBox root;
        root = new ScBox();
        root.css().padSpaced();

        installFilter(root);

        ScArray row;
        row = root.addRow();

        installGrid(row);
        installTarget(row);

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

    private void installTarget(ScArray row)
    {
        _frame = row.addFrame();

        installViewFrame();
        installEditFrame();
        installAddFrame();
    }

    private void installViewFrame()
    {
        MyMetaUser x = MyUser.Meta;

        ScFrameChild frame;
        frame = _frame.createChild();

        ScGroup group;
        group = frame.addGroup("View");

        ScDiv header;
        header = group.getHeader().addFloatRight();
        header.css().pad5();

        ScActionButton button;
        button = header.addButton("Edit", newEditAction());
        button.setImage(MyButtonUrls.edit());

        ScBox body;
        body = group.addBox();
        body.css().pad();

        ScFieldTable fields;
        fields = body.addFields();
        fields.addText(x.Uid);
        fields.addText(x.Email);
        fields.addText(x.Name);

        _viewChild = frame;
    }

    private void installEditFrame()
    {
        MyMetaUser x = MyUser.Meta;

        ScActionIF saveAction = newEditSaveAction();
        ScActionIF cancelAction = newEditCancelAction();

        ScTextField emailField;
        emailField = x.Email.newField();
        emailField.setWidthFull();

        ScTextField nameField;
        nameField = x.Name.newField();
        nameField.setWidthFull();

        ScFrameChild frame;
        frame = _frame.createChild();

        ScForm form;
        form = frame.addForm();
        form.setDefaultAction(saveAction);
        form.onEscape().run(cancelAction);

        ScGroup group;
        group = form.addGroup("Edit");
        group.style().minWidth(300);

        ScBox body;
        body = group.addBox();
        body.css().pad();

        ScFieldTable fields;
        fields = body.addFields();
        fields.css().widthFull();
        fields.addText(x.Uid);
        fields.add(emailField);
        fields.add(nameField);

        group.addDivider();

        ScDiv footer;
        footer = group.addButtonBoxRight();
        footer.addCancelButton(cancelAction);
        footer.addSubmitButton("Save");

        _editChild = frame;
    }

    private void installAddFrame()
    {
        MyMetaUser x = MyUser.Meta;

        ScActionIF saveAction = newAddSaveAction();
        ScActionIF cancelAction = newAddCancelAction();

        ScFrameChild frame;
        frame = _frame.createChild();

        ScForm form;
        form = frame.addForm();
        form.setDefaultAction(saveAction);
        form.onEscape().run(cancelAction);

        ScGroup group;
        group = form.addGroup("Add");

        ScBox body;
        body = group.addBox();
        body.css().pad();

        ScFieldTable fields;
        fields = body.addFields();
        fields.addField(x.Email);
        fields.addField(x.Name);

        group.addDivider();

        ScDiv footer;
        footer = group.addButtonBoxRight();
        footer.addCancelButton(cancelAction);
        footer.addSubmitButton("Save");

        _addChild = frame;
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

    private ScActionIF newEditAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleEdit();
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

    private ScActionIF newAddSaveAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleAddSave();
            }
        };
    }

    private ScActionIF newAddCancelAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleAddCancel();
            }
        };
    }

    private ScActionIF newEditCancelAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleEditCancel();
            }
        };
    }

    private ScActionIF newEditSaveAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleEditSave();
            }
        };
    }

    //##################################################
    //# handle
    //##################################################

    private void handleView()
    {
        String uid;
        uid = getStringArgument();

        MyUser user;
        user = getAccess().findUserUid(uid);

        getPageSession().setUser(user);

        renderView();
    }

    private void handleEdit()
    {
        renderEdit();
    }

    private void handleEditCancel()
    {
        renderView();
    }

    private void handleEditSave()
    {
        _editChild.validate();

        MyUser user;
        user = getPageSession().getUser();
        user.applyFrom(_editChild);
        user.validate();

        _grid.ajaxReload();

        renderView();
    }

    private void handleAdd()
    {
        _addChild.ajaxPrint();
        _addChild.ajax().focus();
    }

    private void handleAddCancel()
    {
        _frame.ajaxClear();
    }

    private void handleAddSave()
    {
        _addChild.ajax().hideAllErrors();
        _addChild.ajax().focus();
        _addChild.validate();

        MyUser e;
        e = new MyUser();
        e.applyFrom(_addChild);
        e.saveDao();

        flushDao();

        getPageSession().setUser(e);

        _grid.ajaxReload();

        renderView();
    }

    private void handleSearch()
    {
        _grid.ajaxReload();
    }

    //##################################################
    //# support
    //##################################################

    private void renderView()
    {
        MyUser user;
        user = getPageSession().getUser();

        _viewChild.applyFromModel(user);
        _viewChild.ajaxPrint();
    }

    private void renderEdit()
    {
        MyUser user;
        user = getPageSession().getUser();

        _editChild.applyFromModel(user);
        _editChild.ajaxPrint();
        _editChild.ajax().focus();
    }

}
