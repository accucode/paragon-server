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
     * Copy my properties to the model.
     */
    void applyToModel(Object model);

    /**
     * Copy the model's properties to myself.
     */
    void applyFromModel(Object model);
}
