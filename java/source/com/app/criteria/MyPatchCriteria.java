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

public class MyPatchCriteria
    extends MyAbstractCriteria<MyPatch>
    implements MyPatchDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyPatchCriteria(KmhCriteria parent)
    {
        super(parent);
    }

    //##################################################
    //# properties
    //##################################################

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), fullName(NAME));
    }

    public KmhPropertyCondition<KmTimestamp> whereInstalledUtcTs()
    {
        return new KmhPropertyCondition<>(context(), fullName(INSTALLED_UTC_TS));
    }

    public KmhStringCondition whereSource()
    {
        return new KmhStringCondition(context(), fullName(SOURCE));
    }

    //##################################################
    //# sorts
    //##################################################

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

    public void sortOnInstalledUtcTs()
    {
        parent().sortAscending(INSTALLED_UTC_TS);
    }

    public void sortOnInstalledUtcTsDescending()
    {
        parent().sortDescending(INSTALLED_UTC_TS);
    }

    public void sortOnInstalledUtcTs(boolean asc)
    {
        if ( asc )
            sortOnInstalledUtcTs();
        else
            sortOnInstalledUtcTsDescending();
    }

    public void sortOnSource()
    {
        parent().sortAscending(SOURCE);
    }

    public void sortOnSourceDescending()
    {
        parent().sortDescending(SOURCE);
    }

    public void sortOnSource(boolean asc)
    {
        if ( asc )
            sortOnSource();
        else
            sortOnSourceDescending();
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
    //# projections (installedUtcTs)
    //##################################################

    public void selectInstalledUtcTs()
    {
        select(INSTALLED_UTC_TS);
    }

    public void selectDistinctInstalledUtcTs()
    {
        selectDistinct(INSTALLED_UTC_TS);
    }

    public void selectCountDistinctInstalledUtcTs()
    {
        selectCountDistinct(INSTALLED_UTC_TS);
    }

    public void selectMinimumInstalledUtcTs()
    {
        selectMinimum(INSTALLED_UTC_TS);
    }

    public void selectMaximumInstalledUtcTs()
    {
        selectMaximum(INSTALLED_UTC_TS);
    }

    public void selectAverageInstalledUtcTs()
    {
        selectAverage(INSTALLED_UTC_TS);
    }

    public void selectSumInstalledUtcTs()
    {
        selectSum(INSTALLED_UTC_TS);
    }

    public void groupByInstalledUtcTs()
    {
        groupBy(INSTALLED_UTC_TS);
    }

    //##################################################
    //# projections (source)
    //##################################################

    public void selectSource()
    {
        select(SOURCE);
    }

    public void selectDistinctSource()
    {
        selectDistinct(SOURCE);
    }

    public void selectCountDistinctSource()
    {
        selectCountDistinct(SOURCE);
    }

    public void selectMinimumSource()
    {
        selectMinimum(SOURCE);
    }

    public void selectMaximumSource()
    {
        selectMaximum(SOURCE);
    }

    public void selectAverageSource()
    {
        selectAverage(SOURCE);
    }

    public void selectSumSource()
    {
        selectSum(SOURCE);
    }

    public void groupBySource()
    {
        groupBy(SOURCE);
    }

    //##################################################
    //# junction
    //##################################################

    public MyPatchJunction addAnd()
    {
        return new MyPatchJunction(parent().addAnd());
    }

    public MyPatchJunction addOr()
    {
        return new MyPatchJunction(parent().addOr());
    }
}
