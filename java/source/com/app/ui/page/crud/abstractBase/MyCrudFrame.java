package com.app.ui.page.crud.abstractBase;

import java.util.function.Consumer;

import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.variable.ScLocalString;

/**
 * I coordinate panels to ADD, EDIT, and VIEW a domain.
 *
 * I do add any ui myself, but coordinate the display and navigation
 * between the add/edit/view controls that I contain.
 *
 * @param <P> The domain PARENT.
 * @param <C> The domain CHILD.
 */
public abstract class MyCrudFrame<P extends KmUidDomainIF, C extends KmUidDomainIF>
    extends ScCardFrame
{
    //##################################################
    //# variables
    //##################################################

    private MyCrudBuilder<P,C> _crudBuilder;

    private ScLocalString _domainChildUid;

    private ScGroup               _messageCard;
    private MyCrudAddCard<P,C>    _addCard;
    private MyCrudEditCard<C>     _editCard;
    private MyCrudViewCard<C>     _viewCard;
    private MyCrudDeleteCard<C>   _deleteCard;
    private MyCrudAuditLogCard<C> _auditLogCard;

    private Consumer<MyCrudSaveEvent<C>> _addSavedListener;
    private Runnable                     _addCancelledListener;
    private Consumer<C>                  _editSavedListener;
    private Consumer<C>                  _deletedListener;

    private Consumer<C> _childChangedListener;
    private Consumer<C> _childListChangedListener;

    /**
     * Used to notify a listener when the list *should* be refreshed.
     * This is usually not needed since the list is normally updated
     * when domains are added, updated, or removed.
     */
    private Runnable _listRefreshListener;

    /**
     * By default, the frame shows the view card when the edit is saved.
     */
    private boolean _showsViewOnEditSaved;

    /**
     * By default, the frame shows the message card upon delete.
     */
    private boolean _showsMessageOnDeleted;

    //##################################################
    //# constructor
    //##################################################

    public MyCrudFrame(MyCrudBuilder<P,C> e)
    {
        _crudBuilder = e;

        _domainChildUid = new ScLocalString();
        _domainChildUid.setAutoSave();

        _showsViewOnEditSaved = true;
        _showsMessageOnDeleted = true;

        ScCardFrame frame;
        frame = this;
        frame.css().relative();

        installMessageCard();
        installViewCard();
        installEditCard();
        installAddCard();
        installDeleteCard();
        installAuditLogCard();

        onAddCancelled(this::ajaxPrintMessage);
        setAutoFocus(true);
    }

    protected MyCrudBuilder<P,C> getCrudBuilder()
    {
        return _crudBuilder;
    }

    //##################################################
    //# install
    //##################################################

    private void installMessageCard()
    {
        ScGroup group;
        group = new ScGroup();
        group.setFlavorSummary();
        group.setTitle("Details");
        group.css().fill();

        ScDiv body;
        body = group.getBody();
        body.css().pad();
        body.addText("Select a value.");

        _messageCard = addCard(group);
    }

    private void installViewCard()
    {
        MyCrudViewCard<C> e;
        e = getCrudBuilder().getViewCard();
        e.onEdit(this::handleEdit);
        e.onDelete(this::handleDelete);
        e.onAuditLog(this::handleAuditLog);
        e.onChildChanged(this::handleChildChanged);
        e.onChildListChanged(this::handleChildListChanged);
        e.css().fill();

        _viewCard = addCard(e);
    }

    private void installAddCard()
    {
        MyCrudAddCard<P,C> e = getCrudBuilder().getAddCard();
        if ( e == null )
            return;

        e.onSaved(this::handleAddSaved);
        e.onCancelled(this::handleAddCancelled);
        e.onListRefresh(this::handleListRefresh);
        e.css().fill();

        _addCard = addCard(e);
    }

    private void installEditCard()
    {
        MyCrudEditCard<C> e = getCrudBuilder().getEditCard();
        if ( e == null )
            return;

        e.onSaved(this::handleEditSaved);
        e.onCancelled(this::handleEditCancelled);
        e.onChildListChanged(this::handleChildListChanged);
        e.css().fill();

        _editCard = addCard(e);
    }

    private void installDeleteCard()
    {
        MyCrudDeleteCard<C> e = getCrudBuilder().getDeleteCard();
        if ( e == null )
            return;

        e.onDeleted(this::handleDeleted);
        e.onCancelled(this::handleDeleteCancelled);
        e.css().fill();

        _deleteCard = addCard(e);
    }

    private void installAuditLogCard()
    {
        MyCrudAuditLogCard<C> e;
        e = new MyCrudAuditLogCard<>(getCrudBuilder());
        e.onBack(this::handleAuditLogClosed);
        e.css().fill();

        _auditLogCard = addCard(e);
    }

    //##################################################
    //# default card
    //##################################################

    public final void setDefaultMessageCard()
    {
        setDefaultCard(_messageCard);
    }

    public final void setDefaultAddCard(P e)
    {
        _addCard.setDomainParent(e);
        setDefaultCard(_addCard);
    }

    public final void setDefaultEditCard(C e)
    {
        _editCard.setDomainChild(e);
        setDefaultCard(_editCard);
    }

    public final void setDefaultViewCard(C e)
    {
        _viewCard.setDomainChild(e);
        setDefaultCard(_viewCard);
    }

    public final void setDefaultDeleteCard(C e)
    {
        _deleteCard.setDomainChild(e);
        setDefaultCard(_viewCard);
    }

    //##################################################
    //# cards
    //##################################################

    public MyCrudViewCard<C> getViewCard()
    {
        return _viewCard;
    }

    //##################################################
    //# listener :: add saved
    //##################################################

    public final void onAddSaved(Consumer<MyCrudSaveEvent<C>> e)
    {
        _addSavedListener = e;
    }

    private void fireAddSaved(MyCrudSaveEvent<C> e)
    {
        if ( _addSavedListener != null )
            _addSavedListener.accept(e);
    }

    //==================================================
    //= listener :: add cancelled
    //==================================================

    public final void onAddCancelled(Runnable e)
    {
        _addCancelledListener = e;
    }

    private void fireAddCancelled()
    {
        fire(_addCancelledListener);
    }

    //==================================================
    //= listener :: edit saved
    //==================================================

    public final void onEditSaved(Consumer<C> e)
    {
        _editSavedListener = e;
    }

    private void fireEditSaved(C e)
    {
        fire(_editSavedListener, e);
    }

    //==================================================
    //= listener :: deleted
    //==================================================

    public final void onDeleted(Consumer<C> e)
    {
        _deletedListener = e;
    }

    private void fireDeleted(C e)
    {
        fire(_deletedListener, e);
    }

    //==================================================
    //= listener :: child changed
    //==================================================

    public final void onChildChanged(Consumer<C> e)
    {
        _childChangedListener = e;
    }

    protected void fireChildChanged(C e)
    {
        fire(_childChangedListener, e);
    }

    public final void onChildListChanged(Consumer<C> e)
    {
        _childListChangedListener = e;
    }

    protected void fireChildListChanged(C e)
    {
        fire(_childListChangedListener, e);
    }

    //==================================================
    //= listener :: list refresh
    //==================================================

    public final void onListRefresh(Runnable e)
    {
        _listRefreshListener = e;
    }

    private final void fireListRefresh()
    {
        fire(_listRefreshListener);
    }

    //##################################################
    //# domain
    //##################################################

    public final C getDomainChild()
    {
        return getCrudBuilder().findChild(_domainChildUid);
    }

    public final void setDomainChild(C c)
    {
        if ( c == null )
        {
            _domainChildUid.clearValue();
            _viewCard.setDomainChild(null);
            _auditLogCard.setDomainChild(null);

            if ( _addCard != null )
                _addCard.setDomainParent(null);

            if ( _editCard != null )
                _editCard.setDomainChild(null);

            if ( _deleteCard != null )
                _deleteCard.setDomainChild(null);

            return;
        }

        P p = getCrudBuilder().getParentFor(c);
        _domainChildUid.setValue(c.getUid());
        _viewCard.setDomainChild(c);
        _auditLogCard.setDomainChild(c);

        if ( _addCard != null )
            _addCard.setDomainParent(p);

        if ( _editCard != null )
            _editCard.setDomainChild(c);

        if ( _deleteCard != null )
            _deleteCard.setDomainChild(c);
    }

    private void clearDomainChild()
    {
        _domainChildUid.clearValue();
    }

    //##################################################
    //# shows view on edit saved
    //##################################################

    public void setShowsViewOnEditSaved(boolean e)
    {
        _showsViewOnEditSaved = e;
    }

    public boolean getShowsViewOnEditSaved()
    {
        return _showsViewOnEditSaved;
    }

    //##################################################
    //# shows message on deleted
    //##################################################

    public void setShowsMessageOnDeleted(boolean e)
    {
        _showsMessageOnDeleted = e;
    }

    public boolean getShowsMessageOnDeleted()
    {
        return _showsMessageOnDeleted;
    }

    //##################################################
    //# downcast
    //##################################################

    @Override
    protected final boolean applyFromModel_here(Object model)
    {
        @SuppressWarnings("unchecked")
        C child = (C)model;

        setDomainChild(child);
        return false;
    }

    //##################################################
    //# handle
    //##################################################

    private void handleAddSaved(MyCrudSaveEvent<C> e)
    {
        boolean more = e.getAddMore();
        C c = e.getChild();

        if ( more )
            ajaxPrintAdd(getCrudBuilder().getParentFor(c));
        else
            ajaxPrintView(c);

        fireAddSaved(e);
    }

    private void handleAddCancelled()
    {
        fireAddCancelled();
    }

    private void handleEdit(C e)
    {
        ajaxPrintEdit(e);
    }

    private void handleEditSaved(C e)
    {
        if ( getShowsViewOnEditSaved() )
            ajaxPrintView(e);

        fireEditSaved(e);
    }

    private void handleEditCancelled(C e)
    {
        ajaxPrintView(e);
    }

    private void handleDelete(C e)
    {
        ajaxPrintDelete(e);
    }

    private void handleDeleted(C e)
    {
        if ( getShowsMessageOnDeleted() )
            ajaxPrintMessage();

        fireDeleted(e);
    }

    private void handleDeleteCancelled(C e)
    {
        ajaxPrintView(e);
    }

    private void handleAuditLog(C c)
    {
        ajaxPrintAuditLog(c);
    }

    private void handleAuditLogClosed(C c)
    {
        ajaxPrintView(c);
    }

    private void handleChildChanged(C e)
    {
        if ( e == null )
            ajaxPrintMessage();

        fireChildChanged(e);
    }

    private void handleChildListChanged(C e)
    {
        if ( e == null )
            ajaxPrintMessage();

        fireChildListChanged(e);
    }

    private void handleListRefresh()
    {
        fireListRefresh();
    }

    //##################################################
    //# ajax print
    //##################################################

    public final void ajaxPrintMessage()
    {
        ajaxPrint(_messageCard);
    }

    public final void ajaxPrintAdd(P parent)
    {
        clearDomainChild();

        MyCrudAddCard<P,C> card;
        card = _addCard;
        card.setDomainParent(parent);
        ajaxPrint(card);
    }

    public final void ajaxPrintEdit(C e)
    {
        setDomainChild(e);
        ajaxPrint(_editCard);
    }

    public final void ajaxPrintView(C e)
    {
        setDomainChild(e);
        ajaxPrint(_viewCard);
    }

    public final void ajaxPrintDelete(C e)
    {
        setDomainChild(e);
        ajaxPrint(_deleteCard);
    }

    public final void ajaxPrintAuditLog(C e)
    {
        setDomainChild(e);
        ajaxPrint(_auditLogCard);
    }
}
