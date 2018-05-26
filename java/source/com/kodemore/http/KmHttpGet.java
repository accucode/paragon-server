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

package com.kodemore.http;

import com.kodemore.utility.Kmu;

public class KmHttpGet
    extends KmHttpRequest
{
    //##################################################
    //# path
    //##################################################

    @Override
    public String getFullPath()
    {
        String path = getPath();
        String params = getRequestParameterString();
        if ( Kmu.hasValue(params) )
            path += "?" + params;
        return path;
    }

    @Override
    protected void _applyRequestValue()
    {
        // GETs to not use the request value.
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        KmHttpRequest req;
        req = new KmHttpGet();
        req.setHost("dictionary.reference.com");
        req.setPort(80);
        req.setPath("search");
        req.setContentType("text/html");
        req.setParameter("q", "test");
        req.submit();

        System.out.println("------------------------------------------------------------");
        if ( req.hasException() )
        {
            System.out.println("url:   " + req.getUrl());
            System.out.println("error: " + req.getException());
            return;
        }

        System.out.println("url:              " + req.getUrl());
        System.out.println("response code:    " + req.getResponseCode());
        System.out.println("response message: " + req.getResponseMessage());
        System.out.println(req.getResponseString());
    }
}
