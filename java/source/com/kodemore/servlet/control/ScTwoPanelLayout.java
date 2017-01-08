/*
  Copyright (c) 2005-2016 www.kodemore.com

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
 */

package com.kodemore.servlet.control;

/**
 * I provide a layout that displays two groups (ScGroup) side-by-side.
 *
 * Groups.
 * The groups can be accessed via getLeftGroup and getRightGroup.
 *
 * Contents.
 * Clients can add contents via the getLeftBox and getRightBox.
 * These bodies correspond loosely to the body of the respective
 * groups but not exactly.  Clients should NOT add contents directly
 * to the groups.  The contents will be automatically inset with
 * standard padding inside the groups.  Also, the contents have a
 * non-static position by default, so clients can safely use
 * abolute positioning to fill the left or right boxes.
 *
 * Styling
 * Clients may safely set the title/banner of the groups, but should
 * avoid other changes.  The groups are prestyled in a very specific way
 * and clients should not change this.
 */
public class ScTwoPanelLayout
    extends ScDivWrapper
{
    //##################################################
    //# variables
    //##################################################

    private ScGroup _leftGroup;
    private ScDiv   _leftBox;

    private ScGroup _rightGroup;
    private ScDiv   _rightBox;

    //##################################################
    //# constructor
    //##################################################

    public ScTwoPanelLayout()
    {
        ScDiv root;
        root = getInner();
        root.css().relative();

        ScDiv row;
        row = root.addFlexRow();
        row.css().fill();

        installLeftOn(row);
        installGapOn(row);
        installRightOn(row);
    }

    private void installLeftOn(ScDiv row)
    {
        ScGroup group;
        group = row.addGroup();
        group.setFlavorSecondary();
        group.css().flexChildBasis0().flexChildFiller();

        ScDiv box;
        box = group.getBody().addDiv();
        box.css().fillOffset10().relative();

        _leftGroup = group;
        _leftBox = box;
    }

    private void installGapOn(ScDiv row)
    {
        row.addFlexGap(20);
    }

    private void installRightOn(ScDiv row)
    {
        ScGroup group;
        group = row.addGroup();
        group.setFlavorTertiary();
        group.css().flexChildBasis0().flexChildFiller();

        ScDiv box;
        box = group.getBody().addDiv();
        box.css().fillOffset10().relative();

        _rightGroup = group;
        _rightBox = box;
    }

    //##################################################
    //# accessing
    //##################################################

    public ScGroup getLeftGroup()
    {
        return _leftGroup;
    }

    public ScGroup getRightGroup()
    {
        return _rightGroup;
    }

    public ScDiv getLeftBox()
    {
        return _leftBox;
    }

    public ScDiv getRightBox()
    {
        return _rightBox;
    }

}
