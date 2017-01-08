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
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
*/

package com.kodemore.job;

import com.kodemore.collection.KmList;

public class KmSimpleJobManager
    extends KmJobManager
{
    //##################################################
    //# variables
    //##################################################

    private KmList<KmJob> _jobs;

    //##################################################
    //# constructor
    //##################################################

    public KmSimpleJobManager()
    {
        _jobs = new KmList<>();
    }

    //##################################################
    //# accessing
    //##################################################

    public void add(KmJob e)
    {
        _jobs.add(e);
    }

    //##################################################
    //# overrides
    //##################################################

    @Override
    protected void runOnce()
    {
        for ( KmJob e : _jobs )
            runJob(e);
    }

    @Override
    protected int getLoopSleepMs()
    {
        return getMsToNextJob(_jobs);
    }

    @Override
    protected void onStop()
    {
        for ( KmJob e : _jobs )
            e.handleStop();
    }

}
