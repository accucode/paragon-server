/*
  Copyright (c) 2010-2010 www.kodemore.com

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

package com.kodemore.jasper;

import com.kodemore.jasper.field.KmJasperField;
import com.kodemore.jasper.xml.KmJasperXmlElement;

public class KmJasperGroup
    implements KmJasperElementIF
{
    //##################################################
    //# variables
    //##################################################

    private KmJasperReportBuilder _report;

    private String                _name;
    private Boolean               _startNewColumn;
    private Boolean               _startNewPage;
    private Boolean               _resetPageNumber;
    private Boolean               _reprintHeaderOnEachPage;
    private Integer               _minimumHeightToStartNewPage;
    private Boolean               _keepTogether;

    private String                _expression;
    private KmJasperBand          _header;
    private KmJasperBand          _footer;

    //##################################################
    //# constructor
    //##################################################

    public KmJasperGroup(KmJasperReportBuilder e)
    {
        _report = e;
    }

    //##################################################
    //# accessing
    //##################################################

    public String getName()
    {
        return _name;
    }

    public void setName(String e)
    {
        _name = e;
    }

    public Boolean getStartNewColumn()
    {
        return _startNewColumn;
    }

    public void setStartNewColumn(Boolean e)
    {
        _startNewColumn = e;
    }

    public void setStartNewColumn()
    {
        setStartNewColumn(true);
    }

    public Boolean getStartNewPage()
    {
        return _startNewPage;
    }

    public void setStartNewPage(Boolean e)
    {
        _startNewPage = e;
    }

    public void setStartNewPage()
    {
        setStartNewPage(true);
    }

    public Boolean getResetPageNumber()
    {
        return _resetPageNumber;
    }

    public void setResetPageNumber(Boolean e)
    {
        _resetPageNumber = e;
    }

    public void setResetPageNumber()
    {
        setResetPageNumber(true);
    }

    public Boolean getReprintHeaderOnEachPage()
    {
        return _reprintHeaderOnEachPage;
    }

    public void setReprintHeaderOnEachPage(Boolean e)
    {
        _reprintHeaderOnEachPage = e;
    }

    public void setReprintHeaderOnEachPage()
    {
        setReprintHeaderOnEachPage(true);
    }

    public Integer getMinimumHeightToStartNewPage()
    {
        return _minimumHeightToStartNewPage;
    }

    public void setMinimumHeightToStartNewPage(Integer e)
    {
        _minimumHeightToStartNewPage = e;
    }

    public Boolean getKeepTogether()
    {
        return _keepTogether;
    }

    public void setKeepTogether(Boolean e)
    {
        _keepTogether = e;
    }

    public void setKeepTogether()
    {
        setKeepTogether(true);
    }

    //##################################################
    //# expression
    //##################################################

    public String getExpression()
    {
        return _expression;
    }

    public void setExpression(String e)
    {
        _expression = e;
    }

    public void setExpressionField(KmJasperField field)
    {
        setExpressionField(field.getName());
    }

    private void setExpressionField(String field)
    {
        String s = "$F{" + field + "}";
        setExpression(s);
    }

    //##################################################
    //# bands
    //##################################################

    public KmJasperBand getHeader()
    {
        if ( _header == null )
            _header = new KmJasperBand(_report, "groupHeader");
        return _header;
    }

    public KmJasperBand getFooter()
    {
        if ( _footer == null )
            _footer = new KmJasperBand(_report, "groupFooter");
        return _footer;
    }

    //##################################################
    //# compose
    //##################################################

    @Override
    public void addTo(KmJasperXmlElement root)
    {
        KmJasperXmlElement group;
        group = root.addElement("group");
        group.addAttribute("name", getName());
        group.addAttribute("isStartNewColumn", getStartNewColumn());
        group.addAttribute("isStartNewPage", getStartNewPage());
        group.addAttribute("isResetPageNumber", getResetPageNumber());
        group.addAttribute("isReprintHeaderOnEachPage", getReprintHeaderOnEachPage());
        group.addAttribute("minHeightToStartNewPage", getMinimumHeightToStartNewPage());
        group.addAttribute("keepTogether", getKeepTogether());

        KmJasperXmlElement expr;
        expr = group.addElement("groupExpression");
        expr.setIndentChildren(false);
        expr.addText(getExpression());

        group.add(_header);
        group.add(_footer);
    }
}
