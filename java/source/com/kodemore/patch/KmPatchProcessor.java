package com.kodemore.patch;

import com.kodemore.collection.KmList;
import com.kodemore.database.KmDatabaseTool;
import com.kodemore.utility.Kmu;

public class KmPatchProcessor
{
    //##################################################
    //# static
    //##################################################

    public static void upgrade(KmPatch e)
    {
        KmPatchProcessor pp;
        pp = new KmPatchProcessor();
        pp.setPatch(e);
        pp.upgrade();
    }

    public static void downgrade(KmPatch e)
    {
        KmPatchProcessor pp;
        pp = new KmPatchProcessor();
        pp.setPatch(e);
        pp.downgrade();
    }

    //##################################################
    //# constants
    //##################################################

    private static final String COMMENT_PREFIX   = "#";
    private static final String DIRECTIVE_PREFIX = "#!";
    private static final Object NEW_LINE         = "\r\n";

    //##################################################
    //# variables (setup)
    //##################################################

    /**
     * The patch to be processed.
     */
    private KmPatch             _patch;

    /**
     * Is the process upgrading or downgrading the database.
     */
    private boolean             _upgrading;

    //##################################################
    //# variables (processing)
    //##################################################

    /**
     * Is the processor currently processing a section marked for
     * upgrade, downgrade, or unknown(null).
     */
    private Boolean             _upgradeSection;

    /**
     * The partial statement being collected.  Statements are assumed
     * to end under the following conditions: 1) a semi-colon at the
     * end of line; 2) A comment; 3) end of file.
     */
    private StringBuilder       _statement;

    /**
     * The entire script runs in a single connection.  Additionally,
     * the entire script generally runs in a single transaction.
     * However, many operations commonly found in patches ignore
     * transaction boundaries, so that cannot be relied on.
     * E.g.: "alter table..."
     */
    private KmDatabaseTool      _databaseTool;

    //##################################################
    //# accessing
    //##################################################

    public void setPatch(KmPatch e)
    {
        _patch = e;
    }

    //##################################################
    //# run
    //##################################################

    public void upgrade()
    {
        _upgrading = true;
        run();
    }

    public void downgrade()
    {
        _upgrading = false;
        run();
    }

    //##################################################
    //# private
    //##################################################

    private void run()
    {
        _databaseTool = new KmDatabaseTool();
        _databaseTool.open();
        try
        {
            runConnection();
            _databaseTool.commit();
        }
        finally
        {
            _databaseTool.closeSafely();
        }
    }

    private void runConnection()
    {
        _upgradeSection = null;
        _statement = new StringBuilder();

        KmList<String> lines = Kmu.parseLines(_patch.getSource());
        for ( String line : lines )
            processLine(line);

        executeStatement();
    }

    private void processLine(String line)
    {
        String trimmed = line.trim();
        if ( trimmed.length() == 0 )
            return;

        if ( trimmed.startsWith(COMMENT_PREFIX) )
        {
            executeStatement();

            if ( trimmed.startsWith(DIRECTIVE_PREFIX) )
                processDirective(line);

            return;
        }

        _statement.append(line);
        _statement.append(NEW_LINE);

        if ( trimmed.endsWith(";") )
            executeStatement();
    }

    private void executeStatement()
    {
        String s = _statement.toString().trim();
        _statement.setLength(0);

        if ( s.length() == 0 )
            return;

        if ( !isSectionActive() )
            return;

        _databaseTool.execute(s);
    }

    private void processDirective(String s)
    {
        s = s.trim();
        s = Kmu.removePrefix(s, DIRECTIVE_PREFIX);
        s = s.trim();

        if ( s.equals("UPGRADE") )
        {
            _upgradeSection = true;
            return;
        }

        if ( s.equals("DOWNGRADE") )
        {
            _upgradeSection = false;
            return;
        }

        if ( s.startsWith("ECHO") )
        {
            if ( isSectionActive() )
            {
                s = Kmu.removePrefix(s, "ECHO").trim();
                System.out.println(s);
            }
            return;
        }

        if ( s.startsWith("ERROR") )
        {
            if ( isSectionActive() )
            {
                s = Kmu.removePrefix(s, "ERROR").trim();
                throw new RuntimeException(s);
            }
            return;
        }

        throw new RuntimeException("Unknown directive: " + s);
    }

    private boolean isSectionActive()
    {
        return _upgrading == _upgradeSection;
    }

}
