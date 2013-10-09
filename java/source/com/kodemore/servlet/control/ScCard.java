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

package com.kodemore.servlet.control;

/**
 * I am used in conjuction with the ScCardFrame.
 */
public class ScCard
    extends ScDiv
{
    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();
    }

    //##################################################
    //# navigation
    //##################################################

    /**
     * I am called immediately before this card is printed.
     * I am called each (every) time the card is printed.
     * Subclasses are generally NOT required to call super.
     */
    public void prePrint()
    {
        // subclass 
    }

    public void print()
    {
        getFrame().print(this);
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public ScCardFrame getParent()
    {
        return (ScCardFrame)super.getParent();
    }

    public ScCardFrame getFrame()
    {
        return getParent();
    }

    protected void closeCard()
    {
        getFrame().close(this);
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public void beDefault()
    {
        getFrame().setDefaultCard(this);
    }

    public boolean isDefault()
    {
        return getFrame().isDefaultCard(this);
    }
}
