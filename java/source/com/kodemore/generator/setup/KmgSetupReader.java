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

package com.kodemore.generator.setup;

import com.kodemore.collection.KmList;
import com.kodemore.stf.KmStfElement;
import com.kodemore.stf.KmStfParser;
import com.kodemore.stf.KmStfRoot;
import com.kodemore.utility.KmConstantsIF;

/**
 * I am the parser used to create template rules for processing models.
 * Typically, the template rules read from a file, see parseFile().
 */
public class KmgSetupReader
    implements KmConstantsIF
{
    //##################################################
    //# variables
    //##################################################

    private String _rootPath;

    //##################################################
    //# accessing
    //##################################################

    public String getRootPath()
    {
        return _rootPath;
    }

    public void setRootPath(String e)
    {
        _rootPath = e;
    }

    //##################################################
    //# process
    //##################################################

    public KmList<KmgSetup> readFile(String path)
    {
        KmStfParser parser;
        parser = new KmStfParser();
        parser.parseFile(path);

        KmStfRoot root;
        root = parser.getRoot();

        return parseRoot(root);
    }

    private KmList<KmgSetup> parseRoot(KmStfRoot root)
    {
        KmList<KmgSetup> v = new KmList<KmgSetup>();

        KmList<KmStfElement> es = root.getChildren("setup");
        for ( KmStfElement e : es )
            v.add(parseSetup(e));

        return v;
    }

    private KmgSetup parseSetup(KmStfElement e)
    {
        String name = e.getValue("name");
        String template = e.getValue("template");
        String target = e.getValue("targetDirectory");
        String fileMode = e.getValue("fileMode");
        String fileName = e.getValue("fileName");
        String ifExists = e.getValue("ifExists");

        KmgSetup setup;
        setup = new KmgSetup();
        setup.setName(name);
        setup.setTemplate(template);
        setup.setTargetDirectory(target);
        setup.setFileMode(fileMode);
        setup.setFileName(fileName);
        setup.setIfExists(ifExists);
        return setup;
    }

}
