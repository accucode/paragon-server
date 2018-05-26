package com.app.macro.builder;

import com.kodemore.time.KmClock;

import com.app.macro.MyMacroDomainType;

/**
 * I build the macros for a specific domain type.
 */
public class MyGlobalMacroBuilder
    extends MyAbstractMacroBuilder
{
    //##################################################
    //# setup
    //##################################################

    @Override
    protected MyMacroDomainType getDomainType()
    {
        return MyMacroDomainType.Global;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void addAll()
    {
        addText("Today", "01/01/2016", (x) -> KmClock.getLocalDate(), "Today's Date");
    }
}
