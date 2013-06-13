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

import java.util.ArrayList;
import java.util.List;

import com.kodemore.jasper.easy.KmJasperEasyBuilder;
import com.kodemore.jasper.field.KmJasperBooleanField;
import com.kodemore.jasper.field.KmJasperField;
import com.kodemore.jasper.field.KmJasperIntegerField;
import com.kodemore.jasper.field.KmJasperStringField;
import com.kodemore.jasper.field.KmJasperVariable;
import com.kodemore.jasper.xml.KmJasperXmlElement;

public class KmJasperReportBuilder
{
    //##################################################
    //# variables
    //##################################################

    private List<KmJasperField>    _fields;
    private List<KmJasperVariable> _variables;

    private String                 _name;
    private KmJasperPage           _page;

    private List<KmJasperGroup>    _groups;
    private List<KmJasperFont>     _fonts;
    private List<KmJasperStyle>    _styles;

    private KmJasperBand           _background;
    private KmJasperBand           _title;
    private KmJasperBand           _pageHeader;
    private KmJasperBand           _columnHeader;
    private KmJasperBand           _columnFooter;
    private KmJasperBand           _pageFooter;
    private KmJasperBand           _summary;
    private KmJasperBand           _noData;

    private List<KmJasperBand>     _details;

    private KmJasperEasyBuilder    _easyBuilder;

    //##################################################
    //# constructor
    //##################################################

    public KmJasperReportBuilder()
    {
        _name = "Report";

        _fields = new ArrayList<KmJasperField>();
        _variables = new ArrayList<KmJasperVariable>();

        _page = new KmJasperPage();
        _groups = new ArrayList<KmJasperGroup>();
        _details = new ArrayList<KmJasperBand>();

        _fonts = new ArrayList<KmJasperFont>();
        installDefaultFont();

        _styles = new ArrayList<KmJasperStyle>();
        installDefaultStyle();
    }

    //##################################################
    //# name
    //##################################################

    public String getName()
    {
        return _name;
    }

    public void setName(String e)
    {
        _name = e;
    }

    //##################################################
    //# page
    //##################################################

    public KmJasperPage getPage()
    {
        return _page;
    }

    //##################################################
    //# groups
    //##################################################

    public List<KmJasperGroup> getGroups()
    {
        return _groups;
    }

    public KmJasperGroup addGroup()
    {
        String name = "group" + _groups.size();

        KmJasperGroup e;
        e = new KmJasperGroup(this);
        e.setName(name);
        _groups.add(e);
        return e;
    }

    public KmJasperGroup addGroup(KmJasperField field)
    {
        KmJasperGroup e;
        e = addGroup();
        e.setExpressionField(field);
        return e;
    }

    //##################################################
    //# fonts
    //##################################################

    public List<KmJasperFont> getFonts()
    {
        return _fonts;
    }

    public KmJasperFont addFont()
    {
        String name = "font" + _fonts.size();

        KmJasperFont e;
        e = new KmJasperFont(this);
        e.setName(name);
        _fonts.add(e);
        return e;
    }

    public KmJasperFont getDefaultFont()
    {
        List<KmJasperFont> v = getFonts();
        for ( KmJasperFont e : v )
            if ( e.getDefault() )
                return e;

        return null;
    }

    private void installDefaultFont()
    {
        KmJasperFont e;
        e = addFont();
        e.setDefault();
        e.setFamilyTimes();
        e.setSize(10);
    }

    //##################################################
    //# styles
    //##################################################

    public List<KmJasperStyle> getStyles()
    {
        return _styles;
    }

    public KmJasperStyle addStyle()
    {
        KmJasperStyle e;
        e = new KmJasperStyle();
        e.setName("style" + _styles.size());
        _styles.add(e);
        return e;
    }

    public KmJasperStyle getDefaultStyle()
    {
        for ( KmJasperStyle e : getStyles() )
            if ( e.isDefault() )
                return e;

        return null;
    }

    public void installDefaultStyle()
    {
        KmJasperStyle e;
        e = addStyle();
        e.setDefault();
    }

    //##################################################
    //# bands
    //##################################################

    public KmJasperBand getBackground()
    {
        if ( _background == null )
        {
            _background = new KmJasperBand(this, "background");
            _background.setHeight(getPage().getClientHeight());
        }
        return _background;
    }

