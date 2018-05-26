package com.app.ui.page.crud.abstractBase;

import java.util.function.Function;
import java.util.function.Predicate;

import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.log.KmLog;
import com.kodemore.meta.KmMetaModel;
import com.kodemore.servlet.field.ScHiddenField;
import com.kodemore.types.KmTuple;
import com.kodemore.utility.KmKeyFinderIF;
import com.kodemore.utility.KmSimpleResult;
import com.kodemore.utility.KmValueHolderIF;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoAccess;
import com.app.model.MyUser;
import com.app.model.support.MyPageDomainIF;
import com.app.ui.dialog.MyDialogs;
import com.app.ui.dialog.MyNotifyDialog;
import com.app.utility.MyGlobals;

/**
 * I act as the bridge between the domain and the ui.
 * I implement a number of common methods so that these don't
 * need to be duplicated repeatedly in the various ui classes.
 *
 * Note that the parent and child classes must implement MyUidDomainIF.
 * That is, they must implement a UID as their unique identifier.
 *
 * @param <P> The domain PARENT, used to get the list, and to add new children.
 * @param <C> The domain CHILD, used to view and edit details.
 */
public abstract class MyCrudBuilder<P extends KmUidDomainIF, C extends KmUidDomainIF>
{
    //##################################################
    //# variables
    //##################################################

    private MyCrudLazyValue<MyCrudListView<P,C>>     _listView;
    private MyCrudLazyValue<MyCrudSearchViewIF<P,C>> _searchView;
    private MyCrudLazyValue<MyCrudFrame<P,C>>        _frame;
    private MyCrudLazyValue<MyCrudAddCard<P,C>>      _addCard;
    private MyCrudLazyValue<MyCrudEditCard<C>>       _editCard;
    private MyCrudLazyValue<MyCrudViewCard<C>>       _viewCard;
    private MyCrudLazyValue<MyCrudDeleteCard<C>>     _deleteCard;

    //##################################################
    //# constructor
    //##################################################

    public MyCrudBuilder()
    {
        _listView = new MyCrudLazyValue<>(this::newListView);
        _searchView = new MyCrudLazyValue<>(this::newSearchView);
        _frame = new MyCrudLazyValue<>(this::newFrame);
        _addCard = new MyCrudLazyValue<>(this::newAddCard);
        _editCard = new MyCrudLazyValue<>(this::newEditCard);
        _viewCard = new MyCrudLazyValue<>(this::newViewCard);
        _deleteCard = new MyCrudLazyValue<>(this::newDeleteCard);
    }

    //##################################################
    //# find
    //##################################################

    /**
     * Find the parent for the uid.
     * This is typically a database fetch.
     * E.g.: getAccess().findProjectUid(uid);
     */
    public abstract P findParent(String uid);

    /**
     * Most of the time, a non-null parent is required for proper behavior.
     * However, in certain rare cases it is allowable.
     * E.g.: globals such as projects and users.
     * Return false by default.
     * Subclasses may override to disable error checking.
     */
    protected boolean allowsNullParent()
    {
        return false;
    }

    //##################################################
    //# child
    //##################################################

    /**
     * Return the meta data for the child.
     * Must not be null.
     */
    public abstract KmMetaModel getChildMeta();

    public abstract KmKeyFinderIF<C,String> getChildFinder();

    /**
     * Return a title to be used for each list element.
     * This is also used in the summary section for a single child.
     */
    public Function<C,String> getChildTitleFunction()
    {
        return C::getDomainTitle;
    }

    /**
     * Return a predicate that determines whether the title should
     * include a strikeout style. If null, the default, strikeout
     * is not applied.
     */
    public Predicate<C> getChildEnabled()
    {
        return C::isDomainEnabled;
    }

    /**
     * If overridden to return a non-null value, this url
     * will be used to open a new browser tab that displays
     * a particular child.
     *
     * @param c The child to be viewed.
     */
    public String getChildPopoutUrlFor(C c)
    {
        if ( c instanceof MyPageDomainIF )
            return ((MyPageDomainIF)c).formatEntryUrl();

        return null;
    }

    /**
     * Return a subtitle to be used for each list element.
     * This is also used in the summary section for a single child.
     * This may be displayed below the title in smaller text.
     */
    public Function<C,String> getChildSubtitleFunction()
    {
        return C::getDomainSubtitle;
    }

