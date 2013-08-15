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

package com.kodemore.profile;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class KmProfileTreeModel
    implements TreeModel
{
    //##################################################
    //# variables
    //##################################################

    private KmProfileTraceNode _root;

    //##################################################
    //# constructor
    //##################################################

    public KmProfileTreeModel(KmProfileTraceNode root)
    {
        _root = root;
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public Object getRoot()
    {
        return _root;
    }

    @Override
    public int getIndexOfChild(Object parent, Object child)
    {
        KmProfileTraceNode pNode = (KmProfileTraceNode)parent;
        KmProfileTraceNode cNode = (KmProfileTraceNode)child;
        return pNode.getIndexOfChild(cNode);
    }

    @Override
    public Object getChild(Object parent, int index)
    {
        KmProfileTraceNode pNode = (KmProfileTraceNode)parent;
        return pNode.getChildAt(index);
    }

    @Override
    public int getChildCount(Object parent)
    {
        KmProfileTraceNode pNode = (KmProfileTraceNode)parent;
        return pNode.getChildCount();
    }

    @Override
    public boolean isLeaf(Object node)
    {
        KmProfileTraceNode pNode = (KmProfileTraceNode)node;
        return pNode.isLeaf();
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addTreeModelListener(TreeModelListener l)
    {
        // ignored
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l)
    {
        // ignored
    }
}
