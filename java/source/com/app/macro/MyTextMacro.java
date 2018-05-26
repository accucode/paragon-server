package com.app.macro;

import java.util.function.Function;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.utility.ScFormatter;

import com.app.utility.MyGlobals;

/**
 * I am used for substitutions in templates that are edited
 * directly by users (non-developers).
 */
public class MyTextMacro
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
     * A function that converts a domain model into a display value.
     * The ScFormatter is used to convert the value to a string.
     */
    private Function<?,? extends Object> _function;

    //##################################################
    //# sample
    //##################################################

    @Override
    public String getSamplePlaintext()
    {
        return _sampleText;
    }

    @Override
    public String getSampleHtml()
    {
        KmHtmlBuilder b;
        b = new KmHtmlBuilder();
        b.print(getSamplePlaintext());
        return b.formatHtml();
    }

    public void setSampleText(String e)
    {
        _sampleText = e;
    }

    //##################################################
    //# function
    //##################################################

    public Function<?,?> getFunction()
    {
        return _function;
    }

    public void setFunction(Function<?,?> e)
    {
        _function = e;
    }

    public boolean hasFunction()
    {
        return _function != null;
    }

    //##################################################
    //# format
    //##################################################

    @Override
    public String formatPlaintext(Object e)
    {
        ScFormatter f = getFormatter();

        return e == null
            ? f.formatNull()
            : f.formatAny(apply(e));
    }

    @Override
    public String formatHtml(Object e)
    {
        KmHtmlBuilder b;
        b = new KmHtmlBuilder();
        b.print(formatPlaintext(e));
        return b.formatHtml();
    }

    @SuppressWarnings(
    {
        "rawtypes",
        "unchecked"
    })
    private Object apply(Object e)
    {
        return ((Function)getFunction()).apply(e);
    }

    //##################################################
    //# support
    //##################################################

    private ScFormatter getFormatter()
    {
        return MyGlobals.getFormatter();
    }
}
