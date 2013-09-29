//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.model.MyNamedCountVoValidator;

import com.kodemore.meta.KmMetaModel;

public class MyMetaNamedCountVo
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaNamedCountVo instance = new MyMetaNamedCountVo();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaNamedCountVo()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "namedCountVo";
    }

    public static MyNamedCountVoValidator getValidator()
    {
        return MyNamedCountVoValidator.instance;
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaNamedCountVo_Name Name = new MyMetaNamedCountVo_Name();
    public static final MyMetaNamedCountVo_Count Count = new MyMetaNamedCountVo_Count();

    //##################################################
    //# associations
    //##################################################

}