    /**
     * Return an error message to be displayed.  In most cases, this
     * is undefined (null) since error checking/validation is handled
     * during the add/edit process. However, there are some cases where
     * it is not feasible to keep the value is a valid state.  In these
     * cases it can be helpful to provide an indicator for those values
     * that have a problem.
     */
    public Function<C,String> getChildErrorFunction()
    {
        return null;
    }

    /**
     * Find the child by its uid.
     * This is typically a database fetch.
     * E.g.: getAccess().findDepotUid(uid);
     */
    public final C findChild(String uid)
    {
        return getChildFinder().find(uid);
    }

    //==================================================
    //= child :: convenience
    //==================================================

    /**
     * The display name of the child.
     * The domain meta model is usually used for consistency.
     */
    public String getChildLabel()
    {
        return getChildMeta().getLabel();
    }

    /**
     * The popup help message for the child domain.
     */
    public final String getChildHelp()
    {
        return getChildMeta().getHelp();
    }

    //##################################################
    //# tree
    //##################################################

    /**
     * Return the child's parent.
     */
    public abstract P getParentFor(C child);

    /**
     * Given a parent and/or child, ensure consistency and fill
     * in the parent is missing. The resulting parent/child pair
     * is returned. This may throw fatal errors.
     */
    public final KmTuple<P,C> reconcileParentChild(P parent, C child)
    {
        MyCrudBuilder<P,C> b = this;
        boolean allowsNullParent = b.allowsNullParent();

        if ( !allowsNullParent )
            if ( parent == null && child == null )
                throw Kmu.newFatal("Parent and child cannot both be null.");

        if ( parent != null && child != null )
            if ( !parent.equals(b.getParentFor(child)) )
            {
                KmLog.printfln(
                    "CRUD parent(%s) does not match child(%s)",
                    parent.getDomainTitle(),
                    child.getDomainTitle());

                return KmTuple.create(parent, null);
            }

        if ( parent == null )
            parent = b.getParentFor(child);

        if ( !allowsNullParent )
            if ( parent == null )
                throw Kmu.newFatal("Parent cannot be null");

        return KmTuple.create(parent, child);
    }

    //##################################################
    //# ui :: manage view
    //##################################################

    public MyCrudListView<P,C> getListView()
    {
        return _listView.getValue();
    }

    public final void setManageView(MyCrudListView<P,C> e)
    {
        _listView.setValue(e);
    }

    /**
     * Return a new crud list view.
     * @see MyCrudListView
     */
    protected abstract MyCrudListView<P,C> newListView();

    //==================================================
    //= ui :: search view
    //==================================================

    public MyCrudSearchViewIF<P,C> getSearchView()
    {
        return _searchView.getValue();
    }

    public final void setSearchView(MyCrudSearchViewIF<P,C> e)
    {
        _searchView.setValue(e);
    }

    protected abstract MyCrudSearchViewIF<P,C> newSearchView();

    //==================================================
    //= ui :: frame
    //==================================================

    public MyCrudFrame<P,C> getFrame()
    {
        return _frame.getValue();
    }

    public final void setFrame(MyCrudFrame<P,C> e)
    {
        _frame.setValue(e);
    }

    /**
     * Return a new crud frame.
     * @see MyCrudFrame
     */
    protected abstract MyCrudFrame<P,C> newFrame();

    //==================================================
    //= ui :: add card
    //==================================================

    public MyCrudAddCard<P,C> getAddCard()
    {
        return _addCard.getValue();
    }

    public void setAddCard(MyCrudAddCard<P,C> e)
    {
        _addCard.setValue(e);
    }

    public boolean hasAddCard()
    {
        return getAddCard() != null;
    }

    /**
     * Return a new crud add card.
     * @see MyCrudAddCard
     */
    protected abstract MyCrudAddCard<P,C> newAddCard();

    //==================================================
    //= ui :: edit card
    //==================================================

    public MyCrudEditCard<C> getEditCard()
    {
        return _editCard.getValue();
    }

    public final void setEditCard(MyCrudEditCard<C> e)
    {
        _editCard.setValue(e);
    }

    public boolean hasEditCard()
    {
        return getEditCard() != null;
    }

    /**
     * Return a new crud edit card.
     * @see MyCrudEditCard
     */
    protected abstract MyCrudEditCard<C> newEditCard();

