package com.app.model.transfer.detail;

import com.kodemore.collection.KmList;
import com.kodemore.exception.KmApplicationException;
import com.kodemore.io.KmIndentPrintWriter;
import com.kodemore.utility.Kmu;

import com.app.model.MyAttachment;
import com.app.model.MyAttachmentOwnerIF;
import com.app.model.MyAttachments;
import com.app.model.MyBlurb;
import com.app.model.MyChoice;
import com.app.model.MyContactIF;
import com.app.model.MyCustomer;
import com.app.model.MyCustomerContact;
import com.app.model.MyEmailTemplate;
import com.app.model.MyNote;
import com.app.model.MyNoteOwnerIF;
import com.app.model.MyNotes;
import com.app.model.MyPriority;
import com.app.model.MyProject;
import com.app.model.MySite;
import com.app.model.MySiteContact;
import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.model.MyVendor;
import com.app.model.base.MyChoiceType;
import com.app.model.base.MyEmailTemplateContextType;
import com.app.model.transfer.MyTransfer;
import com.app.model.transfer.MyTransferAction;
import com.app.model.transfer.MyTransferRoot;
import com.app.utility.MyBasicTimestampsIF;

public abstract class MyTransferAbstractDetail<T>
    extends MyTransfer
{
    //##################################################
    //# variables
    //##################################################

    private MyTransfer _parent;
    private T          _source;

    private T                _result;
    private MyTransferAction _actionType;
    private String           _errorMessage;

    //##################################################
    //# constructor
    //##################################################

    protected MyTransferAbstractDetail(T source)
    {
        _source = source;
    }

    //##################################################
    //# tree
    //##################################################

    @Override
    public final MyTransfer getParent()
    {
        return _parent;
    }

    public final void _setParent(MyTransfer e)
    {
        if ( e == this )
            throw Kmu.newFatal("Cannot set parent to self.");

        _parent = e;
    }

    @Override
    public final MyTransferRoot getRoot()
    {
        return getParent().getRoot();
    }

    //##################################################
    //# source
    //##################################################

    public T getSource()
    {
        return _source;
    }

    public void setSource(T e)
    {
        _source = e;
    }

    public boolean hasSource()
    {
        return _source != null;
    }

    public String formatSource()
    {
        return formatTitle(getSource());
    }

    //##################################################
    //# result
    //##################################################

    public T getResult()
    {
        return _result;
    }

    public boolean hasResult()
    {
        return _result != null;
    }

    public boolean hasError()
    {
        return _actionType == MyTransferAction.Error;
    }

    public String getErrorMessage()
    {
        return _errorMessage;
    }

    //==================================================
    //= results :: action type
    //==================================================

    public MyTransferAction getActionType()
    {
        return _actionType;
    }

    public boolean hasActionType()
    {
        return _actionType != null;
    }

    //==================================================
    //= results :: set
    //==================================================

    protected T setNoSourceResult()
    {
        _actionType = MyTransferAction.NoSource;
        _result = null;
        return _result;
    }

    protected T setExistingResult(T e)
    {
        _actionType = MyTransferAction.Exists;
        _result = e;
        return _result;
    }

    protected T setSkipAdd()
    {
        _actionType = MyTransferAction.SkipAdd;
        _result = null;
        return _result;
    }

    protected T setSkipUpdate(T e)
    {
        _actionType = MyTransferAction.SkipUpdate;
        _result = e;
        return _result;
    }

    protected T setAlreadyUpdated(T e)
    {
        _actionType = MyTransferAction.AlreadyUpdated;
        _result = e;
        return _result;
    }

    protected T setUpdate(T e)
    {
        _actionType = MyTransferAction.Update;
        _result = e;
        return _result;
    }

    protected T setAddResult(T e)
    {
        _actionType = MyTransferAction.Add;
        _result = e;
        return _result;
    }

    protected T setErrorResult(String msg)
    {
        _actionType = MyTransferAction.Error;
        _result = null;
        _errorMessage = msg;
        return _result;
    }

    @Override
    public void collectErrorsOn(KmList<String> v)
    {
        if ( hasError() )
            v.add(getErrorMessage());

        super.collectErrorsOn(v);
    }

    //##################################################
    //# manage
    //##################################################

    public final void manageTransfer()
    {
        try
        {
            tryManageTransfer();
        }
        catch ( KmApplicationException ex )
        {
            setErrorResult(ex.getMessage());
            throw ex;
        }
    }

    private T tryManageTransfer()
    {
        T from = getSource();
        if ( from == null )
            return setNoSourceResult();

        T to = findTargetFor(from);
        return to == null
            ? manageAdd(from)
            : manageUpdate(from, to);
    }

    private T manageAdd(T from)
    {
        T to = transferAdd(from);

        if ( to == null && !hasActionType() )
            throw newError("Add is null without action type.");

        transferDecorations(from, to);
        setAddResult(to);
        return to;
    }

    private T manageUpdate(T from, T to)
    {
        boolean update = getRoot().getUpdateExisting();
        if ( !update )
            return setSkipUpdate(to);

        if ( isUpdated(to) )
            return setAlreadyUpdated(to);

        setUpdated(to);
        transferUpdate(from, to);
        return setUpdate(to);
    }

    //##################################################
    //# transfer
    //##################################################

    protected abstract T transferAdd(T from);

    protected abstract void transferUpdate(T from, T to);

    protected abstract T findTargetFor(T from);

    //==================================================
    //= transfer :: decorations
    //==================================================

    private void transferDecorations(T fromAny, T toAny)
    {
        MyTransferRoot root = getRoot();

        if ( root.getIncludeNotes() )
            transferNotes(fromAny, toAny);

        if ( root.getIncludeAttachments() )
            transferAttachments(fromAny, toAny);
    }

    //==================================================
    //= notes
    //==================================================

    private void transferNotes(T fromAny, T toAny)
    {
        if ( fromAny instanceof MyNoteOwnerIF )
        {
            MyNoteOwnerIF from = (MyNoteOwnerIF)fromAny;
            MyNoteOwnerIF to = (MyNoteOwnerIF)toAny;
            transferNotes(from, to);
        }
    }

    private void transferNotes(MyNoteOwnerIF fromOwner, MyNoteOwnerIF toOwner)
    {
        KmList<MyNote> froms = getAccess().getNoteDao().findAllFor(fromOwner);
        for ( MyNote from : froms )
            transferNote(from, toOwner);
    }

    private void transferNote(MyNote from, MyNoteOwnerIF toOwner)
    {
        MyNote to;
        to = MyNotes.createCopy(from, toOwner);
        applyBasicTimestamps(from, to);
        to.daoAttach();
    }

    //==================================================
    //= attachments
    //==================================================

    private void transferAttachments(T fromAny, T toAny)
    {
        if ( fromAny instanceof MyAttachmentOwnerIF )
        {
            MyAttachmentOwnerIF from = (MyAttachmentOwnerIF)fromAny;
            MyAttachmentOwnerIF to = (MyAttachmentOwnerIF)toAny;
            transferAttachments(from, to);
        }
    }

    private void transferAttachments(MyAttachmentOwnerIF fromOwner, MyAttachmentOwnerIF toOwner)
    {
        KmList<MyAttachment> froms = getAccess().getAttachmentDao().findAllFor(fromOwner);
        for ( MyAttachment from : froms )
            transferAttachment(from, toOwner);
    }

    private void transferAttachment(MyAttachment from, MyAttachmentOwnerIF toOwner)
    {
        MyAttachment to;
        to = MyAttachments.createCopy(from, toOwner);
        applyBasicTimestamps(from, to);
        to.daoAttach();
    }

    //==================================================
    //= transfer :: helper
    //==================================================

    /**
     * Either reset or preserve the basic timestamps associated with the model.
     * That is, the created by/time and updated by/time.
     */
    protected void applyBasicTimestamps(MyBasicTimestampsIF from, MyBasicTimestampsIF to)
    {
        if ( !getIncludeBasicTimestamps() )
            return;

        getAccess().disableBasicTimestampsFor(to);

        MyUser fromCreatedBy = from.getCreatedBy();
        MyUser toCreatedBy = transfer(fromCreatedBy);

        MyUser fromUpdatedBy = from.getUpdatedBy();
        MyUser toUpdatedBy = transfer(fromUpdatedBy);

        to.setCreatedBy(toCreatedBy);
        to.setCreatedUtcTs(from.getCreatedUtcTs());

        to.setUpdatedBy(toUpdatedBy);
        to.setCreatedUtcTs(to.getUpdatedUtcTs());
    }

    protected void applyContact(MyContactIF from, MyContactIF to)
    {
        to.setFirstName(from.getFirstName());
        to.setLastName(from.getLastName());
        to.setNickname(from.getNickname());
        to.setEmail(from.getEmail());
        to.setPhone(from.getPhone());
        to.setTitle(from.getTitle());
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void printOn(KmIndentPrintWriter out)
    {
        out.printfln(formatTypeName());
        out.printfln(formatTitle(getSource()));
        out.printfln(formatAction());
        out.println();

        printChildrenOn(out);
    }

    private String formatAction()
    {
        MyTransferAction type = getActionType();
        if ( type == null )
            return "Undefined";

        switch ( type )
        {
            case NoSource:
            case Add:
            case AlreadyUpdated:
            case Exists:
            case SkipAdd:
            case SkipUpdate:
            case Update:
                return type.getLabel();

            case Error:
                return "Error: " + getErrorMessage();
        }
        throw Kmu.newEnumError(type);
    }

    //##################################################
    //# find
    //##################################################

    //==================================================
    //= find :: blurb
    //==================================================

    protected MyBlurb findBlurbFor(MyBlurb from)
    {
        MyBlurb to = map(from);
        if ( to != null )
            return to;

        MyProject project = getTargetProject();
        String name = from.getName();
        return getAccess().getBlurbDao().findName(project, name);
    }

    //==================================================
    //= find :: customer
    //==================================================

    protected MyCustomer findCustomerFor(MyCustomer from)
    {
        MyCustomer to = map(from);
        if ( to != null )
            return to;

        MyProject project = getTargetProject();
        String name = from.getName();
        return getAccess().getCustomerDao().findName(project, name);
    }

    //==================================================
    //= find :: customer contact
    //==================================================

    protected MyCustomerContact findCustomerContactFor(MyCustomerContact from)
    {
        MyCustomerContact to = map(from);
        if ( to != null )
            return to;

        MyCustomer toCustomer = findCustomerFor(from.getCustomer());
        if ( toCustomer == null )
            return null;

        String fullName = from.getFullName();
        KmList<MyCustomerContact> toContacts = toCustomer.getContactsByFullName();
        return toContacts.selectFirst(e -> e.hasFullName(fullName));
    }

    //==================================================
    //= find :: email templates
    //==================================================

    protected MyEmailTemplate findEmailTemplateFor(MyEmailTemplate from)
    {
        MyEmailTemplate to = map(from);
        if ( to != null )
            return to;

        String name = from.getName();
        MyEmailTemplateContextType type = from.getContextType();
        KmList<MyEmailTemplate> toEmailTemplates = getTargetProject().getEmailTemplatesByName();
        return toEmailTemplates.selectFirst(e -> e.hasName(name) && e.hasContextType(type));
    }

    //==================================================
    //= find :: priority
    //==================================================

    protected MyPriority findPriorityFor(MyPriority from)
    {
        MyPriority to = map(from);
        if ( to != null )
            return to;

        MyProject project = getTargetProject();
        String name = from.getName();
        return getAccess().getPriorityDao().findName(project, name);
    }

    //==================================================
    //= find :: site
    //==================================================

    protected MySite findSiteFor(MySite from)
    {
        MySite to = map(from);
        if ( to != null )
            return to;

        MyCustomer toCustomer = findCustomerFor(from.getCustomer());
        if ( toCustomer == null )
            return null;

        String number = from.getNumber();
        return getAccess().getSiteDao().findNumber(toCustomer, number);
    }

    //==================================================
    //= find :: site contact
    //==================================================

    protected MySiteContact findSiteContactFor(MySiteContact from)
    {
        MySiteContact to = map(from);
        if ( to != null )
            return to;

        MySite toSite = findSiteFor(from.getSite());
        if ( toSite == null )
            return null;

        String fullName = from.getFullName();
        KmList<MySiteContact> toContacts = toSite.getContactsByFullName();
        return toContacts.selectFirst(e -> e.hasFullName(fullName));
    }

    //==================================================
    //= find :: project option
    //==================================================

    protected MyChoice findProjectOptionFor(MyChoice from)
    {
        MyChoice to = map(from);
        if ( to != null )
            return to;

        MyProject project = getTargetProject();
        MyChoiceType type = from.getType();
        String name = from.getName();
        return getAccess().getChoiceDao().findChoice(project, type, name);
    }

    //==================================================
    //= find :: user
    //==================================================

    protected MyUser findUserFor(MyUser from)
    {
        MyUser to = map(from);
        if ( to != null )
            return to;

        MyTenant tenant = getTargetTenant();
        String email = from.getEmail();
        return getAccess().getUserDao().findEmail(tenant, email);
    }

    //==================================================
    //= find :: vendor
    //==================================================

    protected MyVendor findVisitFor(MyVendor from)
    {
        MyVendor to = map(from);
        if ( to != null )
            return to;

        MyProject toProject = getTargetProject();
        String name = from.getName();
        return getAccess().getVendorDao().findName(toProject, name);
    }
}
