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

package com.kodemore.servlet.control;

import java.awt.Color;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.log.KmLogger;
import com.kodemore.servlet.variable.ScLocalInteger;
import com.kodemore.servlet.variable.ScLocalList;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.servlet.variable.ScLocalStringList;
import com.kodemore.utility.KmConstantsIF;
import com.kodemore.utility.Kmu;

public class ScGoogleChart
    extends ScControl
{
    //##################################################
    //# logging
    //##################################################

    private static final KmLogger logger = KmLogger.create(ScGoogleChart.class);

    //##################################################
    //# install
    //##################################################

    // http://chart.apis.google.com/chart?cht=p3&chd=t:60,40&chs=250x100&chl=Hello|World

    public static String scheme = "http";
    public static String host   = "chart.apis.google.com";
    public static String path   = "chart";
    public static int    port   = 80;

    //##################################################
    //# constants
    //##################################################

    private static final String PIPE  = "|";
    private static final String PLUS  = "+";
    private static final String COMMA = ",";

    //##################################################
    //# variables
    //##################################################

    private ScLocalString _type;

    private ScLocalInteger _width;
    private ScLocalInteger _height;

    private ScLocalList<KmList<Double>> _valueSets;

    private ScLocalInteger _minimumScale;
    private ScLocalInteger _maximumScale;

    private ScLocalString  _title;
    private ScLocalString  _titleColor;
    private ScLocalInteger _titleSize;

    private ScLocalStringList _legends;
    private ScLocalString     _legendPosition;

    private ScLocalStringList _labels;
    private ScLocalStringList _colors;

    private ScLocalInteger _barSize;
    private ScLocalInteger _barGap;
    private ScLocalInteger _barGroupGap;

    private ScLocalString _backgroundColor;

    private ScLocalInteger _yAxisMinimum;
    private ScLocalInteger _yAxisMaximum;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();
        _type = new ScLocalString("lc");

        _width = new ScLocalInteger(200);
        _height = new ScLocalInteger(200);

        _valueSets = new ScLocalList<>();

        _minimumScale = new ScLocalInteger();
        _maximumScale = new ScLocalInteger();

        _title = new ScLocalString();
        _titleColor = new ScLocalString();
        _titleSize = new ScLocalInteger();

        _legends = new ScLocalStringList();
        _legendPosition = new ScLocalString();

        _labels = new ScLocalStringList();
        _colors = new ScLocalStringList();

        _barSize = new ScLocalInteger();
        _barGap = new ScLocalInteger();
        _barGroupGap = new ScLocalInteger();

        _backgroundColor = new ScLocalString();

        _yAxisMinimum = new ScLocalInteger();
        _yAxisMaximum = new ScLocalInteger();

        setBackgroundTransparent();
    }

    //##################################################
    //# type
    //##################################################

    public void setTypeLine()
    {
        setType("lc");
    }

    public void setTypeSparkLine()
    {
        setType("ls");
    }

    public void setTypeBarVerticalStacked()
    {
        setType("bvs");
    }

    public void setTypeBarVerticalGrouped()
    {
        setType("bvg");
    }

    public void setTypeBarHorizontalStacked()
    {
        setType("bhs");
    }

    public void setTypeBarHorizontalGrouped()
    {
        setType("bhg");
    }

    public void setTypePie()
    {
        setType("p");
    }

    public void setTypePie3D()
    {
        setType("p3");
    }

    public void setTypeVennDiagram()
    {
        setType("v");
    }

    public String getType()
    {
        return _type.getValue();
    }

    private void setType(String e)
    {
        _type.setValue(e);
    }

    //##################################################
    //# size
    //##################################################

    public int getWidth()
    {
        return _width.getValue();
    }

    public void setWidth(int e)
    {
        _width.setValue(e);
    }

    public int getHeight()
    {
        return _height.getValue();
    }

    public void setHeight(int e)
    {
        _height.setValue(e);
    }

    public void setSize(int w, int h)
    {
        setWidth(w);
        setHeight(h);
    }

    //##################################################
    //# values
    //##################################################

    public void addSeries(KmList<Double> values)
    {
        _valueSets.add(values);
    }

    public void addSeries(Double... arr)
    {
        KmList<Double> v = new KmList<>();
        v.addAll(arr);
        addSeries(v);
    }

    public void addSeries(Integer... arr)
    {
        KmList<Double> v = new KmList<>();
        for ( Integer e : arr )
            v.add(e.doubleValue());
        addSeries(v);
    }

    public double getMaximumValue()
    {
        double max = Double.NaN;

        ScLocalList<KmList<Double>> data = _valueSets;
        for ( KmList<Double> v : data )
            for ( Double d : v )
                max = Kmu.max(d, max);

        return max;
    }

    //##################################################
    //# scale
    //##################################################

    public void setScale(int min, int max)
    {
        _minimumScale.setValue(min);
        _maximumScale.setValue(max);
    }

    public Integer getMinimumScale()
    {
        return _minimumScale.getValue();
    }

    public Integer getMaximumScale()
    {
        return _maximumScale.getValue();
    }

    public boolean hasScale()
    {
        return getMinimumScale() != null;
    }

    //##################################################
    //# title
    //##################################################

    public String getTitle()
    {
        return _title.getValue();
    }

    public void setTitle(String e)
    {
        _title.setValue(e);
    }

    public boolean hasTitle()
    {
        return Kmu.hasValue(getTitle());
    }

    //##################################################
    //# title format
    //##################################################

    public String getTitleColor()
    {
        return _titleColor.getValue();
    }

    public void setTitleColor(String e)
    {
        _titleColor.setValue(e);
    }

    public boolean hasTitleColor()
    {
        return Kmu.hasValue(getTitleColor());
    }

    public Integer getTitleSize()
    {
        return _titleSize.getValue();
    }

    /**
     * Setting a title size requires a title color.  If the title
     * color has not already been explicity set, it will be automatically
     * defaulted to black.
     */
    public void setTitleSize(Integer e)
    {
        _titleSize.setValue(e);
        if ( !hasTitleColor() )
            setTitleColor("000000");
    }

    public boolean hasTitleSize()
    {
        return getTitleSize() != null;
    }

    //##################################################
    //# legend
    //##################################################

    public KmList<String> getLegends()
    {
        return _legends.getValue();
    }

    public void setLegends(KmList<String> e)
    {
        _legends.setValue(e);
    }

    public void setLegends(String... arr)
    {
        KmList<String> v = new KmList<>();
        v.addAll(arr);
        setLegends(v);
    }

    public boolean hasLegends()
    {
        return _legends.isNotEmpty();
    }

    //##################################################
    //# legend position
    //##################################################

    public void setLegendLeft()
    {
        setLegendPosition("l");
    }

    public void setLegendRight()
    {
        setLegendPosition("r");
    }

    public void setLegendTop()
    {
        setLegendPosition("t");
    }

    public void setLegendBottom()
    {
        setLegendPosition("b");
    }

    public String getLegendPosition()
    {
        return _legendPosition.getValue();
    }

    public void setLegendPosition(String e)
    {
        _legendPosition.setValue(e);
    }

    public boolean hasLegendPosition()
    {
        return _legendPosition.hasValue();
    }

    //##################################################
    //# labels
    //##################################################

    public KmList<String> getLabels()
    {
        return _labels.getValue();
    }

    public void setLabels(KmList<String> e)
    {
        _labels.setValue(e);
    }

    public void setLabels(String... e)
    {
        KmList<String> v = new KmList<>();
        v.addAll(e);
        setLabels(v);
    }

    public boolean hasLabels()
    {
        return _labels.isNotEmpty();
    }

    //##################################################
    //# colors
    //##################################################

    public KmList<String> getColors()
    {
        return _colors.getValue();
    }

    /**
     * Colors should be formatted as 6 character rgb triplets.
     * E.g.: red=ff0000, green=00ff00.
     * The hexidecimal values are case-insensitive.
     *
     * You may optionally specify transparency as an extra
     * hexidecimal byte.  FF=solid, 00=transparent.
     * E.g.: ff000080 is red, 50% transparent
     */
    public void setColors(KmList<String> v)
    {
        _colors.setValue(v);
    }

    public void setColors(String... arr)
    {
        KmList<String> v = new KmList<>();
        v.addAll(arr);
        setColors(v);
    }

    public void setColors(Color... arr)
    {
        KmList<String> v = new KmList<>();
        for ( Color e : arr )
            v.add(formatColor(e));
        setColors(v);
    }

    public void setRainbowColors()
    {
        Color indigo = new Color(75, 0, 130);
        Color violet = new Color(238, 130, 238);
        setColors(Color.red, Color.orange, Color.yellow, Color.green, Color.blue, indigo, violet);
    }

    public boolean hasColors()
    {
        return _colors.isNotEmpty();
    }

    //##################################################
    //# bar size
    //##################################################

    public void setBarSize(int size, int gap)
    {
        _barSize.setValue(size);
        _barGap.setValue(gap);
    }

    public void setBarSize(int size, int gap, int groupGap)
    {
        setBarSize(size, gap);
        _barGroupGap.setValue(groupGap);
    }

    public Integer getBarSize()
    {
        return _barSize.getValue();
    }

    public Integer getBarGap()
    {
        return _barGap.getValue();
    }

    public Integer getBarGroupGap()
    {
        return _barGroupGap.getValue();
    }

    public boolean hasBarSize()
    {
        return getBarSize() != null;
    }

    public boolean hasBarGroupGap()
    {
        return getBarGroupGap() != null;
    }

    //##################################################
    //# background
    //##################################################

    public void setBackground(Color c)
    {
        setBackgroundColor(formatColor(c));
    }

    public void setBackgroundTransparent()
    {
        setBackgroundColor("00000000");
    }

    private void setBackgroundColor(String s)
    {
        _backgroundColor.setValue(s);
    }

    private String getBackgroundColor()
    {
        return _backgroundColor.getValue();
    }

    private boolean hasBackgroundColor()
    {
        return _backgroundColor.isNotNull();
    }

    //##################################################
    //# y axis
    //##################################################

    public void setYAxis(int min, int max)
    {
        _yAxisMinimum.setValue(min);
        _yAxisMaximum.setValue(max);
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.printImage(formatImageSource(), getWidth(), getHeight());
    }

    private String formatImageSource()
    {
        StringBuilder args;
        args = new StringBuilder();
        append(args, formatType());
        append(args, formatSize());
        append(args, formatData());
        append(args, formatScale());
        append(args, formatTitle());
        append(args, formatTitleFormat());
        append(args, formatLegend());
        append(args, formatLegendPosition());
        append(args, formatLabels());
        append(args, formatColors());
        append(args, formatBarSize());
        append(args, formatBackground());

        if ( _yAxisMinimum.hasValue() )
        {
            String axis = "chxt=y";
            String range = Kmu.format(
                "chxr=0,%s,%s",
                _yAxisMinimum.getValue(),
                _yAxisMaximum.getValue());

            append(args, axis);
            append(args, range);
        }

        String template = "%s://%s:%s/%s?%s";
        String url = Kmu.format(template, scheme, host, port, path, args.toString());
        boolean useBreaks = false;
        String src = Kmu.escapeHtml(url, useBreaks);

        logger.debug("ScGoogleChart");
        logger.debug("    url:" + url);
        logger.debug("    src:" + src);

        return src;
    }

    private String formatType()
    {
        return Kmu.format("cht=%s", getType());
    }

    private String formatSize()
    {
        return Kmu.format("chs=%sx%s", getWidth(), getHeight());
    }

    private String formatData()
    {
        StringBuilder sbvv = new StringBuilder();
        KmList<KmList<Double>> vv = _valueSets.getValue();

        for ( KmList<Double> v : vv )
        {
            StringBuilder sbv = new StringBuilder();
            for ( Double d : v )
            {
                String s;
                s = Kmu.formatDouble(d, 1, false);
                s = Kmu.removeSuffix(s, ".0");
                if ( sbv.length() != 0 )
                    sbv.append(COMMA);
                sbv.append(s);
            }
            if ( sbvv.length() != 0 )
                sbvv.append(PIPE);
            sbvv.append(sbv);
        }
        return Kmu.format("chd=t:%s", sbvv);
    }

    private String formatScale()
    {
        if ( !hasScale() )
            return null;

        return Kmu.format("chds=%s,%s", getMinimumScale(), getMaximumScale());
    }

    private String formatTitle()
    {
        if ( !hasTitle() )
            return null;

        String s = getTitle();
        s = Kmu.replaceAll(s, KmConstantsIF.CRLF, PIPE);
        s = Kmu.replaceAll(s, KmConstantsIF.CR, PIPE);
        s = Kmu.replaceAll(s, KmConstantsIF.LF, PIPE);
        s = Kmu.replaceAll(s, KmConstantsIF.SPACE, PLUS);

        return Kmu.format("chtt=%s", s);
    }

    private String formatTitleFormat()
    {
        if ( !hasTitleColor() )
            return null;

        String s = Kmu.format("chts=%s", getTitleColor());
        if ( hasTitleSize() )
            s += "," + getTitleSize();

        return s;
    }

    private String formatLegend()
    {
        if ( !hasLegends() )
            return null;

        String s = getLegends().join("|");
        return Kmu.format("chdl=%s", s);
    }

    private String formatLegendPosition()
    {
        if ( !hasLegends() )
            return null;

        if ( !hasLegendPosition() )
            return null;

        return Kmu.format("chdlp=%s", getLegendPosition());
    }

    private String formatLabels()
    {
        if ( !hasLabels() )
            return null;

        String s = getLabels().join("|");
        return Kmu.format("chl=%s", s);
    }

    private String formatColors()
    {
        if ( !hasColors() )
            return null;

        String s = getColors().join(",");
        return Kmu.format("chco=%s", s);
    }

    private String formatBarSize()
    {
        if ( !hasBarSize() )
            return null;

        String s = Kmu.format("chbh=%s,%s", getBarSize(), getBarGap());
        if ( hasBarGroupGap() )
            s += "," + getBarGroupGap();

        return s;
    }

    private String formatBackground()
    {
        if ( !hasBackgroundColor() )
            return null;

        return Kmu.format("chf=bg,s,%s", getBackgroundColor());
    }

    private String formatColor(Color c)
    {
        String s = Kmu.formatHexString((byte)c.getRed())
            + Kmu.formatHexString((byte)c.getGreen())
            + Kmu.formatHexString((byte)c.getBlue());

        int alpha = c.getAlpha();
        if ( alpha != 255 )
            s += Kmu.formatHexString((byte)alpha);

        return s;
    }

    private void append(StringBuilder args, String s)
    {
        if ( Kmu.isEmpty(s) )
            return;

        if ( args.length() > 0 )
            args.append("&");

        args.append(s);
    }

}
