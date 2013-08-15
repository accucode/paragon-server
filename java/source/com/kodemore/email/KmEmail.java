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

package com.kodemore.email;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class KmEmail
    implements KmEmailIF
{
    //##################################################
    //# variables
    //##################################################

    private Object              _key;
    private String              _subject;
    private String              _from;

    private List<String>        _toList;
    private List<String>        _ccList;
    private List<String>        _bccList;

    private List<KmEmailPartIF> _parts;

    //##################################################
    //# constructor
    //##################################################

    public KmEmail()
    {
        _toList = new ArrayList<String>();
        _ccList = new ArrayList<String>();
        _bccList = new ArrayList<String>();
        _parts = new ArrayList<KmEmailPartIF>();
    }

    //##################################################
    //# key
    //##################################################

    @Override
    public Object getKey()
    {
        return _key;
    }

    public void setKey(Object e)
    {
        _key = e;
    }

    //##################################################
    //# subject
    //##################################################

    @Override
    public String getSubject()
    {
        return _subject;
    }

    public void setSubject(String e)
    {
        _subject = e;
    }

    //##################################################
    //# from
    //##################################################

    @Override
    public String getFrom()
    {
        return _from;
    }

    public void setFrom(String e)
    {
        _from = e;
    }

    //##################################################
    //# to
    //##################################################

    @Override
    public List<String> getToList()
    {
        return _toList;
    }

    public void setToList(List<String> v)
    {
        _toList = v;
    }

    public void addTo(String e)
    {
        getToList().add(e);
    }

    public void addTos(Collection<String> v)
    {
        getToList().addAll(v);
    }

    //##################################################
    //# cc
    //##################################################

    @Override
    public List<String> getCcList()
    {
        return _ccList;
    }

    public void setCcList(List<String> v)
    {
        _ccList = v;
    }

    public void addCc(String e)
    {
        getCcList().add(e);
    }

    public void addCcs(Collection<String> v)
    {
        getCcList().addAll(v);
    }

    //##################################################
    //# bcc
    //##################################################

    @Override
    public List<String> getBccList()
    {
        return _bccList;
    }

    public void setBccList(List<String> v)
    {
        _bccList = v;
    }

    public void addBcc(String e)
    {
        getBccList().add(e);
    }

    public void addBccs(Collection<String> v)
    {
        getBccList().addAll(v);
    }

    //##################################################
    //# parts
    //##################################################

    @Override
    public List<KmEmailPartIF> getParts()
    {
        return _parts;
    }

    public void setParts(List<KmEmailPartIF> v)
    {
        _parts = v;
    }

    public KmEmailPart addPart()
    {
        KmEmailPart e;
        e = new KmEmailPart();

        getParts().add(e);

        return e;
    }

    public KmEmailPart addTextPart(String s)
    {
        KmEmailPart e;
        e = addPart();
        e.setText(s);
        return e;
    }

    public KmEmailPart addHtmlPart(String s)
    {
        KmEmailPart e;
        e = addPart();
        e.setHtml(s);
        return e;
    }

}
