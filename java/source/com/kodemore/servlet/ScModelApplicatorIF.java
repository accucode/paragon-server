package com.kodemore.servlet;

public interface ScModelApplicatorIF
{
    /**
     * Copy some of my properties into the model.
     */
    void applyToModel(Object model);

    /**
     * Copy some of the model's properties into myself.
     */
    void applyFromModel(Object model, boolean skipFields);
}
