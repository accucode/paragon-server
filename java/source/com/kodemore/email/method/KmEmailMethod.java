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

package com.kodemore.email.method;

import java.util.List;

import com.kodemore.collection.KmList;
import com.kodemore.email.KmEmailIF;
import com.kodemore.email.KmEmailResult;

public abstract class KmEmailMethod
{
    //##################################################
    //# send
    //##################################################

    public abstract KmList<KmEmailResult> send(List<KmEmailIF> emails);

    public KmEmailResult send(KmEmailIF email)
    {
        KmList<KmEmailIF> emails;
        emails = new KmList<KmEmailIF>();
        emails.add(email);

        KmList<KmEmailResult> results;
        results = send(emails);
        return results.getFirst();
    }

    //##################################################
    //# support
    //##################################################

    protected KmEmailResult okResult(KmEmailIF email)
    {
        KmEmailResult e;
        e = new KmEmailResult();
        e.setEmailKey(email.getKey());
        e.setOk();
        return e;
    }

    protected KmEmailResult errorResult(KmEmailIF email, String error)
    {
        KmEmailResult e;
        e = new KmEmailResult();
        e.setEmailKey(email.getKey());
        e.setError(error);
        return e;
    }

}
