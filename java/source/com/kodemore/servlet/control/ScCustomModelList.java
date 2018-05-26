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

package com.kodemore.servlet.control;

/**
 * I specialize the ScModelList and allow clients to define complex, ad hoc, custom
 * rendering for each item in the list.  Most clients should instead use the ScSimpleModelList
 * which provides standard formatting and a simpler implementation.
 */
public class ScCustomModelList<T>
    extends ScAbstractModelList<T>
{
    //##################################################
    //# variables
    //##################################################

    /**
     * I am responsible for composing the content for each model element.
     * I am a REQUIRED attribute.
     *
     * Although optional, clients will normally need to specify this
     * in order to get something useful.  The default is to simply
     * display the toString of each model.
     *
     * The root is a transient object and may be safely manipulated by the client.
     * The client may add and remove child elements, and may also manipulate the
     * root's style as needed.  By default, the root has the default (box) style,
     * which means it has no visible border or background.
     *
     * The root DOES have a specific htmlId already set, and clients should
     * NOT change this.  The htmlId is used to coordinate dynamic ajax changes.
     */
    private ScBoxComposerIF<T> _itemComposer;

    //##################################################
    //# constructor
    //##################################################

    public ScCustomModelList()
    {
        // none
    }

    //##################################################
    //# renderer
    //##################################################

    public ScBoxComposerIF<T> getItemComposer()
    {
        return _itemComposer;
    }

    public void setItemComposer(ScBoxComposerIF<T> e)
    {
        _itemComposer = e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void composeItemOn(ScDiv root, T value)
    {
        _itemComposer.composeOn(root, value);
    }

}
