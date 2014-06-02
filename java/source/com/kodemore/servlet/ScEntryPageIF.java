package com.kodemore.servlet;

/**
 * Entry pages are those that do not require extra parameters for configuration.
 * These pages can be easily connected directly to buttons and hyperlinks without
 * a custom action to pass the pertinent parameters.
 */
public interface ScEntryPageIF
{
    String getTitle();

    void push();

    String formatQueryString();
}
