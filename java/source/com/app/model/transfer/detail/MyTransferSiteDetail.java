package com.app.model.transfer.detail;

import com.kodemore.collection.KmList;

import com.app.model.MyCustomer;
import com.app.model.MyNote;
import com.app.model.MyNoteOwnerIF;
import com.app.model.MySite;
import com.app.model.MySiteContact;

public class MyTransferSiteDetail
    extends MyTransferAbstractDetail<MySite>
{
    //##################################################
    //# constructor
    //##################################################

    public MyTransferSiteDetail(MySite source)
    {
        super(source);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MySite findTargetFor(MySite from)
    {
        return findSiteFor(from);
    }

    //##################################################
    //# transfer
    //##################################################

    @Override
    protected MySite transferAdd(MySite from)
    {
        MyCustomer fromCustomer = from.getCustomer();
        MyCustomer toCustomer = findCustomerFor(fromCustomer);

        MySite to;
        to = new MySite();
        to.setCustomer(toCustomer);

        map(from, to);
        apply(from, to);
        return to;
    }

    @Override
    protected void transferUpdate(MySite from, MySite to)
    {
        apply(from, to);
    }

    private void apply(MySite from, MySite to)
    {
        to.applyEditableFieldsFrom(from);
        applyBasicTimestamps(from, to);
        to.setType(transfer(from.getType()));
        to.setPriority(transfer(from.getPriority()));
        to.daoAttach();

        postAttach(from, to);
    }

    //##################################################
    //# post attach
    //##################################################

    protected void postAttach(MySite from, MySite to)
    {
        flush();

        transferContacts(from, to);
        transferNotes(from, to);
    }

    private void transferContacts(MySite from, MySite to)
    {
        for ( MySiteContact e : from.getContactsByFullName() )
            transfer(e);

        to.setMainContact(transfer(from.getMainContact()));
        to.setInstallContact(transfer(from.getInstallContact()));
        to.setTechnicalContact(transfer(from.getTechnicalContact()));
        to.setRequesterContact(transfer(from.getRequesterContact()));
        to.setSalesContact(transfer(from.getSalesContact()));
        to.setSchedulingContact(transfer(from.getSchedulingContact()));
    }

    private void transferNotes(MyNoteOwnerIF from, MyNoteOwnerIF to)
    {
        KmList<MyNote> fromNotes = getAccess().getNoteDao().findAllFor(from);
        for ( MyNote fromNote : fromNotes )
            copyNote(fromNote, to);
    }

    private MyNote copyNote(MyNote fromNote, MyNoteOwnerIF to)
    {
        MyNote toNote;
        toNote = fromNote.getBasicCopy();
        toNote.applyOwner(to);

        applyBasicTimestamps(fromNote, toNote);
        return toNote;
    }
}
