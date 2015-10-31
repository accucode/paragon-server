package com.kodemore.generator.model;

import com.kodemore.collection.KmList;
import com.kodemore.generator.KmgElement;
import com.kodemore.stf.KmStfElement;

public class KmgModelDatabase
    extends KmgElement
{
    //##################################################
    //# variables
    //##################################################

    private String                _engine;
    private KmList<KmgModelIndex> _indexes;
    private boolean               _lockVersion;
    private boolean               _auditLog;

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
        checkAttributeKeys(x, "engine", "locking", "auditLog");
        checkChildrenNames(x, "index");

        _engine = parseString(x, "engine", "innodb");
        _lockVersion = parseRequiredBoolean(x, "locking");
        _auditLog = parseRequiredBoolean(x, "auditLog");

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

    public boolean getAuditLog()
    {
        return _auditLog;
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

    public String getEngine()
    {
        return _engine;
    }

    public KmList<KmgModelIndex> getIndexes()
    {
        return _indexes;
    }

    //##################################################
    //# context
    //##################################################

    public String getf_table()
    {
        return getModel().getName();
    }

    public String getf_engine()
    {
        return _engine.toUpperCase();
    }

}
