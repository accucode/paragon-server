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

package com.kodemore.servlet;

import com.kodemore.utility.KmEnumIF;
import com.kodemore.utility.Kmu;

/**
 * I define the common content types for web apps.
 */
public enum ScContentType
    implements KmEnumIF
{
    //##################################################
    //# list
    //##################################################

    Binary,
    Css,
    Html,
    Jpeg,
    Json,
    Octet,
    Pdf,
    Serialized,
    Text,
    Xml;

    //##################################################
    //# value
    //##################################################

    public String getHttpValue()
    {
        switch ( this )
        {
            case Binary:
                return "application/octet-stream";

            case Css:
                return "text/css";

            case Html:
                return "text/html";

            case Jpeg:
                return "image/jpeg";

            case Json:
                return "application/json";

            case Octet:
                return "application/octet-stream";

            case Pdf:
                return "application/pdf";

            case Serialized:
                return "application/x-java-serialized-object";

            case Text:
                return "text/plain";

            case Xml:
                return "text/xml";
        }
        throw Kmu.newEnumError(this);
    }
}
