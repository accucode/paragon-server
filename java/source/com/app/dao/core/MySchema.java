package com.app.dao.core;

import com.kodemore.utility.Kmu;

/**
 * Used to consolidate the references to schema data.
 */
public class MySchema
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The common name.  Used for class name, file names, etc.
     */
    private String _name;

    /**
     * The name used for the database schema and connection.
     */
    private String _databaseName;

    //##################################################
    //# accessing
    //##################################################

    public String getName()
    {
        return _name;
    }

    public void setName(String e)
    {
        _name = e;
    }

    public String getDatabaseName()
    {
        return _databaseName;
    }

    public void setDatabaseName(String e)
    {
        _databaseName = e;
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return Kmu.format("Schema(%s)", _name);
    }
}
