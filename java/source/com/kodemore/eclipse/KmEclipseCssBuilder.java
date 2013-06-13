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

package com.kodemore.eclipse;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

/**
 * I am used to convert css templates (.csst) into css files (.css).
 * 
 * Although not strictly required, I am intended to be used in conjuction
 * with the Eclipse Builder tool.  This allows the developer to write 
 * .csst files and have the .css files be auto-generated. 
 */
public class KmEclipseCssBuilder
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        System.out.println(KmEclipseCssBuilder.class.getName());

        for ( String arg : args )
        {
            KmEclipseCssBuilder e;
            e = new KmEclipseCssBuilder();
            e.run(arg);
        }

        System.out.println("done.");
    }

    //##################################################
    //# variables
    //##################################################

    private String               _inputPath;

    private KmMap<String,String> _variables;
    private KmStringBuilder      _out;

    //##################################################
    //# accessing
    //##################################################

    public String getInputPath()
    {
        return _inputPath;
    }

    public void setInputPath(String e)
    {
        _inputPath = e;
    }

    public String getOutputPath()
    {
        return Kmu.setExtension(getInputPath(), "css");
    }

    //##################################################
    //# run
    //##################################################

    public void run(String inputFile)
    {
        _inputPath = inputFile;

        run();
    }

    public void run()
    {
        System.out.println("Processing " + _inputPath);

        validate();
        generate();
    }

    //##################################################
    //# support
    //##################################################

    private void validate()
    {
        String in = _inputPath;

        if ( Kmu.isEmpty(in) )
            error("No input file provided.");

        if ( !Kmu.fileExists(in) )
            error("Input file not found: %s.", in);

        String ext = Kmu.getExtension(in).trim().toLowerCase();
        if ( !ext.equals("csst") )
            error("Invalid input extension (expected .csst).");
    }

    private void generate()
    {
        _variables = new KmMap<String,String>();
        _out = new KmStringBuilder();

        KmList<String> lines = Kmu.readTextFileLines(_inputPath);
        for ( String line : lines )
            generate(line);

        Kmu.writeFile(getOutputPath(), _out.toString());
    }

    private void generate(String line)
    {
        if ( line.startsWith("$") )
            generateVariable(line);

        else
            generateOutput(line);
    }

    private void generateVariable(String line)
    {
        int i = line.indexOf("=");

        String key = line.substring(0, i).trim();
        String value = line.substring(i + 1).trim();

        _variables.put(key, value);
    }

    private void generateOutput(String line)
    {
        for ( String key : _variables.getKeys() )
        {
            String value = _variables.get(key);
            line = Kmu.replaceAll(line, key, value);
        }

        _out.println(line);
    }

    public static void error(String msg, Object... args)
    {
        Kmu.error(msg, args);
    }

}
