/*
  Copyright (c) 2005-2014 www.kodemore.com

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
*/

package com.kodemore.hibernate.criteria;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.kodemore.collection.KmMap;
import com.kodemore.utility.Kmu;

public class KmRootCriteria
    extends KmCriteria
{
    //##################################################
    //# variables
    //##################################################

    private int                  _aliasIndex;

    /**
     * Entity name -> criteria
     */
    private KmMap<String,KmJoin> _joins;

    private ProjectionList       _projections;

    //##################################################
    //# constructor
    //##################################################

    public KmRootCriteria(Criteria c)
    {
        super(c, null);
        _joins = new KmMap<String,KmJoin>();
        _projections = null;
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public KmRootCriteria getRoot()
    {
        return this;
    }

    private String getNextAlias()
    {
        return "a" + _aliasIndex++;
    }

    public KmJoin _join(KmCriteria parent, String entityName, int joinType)
    {
        KmJoin j = _joins.get(entityName);
        if ( j != null )
        {
            if ( joinType != j.getType() )
                Kmu.fatal("Rejoin to entity(%s), with wrong join type.", entityName);
            return j;
        }

        String alias = getNextAlias();
        Criteria c = parent.getInnerCriteria().createCriteria(entityName, alias, joinType);
        j = new KmJoin(c, parent, entityName, joinType);
        _joins.put(entityName, j);
        return j;
    }

    //##################################################
    //# projections
    //##################################################

    @Override
    public void addProjection(Projection e)
    {
        if ( _projections == null )
        {
            _projections = Projections.projectionList();
            getInnerCriteria().setProjection(_projections);
        }

        _projections.add(e);
    }
}
