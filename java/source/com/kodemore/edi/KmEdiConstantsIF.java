/*
  Copyright (c) 2005-2011 www.kodemore.com

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

package com.kodemore.edi;

/**
 * I am used to parse an edi interchange.
 */
public interface KmEdiConstantsIF
{
    //##################################################
    //# tags
    //##################################################

    String         TAG_SERVICE_ADVICE      = "UNA";

    String         TAG_INTERCHANGE_HEADER  = "UNB";
    String         TAG_INTERCHANGE_TRAILER = "UNZ";

    String         TAG_GROUP_HEADER        = "UNG";
    String         TAG_GROUP_TRAILER       = "UNE";

    String         TAG_MESSAGE_HEADER      = "UNH";
    String         TAG_MESSAGE_TRAILER     = "UNT";

    //##################################################
    //# delimiters
    //##################################################

    char           CHAR_ESCAPE             = '?';
    char           CHAR_SEGMENT_END        = '\'';
    char           CHAR_ELEMENT_SEPARATOR  = '+';
    char           CHAR_VALUE_SEPARATOR    = ':';

    char           CHAR_SPACE              = ' ';
    char           CHAR_CR                 = '\r';
    char           CHAR_LF                 = '\n';

    //##################################################
    //# other
    //##################################################

    String         EMPTY_VALUE             = "";
    String[]       EMPTY_STRING_ARRAY      = new String[0];
    KmEdiElement[] EMPTY_ELEMENT_ARRAY     = new KmEdiElement[0];
}
