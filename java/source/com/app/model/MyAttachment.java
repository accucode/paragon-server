package com.app.model;

import com.kodemore.collection.KmBlob;
import com.kodemore.utility.Kmu;

import com.app.model.base.MyAttachmentBase;
import com.app.model.base.MyAttachmentOwnerType;
import com.app.model.base.MyAttachmentType;
import com.app.model.core.MyProjectDomainIF;
import com.app.utility.MyUrls;

public class MyAttachment
    extends MyAttachmentBase
    implements MyProjectDomainIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAttachment()
    {
        super();
    }

    //##################################################
    //# owner
    //##################################################

    public MyAttachmentOwnerIF getOwner()
    {
        MyAttachmentOwnerType type = getOwnerType();
        switch ( type )
        {
            case Project:
                return getProject();

            case Customer:
                return getCustomer();

            case Site:
                return getSite();
        }
        throw Kmu.newEnumError(type);
    }

    public void applyOwner(MyAttachmentOwnerIF e)
    {
        e.applyAttachmentOwnerTo(this);
    }

    //##################################################
    //# enabled
    //##################################################

    @Override
    public boolean isDomainEnabled()
    {
        return isEnabled();
    }

    @Override
    public String getEnabledStatus()
    {
        return Kmu.formatEnabled(getEnabled());
    }

    //##################################################
    //# content
    //##################################################

    public void setContentString(String s)
    {
        setTypeText();
        setContent(new KmBlob(s));
    }

    public String getContentString()
    {
        return hasContent()
            ? getContent().getUtfValue()
            : null;
    }

    public void setContentImage(byte[] bytes)
    {
        setTypeImage();
        setContentBytes(bytes);
    }

    public void setContentBytes(byte[] bytes)
    {
        setContent(new KmBlob(bytes));
    }

    public byte[] getContentBytes()
    {
        return hasContent()
            ? getContent().getValue()
            : null;
    }

    //##################################################
    //# url
    //##################################################

    public String formatUrl()
    {
        return MyUrls.getAttachmentUrl(this);
    }

    //##################################################
    //# type
    //##################################################

    public void setTypeFromName()
    {
        setType(getTypeForName());
    }

    private MyAttachmentType getTypeForName()
    {
        if ( !hasName() )
            return MyAttachmentType.Other;

        String ext = Kmu.getExtension(getName()).toLowerCase();
        switch ( ext )
        {
            case "pdf":
                return MyAttachmentType.Pdf;

            case "png":
            case "jpg":
            case "gif":
                return MyAttachmentType.Image;

            case "txt":
                return MyAttachmentType.Text;
        }

        return MyAttachmentType.Other;
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getAuditLogTitle()
    {
        return getName();
    }

    @Override
    public String getDomainTitle()
    {
        return getName();
    }

    @Override
    public String getDomainSubtitle()
    {
        return getTypeName();
    }

    //##################################################
    //# set owner
    //##################################################

    public void setOwner(MyProject e)
    {
        setOwnerTypeProject();

        setTenant(e.getTenant());
        setProject(e.getProject());
        clearCustomer();
        clearSite();
    }

    public void setOwner(MyCustomer e)
    {
        setOwnerTypeCustomer();

        setTenant(e.getTenant());
        setProject(e.getProject());
        setCustomer(e);
        clearSite();
    }

    public void setOwner(MySite e)
    {
        setOwnerTypeSite();

        setTenant(e.getTenant());
        setProject(e.getProject());
        setCustomer(e.getCustomer());
        setSite(e);
    }
}
