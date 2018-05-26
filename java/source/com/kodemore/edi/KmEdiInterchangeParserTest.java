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

package com.kodemore.edi;

import java.io.StringWriter;

import com.kodemore.collection.KmList;
import com.kodemore.utility.KmFiles;
import com.kodemore.utility.KmTimer;
import com.kodemore.utility.Kmu;

/**
 * I am used to parse an edi interchange.
 */
public class KmEdiInterchangeParserTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        Runtime rt = Runtime.getRuntime();

        rt.gc();
        long free1 = rt.freeMemory();

        KmTimer t = KmTimer.run();
        KmEdiInterchange i = testRead();
        KmList<KmEdiMessage> messages = i.getMessages();
        String str = messages.get(0).toString();
        t.stop();

        rt.gc();
        long free2 = rt.freeMemory();

        System.out.println();
        System.out.println("Message segments: " + str);
        System.out.println("Memory:      " + Kmu.formatInteger(free1 - free2));
        System.out.println("Segments:    " + i.getSegments().size());

        String value;
        value = Kmu.formatDouble(t.getSeconds(), 2);
        System.out.println("Time:        " + value);
        System.out.println();

        value = i.getHeader().getElement(1).getValue(0);
        System.out.println("Header[1,0]: " + value);

        value = i.getHeader().getElement(1).getValue(1);
        System.out.println("Header[1,1]: " + value);

        value = i.getHeader().getElement(1).getValue(2);
        System.out.println("Header[1,2]: " + value);

        testWrite(i);
        i = null;

        rt.gc();
        testCompare();
    }

    private static KmEdiInterchange testRead()
    {
        String path = "c:/temp/edi/c.dat";
        return KmEdiInterchangeParser.parseFile(path);
    }

    private static void testWrite(KmEdiInterchange x)
    {
        try
        {
            StringWriter sw = new StringWriter();
            KmEdiWriter ew = new KmEdiWriter(sw);
            ew.writeInterchange(x);
            ew.flush();
            KmFiles.writeString("c:/temp/edi/c2.dat", sw.toString());
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    private static void testCompare()
    {
        String a = KmFiles.readString("c:/temp/edi/c.dat");
        String b = KmFiles.readString("c:/temp/edi/c2.dat");
        System.out.println("Match: " + a.equals(b));
    }
}
