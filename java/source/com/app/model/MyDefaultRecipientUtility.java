package com.app.model;

import com.kodemore.collection.KmList;

import com.app.model.base.MyDefaultRecipientContactType;

public class MyDefaultRecipientUtility
{
    //##################################################
    //# constructor
    //##################################################

    private MyDefaultRecipientUtility()
    {
        // private, use static methods
    }

    //##################################################
    //# project
    //##################################################

    public static KmList<MyDefaultRecipientContactType> getProjectRecipientContactTypes()
    {
        KmList<MyDefaultRecipientContactType> v;
        v = new KmList<>();
        v.add(MyDefaultRecipientContactType.ProjectSupport);
        v.add(MyDefaultRecipientContactType.Custom);
        return v;
    }

    public static KmList<MyDefaultRecipientContactType> getProjectRecipientContactTypesFor(
        MyProject project)
    {
        if ( project == null )
            return KmList.createEmpty();

        KmList<MyDefaultRecipientContactType> v = new KmList<>();

        if ( project.hasSupportContactEmail() )
            v.add(MyDefaultRecipientContactType.ProjectSupport);

        v.add(MyDefaultRecipientContactType.Custom);
        return v;
    }

    //##################################################
    //# job
    //##################################################

    public static KmList<MyDefaultRecipientContactType> getJobRecipientContactTypes()
    {
        KmList<MyDefaultRecipientContactType> v;
        v = new KmList<>();
        v.add(MyDefaultRecipientContactType.Main);
        v.add(MyDefaultRecipientContactType.Install);
        v.add(MyDefaultRecipientContactType.Technical);
        v.add(MyDefaultRecipientContactType.Scheduling);
        v.add(MyDefaultRecipientContactType.Sales);
        v.add(MyDefaultRecipientContactType.Requester);
        v.add(MyDefaultRecipientContactType.CustomerApproval);
        v.add(MyDefaultRecipientContactType.CustomerBilling);
        v.add(MyDefaultRecipientContactType.ProjectNotifications);
        v.add(MyDefaultRecipientContactType.JobNotifications);
        v.add(MyDefaultRecipientContactType.CustomerNotifications);
        v.add(MyDefaultRecipientContactType.Custom);
        return v;
    }

    //##################################################
    //# site
    //##################################################

    public static KmList<MyDefaultRecipientContactType> getSiteRecipientContactTypes()
    {
        return getJobRecipientContactTypes();
    }

}
