package com.kodemore.property;

import java.io.File;

import com.kodemore.collection.KmMap;
import com.kodemore.log.KmLog;
import com.kodemore.utility.KmPropertyFileReader;

/**
 * I am a specialized property registry that knows how to load
 * its values from a specific property file.  The file must roughly
 * in the form a a java properties file; a list of lines, each line
 * defines one property and each line in the form: key = value.
 * If the same key is defined multiple times, only the the last
 * definition is used.
 */
public class KmPropertyFileRegistry
    extends KmPropertyRegistry
{
    //##################################################
    //# variables
    //##################################################

    private String _path;

    //##################################################
    //# constructor
    //##################################################

    public KmPropertyFileRegistry()
    {
        _path = null;
    }

    //##################################################
    //# accessing
    //##################################################

    public String getPath()
    {
        return _path;
    }

    public void setPath(String path)
    {
        _path = path;
    }

    public boolean pathExists()
    {
        if ( _path == null )
            return false;
        File f = new File(_path);
        return f.exists() && f.isFile();
    }

    //##################################################
    //# load
    //##################################################

    public void load()
    {
        if ( !pathExists() )
        {
            KmLog.warn("Cannot load properties for file: %s.", _path);
            clearValues();
        }

        KmPropertyFileReader r;
        r = new KmPropertyFileReader();
        KmMap<String,String> m = r.readFile(_path);

        setValues(m);
    }

}
