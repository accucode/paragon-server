package com.app.ui.page.crud.attachment;

import com.app.model.MyAttachment;
import com.app.model.MyAttachmentOwnerIF;
import com.app.ui.page.crud.abstractBase.MyCrudFrame;

public class MyAttachmentFrame
    extends MyCrudFrame<MyAttachmentOwnerIF,MyAttachment>
{
    //##################################################
    //# constructor
    //##################################################

    public MyAttachmentFrame()
    {
        this(new MyAttachmentBuilder());
    }

    public MyAttachmentFrame(MyAttachmentBuilder e)
    {
        super(e);
    }

}
