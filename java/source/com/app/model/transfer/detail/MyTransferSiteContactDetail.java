package com.app.model.transfer.detail;

import com.app.model.MySite;
import com.app.model.MySiteContact;

public class MyTransferSiteContactDetail
    extends MyTransferAbstractDetail<MySiteContact>
{
    //##################################################
    //# constructor
    //##################################################

    public MyTransferSiteContactDetail(MySiteContact source)
    {
        super(source);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MySiteContact findTargetFor(MySiteContact from)
    {
        return findSiteContactFor(from);
    }

    //##################################################
    //# transfer
    //##################################################

    @Override
    protected MySiteContact transferAdd(MySiteContact from)
    {
        MySite fromSite = from.getSite();
        MySite toSite = findSiteFor(fromSite);

        if ( toSite == null )
            throw newError(
                "Cannot transfer contact (%s), you must first transfer site (%s).",
                from.getFullName(),
                fromSite.getName());

        MySiteContact to;
        to = new MySiteContact();
        to.setSite(toSite);

        map(from, to);
        apply(from, to);
        return to;
    }

    @Override
    protected void transferUpdate(MySiteContact from, MySiteContact to)
    {
        apply(from, to);
    }

    //##################################################
    //# apply
    //##################################################

    private void apply(MySiteContact from, MySiteContact to)
    {
        to.applyEditableFieldsFrom(from);
        applyBasicTimestamps(from, to);
        to.daoAttach();
    }

}
