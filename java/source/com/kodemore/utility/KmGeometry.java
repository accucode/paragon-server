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

package com.kodemore.utility;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * I am a collection of various static methods that are useful
 * in a variety of situations. This class should generally not
 * have any dependencies on other packages.
 */
public class KmGeometry
{
    public static Point2D getIntersection(Line2D line1, Line2D line2)
    {
        return getIntersection(line1.getP1(), line1.getP2(), line2.getP1(), line2.getP2());
    }

    public static Point2D getIntersection(Point2D p1a, Point2D p1b, Point2D p2a, Point2D p2b)
    {
        return getIntersection(
            p1a.getX(),
            p1a.getY(),
            p1b.getX(),
            p1b.getY(),
            p2a.getX(),
            p2a.getY(),
            p2b.getX(),
            p2b.getY());
    }

    public static Point2D getIntersection(
        double x1a,
        double y1a,
        double x1b,
        double y1b,
        double x2a,
        double y2a,
        double x2b,
        double y2b)
    {
        double denom = (y2b - y2a) * (x1b - x1a) - (x2b - x2a) * (y1b - y1a);
        if ( denom == 0 )
            return null;

        double num = (y2b - y2a) * (x2a - x1a) - (x2b - x2a) * (y2a - y1a);
        double r = num / denom;
        double x = x1a + r * (x1b - x1a);
        double y = y1a + r * (y1b - y1a);

        return new Point2D.Double(x, y);
    }

    public static double interpolate(double x1, double x2, double x, double y1, double y2)
    {
        return (x - x1) * (y2 - y1) / (x2 - x1) + y1;
    }

}
