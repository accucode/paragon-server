package com.kodemore.authnet.model;

import com.kodemore.utility.Kmu;

public class AuthnetResponseMessage
{
    //##################################################
    //# variables
    //##################################################

    private String _code;
    private String _text;

    //##################################################
    //# constructor
    //##################################################

    public AuthnetResponseMessage()
    {
        // none
    }

    //##################################################
    //# code
    //##################################################

    public String getCode()
    {
        return _code;
    }

    public void setCode(String e)
    {
        _code = e;
    }

    public boolean hasCode()
    {
        return Kmu.hasValue(_code);
    }

    //##################################################
    //# text
    //##################################################

    public String getText()
    {
        return _text;
    }

    public void setText(String e)
    {
        _text = e;
    }

    public boolean hasText()
    {
        return Kmu.hasValue(_text);
    }

    //##################################################
    //# display
    //##################################################

    /**
     * A display string suitable for use to end users.  Changing this
     * may affect public application behavior.
     */
    public String format()
    {
        return Kmu.format("%s:%s", getCode(), getText()).trim();
    }

    /**
     * Only used for debuggging.  Change at will.
     */
    @Override
    public String toString()
    {
        return format();
    }
}
