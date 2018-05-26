package com.app.ui.info;

import com.kodemore.string.KmStringBuilder;

import com.app.model.MySite;

public class MySiteInfo
    extends MyDomainInfo<MySite>
{
    //##################################################
    //# text
    //##################################################

    @Override
    protected String getLabelFor(MySite e)
    {
        return "Site";
    }

    @Override
    protected String getNameFor(MySite e)
    {
        return e.getFullName();
    }

    @Override
    protected String getHelpFor(MySite e)
    {
        KmStringBuilder out;
        out = new KmStringBuilder();

        if ( e.hasAddress() )
            out.println(e.getAddressMultiLine());

        if ( e.hasMainContact() )
            out.print(e.getMainContactSummaryMultiline());

        return out.toString();
    }

    //##################################################
    //# find
    //##################################################

    @Override
    protected MySite findTargetFor(String uid)
    {
        return getAccess().findSiteUid(uid);
    }

    //##################################################
    //# open
    //##################################################

    @Override
    protected void openLinkFor(MySite e)
    {
        e.ajaxEnterPage();
    }

    @Override
    protected String formatPopoutUrlFor(MySite e)
    {
        return e.formatEntryUrl();
    }
}
