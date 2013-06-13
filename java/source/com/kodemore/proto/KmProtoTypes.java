package com.kodemore.proto;

import com.kodemore.collection.KmMap;

public abstract class KmProtoTypes
{
    //##################################################
    //# public
    //##################################################

    public static KmMap<String,KmProtoType> getAll()
    {
        return _all;
    }

    public static KmProtoType get(String name)
    {
        return _all.get(name);
    }

    //##################################################
    //# private
    //##################################################

    private static KmMap<String,KmProtoType> _all = composeMap();

    private static KmMap<String,KmProtoType> composeMap()
    {
        KmMap<String,KmProtoType> m = new KmMap<String,KmProtoType>();

        add(m, new KmProtoBoolean());
        add(m, new KmProtoBlob());
        add(m, new KmProtoHtmlColor());
        add(m, new KmProtoDate());
        add(m, new KmProtoDayFrequency());
        add(m, new KmProtoDouble());
        add(m, new KmProtoInteger());
        add(m, new KmProtoLong());
        add(m, new KmProtoMoney());
        add(m, new KmProtoKilogram());
        add(m, new KmProtoQuantity());
        add(m, new KmProtoRate());
        add(m, new KmProtoCost());
        add(m, new KmProtoString());
        add(m, new KmProtoTime());
        add(m, new KmProtoTimestamp());

        return m;
    }

    private static void add(KmMap<String,KmProtoType> m, KmProtoType e)
    {
        m.put(e.getName(), e);
    }

}
