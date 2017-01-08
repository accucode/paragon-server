package com.app.bridge;

import com.kodemore.collection.KmList;
import com.kodemore.database.KmDatabaseConnectionFactory;
import com.kodemore.file.KmFile;
import com.kodemore.patch.KmPatch;
import com.kodemore.patch.KmPatchBridge;
import com.kodemore.sql.KmSqlConnection;
import com.kodemore.sql.KmSqlDelete;
import com.kodemore.sql.KmSqlInsert;
import com.kodemore.sql.KmSqlResultSet;
import com.kodemore.sql.KmSqlSelect;
import com.kodemore.sql.KmSqlStatement;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.Kmu;

import com.app.file.MyResourceFiles;

/**
 * The application specific hooks for the Patch toolkit.
 */
public class MyPatchBridge
    extends KmPatchBridge
{
    //##################################################
    //# install
    //##################################################

    public static void installBridge()
    {
        KmPatchBridge.install(new MyPatchBridge());
    }

    //##################################################
    //# constants
    //##################################################

    private static final String TABLE                   = "patch";
    private static final String ALIAS                   = "p";

    private static final String COLUMN_NAME             = "name";
    private static final String COLUMN_SOURCE           = "source";
    private static final String COLUMN_INSTALLED_UTC_TS = "installedUtcTs";

    //##################################################
    //# local patches
    //##################################################

    @Override
    public KmFile getLocalPatchFolder()
    {
        return MyResourceFiles.getInstance().getPatchDirectory();
    }

    //##################################################
    //# installed patches
    //##################################################

    @Override
    public KmList<KmPatch> getInstalledPatches()
    {
        KmList<KmPatch> v;

        KmSqlConnection con = null;
        KmSqlSelect st = null;
        KmSqlResultSet rs = null;

        try
        {
            v = new KmList<>();

            con = open();

            st = con.createSelect();
            st.from(TABLE, ALIAS);
            st.selectString(ALIAS, COLUMN_NAME);
            st.selectString(ALIAS, COLUMN_SOURCE);
            st.orderBy(ALIAS, COLUMN_NAME);
            st.disableSlowSqlThreshold();

            rs = st.execute(con);
            while ( rs.next() )
            {
                KmPatch p;
                p = new KmPatch();
                p.setName(rs.getString());
                p.setSource(rs.getString());
                v.add(p);
            }
            return v;
        }
        finally
        {
            close(con, st);
        }
    }

    @Override
    public void saveInstalledPatch(KmPatch patch)
    {
        KmSqlConnection con = null;
        KmSqlInsert st = null;
        KmTimestamp now = KmTimestamp.nowUtc();

        try
        {
            con = open();

            st = con.createInsert();
            st.setTable(TABLE);
            st.setStringValue(COLUMN_NAME, patch.getName());
            st.setStringValue(COLUMN_SOURCE, patch.getSource());
            st.setTimestampValue(COLUMN_INSTALLED_UTC_TS, now);
            st.disableSlowSqlThreshold();

            int n = st.execute(con);
            if ( n != 1 )
                throw Kmu.newFatal("Unexpected updated count(%s).", n);

            con.commit();
        }
        finally
        {
            close(con, st);
        }
    }

    @Override
    public void deleteInstalledPatch(KmPatch patch)
    {
        KmSqlConnection con = null;
        KmSqlDelete st = null;

        try
        {
            con = open();

            st = con.createDelete();
            st.setTable(TABLE);
            st.where().isEqual(COLUMN_NAME, patch.getName());
            st.disableSlowSqlThreshold();

            int n = st.execute(con);
            if ( n != 1 )
                throw Kmu.newFatal("Unexpected delete count(%s).", n);

            con.commit();
        }
        finally
        {
            close(con, st);
        }
    }

    //##################################################
    //# support
    //##################################################

    private KmSqlConnection open()
    {
        KmDatabaseConnectionFactory factory;
        factory = KmDatabaseConnectionFactory.getInstance();

        KmSqlConnection con;
        con = factory.open();
        con.useSchema(factory.getDefaultSchema());
        return con;
    }

    private void close(KmSqlConnection con, KmSqlStatement st)
    {
        if ( st != null )
            st.close();

        if ( con != null )
            con.close();
    }

}
