/*
  Copyright (c) 2005-2011 www.kodemore.com

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

package com.kodemore.servlet.script;

import com.kodemore.json.KmJsonObject;
import com.kodemore.string.KmStringBuilder;

/**
 *  wyatt: (aaron) here is the Equalize script wrapper.  The actual
 *  javascrip function is at the bottom of KmUtility.js
 *  
 * review_aaron (wyatt)
 *      Fix your comment.
 */
public class ScEqualizeScript
    extends ScAbstractScript
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The jquery selector for the elements to be equalized.
     * 
     * review_aaron (wyatt) target
     */
    private String  _target;

    /**
     *  The minimum/maximum values for height and width.  The 
     *  equalized elements will always fall between these values
     *  if they are defined.
     *  
     *  review_aaron (wyatt) comment
     *      Fix comment formatting above.
     *      Unindented lines should start with ONE space, not two.
     *      
     *  review_aaron (wyatt) discuss naming
     */
    private Integer _minWidth;
    private Integer _maxWidth;
    private Integer _minHeight;
    private Integer _maxHeight;

    //##################################################
    //# constructor
    //##################################################

    /**
     * review_aaron (wyatt) remove constructor
     */
    public ScEqualizeScript(String target)
    {
        _target = target;
    }

    //##################################################
    //# acessing
    //##################################################

    public String getTarget()
    {
        return _target;
    }

    public void setTarget(String target)
    {
        _target = target;
    }

    //##################################################
    //# min and max values
    //##################################################

    public Integer getMinWidth()
    {
        return _minWidth;
    }

    /**
     * discuss_aaron (wyatt) discuss getter/setters.
     */
    public void setMinWidth(Integer minWidth)
    {
        _minWidth = minWidth;
    }

    public Integer getMaxWidth()
    {
        return _maxWidth;
    }

    public void setMaxWidth(Integer maxWidth)
    {
        _maxWidth = maxWidth;
    }

    public Integer getMinHeight()
    {
        return _minHeight;
    }

    public void setMinHeight(Integer minHeight)
    {
        _minHeight = minHeight;
    }

    public Integer getMaxHeight()
    {
        return _maxHeight;
    }

    public void setMaxHeight(Integer maxHeight)
    {
        _maxHeight = maxHeight;
    }

    //##################################################
    //# format
    //##################################################

    /**
     * review_aaron (wyatt) discuss
     *      see KmUtility.js
     */
    @Override
    public void formatScriptOn(KmStringBuilder out)
    {
        KmJsonObject options;
        options = new KmJsonObject();
        options.setInteger("minWidth", getMinWidth());
        options.setInteger("maxWidth", getMaxWidth());
        options.setInteger("minHeight", getMinHeight());
        options.setInteger("maxHeight", getMaxHeight());

        out.printf("%s.equalize(%s);", getTarget(), options);
    }
}
