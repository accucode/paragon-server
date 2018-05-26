/*
 Copyright 2005-2011 Kodemore.com

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package com.kodemore.utility;

/**
 * I provide the pieces of a basic email address.
 */
public class KmEmailAddress
{
    //##################################################
    //# variables
    //##################################################

    private String _source;
    private String _name;
    private String _host;
    private String _comment;

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        KmEmailAddress e;
        e = new KmEmailAddress();
        e.setName("jsmith");
        e.setHost("example.net");
        e.setComment("John Smith");

        System.out.println(e);
    }

    //##################################################
    //# source
    //##################################################

    public String getSource()
    {
        return _source;
    }

    public void setSource(String e)
    {
        _source = e;
    }

    public boolean hasSource()
    {
        return Kmu.hasValue(getSource());
    }

    //##################################################
    //# name
    //##################################################

    public String getName()
    {
        return _name;
    }

    public void setName(String e)
    {
        _name = e;
    }

    public boolean hasName()
    {
        return Kmu.hasValue(getName());
    }

    //##################################################
    //# host
    //##################################################

    public String getHost()
    {
        return _host;
    }

    public void setHost(String e)
    {
        _host = e;
    }

    public boolean hasHost()
    {
        return Kmu.hasValue(getHost());
    }

    //##################################################
    //# comment
    //##################################################

    public String getComment()
    {
        return _comment;
    }

    public void setComment(String e)
    {
        _comment = e;
    }

    public boolean hasComment()
    {
        return Kmu.hasValue(getComment());
    }

    //##################################################
    //# format
    //##################################################

    /**
     * Format the entire address including the comment.
     * Assuming this is a valid email addreess, this toString
     * should generally be compatible with the format accepted
     * by common email tools such as GMail and Outlook.
     */
    @Override
    public String toString()
    {
        if ( isValid() )
            return format();

        if ( hasSource() )
            return getSource();

        return Kmu.formatMetaValue("none");
    }

    /**
     * Format the entire address, including the comment.
     */
    public String format()
    {
        String s = formatAddress();

        return hasComment()
            ? Kmu.format("%s <%s>", getComment(), s)
            : s;
    }

    /**
     * Format only the formal address part, NOT the comment.
     */
    public String formatAddress()
    {
        return Kmu.format("%s@%s", getName(), getHost());
    }

    //##################################################
    //# validate
    //##################################################

    public boolean isValid()
    {
        return validate().isOk();
    }

    public KmSimpleResult validate()
    {
        KmSimpleResult r;

        r = validateName();
        if ( r.hasError() )
            return r;

        r = validateHost();
        if ( r.hasError() )
            return r;

        r = validateComment();
        if ( r.hasError() )
            return r;

        r = validateAddress();
        return r;
    }

    private KmSimpleResult validateName()
    {
        String s = getName();

        if ( s == null )
            return error("Name is required.");

        if ( s.isEmpty() )
            return error("Name is required.");

        if ( s.length() > 64 )
            return error("Name cannot exceed 64 characters.");

        for ( char c : s.toCharArray() )
            if ( !isValidNameCharacter(c) )
                return error("Name cannot contain %s character.", c);

        if ( s.startsWith(".") )
            return error("Name cannot start with a period.");

        if ( s.endsWith(".") )
            return error("Name cannot end with a period.");

        if ( s.contains("..") )
            return error("Name cannot contain two periods in a row.");

        return ok();
    }

    private boolean isValidNameCharacter(char c)
    {
        if ( c >= 'a' && c <= 'z' )
            return true;

        if ( c >= 'A' && c <= 'Z' )
            return true;

        if ( c >= '0' && c <= '9' )
            return true;

        // final String symbols = ".!#$%&'*+-/=?^_`{|}~";
        final String symbols = ".-_";
        return symbols.indexOf(c) >= 0;
    }

    private KmSimpleResult validateHost()
    {
        String s = getHost();

        if ( s == null )
            return error("Host is required.");

        if ( s.length() == 0 )
            return error("Host is required.");

        if ( s.length() > 253 )
            return error("Host cannot exceen 253 characters.");

        for ( char c : s.toCharArray() )
            if ( !isValidDomainCharacter(c) )
                return error("Host cannot container %s character.", c);

        int i = s.indexOf(".");
        if ( i < 0 )
            return error("Host must contain a period.");

        if ( s.startsWith(".") )
            return error("Host cannot start with a period.");

        if ( s.endsWith(".") )
            return error("Host cannot end with a period.");

        return ok();
    }

    private boolean isValidDomainCharacter(char c)
    {
        if ( c >= 'a' && c <= 'z' )
            return true;

        if ( c >= 'A' && c <= 'Z' )
            return true;

        if ( c >= '0' && c <= '9' )
            return true;

        final String symbols = ".-";
        return symbols.indexOf(c) >= 0;
    }

    private KmSimpleResult validateComment()
    {
        if ( !hasComment() )
            return ok();

        if ( !Kmu.isSingleLinePrintable(getComment()) )
            return error("Comment cannot contain multiple lines.");

        return ok();
    }

    private KmSimpleResult validateAddress()
    {
        String s = formatAddress();
        if ( s.length() > 254 )
            return error("Address cannot exceed 254 characters.");

        return ok();
    }

    private KmSimpleResult ok()
    {
        return KmSimpleResult.OK;
    }

    private KmSimpleResult error(String msg, Object... args)
    {
        return KmSimpleResult.createError(msg, args);
    }

}
