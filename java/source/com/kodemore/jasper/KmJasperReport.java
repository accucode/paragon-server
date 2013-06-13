/*
  Copyright (c) 2010-2010 www.kodemore.com

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

package com.kodemore.jasper;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class KmJasperReport
{
    //##################################################
    //# variables
    //##################################################

    private JasperReport       _report;
    private Map<String,String> _parameters;
    private JRDataSource       _dataSource;
    private JasperPrint        _print;

    //##################################################
    //# constructor
    //##################################################

    public KmJasperReport()
    {
        setEmptyParameters();
        setEmptyDataSource();
    }

    //##################################################
    //# parameters
    //##################################################

    public void setEmptyParameters()
    {
        _parameters = new HashMap<String,String>();
        resetPrint();
    }

    public void setParameter(String key, String value)
    {
        _parameters.put(key, value);
        resetPrint();
    }

    //##################################################
    //# compile
    //##################################################

    public void compile(KmJasperReportBuilder e)
    {
        compile(e.printXml());
    }

    public void compile(String xml)
    {
        resetPrint();
        InputStream in = null;
        try
        {
            byte[] arr = xml.getBytes();
            in = new ByteArrayInputStream(arr);
            _report = JasperCompileManager.compileReport(in);
            in.close();
        }
        catch ( RuntimeException ex )
        {
            throw ex;
        }
        catch ( Exception ex )
        {
            throw new RuntimeException(ex);
        }
        finally
        {
            if ( in != null )
                try
                {
                    in.close();
                }
                catch ( Exception ex )
                {
                    // ignored
                }
        }
    }

    //##################################################
    //# data source
    //##################################################

    public void setDataSource(KmJasperDataSourceIF e)
    {
        _setDataSource(e);
    }

    public void setEmptyDataSource()
    {
        _setDataSource(new JREmptyDataSource());
    }

    public void setEchoDataSource(int rowCount)
    {
        setDataSource(new KmJasperEchoDataSource(rowCount));
    }

    private void _setDataSource(JRDataSource e)
    {
        _dataSource = e;
        resetPrint();
    }

    //##################################################
    //# pdf
    //##################################################

    public byte[] createPdf()
    {
        try
        {
            return JasperExportManager.exportReportToPdf(getPrint());
        }
        catch ( RuntimeException ex )
        {
            throw ex;
        }
        catch ( Exception ex )
        {
            throw new RuntimeException(ex);
        }
    }

    public void writePdfFile(String outFile)
    {
        try
        {
            JasperExportManager.exportReportToPdfFile(getPrint(), outFile);
        }
        catch ( RuntimeException ex )
        {
            throw ex;
        }
        catch ( Exception ex )
        {
            throw new RuntimeException(ex);
        }
    }

    //##################################################
    //# support
    //##################################################

    private void resetPrint()
    {
        _print = null;
    }

    private JasperPrint getPrint() throws JRException
    {
        if ( _print == null )
            _print = JasperFillManager.fillReport(_report, _parameters, _dataSource);
        return _print;
    }
}
