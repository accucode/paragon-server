package com.kodemore.generator;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.file.KmFile;
import com.kodemore.file.KmFileTraverser;
import com.kodemore.generator.extend.KmgEnumNameFieldExtender;
import com.kodemore.generator.extend.KmgFieldExtender;
import com.kodemore.generator.extend.KmgUtcTsFieldExtender;
import com.kodemore.generator.model.KmgCssBundle;
import com.kodemore.generator.model.KmgModel;
import com.kodemore.generator.model.KmgModelAssociation;
import com.kodemore.generator.model.KmgModelAttribute;
import com.kodemore.generator.model.KmgModelEnum;
import com.kodemore.generator.model.KmgModelField;
import com.kodemore.generator.model.KmgModelFieldType;
import com.kodemore.generator.property.KmgPropertyFile;
import com.kodemore.proto.KmProtoType;
import com.kodemore.proto.KmProtoTypes;
import com.kodemore.stf.KmStfElement;
import com.kodemore.stf.KmStfParser;
import com.kodemore.stf.KmStfRoot;
import com.kodemore.stf.KmStfShortcut;
import com.kodemore.utility.Kmu;

public class KmgRoot
    extends KmgElement
{
    //##################################################
    //# variables
    //##################################################

    private KmMap<String,KmProtoType> _baseTypes;
    private KmList<KmgModelFieldType> _types;
    private KmList<KmgModel>          _models;
    private KmgPropertyFile           _propertyFile;

    private KmList<String> _pageClassNames;
    private KmList<String> _pagePackageNames;

    private String _applicationName;
    private String _applicationPackage;
    private String _applicationPrefix;

    private String _defaultDaoModelSuperClass;
    private String _defaultValueModelSuperClass;

    private KmList<KmgFieldExtender> _extenders;

    private KmList<KmgCssBundle> _cssBundles;

    //##################################################
    //# constructor
    //##################################################

    public KmgRoot()
    {
        super(null);
        _baseTypes = KmProtoTypes.getAll();
        _types = new KmList<>();
        _models = new KmList<>();
        _pageClassNames = new KmList<>();
        _pagePackageNames = new KmList<>();
        _extenders = getDefaultExtenders();
        _cssBundles = new KmList<>();
    }

    //##################################################
    //# accessing
    //##################################################

    public String getApplicationName()
    {
        return _applicationName;
    }

    public void setApplicationName(String e)
    {
        _applicationName = e;
    }

    public String getApplicationPackage()
    {
        return _applicationPackage;
    }

    public void setApplicationPackage(String e)
    {
        _applicationPackage = e;
    }

    public String getApplicationPackagePath()
    {
        return Kmu.replaceAll(getApplicationPackage(), ".", "/");
    }

    public String getApplicationPrefix()
    {
        return _applicationPrefix;
    }

    public void setApplicationPrefix(String e)
    {
        _applicationPrefix = e;
    }

    public KmMap<String,KmProtoType> getBaseTypes()
    {
        return _baseTypes;
    }

    public KmProtoType getBaseType(String name)
    {
        return getBaseTypes().get(name);
    }

    public KmList<KmgModelFieldType> getTypes()
    {
        return _types;
    }

    public KmList<String> getTypeNames()
    {
        KmList<String> v = new KmList<>();
        for ( KmgModelFieldType e : getTypes() )
            v.add(e.getName());
        return v;
    }

    public KmList<KmgModel> getModels()
    {
        return _models;
    }

    public KmList<KmgModel> getDatabaseModels()
    {
        KmList<KmgModel> v = new KmList<>();
        for ( KmgModel e : getModels() )
            if ( e.hasDatabase() )
                v.add(e);
        return v;
    }

    public KmList<KmgModel> getModelBases()
    {
        KmList<KmgModel> v = new KmList<>();
        for ( KmgModel e : getModels() )
            if ( !e.getSkipModelBase() )
                v.add(e);
        return v;
    }

    public KmList<KmgModel> getPrimaryKeyModels()
    {
        KmList<KmgModel> v = new KmList<>();
        for ( KmgModel e : getModels() )
            if ( e.hasPrimaryKey() )
                v.add(e);
        return v;
    }

    public KmList<KmgModelAttribute> getMetaFieldsAndDelegates()
    {
        KmList<KmgModelAttribute> v;
        v = new KmList<>();
        for ( KmgModel e : getModels() )
            v.addAll(e.getMetaFieldsAndDelegates());
        return v;
    }

    public KmList<KmgModelAssociation> getMetaAssociations()
    {
        KmList<KmgModelAssociation> v;
        v = new KmList<>();
        for ( KmgModel e : getModels() )
            v.addAll(e.getMetaAssociations());
        return v;
    }

    public KmList<KmgModel> getNonDatabaseModels()
    {
        KmList<KmgModel> v = new KmList<>();
        for ( KmgModel e : getModels() )
            if ( !e.hasDatabase() )
                v.add(e);
        return v;
    }

    public KmList<KmgModelEnum> getEnums()
    {
        KmMap<String,KmgModelEnum> v = new KmMap<>();

        for ( KmgModel m : getModels() )
            for ( KmgModelField f : m.getFields() )
                if ( f.hasEnum() )
                {
                    KmgModelEnum e = f.getEnum();
                    v.put(e.getType(), e);
                }
        return v.getValues();
    }

    public KmList<String> getModelNames()
    {
        KmList<String> v = new KmList<>();
        for ( KmgModel e : getModels() )
            v.add(e.getName());
        return v;
    }

    public KmgPropertyFile getPropertyFile()
    {
        return _propertyFile;
    }

    public String getDefaultDaoModelSuperClass()
    {
        return _defaultDaoModelSuperClass;
    }

    public void setDefaultDaoModelSuperClass(String e)
    {
        _defaultDaoModelSuperClass = e;
    }

    public String getDefaultValueModelSuperClass()
    {
        return _defaultValueModelSuperClass;
    }

    public void setDefaultValueModelSuperClass(String e)
    {
        _defaultValueModelSuperClass = e;
    }

    public KmList<String> getPageClassNames()
    {
        return _pageClassNames;
    }

    public KmList<String> getPagePackageNames()
    {
        return _pagePackageNames;
    }

    public KmList<KmgCssBundle> getCssBundles()
    {
        return _cssBundles;
    }

    public KmgCssBundle addCssBundle(String name)
    {
        KmgCssBundle e;
        e = new KmgCssBundle();
        e.setName(name);

        _cssBundles.add(e);

        return e;
    }

    //##################################################
    //# extenders
    //##################################################

    public KmList<KmgFieldExtender> getExtenders()
    {
        return _extenders;
    }

    public void addExtender(KmgFieldExtender e)
    {
        _extenders.add(e);
    }

    public void clearExtenders()
    {
        _extenders.clear();
    }

    private KmList<KmgFieldExtender> getDefaultExtenders()
    {
        KmList<KmgFieldExtender> v;
        v = new KmList<>();
        v.add(new KmgEnumNameFieldExtender());
        v.add(new KmgUtcTsFieldExtender());
        return v;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    @Override
    public KmgRoot getRoot()
    {
        return this;
    }

    public KmgModelFieldType getType(String name)
    {
        for ( KmgModelFieldType e : getTypes() )
            if ( e.hasName(name) )
                return e;

        return null;
    }

    public KmgModel getModel(String name)
    {
        for ( KmgModel e : getModels() )
            if ( e.hasName(name) )
                return e;

        return null;
    }

    public KmgModelField getField(String modelName, String fieldName)
    {
        return getModel(modelName).getField(fieldName);
    }

    //##################################################
    //# install
    //##################################################

    public void installTypes(String path)
    {
        KmStfParser parser;
        parser = new KmStfParser();
        parser.parseFile(path);

        KmStfElement root;
        root = parser.getRoot();

        for ( KmStfElement c : root.getChildren() )
        {
            KmgModelFieldType e;
            e = new KmgModelFieldType(this);
            e.parse(c);

            _types.add(e);
        }

        _types.sortOn(KmgModelFieldType.getNameComparator());

        _validate(_types);
        checkDuplicates("type.name", getTypeNames());
    }

    public void installProperties(String path)
    {
        KmgPropertyFile e;
        e = new KmgPropertyFile(this);
        e.parseFile(path);
        e.validate();
        _propertyFile = e;
    }

    //##################################################
    //# install models
    //##################################################

    public void installModels(String dir)
    {
        System.out.println("Installing models...");
        KmFileTraverser files = new KmFileTraverser()
        {
            @Override
            protected void processFile(KmFile f)
            {
                if ( f.hasExtension("stf") )
                    installModel(f);
            }
        };
        files.processAll(dir);
        _models.sortOn(e -> e.getName());
    }

    public void validateModels()
    {
        _validate(_models);
        checkDuplicates("model.name", getModelNames());
        _postValidate(_models);
    }

    private void installModel(KmFile f)
    {
        System.out.println("    " + f.getName());

        KmStfRoot root;
        root = parseModel(f);

        KmgModel e;
        e = new KmgModel(this);
        e.parse(root);

        if ( !f.hasShortName(e.getName()) )
            throw newError(
                "Model name (%s) should match file name (%s).",
                e.getName(),
                f.getName());

        _models.add(e);
    }

    private KmStfRoot parseModel(KmFile f)
    {
        String s;
        s = f.readString();

        KmStfParser p;
        p = new KmStfParser();
        p.setIncludeFolder(f.getParent().getSibling("include"));
        installEnumShortcuts(p);
        p.parseSource(s);

        return p.getRoot();
    }

    private void installEnumShortcuts(KmStfParser p)
    {
        KmStfShortcut sc;
        sc = p.addShortcut();
        sc.setElementPath("**/enum/value");
        sc.setArgumentPrefix("#");
        sc.setAttributeKey("code");

        sc = p.addShortcut();
        sc.setElementPath("**/enum/value");
        sc.setAttributeKey("label");
    }

    public void installExtensions()
    {
        for ( KmgFieldExtender e : getExtenders() )
            e.extendAll(this);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return "root";
    }

    //##################################################
    //# support
    //##################################################

    public String format_ApplicationPrefix()
    {
        return Kmu.toCamelCase(getApplicationPrefix());
    }

    //##################################################
    //# parse
    //##################################################

    @Override
    public void parse(KmStfElement e)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void validate()
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void postValidate()
    {
        throw new UnsupportedOperationException();
    }

}