    public KmJasperBand getTitle()
    {
        if ( _title == null )
            _title = new KmJasperBand(this, "title");
        return _title;
    }

    public KmJasperBand getPageHeader()
    {
        if ( _pageHeader == null )
            _pageHeader = new KmJasperBand(this, "pageHeader");
        return _pageHeader;
    }

    public KmJasperBand getColumnHeader()
    {
        if ( _columnHeader == null )
            _columnHeader = new KmJasperBand(this, "columnHeader");
        return _columnHeader;
    }

    public KmJasperBand getDetail()
    {
        if ( _details.isEmpty() )
            return addDetail();

        return _details.get(0);
    }

    public KmJasperBand addDetail()
    {
        KmJasperBand e = new KmJasperBand(this, "detail");
        _details.add(e);
        return e;
    }

    public KmJasperBand getPageFooter()
    {
        if ( _pageFooter == null )
            _pageFooter = new KmJasperBand(this, "pageFooter");
        return _pageFooter;
    }

    public KmJasperBand getColumnFooter()
    {
        if ( _columnFooter == null )
            _columnFooter = new KmJasperBand(this, "columnFooter");
        return _columnFooter;
    }

    public KmJasperBand getSummary()
    {
        if ( _summary == null )
            _summary = new KmJasperBand(this, "summary");
        return _summary;
    }

    public KmJasperBand getNoData()
    {
        if ( _noData == null )
            _noData = new KmJasperBand(this, "noData");
        return _noData;
    }

    //##################################################
    //# fields
    //##################################################

    public List<KmJasperField> getFields()
    {
        return _fields;
    }

    public KmJasperStringField addStringField()
    {
        return addStringField(nextFieldName());
    }

    public KmJasperStringField addStringField(String name)
    {
        return addField(new KmJasperStringField(name));
    }

    public KmJasperBooleanField addBooleanField()
    {
        return addBooleanField(nextFieldName());
    }

    public KmJasperBooleanField addBooleanField(String name)
    {
        return addField(new KmJasperBooleanField(name));
    }

    public KmJasperIntegerField addIntegerField()
    {
        return addIntegerField(nextFieldName());
    }

    public KmJasperIntegerField addIntegerField(String name)
    {
        return addField(new KmJasperIntegerField(name));
    }

    private String nextFieldName()
    {
        return "field" + _fields.size();
    }

    private <E extends KmJasperField> E addField(E e)
    {
        _fields.add(e);
        return e;
    }

    //##################################################
    //# variables
    //##################################################

    public List<KmJasperVariable> getVariables()
    {
        return _variables;
    }

    public KmJasperVariable addVariable()
    {
        String name = "var" + _variables.size();

        KmJasperVariable e;
        e = new KmJasperVariable(name);
        _variables.add(e);
        return e;
    }

    //##################################################
    //# compose 
    //##################################################

    public void dumpXml()
    {
        System.out.println(printXml());
    }

    public String printXml()
    {
        KmJasperXmlElement report;
        report = new KmJasperXmlElement();
        report.setName("jasperReport");

        report.addAttribute("xmlns", "http://jasperreports.sourceforge.net/jasperreports");
        report.addAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
        report.addAttribute(
            "xsi:schemaLocation",
            "http://jasperreports.sourceforge.net/jasperreports http://jasperreports.sourceforge.net/xsd/jasperreport.xsd");

        report.addAttribute("name", getName());

        getPage().addAttributesTo(report);

        report.addAll(getFonts());
        report.addAll(getStyles());
        report.addAll(getFields());
        report.addAll(getVariables());
        report.addAll(getGroups());

        report.add(_background);
        report.add(_title);
        report.add(_pageHeader);
        report.add(_columnHeader);
        report.addAll(_details);
        report.add(_columnFooter);
        report.add(_pageFooter);
        report.add(_summary);
        report.add(_noData);

        return report.print();
    }

    //##################################################
    //# easy columns
    //##################################################

    public KmJasperEasyBuilder getEasyBuilder()
    {
        if ( _easyBuilder == null )
            _easyBuilder = new KmJasperEasyBuilder(this);
        return _easyBuilder;
    }

    //##################################################
    //# compile
    //##################################################

    public KmJasperReport compile()
    {
        KmJasperReport e;
        e = new KmJasperReport();
        e.compile(this);
        return e;
    }
}
