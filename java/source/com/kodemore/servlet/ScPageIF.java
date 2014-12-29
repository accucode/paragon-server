package com.kodemore.servlet;

import com.kodemore.servlet.action.ScActionContextIF;

public interface ScPageIF
    extends ScActionContextIF, ScModelApplicatorIF
{
    String getTitle();

    boolean requiresUser();

    ScParameterList composeQueryParameters();

    void applyQueryParameters(ScParameterList params);

    void print();
}
