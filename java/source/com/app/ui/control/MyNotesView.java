package com.app.ui.control;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScTransientDiv;
import com.kodemore.servlet.field.ScTextArea;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalString;

import com.app.dao.base.MyDaoAccess;
import com.app.model.MyNote;
import com.app.model.MyNoteOwnerIF;
import com.app.model.MyUser;
import com.app.model.base.MyNoteOwnerType;
import com.app.utility.MyGlobals;

public class MyNotesView
    extends ScGroup
{
    //##################################################
    //# variables
    //##################################################

    /**
     * If true (the default), allow new notes to be added.
     * If false, only the history will be displayed.
     */
    private ScLocalBoolean _allowsAdd;

    private ScLocalString _ownerTypeCode;
    private ScLocalString _ownerUid;

    private ScForm         _expandedForm;
    private ScTextArea     _messageField;
    private ScTransientDiv _historyView;

    private ScDiv    _collapsedView;
    private ScAction _addedAction;

    //##################################################
    //# constructor
    //##################################################

    public MyNotesView()
    {
        _allowsAdd = new ScLocalBoolean(true);

        _ownerTypeCode = new ScLocalString();
        _ownerTypeCode.setAutoSave();

        _ownerUid = new ScLocalString();
        _ownerUid.setAutoSave();

        setTitle("Notes");
        setLabel("Notes");
        setFlavorList();
        css().clip();

        _addedAction = newUncheckedAction(this::handleAdded);

        installControls();
        collapse();
    }

    private void installControls()
    {
        ScDiv body;
        body = getBody();
        body.css().flexColumn();

        body.add(createExpandedView());
        body.add(createCollapsedView());
        body.add(createHistoryView());
    }

    //==================================================
    //= install :: expanded view
    //==================================================

    private ScForm createExpandedView()
    {
        ScForm form;
        form = new ScForm();
        form.css().flexChildStatic();
        form.css().flexColumn().gap10();
        form.onSubmit(newUncheckedAction(this::handleAdd));
        form.hide();

        ScFieldLayout fields;
        fields = form.addFieldLayout();
        fields.css().flexChildStatic();
        fields.add(createMessageField());

        form.add(createAddButtonRow());
        form.hide();
        _expandedForm = form;
        return form;
    }

    private ScTextArea createMessageField()
    {
        ScTextArea e;
        e = new ScTextArea();
        e.setLabel("Add Note");
        e.layoutBlock();
        e.setValidator(MyNote.Meta.Message.getValidator());
        _messageField = e;
        return e;
    }

    private ScControl createAddButtonRow()
    {
        ScDiv row;
        row = new ScDiv();
        row.css().flexRow().flexAlignSpaced().flexChildStatic();
        row.add(createAddButton());
        row.add(createCollapseButton());
        return row;
    }

    private ScActionButton createAddButton()
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setText("Add Note");
        e.setPrimary();
        e.setFlavorPositive();
        e.setAction(newUncheckedAction(this::handleAdd));
        return e;
    }

    private ScActionButton createCollapseButton()
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setText("Collapse");
        e.setIcon().nameExpandLess();
        e.setAction(newUncheckedAction(this::handleHideNote));
        return e;
    }

    //==================================================
    //= install :: collapsed view
    //==================================================

    private ScControl createCollapsedView()
    {
        ScDiv e;
        e = new ScDiv();
        e.css().flexRow().flexAlignSpaced().flexChildStatic().pad();
        e.add(createCollapsedAddButton());
        e.add(createCollapsedExpandButton());
        e.hide();
        _collapsedView = e;
        return e;
    }

    private ScActionButton createCollapsedAddButton()
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setText("Add Note...");
        e.setPrimary();
        e.setFlavorPositive();
        e.setAction(newUncheckedAction(this::handleAddDialog));
        return e;
    }

    private ScActionButton createCollapsedExpandButton()
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setText("Expand");
        e.setIcon().nameExpandMore();
        e.setAction(newUncheckedAction(this::handleShowNote));
        return e;
    }

    //==================================================
    //= install :: history
    //==================================================

    private ScControl createHistoryView()
    {
        ScTransientDiv e;
        e = new ScTransientDiv();
        e.css().flexChildFiller();
        e.css().flexColumn().columnSpacer10().pad10().auto();
        _historyView = e;
        return e;
    }

    //##################################################
    //# setup
    //##################################################

    public void expand()
    {
        _expandedForm.show();
        _collapsedView.hide();
    }

    public void collapse()
    {
        _expandedForm.hide();
        _collapsedView.show();
    }

    //##################################################
    //# apply
    //##################################################

    @Override
    protected boolean applyFromModel_here(Object model)
    {
        if ( model instanceof MyNoteOwnerIF )
            setOwner((MyNoteOwnerIF)model);
        else
            clearOwner();

        return false;
    }

    //##################################################
    //# owner
    //##################################################

    public MyNoteOwnerIF getOwner()
    {
        String uid = _ownerUid.getValue();
        return getOwnerType().findOwnerUid(uid);
    }

    public void setOwner(MyNoteOwnerIF e)
    {
        if ( e == null )
        {
            clearOwner();
            return;
        }

        _ownerTypeCode.setValue(e.getNoteOwnerType().getCode());
        _ownerUid.setValue(e.getUid());
    }

    private void clearOwner()
    {
        _ownerTypeCode.clearValue();
        _ownerUid.clearValue();
    }

    //##################################################
    //# owner type
    //##################################################

    private MyNoteOwnerType getOwnerType()
    {
        String code = _ownerTypeCode.getValue();
        return MyNoteOwnerType.findCode(code);
    }

    //##################################################
    //# add
    //##################################################

    public boolean getAllowsAdd()
    {
        return _allowsAdd.isTrue();
    }

    public void setAllowsAdd(boolean e)
    {
        _allowsAdd.setValue(e);
    }

    public void disableAdd()
    {
        setAllowsAdd(false);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        preRenderHistory();
    }

    private void preRenderHistory()
    {
        for ( MyNote e : findNotes() )
            _historyView.add(createHistoryFor(e));
    }

    private ScFieldset createHistoryFor(MyNote e)
    {
        ScFieldset set;
        set = new ScFieldset();
        set.setLabel(formatNameFor(e));
        set.addParagraph(e.getUpdatedLocalTsMessage());
        set.addParagraph(e.getMessage());
        return set;
    }

    private String formatNameFor(MyNote e)
    {
        return e.hasCreatedBy()
            ? e.getCreatedByFullName()
            : MyUser.SYSTEM_NAME;
    }

    //##################################################
    //# handle
    //##################################################

    private void handleAdd()
    {
        _htmlIdAjax().hideAllErrors();
        validateAndCheck();

        MyNoteOwnerIF owner = getOwner();
        String msg = _messageField.getValue();
        MyNote note = owner.addUserNote(msg);

        getAccess().flush();

        ajaxShowNote(note);
    }

    private void handleAddDialog()
    {
        MyAddNoteDialog.getInstance().ajaxOpen(getOwner(), _addedAction);
    }

    private void handleAdded()
    {
        String uid = getData().getStringArgument();
        MyNote note = getAccess().findNoteUid(uid);
        ajaxShowNote(note);
    }

    private void handleShowNote()
    {
        _expandedForm.ajaxShow();
        _collapsedView.ajaxHide();
    }

    private void handleHideNote()
    {
        _expandedForm.ajaxHide();
        _collapsedView.ajaxShow();
    }

    //##################################################
    //# support
    //##################################################

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    private KmList<MyNote> findNotes()
    {
        KmList<MyNote> v;
        v = getAccess().getNoteDao().findAllFor(getOwner());
        v.sortOn(e -> e.getCreatedUtcTs());
        v.reverse();
        return v;
    }

    private void ajaxShowNote(MyNote note)
    {
        _messageField.ajaxClearFieldValue();

        if ( note == null )
        {
            preRenderHistory();
            _historyView.ajaxReplace();
            return;
        }

        ScFieldset c;
        c = createHistoryFor(note);
        c.hide();
        _historyView._htmlIdAjax().prependContents(c);
        c.ajaxShow().slide();
    }

}
