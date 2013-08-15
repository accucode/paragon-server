/*
  Copyright (c) 2005-2013 www.kodemore.com

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
*/

package com.kodemore.console;

import com.kodemore.utility.Kmu;

/**
 * I am a collection of various static methods that are useful in a variety of
 * situations. This class should generally not have any dependencies on other
 * packages.
 */
public class KmConsoleInput
{
    public static void waitForReturn()
    {
        String s = "Please press the return key to continue...";
        waitForReturn(s);
    }

    public static void waitForReturn(String prompt)
    {
        readString(prompt);
    }

    public static String readString(String prompt)
    {
        try
        {
            StringBuilder sb = new StringBuilder();
            System.out.print(prompt);
            while ( true )
            {
                int i = System.in.read();
                if ( i == '\n' )
                    break;
                sb.append((char)i);
            }
            return sb.toString();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public static Integer readInteger(String prompt)
    {
        String s = readString(prompt);
        return Kmu.parseInteger(s);
    }

    public static Double readDouble(String prompt)
    {
        String s = readString(prompt);
        return Kmu.parseDouble(s);
    }

}
