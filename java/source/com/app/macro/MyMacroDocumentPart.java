package com.app.macro;

import com.kodemore.utility.KmEnumIF;
import com.kodemore.utility.Kmu;

/**
 * I am a part of a macro document. Either a literal or a macro.
 * If type is macro, I can validate the macro.
 */
public class MyMacroDocumentPart
{
    //##################################################
    //# type
    //##################################################

    private enum Type
        implements KmEnumIF
    {
        Literal,
        Macro;
    }

    //##################################################
    //# constants
    //##################################################

    private static String MACRO_START_TOKEN       = "$(";
    private static String MACRO_END_TOKEN         = ")";
    private static String MACRO_OPTIONS_DELIMITER = ",";

    //##################################################
    //# static
    //##################################################

    /**
     * Create a new document part.  If the source is likely a macro, this will
     * attempt to parse and return a macro part.  If a macro cannot be parsed it
     * will return a literal.
     */
    public static MyMacroDocumentPart createFrom(String source)
    {
        MyMacroDocumentPart e;
        e = new MyMacroDocumentPart();
        e.setSource(source);

        if ( isLikelyMacro(source) )
        {
            e.parseMacro();
            return e;
        }

        e.setTypeLiteral();
        return e;
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * The type of part that I represent. E.g.: literal or macro.
     */
    private Type _type;

    /**
     * The original template source.
     * For literals, the original source IS the value we output.
     * For macros, the source is used to determine the macro key and options.
     */
    private String _source;

    /**
     * The macro associated with this part.
     * This is combined with the options if needed to render the part.
     */
    private MyMacro _macro;

    /**
     * The options associated with this macro.
     * Not all macros have options so this may be null for macros.
     */
    private String _macroOptions;

    //##################################################
    //# constructor
    //##################################################

    /**
     * Clients should use the instance creation methods above.
     */
    private MyMacroDocumentPart()
    {
        // private
    }

    //##################################################
    //# type :: accessing
    //##################################################

    public Type getType()
    {
        return _type;
    }

    public boolean isTypeLiteral()
    {
        return getType() == Type.Literal;
    }

    public boolean isTypeMacro()
    {
        return getType() == Type.Macro;
    }

    //==================================================
    //= type :: private
    //==================================================

    private void setType(Type e)
    {
        _type = e;
    }

    public void setTypeLiteral()
    {
        setType(Type.Literal);
    }

    public void setTypeMacro()
    {
        setType(Type.Macro);
    }

    //##################################################
    //# literal
    //##################################################

    private String getSource()
    {
        return _source;
    }

    private void setSource(String e)
    {
        _source = e;
    }

    //##################################################
    //# macro
    //##################################################

    public MyMacro getMacro()
    {
        return _macro;
    }

    private void setMacro(MyMacro e)
    {
        _macro = e;
    }

    private boolean hasMacro()
    {
        return getMacro() != null;
    }

    //==================================================
    //= macro :: options
    //==================================================

    /**
     * These are currently unused.  This is set up so we can
     * support macro options such as image sizing in the future;
     */
    @SuppressWarnings("unused")
    private String getMacroOptions()
    {
        return _macroOptions;
    }

    private void setMacroOptions(String e)
    {
        _macroOptions = e;
    }

    //==================================================
    //= macro :: domain type
    //==================================================

    public MyMacroDomainType getMacroDomainType()
    {
        return hasMacro()
            ? getMacro().getDomainType()
            : null;
    }

    public boolean hasMacroDomainType(MyMacroDomainType e)
    {
        return Kmu.isEqual(getMacroDomainType(), e);
    }

    //##################################################
    //# format value
    //##################################################

    public String formatValuePlaintext(Object e)
    {
        Type type = getType();
        switch ( type )
        {
            case Macro:
                return formatValueMacroPlaintext(e);

            case Literal:
                return getSource();
        }
        throw Kmu.newEnumError(type);
    }

    public String formatValueHtml(Object e)
    {
        Type type = getType();
        switch ( type )
        {
            case Macro:
                return formatValueMacroHtml(e);

            case Literal:
                return getSource();
        }
        throw Kmu.newEnumError(type);
    }

    //==================================================
    //= format value :: private
    //==================================================

    private String formatValueMacroPlaintext(Object e)
    {
        if ( hasMacro() )
            return getMacro().formatPlaintext(e);

        return getSource();
    }

    private String formatValueMacroHtml(Object e)
    {
        if ( hasMacro() )
            return getMacro().formatHtml(e);

        return getSource();
    }

    //##################################################
    //# format sample
    //##################################################

    public String formatSampleHtml()
    {
        return formatSample(true);
    }

    public String formatSamplePlaintext()
    {
        return formatSample(false);
    }

    //==================================================
    //= format sample :: private
    //==================================================

    private String formatSample(boolean html)
    {
        Type type = getType();
        switch ( type )
        {
            case Macro:
                return formatSampleMacro(html);

            case Literal:
                return getSource();
        }
        throw Kmu.newEnumError(type);
    }

    private String formatSampleMacro(boolean html)
    {
        if ( html )
            return formatSampleMacroHtml();

        return formatSampleMacroPlaintext();
    }

    private String formatSampleMacroPlaintext()
    {
        if ( hasMacro() )
            return getMacro().getSamplePlaintext();

        return Kmu.format(">>>>>%s<<<<<", getSource());
    }

    private String formatSampleMacroHtml()
    {
        if ( hasMacro() )
            return getMacro().getSampleHtml();

        return Kmu.format("<span style='color:red;font-weight:bold'>%s</span>", getSource());
    }

    //##################################################
    //# parse marco
    //##################################################

    private static boolean isLikelyMacro(String source)
    {
        if ( !source.startsWith(MACRO_START_TOKEN) )
            return false;

        if ( !source.endsWith(MACRO_END_TOKEN) )
            return false;

        return true;
    }

    private void parseMacro()
    {
        String token;
        token = getSource();
        token = Kmu.removePrefix(token, MACRO_START_TOKEN);
        token = Kmu.removeSuffix(token, MACRO_END_TOKEN);

        String key = token;
        String options = null;

        if ( Kmu.containsAny(token, MACRO_OPTIONS_DELIMITER) )
        {
            key = Kmu.getBeforeFirst(token, MACRO_OPTIONS_DELIMITER);
            options = Kmu.getAfterFirst(token, MACRO_OPTIONS_DELIMITER);
        }

        MyMacro macro = MyMacros.findKey(key);
        if ( macro == null )
        {
            setTypeLiteral();
            return;
        }

        setTypeMacro();
        setMacro(macro);
        setMacroOptions(options);
    }
}
