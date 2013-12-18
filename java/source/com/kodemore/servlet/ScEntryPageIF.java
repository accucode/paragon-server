package com.kodemore.servlet;

/**
 * Entry pages are those that do not require extra parameters for configuration.
 * These pages can be easily used by buttons and hyperlinks.
 */
public interface ScEntryPageIF
{
    String getTitle();

    void push();

    String formatQueryString();
}
