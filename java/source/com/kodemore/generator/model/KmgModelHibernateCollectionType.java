package com.kodemore.generator.model;

public class KmgModelHibernateCollectionType
{
    //##################################################
    //# types
    //##################################################

    public static KmgModelHibernateCollectionType getType()
    {
        return new KmgModelHibernateCollectionType();
    }

    //##################################################
    //# accessing
    //##################################################

    public String getName()
    {
        return "bag";
    }

    public String getJavaType()
    {
        return "List";
    }

    public String getJavaImpl()
    {
        return "ArrayList";
    }

    public String getJavaWrapper()
    {
        return "KmCollection";
    }

    public String getJavaImplWrapper()
    {
        return "KmHibernateCollection";
    }

    public boolean getUsesSequence()
    {
        return false;
    }

    public boolean getInverse()
    {
        return false;
    }
}
