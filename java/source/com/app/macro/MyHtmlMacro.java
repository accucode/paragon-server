package com.app.macro;

import java.util.function.Function;

import com.kodemore.servlet.utility.ScFormatter;

import com.app.utility.MyGlobals;

/**
 * I am used for substitutions in templates that are edited
 * directly by users (non-developers). I will return formatted HTML.
 */
public class MyHtmlMacro
    extends MyMacro
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The sample text to be used for mockups when a real
     * domain model is not available.
     */
    private String _sampleText;

    /**
     * The sample html to be used for mockups when a real
     * domain model is not available.
     */
    private String _sampleHtml;

    /**
     * A function that converts a domain model into a display value.
     * The ScFormatter is used to convert the value to a string.
     */
    private Function<?,? extends Object> _textFunction;

    /**
     * A function that converts a domain model into a display value.
     * The ScFormatter is used to convert the value to a string.
     */
    private Function<?,? extends Object> _htmlFunction;

    //##################################################
    //# sample
    //##################################################

    @Override
    public String getSamplePlaintext()
    {
        return _sampleText;
    }

    public void setSampleText(String e)
    {
        _sampleText = e;
    }

    @Override
    public String getSampleHtml()
    {
        return _sampleHtml;
    }

    public void setSampleHtml(String e)
    {
        _sampleHtml = e;
    }

    //##################################################
    //# function
    //##################################################

    public Function<?,?> getTextFunction()
    {
        return _textFunction;
    }

    public void setTextFunction(Function<?,?> e)
    {
        _textFunction = e;
    }

    public boolean hasTextFunction()
    {
        return _textFunction != null;
    }

    public Function<?,?> getHtmlFunction()
    {
        return _htmlFunction;
    }

    public void setHtmlFunction(Function<?,?> e)
    {
        _htmlFunction = e;
    }

    public boolean hasHtmlFunction()
    {
        return _htmlFunction != null;
    }

    //##################################################
    //# format
    //##################################################

    @Override
    public String formatHtml(Object e)
    {
        ScFormatter f = getFormatter();

        return e == null
            ? f.formatNull()
            : f.formatAny(applyHtml(e));
    }

    @Override
    public String formatPlaintext(Object e)
    {
        ScFormatter f = getFormatter();

        return e == null
            ? f.formatNull()
            : f.formatAny(applyText(e));
    }

    @SuppressWarnings(
    {
        "rawtypes",
        "unchecked"
    })
    private Object applyText(Object e)
    {
        return ((Function)getTextFunction()).apply(e);
    }

    @SuppressWarnings(
    {
        "rawtypes",
        "unchecked"
    })
    private Object applyHtml(Object e)
    {
        return ((Function)getHtmlFunction()).apply(e);
    }

    //##################################################
    //# support
    //##################################################

    private ScFormatter getFormatter()
    {
        return MyGlobals.getFormatter();
    }
}
