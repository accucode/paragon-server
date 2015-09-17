package com.kodemore.servlet;

/**
 * Apply the model to some target, typically a ui element; or vice-versa.
 *
 * For example, this is used to easily apply the model's attributes to all of the
 * fields in form, or to apply all of the form's fields to the model.
 */
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
