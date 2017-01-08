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

package com.kodemore.dbase3;

import com.kodemore.console.KmConsoleMeter;

public class KmDbaseTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String args[])
    {
        new KmDbaseTest().run();
    }

    //##################################################
    //# run
    //##################################################

    private void run()
    {
        printFile();
    }

    private void printFile()
    {
        String path = "somefile.dbf";
        printFile(path);
    }

    private void printFile(String path)
    {
        KmDbaseFile f;
        f = new KmDbaseFile();
        f.setPath(path);

        System.out.println();
        System.out.println("Path: " + path);
        printHeader(f);
        printColumnDescriptors(f);
        printFirstRecord(f);
        printLastRecord(f);
        printRecords(f);
        iterateRecords(f);
    }

    private void printHeader(KmDbaseFile f)
    {
        KmDbaseHeader h = f.getHeader();
        System.out.println("Header");
        System.out.println("    h.getVersion():         " + h.getVersion());
        System.out.println("    h.getMemoFlag():        " + h.getMemoFlag());
        System.out.println("    h.getLastUpdate():      " + h.getLastUpdate());
        System.out.println("    h.getRecordCount():     " + h.getRecordCount());
        System.out.println("    h.getHeaderByteCount(): " + h.getHeaderByteCount());
        System.out.println("    h.getRecordByteCount(): " + h.getRecordByteCount());
        System.out.println("    h.getFieldCount():      " + h.getFieldCount());
    }

    private void printColumnDescriptors(KmDbaseFile f)
    {
        System.out.println();
        System.out.println("Field Descriptors");

        int n = f.getFieldDescriptorCount();
        for ( int i = 0; i < n; i++ )
        {
            KmDbaseFieldDescriptor fd;
            fd = f.getFieldDescriptor(i);
            System.out.println("    fd.getName():           " + fd.getName());
            System.out.println("    fd.getType():           " + fd.getType());
            System.out.println("    fd.getLength():         " + fd.getLength());
            System.out.println("    fd.getDecimalCount():   " + fd.getDecimalCount());
            System.out.println("    fd.getWorkAreaId():     " + fd.getWorkAreaId());
            System.out.println("    fd.getSetFieldsFlag():  " + fd.getSetFieldsFlag());
            System.out.println("    fd.getOffset():         " + fd.getOffset());
            System.out.println();
        }
    }

    private void printFirstRecord(KmDbaseFile f)
    {
        printRecord(f, 0);
    }

    private void printLastRecord(KmDbaseFile f)
    {
        int n = f.getHeader().getRecordCount();
        printRecord(f, n - 1);
    }

    private void printRecords(KmDbaseFile f)
    {
        int n = f.getHeader().getRecordCount();
        n = 1;
        for ( int i = 0; i < n; i++ )
            printRecord(f, i);
    }

    private void printRecord(KmDbaseFile f, int index)
    {
        KmDbaseRecord r = f.getRecord(index);
        System.out.println("Record: " + index);
        printFields(r);
    }

    public void printFields(KmDbaseRecord r)
    {
        int n = r.getFieldCount();
        for ( int i = 0; i < n; i++ )
        {
            KmDbaseFieldDescriptor fd = r.getFieldDescriptor(i);

            System.out.print(fd.getName());
            System.out.print("(");
            System.out.print(fd.getType());
            System.out.print("): ");
            System.out.print(formatField(r, i));
            System.out.println();
        }
        System.out.println();
    }

    public String formatField(KmDbaseRecord r, int i)
    {
        KmDbaseFieldDescriptor fd = r.getFieldDescriptor(i);

        if ( fd.isCharacter() )
            return r.getString(i).trim();

        if ( fd.isDate() )
            return r.getDate(i) + "";

        if ( fd.isLogical() )
            return r.getBoolean(i) + "";

        if ( fd.isNumeric() )
        {
            if ( fd.getDecimalCount() > 0 )
                return r.getDouble(i) + "";

            if ( fd.getLength() < 10 )
                return r.getInteger(i) + "";

            return r.getLong(i) + "";
        }

        return "UKNONWN FORMAT";
    }

    //##################################################
    //# iterator records
    //##################################################

    public void iterateRecords(KmDbaseFile f)
    {
        int n = f.getHeader().getRecordCount();
        KmConsoleMeter m = new KmConsoleMeter("Records", n);

        for ( int i = 0; i < n; i++ )
        {
            iterateRecord(f, i);
            m.meter();
        }

        m.stop();
    }

    public void iterateRecord(KmDbaseFile f, int i)
    {
        KmDbaseRecord r = f.getRecord(i);
        iterateFields(r);
    }

    public void iterateFields(KmDbaseRecord r)
    {
        int n = r.getFieldCount();
        for ( int i = 0; i < n; i++ )
            formatField(r, i);
    }

}
