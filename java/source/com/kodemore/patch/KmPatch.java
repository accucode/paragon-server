package com.kodemore.patch;

public class KmPatch
    implements Comparable<KmPatch>
{
    //##################################################
    //# variables
    //##################################################

    private String _name;
    private String _source;

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

    public String getSource()
    {
        return _source;
    }

    public void setSource(String e)
    {
        _source = e;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object e)
    {
        if ( !(e instanceof KmPatch) )
            return false;

        return getName().equals(((KmPatch)e).getName());
    }

    @Override
    public int hashCode()
    {
        return getName().hashCode();
    }

    @Override
    public int compareTo(KmPatch e)
    {
        return getName().compareTo(e.getName());
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return getName();
    }
}
