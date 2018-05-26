package com.app.model;

import com.kodemore.utility.Kmu;

import com.app.model.base.MyPriorityBase;
import com.app.model.base.MyPriorityCategory;
import com.app.model.core.MyProjectDomainIF;
import com.app.model.support.MyPrioritySequence;
import com.app.model.transfer.MyTransferrableIF;
import com.app.model.transfer.detail.MyTransferPriorityDetail;

public class MyPriority
    extends MyPriorityBase
    implements MyProjectDomainIF, MyTransferrableIF<MyPriority>
{
    //##################################################
    //# constructor
    //##################################################

    public MyPriority()
    {
        super();
    }

    //##################################################
    //# context
    //##################################################

    @Override
    public MyTenant getTenant()
    {
        return getProject().getTenant();
    }

    //##################################################
    //# sequence
    //##################################################

    public MyPrioritySequence getSequence()
    {
        return MyPrioritySequence.findCode(getSequenceCode());
    }

    public void setSequence(MyPrioritySequence e)
    {
        if ( e == null )
        {
            clearSequenceCode();
            return;
        }

        setSequenceCode(e.getCode());
    }

    public boolean hasSequence(MyPrioritySequence e)
    {
        return hasSequenceCode(e.getCode());
    }

    @Override
    public String getSequenceName()
    {
        return getSequence().getLabel();
    }

    //##################################################
    //# category
    //##################################################

    @Override
    protected void updateCategoryCode()
    {
        setCategory(calculateCategory());
    }

    private MyPriorityCategory calculateCategory()
    {
        MyPrioritySequence e = getSequence();
        if ( e == null )
            return null;

        switch ( e )
        {
            case High1:
            case High2:
            case High3:
                return MyPriorityCategory.High;

            case Low1:
            case Low2:
            case Low3:
                return MyPriorityCategory.Low;

            case Normal1:
            case Normal2:
            case Normal3:
                return MyPriorityCategory.Normal;
        }
        throw Kmu.newEnumError(e);
    }

    //##################################################
    //# transfer
    //##################################################

    @Override
    public MyTransferPriorityDetail newTransferDetail()
    {
        return new MyTransferPriorityDetail(this);
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
        return getSequenceName();
    }

}
