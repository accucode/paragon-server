package com.kodemore.servlet.action;

import com.kodemore.servlet.utility.ScKeyIF;

public interface ScActionIF
    extends ScKeyIF
{
    //##################################################
    //# core
    //##################################################

    @Override
    String getKey();

    void run();

    ScActionContextIF getContext();

    //##################################################
    //# other
    //##################################################

    String getJavascriptFunction();
}
