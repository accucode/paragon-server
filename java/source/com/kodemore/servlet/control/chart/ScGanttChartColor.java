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

package com.kodemore.servlet.control.chart;

import com.kodemore.collection.KmList;
import com.kodemore.utility.KmEnumIF;

public enum ScGanttChartColor
    implements KmEnumIF
{
    //##################################################
    //# enum
    //##################################################

    Blue,
    Blue1,
    Blue2,
    Blue3,
    Blue4,
    Blue5,
    Blue6,
    Cyan,
    Green,
    Yellow,
    Orange,
    Orange1,
    Orange2,
    Orange3,
    Orange4,
    Orange5,
    Orange6,
    Purple,
    Purple1,
    Purple2,
    Purple3,
    Purple4,
    Purple5,
    Purple6,
    Red,
    Gray,
    Gray1,
    Gray2,
    Gray3,
    Gray4,
    Gray5,
    Gray6;

    //##################################################
    //# default
    //##################################################

    public static ScGanttChartColor getDefaultColor()
    {
        return ScGanttChartColor.Blue;
    }

    //##################################################
    //# theme
    //##################################################

    public static KmList<ScGanttChartColor> getRainbowThemeColors()
    {
        KmList<ScGanttChartColor> v;
        v = new KmList<>();
        v.add(Blue);
        v.add(Cyan);
        v.add(Green);
        v.add(Yellow);
        v.add(Orange);
        v.add(Purple);
        return v;
    }

    //==================================================
    //= theme :: blue
    //==================================================

    public static KmList<ScGanttChartColor> getBlueThemeColors()
    {
        KmList<ScGanttChartColor> v;
        v = new KmList<>();
        v.add(Blue1);
        v.add(Blue2);
        v.add(Blue3);
        v.add(Blue4);
        v.add(Blue5);
        v.add(Blue6);
        return v;
    }

    //==================================================
    //= theme :: orange
    //==================================================

    public static KmList<ScGanttChartColor> getOrangeThemeColors()
    {
        KmList<ScGanttChartColor> v;
        v = new KmList<>();
        v.add(Orange1);
        v.add(Orange2);
        v.add(Orange3);
        v.add(Orange4);
        v.add(Orange5);
        v.add(Orange6);
        return v;
    }

    //==================================================
    //= theme :: orange
    //==================================================

    public static KmList<ScGanttChartColor> getPurpleThemeColors()
    {
        KmList<ScGanttChartColor> v;
        v = new KmList<>();
        v.add(Purple1);
        v.add(Purple2);
        v.add(Purple3);
        v.add(Purple4);
        v.add(Purple5);
        v.add(Purple6);
        return v;
    }
}
