package com.kodemore.generator.extend;

import com.kodemore.generator.KmgRoot;
import com.kodemore.generator.model.KmgModel;
import com.kodemore.generator.model.KmgModelField;

public abstract class KmgFieldExtender
{
    public void extendAll(KmgRoot r)
    {
        for ( KmgModel m : r.getModels() )
            for ( KmgModelField f : m.getFields().getShallowCopy() )
                extend(f);
    }

    public abstract void extend(KmgModelField field);

}
