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

public class ScThreePanelLayout
    extends ScDivWrapper
{
    //##################################################
    //# variables
    //##################################################

    private ScGroup _menuGroup;
    private ScGroup _leftGroup;
    private ScGroup _rightGroup;
    private ScDiv   _menuBox;
    private ScDiv   _leftBox;
    private ScDiv   _rightBox;

    //##################################################
    //# constructor
    //##################################################

    public ScThreePanelLayout()
    {
        ScDiv root;
        root = getInner();

        ScDiv row;
        row = root.addFlexRow();
        row.css().fill().pad20();

        // ----- columns ---------

        ScDiv menuColumn;
        menuColumn = row.addFlexColumn();
        menuColumn.css().flexChildStatic();
        menuColumn.style().width(350);

        row.addFlexGap(20);

        ScDiv leftColumn;
        leftColumn = row.addFlexColumn();
        leftColumn.css().flexChildGrow().flexChildBasis0();

        row.addFlexGap(20);

        ScDiv rightColumn;
        rightColumn = row.addFlexColumn();
        rightColumn.css().flexChildGrow().flexChildBasis0();

        // ----- groups ---------

        _menuGroup = menuColumn.addGroup();
        _menuGroup.setFlavorPrimary();
        _menuGroup.css().flexChildGrow();

        _leftGroup = leftColumn.addGroup();
        _leftGroup.setFlavorSecondary();
        _leftGroup.css().flexChildGrow();

        _rightGroup = rightColumn.addGroup();
        _rightGroup.setFlavorTertiary();
        _rightGroup.css().flexChildGrow();

        _menuGroup.getBody().css().flexRow();
        _leftGroup.getBody().css().flexRow();
        _rightGroup.getBody().css().flexRow();

        _menuBox = _menuGroup.getBody().addDiv();
        _menuBox.css().flexColumn().margin10();

        _leftBox = _leftGroup.getBody().addDiv();
        _leftBox.css().flexColumn().margin10();

        _rightBox = _rightGroup.getBody().addDiv();
        _rightBox.css().flexColumn().margin10();
    }

    //##################################################
    //# accessing
    //##################################################

    public ScGroup getMenuGroup()
    {
        return _menuGroup;
    }

    public void setMenuGroup(ScGroup menuGroup)
    {
        _menuGroup = menuGroup;
    }

    public ScGroup getLeftGroup()
    {
        return _leftGroup;
    }

    public void setLeftGroup(ScGroup leftGroup)
    {
        _leftGroup = leftGroup;
    }

    public ScGroup getRightGroup()
    {
        return _rightGroup;
    }

    public void setRightGroup(ScGroup rightGroup)
    {
        _rightGroup = rightGroup;
    }

    public ScDiv getMenuBox()
    {
        return _menuBox;
    }

    public void setMenuBox(ScDiv menuBox)
    {
        _menuBox = menuBox;
    }

    public ScDiv getLeftBox()
    {
        return _leftBox;
    }

    public void setLeftBox(ScDiv leftBox)
    {
        _leftBox = leftBox;
    }

    public ScDiv getRightBox()
    {
        return _rightBox;
    }

    public void setRightBox(ScDiv rightBox)
    {
        _rightBox = rightBox;
    }

    //##################################################
    //# utility
    //##################################################

    public void addLeftSpacer()
    {
        getLeftBox().add(createSpacer());
    }

    public void addRightSpacer()
    {
        getRightBox().add(createSpacer());
    }

    private ScControl createSpacer()
    {
        ScDiv spacer = new ScDiv();
        spacer.css().height10();

        return spacer;
    }
}
