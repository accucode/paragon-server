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

import com.app.criteria.core.*;
import com.app.dao.*;
import com.app.dao.base.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.base.*;
import com.app.model.meta.*;

public class MyDownloadCriteria
    extends MyAbstractCriteria<MyDownload>
    implements MyDownloadDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyDownloadCriteria(KmhCriteria parent)
    {
        super(parent);
    }

    //##################################################
    //# primary key
    //##################################################

    public void whereUidIs(MyDownload e)
    {
        whereUid().is(e.getUid());
    }

    public void whereUidIsNot(MyDownload e)
    {
        whereUid().isNot(e.getUid());
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

    public void whereTypeIs(MyDownloadType e)
    {
        if ( e == null )
            whereTypeCode().isNull();
        else
            whereTypeCode().is(e.getCode());
    }

    public void whereTypeIsNot(MyDownloadType e)
    {
        if ( e == null )
            whereTypeCode().isNull();
        else
            whereTypeCode().isNot(e.getCode());
    }

    public void whereTypeIsFile()
    {
        whereTypeIs(MyDownloadType.File);
    }

    public void whereTypeIsNotFile()
    {
        whereTypeIsNot(MyDownloadType.File);
    }

    public void whereTypeIsFile(boolean e)
    {
        if ( e )
            whereTypeIsFile();
        else
            whereTypeIsNotFile();
    }

    public void whereTypeIsAttachment()
    {
        whereTypeIs(MyDownloadType.Attachment);
    }

    public void whereTypeIsNotAttachment()
    {
        whereTypeIsNot(MyDownloadType.Attachment);
    }

    public void whereTypeIsAttachment(boolean e)
    {
        if ( e )
            whereTypeIsAttachment();
        else
            whereTypeIsNotAttachment();
    }

    public void whereTypeIsBytes()
    {
        whereTypeIs(MyDownloadType.Bytes);
    }

    public void whereTypeIsNotBytes()
    {
        whereTypeIsNot(MyDownloadType.Bytes);
    }

    public void whereTypeIsBytes(boolean e)
    {
        if ( e )
            whereTypeIsBytes();
        else
            whereTypeIsNotBytes();
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
    //# sorts
    //##################################################

    public void sortOnBytes()
    {
        parent().sortAscending(BYTES);
    }

    public void sortOnBytesDescending()
    {
        parent().sortDescending(BYTES);
    }

    public void sortOnBytes(boolean asc)
    {
        if ( asc )
            sortOnBytes();
        else
            sortOnBytesDescending();
    }

    public void sortOnCreatedUtcTs()
    {
        parent().sortAscending(CREATED_UTC_TS);
    }

    public void sortOnCreatedUtcTsDescending()
    {
        parent().sortDescending(CREATED_UTC_TS);
    }

    public void sortOnCreatedUtcTs(boolean asc)
    {
        if ( asc )
            sortOnCreatedUtcTs();
        else
            sortOnCreatedUtcTsDescending();
    }

    public void sortOnFileName()
    {
        parent().sortAscending(FILE_NAME);
    }

    public void sortOnFileNameDescending()
    {
        parent().sortDescending(FILE_NAME);
    }

    public void sortOnFileName(boolean asc)
    {
        if ( asc )
            sortOnFileName();
        else
            sortOnFileNameDescending();
    }

    public void sortOnName()
    {
        parent().sortAscending(NAME);
    }

    public void sortOnNameDescending()
    {
        parent().sortDescending(NAME);
    }

    public void sortOnName(boolean asc)
    {
        if ( asc )
            sortOnName();
        else
            sortOnNameDescending();
    }

    public void sortOnTypeCode()
    {
        parent().sortAscending(TYPE_CODE);
    }

    public void sortOnTypeCodeDescending()
    {
        parent().sortDescending(TYPE_CODE);
    }

    public void sortOnTypeCode(boolean asc)
    {
        if ( asc )
            sortOnTypeCode();
        else
            sortOnTypeCodeDescending();
    }

    public void sortOnUid()
    {
        parent().sortAscending(UID);
    }

    public void sortOnUidDescending()
    {
        parent().sortDescending(UID);
    }

    public void sortOnUid(boolean asc)
    {
        if ( asc )
            sortOnUid();
        else
            sortOnUidDescending();
    }

    public void sortOnLockVersion()
    {
        parent().sortAscending(LOCK_VERSION);
    }

    public void sortOnLockVersionDescending()
    {
        parent().sortDescending(LOCK_VERSION);
    }

    public void sortOnLockVersion(boolean asc)
    {
        if ( asc )
            sortOnLockVersion();
        else
            sortOnLockVersionDescending();
    }

    //##################################################
    //# projections (bytes)
    //##################################################

    public void selectBytes()
    {
        select(BYTES);
    }

    public void selectDistinctBytes()
    {
        selectDistinct(BYTES);
    }

    public void selectCountDistinctBytes()
    {
        selectCountDistinct(BYTES);
    }

    public void selectMinimumBytes()
    {
        selectMinimum(BYTES);
    }

    public void selectMaximumBytes()
    {
        selectMaximum(BYTES);
    }

    public void selectAverageBytes()
    {
        selectAverage(BYTES);
    }

    public void selectSumBytes()
    {
        selectSum(BYTES);
    }

    public void groupByBytes()
    {
        groupBy(BYTES);
    }

    //##################################################
    //# projections (createdUtcTs)
    //##################################################

    public void selectCreatedUtcTs()
    {
        select(CREATED_UTC_TS);
    }

    public void selectDistinctCreatedUtcTs()
    {
        selectDistinct(CREATED_UTC_TS);
    }

    public void selectCountDistinctCreatedUtcTs()
    {
        selectCountDistinct(CREATED_UTC_TS);
    }

    public void selectMinimumCreatedUtcTs()
    {
        selectMinimum(CREATED_UTC_TS);
    }

    public void selectMaximumCreatedUtcTs()
    {
        selectMaximum(CREATED_UTC_TS);
    }

    public void selectAverageCreatedUtcTs()
    {
        selectAverage(CREATED_UTC_TS);
    }

    public void selectSumCreatedUtcTs()
    {
        selectSum(CREATED_UTC_TS);
    }

    public void groupByCreatedUtcTs()
    {
        groupBy(CREATED_UTC_TS);
    }

    //##################################################
    //# projections (fileName)
    //##################################################

    public void selectFileName()
    {
        select(FILE_NAME);
    }

    public void selectDistinctFileName()
    {
        selectDistinct(FILE_NAME);
    }

    public void selectCountDistinctFileName()
    {
        selectCountDistinct(FILE_NAME);
    }

    public void selectMinimumFileName()
    {
        selectMinimum(FILE_NAME);
    }

    public void selectMaximumFileName()
    {
        selectMaximum(FILE_NAME);
    }

    public void selectAverageFileName()
    {
        selectAverage(FILE_NAME);
    }

    public void selectSumFileName()
    {
        selectSum(FILE_NAME);
    }

    public void groupByFileName()
    {
        groupBy(FILE_NAME);
    }

    //##################################################
    //# projections (name)
    //##################################################

    public void selectName()
    {
        select(NAME);
    }

    public void selectDistinctName()
    {
        selectDistinct(NAME);
    }

    public void selectCountDistinctName()
    {
        selectCountDistinct(NAME);
    }

    public void selectMinimumName()
    {
        selectMinimum(NAME);
    }

    public void selectMaximumName()
    {
        selectMaximum(NAME);
    }

    public void selectAverageName()
    {
        selectAverage(NAME);
    }

    public void selectSumName()
    {
        selectSum(NAME);
    }

    public void groupByName()
    {
        groupBy(NAME);
    }

    //##################################################
    //# projections (typeCode)
    //##################################################

    public void selectTypeCode()
    {
        select(TYPE_CODE);
    }

    public void selectDistinctTypeCode()
    {
        selectDistinct(TYPE_CODE);
    }

    public void selectCountDistinctTypeCode()
    {
        selectCountDistinct(TYPE_CODE);
    }

    public void selectMinimumTypeCode()
    {
        selectMinimum(TYPE_CODE);
    }

    public void selectMaximumTypeCode()
    {
        selectMaximum(TYPE_CODE);
    }

    public void selectAverageTypeCode()
    {
        selectAverage(TYPE_CODE);
    }

    public void selectSumTypeCode()
    {
        selectSum(TYPE_CODE);
    }

    public void groupByTypeCode()
    {
        groupBy(TYPE_CODE);
    }

    //##################################################
    //# projections (uid)
    //##################################################

    public void selectUid()
    {
        select(UID);
    }

    public void selectDistinctUid()
    {
        selectDistinct(UID);
    }

    public void selectCountDistinctUid()
    {
        selectCountDistinct(UID);
    }

    public void selectMinimumUid()
    {
        selectMinimum(UID);
    }

    public void selectMaximumUid()
    {
        selectMaximum(UID);
    }

    public void selectAverageUid()
    {
        selectAverage(UID);
    }

    public void selectSumUid()
    {
        selectSum(UID);
    }

    public void groupByUid()
    {
        groupBy(UID);
    }

    //##################################################
    //# projections (lockVersion)
    //##################################################

    public void selectLockVersion()
    {
        select(LOCK_VERSION);
    }

    public void selectDistinctLockVersion()
    {
        selectDistinct(LOCK_VERSION);
    }

    public void selectCountDistinctLockVersion()
    {
        selectCountDistinct(LOCK_VERSION);
    }

    public void selectMinimumLockVersion()
    {
        selectMinimum(LOCK_VERSION);
    }

    public void selectMaximumLockVersion()
    {
        selectMaximum(LOCK_VERSION);
    }

    public void selectAverageLockVersion()
    {
        selectAverage(LOCK_VERSION);
    }

    public void selectSumLockVersion()
    {
        selectSum(LOCK_VERSION);
    }

    public void groupByLockVersion()
    {
        groupBy(LOCK_VERSION);
    }

    //##################################################
    //# association (Attachment)
    //##################################################

    public void selectAttachmentUid()
    {
        select(ATTACHMENT_UID);
    }

    public void selectCountDistinctAttachmentUid()
    {
        selectCountDistinct(ATTACHMENT_UID);
    }
    
    public void selectDistinctAttachmentUid()
    {
        selectDistinct(ATTACHMENT_UID);
    }

    public void selectMinimumAttachmentUid()
    {
        selectMinimum(ATTACHMENT_UID);
    }

    public void selectMaximumAttachmentUid()
    {
        selectMaximum(ATTACHMENT_UID);
    }

    public void groupByAttachmentUid()
    {
        groupBy(ATTACHMENT_UID);
    }

    public MyAttachmentCriteria joinToAttachment()
    {
        return new MyAttachmentCriteria(joinTo(ATTACHMENT));
    }

    public MyAttachmentCriteria leftJoinToAttachment()
    {
        return new MyAttachmentCriteria(leftJoinTo(ATTACHMENT));
    }

    public KmhStringCondition whereAttachmentUid()
    {
        return new KmhStringCondition(parent(), alias(), ATTACHMENT_UID);
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

    public void selectUserUid()
    {
        select(USER_UID);
    }

    public void selectCountDistinctUserUid()
    {
        selectCountDistinct(USER_UID);
    }
    
    public void selectDistinctUserUid()
    {
        selectDistinct(USER_UID);
    }

    public void selectMinimumUserUid()
    {
        selectMinimum(USER_UID);
    }

    public void selectMaximumUserUid()
    {
        selectMaximum(USER_UID);
    }

    public void groupByUserUid()
    {
        groupBy(USER_UID);
    }

    public MyUserCriteria joinToUser()
    {
        return new MyUserCriteria(joinTo(USER));
    }

    public MyUserCriteria leftJoinToUser()
    {
        return new MyUserCriteria(leftJoinTo(USER));
    }

    public KmhStringCondition whereUserUid()
    {
        return new KmhStringCondition(parent(), alias(), USER_UID);
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
    //# junction :: alias
    //##################################################

    public MyDownloadJunction all()
    {
        return addAnd();
    }

    public MyDownloadJunction any()
    {
        return addOr();
    }

    public MyDownloadJunction none()
    {
        return addNotOr();
    }

    //##################################################
    //# junction :: basic
    //##################################################

    public MyDownloadJunction addNotAnd()
    {
        return new MyDownloadJunction(parent().addNotAnd());
    }

    public MyDownloadJunction addNotOr()
    {
        return new MyDownloadJunction(parent().addNotOr());
    }

    public MyDownloadJunction addAnd()
    {
        return new MyDownloadJunction(parent().addAnd());
    }

    public MyDownloadJunction addOr()
    {
        return new MyDownloadJunction(parent().addOr());
    }
}
