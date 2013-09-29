//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.criteria;

import com.app.criteria.core.MyAbstractCriteria;
import com.app.dao.base.MySystemLogTraceDaoConstantsIF;
import com.app.model.MySystemLog;
import com.app.model.MySystemLogTrace;

import com.kodemore.hibernate.criteria.KmAbstractCriteria;
import com.kodemore.hibernate.criteria.KmCriteria;
import com.kodemore.hibernate.criteria.KmIntegerCriteria;
import com.kodemore.hibernate.criteria.KmModelJunction;
import com.kodemore.hibernate.criteria.KmStringCriteria;

public class MySystemLogTraceCriteria
    extends MyAbstractCriteria<MySystemLogTrace>
    implements MySystemLogTraceDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MySystemLogTraceCriteria(KmCriteria parent)
    {
        super(parent);
    }

    public MySystemLogTraceCriteria(KmCriteria parent, KmAbstractCriteria context)
    {
        super(parent, context);
    }

    //##################################################
    //# properties
    //##################################################

    public KmIntegerCriteria whereId()
    {
        return new KmIntegerCriteria(context(), fullName(ID));
    }

    public KmIntegerCriteria whereSequence()
    {
        return new KmIntegerCriteria(context(), fullName(SEQUENCE));
    }

    public KmStringCriteria whereValue()
    {
        return new KmStringCriteria(context(), fullName(VALUE));
    }

    //##################################################
    //# sorts
    //##################################################

    public void sortOnId()
    {
        parent().sortAscending(ID);
    }

    public void sortOnIdDescending()
    {
        parent().sortDescending(ID);
    }

    public void sortOnId(boolean asc)
    {
        if ( asc )
            sortOnId();
        else
            sortOnIdDescending();
    }

    public void sortOnSequence()
    {
        parent().sortAscending(SEQUENCE);
    }

    public void sortOnSequenceDescending()
    {
        parent().sortDescending(SEQUENCE);
    }

    public void sortOnSequence(boolean asc)
    {
        if ( asc )
            sortOnSequence();
        else
            sortOnSequenceDescending();
    }

    public void sortOnValue()
    {
        parent().sortAscending(VALUE);
    }

    public void sortOnValueDescending()
    {
        parent().sortDescending(VALUE);
    }

    public void sortOnValue(boolean asc)
    {
        if ( asc )
            sortOnValue();
        else
            sortOnValueDescending();
    }

    //##################################################
    //# projections (id)
    //##################################################

    public void selectId()
    {
        select(ID);
    }

    public void selectDistinctId()
    {
        selectDistinct(ID);
    }

    public void selectCountDistinctId()
    {
        selectCountDistinct(ID);
    }

    public void selectMinimumId()
    {
        selectMinimum(ID);
    }

    public void selectMaximumId()
    {
        selectMaximum(ID);
    }

    public void selectAverageId()
    {
        selectAverage(ID);
    }

    public void selectSumId()
    {
        selectSum(ID);
    }

    public void groupById()
    {
        groupBy(ID);
    }

    //##################################################
    //# projections (sequence)
    //##################################################

    public void selectSequence()
    {
        select(SEQUENCE);
    }

    public void selectDistinctSequence()
    {
        selectDistinct(SEQUENCE);
    }

    public void selectCountDistinctSequence()
    {
        selectCountDistinct(SEQUENCE);
    }

    public void selectMinimumSequence()
    {
        selectMinimum(SEQUENCE);
    }

    public void selectMaximumSequence()
    {
        selectMaximum(SEQUENCE);
    }

    public void selectAverageSequence()
    {
        selectAverage(SEQUENCE);
    }

    public void selectSumSequence()
    {
        selectSum(SEQUENCE);
    }

    public void groupBySequence()
    {
        groupBy(SEQUENCE);
    }

    //##################################################
    //# projections (value)
    //##################################################

    public void selectValue()
    {
        select(VALUE);
    }

    public void selectDistinctValue()
    {
        selectDistinct(VALUE);
    }

    public void selectCountDistinctValue()
    {
        selectCountDistinct(VALUE);
    }

    public void selectMinimumValue()
    {
        selectMinimum(VALUE);
    }

    public void selectMaximumValue()
    {
        selectMaximum(VALUE);
    }

    public void selectAverageValue()
    {
        selectAverage(VALUE);
    }

    public void selectSumValue()
    {
        selectSum(VALUE);
    }

    public void groupByValue()
    {
        groupBy(VALUE);
    }

    //##################################################
    //# association (Log)
    //##################################################

    public void selectLogId()
    {
        select(LOG_ID);
    }

    public void selectMinimumLogId()
    {
        selectMinimum(LOG_ID);
    }

    public void selectMaximumLogId()
    {
        selectMaximum(LOG_ID);
    }

    public void groupByLogId()
    {
        groupBy(LOG);
    }

    public MySystemLogCriteria joinToLog()
    {
        return new MySystemLogCriteria(joinTo(LOG));
    }

    public MySystemLogCriteria leftJoinToLog()
    {
        return new MySystemLogCriteria(leftJoinTo(LOG));
    }

    public KmIntegerCriteria whereLogId()
    {
        return new KmIntegerCriteria(parent(), fullName(LOG_ID));
    }

    public void whereLogIs(MySystemLog e)
    {
        if ( e == null )
            whereLogId().isNull();
        else
            whereLogId().is(e.getId());
    }

    //##################################################
    //# junction
    //##################################################

    public MySystemLogTraceJunction addAnd()
    {
        return new MySystemLogTraceJunction(parent().addAnd());
    }

    public MySystemLogTraceJunction addOr()
    {
        return new MySystemLogTraceJunction(parent().addOr());
    }

    //##################################################
    //# support
    //##################################################

    @Override
    @SuppressWarnings("rawtypes")
    public MySystemLogTraceCriteria createOn(KmModelJunction junction)
    {
        return new MySystemLogTraceCriteria(parent(), junction.context());
    }

}
