package com.app.model;

public abstract class MyAttachments
{
    //##################################################
    //# find owner
    //##################################################

    public static MyAttachment createCopy(MyAttachment from, MyAttachmentOwnerIF toOwner)
    {
        MyAttachment to;
        to = from.getBasicCopy();
        to.applyOwner(toOwner);
        return to;
    }

}
