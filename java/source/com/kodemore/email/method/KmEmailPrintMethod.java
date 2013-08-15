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

package com.kodemore.email.method;

import java.util.List;

import com.kodemore.collection.KmList;
import com.kodemore.email.KmEmailIF;
import com.kodemore.email.KmEmailPartIF;
import com.kodemore.email.KmEmailPartType;
import com.kodemore.email.KmEmailResult;
import com.kodemore.utility.Kmu;

public class KmEmailPrintMethod
    extends KmEmailMethod
{
    //##################################################
    //# send
    //##################################################

    @Override
    public KmList<KmEmailResult> send(List<KmEmailIF> emails)
    {
        KmList<KmEmailResult> v = new KmList<KmEmailResult>();
        for ( KmEmailIF e : emails )
            v.add(_send(e));
        return v;
    }

    private KmEmailResult _send(KmEmailIF email)
    {
        begin();
        printHeader(email);
        printRecipients(email);
        printBody(email);
        end();
        return okResult(email);
    }

    //##################################################
    //# private
    //##################################################

    private void printHeader(KmEmailIF email)
    {
        println("Key:     " + email.getKey());
        println("Subject: " + email.getSubject());
        println("From:    " + email.getFrom());
    }

    private void printRecipients(KmEmailIF email)
    {
        printRecipients("To", email.getToList());
        printRecipients("Cc", email.getCcList());
        printRecipients("Bcc", email.getBccList());
    }

    private void printRecipients(String label, List<String> v)
    {
        if ( v == null )
            v = new KmList<String>();

        printfln(label + " (%s)", v.size());
        for ( String e : v )
            println("    " + e);
    }

    private void printBody(KmEmailIF email)
    {
        List<KmEmailPartIF> parts = email.getParts();
        for ( KmEmailPartIF part : parts )
        {
            printfln("Part (%s)", part.getType().name());

            byte[] arr = part.getData();

            KmEmailPartType type = part.getType();
            switch ( type )
            {
                case Text:
                {
                    String s = new String(arr);
                    println(s);
                    continue;
                }

                case Html:
                {
                    String s = new String(arr);
                    println(s);
                    continue;
                }

                case Attachment:
                {
                    println("    Name: " + part.getAttachmentName());
                    println("    Size: " + arr.length);
                    println("    Data: " + Kmu.formatHexString(arr, 20));
                    continue;
                }
            }
        }
    }

    private void begin()
    {
        println(Kmu.repeat(">", 60));
    }

    private void end()
    {
        println(Kmu.repeat("<", 70));
    }

    //##################################################
    //# support
    //##################################################

    protected void println(String e)
    {
        System.out.println(e);
    }

    private void printfln(String msg, Object... args)
    {
        String s = Kmu.format(msg, args);
        println(s);
    }
}
