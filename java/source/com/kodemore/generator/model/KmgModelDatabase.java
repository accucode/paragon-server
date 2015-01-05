package com.kodemore.generator.model;

import com.kodemore.collection.KmList;
import com.kodemore.generator.KmgElement;
import com.kodemore.stf.KmStfElement;
import com.kodemore.utility.Kmu;

public class KmgModelDatabase
    extends KmgElement
{
    //##################################################
    //# variables
    //##################################################

    private String                _alias;
    private String                _engine;
    private boolean               _cache;
    private boolean               _pages;
    private KmList<KmgModelIndex> _indexes;
    private boolean               _lockVersion;

    //##################################################
    //# constructor
    //##################################################

    public KmgModelDatabase(KmgElement parent)
    {
        super(parent);
    }

    //##################################################
    //# parse
    //##################################################

    @Override
    public void parse(KmStfElement x)
    {
        checkAttributeKeys(x, "alias", "engine", "pages", "locking");
        checkChildrenNames(x, "index");

        _alias = parseRequiredString(x, "alias");
        _engine = parseString(x, "engine", "innodb");
        _pages = parseBoolean(x, "pages");
        _lockVersion = parseBoolean(x, "locking", true);

        parseIndexes(x);
    }

    private void parseIndexes(KmStfElement x)
    {
        _indexes = new KmList<>();

        for ( KmStfElement xi : x.getChildren("index") )
        {
            KmgModelIndex i;
            i = new KmgModelIndex(this);
            i.parse(xi);
            _indexes.add(i);
        }
    }

    @Override
    public void validate()
    {
        String engine = getEngine();
        KmList<String> engines = KmList.createWith("innodb", "myisam");

        if ( !engines.contains(engine) )
            throw newFatal("Not a valid engine (%s).", engine);

        _validate(getIndexes());
    }

    @Override
    public void postValidate()
    {
        _postValidate(getIndexes());
    }

    public boolean getLockVersion()
    {
        return _lockVersion;
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return "model database";
    }

    //##################################################
    //# accessing
    //##################################################

    public String getAlias()
    {
        return _alias;
    }

    public void setAlias(String alias)
    {
        _alias = alias;
    }

    public boolean hasAlias(String s)
    {
        return Kmu.isEqual(_alias, s);
    }

    public String getEngine()
    {
        return _engine;
    }

    public Boolean isCached()
    {
        return _cache;
    }

    public void setCache(Boolean e)
    {
        _cache = e;
    }

    public boolean getPages()
    {
        return _pages;
    }

    public KmList<KmgModelIndex> getIndexes()
    {
        return _indexes;
    }

    //##################################################
    //# context
    //##################################################

    public String getf_alias()
    {
        return _alias;
    }

    public String getf_table()
    {
        return getModel().getName();
    }

    public String getf_engine()
    {
        return _engine.toUpperCase();
    }

}
