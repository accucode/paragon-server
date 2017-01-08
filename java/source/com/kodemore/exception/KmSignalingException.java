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

package com.kodemore.exception;

/**
 * I am used to indicate unchecked exceptions that are used during
 * NORMAL execution to signal some status to the caller.  I indicate
 * that callers should NOT wrap me or attempt to provide additional
 * context, but should rather simply rethrow me if caught so that
 * the upstream sender can easily catch and process the signal.
 */
public class KmSignalingException
    extends RuntimeException
{
    //##################################################
    //# constructor
    //##################################################

    public KmSignalingException()
    {
        super();
    }

    public KmSignalingException(String message)
    {
        super(message);
    }

    public KmSignalingException(Throwable cause)
    {
        super(cause);
    }

    public KmSignalingException(String msg, Throwable cause)
    {
        super(msg, cause);
    }

}
