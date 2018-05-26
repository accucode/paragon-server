package com.app.ui.control;

import com.kodemore.collection.KmList;
import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.servlet.field.ScDomainDropdownField;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoAccess;
import com.app.model.MyPriority;
import com.app.model.MyProject;
import com.app.model.meta.MyMetaPriority;
import com.app.utility.MyGlobals;

public class MyPriorityField
    extends ScDomainDropdownField<MyPriority,String>
{
    //##################################################
    //# variables
    //##################################################

    /**
     * Used to populate the options.
     */
    private ScLocalString _projectUid;

    //##################################################
    //# constructor
    //##################################################

    public MyPriorityField()
    {
        MyMetaPriority x = MyPriority.Meta;

        _projectUid = new ScLocalString();
        _projectUid.setAutoSave();

        setLabel(x.getLabel());
        setHelp(x.getHelp());
        setFinder(MyPriority.Finder);
        setOptionSupplier(this::findOptions);
        setOptionKeyFunction(x.Uid);
        setOptionLabelFunction(x.DomainTitle);
    }

    //##################################################
    //# project
    //##################################################

    public MyProject getProject()
    {
        String uid = _projectUid.getValue();
        return getAccess().findProjectUid(uid);
    }

    public void setProject(MyProject e)
    {
        String uid = KmUidDomainIF.getUidFor(e);
        _projectUid.setValue(uid);
    }

    public boolean hasProject()
    {
        return getProject() != null;
    }

    //##################################################
    //# options
    //##################################################

    private KmList<MyPriority> findOptions()
    {
        checkProject();

        return getProject().getPriorityListBySequence();
    }

    //##################################################
    //# support
    //##################################################

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    private void checkProject()
    {
        if ( !hasProject() )
            throw Kmu.newFatal("No project, usually set in preRender.");
    }

}
