package com.kodemore.servlet;

import com.kodemore.servlet.action.ScContextSupplierIF;

public interface ScPageIF
    extends ScContextSupplierIF, ScModelApplicatorIF
{
    String getTitle();

    boolean requiresUser();

    ScParameterList composeQueryParameters();

    void applyQueryParameters(ScParameterList params);

    void print();
}
