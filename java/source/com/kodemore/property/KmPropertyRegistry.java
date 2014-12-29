package com.kodemore.property;

import java.util.Collection;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.file.KmFile;
import com.kodemore.utility.KmPropertyFileReader;
import com.kodemore.utility.Kmu;

/**
 * I provide the lookup mechanism for a tiered property structure.
 * Where the property is responsible for the defining the structure
 * and type of a property value, the registry is responsible for
 * defining the actual value.
 *
 * In most cases, multiple property registries are chained together
 * to provide more flexibility.  For example, the root is usually
 * a registry that contains the default values from the property
 * definitions.  The next registry provides a default layer that
 * is ready from a file system; this provides a layer where values
 * pertaining to database connection strings can be configured.
 * The next layer may read additional configuration values from
 * a global database schema.  And additional layers may provide
 * for property overrides on a per account, or per user basis.
 *
 * A property override will often be specified when creating a
 * registry hierarchy.  The override is used during development
 * to override a given value at all level of the hierarchy.  For
 * example, suppose the developer has a copy of the production system
 * and there are 100's of user and account registries with various
 * property settings.  The override mechanism allows the developer
 * to force various property settings across the entire property
 * hierarchy for debugging.
 */
public class KmPropertyRegistry
{
    //##################################################
    //# variables
    //##################################################

    private KmPropertyRegistry   _overrides;
    private KmMap<String,String> _values;
    private KmPropertyRegistry   _parent;

    //##################################################
    //# constructor
    //##################################################

    public KmPropertyRegistry()
    {
        _overrides = null;
        _values = new KmMap<>();
        _parent = null;
    }

    //##################################################
    //# accessing
    //##################################################

    public KmMap<String,String> getValues()
    {
        return _values;
    }

    public void setValues(KmMap<String,String> e)
    {
        _values = e;
    }

    public void clearValues()
    {
        _values.clear();
    }

    public KmPropertyRegistry getParent()
    {
        return _parent;
    }

    public void setParent(KmPropertyRegistry e)
    {
        _parent = e;
    }

    public boolean hasParent()
    {
        return _parent != null;
    }

    public KmPropertyRegistry getOverrides()
    {
        return _overrides;
    }

    public void setOverrides(KmPropertyRegistry e)
    {
        _overrides = e;
    }

    public boolean hasOverrides()
    {
        return _overrides != null;
    }

    //##################################################
    //# private
    //##################################################

    /**
     * If the raw value is needed, clients should get it from the property
     * rather than the registry since otherwise, the default value will not
     * be included.
     */
    public String _getRawValue(String key)
    {
        if ( _overrides != null )
            if ( _overrides._hasRawValue(key) )
                return _overrides._getRawValue(key);

        if ( _values.containsKey(key) )
            return _values.get(key);

        if ( _parent != null )
            return _parent._getRawValue(key);

        return null;
    }

    public boolean _hasRawValue(String key)
    {
        if ( _overrides != null )
            if ( _overrides._hasRawValue(key) )
                return true;

        if ( _values.containsKey(key) )
            return true;

        if ( _parent != null )
            if ( _parent._hasRawValue(key) )
                return true;

        return false;
    }

    //##################################################
    //# load
    //##################################################

    public void loadFile(KmFile file)
    {
        if ( file == null )
            fatal("Cannot load properties.  File is NULL.");

        if ( !file.exists() || !file.isFile() )
            fatal("Cannot load properties.  File does not exist: %s.", file);

        KmPropertyFileReader r;
        r = new KmPropertyFileReader();
        r.setCommentPrefixes("#", "//");

        KmMap<String,String> m = r.readFile(file);
        setValues(m);
    }

    public void loadDefaults(KmList<? extends KmPropertyDefinition> v)
    {
        KmMap<String,String> map = new KmMap<>();

        for ( KmPropertyDefinition e : v )
            map.put(e.getKey(), e.getDefaultValue());

        setValues(map);
    }

    public KmList<String> getUnknownKeys(Collection<String> knownKeys)
    {
        KmList<String> keys = new KmList<>();

        for ( String e : getAllKeys() )
            if ( !knownKeys.contains(e) )
                keys.add(e);

        keys.sort();
        return keys;
    }

    //##################################################
    //# support
    //##################################################

    private KmList<String> getAllKeys()
    {
        KmList<String> v = _values.getKeys();

        if ( hasParent() )
            v.addAllDistinct(getParent().getAllKeys());

        if ( hasOverrides() )
            v.addAllDistinct(getOverrides().getAllKeys());

        return v;
    }

    private void fatal(String msg, Object... args)
    {
        Kmu.fatal(msg, args);
    }

    //##################################################
    //# print
    //##################################################

    public void dumpAll()
    {
        KmList<String> keys;
        keys = getAllKeys();
        keys.sort();

        int max = Kmu.getMaximumLength(keys);

        for ( String key : keys )
            System.out.printf("%s = %s\n", Kmu.rightPad(key, max), _getRawValue(key));
    }
}
