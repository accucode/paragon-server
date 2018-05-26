//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.filter.base;

import com.kodemore.collection.*;
import com.kodemore.hibernate.*;

import com.app.command.base.*;
import com.app.criteria.*;
import com.app.dao.*;
import com.app.dao.base.*;
import com.app.filter.*;
import com.app.filter.core.*;
import com.app.model.*;
import com.app.model.meta.*;

public abstract class MyNoteFilterBase
    extends MyBasicFilter<MyNote>
    implements MyNoteDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyNote> c)
    {
        applyConditionsTo((MyNoteCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyNote> c)
    {
        applySortsTo((MyNoteCriteria)c);
    }

    protected abstract void applyConditionsTo(MyNoteCriteria c);

    protected abstract void applySortsTo(MyNoteCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaNote getMeta()
    {
        return MyNote.Meta;
    }

    @Override
    protected MyNoteDao getDao()
    {
        return getAccess().getNoteDao();
    }

    @Override
    protected MyNoteCriteria createCriteria()
    {
        return new MyNoteCriteria(_createCriteria());
    }
}