    //==================================================
    //= ui :: delete card
    //==================================================

    public final MyCrudDeleteCard<C> getDeleteCard()
    {
        return _deleteCard.getValue();
    }

    public final void setDeleteCard(MyCrudDeleteCard<C> e)
    {
        _deleteCard.setValue(e);
    }

    public boolean hasDeleteCard()
    {
        return getDeleteCard() != null;
    }

    /**
     * Return a new DELETE card.
     * Return null by default, disabling deletion.
     */
    protected MyCrudDeleteCard<C> newDeleteCard()
    {
        return null;
    }

    //==================================================
    //= ui :: view card
    //==================================================

    public MyCrudViewCard<C> getViewCard()
    {
        return _viewCard.getValue();
    }

    public final void setViewCard(MyCrudViewCard<C> e)
    {
        _viewCard.setValue(e);
    }

    /**
     * Return a new view card.
     * @see MyCrudViewCard
     */
    protected abstract MyCrudViewCard<C> newViewCard();

    //##################################################
    //# testing :: shows
    //##################################################

    /**
     * Determine if the add button is visible.
     * @param parent The parent the child would be added to.
     */
    protected boolean showsAddFor(P parent)
    {
        return hasAddCard();
    }

    /**
     * Determine if the edit button is visible.
     * @param child The child to be edited.
     */
    protected boolean showsEditFor(C child)
    {
        return hasEditCard();
    }

    /**
     * Determine if the delete button is visible.
     * @param child The child to be deleted.
     */
    protected boolean showsDeleteFor(C child)
    {
        return hasDeleteCard();
    }

    //##################################################
    //# testing :: allows
    //##################################################

    /**
     * Determine if 'add' is allowed, checked when the 'add' button is clicked.
     * @param parent The parent the child would be added to.
     */
    protected KmSimpleResult allowsAddFor(P parent)
    {
        return KmSimpleResult.OK;
    }

    /**
     * Determine if 'edit' is allowed. Checked when the 'edit' button is clicked.
     * @param child The child to be edited.
     */
    protected KmSimpleResult allowsEditFor(C child)
    {
        return KmSimpleResult.OK;
    }

    /**
     * Determine if 'delete' is allowed. Checked when the 'delete' button is clicked.
     * @param child The child to be deleted.
     */
    protected KmSimpleResult allowsDeleteFor(C child)
    {
        return KmSimpleResult.OK;
    }

    //##################################################
    //# find
    //##################################################

    public final P findParent(ScHiddenField<String> uidField)
    {
        String uid = uidField.getValue();
        return findParent(uid);
    }

    public final P findParent(KmValueHolderIF<String> holder)
    {
        String uid = holder.getValue();
        return findParent(uid);
    }

    public final C findChild(ScHiddenField<String> uidField)
    {
        String uid = uidField.getValue();
        return findChild(uid);
    }

    public final C findChild(KmValueHolderIF<String> holder)
    {
        String uid = holder.getValue();
        return findChild(uid);
    }

    //##################################################
    //# support
    //##################################################

    protected final MyGlobals getGlobals()
    {
        return MyGlobals.instance;
    }

    protected final MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    protected MyUser getCurrentUser()
    {
        return MyGlobals.getCurrentUser();
    }

    //##################################################
    //# dialogs
    //##################################################

    public void showCannotAddDialog(KmSimpleResult r)
    {
        if ( r.isOk() )
            return;

        MyNotifyDialog d;
        d = MyDialogs.getNotifyDialog();
        d.setTitle("Cannot Add " + getChildLabel());
        d.setMessage(r.getError());
        d.setFlavorCaution();
        d.ajaxOpen();
    }

    public void showCannotEditDialog(KmSimpleResult r)
    {
        if ( r.isOk() )
            return;

        MyNotifyDialog d;
        d = MyDialogs.getNotifyDialog();
        d.setTitle("Cannot Edit " + getChildLabel());
        d.setMessage(r.getError());
        d.setFlavorCaution();
        d.ajaxOpen();
    }

    public void showCannotDeleteDialog(KmSimpleResult r)
    {
        if ( r.isOk() )
            return;

        MyNotifyDialog d;
        d = MyDialogs.getNotifyDialog();
        d.setTitle("Cannot Delete " + getChildLabel());
        d.setMessage(r.getError());
        d.setFlavorCaution();
        d.ajaxOpen();
    }

}
