package com.app.model;

import com.app.model.base.MyNoteOwnerType;

public abstract class MyNotes
{
    //##################################################
    //# find owner
    //##################################################

    public static MyNote createCopy(MyNote from, MyNoteOwnerIF toOwner)
    {
        MyNote to;
        to = from.getBasicCopy();
        to.applyOwner(toOwner);
        return to;
    }

}
