package com.app.model.core;

import com.kodemore.adaptor.KmAdaptorIF;

/**
 * I am a hack to make the autogeneration template simpler.
 */
public interface MyUidDomainIF
    extends MyDomainIF
{
    //##################################################
    //# uid
    //##################################################

    String getUid();

    void setUid(String e);

    //##################################################
    //# static
    //##################################################

    static String getUidFor(MyUidDomainIF e)
    {
        return e == null
            ? null
            : e.getUid();
    }

    static <T extends MyUidDomainIF> KmAdaptorIF<T,String> getUidAdaptor()
    {
        return new KmAdaptorIF<T,String>()
        {
            @Override
            public String getValue(T model)
            {
                return model.getUid();
            }

            @Override
            public void setValue(T model, String value)
            {
                model.setUid(value);
            }
        };
    }
}
