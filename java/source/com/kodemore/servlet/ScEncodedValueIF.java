package com.kodemore.servlet;

/**
 * Return the value in a format that is suitable for encoding.
 */
public interface ScEncodedValueIF
{
    Object getEncodableValue();

    void setEncodableValue(Object e);
}
