package com.app.macro;

import java.util.function.Function;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.utility.ScFormatter;
import com.kodemore.servlet.utility.ScUrls;
import com.kodemore.utility.Kmu;

import com.app.utility.MyGlobals;

/**
 * I am used for substitutions in templates that are edited
 * directly by users (non-developers).
 */
public class MyImageMacro
    extends MyMacro
{
    //##################################################
    //# variables
    //##################################################

    /**
     * A function that converts a domain model into a the encoded image source.
     */
    private Function<?,String> _encodedfunction;

    /**
     * A function that converts a domain model into the image name.
     */
    private Function<?,String> _namefunction;

    //##################################################
    //# sample
    //##################################################

    @Override
    public String getSamplePlaintext()
    {
        return Kmu.format("[Image: %s]", "sampleImage.png");
    }

    @Override
    public String getSampleHtml()
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.open("img");
        out.printAttribute("src", ScUrls.getThemeImage("placeholder.png"));
        out.printAttribute("alt", "sampleImage.png");
        out.close();

        return out.formatHtml();
    }

    //##################################################
    //# function
    //##################################################

    public Function<?,String> getEncodedfunction()
    {
        return _encodedfunction;
    }

    public void setEncodedfunction(Function<?,String> sourcefunction)
    {
        _encodedfunction = sourcefunction;
    }

    public boolean hasEncodedFunction()
    {
        return _encodedfunction != null;
    }

    //==================================================
    //= function :: name
    //==================================================

    public Function<?,String> getNamefunction()
    {
        return _namefunction;
    }

    public void setNameFunction(Function<?,String> e)
    {
        _namefunction = e;
    }

    public boolean hasFunction()
    {
        return _namefunction != null;
    }

    //##################################################
    //# format
    //##################################################

    @Override
    public String formatPlaintext(Object e)
    {
        ScFormatter f = getFormatter();

        String name = e == null
            ? f.formatNull()
            : f.formatAny(getName(e));

        return Kmu.format("[Image: %s]", name);
    }

    @Override
    public String formatHtml(Object e)
    {
        ScFormatter f = getFormatter();

        String name = e == null
            ? f.formatNull()
            : f.formatAny(getName(e));

        String encoded = getEncoded(e);

        if ( Kmu.isEmpty(encoded) )
            return f.formatNull();

        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.open("img");
        out.printAttribute("src", encoded);
        out.printAttribute("alt", name);
        out.close();

        return out.formatHtml();
    }

    //##################################################
    //# apply
    //##################################################

    @SuppressWarnings(
    {
        "unchecked",
        "rawtypes"
    })
    private Object getName(Object e)
    {
        ScFormatter f = getFormatter();
        Function nameFunction = getNamefunction();

        return e == null
            ? f.formatNull()
            : f.formatAny(nameFunction.apply(e));
    }

    @SuppressWarnings(
    {
        "unchecked",
        "rawtypes"
    })
    private String getEncoded(Object e)
    {
        Function sourceFunction = getEncodedfunction();
        String encoded = (String)sourceFunction.apply(e);
        return encoded;
    }

    //##################################################
    //# support
    //##################################################

    private ScFormatter getFormatter()
    {
        return MyGlobals.getFormatter();
    }
}
