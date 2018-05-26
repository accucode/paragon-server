package com.app.macro;

import com.kodemore.utility.Kmu;

/**
 * I parse text into a macro document.
 */
public class MyMacroDocumentParser
{
    //##################################################
    //# static
    //##################################################

    public static MyMacroDocument staticParse(String template)
    {
        MyMacroDocumentParser p;
        p = new MyMacroDocumentParser();
        return p.parse(template);
    }

    //##################################################
    //# constants
    //##################################################

    private static String MACRO_START_TOKEN = "$(";
    private static String MACRO_END_TOKEN   = ")";

    //##################################################
    //# variables
    //##################################################

    private MyMacroDocument _document;
    private String          _buffer;

    //##################################################
    //# buffer
    //##################################################

    private String getBuffer()
    {
        return _buffer;
    }

    private void setBuffer(String e)
    {
        _buffer = e;
    }

    private void clearBuffer()
    {
        setBuffer(null);
    }

    //##################################################
    //# parse
    //##################################################

    public MyMacroDocument parse(String template)
    {
        setBuffer(template);

        _document = new MyMacroDocument();

        while ( true )
        {
            MyMacroDocumentPart part = getNextPart();

            if ( part == null )
                return _document;

            _document.addPart(part);
        }
    }

    private MyMacroDocumentPart getNextPart()
    {
        if ( Kmu.isEmpty(getBuffer()) )
            return null;

        if ( atMacro() )
            return getNextMacroPart();

        return getNextTextPart();
    }

    private MyMacroDocumentPart getNextMacroPart()
    {
        String template = getBuffer();
        if ( Kmu.isEmpty(template) )
            return null;

        int index = template.indexOf(MACRO_END_TOKEN) + 1;

        // end
        if ( index <= 0 )
        {
            MyMacroDocumentPart part = MyMacroDocumentPart.createFrom(template);
            clearBuffer();
            return part;
        }

        // get all up to and including ")"
        String text = template.substring(0, index);
        MyMacroDocumentPart part = MyMacroDocumentPart.createFrom(text);

        // trim template text
        template = template.substring(index);
        setBuffer(template);

        return part;
    }

    private MyMacroDocumentPart getNextTextPart()
    {
        String template = getBuffer();
        if ( Kmu.isEmpty(template) )
            return null;

        int index = template.indexOf(MACRO_START_TOKEN);

        // end
        if ( index <= 0 )
        {
            MyMacroDocumentPart part = MyMacroDocumentPart.createFrom(template);
            clearBuffer();
            return part;
        }

        // get all before "$("
        String text = template.substring(0, index);
        MyMacroDocumentPart part = MyMacroDocumentPart.createFrom(text);

        // trim template text
        template = template.substring(index);
        setBuffer(template);

        return part;
    }

    //##################################################
    //# mode
    //##################################################

    private boolean atMacro()
    {
        String template = getBuffer();

        if ( Kmu.isEmpty(template) )
            return false;

        if ( template.startsWith(MACRO_START_TOKEN) )
            return true;

        return false;
    }
}
