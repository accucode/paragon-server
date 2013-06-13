package com.kodemore.servlet.result;

import com.kodemore.servlet.ScServletData;

public interface ScResultIF
{
    void applyTo(ScServletData data);

    int getLength();
}
