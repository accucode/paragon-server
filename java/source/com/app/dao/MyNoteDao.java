package com.app.dao;

import com.kodemore.collection.KmList;

import com.app.criteria.MyNoteCriteria;
import com.app.dao.base.MyNoteDaoBase;
import com.app.model.MyNote;
import com.app.model.MyNoteOwnerIF;

public class MyNoteDao
    extends MyNoteDaoBase
{
    //##################################################
    //# find notes
    //##################################################

    public KmList<MyNote> findAllFor(MyNoteOwnerIF owner)
    {
        MyNoteCriteria c;
        c = createCriteria();
        owner.applyNoteOwnerTo(c);
        return c.findAll();
    }

}
