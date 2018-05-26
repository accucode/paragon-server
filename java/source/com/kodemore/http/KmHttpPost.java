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

import java.io.IOException;
import java.net.HttpURLConnection;

public class KmHttpPost
    extends KmHttpRequest
{
    //##################################################
    //# constructor
    //##################################################

    public KmHttpPost()
    {
        setContentTypeFormPost();
    }

    //##################################################
    //# path
    //##################################################

    @Override
    public String getFullPath()
    {
        return getPath();
    }

    @Override
    public void _applyRequestValue() throws IOException
    {
        byte[] arr = getRequestParameterString().getBytes();

        HttpURLConnection con;
        con = getConnection();
        con.setDoOutput(true);
        con.setDoInput(true);
        con.getOutputStream().write(arr);
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        KmHttpRequest req;
        req = new KmHttpPost();
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
