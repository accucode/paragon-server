package com.kodemore.javaParser;

import java.util.Iterator;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

public class KmJavaMethod
{
    //##################################################
    //# variables
    //##################################################

    private String                 _name;
    private String                 _returnType;
    private KmList<KmJavaArgument> _arguments;

    //##################################################
    //# constructor
    //##################################################

    public KmJavaMethod()
    {
        _arguments = new KmList<>();
    }

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

    public KmList<KmJavaArgument> getArguments()
    {
        return _arguments;
    }

    public void setArguments(KmList<KmJavaArgument> e)
    {
        _arguments = e;
    }

    public void addArgument(KmJavaArgument e)
    {
        _arguments.add(e);
    }

    public void addArgument(String name, String type)
    {
        KmJavaArgument e;
        e = new KmJavaArgument();
        e.setType(type);
        e.setName(name);
        addArgument(e);
    }

    public String getReturnType()
    {
        return _returnType;
    }

    public void setReturnType(String e)
    {
        _returnType = e;
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        StringBuilder out = new StringBuilder();

        Iterator<KmJavaArgument> i = _arguments.iterator();
        while ( i.hasNext() )
        {
            out.append(i.next());
            if ( i.hasNext() )
                out.append(", ");
        }

        return Kmu.format("%s %s(%s)", _returnType, _name, out);
    }

}
