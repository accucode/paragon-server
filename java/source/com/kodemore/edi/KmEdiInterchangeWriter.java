package com.kodemore.edi;

import java.io.IOException;
import java.io.Writer;

import com.kodemore.utility.KmWriteableIF;

public class KmEdiInterchangeWriter
    implements KmWriteableIF
{
    //##################################################
    //# variables
    //##################################################

    private KmEdiInterchange _interchange;

    //##################################################
    //# constructor
    //##################################################

    public KmEdiInterchangeWriter(KmEdiInterchange x)
    {
        super();
        _interchange = x;
    }

    //##################################################
    //# io
    //##################################################

    @Override
    public void writeOn(Writer w) throws IOException
    {
        KmEdiWriter x;
        x = new KmEdiWriter(w);
        x.writeInterchange(_interchange);
        x.flush();
    }

}
