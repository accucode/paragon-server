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

package com.kodemore.csv;

/**
 * A minimal interface for reading records and cells.
 */
public interface KmCellReaderIF
{
    /**
     * Read the next record; this must be called before the first
     * record is accessed.  Return true if a record is read, false
     * if end of file.  The reader is NOT closed automatically upon
     * end of file, you must call close.
     */
    boolean nextRecord();

    /**
     * Read the next string in the current record.
     */
    String getString();

    /**
     * Read the string at the column index (0-based) with the current record.
     */
    String getString(int column);

    /**
     * Read the Integer at the column index (0-based) with the current record. Returns
     * def if an error occurs.
     */
    int getInteger(int column, int def);

    /**
     * Read the Boolean at the column index (0-based) with the current record.
     */
    Boolean getBooleanObject(int column);
}
