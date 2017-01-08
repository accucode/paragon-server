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

package com.kodemore.generator.setup;

import com.kodemore.utility.KmConstantsIF;
import com.kodemore.utility.Kmu;

/**
 * I define the attributes used to apply a list of models to a template.
 */
public class KmgSetup
    implements KmConstantsIF
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The name of the template.  This is only used to print status.
     */
    private String _name;

    /**
     * The path to the template file.   This is the file that will contain
     * the macro substitutions for the models.  It is assumed that the
     * source file is located in the same directory as the setup file.
     */
    private String _template;

    /**
     * The path to the target directory where the resulting file(s) should
     * be created.  This is NOT the path to the fully qualified file name; use
     * fileName to define the fileName.
     */
    private String _targetDirectory;

    /**
     * The fileMode should be set to one of the values:
     *      oneFile
     *      oneFilePerModel
     *
     * If the value is oneFile then all of the models will be iterated for
     * a single file, the fileName defines the name of the file.  If oneFilePerModel,
     * then a separate file will be created for each model and only the single model
     * will be accessable to the template when processing that file; the file name
     * must include a template macro in order to create distinct file names.
     */
    private String _fileMode;

    /**
     * The file name to create.  If the file mode is oneFilePerModel, then this
     * name should include a template macro that will result in distinct file names.
     */
    private String _fileName;

    /**
     * Define the policy to follow if the target file already exists.  Valid values
     * are: overwrite and skip.
     */
    private String _ifExists;

    /**
     * The last time when the setup file was modified.  If 0, the time is unknown.
     * This is populated using File.lastModified.
     */
    private long   _lastModified;

    //##################################################
    //# accessing
    //##################################################

    public String getName()
    {
        return _name;
    }

    public void setName(String e)
    {
        _name = e;
    }

    public String getTemplate()
    {
        return _template;
    }

    public void setTemplate(String e)
    {
        _template = e;
    }

    public String getTargetDirectory()
    {
        return _targetDirectory;
    }

    public void setTargetDirectory(String e)
    {
        _targetDirectory = e;
    }

    public String getFileMode()
    {
        return _fileMode;
    }

    public void setFileMode(String e)
    {
        _fileMode = e;
    }

    public String getFileName()
    {
        return _fileName;
    }

    public void setFileName(String e)
    {
        _fileName = e;
    }

    public String getIfExists()
    {
        return _ifExists;
    }

    public void setIfExists(String e)
    {
        _ifExists = e;
    }

    public boolean overwriteIfExists()
    {
        return Kmu.isEqual(_ifExists, "overwrite");
    }

    public boolean skipIfExists()
    {
        return !overwriteIfExists();
    }

    public long getLastModified()
    {
        return _lastModified;
    }

    public void setLastModified(long e)
    {
        _lastModified = e;
    }

    //##################################################
    //# display
    //##################################################

    public void print()
    {
        System.out.println(Kmu.getSimpleClassName(this));
        System.out.println("    name:      " + _name);
        System.out.println("    source:    " + _template);
        System.out.println("    targetDir: " + _targetDirectory);
        System.out.println("    fileMode:  " + _fileMode);
        System.out.println("    fileName:  " + _fileName);
        System.out.println("    isExists:  " + _ifExists);
    }
}
