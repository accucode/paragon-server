package com.app.filter;

import com.kodemore.utility.KmNamedEnumIF;

import com.app.criteria.MyMasterProductCriteria;
import com.app.filter.base.MyMasterProductFilterBase;
import com.app.model.MyProject;

public class MyMasterProductFilter
    extends MyMasterProductFilterBase
{
    //##################################################
    //# sort (enum)
    //##################################################

    public static enum Sort
        implements KmNamedEnumIF
    {
        Uid("Uid");

        private String _name;

        private Sort(String name)
        {
            _name = name;
        }

        @Override
        public String getName()
        {
            return _name;
        }
    }

    //##################################################
    //# variables
    //##################################################

    private MyProject _project;
    private boolean   _usesProject;

    private String  _partNumber;
    private boolean _usesPartNumber;

    private Sort    _sort;
    private boolean _sortAscending;

    //##################################################
    //# project
    //##################################################

    public MyProject getProject()
    {
        return _project;
    }

    public void setProject(MyProject e)
    {
        _project = e;
        _usesProject = true;
    }

    public boolean usesProject()
    {
        return _usesProject;
    }

    //##################################################
    //# part number
    //##################################################

    public String getPartNumber()
    {
        return _partNumber;
    }

    public void setPartNumber(String e)
    {
        _partNumber = e;
        _usesPartNumber = true;
    }

    public boolean usesPartNumber()
    {
        return _usesPartNumber;
    }

    //##################################################
    //# sort
    //##################################################

    public void sortOnUid()
    {
        sortOn(Sort.Uid);
    }

    //##################################################
    //# sort (support)
    //##################################################

    public void sortOn(int i)
    {
        sortOn(Sort.values()[i]);
    }

    public void sortOn(Sort e)
    {
        _sort = e;
    }

    public boolean usesSort()
    {
        return _sort != null;
    }

    //##################################################
    //# sort order
    //##################################################

    public void sortAscending()
    {
        sortAscending(true);
    }

    public void sortAscending(boolean e)
    {
        _sortAscending = e;
    }

    public void sortDescending()
    {
        sortAscending(false);
    }

    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(MyMasterProductCriteria c)
    {
        if ( usesProject() )
            c.whereProjectIs(getProject());

        if ( usesPartNumber() )
            c.wherePartNumber().is(getPartNumber());
    }

    @Override
    protected void applySortsTo(MyMasterProductCriteria c)
    {
        if ( !usesSort() )
            return;

        boolean asc = _sortAscending;

        switch ( _sort )
        {
            case Uid:
                c.sortOnUid(asc);
                break;
        }
    }

}
