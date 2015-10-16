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
import com.app.model.meta.*;

public class MyApplicationLogCriteria
    extends MyAbstractCriteria<MyApplicationLog>
    implements MyApplicationLogDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyApplicationLogCriteria(KmhCriteria parent)
    {
        super(parent);
    }

    //##################################################
    //# properties
    //##################################################

    public KmhStringCondition whereUid()
    {
        return new KmhStringCondition(context(), fullName(UID));
    }

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), fullName(CREATED_UTC_TS));
    }

    public KmhStringCondition whereLoggerName()
    {
        return new KmhStringCondition(context(), fullName(LOGGER_NAME));
    }

    public KmhStringCondition whereContext()
    {
        return new KmhStringCondition(context(), fullName(CONTEXT));
    }

    public KmhStringCondition whereMessage()
    {
        return new KmhStringCondition(context(), fullName(MESSAGE));
    }

    public KmhStringCondition whereLevelName()
    {
        return new KmhStringCondition(context(), fullName(LEVEL_NAME));
    }

    public KmhIntegerCondition whereLevelCode()
    {
        return new KmhIntegerCondition(context(), fullName(LEVEL_CODE));
    }

    public KmhStringCondition whereThreadName()
    {
        return new KmhStringCondition(context(), fullName(THREAD_NAME));
    }

    public KmhStringCondition whereTrace()
    {
        return new KmhStringCondition(context(), fullName(TRACE));
    }

    //##################################################
    //# sorts
    //##################################################

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

    public void sortOnLoggerName()
    {
        parent().sortAscending(LOGGER_NAME);
    }

    public void sortOnLoggerNameDescending()
    {
        parent().sortDescending(LOGGER_NAME);
    }

    public void sortOnLoggerName(boolean asc)
    {
        if ( asc )
            sortOnLoggerName();
        else
            sortOnLoggerNameDescending();
    }

    public void sortOnContext()
    {
        parent().sortAscending(CONTEXT);
    }

    public void sortOnContextDescending()
    {
        parent().sortDescending(CONTEXT);
    }

    public void sortOnContext(boolean asc)
    {
        if ( asc )
            sortOnContext();
        else
            sortOnContextDescending();
    }

    public void sortOnMessage()
    {
        parent().sortAscending(MESSAGE);
    }

    public void sortOnMessageDescending()
    {
        parent().sortDescending(MESSAGE);
    }

    public void sortOnMessage(boolean asc)
    {
        if ( asc )
            sortOnMessage();
        else
            sortOnMessageDescending();
    }

    public void sortOnLevelName()
    {
        parent().sortAscending(LEVEL_NAME);
    }

    public void sortOnLevelNameDescending()
    {
        parent().sortDescending(LEVEL_NAME);
    }

    public void sortOnLevelName(boolean asc)
    {
        if ( asc )
            sortOnLevelName();
        else
            sortOnLevelNameDescending();
    }

    public void sortOnLevelCode()
    {
        parent().sortAscending(LEVEL_CODE);
    }

    public void sortOnLevelCodeDescending()
    {
        parent().sortDescending(LEVEL_CODE);
    }

    public void sortOnLevelCode(boolean asc)
    {
        if ( asc )
            sortOnLevelCode();
        else
            sortOnLevelCodeDescending();
    }

    public void sortOnThreadName()
    {
        parent().sortAscending(THREAD_NAME);
    }

    public void sortOnThreadNameDescending()
    {
        parent().sortDescending(THREAD_NAME);
    }

    public void sortOnThreadName(boolean asc)
    {
        if ( asc )
            sortOnThreadName();
        else
            sortOnThreadNameDescending();
    }

    public void sortOnTrace()
    {
        parent().sortAscending(TRACE);
    }

    public void sortOnTraceDescending()
    {
        parent().sortDescending(TRACE);
    }

    public void sortOnTrace(boolean asc)
    {
        if ( asc )
            sortOnTrace();
        else
            sortOnTraceDescending();
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
    //# projections (loggerName)
    //##################################################

    public void selectLoggerName()
    {
        select(LOGGER_NAME);
    }

    public void selectDistinctLoggerName()
    {
        selectDistinct(LOGGER_NAME);
    }

    public void selectCountDistinctLoggerName()
    {
        selectCountDistinct(LOGGER_NAME);
    }

    public void selectMinimumLoggerName()
    {
        selectMinimum(LOGGER_NAME);
    }

    public void selectMaximumLoggerName()
    {
        selectMaximum(LOGGER_NAME);
    }

    public void selectAverageLoggerName()
    {
        selectAverage(LOGGER_NAME);
    }

    public void selectSumLoggerName()
    {
        selectSum(LOGGER_NAME);
    }

    public void groupByLoggerName()
    {
        groupBy(LOGGER_NAME);
    }

    //##################################################
    //# projections (context)
    //##################################################

    public void selectContext()
    {
        select(CONTEXT);
    }

    public void selectDistinctContext()
    {
        selectDistinct(CONTEXT);
    }

    public void selectCountDistinctContext()
    {
        selectCountDistinct(CONTEXT);
    }

    public void selectMinimumContext()
    {
        selectMinimum(CONTEXT);
    }

    public void selectMaximumContext()
    {
        selectMaximum(CONTEXT);
    }

    public void selectAverageContext()
    {
        selectAverage(CONTEXT);
    }

    public void selectSumContext()
    {
        selectSum(CONTEXT);
    }

    public void groupByContext()
    {
        groupBy(CONTEXT);
    }

    //##################################################
    //# projections (message)
    //##################################################

    public void selectMessage()
    {
        select(MESSAGE);
    }

    public void selectDistinctMessage()
    {
        selectDistinct(MESSAGE);
    }

    public void selectCountDistinctMessage()
    {
        selectCountDistinct(MESSAGE);
    }

    public void selectMinimumMessage()
    {
        selectMinimum(MESSAGE);
    }

    public void selectMaximumMessage()
    {
        selectMaximum(MESSAGE);
    }

    public void selectAverageMessage()
    {
        selectAverage(MESSAGE);
    }

    public void selectSumMessage()
    {
        selectSum(MESSAGE);
    }

    public void groupByMessage()
    {
        groupBy(MESSAGE);
    }

    //##################################################
    //# projections (levelName)
    //##################################################

    public void selectLevelName()
    {
        select(LEVEL_NAME);
    }

    public void selectDistinctLevelName()
    {
        selectDistinct(LEVEL_NAME);
    }

    public void selectCountDistinctLevelName()
    {
        selectCountDistinct(LEVEL_NAME);
    }

    public void selectMinimumLevelName()
    {
        selectMinimum(LEVEL_NAME);
    }

    public void selectMaximumLevelName()
    {
        selectMaximum(LEVEL_NAME);
    }

    public void selectAverageLevelName()
    {
        selectAverage(LEVEL_NAME);
    }

    public void selectSumLevelName()
    {
        selectSum(LEVEL_NAME);
    }

    public void groupByLevelName()
    {
        groupBy(LEVEL_NAME);
    }

    //##################################################
    //# projections (levelCode)
    //##################################################

    public void selectLevelCode()
    {
        select(LEVEL_CODE);
    }

    public void selectDistinctLevelCode()
    {
        selectDistinct(LEVEL_CODE);
    }

    public void selectCountDistinctLevelCode()
    {
        selectCountDistinct(LEVEL_CODE);
    }

    public void selectMinimumLevelCode()
    {
        selectMinimum(LEVEL_CODE);
    }

    public void selectMaximumLevelCode()
    {
        selectMaximum(LEVEL_CODE);
    }

    public void selectAverageLevelCode()
    {
        selectAverage(LEVEL_CODE);
    }

    public void selectSumLevelCode()
    {
        selectSum(LEVEL_CODE);
    }

    public void groupByLevelCode()
    {
        groupBy(LEVEL_CODE);
    }

    //##################################################
    //# projections (threadName)
    //##################################################

    public void selectThreadName()
    {
        select(THREAD_NAME);
    }

    public void selectDistinctThreadName()
    {
        selectDistinct(THREAD_NAME);
    }

    public void selectCountDistinctThreadName()
    {
        selectCountDistinct(THREAD_NAME);
    }

    public void selectMinimumThreadName()
    {
        selectMinimum(THREAD_NAME);
    }

    public void selectMaximumThreadName()
    {
        selectMaximum(THREAD_NAME);
    }

    public void selectAverageThreadName()
    {
        selectAverage(THREAD_NAME);
    }

    public void selectSumThreadName()
    {
        selectSum(THREAD_NAME);
    }

    public void groupByThreadName()
    {
        groupBy(THREAD_NAME);
    }

    //##################################################
    //# projections (trace)
    //##################################################

    public void selectTrace()
    {
        select(TRACE);
    }

    public void selectDistinctTrace()
    {
        selectDistinct(TRACE);
    }

    public void selectCountDistinctTrace()
    {
        selectCountDistinct(TRACE);
    }

    public void selectMinimumTrace()
    {
        selectMinimum(TRACE);
    }

    public void selectMaximumTrace()
    {
        selectMaximum(TRACE);
    }

    public void selectAverageTrace()
    {
        selectAverage(TRACE);
    }

    public void selectSumTrace()
    {
        selectSum(TRACE);
    }

    public void groupByTrace()
    {
        groupBy(TRACE);
    }

    //##################################################
    //# junction
    //##################################################

    public MyApplicationLogJunction addAnd()
    {
        return new MyApplicationLogJunction(parent().addAnd());
    }

    public MyApplicationLogJunction addOr()
    {
        return new MyApplicationLogJunction(parent().addOr());
    }
}
