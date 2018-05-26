//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.criteria;

import com.kodemore.collection.*;
import com.kodemore.hibernate.*;
import com.kodemore.hibernate.basic.*;
import com.kodemore.time.*;
import com.kodemore.types.*;

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;

public class MyDownloadJunction
    extends KmhModelJunction
    implements MyDownloadDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyDownloadJunction(KmhJunction context)
    {
        super(context);
    }

    //##################################################
    //# properties
    //##################################################

    public KmhPropertyCondition<KmBlob> whereBytes()
    {
        return new KmhPropertyCondition<>(context(), alias(), BYTES);
    }

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), CREATED_UTC_TS);
    }

    public KmhStringCondition whereFileName()
    {
        return new KmhStringCondition(context(), alias(), FILE_NAME);
    }

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), alias(), NAME);
    }

    public KmhStringCondition whereTypeCode()
    {
        return new KmhStringCondition(context(), alias(), TYPE_CODE);
    }

    public KmhStringCondition whereUid()
    {
        return new KmhStringCondition(context(), alias(), UID);
    }

    public KmhIntegerCondition whereLockVersion()
    {
        return new KmhIntegerCondition(context(), alias(), LOCK_VERSION);
    }

    //##################################################
    //# associations
    //##################################################
    //##################################################
    //# association (Attachment)
    //##################################################

//    public MyAttachmentCriteria joinToAttachment()
//    {
//        return new MyAttachmentCriteria(joinTo(ATTACHMENT));
//    }
//
//    public MyAttachmentCriteria leftJoinToAttachment()
//    {
//        return new MyAttachmentCriteria(leftJoinTo(ATTACHMENT));
//    }

    public KmhStringCondition whereAttachmentUid()
    {
        return new KmhStringCondition(context(), alias(), ATTACHMENT_UID);
    }

    public void whereAttachmentIs(MyAttachment e)
    {
        if ( e == null )
            whereAttachmentUid().isNull();
        else
            whereAttachmentUid().is(e.getUid());
    }

    public void whereAttachmentIsNot(MyAttachment e)
    {
        if ( e == null )
            whereAttachmentUid().isNotNull();
        else
            whereAttachmentUid().isNot(e.getUid());
    }

    //##################################################
    //# association (User)
    //##################################################

//    public MyUserCriteria joinToUser()
//    {
//        return new MyUserCriteria(joinTo(USER));
//    }
//
//    public MyUserCriteria leftJoinToUser()
//    {
//        return new MyUserCriteria(leftJoinTo(USER));
//    }

    public KmhStringCondition whereUserUid()
    {
        return new KmhStringCondition(context(), alias(), USER_UID);
    }

    public void whereUserIs(MyUser e)
    {
        if ( e == null )
            whereUserUid().isNull();
        else
            whereUserUid().is(e.getUid());
    }

    public void whereUserIsNot(MyUser e)
    {
        if ( e == null )
            whereUserUid().isNotNull();
        else
            whereUserUid().isNot(e.getUid());
    }


    //##################################################
    //# junction
    //##################################################

    public MyDownloadJunction addAnd()
    {
        return new MyDownloadJunction(context().addAnd());
    }

    public MyDownloadJunction addOr()
    {
        return new MyDownloadJunction(context().addOr());
    }

}
