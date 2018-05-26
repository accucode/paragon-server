package com.kodemore.domain;

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.servlet.ScModelApplicatorIF;

/**
 * I am a hack to make the autogeneration template simpler.
 */
public interface KmUidDomainIF
    extends KmDomainIF
{
    //##################################################
    //# uid
    //##################################################

    String getUid();

    void setUid(String e);

    //##################################################
    //# apply
    //##################################################

    void applyFrom(ScModelApplicatorIF e);

    void applyTo(ScModelApplicatorIF e);

    //##################################################
    //# static
    //##################################################

    static String getUidFor(KmUidDomainIF e)
    {
        return e == null
            ? null
            : e.getUid();
    }

    static <T extends KmUidDomainIF> KmAdaptorIF<T,String> getUidAdaptor()
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
