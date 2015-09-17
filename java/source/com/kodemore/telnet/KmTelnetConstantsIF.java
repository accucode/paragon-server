/*
  Copyright (c) 2005-2014 www.kodemore.com

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

public interface KmTelnetConstantsIF
{
    //##################################################
    //# characters
    //##################################################

    String CR    = "\r";
    String LF    = "\n";
    String CRLF  = CR + LF;
    String ESC   = "" + (char)27;
    String SPACE = " ";

    String ALT_PREFIX = "ALT-";

    //##################################################
    //# attributes
    //##################################################

    int ATTRIBUTE_NORMAL     = 0;
    int ATTRIBUTE_BRIGHT     = 1;
    int ATTRIBUTE_DIM        = 2;
    int ATTRIBUTE_UNDERSCORE = 4;
    int ATTRIBUTE_BLINK      = 5;
    int ATTRIBUTE_REVERSE    = 7;

    //##################################################
    //# commands
    //##################################################

    int COMMAND_SUB_END       = 240;
    int COMMAND_NOP           = 241;
    int COMMAND_DATA_MARK     = 242;
    int COMMAND_BREAK         = 243;
    int COMMAND_IP            = 244;
    int COMMAND_AO            = 245;
    int COMMAND_ARE_YOU_THERE = 246;
    int COMMAND_EC            = 247;
    int COMMAND_EL            = 248;
    int COMMAND_GA            = 249;
    int COMMAND_SUB_BEGIN     = 250;
    int COMMAND_WILL          = 251;
    int COMMAND_WONT          = 252;
    int COMMAND_DO            = 253;
    int COMMAND_DONT          = 254;
    int COMMAND_IAC           = 255;

    //##################################################
    //# option
    //##################################################

    int OPTION_TRANSMIT_BINARY   = 0;
    int OPTION_ECHO              = 1;
    int OPTION_RECONNECTION      = 2;
    int OPTION_SUPPRESS_GO_AHEAD = 3;
    int OPTION_MESSAGE_SIZE      = 4;
    int OPTION_STATUS            = 5;
    int OPTION_TIMING_MARK       = 6;
    int OPTION_RCTE              = 7;
    int OPTION_OUTPUT_LINE_WIDTH = 8;
    int OPTION_OUTPUT_PAGE_SIZE  = 9;
    int OPTION_TERMINAL_TYPE     = 24;
    int OPTION_WINDOW_SIZE       = 31;
    int OPTION_TERMINAL_SPEED    = 32;
    int OPTION_ENVIRONMENT       = 36;
    int OPTION_NEW_ENVIRONMENT   = 39;

    //##################################################
    //# keys
    //##################################################

    int VK_UNDEFINED = -1;

    int VK_LEFT  = 10;
    int VK_RIGHT = 11;
    int VK_UP    = 12;
    int VK_DOWN  = 13;

    int VK_TAB             = 20;
    int VK_SHIFT_TAB       = 21;
    int VK_BACKSPACE       = 22;
    int VK_SHIFT_BACKSPACE = 23;
    int VK_ENTER           = 24;

    int VK_INSERT    = 40;
    int VK_DELETE    = 41;
    int VK_HOME      = 42;
    int VK_END       = 43;
    int VK_PAGE_UP   = 44;
    int VK_PAGE_DOWN = 45;

    int VK_F1  = 50;
    int VK_F2  = 51;
    int VK_F3  = 52;
    int VK_F4  = 53;
    int VK_F5  = 54;
    int VK_F6  = 55;
    int VK_F7  = 56;
    int VK_F8  = 57;
    int VK_F9  = 58;
    int VK_F10 = 59;

    int VK_SHIFT_F1  = 60;
    int VK_SHIFT_F2  = 61;
    int VK_SHIFT_F3  = 62;
    int VK_SHIFT_F4  = 63;
    int VK_SHIFT_F5  = 64;
    int VK_SHIFT_F6  = 65;
    int VK_SHIFT_F7  = 66;
    int VK_SHIFT_F8  = 67;
    int VK_SHIFT_F9  = 68;
    int VK_SHIFT_F10 = 69;

}
