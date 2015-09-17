package sandbox.wlove;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDao;

import com.app.criteria.MyProjectCriteria;
import com.app.criteria.MyRegionCriteria;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyProject;
import com.app.model.MyRegion;
import com.app.utility.MyGlobals;
import com.app.utility.MyInstaller;

/**
 * I demonstrate the use of a subquery via hibernate.
 *
 * Find all projects that do NOT have a region with the specified name.
 * We used Detached Criteria to implement a subquery.
 *
 * The sql will look roughly like:
 *      select pOuter.*
 *      from project pOuter
 *      where 0 =
 *        (
 *          select count(*)
 *          from region rInner
 *          where rInner.projectUid = pOuter.uid
 *            and rInner.name = ?
 *        )
 *
 * Cannot use 'having'.
 *      This would be more efficient if written with an sql 'having' clause,
 *      but the hibernate criteria pattern does not support 'having'.
 *      So, we cannot write the query as:
 *          select p.*
 *          from project p left join region r on p.uid = r.projectUid
 *          group by p.uid
 *          having sum( if(r.name=?,1,0) ) = 0;
 */
public class JkHibernateSubqueryTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        System.out.println("----------------");
        new JkHibernateSubqueryTest().start();
        System.out.println("----------------");
        System.out.println("ok.");

    }

    private void start()
    {
        MyInstaller.installDatabase();
        KmDao.run(this::run);
    }

    //##################################################
    //# run
    //##################################################

    private void run()
    {
        KmList<MyProject> v;
        v = findProjectsWithoutRegion2("USA");
        v.sortOn(e -> e.getName());

        for ( MyProject e : v )
            System.out.println(e.getName());
    }

    //##################################################
    //# test
    //##################################################

    public KmList<MyProject> findProjectsWithoutRegion1(String regionName)
    {
        MyProjectCriteria outer = getAccess().getProjectDao().createCriteria();
        String outerUid = outer.parent().getFullName("uid");

        DetachedCriteria inner;
        inner = DetachedCriteria.forClass(MyProject.class, "inner");
        inner.setProjection(Projections.rowCount());
        inner.add(Restrictions.eqProperty("inner.uid", outerUid));
        inner.createCriteria("regions").add(Restrictions.eq("name", regionName));

        outer.parent()._add(Subqueries.eq(0L, inner));
        return outer.findAll();
    }

    public KmList<MyProject> findProjectsWithoutRegion2(String regionName)
    {
        MyProjectCriteria outer = getAccess().getProjectDao().createCriteria();
        String outerUid = outer.parent().getFullName("uid");

        DetachedCriteria inner;
        inner = DetachedCriteria.forClass(MyRegion.class, "inner");
        inner.setProjection(Projections.rowCount());
        inner.add(Restrictions.eq("name", regionName));
        inner.add(Restrictions.eqProperty("inner.project.uid", outerUid));

        outer.parent()._add(Subqueries.eq(0L, inner));
        return outer.findAll();
    }

    public KmList<MyProject> findProjectsWithoutRegion3(String regionName)
    {
        MyProjectCriteria outer = getAccess().getProjectDao().createCriteria();
        String outerUid = outer.parent().getFullName(outer.UID);

        MyRegionCriteria inner;
        inner = getAccess().getRegionDao().createDetachedCriteria("inner");
        inner.selectRowCount();
        inner.whereName().is(regionName);
        inner.whereProjectUid().equalsProperty(outerUid);

        outer.whereSubquery(inner).is(0L);

        return outer.findAll();
    }

    //##################################################
    //# support
    //##################################################

    protected MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }

}
