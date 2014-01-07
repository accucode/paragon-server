/*
  Copyright (c) 2005-2014 www.kodemore.com

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

package com.kodemore.generator;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.generator.model.KmgModel;
import com.kodemore.generator.model.KmgModelEnum;
import com.kodemore.generator.setup.KmgSetup;
import com.kodemore.generator.setup.KmgSetupReader;
import com.kodemore.utility.Kmu;

public class KmgGenerator
{
    //##################################################
    //# variables
    //##################################################

    private String               _setupDir;
    private String               _setupFile;

    private String               _definesPath;

    /**
     * The root path is used to process the templates, it is not combined
     * with the setupPath or definesPath.
     */
    private String               _rootPath;

    private KmgRoot              _root;

    private KmList<KmgSetup>     _setups;

    private String               _javaAutoGenerationComment;
    private String               _xmlAutoGenerationComment;
    private String               _ddlAutoGenerationComment;

    private String               _lineEnd;

    private VelocityEngine       _velocity;
    private VelocityContext      _rootContext;
    private KmMap<String,Object> _extraContext;

    //##################################################
    //# constructor
    //##################################################

    public KmgGenerator()
    {
        _lineEnd = Kmu.getDefaultLineEnd();
        _extraContext = new KmMap<String,Object>();
    }

    //##################################################
    //# accessing
    //##################################################

    public String getSetupDir()
    {
        return _setupDir;
    }

    public void setSetupDir(String e)
    {
        _setupDir = e;
    }

    public String getSetupFile()
    {
        return _setupFile;
    }

    public void setSetupFile(String setupFile)
    {
        _setupFile = setupFile;
    }

    public String getDefinesPath()
    {
        return _definesPath;
    }

    public void setDefinesPath(String e)
    {
        _definesPath = e;
    }

    public String getRootPath()
    {
        return _rootPath;
    }

    public void setRootPath(String e)
    {
        _rootPath = e;
    }

    public KmList<KmgSetup> getSetups()
    {
        if ( _setups == null )
        {
            String path = Kmu.joinFilePath(_setupDir, _setupFile);

            KmgSetupReader r;
            r = new KmgSetupReader();
            r.setRootPath(_rootPath);

            _setups = r.readFile(path);
        }
        return _setups;
    }

    public KmgRoot getRoot()
    {
        return _root;
    }

    public void setRoot(KmgRoot e)
    {
        _root = e;
    }

    public String getLineEnd()
    {
        return _lineEnd;
    }

    public void setLineEnd(String e)
    {
        _lineEnd = e;
    }

    //##################################################
    //# process
    //##################################################

    public void run()
    {
        init();

        for ( KmgSetup e : getSetups() )
            process(e);
    }

    private void process(KmgSetup t)
    {
        System.out.println(t.getName());

        if ( t.getFileMode().equals("oneFile") )
        {
            processOneFile(t);
            return;
        }

        if ( t.getFileMode().equals("oneFilePerModel") )
        {
            processOneFilePerModel(t);
            return;
        }

        if ( t.getFileMode().equals("oneFilePerEnum") )
        {
            processOneFilePerEnum(t);
            return;
        }

        if ( t.getFileMode().equals("oneFilePerPageModel") )
        {
            processOneFilePerPageModel(t);
            return;
        }

        if ( t.getFileMode().equals("oneFilePerCacheModel") )
        {
            processOneFilePerCacheModel(t);
            return;
        }

        if ( t.getFileMode().equals("oneFilePerDatabaseModel") )
        {
            processOneFilePerDatabaseModel(t);
            return;
        }

        if ( t.getFileMode().equals("oneFilePerModelBase") )
        {
            processOneFilePerModelBase(t);
            return;
        }

        if ( t.getFileMode().equals("oneFilePerPrimaryKeyModel") )
        {
            processOneFilePerPrimaryKeyModel(t);
            return;
        }

        if ( t.getFileMode().equals("oneFilePerMetaFieldAndDelegate") )
        {
            processOneFilePerMetaFieldAndDelegate(t);
            return;
        }

        if ( t.getFileMode().equals("oneFilePerMetaAssociation") )
        {
            processOneFilePerMetaAssociation(t);
            return;
        }

        if ( t.getFileMode().equals("oneFilePerCssBundle") )
        {
            processOneFilePerCssBundle(t);
            return;
        }

        fatal("Unknown file mode: " + t.getFileMode());
    }

    private void processOneFile(KmgSetup gs)
    {
        VelocityContext c = getRootContext();
        writeFile(gs, c);
    }

    private void processOneFilePerModel(KmgSetup gs)
    {
        KmList<KmgModel> v = _root.getModels();
        processOneFilePer(gs, v, "model");
    }

    private void processOneFilePerEnum(KmgSetup gs)
    {
        KmList<KmgModelEnum> v = _root.getEnums();
        processOneFilePer(gs, v, "enum");
    }

    private void processOneFilePerPageModel(KmgSetup gs)
    {
        KmList<KmgModel> v = _root.getPageModels();
        processOneFilePer(gs, v, "model");
    }

    private void processOneFilePerCacheModel(KmgSetup gs)
    {
        KmList<KmgModel> v = _root.getCacheModels();
        processOneFilePer(gs, v, "model");
    }

    private void processOneFilePerDatabaseModel(KmgSetup gs)
    {
        KmList<KmgModel> v = _root.getDatabaseModels();
        processOneFilePer(gs, v, "model");
    }

    private void processOneFilePerModelBase(KmgSetup gs)
    {
        KmList<KmgModel> v = _root.getModelBases();
        processOneFilePer(gs, v, "model");
    }

    private void processOneFilePerPrimaryKeyModel(KmgSetup gs)
    {
        KmList<KmgModel> v = _root.getPrimaryKeyModels();
        processOneFilePer(gs, v, "model");
    }

    private void processOneFilePerMetaFieldAndDelegate(KmgSetup gs)
    {
        KmList<?> v = _root.getMetaFieldsAndDelegates();
        processOneFilePer(gs, v, "field");
    }

    private void processOneFilePerMetaAssociation(KmgSetup gs)
    {
        KmList<?> v = _root.getMetaAssociations();
        processOneFilePer(gs, v, "field");
    }

    private void processOneFilePerCssBundle(KmgSetup gs)
    {
        KmList<?> v = _root.getCssBundles();
        processOneFilePer(gs, v, "bundle");
    }

    private void processOneFilePer(KmgSetup setup, KmList<?> v, String eachKey)
    {
        VelocityContext context = new VelocityContext(getRootContext());
        for ( Object e : v )
        {
            context.put(eachKey, e);
            writeFile(setup, context);
        }
    }

    //##################################################
    //# context
    //##################################################

    private VelocityContext getRootContext()
    {
        if ( _rootContext == null )
            _rootContext = createRootContext();

        return _rootContext;
    }

    private VelocityContext createRootContext()
    {
        VelocityContext c = new VelocityContext();
        c.put("root", _root);
        c.put("applicationName", _root.getApplicationName());
        c.put("package", _root.getApplicationPackage());
        c.put("packagePath", _root.getApplicationPackagePath());
        c.put("prefix", _root.getApplicationPrefix());
        c.put("Prefix", _root.format_ApplicationPrefix());
        c.put("javaAutoGenerationComment", getJavaAutoGenerationComment());
        c.put("xmlAutoGenerationComment", getXmlAutoGenerationComment());
        c.put("htmlAutoGenerationComment", getHtmlAutoGenerationComment());
        c.put("ddlAutoGenerationComment", getDdlAutoGenerationComment());
        c.put("utility", new KmgUtility());

        for ( String key : _extraContext.keySet() )
            c.put(key, _extraContext.get(key));

        return c;
    }

    public void setExtraContext(String key, Object e)
    {
        _extraContext.put(key, e);
    }

    //##################################################
    //# write file
    //##################################################

    private void writeFile(KmgSetup setup, VelocityContext context)
    {
        String targetDir = formatTargetDirectory(setup, context);
        String targetName = formatFileName(setup, context);

        String targetPath;
        targetPath = Kmu.joinFilePath(targetDir, targetName);
        targetPath = Kmu.getCanonicalPath(targetPath);

        Kmu.createFolder(targetDir);

        File targetFile = new File(targetPath);
        boolean targetExists = targetFile.exists();

        String text;
        text = formatSource(setup, context);
        text = normalizeFile(text);

        updateCounts(targetPath, text);

        if ( targetExists && setup.skipIfExists() )
            return;

        if ( hasChanged(targetPath, text) )
        {
            Kmu.writeFile(targetPath, text);
            System.out.println(targetPath);
        }
    }

    private String normalizeFile(String s)
    {
        return Kmu.normalizeLineEnds(s, _lineEnd);
    }

    private boolean hasChanged(String path, String newText)
    {
        if ( !Kmu.fileExists(path) )
            return true;

        String oldText = Kmu.readTextFile(path);
        return !oldText.equals(newText);
    }

    //##################################################
    //# template
    //##################################################

    private String formatTargetDirectory(KmgSetup setup, VelocityContext context)
    {
        return evaluate(setup.getTargetDirectory(), context);
    }

    private String formatSource(KmgSetup setup, VelocityContext context)
    {
        Template template = getTemplate(setup.getTemplate());
        return formatTemplate(template, context);
    }

    private String formatFileName(KmgSetup setup, VelocityContext context)
    {
        String template = setup.getFileName();
        return evaluate(template, context);
    }

    //##################################################
    //# velocity
    //##################################################

    private void init()
    {
        try
        {
            _velocity = new VelocityEngine();
            _velocity.setProperty("file.resource.loader.path", getSetupDir());
            _velocity.setProperty("directive.foreach.counter.name", "foreachIndex");
            _velocity.setProperty("directive.foreach.counter.initial.value", 0);
            _velocity.init();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    private Template getTemplate(String fileName)
    {
        try
        {
            return _velocity.getTemplate(fileName);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    private String formatTemplate(Template template, VelocityContext context)
    {
        try
        {
            StringWriter out = new StringWriter();
            template.merge(context, out);
            out.close();
            return out.toString();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    private String evaluate(String template, VelocityContext context)
    {
        try
        {
            StringWriter out = new StringWriter();
            boolean ok = _velocity.evaluate(context, out, "dynamic", template);
            out.close();
            if ( !ok )
                fatal("Cannot evaluate template: (%s).", template);
            return out.toString();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# header blocks
    //##################################################

    private String getJavaAutoGenerationComment()
    {
        if ( _javaAutoGenerationComment == null )
            _javaAutoGenerationComment = composeJavaAutoGenerationComment();
        return _javaAutoGenerationComment;
    }

    private String composeJavaAutoGenerationComment()
    {
        StringWriter sw = new StringWriter();
        PrintWriter out = new PrintWriter(sw);
        out.println("//###############################################################");
        out.println("//###############################################################");
        out.println("//##");
        out.println("//##  AUTO GENERATED - DO NOT EDIT");
        out.println("//##");
        out.println("//###############################################################");
        out.print("//###############################################################");
        out.close();
        return sw.toString();
    }

    private String getXmlAutoGenerationComment()
    {
        if ( _xmlAutoGenerationComment == null )
            _xmlAutoGenerationComment = composeXmlAutoGenerationComment();

        return _xmlAutoGenerationComment;
    }

    private String composeXmlAutoGenerationComment()
    {
        StringWriter sw = new StringWriter();
        PrintWriter out = new PrintWriter(sw);
        out.println("<!--");
        out.println("###############################################################");
        out.println("###############################################################");
        out.println("##");
        out.println("##  AUTO GENERATED - DO NOT EDIT");
        out.println("##");
        out.println("###############################################################");
        out.println("###############################################################");
        out.print("-->");
        out.close();
        return sw.toString();
    }

    private String getHtmlAutoGenerationComment()
    {
        return getXmlAutoGenerationComment();
    }

    private String getDdlAutoGenerationComment()
    {
        if ( _ddlAutoGenerationComment == null )
            _ddlAutoGenerationComment = composeDdlAutoGenerationComment();
        return _ddlAutoGenerationComment;
    }

    private String composeDdlAutoGenerationComment()
    {
        StringWriter sw = new StringWriter();
        PrintWriter out = new PrintWriter(sw);
        out.println("###############################################################");
        out.println("###############################################################");
        out.println("##");
        out.println("##  AUTO GENERATED - DO NOT EDIT");
        out.println("##");
        out.println("###############################################################");
        out.print("###############################################################");
        out.close();
        return sw.toString();
    }

    //##################################################
    //# support
    //##################################################

    public void fatal(String s, Object... args)
    {
        Kmu.fatal(s, args);
    }

    //##################################################
    //# log
    //##################################################

    private static KmMap<String,Integer> bytes = new KmMap<String,Integer>();
    private static KmMap<String,Integer> lines = new KmMap<String,Integer>();

    public void updateCounts(String path, String text)
    {
        Integer i;
        String ext = Kmu.getExtension(path);

        i = bytes.get(ext);
        if ( i == null )
            i = 0;

        i += text.length();

        bytes.put(ext, i);

        i = lines.get(ext);
        if ( i == null )
            i = 0;

        i += Kmu.getLines(text).size();
        lines.put(ext, i);
    }

    public static void printCounts()
    {
        System.out.println();
        System.out.println();
        System.out.println("Summary");
        System.out.printf("%8s: %10s %10s\n", "Ext", "Lines", "Bytes");

        KmList<String> exts;
        exts = bytes.getKeys();
        exts.sort();
        for ( String s : exts )
            System.out.printf("%8s: %,10d %,10d\n", s, lines.get(s), bytes.get(s));
    }

}
