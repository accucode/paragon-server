/*
  Copyright (c) 2005-2018 www.kodemore.com

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

package com.kodemore.telnet;

public class KmTelnetUtility
    implements KmTelnetConstantsIF
{
    //##################################################
    //# format
    //##################################################

    public static String formatCharacters(byte[] arr)
    {
        String s = new String(arr);
        return formatCharacters(s);
    }

    public static String formatCharacters(String s)
    {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for ( int i = 0; i < n; i++ )
        {
            char c = s.charAt(i);
            sb.append(formatCharacter(c));
        }
        return sb.toString();
    }

    public static String formatCharacter(char c, boolean alt)
    {
        String s = formatCharacter(c);
        if ( alt )
            s = ALT_PREFIX + s;
        return s;
    }

    public static String formatCharacter(char c)
    {
        if ( isPrintable(c) )
            return c + "";
        return "<" + (int)c + ">";
    }

    public static String formatCommand(int i)
    {
        switch ( i )
        {
            case COMMAND_SUB_END:
                return "sub end";
            case COMMAND_NOP:
                return "nop";
            case COMMAND_DATA_MARK:
                return "data mark";
            case COMMAND_BREAK:
                return "break";
            case COMMAND_IP:
                return "ip";
            case COMMAND_AO:
                return "ao";
            case COMMAND_ARE_YOU_THERE:
                return "are you there";
            case COMMAND_EC:
                return "ec";
            case COMMAND_EL:
                return "el";
            case COMMAND_GA:
                return "go ahead";
            case COMMAND_SUB_BEGIN:
                return "sub begin";
            case COMMAND_WILL:
                return "will";
            case COMMAND_WONT:
                return "wont";
            case COMMAND_DO:
                return "do";
            case COMMAND_DONT:
                return "dont";
            case COMMAND_IAC:
                return "iac";
        }
        return "unknown command <" + i + ">";
    }

    public static String formatOption(int i)
    {
        switch ( i )
        {
            case OPTION_TRANSMIT_BINARY:
                return "transmit binary";
            case OPTION_ECHO:
                return "echo";
            case OPTION_RECONNECTION:
                return "reconnection";
            case OPTION_SUPPRESS_GO_AHEAD:
                return "suppress go ahead";
            case OPTION_MESSAGE_SIZE:
                return "message size";
            case OPTION_STATUS:
                return "status";
            case OPTION_TIMING_MARK:
                return "timing mark";
            case OPTION_RCTE:
                return "rcte";
            case OPTION_OUTPUT_LINE_WIDTH:
                return "output line width";
            case OPTION_OUTPUT_PAGE_SIZE:
                return "output page size";
            case OPTION_TERMINAL_TYPE:
                return "terminal type";
            case OPTION_WINDOW_SIZE:
                return "window size";
            case OPTION_TERMINAL_SPEED:
                return "terminal speed";
            case OPTION_ENVIRONMENT:
                return "environment";
            case OPTION_NEW_ENVIRONMENT:
                return "new environment";
        }
        return "unknown option <" + i + ">";
    }

    public static String formatVirtualKey(int i, boolean alt)
    {
        String s = formatVirtualKey(i);
        if ( alt )
            s = ALT_PREFIX + s;
        return s;
    }

    public static String formatVirtualKey(int i)
    {
        switch ( i )
        {
            case VK_UNDEFINED:
                return "VK_UNDEFINED";

            case VK_LEFT:
                return "VK_LEFT";
            case VK_RIGHT:
                return "VK_RIGHT";
            case VK_UP:
                return "VK_UP";
            case VK_DOWN:
                return "VK_DOWN";

            case VK_TAB:
                return "VK_TAB";
            case VK_SHIFT_TAB:
                return "VK_SHIFT_TAB";
            case VK_BACKSPACE:
                return "VK_BACKSPACE";
            case VK_SHIFT_BACKSPACE:
                return "VK_SHIFT_BACKSPACE";
            case VK_ENTER:
                return "VK_ENTER";

            case VK_INSERT:
                return "VK_INSERT";
            case VK_DELETE:
                return "VK_DELETE";
            case VK_HOME:
                return "VK_HOME";
            case VK_END:
                return "VK_END";
            case VK_PAGE_UP:
                return "VK_PAGE_UP";
            case VK_PAGE_DOWN:
                return "VK_PAGE_DOWN";

            case VK_F1:
                return "VK_F1";
            case VK_F2:
                return "VK_F2";
            case VK_F3:
                return "VK_F3";
            case VK_F4:
                return "VK_F4";
            case VK_F5:
                return "VK_F5";
            case VK_F6:
                return "VK_F6";
            case VK_F7:
                return "VK_F7";
            case VK_F8:
                return "VK_F8";
            case VK_F9:
                return "VK_F9";
            case VK_F10:
                return "VK_F10";

            case VK_SHIFT_F1:
                return "VK_SHIFT_F1";
            case VK_SHIFT_F2:
                return "VK_SHIFT_F2";
            case VK_SHIFT_F3:
                return "VK_SHIFT_F3";
            case VK_SHIFT_F4:
                return "VK_SHIFT_F4";
            case VK_SHIFT_F5:
                return "VK_SHIFT_F5";
            case VK_SHIFT_F6:
                return "VK_SHIFT_F6";
            case VK_SHIFT_F7:
                return "VK_SHIFT_F7";
            case VK_SHIFT_F8:
                return "VK_SHIFT_F8";
            case VK_SHIFT_F9:
                return "VK_SHIFT_F9";
            case VK_SHIFT_F10:
                return "VK_SHIFT_F10";
        }
        return "unknown virtual key: <" + i + ">";
    }

    //##################################################
    //# testing
    //##################################################

    public static boolean isOption(int i)
    {
        return isPositiveOption(i) || isNegativeOption(i);
    }

    public static boolean isPositiveOption(int i)
    {
        if ( i == COMMAND_WILL )
            return true;
        if ( i == COMMAND_DO )
            return true;
        return false;
    }

    public static boolean isNegativeOption(int i)
    {
        if ( i == COMMAND_WONT )
            return true;
        if ( i == COMMAND_DONT )
            return true;
        return false;
    }

    public static boolean isPrintable(char c)
    {
        return c >= 32 && c <= 126;
    }

}
