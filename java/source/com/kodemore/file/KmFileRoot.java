package com.kodemore.file;

import com.kodemore.utility.Kmu;

/**
 * I am used to provide access to an artifical file system root.
 * Any KmFile(s) derived from me will be constrained to a child
 * directory.   Any attempt to access a directory outside of
 * myself will result in an error.  See main() for examples.
 */
public class KmFileRoot
    implements KmFileConstantsIF
{
    //##################################################
    //# variables
    //##################################################

    private String _path;

    //##################################################
    //# constructor
    //##################################################

    public KmFileRoot(String path)
    {
        _path = Kmu.getCanonicalPath(path);
    }

    //##################################################
    //# accessing
    //##################################################

    public String getPath()
    {
        return _path;
    }

    public KmFile getFolder()
    {
        return new KmFile(this, SLASH);
    }

    public KmFile getChild(String path)
    {
        return getFolder().getChild(path);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return _path;
    }
}
