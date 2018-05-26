package com.app.model;

import com.kodemore.domain.KmUidDomainIF;

import com.app.criteria.MyNoteCriteria;
import com.app.model.base.MyNoteOwnerType;
import com.app.model.base.MyNoteSourceType;
import com.app.model.core.MyProjectDomainIF;

public interface MyNoteOwnerIF
    extends MyProjectDomainIF, KmUidDomainIF
{
    //##################################################
    //# type
    //##################################################

    MyNoteOwnerType getNoteOwnerType();

    //##################################################
    //# apply
    //##################################################

    void applyNoteOwnerTo(MyNote e);

    void applyNoteOwnerTo(MyNoteCriteria e);

    //##################################################
    //# add
    //##################################################

    default MyNote addUserNote(String msg)
    {
        MyNote e;
        e = new MyNote();
        e.applyOwner(this);
        e.setSourceType(MyNoteSourceType.User);
        e.setMessage(msg);
        e.daoAttach();
        return e;

    }

    default MyNote addSystemNote(String msg)
    {
        MyNote e;
        e = new MyNote();
        e.applyOwner(this);
        e.setSourceType(MyNoteSourceType.System);
        e.setMessage(msg);
        e.daoAttach();
        return e;
    }

}
