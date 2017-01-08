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
 * I provide easy parsing and validation of email addresses.
 */
public class KmEmailParser
{
    //##################################################
    //# static
    //##################################################

    public static boolean validate(String email)
    {
        KmEmailParser e;
        e = new KmEmailParser();
        e.setEmail(email);

        return e.isValid();
    }

    //##################################################
    //# variables
    //##################################################

    private String _email;

    //##################################################
    //# accessing
    //##################################################

    public void setEmail(String e)
    {
        _email = e;
    }

    public String getEmail()
    {
        return _email;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public String getName()
    {
        String s = getEmail();
        if ( s == null )
            return null;

        int i = s.indexOf("@");
        if ( i < 0 )
            return null;

        return s.substring(0, i);
    }

    public String getHost()
    {
        String s = getEmail();
        if ( s == null )
            return null;

        int i = s.indexOf("@");
        if ( i < 0 )
            return null;

        return s.substring(i + 1);
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isValid()
    {
        if ( !isNameValid() )
            return false;

        if ( !isHostValid() )
            return false;

        String s = getEmail();
        if ( s.length() > 254 )
            return false;

        return true;
    }

    public boolean isNameValid()
    {
        String s = getName();

        if ( s == null )
            return false;

        if ( s.length() == 0 )
            return false;

        if ( s.length() > 64 )
            return false;

        for ( char c : s.toCharArray() )
            if ( !isValidNameCharacter(c) )
                return false;

        if ( s.startsWith(".") )
            return false;

        if ( s.endsWith(".") )
            return false;

        if ( s.contains("..") )
            return false;

        return true;
    }

    public boolean isHostValid()
    {
        String s = getHost();

        if ( s == null )
            return false;

        if ( s.length() == 0 )
            return false;

        if ( s.length() > 253 )
            return false;

        int i = s.indexOf(".");
        if ( i < 0 )
            return false;

        if ( s.startsWith(".") )
            return false;

        if ( s.endsWith(".") )
            return false;

        return true;
    }

    //##################################################
    //# support
    //##################################################

    private boolean isValidNameCharacter(char c)
    {
        if ( c >= 'a' && c <= 'z' )
            return true;

        if ( c >= 'A' && c <= 'Z' )
            return true;

        if ( c >= '0' && c <= '9' )
            return true;

        final String symbols = ".!#$%&'*+-/=?^_`{|}~";
        return symbols.indexOf(c) >= 0;
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        KmEmailParser p;
        p = new KmEmailParser();
        p.setEmail("John Doe <jdoe@example.com>");

        boolean valid = p.isValid();
        System.out.println("    valid: " + valid);

    }
}
