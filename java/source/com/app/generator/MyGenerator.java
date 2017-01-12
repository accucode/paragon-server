package com.app.generator;

import com.kodemore.collection.KmList;
import com.kodemore.exception.KmApplicationException;
import com.kodemore.file.KmFile;
import com.kodemore.file.KmFileTraverser;
import com.kodemore.generator.KmgGenerator;
import com.kodemore.generator.KmgRoot;
import com.kodemore.generator.model.KmgCssBundle;
import com.kodemore.html.KmCssParser;
import com.kodemore.javaParser.KmJavaParser;
import com.kodemore.log.KmLog;
import com.kodemore.utility.KmConstantsIF;
import com.kodemore.utility.Kmu;

import com.app.file.MyDevelopmentFiles;
import com.app.utility.MyConstantsIF;
import com.app.utility.MyEnvironment;

public class MyGenerator
    implements KmConstantsIF
{
    //##################################################
    //# main
    //##################################################

    public static void main(String... args)
    {
        try
        {
            KmLog.installConsole();
            MyEnvironment.install();

            MyGenerator e;
            e = new MyGenerator();
            e.setArgs(args);
            e.generate();
        }
        catch ( KmApplicationException ex )
        {
            System.out.flush();
            System.err.flush();
        }
        catch ( RuntimeException ex )
        {
            System.out.flush();
            System.err.flush();
            ex.printStackTrace(System.out);
        }
    }

    //##################################################
    //# constants
    //##################################################

    /**
     * This class prefix is used in front of most/all of the application
     * specific classes.  In particular this prefix is used during code
     * generation.
     */
    private static final String APPLICATION_PREFIX  = "my";

    /**
     * The root package that contains the application specific code.
     */
    private static final String APPLICATION_PACKAGE = "com.app";

    //##################################################
    //# variables
    //##################################################

    private KmgRoot             _root;
    private KmList<String>      _args;

    private boolean             _installedModels;
    private boolean             _installedProperties;
    private boolean             _installedPages;
    private boolean             _installedCss;

    //##################################################
    //# constructor
    //##################################################

    public MyGenerator()
    {
        _args = new KmList<>();
    }

    //##################################################
    //# generate
    //##################################################

    public void generate()
    {
        if ( getArgs().isEmpty() )
        {
            generateAll();
            return;
        }

        if ( hasArg("all") )
        {
            generateAll();
            return;
        }

        if ( hasArg("models") )
            generateModels();

        if ( hasArg("pages") )
            generatePages();

        if ( hasArg("properties") )
            generateProperties();

        if ( hasArg("css") )
            generateCss();
    }

    public void generateAll()
    {
        generateModels();
        generateProperties();
        generatePages();
        generateCss();

        KmgGenerator.printCounts();
    }

    private void generateModels()
    {
        installModels();
        generate("model");
        generate("db");
        generate("doc");
    }

    private void generateProperties()
    {
        installProperties();
        generate("property");
    }

    private void generatePages()
    {
        installModels();
        installPages();
        generate("page");
    }

    private void generateCss()
    {
        installCss();
        generate("css");
    }

    private void generate(String setupPath)
    {
        String templatePath = Kmu.joinFilePath(getGeneratorPath(), "templates");
        String setupDir = Kmu.joinFilePath(templatePath, setupPath);
        String setupFile = "_setup.stf";

        KmgGenerator g;
        g = new KmgGenerator();
        g.setRootPath(getRootPath());
        g.setSetupDir(setupDir);
        g.setSetupFile(setupFile);
        g.setRoot(getRoot());
        g.run();
    }

    //##################################################
    //# accessing
    //##################################################

    public void setArgs(String... args)
    {
        _args.clear();
        _args.addAll(args);
    }

    public KmList<String> getArgs()
    {
        return _args;
    }

    public boolean hasArg(String e)
    {
        return getArgs().contains(e);
    }

    //##################################################
    //# models
    //##################################################

    public KmgRoot getRoot()
    {
        if ( _root == null )
        {
            _root = new KmgRoot();
            _root.setApplicationName(MyConstantsIF.APPLICATION_NAME);
            _root.setApplicationPrefix(APPLICATION_PREFIX);
            _root.setApplicationPackage(APPLICATION_PACKAGE);
            _root.setDefaultDaoModelSuperClass("MyAbstractDaoDomain");
            _root.setDefaultValueModelSuperClass("MyAbstractValueDomain");
        }
        return _root;
    }

    //##################################################
    //# models
    //##################################################

    public void installModels()
    {
        if ( _installedModels )
            return;

        String typesPath = getConfigPath("types.stf");
        String modelsDir = getConfigPath("model");

        KmgRoot e;
        e = getRoot();
        e.installTypes(typesPath);
        e.installModels(modelsDir);
        e.installExtensions();
        e.validateModels();

        _installedModels = true;
    }

    //##################################################
    //# css
    //##################################################

    public void installCss()
    {
        if ( _installedCss )
            return;

        String themePath = "web/static/version/app/theme/default/css/theme.css";

        KmgRoot root;
        root = getRoot();

        KmgCssBundle e;
        e = root.addCssBundle("default");
        addSelectorsTo(e, themePath);

        _installedCss = true;
    }

    private void addSelectorsTo(KmgCssBundle bundle, String path)
    {
        System.out.println("parse style sheet: " + path);

        path = getRootPath(path);

        KmCssParser parser;
        parser = new KmCssParser();
        parser.parseFile(path);

        bundle.addIdSelectors(parser.getIdSelectors());
        bundle.addCssSelectors(parser.getCssSelectors());
        bundle.installCssComposites();
    }

    //##################################################
    //# properties
    //##################################################

    public void installProperties()
    {
        if ( _installedProperties )
            return;

        String path = getConfigPath("properties.stf");
        getRoot().installProperties(path);

        _installedProperties = true;
    }

    //##################################################
    //# install pages
    //##################################################

    private void installPages()
    {
        if ( _installedPages )
            return;

        String pkg = APPLICATION_PACKAGE;
        String pkgPrefix = Kmu.replaceAll(pkg, DOT, SLASH);
        String pkgSuffix = "ui";

        String path;
        path = MyDevelopmentFiles.getJavaSourcePath(pkgPrefix, pkgSuffix);

        getPageTraverser().processAll(path);

        KmgRoot root;
        root = getRoot();
        root.getPageClassNames().sort();
        root.getPagePackageNames().sort();

        _installedPages = true;
    }

    private KmFileTraverser getPageTraverser()
    {
        return new KmFileTraverser()
        {
            @Override
            public void processFile(KmFile f)
            {
                if ( isValid(f) )
                    addPage(f);
            }

            public boolean isValid(KmFile f)
            {
                if ( f.getName().contains("Abstract") )
                    return false;

                if ( f.hasSuffix("Page.java") )
                    return true;

                return false;
            }
        };
    }

    private void addPage(KmFile f)
    {
        KmJavaParser jp;
        jp = new KmJavaParser();
        jp.setSourceFile(f);

        if ( jp.isAbstract() )
            return;

        String name;
        name = f.getName();
        name = Kmu.removeSuffix(name, ".java");

        String pkg;
        pkg = f.getParent().getRealPath();
        pkg = Kmu.replaceAll(pkg, SLASH, DOT);
        pkg = Kmu.replaceAll(pkg, BACKSLASH, DOT);

        String x = ".java.source.";
        int i = pkg.indexOf(x);
        pkg = pkg.substring(i + x.length());

        KmgRoot root;
        root = getRoot();
        root.getPageClassNames().add(name);
        root.getPagePackageNames().addDistinct(pkg);
    }

    //##################################################
    //# support
    //##################################################

    private String getRootPath()
    {
        return MyDevelopmentFiles.getProjectRoot();
    }

    private String getRootPath(String... path)
    {
        return join(getRootPath(), join(path));
    }

    private String getGeneratorPath()
    {
        return join(getRootPath(), "web/WEB-INF/resource/generator");
    }

    private String getConfigPath(String... args)
    {
        return join(getGeneratorPath(), "config", join(args));
    }

    private String join(String... path)
    {
        return Kmu.joinFilePath(path);
    }
}
