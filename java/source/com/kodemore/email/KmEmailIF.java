package com.kodemore.email;

import java.util.List;

import com.kodemore.types.KmStringTuple;

public interface KmEmailIF
{
    //##################################################
    //# key
    //##################################################

    /**
     * The key that uniquely identifies this email.
     * Not required by the email tool, but may be used
     * by the client.
     */
    Object getKey();

    //##################################################
    //# header
    //##################################################

    /**
     * The subject line for the email.
     * Typically a single line of text and relatively short.
     */
    String getSubject();

    /**
     * The from address, as displayed.  This is not necessarily
     * the user that sent the email, just the from address to
     * be shows to the recipient.
     */
    String getFrom();

    /**
     * Get additional non-standard headers.
     */
    List<KmStringTuple> getHeaders();

    //##################################################
    //# recipients
    //##################################################

    List<String> getToList();

    List<String> getCcList();

    List<String> getBccList();

    //##################################################
    //# parts
    //##################################################

    List<KmEmailPartIF> getParts();

}
