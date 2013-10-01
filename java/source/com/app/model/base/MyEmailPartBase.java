//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import com.app.model.MyEmail;
import com.app.model.MyEmailPart;
import com.app.model.MyEmailPartTools;
import com.app.model.MyEmailPartType;
import com.app.model.MyEmailPartValidator;
import com.app.model.core.MyAbstractDomain;
import com.app.model.meta.MyMetaEmailPart;

import com.kodemore.collection.KmBlob;
import com.kodemore.collection.KmMap;
import com.kodemore.servlet.utility.ScFormatter;
import com.kodemore.utility.KmProperties;
import com.kodemore.utility.KmSequenceIF;
import com.kodemore.utility.Kmu;

public abstract class MyEmailPartBase
    extends MyAbstractDomain
    implements KmSequenceIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaEmailPart Meta = MyMetaEmailPart.instance;
    public static final MyEmailPartTools Tools = MyEmailPartTools.instance;
    public static final MyEmailPartValidator Validator = MyEmailPartValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private Integer sequence;
    private String typeCode;
    private String attachmentName;
    private KmBlob data;
    private Integer lockVersion;
    private MyEmail email;

    //##################################################
    //# constructor
    //##################################################

    public MyEmailPartBase()
    {
        super();
        setUid(newUid());
    }

    //##################################################
    //# field (uid)
    //##################################################

    public String getUid()
    {
        return uid;
    }

    public void setUid(String e)
    {
        checkReadOnly();
        e = Validator.getUidValidator().convertOnly(e);
        uid = e;
    }

    public void clearUid()
    {
        setUid(null);
    }

    public boolean hasUid()
    {
        return Kmu.hasValue(getUid());
    }

    public boolean hasUid(String e)
    {
        return Kmu.isEqualIgnoreCase(getUid(), e);
    }

    public void truncateUid()
    {
        truncateUid(false);
    }

    public void truncateUid(boolean ellipses)
    {
        uid = Kmu.truncate(uid, 30, ellipses);
    }

    //##################################################
    //# field (sequence)
    //##################################################

    @Override
    public Integer getSequence()
    {
        return sequence;
    }

    @Override
    public void setSequence(Integer e)
    {
        checkReadOnly();
        e = Validator.getSequenceValidator().convertOnly(e);
        sequence = e;
    }

    public void clearSequence()
    {
        setSequence(null);
    }

    public boolean hasSequence()
    {
        return getSequence() != null;
    }

    public boolean hasSequence(Integer e)
    {
        return Kmu.isEqual(getSequence(), e);
    }

    //##################################################
    //# field (typeCode)
    //##################################################

    public String getTypeCode()
    {
        return typeCode;
    }

    public void setTypeCode(String e)
    {
        checkReadOnly();
        e = Validator.getTypeCodeValidator().convertOnly(e);
        typeCode = e;
    }

    public void clearTypeCode()
    {
        setTypeCode(null);
    }

    public boolean hasTypeCode()
    {
        return Kmu.hasValue(getTypeCode());
    }

    public boolean hasTypeCode(String e)
    {
        return Kmu.isEqualIgnoreCase(getTypeCode(), e);
    }

    public void truncateTypeCode()
    {
        truncateTypeCode(false);
    }

    public void truncateTypeCode(boolean ellipses)
    {
        typeCode = Kmu.truncate(typeCode, 1, ellipses);
    }

    public MyEmailPartType getType()
    {
        return MyEmailPartType.findCode(getTypeCode());
    }

    public void setType(MyEmailPartType e)
    {
        if ( e == null )
            setTypeCode(null);
        else
            setTypeCode(e.getCode());
    }

    public boolean hasType()
    {
        return getType() != null;
    }

    public boolean hasType(MyEmailPartType e)
    {
        return getType() == e;
    }

    public void setTypeText()
    {
        setType(MyEmailPartType.Text);
    }

    public boolean isTypeText()
    {
        return hasType(MyEmailPartType.Text);
    }

    public boolean isNotTypeText()
    {
        return !isTypeText();
    }

    public void setTypeHtml()
    {
        setType(MyEmailPartType.Html);
    }

    public boolean isTypeHtml()
    {
        return hasType(MyEmailPartType.Html);
    }

    public boolean isNotTypeHtml()
    {
        return !isTypeHtml();
    }

    public void setTypeAttachment()
    {
        setType(MyEmailPartType.Attachment);
    }

    public boolean isTypeAttachment()
    {
        return hasType(MyEmailPartType.Attachment);
    }

    public boolean isNotTypeAttachment()
    {
        return !isTypeAttachment();
    }

    //##################################################
    //# field (attachmentName)
    //##################################################

    public String getAttachmentName()
    {
        return attachmentName;
    }

    public void setAttachmentName(String e)
    {
        checkReadOnly();
        e = Validator.getAttachmentNameValidator().convertOnly(e);
        attachmentName = e;
    }

    public void clearAttachmentName()
    {
        setAttachmentName(null);
    }

    public boolean hasAttachmentName()
    {
        return Kmu.hasValue(getAttachmentName());
    }

    public boolean hasAttachmentName(String e)
    {
        return Kmu.isEqualIgnoreCase(getAttachmentName(), e);
    }

    public void truncateAttachmentName()
    {
        truncateAttachmentName(false);
    }

    public void truncateAttachmentName(boolean ellipses)
    {
        attachmentName = Kmu.truncate(attachmentName, 30, ellipses);
    }

    //##################################################
    //# field (data)
    //##################################################

    public KmBlob getData()
    {
        return data;
    }

    public void setData(KmBlob e)
    {
        checkReadOnly();
        e = Validator.getDataValidator().convertOnly(e);
        data = e;
    }

    public void clearData()
    {
        setData(null);
    }

    public boolean hasData()
    {
        return getData() != null;
    }

    public boolean hasData(KmBlob e)
    {
        return Kmu.isEqual(getData(), e);
    }

    //##################################################
    //# field (lockVersion)
    //##################################################

    public Integer getLockVersion()
    {
        return lockVersion;
    }

    public void setLockVersion(Integer e)
    {
        checkReadOnly();
        e = Validator.getLockVersionValidator().convertOnly(e);
        lockVersion = e;
    }

    public void clearLockVersion()
    {
        setLockVersion(null);
    }

    public boolean hasLockVersion()
    {
        return getLockVersion() != null;
    }

    public boolean hasLockVersion(Integer e)
    {
        return Kmu.isEqual(getLockVersion(), e);
    }

    //##################################################
    //# field (typeName)
    //##################################################

    public final String getTypeName()
    {
        return Kmu.getName(getType());
    }

    public boolean hasTypeName()
    {
        return Kmu.hasValue(getTypeName());
    }

    public boolean hasTypeName(String e)
    {
        return Kmu.isEqualIgnoreCase(getTypeName(), e);
    }

    //##################################################
    //# email
    //##################################################

    public MyEmail getEmail()
    {
        return email;
    }

    public void setEmail(MyEmail e)
    {
        checkReadOnly();
        email = e;
    }

    public void _setEmail(MyEmail e)
    {
        checkReadOnly();
        email = e;
    }

    public void clearEmail()
    {
        setEmail(null);
    }

    public boolean hasEmail()
    {
        return getEmail() != null;
    }

    public boolean hasEmail(MyEmail e)
    {
        return Kmu.isEqual(getEmail(), e);
    }


    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyEmailPart)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyEmailPart)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyEmailPart)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyEmailPart getCopy()
    {
        return (MyEmailPart)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = null;
        email = null;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyEmailPartBase) )
            return false;

        MyEmailPartBase e = (MyEmailPartBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyEmailPart e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyEmailPart e)
    {
        if ( !Kmu.isEqual(getSequence(), e.getSequence()) ) return false;
        if ( !Kmu.isEqual(getTypeCode(), e.getTypeCode()) ) return false;
        if ( !Kmu.isEqual(getAttachmentName(), e.getAttachmentName()) ) return false;
        if ( !Kmu.isEqual(getData(), e.getData()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( !Kmu.isEqual(getTypeName(), e.getTypeName()) ) return false;
        return true;
    }

    public boolean isDifferent(MyEmailPart e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyEmailPart e)
    {
        return !isSameIgnoringKey(e);
    }

    //##################################################
    //# property
    //##################################################

    public void importPropertyMap(KmMap<String,String> map)
    {
        KmProperties p;
        p = new KmProperties();
        p.setMap(map);

        if ( p.hasKey("uid") )
            setUid(p.getString("uid"));

        if ( p.hasKey("sequence") )
            setSequence(p.getInteger("sequence"));

        if ( p.hasKey("typeCode") )
            setTypeCode(p.getString("typeCode"));

        if ( p.hasKey("attachmentName") )
            setAttachmentName(p.getString("attachmentName"));

        if ( p.hasKey("lockVersion") )
            setLockVersion(p.getInteger("lockVersion"));
    }

    public KmMap<String,String> exportPropertyMap()
    {
        KmProperties p;
        p = new KmProperties();

        if ( hasUid() )
            p.setString("uid", getUid());

        if ( hasSequence() )
            p.setInteger("sequence", getSequence());

        if ( hasTypeCode() )
            p.setString("typeCode", getTypeCode());

        if ( hasAttachmentName() )
            p.setString("attachmentName", getAttachmentName());

        if ( hasLockVersion() )
            p.setInteger("lockVersion", getLockVersion());

        return p.getMap();
    }


    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MyEmailPart");
        sb.append("(");
        sb.append("Uid=");
        sb.append(uid);
        sb.append(")");
        return sb.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    Uid = " + uid);
        System.out.println("    Sequence = " + sequence);
        System.out.println("    TypeCode = " + typeCode);
        System.out.println("    AttachmentName = " + attachmentName);
        System.out.println("    Data = " + data);
        System.out.println("    LockVersion = " + lockVersion);
    }

    /**
     * Format the primary key fields in a comma separated list.  The format
     * is intended to be suitable for display to users.
     */
    public String formatPrimaryKey()
    {
        StringBuilder sb = new StringBuilder();
        ScFormatter f = getFormatter();
        sb.append(f.formatAny(uid));
        return sb.toString();
    }

}
